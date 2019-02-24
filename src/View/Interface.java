/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Entidadades.Administrador;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

    int ID = 0;

    public Interface() {
        initComponents();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); // não reconhece o clique no botao de fechar a janela toda

        addWindowListener(new WindowAdapter() { // para confirna se deseja ralmente sair do sistema
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja realmente sair do sistema?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
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

    public void bloquiarMenus(Administrador a) {
        ID = a.getId();
        if ("Administrador".equals(a.getTipo_usuario())) {
            MENU_PESQUISAR.setVisible(false);
        } else {
            MENU_SALVAR.setVisible(false);
            MENU_PE.setVisible(false);
            MENU_EXCLUIR.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        DESKTOP = new javax.swing.JDesktopPane();
        BARRAMENU = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MENU_SALVAR = new javax.swing.JMenu();
        MENU_CAD_USU = new javax.swing.JMenuItem();
        MENU_CAD_SIND = new javax.swing.JMenuItem();
        MENU_PE = new javax.swing.JMenu();
        MENU_PESQUISAR = new javax.swing.JMenu();
        MENU_EXCLUIR = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DESKTOPLayout = new javax.swing.GroupLayout(DESKTOP);
        DESKTOP.setLayout(DESKTOPLayout);
        DESKTOPLayout.setHorizontalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
        );
        DESKTOPLayout.setVerticalGroup(
            DESKTOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoSiteMenu.png"))); // NOI18N
        BARRAMENU.add(jMenu2);

        MENU_SALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/SALVAR 2.png"))); // NOI18N
        MENU_SALVAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENU_SALVARMouseEntered(evt);
            }
        });

        MENU_CAD_USU.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
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
        BARRAMENU.add(MENU_PE);

        MENU_PESQUISAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PESQUISAR (2).png"))); // NOI18N
        BARRAMENU.add(MENU_PESQUISAR);

        MENU_EXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ESCLUIR 2.png"))); // NOI18N
        BARRAMENU.add(MENU_EXCLUIR);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/siraICO.png"))); // NOI18N
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
        Cad_Administrador ca = new Cad_Administrador();
        Interface.DESKTOP.add(ca);
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
        Cad_Sindicalizado cs = new Cad_Sindicalizado();
        DESKTOP.add(cs);
        cs.setVisible(true);
        cs.setPosicao();
    }//GEN-LAST:event_MENU_CAD_SINDActionPerformed

    private void MENU_CAD_SINDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseEntered
        MENU_CAD_SIND.setToolTipText("Cadastrar sindicalizado");
    }//GEN-LAST:event_MENU_CAD_SINDMouseEntered

    private void MENU_CAD_SINDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENU_CAD_SINDMouseClicked

    }//GEN-LAST:event_MENU_CAD_SINDMouseClicked

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
    private javax.swing.JMenu MENU_PESQUISAR;
    private javax.swing.JMenu MENU_SALVAR;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    // End of variables declaration//GEN-END:variables
}
