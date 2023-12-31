/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visoes;

import Controladores.ControladorTelaListagem;
import Modelos.Usuario;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class TelaListagem extends javax.swing.JFrame {
 
    
    private final ControladorTelaListagem controlador;
    private static Usuario usuario;
    
   
    
    /**
     * Creates new form TelaListagem
     */
    public TelaListagem(Usuario usuario) {
        initComponents();
       
        controlador = new ControladorTelaListagem(this);
        controlador.exibeModeloNaTabelaDaVisao();
        this.usuario = usuario;
         
         controlador.sumirBotaoCadastrar();
         
         controlador.mostrarMensagemBoasVindas();
        
        
       
        
    }

    public TelaListagem(ControladorTelaListagem controlador, Usuario usuario) {
        this.controlador = controlador;
        this.usuario = usuario;
    }

   

   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagem = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelTituloPesquisa = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Produtor", "Nome do episódio", "Nº episódio", "Duração", "Url do repo"
            }
        ));
        jScrollPane1.setViewportView(jTableListagem);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 800, 190));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, -1, -1));

        jTextFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 230, 30));

        jLabelTituloPesquisa.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabelTituloPesquisa.setText("Pesquisar podcast por produtor");
        getContentPane().add(jLabelTituloPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabelSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelSubtitulo.setText("Listagem");
        getContentPane().add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 130, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitulo.setText("Cenaflix");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 160, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
       controlador.irTelaCadastrar();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       controlador.exibeModeloTabelaPesquisa();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
         
                new TelaListagem(usuario).setVisible(true);
            }
        });
    }

    public JTextField getjTextFieldPesquisa() {
        return jTextFieldPesquisa;
    }

    public void setjTextFieldPesquisa(JTextField jTextFieldPesquisa) {
        this.jTextFieldPesquisa = jTextFieldPesquisa;
    }

    
    public JTable getjTableListagem() {
        return jTableListagem;
    }

    public void setjTableListagem(JTable jTableListagem) {
        this.jTableListagem = jTableListagem;
    }

    public JButton getjButtonCadastrar() {
        return jButtonCadastrar;
    }

    public void setjButtonCadastrar(JButton jButtonCadastrar) {
        this.jButtonCadastrar = jButtonCadastrar;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        TelaListagem.usuario = usuario;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListagem;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
