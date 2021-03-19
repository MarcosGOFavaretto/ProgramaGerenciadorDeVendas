package View;

import Controller.ClasseProdutos;
import Controller.ClasseRelatorio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    DefaultTableModel objetoDaClasseDefaultTableModel;
    ClasseProdutos objetoDaClasseProdutos;
    ClasseRelatorio objetoDaClasseRelatorio;
    int linhasDeProdutosNaLista = 0;

    public TelaPrincipal() throws SQLException {
        initComponents();
        instanciarClasses();
        limparInformacoes();
        desativarInsercaoManual();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtCodigoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTxtNomeCliente = new javax.swing.JTextField();
        jBtnInserirManualmente = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNomeProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtFabricanteProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jBtnInserir = new javax.swing.JButton();
        jBtnCancelarInsercaoManual = new javax.swing.JButton();

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

        jTxtCodigoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jTxtCodigoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 716, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("PROGRAMA GERENCIADOR DE VENDAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 720, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setToolTipText("");
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 716, 22));

        jTbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do produto", "Fabricante", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 716, 508));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NOME COMPLETO DO CLIENTE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        jTxtNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 716, -1));

        jBtnInserirManualmente.setText("INSERIR MANUALMENTE");
        jBtnInserirManualmente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInserirManualmenteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnInserirManualmente, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 680, 170, -1));

        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 650, 170, -1));

        jBtnSalvar.setText("SALVAR");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 620, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CÓDIGO DO PRODUTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nome do produto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, -1, -1));

        jTxtNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 320, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fabricante do produto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        jTxtFabricanteProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtFabricanteProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 320, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Quantidade:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        jTxtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 100, -1));

        jBtnInserir.setText("INSERIR");
        jBtnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 100, -1));

        jBtnCancelarInsercaoManual.setText("CANCELAR");
        jBtnCancelarInsercaoManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarInsercaoManualActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelarInsercaoManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 100, -1));

        setSize(new java.awt.Dimension(1096, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void instanciarClasses() throws SQLException {
        if (objetoDaClasseDefaultTableModel == null) {
            objetoDaClasseDefaultTableModel = (DefaultTableModel) jTbProdutos.getModel();
        }
        if (objetoDaClasseProdutos == null) {
            objetoDaClasseProdutos = new ClasseProdutos();
        }
        if (objetoDaClasseRelatorio == null) {
            objetoDaClasseRelatorio = new ClasseRelatorio();
        }
    }

    private void limparInformacoes() {
        objetoDaClasseDefaultTableModel.setNumRows(0);
        jTxtNomeCliente.setText("");
        prepararSistemaParaAdicionarNovoProduto();
        limparDadosDasCompras();
    }

    private void prepararSistemaParaAdicionarNovoProduto() {
        jTxtCodigoProduto.setText("");
        jTxtCodigoProduto.requestFocus();
    }

    private void limparCamposDaInsercaoManual() {
        jTxtNomeProduto.setText("");
        jTxtFabricanteProduto.setText("");
        jTxtQuantidade.setText("");
    }

    private void limparDadosDasCompras() {
        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.clear();
    }

    private void adicionarLinhaNaTabelaDoSistema(boolean seTrataDeUmaInsercaoManual) throws SQLException {
        if (seTrataDeUmaInsercaoManual) {
            objetoDaClasseProdutos.adicionarProdutoNaListaDeProdutosJáAdicinadosNaCompra(jTxtNomeProduto.getText(), jTxtFabricanteProduto.getText(), Float.valueOf(jTxtQuantidade.getText()));
            if (objetoDaClasseProdutos.getAQuantidadeInformadaVaiResultarEmUmaQuantidadeMenorQueZero()) {
                exibirMensagemDeQuantidadeInválida();
            } else {
                objetoDaClasseDefaultTableModel.setNumRows(0);
                linhasDeProdutosNaLista = objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.size() / 3;
                for (int i = 0; i < linhasDeProdutosNaLista; ++i) {
                    objetoDaClasseDefaultTableModel.addRow(new Object[]{
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3),
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3 + 1),
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3 + 2)
                    }
                    );
                }
            }
        } else {
            objetoDaClasseProdutos.setCodigoDoProduto(jTxtCodigoProduto.getText());
            try {
                objetoDaClasseProdutos.buscarProdutoNoBanco();
                objetoDaClasseDefaultTableModel.setNumRows(0);
                linhasDeProdutosNaLista = objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.size() / 3;
                for (int i = 0; i < linhasDeProdutosNaLista; ++i) {
                    objetoDaClasseDefaultTableModel.addRow(new Object[]{
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3),
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3 + 1),
                        objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.get(i * 3 + 2)
                    }
                    );
                }
            } catch (SQLException erroAoAdicionarLinhaNaTabelaDoSistema) {
                System.err.println("Problema ao tentar adicionar uma nova linha na tabela do sistema, ERRO: " + erroAoAdicionarLinhaNaTabelaDoSistema);
            }
        }
    }

    private void exibirMensagemDeArquivoSalvo() {
        JOptionPane.showMessageDialog(this, "O arquivo foi gerado e salvo!", "OPERAÇÃO CONCLUÍDA!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exibirMensagemDeCancelamento() {
        int escolhaDoUsuario = JOptionPane.showConfirmDialog(this, "Deseja LIMPAR todos os campos da tela?", "OPERAÇÃO DE CANCELAMENTO", JOptionPane.YES_NO_OPTION);
        switch (escolhaDoUsuario) {
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(this, "Informações apagadas!", "OPERAÇÃO CONCLUÍDA!", JOptionPane.INFORMATION_MESSAGE);
                limparInformacoes();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(this, "NENHUMA informação foi alterada!", "ALERTA!", 2);
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
        }
    }

    private void exibirMensagemDeQuantidadeInválida() {
        JOptionPane.showMessageDialog(this, "O número inserido no campo de quantidade é inválido! Por favor, revise as informações", "ALERTA!", 2);
    }

    private void exibirMensagemDeNomeDeUsuarioAusente() {
        JOptionPane.showMessageDialog(this, "Lamento, o NOME DO USUÁRIO não foi informado!", "ALERTA!", 2);
    }

    private void exibirMensagemDeCodigoDoProdutoAusente() {
        JOptionPane.showMessageDialog(this, "Lamento, o CÓDIGO DO PRODUTO não foi informado!", "ALERTA!", 2);
    }

    private void exibirMensagemDeInformacoesAusentes() {
        JOptionPane.showMessageDialog(this, "Lamento, as informações não estão completas!", "ALERTA!", 2);
    }

    private void exibirMensagemDeListaDeProdutosVazias() {
        JOptionPane.showMessageDialog(this, "Lamento, não há produtos na lista, por favor, faça cadastros de novos!", "ALERTA!", 2);
    }

    private void ativarInsercaoManual() {
        jTxtNomeProduto.setEnabled(true);
        jTxtFabricanteProduto.setEnabled(true);
        jTxtQuantidade.setEnabled(true);
        jTxtNomeProduto.setVisible(true);
        jTxtFabricanteProduto.setVisible(true);
        jTxtQuantidade.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jBtnInserir.setEnabled(true);
        jBtnCancelarInsercaoManual.setEnabled(true);
        jBtnInserir.setVisible(true);
        jBtnCancelarInsercaoManual.setVisible(true);
    }

    private void desativarInsercaoManual() {
        jTxtNomeProduto.setEnabled(false);
        jTxtFabricanteProduto.setEnabled(false);
        jTxtQuantidade.setEnabled(false);
        jTxtNomeProduto.setVisible(false);
        jTxtFabricanteProduto.setVisible(false);
        jTxtQuantidade.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jBtnInserir.setEnabled(false);
        jBtnCancelarInsercaoManual.setEnabled(false);
        jBtnInserir.setVisible(false);
        jBtnCancelarInsercaoManual.setVisible(false);
    }
    private void jBtnInserirManualmenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInserirManualmenteActionPerformed
        ativarInsercaoManual();
    }//GEN-LAST:event_jBtnInserirManualmenteActionPerformed
    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        exibirMensagemDeCancelamento();
    }//GEN-LAST:event_jBtnCancelarActionPerformed
    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        if (jTxtNomeCliente.getText().equals("")) {
            exibirMensagemDeNomeDeUsuarioAusente();
        } else {
            if (objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra.isEmpty()) {
                exibirMensagemDeListaDeProdutosVazias();
            } else {
                objetoDaClasseRelatorio.gerarRelatorio(jTxtNomeCliente.getText(), objetoDaClasseProdutos.listaDeProdutosJaAdicionadosNaCompra);
                exibirMensagemDeArquivoSalvo();
                limparInformacoes();
            }
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed
    private void jTxtCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoProdutoActionPerformed
        if (jTxtCodigoProduto.getText().equals("")) {
            exibirMensagemDeCodigoDoProdutoAusente();
        } else {
            try {
                adicionarLinhaNaTabelaDoSistema(false);
            } catch (SQLException erroAoAdicionarLinhaNaTabelaDoSistema) {
                System.err.println("Problema ao tentar adicionar linha na tebela do sistema, ERRO: " + erroAoAdicionarLinhaNaTabelaDoSistema);
            }
            prepararSistemaParaAdicionarNovoProduto();
        }
    }//GEN-LAST:event_jTxtCodigoProdutoActionPerformed
    private void jBtnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInserirActionPerformed
        if (jTxtNomeProduto.getText().equals("") || jTxtFabricanteProduto.getText().equals("") || jTxtQuantidade.getText().equals("")) {
            exibirMensagemDeInformacoesAusentes();
        } else {
            try {
                adicionarLinhaNaTabelaDoSistema(true);
                desativarInsercaoManual();
                limparCamposDaInsercaoManual();
            } catch (SQLException erroAoAdicionarLinhaNaTabelaDoSistema) {
                System.err.println("Problema ao tentar adicionar linha na tebela do sistema, ERRO: " + erroAoAdicionarLinhaNaTabelaDoSistema);
            }
        }
    }//GEN-LAST:event_jBtnInserirActionPerformed
    private void jBtnCancelarInsercaoManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarInsercaoManualActionPerformed
        desativarInsercaoManual();
        limparCamposDaInsercaoManual();
    }//GEN-LAST:event_jBtnCancelarInsercaoManualActionPerformed
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnCancelarInsercaoManual;
    private javax.swing.JButton jBtnInserir;
    private javax.swing.JButton jBtnInserirManualmente;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTbProdutos;
    private javax.swing.JTextField jTxtCodigoProduto;
    private javax.swing.JTextField jTxtFabricanteProduto;
    private javax.swing.JTextField jTxtNomeCliente;
    private javax.swing.JTextField jTxtNomeProduto;
    private javax.swing.JTextField jTxtQuantidade;
    // End of variables declaration//GEN-END:variables
}
