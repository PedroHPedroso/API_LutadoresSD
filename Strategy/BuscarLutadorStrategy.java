package API_UenpBet.Strategy;

import API_UenpBet.Singleton.*;
import API_UenpBet.model.Lutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarLutadorStrategy implements LutadorStrategy {

    @Override
    public void executar(Lutador lutador) {
        String sql = "SELECT * FROM lutadores WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, lutador.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Lutador encontrado = new Lutador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getString("apelido"),
                        rs.getString("arte")
                );

                System.out.println(encontrado);
            } else {
                System.out.println("Lutador não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar lutador: " + e.getMessage());
        }
    }
}