/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login;
import Controller.Receptor;
import Model.DAO.AdministradorDAO;
import Model.Entidadades.Administrador_Entidade;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public abstract class Cad_Administrador extends javax.swing.JInternalFrame implements Receptor {

    Administrador_Entidade usu = new Administrador_Entidade();
    Login l = new Login();
    String senha = "", senhaC = "";
    boolean alterar = false, login = true;
    int id = 0, cont = 0;

    public Cad_Administrador() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Administrador_Entidade preencher_objeto() {
        usu.setNome(TXTNOME.getText());
        usu.setTelefone(TXTFONE.getText());
        usu.setTipo_usuario("Administrador");
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
            }
        } else {
            v = true;
        }
        return v;
    }

    public void limparCampus() {
        TXTNOME.setText("");
        TXTFONE.setText("");
        TXTLOGIN.setText("");
        TXTSENHA.setText("");
    }

    public void preencherCampus(Administrador_Entidade adm) {
        TXTNOME.setText(adm.getNome());
        TXTFONE.setText(adm.getTelefone());
        TXTLOGIN.setText(adm.getLogin());
        this.id = adm.getId();
        alterar = true;
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BOTAO_SALVAR_ = new javax.swing.JLabel();
        BT_ATU = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Cadastrar Administrador");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(TXTSENHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 163, 160, -1));

        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, -1, -1));

        jLabel3.setText("Login:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, -1, -1));

        jLabel2.setText("Telefone:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, -1, -1));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, -1, -1));

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
        getContentPane().add(TXTLOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 118, 160, -1));

        try {
            TXTFONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - #### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(TXTFONE, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 78, 150, -1));
        getContentPane().add(TXTNOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 38, 160, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        jLabel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel6KeyTyped(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 38, 139, 145));

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
        });
        getContentPane().add(BOTAO_SALVAR_, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 201, -1, -1));

        BT_ATU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        BT_ATU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ATUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BT_ATUMouseEntered(evt);
            }
        });
        getContentPane().add(BT_ATU, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 201, 31, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 41, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 166, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("*");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel10.setVerifyInputWhenFocusTarget(false);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 121, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTSENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTSENHAActionPerformed

    }//GEN-LAST:event_TXTSENHAActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
                    if (login) {
                        limparCampus();
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
                            Pesquisar_Alterar_Admin paa = new Pesquisar_Alterar_Admin();
                            paa.setVisible(true);
                            Interface.DESKTOP.add(paa);
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
                                Pesquisar_Alterar_Admin paa = new Pesquisar_Alterar_Admin();
                                paa.setVisible(true);
                                Interface.DESKTOP.add(paa);
                                paa.setPosicao();
                                this.dispose();
                            } else {
                                TXTLOGIN.setText("");
                                TXTLOGIN.requestFocus();
                            }
                        } else {
                            validacao();
                        }
                    }
                } else {
                    login = ud.alterar_ADMIN(preencher_objeto(), this.id);
                    if (login) {
                        Pesquisar_Alterar_Admin paa = new Pesquisar_Alterar_Admin();
                        paa.setVisible(true);
                        Interface.DESKTOP.add(paa);
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
        limparCampus();
    }//GEN-LAST:event_BT_ATUMouseClicked

    private void TXTSENHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTSENHAKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean v;

            v = validacao();

            if (v) {
                AdministradorDAO ud = new AdministradorDAO();
                ud.salvar_ADMIN(preencher_objeto());
                limparCampus();
            }
        }// evento quando o ENTER é apertado

    }//GEN-LAST:event_TXTSENHAKeyPressed

    private void TXTSENHAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXTSENHAMouseClicked

        if (evt.getSource() == TXTSENHA) {
            //System.out.println("ganho foco");

            Alterar_senha as = new Alterar_senha(this);
            Interface.DESKTOP.add(as);
            as.setVisible(true);
            as.setPosicao();
            cont = 1;

        }


    }//GEN-LAST:event_TXTSENHAMouseClicked

    private void TXTLOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTLOGINKeyPressed

    }//GEN-LAST:event_TXTLOGINKeyPressed

    private void jLabel6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel6KeyTyped

    }//GEN-LAST:event_jLabel6KeyTyped

    private void TXTSENHAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTSENHAFocusGained
        if (!"".equals(TXTLOGIN.getText())) {
            if (evt.getSource() == TXTSENHA) {
                //System.out.println("ganho foco");

                Alterar_senha as = new Alterar_senha(this);
                Interface.DESKTOP.add(as);
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
        if (evt.getSource() == BOTAO_SALVAR_) {
            boolean v, t;
            AdministradorDAO ud = new AdministradorDAO();
            v = validacao();

            if (v) {
                if (!alterar) {
                    if ("".equals(preencher_objeto().getSenha()) && cont == 1 && "".equals(TXTSENHA.getText())) {
                        validacao();
                    } else {
                        t = ud.salvar_ADMIN(preencher_objeto());
                        if (!t) {
                            limparCampus();
                        } else {
                            TXTLOGIN.setText("");
                        }
                    }
                } else {
                    if ("".equals(preencher_objeto().getSenha())) {
                        if (cont != 1) {
                            ud.alterar_ADMIN(preencher_objeto(), this.id);
                            limparCampus();
                        } else {
                            validacao();
                        }
                    } else {
                        ud.alterar_ADMIN(preencher_objeto(), this.id);
                        limparCampus();
                    }
                }
            }
        }
    }//GEN-LAST:event_BOTAO_SALVAR_FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BOTAO_SALVAR_;
    private javax.swing.JLabel BT_ATU;
    private javax.swing.JFormattedTextField TXTFONE;
    private javax.swing.JTextField TXTLOGIN;
    private javax.swing.JTextField TXTNOME;
    private javax.swing.JTextField TXTSENHA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
