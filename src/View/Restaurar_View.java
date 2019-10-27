/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util_Controller;
import DAO.AdministradorDAO;
import DAO.Sindicalizado_Pessoais_DAO;
import DAO.Sindicalizado_Rurais_DAO;
import Model.Administrador;
import Model.Sindicalizado_Pessoais;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
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
public final class Restaurar_View extends javax.swing.JInternalFrame {

    int cont = 0, ID = 0;
    public int NULL = 0;
    boolean nulo = false;
    String nome = "";

    Sindicalizado_Pessoais_DAO dsp = new Sindicalizado_Pessoais_DAO();
    Sindicalizado_Rurais_DAO DADOSR = new Sindicalizado_Rurais_DAO();

    public Restaurar_View() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Restaurar_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Restaurar_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Restaurar_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Restaurar_View.class.getName()).log(Level.SEVERE, null, ex);
        }

        Util_Controller.soLetras(TXT_NOME);
        TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        listarTabela_P_Restau();
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public int pesquisar_nome_SIND(String nome) {
        ArrayList<Sindicalizado_Pessoais> SIND;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        SIND = dsp.pesquisar_restaurar(nome);

        if (SIND != null && !SIND.isEmpty()) { // SE O ARRAY N ESTA NULO
            SIND.forEach((sind) -> {
                ID = sind.getId_sindi();
                dtma.addRow(new Object[]{
                    sind.getId_sindi(),
                    sind.getNome(),
                    sind.getCelular(),
                    sind.getRg(),
                    sind.getCpf()
                });
            });
        }else{
            JOptionPane.showMessageDialog(null, "Não há sindicalizado excluido chamado " + nome);
        }
        corLinhaJTable();
        return ID;
    }

    public void listarTabela_P_Restau() {
        DefaultTableModel dtma = (DefaultTableModel) TABELA_P_RESTAURAR.getModel();
        dtma.setNumRows(0);

        TABELA_P_RESTAURAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA_P_RESTAURAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_P_RESTAURAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        dsp.listar_Tabela_Dados_Pessoais_Restaurar().forEach((sind) -> {
            dtma.addRow(new Object[]{
                sind.getId_sindi(),
                sind.getNome(),
                sind.getCelular(),
                sind.getRg(),
                sind.getCpf()
            });
        });
        corLinhaJTable_Tabela_P_R();
    }

    public void listarTabela_P_Restau_NOME(String Nome) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA_P_RESTAURAR.getModel();
        dtma.setNumRows(0);

        TABELA_P_RESTAURAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        ArrayList<Sindicalizado_Pessoais> SIND;
        SIND = dsp.listar_Tabela_Dados_Pessoais_Restaurar_NOME(Nome);

        if (SIND != null && !SIND.isEmpty()) {              //SE O ArrayList NÃO ESTIVER VAZIO
            SIND.forEach((sind) -> {
                dtma.addRow(new Object[]{
                    sind.getId_sindi(),
                    sind.getNome(),
                    sind.getCelular(),
                    sind.getRg(),
                    sind.getCpf()
                });
            });
            corLinhaJTable_Tabela_P_R();
        } else {
            JOptionPane.showMessageDialog(null, "Não há cadastro de sindicalizado chamado " + Nome);
            listarTabela_P_Restau();
            NOME_RESTAU.setText("");
        }
    }

    public void listarTabela_Dados_Excluidos(int i) {

        DefaultTableModel dtma = (DefaultTableModel) TABELA_DADOS_EXCLUIDOS.getModel();
        dtma.setNumRows(0);

        TABELA_DADOS_EXCLUIDOS.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_DADOS_EXCLUIDOS.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        TABELA_DADOS_EXCLUIDOS.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DADOSR.lista_tabela_propri_res(i, nome).forEach((propri) -> {
            dtma.addRow(new Object[]{
                propri.getId_proprie(),
                propri.getNomeFazenda(),
                propri.getMuniciSede(),
                propri.getCodINCRA(),
                propri.getNIRF()
            });
        });
        corLinhaJTable_Tabela_Dados_Excluidos();
    }

    public int pesquisar_nome_ADM(String nome) {
        ArrayList<Administrador> AD;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        String rg = "";
        String cpf = "";

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        AdministradorDAO ad = new AdministradorDAO();
        AD = ad.pesquisar_restaurar(nome);
        if (AD != null && !AD.isEmpty()) {
            AD.forEach((adm) -> {
                ID = adm.getId();
                dtma.addRow(new Object[]{
                    adm.getId(),
                    adm.getNome(),
                    adm.getCelular(),
                    rg,
                    cpf
                });
            });
        } else {
            JOptionPane.showMessageDialog(null, "Não há administrador excluido chamado " + nome);
        }
        corLinhaJTable();
        return ID;
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

    public void corLinhaJTable_Tabela_P_R() {
        TABELA_P_RESTAURAR.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

    public void corLinhaJTable_Tabela_Dados_Excluidos() {
        TABELA_DADOS_EXCLUIDOS.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

    public void limpar_TABELA_DADOS_EXCLUIDOS() {
        ((DefaultTableModel) TABELA_DADOS_EXCLUIDOS.getModel()).setRowCount(0); // REMOVE TODOS OS DADOS QUE ESTIVER NA TABELA
    }

    public void limparCampo_Pesquisa() {
        TXT_NOME.setText("");
        NOME_RESTAU.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABELA_P_RESTAURAR = new javax.swing.JTable();
        NOME_RESTAU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABELA_DADOS_EXCLUIDOS = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        RESTAURA_SIND_ = new javax.swing.JButton();
        RESTAURA_ADM_ = new javax.swing.JButton();
        TXT_NOME = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Restaurar");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        TABELA_P_RESTAURAR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "RG", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABELA_P_RESTAURAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELA_P_RESTAURARMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TABELA_P_RESTAURAR);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel3.setText("Nome do Sindicalizado:");

        TABELA_DADOS_EXCLUIDOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome da propriedade", "Município cede", "Número do Imóvel no NIRF", "Número do Imóvel no INCRA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABELA_DADOS_EXCLUIDOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELA_DADOS_EXCLUIDOSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABELA_DADOS_EXCLUIDOS);

        jLabel2.setText("RESTAURAR PROPRIEDADE RURAL");

        jLabel6.setText("Propriedades excluidas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(NOME_RESTAU, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(116, 116, 116))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(NOME_RESTAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "RG", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        RESTAURA_SIND_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        RESTAURA_SIND_.setText("Sindicalizado");
        RESTAURA_SIND_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESTAURA_SIND_ActionPerformed(evt);
            }
        });

        RESTAURA_ADM_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        RESTAURA_ADM_.setText("Administrador");
        RESTAURA_ADM_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESTAURA_ADM_ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel5.setText("RESTAURAR SINDICALIZADO - ADMINISTRADOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(RESTAURA_SIND_)
                        .addGap(42, 42, 42)
                        .addComponent(RESTAURA_ADM_))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RESTAURA_SIND_)
                    .addComponent(RESTAURA_ADM_))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RESTAURA_SIND_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESTAURA_SIND_ActionPerformed
        ID = 0;

        pesquisar_nome_SIND(TXT_NOME.getText());
        cont = 1;
    }//GEN-LAST:event_RESTAURA_SIND_ActionPerformed

    private void RESTAURA_ADM_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESTAURA_ADM_ActionPerformed
        ID = 0;

        ID = pesquisar_nome_ADM(TXT_NOME.getText());
        cont = 2;
    }//GEN-LAST:event_RESTAURA_ADM_ActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        String ObjButtons[] = {"Sim", "Não"};
        int PromptResult = JOptionPane.showOptionDialog(null,
                "Realmente deseja realizar a restauração?", "ATENÇÃO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            if (cont == 1) {
                DADOSR.restaurar_SIND(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
                TXT_NOME.setText("");
                pesquisar_nome_SIND(TXT_NOME.getText());
            } else if (cont == 2) {
                AdministradorDAO ad = new AdministradorDAO();
                ad.restaurar(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
                TXT_NOME.setText("");
                ID = pesquisar_nome_ADM(TXT_NOME.getText());
            }
        }
    }//GEN-LAST:event_TABELAMouseClicked

    private void TABELA_P_RESTAURARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELA_P_RESTAURARMouseClicked
        ID = Integer.parseInt(TABELA_P_RESTAURAR.getValueAt(TABELA_P_RESTAURAR.getSelectedRow(), 0).toString());
        nome = TABELA_P_RESTAURAR.getValueAt(TABELA_P_RESTAURAR.getSelectedRow(), 1).toString();

        listarTabela_Dados_Excluidos(ID);

    }//GEN-LAST:event_TABELA_P_RESTAURARMouseClicked

    private void TABELA_DADOS_EXCLUIDOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELA_DADOS_EXCLUIDOSMouseClicked
        String ObjButtons[] = {"Sim", "Não"};
        int PromptResult = JOptionPane.showOptionDialog(null,
                "Deseja restaurar os dados desta propriedade rural?", "ATENÇÃO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            ID = Integer.parseInt(TABELA_DADOS_EXCLUIDOS.getValueAt(TABELA_DADOS_EXCLUIDOS.getSelectedRow(), 0).toString());
            DADOSR.restaurar_Uma_Propri(ID);
            limpar_TABELA_DADOS_EXCLUIDOS();
            listarTabela_P_Restau();
        }
    }//GEN-LAST:event_TABELA_DADOS_EXCLUIDOSMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if ("".equals(NOME_RESTAU.getText())) {
            listarTabela_P_Restau();
        } else {
            listarTabela_P_Restau_NOME(NOME_RESTAU.getText());
        }
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NOME_RESTAU;
    private javax.swing.JButton RESTAURA_ADM_;
    private javax.swing.JButton RESTAURA_SIND_;
    private javax.swing.JTable TABELA;
    private javax.swing.JTable TABELA_DADOS_EXCLUIDOS;
    private javax.swing.JTable TABELA_P_RESTAURAR;
    private javax.swing.JTextField TXT_NOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
