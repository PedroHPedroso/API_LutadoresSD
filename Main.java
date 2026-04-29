package API_UenpBet;

import API_UenpBet.Factory.LutadorStrategyFactory;
import API_UenpBet.model.Lutador;
import API_UenpBet.Strategy.LutadorStrategy;

public class Main {

    public static void main(String[] args) {

        Lutador lutador = new Lutador(
                0,
                "Joao da Silva",
                "medio",
                "Miranha",
                "Muay Thai"
        );

        LutadorStrategy cadastrar = LutadorStrategyFactory.criarStrategy("cadastrar");
        cadastrar.executar(lutador);

        LutadorStrategy listar = LutadorStrategyFactory.criarStrategy("listar");
        listar.executar(null);

        Lutador buscarPorId = new Lutador();
        buscarPorId.setId(1);

        LutadorStrategy buscar = LutadorStrategyFactory.criarStrategy("buscar");
        buscar.executar(buscarPorId);
    }
}