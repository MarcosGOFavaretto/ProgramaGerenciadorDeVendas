package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalvarProdutoNaLista {

    private String sql_SalvarProdutoNaLista = null;
    private ConexaoBancoDeDados objeto_ConexaoBancoDeDados = new ConexaoBancoDeDados();
    private PreparedStatement statment_SalvarProdutoNaLista;

    public boolean salvarProdutoNaLista(String nomeProdutoCompra, String fabricanteProdutoCompra, String quantidade) throws SQLException {
        try {
            sql_SalvarProdutoNaLista = "INSERT INTO compra(nome_produto_compra, fabricante_produto_compra, quantidade) VALUES (?,?,?);";
            objeto_ConexaoBancoDeDados.abrirConexao();
            statment_SalvarProdutoNaLista = objeto_ConexaoBancoDeDados.conexao.prepareStatement(sql_SalvarProdutoNaLista);
            statment_SalvarProdutoNaLista.setString(1, nomeProdutoCompra);
            statment_SalvarProdutoNaLista.setString(2, fabricanteProdutoCompra);
            statment_SalvarProdutoNaLista.setString(3, quantidade);
            if (!statment_SalvarProdutoNaLista.execute()) {
                System.out.println("Arquivo adicionado na lista de compra!");
                return true;
            } else {
                System.out.println("Arquivo NÃO adicionado na lista de compra!");
                return false;
            }
        } catch (SQLException erro_SalvarProdutoNaLista) {
            System.err.println("Problema ao tentar adicionar o produto na lista de compra, ERRO: " + erro_SalvarProdutoNaLista);
            return false;
        }

    }
}
