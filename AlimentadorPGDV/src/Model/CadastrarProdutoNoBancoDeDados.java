package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarProdutoNoBancoDeDados {

    private ConexaoComBancoDeDados objetoDaClasseConexaoComBancoDeDados = new ConexaoComBancoDeDados();
    private String comandoSQL;
    private PreparedStatement statementParaCadastrarProdutosNoBancoDeDados;

    public boolean cadastrarProduto(String codigoDoProduto, String nomeDoProduto, String fabricanteDoProduto) {
        try {
            comandoSQL = "INSERT INTO produtos(cod_produto,nome_produto,fabricante_produto) VALUES(?,?,?)";
            objetoDaClasseConexaoComBancoDeDados.abrirConexao();
            statementParaCadastrarProdutosNoBancoDeDados = objetoDaClasseConexaoComBancoDeDados.objetoDaClasseConnection.prepareStatement(comandoSQL);
            statementParaCadastrarProdutosNoBancoDeDados.setString(1, codigoDoProduto);
            statementParaCadastrarProdutosNoBancoDeDados.setString(2, nomeDoProduto);
            statementParaCadastrarProdutosNoBancoDeDados.setString(3, fabricanteDoProduto);
            if (!statementParaCadastrarProdutosNoBancoDeDados.execute()) {
                System.out.println("Produto cadastrado!");
                return true;
            } else {
                System.out.println("Produto NÃO cadastrado!");
                return false;
            }
        } catch (SQLException erroAoCadastrarProduto) {
            System.err.println("Problema ao tentar cadastrar produto, ERRO: " + erroAoCadastrarProduto);
            return false;
        }
    }
}
