package Controller;

import Model.BuscarProduto;
import Model.SalvarProdutoNaLista;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosClass {

    // DECLARANDO AS VARIÁVEIS GLOBAIS DA CLASSE:
    private String codigoProduto;
    private String nomeProduto;
    private String fabricanteProduto;
    private float quantidadeProduto;
    BuscarProduto objeto_buscarproduto = new BuscarProduto();
    SalvarProdutoNaLista objeto_SalvarProdutoNaLista = new SalvarProdutoNaLista();
    private ResultSet resultset_buscarproduto;
    public Object[] listaDeCompraNome = null;
    public Object[] listaDeCompraFornecedor = null;
    public Object[] listaDeCompraQuantidade = null;

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

    // CRIANDO MÉTODO QUE IRÁ SALVAR A LISTA DE COMPRAS NO BANCO DE DADOS:
    public void salvarProdutoNaLista(int quantidadeDeLinhasTabela) throws SQLException {
        for (int i = 0; i < quantidadeDeLinhasTabela; i++) {
            String nomeProdutoVenda = this.listaDeCompraNome[i].toString();
            String fornecedorProdutoVenda = this.listaDeCompraFornecedor[i].toString();
            String quantidadeProdutoVenda = this.listaDeCompraQuantidade[i].toString();
            objeto_SalvarProdutoNaLista.salvarProdutoNaLista(nomeProdutoVenda, fornecedorProdutoVenda, quantidadeProdutoVenda);
            nomeProdutoVenda = "";
            fornecedorProdutoVenda = "";
            quantidadeProdutoVenda = "";
        }
    }

    public void criarArrays(int quantidadeDeLinhasTabela) {
        listaDeCompraNome = new Object[quantidadeDeLinhasTabela];
        listaDeCompraFornecedor = new Object[quantidadeDeLinhasTabela];
        listaDeCompraQuantidade = new Object[quantidadeDeLinhasTabela];
    }
}
