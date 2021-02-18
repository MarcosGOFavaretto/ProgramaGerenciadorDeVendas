package Controller;

import Model.BuscarProduto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosClass {

    // DECLARANDO AS VARIÁVEIS GLOBAIS DA CLASSE:
    private String codigoProduto;
    private String nomeProduto;
    private String fabricanteProduto;
    private float quantidadeProduto;
    BuscarProduto objeto_buscarproduto = new BuscarProduto();
    private ResultSet resultset_buscarproduto;
    private ResultSet resultset_BuscarLista;
    public Object[] listaDeCompraNome = null;
    public Object[] listaDeCompraFornecedor = null;
    public Object[] listaDeCompraQuantidade = null;
    public Object[] produtosAtuaisNome = null;
    public Object[] produtosAtuaisFornecedor = null;
    public Object[] produtosAtuaisQuantidade = null;

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
    public ResultSet buscarProdutoNoBanco() {
        resultset_buscarproduto = null;
        resultset_buscarproduto = objeto_buscarproduto.buscarProduto(getCodigoProduto());
        return resultset_buscarproduto;
    }

    public void criarArraysDaLista(int quantidadeDeLinhasTabela) {
        listaDeCompraNome = new Object[quantidadeDeLinhasTabela];
        listaDeCompraFornecedor = new Object[quantidadeDeLinhasTabela];
        listaDeCompraQuantidade = new Object[quantidadeDeLinhasTabela];
    }
    public void criarArraysDosProdutosAtuais(int quantidadeDeLinhasTabela) {
        produtosAtuaisNome = new Object[quantidadeDeLinhasTabela];
        produtosAtuaisFornecedor = new Object[quantidadeDeLinhasTabela];
        produtosAtuaisQuantidade = new Object[quantidadeDeLinhasTabela];
    }

}
