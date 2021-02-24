package Controller;

import Model.BuscarProdutoNoBancoDeDados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosClass {

    private String codigoDoProduto;
    private String nomeDoProduto;
    private String fabricanteDoProduto;
    private float quantidadeDoProduto;
    private BuscarProdutoNoBancoDeDados objetoDaClasseBuscarProduto = new BuscarProdutoNoBancoDeDados();
    private ResultSet resultadoDaBuscaPeloProdutoNoBancoDeDados;
    public ArrayList<String> listaDeProdutosJaAdicionadosNaCompra = new ArrayList();

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public String getFabricanteDoProduto() {
        return fabricanteDoProduto;
    }

    public float getQuantidadeDoProduto() {
        return quantidadeDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setFabricanteDoProduto(String fabricanteDoProduto) {
        this.fabricanteDoProduto = fabricanteDoProduto;
    }

    public void setQuantidadeDoProduto(float quantidadeDoProduto) {
        this.quantidadeDoProduto = quantidadeDoProduto;
    }

    public void buscarProdutoNoBanco() throws SQLException {
        resultadoDaBuscaPeloProdutoNoBancoDeDados = null;
        resultadoDaBuscaPeloProdutoNoBancoDeDados = objetoDaClasseBuscarProduto.buscarProdutoNoBancoDeDados(getCodigoDoProduto());
        if (listaDeProdutosJaAdicionadosNaCompra.contains(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("nome_produto"))) {
            for (int i = 0; i < listaDeProdutosJaAdicionadosNaCompra.size(); i++) {
                if (listaDeProdutosJaAdicionadosNaCompra.get(i).equals(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("nome_produto"))) {
                    i = i + 2;
                    int valorDaQuantidade = Integer.parseInt(listaDeProdutosJaAdicionadosNaCompra.get(i)) + 1;
                    listaDeProdutosJaAdicionadosNaCompra.set(i, String.valueOf(valorDaQuantidade));
                }
            }
        } else {
            listaDeProdutosJaAdicionadosNaCompra.add(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("nome_produto"));
            listaDeProdutosJaAdicionadosNaCompra.add(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("fabricante_produto"));
            listaDeProdutosJaAdicionadosNaCompra.add("1");
        }
    }
}
