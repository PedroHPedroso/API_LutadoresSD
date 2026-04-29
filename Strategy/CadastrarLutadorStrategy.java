package API_UenpBet.Strategy;

import API_UenpBet.Singleton.DatabaseConnection;
import API_UenpBet.model.Lutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarLutadorStrategy implements LutadorStrategy {

    @Override
    public void executar(Lutador lutador) {
        String sql = """
                INSERT INTO lutadores (nome, categoria, apelido, arte)
                VALUES (?, ?, ?, ?)
                """;

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lutador.getNome());
            stmt.setString(2, lutador.getCategoria());
            stmt.setString(3, lutador.getApelido());
            stmt.setString(4, lutador.getArte());

            stmt.executeUpdate();

            System.out.println("Lutador cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar lutador: " + e.getMessage());
        }
    }
}