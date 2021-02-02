package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarProduto {

    // DECLARANDO AS VARIÁVEIS GLOBAIS DA CLASSE:
    private ConexaoBancoDeDados objeto_conexaobancodedados = new ConexaoBancoDeDados();
    private String sql_buscarproduto = null;
    private ResultSet resultset_buscarproduto = null;
    private PreparedStatement statement_buscarproduto = null;

    // CRIANDO MÉTODO QUE IRÁ REALIZAR A BUSCA NO BANCO DE DADOS:
    public ResultSet buscarProduto(int codigoProduto) {
        try {
            sql_buscarproduto = "SELECT * FROM produtos WHERE cod_produto=?";
            objeto_conexaobancodedados.abrirConexao();
            statement_buscarproduto = objeto_conexaobancodedados.conexao.prepareStatement(sql_buscarproduto);
            statement_buscarproduto.setInt(1, codigoProduto);
            resultset_buscarproduto = statement_buscarproduto.executeQuery();
        } catch (SQLException erro_buscarproduto) {
            System.err.println("Problema ao tentar buscar o produto no banco de dados, ERRO: " + erro_buscarproduto);
        }
        return resultset_buscarproduto;
    }
}
