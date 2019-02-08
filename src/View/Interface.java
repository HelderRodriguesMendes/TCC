/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Fundo_tela_Inicial;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public class Interface extends javax.swing.JFrame {

    Fundo_tela_Inicial tela;
    
    public Interface() {
        initComponents();
        setLayout(new GridLayout());
        tela = new Fundo_tela_Inicial("src/Imagens/SIRA.png");
        getContentPane().add(tela);
    }

    public void bloquiarMenus(boolean adm){
        if(adm == true){
            MENU_PESQUISAR.setVisible(false);
        }else{
            MENU_SALVAR.setVisible(false);
            MENU_PE.setVisible(false);
            MENU_EXCLUIR.setVisible(false);
            
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

        jMenuBar1 = new javax.swing.JMenuBar();
        MENU_SALVAR = new javax.swing.JMenu();
        MENU_PE = new javax.swing.JMenu();
        MENU_PESQUISAR = new javax.swing.JMenu();
        MENU_EXCLUIR = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        Menu_SAIR = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MENU_SALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/SALVAR 2.png"))); // NOI18N
        jMenuBar1.add(MENU_SALVAR);

        MENU_PE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar_editar.png"))); // NOI18N
        jMenuBar1.add(MENU_PE);

        MENU_PESQUISAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PESQUISAR (2).png"))); // NOI18N
        jMenuBar1.add(MENU_PESQUISAR);

        MENU_EXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ESCLUIR 2.png"))); // NOI18N
        jMenuBar1.add(MENU_EXCLUIR);

        jMenu5.setEnabled(false);
        jMenu5.setMaximumSize(new java.awt.Dimension(1000, 32767));
        jMenu5.setPreferredSize(new java.awt.Dimension(700, 19));
        jMenuBar1.add(jMenu5);

        Menu_SAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/SAIR 2.png"))); // NOI18N
        Menu_SAIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_SAIRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu_SAIRMouseEntered(evt);
            }
        });
        jMenuBar1.add(Menu_SAIR);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu_SAIRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_SAIRMouseClicked
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja Sair Realmente?", "Sair",JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {  
                        System.exit(0);  
                    }
    }//GEN-LAST:event_Menu_SAIRMouseClicked

    private void Menu_SAIRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_SAIRMouseEntered
             Menu_SAIR.setToolTipText("Sair");
    }//GEN-LAST:event_Menu_SAIRMouseEntered

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Padrao_JTattoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Padrao_JTattoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Padrao_JTattoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Padrao_JTattoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MENU_EXCLUIR;
    private javax.swing.JMenu MENU_PE;
    private javax.swing.JMenu MENU_PESQUISAR;
    private javax.swing.JMenu MENU_SALVAR;
    private javax.swing.JMenu Menu_SAIR;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
