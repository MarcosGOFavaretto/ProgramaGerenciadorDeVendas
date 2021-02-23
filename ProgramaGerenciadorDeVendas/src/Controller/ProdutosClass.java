package Controller;

import Model.BuscarProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosClass {

    // DECLARANDO AS VARIÁVEIS GLOBAIS DA CLASSE:
    private String codigoProduto;
    private String nomeProduto;
    private String fabricanteProduto;
    private float quantidadeProduto;
    BuscarProduto objeto_buscarproduto = new BuscarProduto();
    private ResultSet resultset_buscarproduto;
    public ArrayList<String> listaDeProdutos = new ArrayList();

    // CRIANDO OS MÉTODOS "GETTERS":
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public float getQuantidadeProduto() {
        return quantidadeProduto;
    }

    // CRIANDO OS MÉTODOS "SETTERS":
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) {
        this.fabricanteProduto = fabricanteProduto;
    }

    public void setQuantidadeProduto(float quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    // CRIANDO MÉTODO QUE IRÁ INICIAR A BUSCA NO BANCO DE DADOS:
    public void buscarProdutoNoBanco() throws SQLException {
        resultset_buscarproduto = null;
        resultset_buscarproduto = objeto_buscarproduto.buscarProduto(getCodigoProduto());
        if (listaDeProdutos.contains(resultset_buscarproduto.getString("nome_produto"))) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).equals(resultset_buscarproduto.getString("nome_produto"))) {
                    i = i + 2;
                    int valorDaQuantidade = Integer.parseInt(listaDeProdutos.get(i)) + 1;
                    listaDeProdutos.set(i, String.valueOf(valorDaQuantidade));
                }
            }
        } else {
            listaDeProdutos.add(resultset_buscarproduto.getString("nome_produto"));
            listaDeProdutos.add(resultset_buscarproduto.getString("fabricante_produto"));
            listaDeProdutos.add("1");
        }
    }
}
