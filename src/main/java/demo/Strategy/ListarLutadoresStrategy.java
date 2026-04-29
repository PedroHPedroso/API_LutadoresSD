package demo.Strategy;

import demo.Singleton.DatabaseConnection;
import demo.model.Lutador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarLutadoresStrategy implements LutadorStrategy {

    @Override
    public void executar(Lutador lutador) {
        String sql = "SELECT * FROM lutadores";

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Lutador l = new Lutador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getString("apelido"),
                        rs.getString("arte")
                );

                System.out.println(l);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar lutadores: " + e.getMessage());
        }
    }
}