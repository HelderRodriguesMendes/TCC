/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util_Controller;
import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;
import java.awt.Dimension;
import java.text.DateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class ControleCaixa_VIEW extends javax.swing.JInternalFrame {

    public ControleCaixa_VIEW() {
        initComponents();
    }

    Controle_Caixa c;
    DateFormat df = DateFormat.getDateInstance();
    Controle_Caixa_DAO CD = new Controle_Caixa_DAO();

    public String status = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FORM_GUIAS = new javax.swing.JTabbedPane();
        TELA1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BANCO = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DATA = new com.toedter.calendar.JDateChooser();
        ANUIDADE = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        DOCUMENTO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TRANSACAO = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VALORF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HISTORICO = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        BOTAO_SALVA_ = new javax.swing.JLabel();
        BOTAO_REFAZER_ = new javax.swing.JLabel();
        BOTAO_AVANCAR_ = new javax.swing.JLabel();
        TELA2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        bancoP2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        TELA3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        SALDO1 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        bancoP1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Caixa");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Baonco:");

        BANCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa Interno", "Sicredi" }));

        jLabel2.setText("Data:");

        ANUIDADE.setText("Anuidade");

        jLabel3.setText("Documento:");

        jLabel4.setBackground(new java.awt.Color(204, 0, 102));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("*");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setAlignmentY(0.0F);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.setIconTextGap(1);
        jLabel4.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel4.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel6.setBackground(new java.awt.Color(204, 0, 102));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("*");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel6.setIconTextGap(1);
        jLabel6.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel6.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel6.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Transação financeira:");

        TRANSACAO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Crédito", "Débito" }));

        jLabel7.setBackground(new java.awt.Color(204, 0, 102));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("*");
        jLabel7.setToolTipText("");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel7.setIconTextGap(1);
        jLabel7.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel7.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel7.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel8.setText("Valor Financeiro:");

        jLabel10.setBackground(new java.awt.Color(204, 0, 102));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("*");
        jLabel10.setToolTipText("");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel10.setIconTextGap(1);
        jLabel10.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel10.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel10.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel11.setText("Histórico:");

        HISTORICO.setColumns(20);
        HISTORICO.setRows(5);
        jScrollPane1.setViewportView(HISTORICO);

        jLabel9.setBackground(new java.awt.Color(204, 0, 102));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("*");
        jLabel9.setToolTipText("");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel9.setIconTextGap(1);
        jLabel9.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel9.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel9.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        BOTAO_SALVA_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        BOTAO_SALVA_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_SALVA_MouseClicked(evt);
            }
        });

        BOTAO_REFAZER_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refazer.png"))); // NOI18N
        BOTAO_REFAZER_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_REFAZER_MouseClicked(evt);
            }
        });

        BOTAO_AVANCAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        BOTAO_AVANCAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_AVANCAR_MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BOTAO_AVANCAR_MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(DOCUMENTO)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(BANCO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(77, 77, 77))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(69, 69, 69)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ANUIDADE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(BOTAO_SALVA_)
                                .addGap(18, 18, 18)
                                .addComponent(BOTAO_REFAZER_)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BOTAO_AVANCAR_)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BANCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ANUIDADE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BOTAO_SALVA_)
                                    .addComponent(BOTAO_REFAZER_)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BOTAO_AVANCAR_)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout TELA1Layout = new javax.swing.GroupLayout(TELA1);
        TELA1.setLayout(TELA1Layout);
        TELA1Layout.setHorizontalGroup(
            TELA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TELA1Layout.setVerticalGroup(
            TELA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        FORM_GUIAS.addTab("tab1", TELA1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N

        bancoP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        bancoP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bancoP2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bancoP2MousePressed(evt);
            }
        });

        jLabel19.setText("Banco:");

        jLabel25.setText("Data ou intervalo entre duas datas:");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setText("Há");

        javax.swing.GroupLayout TELA2Layout = new javax.swing.GroupLayout(TELA2);
        TELA2.setLayout(TELA2Layout);
        TELA2Layout.setHorizontalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bancoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(45, 45, 45))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        TELA2Layout.setVerticalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bancoP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FORM_GUIAS.addTab("Consultar Dados", TELA2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N

        jLabel18.setText("Saldo:");

        SALDO1.setEnabled(false);

        jLabel24.setText("Data ou intervalo entre duas datas:");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setText("Há");

        bancoP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        bancoP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bancoP1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bancoP1MousePressed(evt);
            }
        });

        jLabel16.setText("Banco:");

        javax.swing.GroupLayout TELA3Layout = new javax.swing.GroupLayout(TELA3);
        TELA3.setLayout(TELA3Layout);
        TELA3Layout.setHorizontalGroup(
            TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bancoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA3Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TELA3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel24)))
                .addGap(57, 57, 57)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SALDO1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        TELA3Layout.setVerticalGroup(
            TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SALDO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TELA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bancoP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FORM_GUIAS.addTab("Consultar Saldo", TELA3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_REFAZER_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_REFAZER_MouseClicked
        limparCamous();
    }//GEN-LAST:event_BOTAO_REFAZER_MouseClicked

    private void BOTAO_SALVA_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVA_MouseClicked
        if (validarObrigatorios()) {
            CD.salvar(preenche_Objeto());
            BANCO.requestFocus();
            limparCamous();
        }
    }//GEN-LAST:event_BOTAO_SALVA_MouseClicked

    private void BOTAO_AVANCAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_AVANCAR_MouseClicked
       
    }//GEN-LAST:event_BOTAO_AVANCAR_MouseClicked

    private void BOTAO_AVANCAR_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_AVANCAR_MouseEntered
        BOTAO_AVANCAR_.setToolTipText("AVANÇAR");
    }//GEN-LAST:event_BOTAO_AVANCAR_MouseEntered

    private void bancoP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bancoP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bancoP1MouseClicked

    private void bancoP1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bancoP1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bancoP1MousePressed

    private void bancoP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bancoP2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bancoP2MouseClicked

    private void bancoP2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bancoP2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bancoP2MousePressed

    public boolean validarObrigatorios() {
        boolean ok = false;
        int cont = 0;

        if (BANCO.getSelectedIndex() == 0 && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o banco desejado para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            BANCO.requestFocus();
            cont++;
        } else if (DATA.getDate() == null && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe a data desejada para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            DATA.requestFocus();
            cont++;
        } else if (TRANSACAO.getSelectedIndex() == 0 && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o tipo de transação financeira", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            TRANSACAO.requestFocus();
            cont++;
        } else if ("".equals(VALORF.getText()) && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o valor financeiro da transação");
            VALORF.requestFocus();
            cont++;
        } else if ("".equals(HISTORICO.getText()) && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o histórico da transação");
            HISTORICO.requestFocus();
            cont++;
        }

        if (cont == 0) {
            ok = true;
        }
        return ok;
    }

    public Controle_Caixa preenche_Objeto() {
        c = new Controle_Caixa();

        c.setBanco(String.valueOf(BANCO.getSelectedItem()));
        String dt = df.format(DATA.getDate());
        c.setData(Util_Controller.STRING_DATE(dt));
        c.setDocumento(DOCUMENTO.getText());

        if (TRANSACAO.getSelectedIndex() == 1) {
            c.setCredito(Double.parseDouble(VALORF.getText().replace(",", ".")));
            c.setDebito(0.0);
        } else if (TRANSACAO.getSelectedIndex() == 2) {
            c.setDebito(Double.parseDouble(VALORF.getText().replace(",", ".")));
            c.setCredito(0.0);
        }

        c.setHistorico(HISTORICO.getText());

        return c;
    }

    public void limparCamous() {
        BANCO.setSelectedIndex(0);
        DATA.setDate(null);
        DOCUMENTO.setText("");
        TRANSACAO.setSelectedIndex(0);
        VALORF.setText("");
        HISTORICO.setText("");
        ANUIDADE.setSelected(false);
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void selecionar_guia(int n) {

        this.FORM_GUIAS.setEnabledAt(n, true); // desabilita toda a aba 1
        this.FORM_GUIAS.setSelectedIndex(n);
        switch (n) {
            case 0:
                this.FORM_GUIAS.setEnabledAt(1, false); // desabilita toda a aba 1
                this.FORM_GUIAS.setEnabledAt(2, false); // desabilita toda a aba 1        
                if ("cadastrar".equals(status)) {
                    FORM_GUIAS.setTitleAt(n, "Cadastrar");
                    BOTAO_AVANCAR_.setVisible(false);
                } else if ("alterar".equals(status)) {
                    FORM_GUIAS.setTitleAt(n, "Alterar");
                }
                break;
            case 1:
                this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                this.FORM_GUIAS.setEnabledAt(1, true); // desabilita toda a aba 0
                this.FORM_GUIAS.setEnabledAt(2, true); // desabilita toda a aba 0    
                if ("cadastrar".equals(status)) {
                    FORM_GUIAS.setTitleAt(0, "Cadastrar");
                    BOTAO_AVANCAR_.setVisible(false);
                } else if ("alterar".equals(status)) {
                    FORM_GUIAS.setTitleAt(0, "Alterar");
                }
            default:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ANUIDADE;
    private javax.swing.JComboBox<String> BANCO;
    private javax.swing.JLabel BOTAO_AVANCAR_;
    private javax.swing.JLabel BOTAO_REFAZER_;
    private javax.swing.JLabel BOTAO_SALVA_;
    private com.toedter.calendar.JDateChooser DATA;
    private javax.swing.JTextField DOCUMENTO;
    private javax.swing.JTabbedPane FORM_GUIAS;
    private javax.swing.JTextArea HISTORICO;
    private javax.swing.JTextField SALDO1;
    public javax.swing.JPanel TELA1;
    public javax.swing.JPanel TELA2;
    private javax.swing.JPanel TELA3;
    private javax.swing.JComboBox<String> TRANSACAO;
    private javax.swing.JTextField VALORF;
    private javax.swing.JComboBox<Object> bancoP1;
    private javax.swing.JComboBox<Object> bancoP2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
