package View;

import Controller.ClientesClass;
import Controller.ProdutosClass;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    // VARIÁVEIS GLOBAIS DA CLASSE:
    private String nomeDoArquivo = "";
    private ProdutosClass objeto_ProdutosClass = new ProdutosClass();
    ClientesClass objeto_ClientesClass = new ClientesClass();
    private ResultSet resultset_ProdutoParaInserir = null;
    String[] array_DataAtual = null;
    String[] array_HorarioAtual = null;
    SimpleDateFormat mascara_Dia = null;
    SimpleDateFormat mascara_Horas = null;
    Date data_Atual = null;

    PdfPTable objeto_PdfPTable = null;
    PdfPCell objeto_PdfPCell = null;

    public TelaPrincipal() throws SQLException {
        initComponents();
        //limparInformacoes();
        int leituraAtual = 1; // Variável que simula o código lido pelo leitor de código de barras.
        resultset_ProdutoParaInserir = objeto_ProdutosClass.buscarProdutoNoBanco(leituraAtual);
        DefaultTableModel objeto_Tabela = (DefaultTableModel) jTbProdutos.getModel();
        objeto_Tabela.setNumRows(0);
        while (resultset_ProdutoParaInserir.next()) {
            objeto_Tabela.addRow(new Object[]{
                resultset_ProdutoParaInserir.getInt("nome_produto"),
                resultset_ProdutoParaInserir.getString("fabricante_produto"),
                String.valueOf(objeto_ProdutosClass.getQuantidadeProduto())
            }
            );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTxtNomeCliente = new javax.swing.JTextField();
        jBtnInserirManualmente = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROGRAMA GERENCIADOR DE VENDAS");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("TelaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("PROGRAMA GERENCIADOR DE VENDAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 720, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setToolTipText("");
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 716, 22));

        jTbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do produto", "Fabricante", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(jTbProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 716, 508));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NOME COMPLETO DO CLIENTE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, -1, -1));

        jTxtNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNomeCliente.setText("Marcos Gabriel de Oliveira Favaretto");
        getContentPane().add(jTxtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 716, -1));

        jBtnInserirManualmente.setText("INSERIR MANUALMENTE");
        jBtnInserirManualmente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInserirManualmenteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnInserirManualmente, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 620, -1, -1));

        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 151, -1));

        jBtnSalvar.setText("SALVAR");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 150, -1));

        setSize(new java.awt.Dimension(1096, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void obterDataHorarioAtual() {
        data_Atual = new Date();
        mascara_Dia = new SimpleDateFormat("dd-MM-yyyy");
        mascara_Horas = new SimpleDateFormat("HH-mm-ss");
        array_DataAtual = mascara_Dia.format(data_Atual).split("-");
        array_HorarioAtual = mascara_Horas.format(data_Atual).split("-");

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(array_DataAtual[0]) - 1);
        cal.set(Calendar.MONTH, Integer.parseInt(array_DataAtual[1]) - 1);
        cal.set(Calendar.YEAR, Integer.parseInt(array_DataAtual[2]));
        cal.set(Calendar.HOUR, Integer.parseInt(array_HorarioAtual[0]) + 12);
        cal.set(Calendar.MINUTE, Integer.parseInt(array_HorarioAtual[1]));
        cal.set(Calendar.SECOND, Integer.parseInt(array_HorarioAtual[2]));
        data_Atual = cal.getTime();
    }

    private String criarNomeDoArquivo() {
        obterDataHorarioAtual();
        String nomeArquivoPDFSaida = mascara_Dia.format(data_Atual) + " às " + mascara_Horas.format(data_Atual) + " - " + objeto_ClientesClass.getNome_cliente() + ".pdf";
        return nomeArquivoPDFSaida;
    }

    private void abrirPDF() {
        try {
            Desktop.getDesktop().open(new File(this.nomeDoArquivo));
        } catch (IOException erro_abrirpdf) {
            System.err.println("Problema ao tentar abrir o arquivo em formato PDF, ERRO: " + erro_abrirpdf);
        }
    }

    private void limparInformacoes() {
        String stringVazia = "";
        DefaultTableModel jTbProdutos_objeto = (DefaultTableModel) this.jTbProdutos.getModel();
        jTbProdutos_objeto.setNumRows(0);
        jTxtNomeCliente.setText(stringVazia);
    }

    private void jBtnInserirManualmenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInserirManualmenteActionPerformed
        // CÓDIGO DO BOTÃO "INSERIR MANUALMENTE":
        TelaInsercaoManual telaInsercaoManual_objeto = new TelaInsercaoManual();
        telaInsercaoManual_objeto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnInserirManualmenteActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // CÓDIGO DO BOTÃO "CANCELAR":
        if (JOptionPane.showConfirmDialog(this, "Deseja limpar TODOS os campos?") == JOptionPane.YES_OPTION) {
            limparInformacoes();
            JOptionPane.showMessageDialog(this, "Informações apagadas!", "OPERAÇÃO CONCLUÍDA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma informação foi alterada!", "ALERTA!", 2);
        }
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void criarCabecalhoDaTabelaEmPdf() {
        objeto_PdfPTable = new PdfPTable(new float[]{10f, 5f, 3f});
        objeto_PdfPCell = new PdfPCell(new Phrase("Nome do produto"));
        objeto_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objeto_PdfPTable.addCell(objeto_PdfPCell);
        objeto_PdfPCell = new PdfPCell(new Phrase("Fabricante"));
        objeto_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objeto_PdfPTable.addCell(objeto_PdfPCell);
        objeto_PdfPCell = new PdfPCell(new Phrase("Quantidade"));
        objeto_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        objeto_PdfPTable.addCell(objeto_PdfPCell);
    }
    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        // CÓDIGO DO BOTÃO "SALVAR":
        objeto_ClientesClass.setNome_cliente("Robson Pereira Alameda");
        Document objeto_Document = new Document();
        nomeDoArquivo = criarNomeDoArquivo();
        // Criando as fontes:
        Font objeto_Font_Cabecalho = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
        Font objeto_Font_Padrao = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Paragraph objeto_Paragraph_Cabecalho = new Paragraph("LISTA DE SAÍDA DE PRODUTOS", objeto_Font_Cabecalho);
        objeto_Paragraph_Cabecalho.setAlignment(Element.ALIGN_CENTER);
        Paragraph objeto_Paragraph_Padrao = new Paragraph("Este arquivo foi gerado de forma autônoma através do sistema Programa Gerenciador de Vendas (PGDV). Abaixo, têm-se os dados registrados a cerca dos produtos. Este arquivo registra os artigos comprados por " + objeto_ClientesClass.getNome_cliente() + " no dia " + mascara_Dia.format(data_Atual) + ".", objeto_Font_Padrao);
        objeto_Paragraph_Padrao.setAlignment(Element.ALIGN_JUSTIFIED);
        objeto_Paragraph_Padrao.setFirstLineIndent(10);
        try {
            PdfWriter.getInstance(objeto_Document, new FileOutputStream(nomeDoArquivo));
            objeto_Document.open();
            // Metadados
            objeto_Document.addAuthor("Sistema Gerenciador De Vendas");
            objeto_Document.addLanguage("pt-br");
            objeto_Document.addTitle("LISTA DE SAÍDA DE PRODUTOS");
            objeto_Document.addCreationDate();
            // CONTEÚDO DO ARQUIVO:
            // Texto:
            objeto_Document.add(objeto_Paragraph_Cabecalho);
            objeto_Document.add(new Paragraph(" "));
            objeto_Document.add(objeto_Paragraph_Padrao);
            objeto_Document.add(new Paragraph(" "));
            // Tabela:
            criarCabecalhoDaTabelaEmPdf();
            if (objeto_Document.isOpen()) {
                // A cada linha criada na tabela do layout, deve-se adicionar mais três células, com seus respectivos valores
                PdfPCell celula1 = new PdfPCell(new Phrase("Caneta Preta"));
                celula1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell celula2 = new PdfPCell(new Phrase("BIC"));
                celula2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell celula3 = new PdfPCell(new Phrase("50"));
                celula3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                objeto_PdfPTable.addCell(celula1);
                objeto_PdfPTable.addCell(celula2);
                objeto_PdfPTable.addCell(celula3);
            }
            objeto_Document.add(objeto_PdfPTable);

        } catch (FileNotFoundException | DocumentException erro_gerarpdf) {
            System.err.println("Problema ao tentar gerar o arquivo em formato PDF, ERRO: " + erro_gerarpdf);
        } finally {
            objeto_Document.close();
        }

        if (JOptionPane.showConfirmDialog(this, "Deseja imprimir a lista de produtos?", "IMPRIMIR?!", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Arquivo enviado para a impressora!", "OPERAÇÃO CONCLUÍDA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Arquivo PDF gerado!", "OPERAÇÃO CONCLUÍDA!", JOptionPane.INFORMATION_MESSAGE);
            abrirPDF();
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnInserirManualmente;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTbProdutos;
    private javax.swing.JTextField jTxtNomeCliente;
    // End of variables declaration//GEN-END:variables
}
