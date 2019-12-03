/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login_Controller;
import Controller.Util_Controller;
import DAO.AdministradorDAO;
import Model.Administrador;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Controller.Receptor_Controller;

/**
 *
 * @author helde
 */
public abstract class Administrador_View extends javax.swing.JInternalFrame implements Receptor_Controller {

    Administrador usu = new Administrador();
    Login_Controller l = new Login_Controller();
    String senha = "", senhaC = "";
    boolean alterar = false, login = true;
    int id = 0, cont = 0;

    public Administrador_View() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Interface_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Interface_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Interface_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Interface_View.class.getName()).log(Level.SEVERE, null, ex);
        }
        VOLTAR.setVisible(false);
        Util_Controller.soLetras(TXTNOME);
    }

    public Administrador preencher_objeto() {
        usu.setNome(TXTNOME.getText());
        usu.setCelular(TXTFONE.getText());
        usu.setLogin(TXTLOGIN.getText());
        if (alterar) {
            usu.setId(this.id);
            if (cont == 1) {
                if (TXTSENHA.getText().equals(senha)) {
                    usu.setSenha(senhaC);
                } else {
                    TXTSENHA.setText("");
                    usu.setSenha("");
                }
            } else {
                usu.setSenha("");
            }
        } else {
            if (TXTSENHA.getText().equals(this.senha)) {
                usu.setSenha(senhaC);
            } else {
                TXTSENHA.setText("");
                usu.setSenha("");
            }
            usu.setExcluido(false);
        }

        return usu;
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public boolean validacao() {
        boolean v = false;

        if ("".equals(TXTNOME.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o NOME", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            TXTNOME.requestFocus();
        } else if ("".equals(TXTLOGIN.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o LOGIN", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            TXTLOGIN.requestFocus();
        } else if (!alterar) {
            if ("".equals(TXTSENHA.getText())) {
                JOptionPane.showMessageDialog(null, "Informe a SENHA", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                TXTSENHA.requestFocus();
            } else {
                v = true;
            }
        } else if (cont == 5) {
            if ("".equals(TXTSENHA.getText())) {
                JOptionPane.showMessageDialog(null, "Informe a SENHA", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                TXTSENHA.requestFocus();
            }
        } else {
            v = true;
        }
        return v;
    }

    public void limparCampos() {
        TXTNOME.setText("");
        TXTFONE.setText("");
        TXTLOGIN.setText("");
        TXTSENHA.setText("");
    }

    public void preencherCampus(Administrador adm) {
        TXTNOME.setText(adm.getNome());
        TXTFONE.setText(adm.getCelular());
        TXTLOGIN.setText(adm.getLogin());
        this.id = adm.getId();
        alterar = true;
        VOLTAR.setVisible(true);
    }

    @Override
    public void receber(String senhaC, String senha) {
        TXTSENHA.setText(senha);
        this.senha = senha;
        this.senhaC = senhaC;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TXTSENHA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TXTLOGIN = new javax.swing.JTextField();
        TXTFONE = new javax.swing.JFormattedTextField();
        TXTNOME = new javax.swing.JTextField();
        BOTAO_SALVAR_ = new javax.swing.JLabel();
        BT_ATU = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        VOLTAR = new javax.swing.JLabel();
        USO = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        TXTSENHA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTSENHAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTSENHAFocusLost(evt);
            }
        });
        TXTSENHA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXTSENHAMouseClicked(evt);
            }
        });
        TXTSENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTSENHAActionPerformed(evt);
            }
        });
        TXTSENHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXTSENHAKeyPressed(evt);
            }
        });

        jLabel4.setText("Senha:");

        jLabel3.setText("Login:");

        jLabel2.setText("Telefone:");

        jLabel1.setText("Nome:");

        TXTLOGIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTLOGINFocusLost(evt);
            }
        });
        TXTLOGIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXTLOGINKeyPressed(evt);
            }
        });

        try {
            TXTFONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - #### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BOTAO_SALVAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        BOTAO_SALVAR_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BOTAO_SALVAR_FocusGained(evt);
            }
        });
        BOTAO_SALVAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_SALVAR_MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BOTAO_SALVAR_MouseEntered(evt);
            }
        });

        BT_ATU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        BT_ATU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ATUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BT_ATUMouseEntered(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("*");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel10.setVerifyInputWhenFocusTarget(false);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        VOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        VOLTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VOLTARMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(USO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTNOME, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addGap(4, 4, 4)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TXTFONE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TXTLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXTSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(63, 63, 63))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(BOTAO_SALVAR_)
                        .addGap(35, 35, 35)
                        .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel9))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTFONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel10)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9)))
                        .addGap(29, 29, 29)
                        .addComponent(BOTAO_SALVAR_))
                    .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTSENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTSENHAActionPerformed

    }//GEN-LAST:event_TXTSENHAActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void BT_ATUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseEntered
        BT_ATU.setToolTipText("Limpar campus");
    }//GEN-LAST:event_BT_ATUMouseEntered

    private void BOTAO_SALVAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVAR_MouseClicked
        boolean v;
        AdministradorDAO ud = new AdministradorDAO();
        v = validacao();

        if (v) {
            if (!alterar) {
                if ("".equals(preencher_objeto().getSenha()) && cont == 1 && "".equals(TXTSENHA.getText())) {
                    validacao();
                } else {
                    login = ud.salvar_ADMIN(preencher_objeto());
                    if (!login) {
                        limparCampos();
                        TXTNOME.requestFocus();
                    } else {
                        TXTLOGIN.setText("");
                        TXTLOGIN.requestFocus();
                    }
                }
            } else {
                if ("".equals(preencher_objeto().getSenha())) {
                    if (cont != 1) {        // NÃO CLICOU PARA ALTERAR SENHA
                        login = ud.alterar_ADMIN(preencher_objeto(), this.id);
                        if (login) {
                            Pesquisar_Alterar_Admin_View paa = new Pesquisar_Alterar_Admin_View();
                            paa.setVisible(true);
                            Interface_View.DESKTOP.add(paa);
                            paa.setPosicao();
                            this.dispose();
                        } else {
                            TXTLOGIN.setText("");
                            TXTLOGIN.requestFocus();
                        }
                    } else {
                        String ObjButtons[] = {"Sim", "Não"};
                        int PromptResult = JOptionPane.showOptionDialog(null,
                                "Tem certeza que não deseja alterar a senha?", "ATENÇÃO",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                ObjButtons, ObjButtons[1]);
                        if (PromptResult == 0) {
                            login = ud.alterar_ADMIN(preencher_objeto(), this.id);
                            if (login) {
                                Pesquisar_Alterar_Admin_View paa = new Pesquisar_Alterar_Admin_View();
                                paa.setVisible(true);
                                Interface_View.DESKTOP.add(paa);
                                paa.setPosicao();
                                this.dispose();
                            } else {
                                TXTLOGIN.setText("");
                                TXTLOGIN.requestFocus();
                            }
                        } else if (PromptResult == 1) {
                            cont = 5;
                            validacao();
                        }
                    }
                } else {
                    login = ud.alterar_ADMIN(preencher_objeto(), this.id);
                    if (login) {
                        Pesquisar_Alterar_Admin_View paa = new Pesquisar_Alterar_Admin_View();
                        paa.setVisible(true);
                        Interface_View.DESKTOP.add(paa);
                        paa.setPosicao();
                        this.dispose();
                    } else {
                        TXTLOGIN.setText("");
                        TXTLOGIN.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_BOTAO_SALVAR_MouseClicked

    private void BT_ATUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseClicked
        limparCampos();
    }//GEN-LAST:event_BT_ATUMouseClicked

    private void TXTSENHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTSENHAKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean v;

            v = validacao();

            if (v) {
                AdministradorDAO ud = new AdministradorDAO();
                login = ud.salvar_ADMIN(preencher_objeto());
                if (!login) {
                    limparCampos();
                    TXTNOME.requestFocus();
                } else {
                    TXTLOGIN.setText("");
                    TXTLOGIN.requestFocus();
                }
            }
        }// evento quando o ENTER é apertado

    }//GEN-LAST:event_TXTSENHAKeyPressed

    private void TXTSENHAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXTSENHAMouseClicked

        if (evt.getSource() == TXTSENHA) {
            //System.out.println("ganho foco");

            Alterar_senha_View as = new Alterar_senha_View(this);
            Interface_View.DESKTOP.add(as);
            as.setVisible(true);
            as.setPosicao();
            cont = 1;

        }


    }//GEN-LAST:event_TXTSENHAMouseClicked

    private void TXTLOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTLOGINKeyPressed

    }//GEN-LAST:event_TXTLOGINKeyPressed

    private void TXTSENHAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTSENHAFocusGained
        if (!"".equals(TXTLOGIN.getText())) {
            if (evt.getSource() == TXTSENHA) {
                //System.out.println("ganho foco");

                Alterar_senha_View as = new Alterar_senha_View(this);
                Interface_View.DESKTOP.add(as);
                as.setVisible(true);
                as.setPosicao();
                cont = 1;
                TXTNOME.requestFocus();
            }
        }

    }//GEN-LAST:event_TXTSENHAFocusGained

    private void TXTSENHAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTSENHAFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTSENHAFocusLost

    private void TXTLOGINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTLOGINFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTLOGINFocusLost

    private void BOTAO_SALVAR_FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BOTAO_SALVAR_FocusGained

    }//GEN-LAST:event_BOTAO_SALVAR_FocusGained

    private void BOTAO_SALVAR_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVAR_MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BOTAO_SALVAR_MouseEntered

    private void VOLTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VOLTARMouseClicked
        Pesquisar_Alterar_Admin_View paa = new Pesquisar_Alterar_Admin_View();
        Interface_View.DESKTOP.add(paa);
        paa.setVisible(true);
        paa.setPosicao();
        this.dispose();
    }//GEN-LAST:event_VOLTARMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BOTAO_SALVAR_;
    private javax.swing.JLabel BT_ATU;
    private javax.swing.JFormattedTextField TXTFONE;
    private javax.swing.JTextField TXTLOGIN;
    private javax.swing.JTextField TXTNOME;
    private javax.swing.JTextField TXTSENHA;
    private javax.swing.JLabel USO;
    private javax.swing.JLabel VOLTAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
