package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBancoDeDados {

    public static Connection objetoDaClasseConnection;
    private final String urlDaConexao = "jdbc:sqlite:/";
    private final String caminhoDoProjeto = "C:\\PGDV\\bancodedados";
    private final String arquivoDoBancoDeDados = "/bancodedados.db";

    public boolean abrirConexao() {
        try {
            if (objetoDaClasseConnection == null) {
                Class.forName("org.sqlite.JDBC");
                objetoDaClasseConnection = DriverManager.getConnection(urlDaConexao + caminhoDoProjeto + arquivoDoBancoDeDados);
            }
            return true;
        } catch (ClassNotFoundException | SQLException erroAoTentarAbrirConexao) {
            System.err.println("Problema ao tentar abrir a conexao com o banco de dados, ERRO: " + erroAoTentarAbrirConexao);
            return false;
        }
    }

    public boolean fecharConexao() {
        try {
            if (objetoDaClasseConnection != null) {
                this.objetoDaClasseConnection.close();
                objetoDaClasseConnection.clearWarnings();
                return true;
            } else {
                return false;
            }
        } catch (SQLException erroAoTentarFecharConexao) {
            System.err.println("Problema ao tentar fechar a conexão com o banco de dados, ERRO: " + erroAoTentarFecharConexao);
            return false;
        }
    }
}
