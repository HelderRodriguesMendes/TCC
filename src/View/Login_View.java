package View;

import Controller.Login_Controller;
import Controller.Util_Controller;
import DAO.AdministradorDAO;
import Model.Administrador;
import Model.Sindicalizado;
import com.sun.glass.events.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public class Login_View extends javax.swing.JFrame {

    boolean adm;
    Administrador ad = new Administrador();
    Sindicalizado si = new Sindicalizado();
    AdministradorDAO ld = new AdministradorDAO();

    public Login_View() {
        this.setTitle("LOGIN DE ACESSO");
        initComponents();
        setResizable(false);
        Util_Controller.inserirIcone(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BOTAO_ENTRAR = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TXT_LOGIN = new javax.swing.JTextField();
        TXT_SENHA = new javax.swing.JPasswordField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");

        jPanel4.setBackground(new java.awt.Color(0, 204, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/BLOQUIADO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/oie_11598YG1QSGOk (2).png"))); // NOI18N

        BOTAO_ENTRAR.setText("Entrar");
        BOTAO_ENTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_ENTRARActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/USER_1 - Copia.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/password - Copia.png"))); // NOI18N

        TXT_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_LOGINActionPerformed(evt);
            }
        });

        TXT_SENHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_SENHAKeyPressed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 0));
        jLabel76.setText("*");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 0));
        jLabel77.setText("*");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel4)
                                        .addGap(3, 3, 3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TXT_SENHA)
                                    .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(BOTAO_ENTRAR))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel76)))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(BOTAO_ENTRAR)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_ENTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_ENTRARActionPerformed

        if ("".equals(TXT_LOGIN.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o login de acesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            TXT_LOGIN.requestFocus();
        } else if ("".equals(TXT_SENHA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a senha", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            TXT_SENHA.requestFocus();
        } else {
            ad.setLogin(TXT_LOGIN.getText());

            if ("hrm".equals(ad.getLogin())) {
                ad.setSenha(TXT_SENHA.getText());
            } else {
                ad.setSenha(Login_Controller.criptografar_senha(TXT_SENHA.getText()));
            }
            Administrador adi;
            adi = ld.logarAdmin(ad);
            if (adi.getId() > 0 && !adi.getExcluido()) {
                abrirInterface(adi);
            }else if(adi.getExcluido()){
                JOptionPane.showMessageDialog(null, "Este administrador está excluido do sistema" , "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BOTAO_ENTRARActionPerformed

    private void TXT_SENHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_SENHAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ad.setLogin(TXT_LOGIN.getText());

            if ("hrm".equals(ad.getLogin())) {
                ad.setSenha(TXT_SENHA.getText());
            } else {
                ad.setSenha(Login_Controller.criptografar_senha(TXT_SENHA.getText()));
            }
            Administrador adi;
            adi = ld.logarAdmin(ad);
            if (adi.getId() > 0) {
                abrirInterface(adi);
            }
        }// evento quando o ENTER é apertado
    }//GEN-LAST:event_TXT_SENHAKeyPressed

    private void TXT_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_LOGINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_LOGINActionPerformed

    public void abrirInterface(Administrador ad) {
        Interface_View in = new Interface_View();
        in.setVisible(true);
        in.ID = ad.getId();
        in.setExtendedState(JFrame.MAXIMIZED_BOTH);
        in.show();
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            /* Create and display the form */
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login_View.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTAO_ENTRAR;
    private javax.swing.JTextField TXT_LOGIN;
    private javax.swing.JPasswordField TXT_SENHA;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
