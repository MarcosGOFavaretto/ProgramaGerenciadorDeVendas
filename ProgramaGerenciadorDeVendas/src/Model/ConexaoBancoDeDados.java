package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public static Connection conexao;
    private final String url = "jdbc:sqlite:/";
    private final String projeto = "D:\\Users\\T-Gamer\\ProgramaGerenciadorDeVendas\\ProgramaGerenciadorDeVendas\\bancodedados";
    private final String arquivoBancoDeDados = "/bancodedados.db";

    public boolean AbrirConexao() {
        try {
            if (conexao == null) {
                System.out.println("CONEXÃO: Não instanciada!");
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection(url + projeto + arquivoBancoDeDados);
            } else {
                System.out.println("CONEXÃO: Realizada!");
            }
            return true;
        } catch (ClassNotFoundException | SQLException erro_AbrirConexao) {
            System.err.println("Problema ao tentar abrir a conexao com o banco de dados, ERRO: " + erro_AbrirConexao);
            return false;
        }
    }

    public boolean FecharConexao() {
        try {
            if (conexao != null) {
                this.conexao.close();
                conexao.clearWarnings();
                System.out.println("CONEXÃO = Fechada");
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro_FecharConexao) {
            System.err.println("Problema ao tentar fechar a conexão com o banco de dados, ERRO: " + erro_FecharConexao);
            return false;
        }
    }
}
