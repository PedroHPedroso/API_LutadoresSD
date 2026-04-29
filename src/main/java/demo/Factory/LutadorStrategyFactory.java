package demo.Factory;

import demo.Strategy.*;

public class LutadorStrategyFactory {

    public static LutadorStrategy criarStrategy(String acao) {

        return switch (acao.toLowerCase()) {
            case "cadastrar" -> new CadastrarLutadorStrategy();
            case "listar" -> new ListarLutadoresStrategy();
            case "buscar" -> new BuscarLutadorStrategy();
            case "atualizar" -> new AtualizarLutadorStrategy();
            case "deletar" -> new DeletarLutadorStrategy();

            default -> throw new IllegalArgumentException("Ação inválida: " + acao);
        };
    }
}