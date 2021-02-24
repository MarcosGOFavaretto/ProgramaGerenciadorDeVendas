package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBancoDeDados {

    public static Connection objetoDaClasseConnection;
    private final String urlDaConexao = "jdbc:sqlite:/";
    private final String caminhoDoProjeto = "D:\\Users\\T-Gamer\\ProgramaGerenciadorDeVendas\\ProgramaGerenciadorDeVendas\\bancodedados";
    private final String arquivoDoBancoDeDados = "/bancodedados.db";

    public boolean abrirConexao() {
        try {
            if (objetoDaClasseConnection == null) {
                System.out.println("CONEXÃO: Não instanciada!");
                Class.forName("org.sqlite.JDBC");
                objetoDaClasseConnection = DriverManager.getConnection(urlDaConexao + caminhoDoProjeto + arquivoDoBancoDeDados);
            } else {
                System.out.println("CONEXÃO: Realizada!");
            }
            return true;
        } catch (ClassNotFoundException | SQLException erro_AbrirConexao) {
            System.err.println("Problema ao tentar abrir a conexao com o banco de dados, ERRO: " + erro_AbrirConexao);
            return false;
        }
    }

    public boolean fecharConexao() {
        try {
            if (objetoDaClasseConnection != null) {
                this.objetoDaClasseConnection.close();
                objetoDaClasseConnection.clearWarnings();
                System.out.println("CONEXÃO = Fechada");
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro_fecharConexao) {
            System.err.println("Problema ao tentar fechar a conexão com o banco de dados, ERRO: " + erro_fecharConexao);
            return false;
        }
    }
}
