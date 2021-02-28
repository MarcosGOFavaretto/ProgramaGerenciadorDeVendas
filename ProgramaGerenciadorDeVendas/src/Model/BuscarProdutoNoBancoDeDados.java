package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarProdutoNoBancoDeDados {

    private ConexaoComBancoDeDados objetoDaClasseConexaoComBancoDeDados = new ConexaoComBancoDeDados();
    private String comandoSQL = null;
    private ResultSet resultadoDaBuscaPeloProdutoNoBancoDeDados = null;
    private PreparedStatement statementParaBuscaNoBancoDeDados = null;

    public ResultSet buscarProdutoNoBancoDeDados(String codigoDoProduto) {
        try {
            comandoSQL = "SELECT * FROM produtos WHERE cod_produto=?";
            objetoDaClasseConexaoComBancoDeDados.abrirConexao();
            statementParaBuscaNoBancoDeDados = objetoDaClasseConexaoComBancoDeDados.objetoDaClasseConnection.prepareStatement(comandoSQL);
            statementParaBuscaNoBancoDeDados.setString(1, codigoDoProduto);
            resultadoDaBuscaPeloProdutoNoBancoDeDados = statementParaBuscaNoBancoDeDados.executeQuery();
        } catch (SQLException erroAoTentarBuscarProdutos) {
            System.err.println("Problema ao tentar buscar o produto no banco de dados, ERRO: " + erroAoTentarBuscarProdutos);
        }
        return resultadoDaBuscaPeloProdutoNoBancoDeDados;
    }
}
