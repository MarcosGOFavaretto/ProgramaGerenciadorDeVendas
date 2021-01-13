package Controller;

import Model.BuscarProduto;
import java.sql.ResultSet;

public class ProdutosClass {

    private String nomeProduto;
    private String fabricanteProduto;
    private float quantidadeProduto;
    BuscarProduto objeto_buscarproduto = new BuscarProduto();

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public float getQuantidadeProduto() {
        return quantidadeProduto;
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

    public void buscarProduto(String codigoProduto) {
        // Código do método que iniciará a busca no banco de dados.
        ResultSet resultset_buscarproduto = objeto_buscarproduto.BuscarProduto(codigoProduto);
        inserirProduto(resultset_buscarproduto);
    }
    
    public void inserirProduto(ResultSet resultset_buscarproduto){
        // Código do método que adicionará uma nova linha à tabela.
    }
}