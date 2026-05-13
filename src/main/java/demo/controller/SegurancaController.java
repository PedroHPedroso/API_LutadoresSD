package demo.controller;

import demo.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seguranca")
public class SegurancaController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/chave-publica")
    public String obterChavePublica() {
        return cryptoService.getChavePublicaBase64();
    }
}