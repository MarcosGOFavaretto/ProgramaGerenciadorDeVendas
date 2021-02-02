package Controller;

import Model.BuscarProduto;
import java.sql.ResultSet;

public class ProdutosClass {

    // DECLARANDO AS VARIÁVEIS GLOBAIS DA CLASSE:
    private String nomeProduto;
    private String fabricanteProduto;
    private float quantidadeProduto;
    BuscarProduto objeto_buscarproduto = new BuscarProduto();

    // CRIANDO OS MÉTODOS "GETTERS":
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
    public ResultSet buscarProdutoNoBanco(int codigoProduto) {
        ResultSet resultset_buscarproduto = null;
        resultset_buscarproduto = objeto_buscarproduto.buscarProduto(codigoProduto);
        return resultset_buscarproduto;
    }
}
