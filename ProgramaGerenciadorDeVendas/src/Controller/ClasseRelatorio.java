package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClasseRelatorio {

    private String nomeDoCliente;
    private ArrayList<String> listaDeProdutosJaAdicionadosNaCompra;
    ClasseProdutos objetoDaClasseProdutos;
    ClasseClientes objetoDaClasseClientes;
    Document objetoDaClasseDocument = null;
    Paragraph objeto_Paragraph_Cabecalho = null;
    Font objeto_Font_Cabecalho = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    Paragraph objeto_Paragraph_Padrao = null;
    Font objeto_Font_Padrao = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    PdfPTable objetoDaClassePdfPTable = null;
    PdfPCell objetoDaClassePdfPCell = null;
    int linhasDeProdutosNaLista = 0;
    Date dataAtual = null;
    SimpleDateFormat mascaraDataAtual = null;
    String nomeDoArquivo = "";

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public ArrayList<String> getListaDeProdutosJaAdicionadosNaCompra() {
        return listaDeProdutosJaAdicionadosNaCompra;
    }

    public void setListaDeProdutosJaAdicionadosNaCompra(ArrayList<String> listaDeProdutosJaAdicionadosNaCompra) {
        this.listaDeProdutosJaAdicionadosNaCompra = listaDeProdutosJaAdicionadosNaCompra;
    }

    private void obterDataAtual() {
        dataAtual = new Date();
        mascaraDataAtual = new SimpleDateFormat("dd.MM.yyyy");
    }

    private void criarNomeDoArquivo() {
        //nomeDoArquivo = mascaraDataAtual.format(dataAtual) + " - " + getNomeDoCliente() + ".pdf";
    }

    private void criarCabecalhoDoArquivo() {
        objeto_Paragraph_Cabecalho = new Paragraph("LISTA DE SAÍDA DE PRODUTOS", objeto_Font_Cabecalho);
        objeto_Paragraph_Cabecalho.setAlignment(Element.ALIGN_CENTER);
        objeto_Paragraph_Padrao = new Paragraph("Este arquivo foi gerado de forma autônoma através do sistema Programa Gerenciador de Vendas (PGDV). Abaixo, têm-se os dados registrados a cerca dos produtos. Este arquivo registra os artigos comprados por " + getNomeDoCliente() + " no dia " + mascaraDataAtual.format(dataAtual) + ".", objeto_Font_Padrao);
        objeto_Paragraph_Padrao.setAlignment(Element.ALIGN_JUSTIFIED);
        objeto_Paragraph_Padrao.setFirstLineIndent(10);
    }

    private void adicionarMetadadosAoArquivo() {
        objetoDaClasseDocument.addAuthor("Sistema Gerenciador De Vendas");
        objetoDaClasseDocument.addLanguage("pt-br");
        objetoDaClasseDocument.addTitle("LISTA DE SAÍDA DE PRODUTOS");
        objetoDaClasseDocument.addCreationDate();
    }

    private void adicionarCabecalhoComEspacamentoAoArquivo() throws DocumentException {
        objetoDaClasseDocument.add(objeto_Paragraph_Cabecalho);
        objetoDaClasseDocument.add(new Paragraph(" "));
        objetoDaClasseDocument.add(objeto_Paragraph_Padrao);
        objetoDaClasseDocument.add(new Paragraph(" "));
    }

    private void criarCabecalhoDaTabelaDoArquivo() {
        objetoDaClassePdfPTable = new PdfPTable(new float[]{10f, 5f, 3f});
        objetoDaClassePdfPCell = new PdfPCell(new Phrase("NOME DO PRODUTO"));
        objetoDaClassePdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objetoDaClassePdfPTable.addCell(objetoDaClassePdfPCell);
        objetoDaClassePdfPCell = new PdfPCell(new Phrase("FABRICANTE"));
        objetoDaClassePdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objetoDaClassePdfPTable.addCell(objetoDaClassePdfPCell);
        objetoDaClassePdfPCell = new PdfPCell(new Phrase("QUANTIDADE"));
        objetoDaClassePdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objetoDaClassePdfPTable.addCell(objetoDaClassePdfPCell);
    }

    private void inserirDadosDaTabelaDoArquivo() {
        linhasDeProdutosNaLista = getListaDeProdutosJaAdicionadosNaCompra().size() / 3;
        if (objetoDaClasseDocument.isOpen()) {
            for (int i = 0; i < linhasDeProdutosNaLista; ++i) {
                PdfPCell celula1 = new PdfPCell(new Phrase(getListaDeProdutosJaAdicionadosNaCompra().get(i * 3)));
                celula1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell celula2 = new PdfPCell(new Phrase(getListaDeProdutosJaAdicionadosNaCompra().get(i * 3 + 1)));
                celula2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell celula3 = new PdfPCell(new Phrase(getListaDeProdutosJaAdicionadosNaCompra().get(i * 3 + 2)));
                celula3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                objetoDaClassePdfPTable.addCell(celula1);
                objetoDaClassePdfPTable.addCell(celula2);
                objetoDaClassePdfPTable.addCell(celula3);
            }
            System.gc();
        }
    }

    private void adicionarTabelaDeDadosAoArquivo() throws DocumentException {
        objetoDaClasseDocument.add(objetoDaClassePdfPTable);
    }

    private void adicionarRodapeAoArquivo() throws DocumentException {
        objeto_Paragraph_Padrao = null;
        objeto_Paragraph_Padrao = new Paragraph("Nome da empresa", objeto_Font_Padrao);
        objeto_Paragraph_Padrao.setAlignment(Element.ALIGN_CENTER);
        objetoDaClasseDocument.add(objeto_Paragraph_Padrao);
    }

    private void abrirArquivoGerado() {
        try {
            Desktop.getDesktop().open(new File(this.nomeDoArquivo));
        } catch (IOException erroAoAbrirArquivoGerado) {
            System.err.println("Problema ao tentar abrir o arquivo gerado, ERRO: " + erroAoAbrirArquivoGerado);
        }
    }

    public void gerarRelatorio(String nomeDoCliente, ArrayList<String> listaDeProdutosJaAdicionadosNaCompra) {
        try {
            objetoDaClasseDocument = new Document();
            obterDataAtual();
            criarNomeDoArquivo();
            PdfWriter.getInstance(objetoDaClasseDocument, new FileOutputStream(nomeDoArquivo));
            objetoDaClasseDocument.open();
            setNomeDoCliente(nomeDoCliente);
            setListaDeProdutosJaAdicionadosNaCompra(listaDeProdutosJaAdicionadosNaCompra);
            adicionarMetadadosAoArquivo();
            criarCabecalhoDoArquivo();
            adicionarCabecalhoComEspacamentoAoArquivo();
            criarCabecalhoDaTabelaDoArquivo();
            inserirDadosDaTabelaDoArquivo();
            adicionarTabelaDeDadosAoArquivo();
            adicionarRodapeAoArquivo();
        } catch (FileNotFoundException | DocumentException erroAoGerarArquivo) {
            System.err.println("Problema ao tentar gerar o arquivo PDF, ERRO: " + erroAoGerarArquivo);
        } finally {
            objetoDaClasseDocument.close();
            abrirArquivoGerado();
        }
    }
}
