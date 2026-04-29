package demo.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlite:lutadores.db";

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL);
            criarTabela();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco SQLite", e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private void criarTabela() {
        String sql = """
                CREATE TABLE IF NOT EXISTS lutadores (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    categoria TEXT NOT NULL,
                    apelido TEXT NOT NULL,
                    arte TEXT NOT NULL
                );
                """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela de lutadores", e);
        }
    }
}