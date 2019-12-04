/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login_Controller;
import Controller.Util_Controller;
import DAO.AdministradorDAO;
import DAO.Util_DAO;
import Model.Administrador;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helde
 */
public class Pesquisar_Alterar_Admin_View extends javax.swing.JInternalFrame {

    int cont = 0, con = 0, ID = 0;
    Administrador adm = new Administrador();
    AdministradorDAO ad = new AdministradorDAO();
    Login_Controller lo = new Login_Controller();
    Util_DAO ud = new Util_DAO();
    public String status = "";

    public Pesquisar_Alterar_Admin_View() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin_View.class.getName()).log(Level.SEVERE, null, ex);
        }

        LISTAR_TABELA();
        Util_Controller.soLetras(NOME);

        TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NOME = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Nome:");

        NOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOMEKeyPressed(evt);
            }
        });

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABELA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABELA);
        if (TABELA.getColumnModel().getColumnCount() > 0) {
            TABELA.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        ID = Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString());
        System.out.println("ID: " + ID);
        if ("alterar".equals(status)) {
            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja alterar os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                Administrador_View cadm = new Administrador_View() {
                };
                cadm.preencherCampus(preencher_Objeto());
                cadm.setTitle("Alterar dados do Administrador");
                cadm.setVisible(true);
                Interface_View.DESKTOP.add(cadm);
                cadm.setPosicao();
                this.dispose();
            }
        } else if ("excluir".equals(status)) {

            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja excluir os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {

                boolean ok = ud.excluir_S_A(ID, "adm");
                System.out.println("ok da dao: " + ok);
                if (ok) {
                    LISTAR_TABELA();
                }
            }
        } else if ("restaurar".equals(status)) {
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                    "Deseja restaurar os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (PromptResult == 0) {
                ad.restaurar(ID);
                LISTAR_TABELA_restaurar();
                NOME.setText("");

            }
        }
    }//GEN-LAST:event_TABELAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!"".equals(NOME.getText())) {
            if ("restaurar".equals(status)) {
                Pesquisar_Nome_restaurar(NOME.getText());
                ID = 0;
                int i = Util_Controller.selectNull(ID);
                if (i == 0) {
                    NOME.setText("");
                    LISTAR_TABELA();
                }
            } else {
                ID = 0;
                Pesquisar_Nome(NOME.getText());
                int i = Util_Controller.selectNull(ID);
                if (i == 0) {
                    NOME.setText("");
                    LISTAR_TABELA();
                }
            }
        } else {
            LISTAR_TABELA();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NOMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMEKeyPressed

    }//GEN-LAST:event_NOMEKeyPressed

    public final void LISTAR_TABELA() {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        ad.list_JTable().forEach((admin) -> {

            dtma.addRow(new Object[]{
                admin.getId(),
                admin.getNome(),
                admin.getCelular(),
                admin.getLogin()
            });
        });
        corLinhaJTable();
    }

    public final void LISTAR_TABELA_restaurar() {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        ad.lista_restaurar().forEach((admin) -> {

            dtma.addRow(new Object[]{
                admin.getId(),
                admin.getNome(),
                admin.getCelular(),
                admin.getLogin()
            });
        });
        corLinhaJTable();
    }

    public void Pesquisar_Nome(String nome) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        ad.select_Name(nome).forEach((admi) -> {
            ID = admi.getId();
            System.out.println("ID: " + ID);
            dtma.addRow(new Object[]{
                admi.getId(),
                admi.getNome(),
                admi.getCelular(),
                admi.getLogin()
            });
        });
        corLinhaJTable();
    }

    public void Pesquisar_Nome_restaurar(String nome) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        ad.pesquisar_restaurar(nome).forEach((admi) -> {
            ID = admi.getId();
            System.out.println("ID: " + ID);
            dtma.addRow(new Object[]{
                admi.getId(),
                admi.getNome(),
                admi.getCelular(),
                admi.getLogin()
            });
        });
        corLinhaJTable();
    }

    public Administrador preencher_Objeto() {
        adm.setId(ID);
        adm.setNome(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString());
        if (TABELA.getValueAt(TABELA.getSelectedRow(), 2) != null) {
            adm.setCelular(TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString());
        } else {
            adm.setCelular("");
        }
        adm.setLogin(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString());

        return adm;
    }

    public void Limpar_campus() {
        NOME.setText("");
    }

    public void corLinhaJTable() {
        TABELA.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (row % 2 != 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NOME;
    private javax.swing.JTable TABELA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
