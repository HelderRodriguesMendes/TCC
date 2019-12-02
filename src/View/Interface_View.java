/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.Sindicalizado_DAO;
import DAO.Util_DAO;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public class Interface_View extends javax.swing.JFrame {

    public int ID = 0;
    Sindicalizado_DAO dsp = new Sindicalizado_DAO();

    public Interface_View() {
        initComponents();

        addWindowListener(new WindowAdapter() { // para confirna se deseja ralmente sair do sistema
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja realmente sair do sistema?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    retornarLogin();
                }
            }
        });

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

        BARRAMENU.setLayout(new GridBagLayout());

    }

    public void retornarLogin() {
        Login_View tl = new Login_View();
        tl.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        DESKTOP = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        BARRAMENU = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MENU_SALVAR = new javax.swing.JMenu();
        MENU_CAD_USU = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        CONTROLE_CAIXA_ = new javax.swing.JMenuItem();
        MENU_CAD_SIND = new javax.swing.JMenuItem();
        MENU_PE = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        ANUIDADE_ALRERAR = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MENU_EXCLUIR = new javax.swing.JMenu();
        EXCLUIR_ADMIN_ = new javax.swing.JMenuItem();
        EXCLUIR_CONTROLE_CAIXA_ = new javax.swing.JMenuItem();
        EXCLUIR_SIND_ = new javax.swing.JMenuItem();
        RESTAURAR_ = new javax.swing.JMenuItem();
        MENU_RELA = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Página Inicial");

        DESKTOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DESKTOPMouseEntered(evt);
            }
        });
        DESKTOP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DESKTOPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout DESKTOPLayout = new javax.swing.GroupLayout(DESKTOP);
        DESKTOP.setLayout(DESKTOPLayout);
        DESKTOPLayout.setHorizontalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1267, Short.MAX_VALUE)
        );
        DESKTOPLayout.setVerticalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoSiteMenu.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        BARRAMENU.add(jMenu2);

        MENU_SALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/SALVAR 2.png"))); // NOI18N
        MENU_SALVAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_SALVARMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MENU_SALVARMouseExited(evt);
            }
        });

        MENU_CAD_USU.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        MENU_CAD_USU.setText("Administrador");
        MENU_CAD_USU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MENU_CAD_USUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_CAD_USUMouseEntered(evt);
            }
        });
        MENU_CAD_USU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_CAD_USUActionPerformed(evt);
            }
        });
        MENU_SALVAR.add(MENU_CAD_USU);

        jMenuItem5.setText("Anuidade");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MENU_SALVAR.add(jMenuItem5);

        CONTROLE_CAIXA_.setText("Controle de Caixa");
        CONTROLE_CAIXA_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTROLE_CAIXA_ActionPerformed(evt);
            }
        });
        MENU_SALVAR.add(CONTROLE_CAIXA_);

        MENU_CAD_SIND.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        MENU_CAD_SIND.setText("Sindicalizado");
        MENU_CAD_SIND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MENU_CAD_SINDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_CAD_SINDMouseEntered(evt);
            }
        });
        MENU_CAD_SIND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_CAD_SINDActionPerformed(evt);
            }
        });
        MENU_SALVAR.add(MENU_CAD_SIND);

        BARRAMENU.add(MENU_SALVAR);

        MENU_PE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar_editar.png"))); // NOI18N
        MENU_PE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_PEMouseEntered(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Administrador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MENU_PE.add(jMenuItem1);

        ANUIDADE_ALRERAR.setText("Anuidade");
        ANUIDADE_ALRERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANUIDADE_ALRERARActionPerformed(evt);
            }
        });
        MENU_PE.add(ANUIDADE_ALRERAR);

        jMenuItem4.setText("Controle de Caixa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MENU_PE.add(jMenuItem4);

        jMenuItem2.setText("Sindicalizado");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MENU_PE.add(jMenuItem2);

        BARRAMENU.add(MENU_PE);

        MENU_EXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ESCLUIR 2.png"))); // NOI18N
        MENU_EXCLUIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_EXCLUIRMouseEntered(evt);
            }
        });

        EXCLUIR_ADMIN_.setText("Administrador");
        EXCLUIR_ADMIN_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXCLUIR_ADMIN_ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(EXCLUIR_ADMIN_);

        EXCLUIR_CONTROLE_CAIXA_.setText("Controle de Caixa");
        EXCLUIR_CONTROLE_CAIXA_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXCLUIR_CONTROLE_CAIXA_ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(EXCLUIR_CONTROLE_CAIXA_);

        EXCLUIR_SIND_.setText("Sindicalizado");
        EXCLUIR_SIND_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXCLUIR_SIND_ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(EXCLUIR_SIND_);

        RESTAURAR_.setText("Restaurar");
        RESTAURAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESTAURAR_ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(RESTAURAR_);

        BARRAMENU.add(MENU_EXCLUIR);

        MENU_RELA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatório.png"))); // NOI18N
        MENU_RELA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_RELAMouseEntered(evt);
            }
        });

        jMenuItem7.setText("Controde de caixa");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MENU_RELA.add(jMenuItem7);

        jMenuItem8.setText("Sindicalizado");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        MENU_RELA.add(jMenuItem8);

        BARRAMENU.add(MENU_RELA);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/siraICO.png"))); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        BARRAMENU.add(jMenu7);

        setJMenuBar(BARRAMENU);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DESKTOP)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DESKTOP)
        );

        setSize(new java.awt.Dimension(1307, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MENU_CAD_USUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_CAD_USUActionPerformed
        Administrador_View ca = new Administrador_View() {
        };
        Interface_View.DESKTOP.add(ca);
        ca.setTitle("Cadastrar Administrador");
        ca.setVisible(true);
        ca.setPosicao();
    }//GEN-LAST:event_MENU_CAD_USUActionPerformed

    private void MENU_CAD_USUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_USUMouseEntered

    }//GEN-LAST:event_MENU_CAD_USUMouseEntered

    private void MENU_CAD_USUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_USUMouseClicked

    }//GEN-LAST:event_MENU_CAD_USUMouseClicked

    private void MENU_SALVARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_SALVARMouseEntered
        MENU_SALVAR.setToolTipText("Cadastrar");
    }//GEN-LAST:event_MENU_SALVARMouseEntered

    private void MENU_CAD_SINDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDActionPerformed
        Sindicalizado_View cs = new Sindicalizado_View() {
        };
        DESKTOP.add(cs);
        cs.setTitle("Cadastrar Sindicalizado");
        cs.status = "cadastrar";
        cs.selecionar_guia(1);
        cs.setVisible(true);
        cs.setPosicao();
    }//GEN-LAST:event_MENU_CAD_SINDActionPerformed

    private void MENU_CAD_SINDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseEntered
        MENU_CAD_SIND.setToolTipText("Cadastrar sindicalizado");
    }//GEN-LAST:event_MENU_CAD_SINDMouseEntered

    private void MENU_CAD_SINDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseClicked

    }//GEN-LAST:event_MENU_CAD_SINDMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Pesquisar_Alterar_Admin_View paa = new Pesquisar_Alterar_Admin_View();
        DESKTOP.add(paa);
        paa.setTitle("Consultar e Alterar Administrador");
        paa.setVisible(true);
        paa.setPosicao();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Sindicalizado_View pas = new Sindicalizado_View();
        DESKTOP.add(pas);
        pas.setTitle("Consultar e alterar Sindicalizado");
        pas.status = "alterar";
        pas.selecionar_guia(0);
        pas.setVisible(true);
        pas.setPosicao();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void EXCLUIR_SIND_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXCLUIR_SIND_ActionPerformed
        Sindicalizado_View pas = new Sindicalizado_View();
        DESKTOP.add(pas);
        pas.setTitle("Consultar e Excluir Sindicalizado");
        pas.setVisible(true);
        pas.setPosicao();
        pas.status = "excluir";
    }//GEN-LAST:event_EXCLUIR_SIND_ActionPerformed

    private void EXCLUIR_ADMIN_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXCLUIR_ADMIN_ActionPerformed
        Pesquisar_Alterar_Admin_View caa = new Pesquisar_Alterar_Admin_View() {
        };
        DESKTOP.add(caa);
        caa.setTitle("Consultar e Excluir Administrador");
        caa.setVisible(true);
        caa.setPosicao();
        caa.excluir = true;

    }//GEN-LAST:event_EXCLUIR_ADMIN_ActionPerformed

    private void MENU_SALVARMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_SALVARMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MENU_SALVARMouseExited

    private void DESKTOPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DESKTOPMouseEntered
        boolean n = dsp.niver;
        if (n) {
            dsp.anivarsario();
        }
    }//GEN-LAST:event_DESKTOPMouseEntered

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Login_View tl = new Login_View();
        tl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Util_DAO ud = new Util_DAO();
        ud.Acessar_Facebook();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void RESTAURAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESTAURAR_ActionPerformed
        Restaurar_View r = new Restaurar_View();
        DESKTOP.add(r);
        r.setVisible(true);
        r.setPosicao();
    }//GEN-LAST:event_RESTAURAR_ActionPerformed

    private void MENU_PEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_PEMouseEntered
        MENU_PE.setToolTipText("Pesquisar e Alterar");
    }//GEN-LAST:event_MENU_PEMouseEntered

    private void MENU_EXCLUIRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_EXCLUIRMouseEntered
        MENU_EXCLUIR.setToolTipText("Excluir");
    }//GEN-LAST:event_MENU_EXCLUIRMouseEntered

    private void MENU_RELAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_RELAMouseEntered
        MENU_RELA.setToolTipText("Relatórios");
    }//GEN-LAST:event_MENU_RELAMouseEntered

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Sindicalizado_View pas = new Sindicalizado_View();
        DESKTOP.add(pas);
        pas.setTitle("Consultar e Gerar Relatório de Sindicalizado");
        pas.setVisible(true);
        pas.setPosicao();
        pas.status = "contrato";
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void DESKTOPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DESKTOPKeyReleased
        boolean n = dsp.niver;
        if (n) {
            dsp.anivarsario();
        }
    }//GEN-LAST:event_DESKTOPKeyReleased

    private void CONTROLE_CAIXA_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTROLE_CAIXA_ActionPerformed
        ControleCaixa_VIEW CC = new ControleCaixa_VIEW();
        DESKTOP.add(CC);
        CC.setVisible(true);
        CC.status = "cadastrar";
        CC.setPosicao();
        CC.selecionar_guia(0);

    }//GEN-LAST:event_CONTROLE_CAIXA_ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ControleCaixa_VIEW CC = new ControleCaixa_VIEW();
        DESKTOP.add(CC);
        CC.setVisible(true);
        CC.status = "alterar";
        CC.setPosicao();
        CC.selecionar_guia(1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void EXCLUIR_CONTROLE_CAIXA_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXCLUIR_CONTROLE_CAIXA_ActionPerformed
        ControleCaixa_VIEW CC = new ControleCaixa_VIEW();
        DESKTOP.add(CC);
        CC.setVisible(true);
        CC.status = "excluir";
        CC.setPosicao();
        CC.selecionar_guia(1);
    }//GEN-LAST:event_EXCLUIR_CONTROLE_CAIXA_ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Anuidade_View av = new Anuidade_View();
        DESKTOP.add(av);
        av.setVisible(true);
        av.setPosicao();
        av.status = "cadastrar";
        av.selecionar_guia(0);
        av.verificaCadastro("cadastrar");
        av.setTitle("Cadastrar Dados Anuais");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ANUIDADE_ALRERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANUIDADE_ALRERARActionPerformed
        Anuidade_View av = new Anuidade_View();
        DESKTOP.add(av);
        av.setVisible(true);
        av.setPosicao();
        av.status = "alterar";
        av.selecionar_guia(0);
        av.verificaCadastro("alterar");
        av.setTitle("Consultar/Alterar/Gerar Anuidades");
    }//GEN-LAST:event_ANUIDADE_ALRERARActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ControleCaixa_VIEW CC = new ControleCaixa_VIEW();
        DESKTOP.add(CC);
        CC.setTitle("Controle de Caixa - Gerar Relatório");
        CC.setVisible(true);
        CC.status = "relatorio";
        CC.setPosicao();
        CC.selecionar_guia(1);
        CC.DATA2.setEnabled(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ANUIDADE_ALRERAR;
    private javax.swing.JMenuBar BARRAMENU;
    private javax.swing.JMenuItem CONTROLE_CAIXA_;
    public static javax.swing.JDesktopPane DESKTOP;
    private javax.swing.JMenuItem EXCLUIR_ADMIN_;
    private javax.swing.JMenuItem EXCLUIR_CONTROLE_CAIXA_;
    private javax.swing.JMenuItem EXCLUIR_SIND_;
    private javax.swing.JMenuItem MENU_CAD_SIND;
    private javax.swing.JMenuItem MENU_CAD_USU;
    private javax.swing.JMenu MENU_EXCLUIR;
    private javax.swing.JMenu MENU_PE;
    private javax.swing.JMenu MENU_RELA;
    private javax.swing.JMenu MENU_SALVAR;
    private javax.swing.JMenuItem RESTAURAR_;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
