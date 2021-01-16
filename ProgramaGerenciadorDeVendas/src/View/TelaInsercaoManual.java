package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author T-Gamer
 */
public class TelaInsercaoManual extends javax.swing.JFrame {

    /**
     * Creates new form TelaInsercaoManual
     */
    public TelaInsercaoManual() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jTxtNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtFabricanteProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jTxtInserir = new javax.swing.JButton();
        jTxtCancelar = new javax.swing.JButton();
        jTxtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jTxtInserir.setText("INSERIR");
        getContentPane().add(jTxtInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jTxtCancelar.setText("CANCELAR");
        getContentPane().add(jTxtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jTxtVoltar.setText("VOLTAR");
        jTxtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jTxtVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        setSize(new java.awt.Dimension(616, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtVoltarActionPerformed
        // CÓDIGO DO BOTÃO "VOLTAR":
        try {
            TelaPrincipal telaPrincipal_objeto;
            telaPrincipal_objeto = new TelaPrincipal();
            telaPrincipal_objeto.setVisible(true);
        this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(TelaInsercaoManual.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTxtVoltarActionPerformed

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
                new TelaInsercaoManual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jTxtCancelar;
    private javax.swing.JTextField jTxtFabricanteProduto;
    private javax.swing.JButton jTxtInserir;
    private javax.swing.JTextField jTxtNomeProduto;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JButton jTxtVoltar;
    // End of variables declaration//GEN-END:variables
}
