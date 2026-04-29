package demo.Strategy;

import demo.Singleton.DatabaseConnection;
import demo.model.Lutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarLutadorStrategy implements LutadorStrategy {

    @Override
    public void executar(Lutador lutador) {
        String sql = "DELETE FROM lutadores WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, lutador.getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Lutador deletado com sucesso!");
            } else {
                System.out.println("Lutador não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar lutador: " + e.getMessage());
        }
    }
}