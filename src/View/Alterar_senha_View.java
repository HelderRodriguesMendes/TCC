/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login_Controller;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Controller.Receptor_Controller;

/**
 *
 * @author helde
 */
public class Alterar_senha_View extends javax.swing.JInternalFrame {

    Login_Controller lo = new Login_Controller();
    public String senhaC = "", senha = "";
    Receptor_Controller rec;

    public Alterar_senha_View(Receptor_Controller rec) {
        initComponents();
        this.rec = rec;
        NOVA_SENHA.requestFocus();
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Alterar_senha_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Alterar_senha_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Alterar_senha_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Alterar_senha_View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TXT_NovaSenha = new javax.swing.JLabel();
        TXT_CONFIR_SENHA = new javax.swing.JLabel();
        NOVA_SENHA = new javax.swing.JPasswordField();
        CONFIR_SENHA = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Alterar senha");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TXT_NovaSenha.setText("Nova senha:");

        TXT_CONFIR_SENHA.setText("Confirma senha:");

        CONFIR_SENHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CONFIR_SENHAKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NOVA_SENHA)
                    .addComponent(CONFIR_SENHA))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_CONFIR_SENHA)
                    .addComponent(TXT_NovaSenha))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TXT_NovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NOVA_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TXT_CONFIR_SENHA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CONFIR_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validarcampus()) {
            senhaC = lo.validar_nova_senha(NOVA_SENHA.getText(), CONFIR_SENHA.getText());
            this.senha = lo.senha;
            rec.receber(senhaC, senha);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CONFIR_SENHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONFIR_SENHAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (validarcampus()) {
                senhaC = lo.validar_nova_senha(NOVA_SENHA.getText(), CONFIR_SENHA.getText());
                this.senha = lo.senha;
                rec.receber(senhaC, senha);
                this.dispose();
            }
        }
    }//GEN-LAST:event_CONFIR_SENHAKeyPressed

    public boolean validarcampus() {
        boolean v = false;
        if ("".equals(NOVA_SENHA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a senha", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            NOVA_SENHA.requestFocus();
        } else if ("".equals(CONFIR_SENHA.getText())) {
            JOptionPane.showMessageDialog(null, "Confirme a senha escolhida", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            CONFIR_SENHA.requestFocus();
        } else {
            v = true;
        }
        return v;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CONFIR_SENHA;
    private javax.swing.JPasswordField NOVA_SENHA;
    private javax.swing.JLabel TXT_CONFIR_SENHA;
    private javax.swing.JLabel TXT_NovaSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
