
package demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Service
public class CryptoService {

    // Terás de carregar esta chave privada de forma segura (ex: variáveis de ambiente)
    private PrivateKey chavePrivada;
    private PublicKey chavePublica;

    // Este método corre automaticamente quando o Spring Boot arranca
    @PostConstruct
    public void gerarChavesRSA() {
        try {
            KeyPairGenerator gerador = KeyPairGenerator.getInstance("RSA");
            gerador.initialize(2048); // Tamanho seguro
            KeyPair par = gerador.generateKeyPair();
            this.chavePrivada = par.getPrivate();
            this.chavePublica = par.getPublic();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar chaves RSA", e);
        }
    }

    // Método para entregar a chave pública ao cliente
    public String getChavePublicaBase64() {
        return Base64.getEncoder().encodeToString(this.chavePublica.getEncoded());
    }
    public String desencriptarPayload(String chaveSessaoBase64, String dadosBase64) throws Exception {

        // 1. Revelar a chave AES aleatória que veio do Javascript usando o teu RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.DECRYPT_MODE, this.chavePrivada);
        byte[] chaveAesBytesDecifrados = rsaCipher.doFinal(Base64.getDecoder().decode(chaveSessaoBase64));

        // Limpar espaços ou quebras de linha que possam ter vindo da rede
        String chaveAesString = new String(chaveAesBytesDecifrados, "UTF-8").trim();

        // GARANTIA: Cortar para 16 caracteres exatos, senão o AES vai dar erro!
        if (chaveAesString.length() > 16) {
            chaveAesString = chaveAesString.substring(0, 16);
        }

        // Imprime no log para mostrares ao professor que a desencriptação funcionou
        System.out.println("=== ENVELOPE ABERTO ===");
        System.out.println("Chave de Sessão interceptada: " + chaveAesString);

        // 2. Criar o objeto de chave AES com os 16 bytes limpos
        SecretKeySpec aesKey = new SecretKeySpec(chaveAesString.getBytes("UTF-8"), "AES");

        // 3. Desencriptar os dados do Lutador
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] jsonOriginalBytes = aesCipher.doFinal(Base64.getDecoder().decode(dadosBase64));

        return new String(jsonOriginalBytes, "UTF-8");
    }
}