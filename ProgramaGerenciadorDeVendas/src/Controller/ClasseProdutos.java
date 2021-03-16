package Controller;

import Model.BuscarProdutoNoBancoDeDados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasseProdutos {

    private String codigoDoProduto;
    private String nomeDoProduto;
    private String fabricanteDoProduto;
    private float quantidadeDoProduto;
    private ResultSet resultadoDaBuscaPeloProdutoNoBancoDeDados;
    private BuscarProdutoNoBancoDeDados objetoDaClasseBuscarProduto = new BuscarProdutoNoBancoDeDados();
    public ArrayList<String> listaDeProdutosJaAdicionadosNaCompra = new ArrayList();
    private boolean aQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero;

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

    public boolean getAQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero() {
        return aQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero;
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
                if (listaDeProdutosJaAdicionadosNaCompra.get(i).equals(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("nome_produto")) && listaDeProdutosJaAdicionadosNaCompra.get(i + 1).equals(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("fabricante_produto"))) {
                    i = i + 2;
                    float valorDaQuantidade = Float.valueOf(listaDeProdutosJaAdicionadosNaCompra.get(i)) + 1;
                    listaDeProdutosJaAdicionadosNaCompra.set(i, String.valueOf(valorDaQuantidade));
                }
            }
        } else {
            listaDeProdutosJaAdicionadosNaCompra.add(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("nome_produto"));
            listaDeProdutosJaAdicionadosNaCompra.add(resultadoDaBuscaPeloProdutoNoBancoDeDados.getString("fabricante_produto"));
            listaDeProdutosJaAdicionadosNaCompra.add("1.0");
        }
    }

    public void adicionarProdutoNaListaDeProdutosJáAdicinadosNaCompra() {
        boolean produtoExisteNalista = false;
        for (int i = 0; i < listaDeProdutosJaAdicionadosNaCompra.size(); i++) {
            if (listaDeProdutosJaAdicionadosNaCompra.get(i).equals(getNomeDoProduto()) && listaDeProdutosJaAdicionadosNaCompra.get(i + 1).equals(getFabricanteDoProduto())) {
                produtoExisteNalista = true;
                i = i + 2;
                if (getQuantidadeDoProduto() < -Float.valueOf(listaDeProdutosJaAdicionadosNaCompra.get(i))) {
                    aQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero = true;
                } else {
                    aQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero = false;
                    float valorDaQuantidade = Float.valueOf(listaDeProdutosJaAdicionadosNaCompra.get(i)) + getQuantidadeDoProduto();
                    if (valorDaQuantidade <= 0) {
                        listaDeProdutosJaAdicionadosNaCompra.remove(i - 2);
                        listaDeProdutosJaAdicionadosNaCompra.remove(i - 1);
                        listaDeProdutosJaAdicionadosNaCompra.remove(i);
                    } else {
                        listaDeProdutosJaAdicionadosNaCompra.set(i, String.valueOf(valorDaQuantidade));
                    }
                }
                break;
            } else {
                produtoExisteNalista = false;
            }
        }
        if (!produtoExisteNalista || listaDeProdutosJaAdicionadosNaCompra.isEmpty()) {
            listaDeProdutosJaAdicionadosNaCompra.add(getNomeDoProduto());
            listaDeProdutosJaAdicionadosNaCompra.add(getFabricanteDoProduto());
            listaDeProdutosJaAdicionadosNaCompra.add(String.valueOf(getQuantidadeDoProduto()));
        }
        setNomeDoProduto("");
        setFabricanteDoProduto("");
        setQuantidadeDoProduto(0);
    }
}
