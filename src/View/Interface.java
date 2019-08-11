/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.Sindicalizado_DAO;
import DAO.Util_DAO;
import Model.Administrador_Entidade;
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
public class Interface extends javax.swing.JFrame {

    public int ID = 0;
    Sindicalizado_DAO sd = new Sindicalizado_DAO();

    public Interface() {
        initComponents();

        addWindowListener(new WindowAdapter() { // para confirna se deseja ralmente sair do sistema
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja realmente sair do sistema?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[0]);
                if (PromptResult == 0) {
                    retornarLogin();
                }
            }
        });

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

        BARRAMENU.setLayout(new GridBagLayout());

    }

    public void retornarLogin() {
        Tela_Login tl = new Tela_Login();
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
        BARRAMENU = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MENU_SALVAR = new javax.swing.JMenu();
        MENU_CAD_USU = new javax.swing.JMenuItem();
        MENU_CAD_SIND = new javax.swing.JMenuItem();
        MENU_PE = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MENU_EXCLUIR = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        DESKTOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DESKTOPMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout DESKTOPLayout = new javax.swing.GroupLayout(DESKTOP);
        DESKTOP.setLayout(DESKTOPLayout);
        DESKTOPLayout.setHorizontalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
        );
        DESKTOPLayout.setVerticalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Administrador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MENU_PE.add(jMenuItem1);

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

        jMenuItem4.setText("Administrador");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(jMenuItem4);

        jMenuItem5.setText("Sindicalizado");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(jMenuItem5);

        jMenuItem7.setText("Restaurar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MENU_EXCLUIR.add(jMenuItem7);

        BARRAMENU.add(MENU_EXCLUIR);

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
            .addComponent(DESKTOP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DESKTOP)
        );

        setSize(new java.awt.Dimension(1308, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MENU_CAD_USUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_CAD_USUActionPerformed
        Cad_Administrador ca = new Cad_Administrador() {
        };
        Interface.DESKTOP.add(ca);
        ca.setTitle("Cadastrar Administrador");
        ca.setVisible(true);
        ca.setPosicao();
    }//GEN-LAST:event_MENU_CAD_USUActionPerformed

    private void MENU_CAD_USUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_USUMouseEntered
        MENU_CAD_USU.setToolTipText("Cadastrar usuário");
    }//GEN-LAST:event_MENU_CAD_USUMouseEntered

    private void MENU_CAD_USUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_USUMouseClicked

    }//GEN-LAST:event_MENU_CAD_USUMouseClicked

    private void MENU_SALVARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_SALVARMouseEntered
        MENU_SALVAR.setToolTipText("Cadastrar");
    }//GEN-LAST:event_MENU_SALVARMouseEntered

    private void MENU_CAD_SINDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDActionPerformed
        Cadastrar_Sindicalizado cs = new Cadastrar_Sindicalizado() {
        };       
        DESKTOP.add(cs);
        cs.setTitle("Cadastrar Sindicalizado");
        cs.setVisible(true);
        cs.setPosicao();
    }//GEN-LAST:event_MENU_CAD_SINDActionPerformed

    private void MENU_CAD_SINDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseEntered
        MENU_CAD_SIND.setToolTipText("Cadastrar sindicalizado");
    }//GEN-LAST:event_MENU_CAD_SINDMouseEntered

    private void MENU_CAD_SINDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseClicked

    }//GEN-LAST:event_MENU_CAD_SINDMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Pesquisar_Alterar_Admin paa = new Pesquisar_Alterar_Admin();
        DESKTOP.add(paa);
        paa.setTitle("Consultar e Alterar Administrador");
        paa.setVisible(true);
        paa.setPosicao();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
        DESKTOP.add(pas);
        pas.setTitle("Consultar e Alterar Sindicalizado");
        pas.setVisible(true);
        pas.setPosicao();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
        DESKTOP.add(pas);
        pas.setTitle("Consultar e Excluir Sindicalizado");
        pas.setVisible(true);
        pas.setPosicao();
        pas.uso = "excluir";
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Pesquisar_Alterar_Admin caa = new Pesquisar_Alterar_Admin() {
        };
        DESKTOP.add(caa);
        caa.setTitle("Consultar e Excluir Administrador");
        caa.setVisible(true);
        caa.setPosicao();
        caa.excluir = true;

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void MENU_SALVARMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_SALVARMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MENU_SALVARMouseExited

    private void DESKTOPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DESKTOPMouseEntered
        boolean n = sd.niver;
        if (n) {
            sd.niver();
        }
    }//GEN-LAST:event_DESKTOPMouseEntered

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Tela_Login tl = new Tela_Login();
        tl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Util_DAO ud = new Util_DAO();
        ud.Acessar_Facebook();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Restaurar r = new Restaurar();
        DESKTOP.add(r);
        r.setVisible(true);
        r.setPosicao();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BARRAMENU;
    public static javax.swing.JDesktopPane DESKTOP;
    private javax.swing.JMenuItem MENU_CAD_SIND;
    private javax.swing.JMenuItem MENU_CAD_USU;
    private javax.swing.JMenu MENU_EXCLUIR;
    private javax.swing.JMenu MENU_PE;
    private javax.swing.JMenu MENU_SALVAR;
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
    // End of variables declaration//GEN-END:variables
}
