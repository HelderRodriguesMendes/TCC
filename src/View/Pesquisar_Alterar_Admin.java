/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login;
import Controller.Util;
import DAO.AdministradorDAO;
import DAO.Util_DAO;
import Model.Administrador_Entidade;
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
public class Pesquisar_Alterar_Admin extends javax.swing.JInternalFrame {

    int cont = 0, con = 0, ID = 0;
    Administrador_Entidade adm = new Administrador_Entidade();
    AdministradorDAO ad = new AdministradorDAO();
    Login lo = new Login();
    public boolean excluir = false;

    public Pesquisar_Alterar_Admin() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        LISTAR_TABELA();
        Util.soLetras(NOME);

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
        if (!excluir) {
            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja alterar os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                Cad_Administrador cadm = new Cad_Administrador() {
                };
                cadm.preencherCampus(preencher_Objeto());
                cadm.setTitle("Alterar dados do Administrador");
                cadm.setVisible(true);
                Interface.DESKTOP.add(cadm);
                cadm.setPosicao();
                this.dispose();
            }
        } else {

            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Tem certeza que deseja excluir esses dados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                int id = Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString());
                Util_DAO ud = new Util_DAO();
                ud.excluir(id, "adm");
                LISTAR_TABELA();
            }
        }
    }//GEN-LAST:event_TABELAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!"".equals(NOME.getText())) {
            ID = 0;
            Pesquisar_Nome(NOME.getText());
            int i = Util.selectNull(ID);
            if (i == 1) {
                NOME.setText("");
                LISTAR_TABELA();
            }
        } else {
            LISTAR_TABELA();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NOMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMEKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(NOME.getText())) {
                ID = 0;
                Pesquisar_Nome(NOME.getText());
                int i = Util.selectNull(ID);
                if (i == 1) {
                    NOME.setText("");
                    LISTAR_TABELA();
                }
            } else {
                LISTAR_TABELA();
            }
        }
    }//GEN-LAST:event_NOMEKeyPressed

    public void LISTAR_TABELA() {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        ad.Listar_Tabela().forEach((admin) -> {

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

        ad.Pesquisar_Nome(nome).forEach((admi) -> {
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

    public Administrador_Entidade preencher_Objeto() {
        adm.setId(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
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
