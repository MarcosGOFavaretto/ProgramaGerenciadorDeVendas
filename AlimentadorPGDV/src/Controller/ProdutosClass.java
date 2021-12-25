package Controller;

import Model.BuscarProdutoNoBancoDeDados;
import Model.CadastrarProdutoNoBancoDeDados;
import java.sql.ResultSet;

public class ProdutosClass {

    private String codigoDoProduto;
    private String nomeDoProduto;
    private String fabricanteDoProduto;
    private CadastrarProdutoNoBancoDeDados objetoDaClasseCadastrarProdutoNoBancoDeDados = new CadastrarProdutoNoBancoDeDados();
    private BuscarProdutoNoBancoDeDados objetoDaClasseBuscarProdutoNoBancoDeDados = new BuscarProdutoNoBancoDeDados();

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getFabricanteDoProduto() {
        return fabricanteDoProduto;
    }

    public void setFabricanteDoProduto(String fabricanteDoProduto) {
        this.fabricanteDoProduto = fabricanteDoProduto;
    }

    public boolean cadastrarProtudo(){
        return objetoDaClasseCadastrarProdutoNoBancoDeDados.cadastrarProduto(this.getCodigoDoProduto(), this.getNomeDoProduto(), this.getFabricanteDoProduto());
    }
    
    public ResultSet buscarProdutos(){
        return objetoDaClasseBuscarProdutoNoBancoDeDados.buscarProdutoNoBancoDeDados();
    }
}
