package demo.Strategy;

import demo.Singleton.DatabaseConnection;
import demo.model.Lutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarLutadorStrategy implements LutadorStrategy {

    @Override
    public void executar(Lutador lutador) {
        String sql = """
                UPDATE lutadores
                SET nome = ?, categoria = ?, apelido = ?, arte = ?
                WHERE id = ?
                """;

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lutador.getNome());
            stmt.setString(2, lutador.getCategoria());
            stmt.setString(3, lutador.getApelido());
            stmt.setString(4, lutador.getArte());
            stmt.setInt(5, lutador.getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Lutador atualizado com sucesso!");
            } else {
                System.out.println("Lutador não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar lutador: " + e.getMessage());
        }
    }
}