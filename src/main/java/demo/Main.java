package demo;

import demo.Factory.LutadorStrategyFactory;
import demo.model.Lutador;
import demo.Strategy.LutadorStrategy;

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