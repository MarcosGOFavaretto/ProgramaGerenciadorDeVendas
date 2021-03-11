package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaInsercaoManual extends javax.swing.JFrame {

    TelaPrincipal objetoDaTelaPrincipal;
    public boolean janelaDeInsercaoManualFoiAberta;

    public TelaInsercaoManual() throws SQLException {
        initComponents();
        janelaDeInsercaoManualFoiAberta = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtFabricanteProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jBtnInserir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INSERÇÃO MANUAL");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setName("TelaInsercaoManual"); // NOI18N
        setState(6);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("INSERÇÃO MANUAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome do produto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jTxtNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 360, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fabricante do produto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jTxtFabricanteProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtFabricanteProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 360, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jTxtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTxtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 360, -1));

        jBtnInserir.setText("INSERIR");
        jBtnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jBtnVoltar.setText("VOLTAR");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        setSize(new java.awt.Dimension(616, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        if (objetoDaTelaPrincipal == null) {
            try {
                objetoDaTelaPrincipal = new TelaPrincipal();
            } catch (SQLException ex) {
                Logger.getLogger(TelaInsercaoManual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        objetoDaTelaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnVoltarActionPerformed
    private void prepararSistemaParaAdicionarNovoProduto() {
        jTxtNomeProduto.setText("");
        jTxtFabricanteProduto.setText("");
        jTxtQuantidade.setText("");
        jTxtNomeProduto.requestFocus();
    }
    private void jBtnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInserirActionPerformed
        if (objetoDaTelaPrincipal == null) {
            try {
                objetoDaTelaPrincipal = new TelaPrincipal();
            } catch (SQLException ex) {
                Logger.getLogger(TelaInsercaoManual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        objetoDaTelaPrincipal.objetoDaClasseProdutos.setNomeDoProduto(jTxtNomeProduto.getText());
        objetoDaTelaPrincipal.objetoDaClasseProdutos.setFabricanteDoProduto(jTxtFabricanteProduto.getText());
        objetoDaTelaPrincipal.objetoDaClasseProdutos.setQuantidadeDoProduto(Float.valueOf(jTxtQuantidade.getText()));
        JOptionPane.showMessageDialog(this, objetoDaTelaPrincipal.objetoDaClasseProdutos.getNomeDoProduto() + "\n" + objetoDaTelaPrincipal.objetoDaClasseProdutos.getFabricanteDoProduto() + "\n" + objetoDaTelaPrincipal.objetoDaClasseProdutos.getQuantidadeDoProduto() + "\n");
        objetoDaTelaPrincipal.objetoDaClasseProdutos.adicionarProdutoNaListaDeProdutosJáAdicinadosNaCompra();
        prepararSistemaParaAdicionarNovoProduto();
    }//GEN-LAST:event_jBtnInserirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        prepararSistemaParaAdicionarNovoProduto();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInsercaoManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInsercaoManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInsercaoManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInsercaoManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaInsercaoManual().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaInsercaoManual.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnInserir;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtFabricanteProduto;
    private javax.swing.JTextField jTxtNomeProduto;
    private javax.swing.JTextField jTxtQuantidade;
    // End of variables declaration//GEN-END:variables
}
