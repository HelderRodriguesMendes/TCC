/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controle_caixa_Controller;
import Controller.Util_Controller;
import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helde
 */
public class ControleCaixa_VIEW extends javax.swing.JInternalFrame {

    public ControleCaixa_VIEW() {
        initComponents();
        lista_TABELA_PESQUISAR_ALTERAR();
        TABELA_PESQUISAR_ALTERAR.getTableHeader().setReorderingAllowed(false);
    }

    Controle_Caixa c;
    DateFormat df = DateFormat.getDateInstance();
    Controle_Caixa_DAO CC = new Controle_Caixa_DAO();
    Controle_caixa_Controller cc_controler = new Controle_caixa_Controller();
    ArrayList<Date> DATAS = new ArrayList<>();

    public String status = "";
    Date dt1 = null, dt2 = null, dt_uni = null;
    String data1 = "", data2 = "", dataUnica1 = "", banco = "";
    int id_controleCaixa = 0, linhaSelecionada, cont_data = 0, cont_mes = 0, cont_data_inter1 = 0, cont_data_inter2 = 0, dataUnica2 = 0, mes = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FORM_GUIAS = new javax.swing.JTabbedPane();
        TELA1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BANCO1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DATA1 = new com.toedter.calendar.JDateChooser();
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
        BOTAO_CANCELAR_EDIÇÃO = new javax.swing.JLabel();
        TELA2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABELA_PESQUISAR_ALTERAR = new javax.swing.JTable();
        BOTAO_PESQUISAR_ = new javax.swing.JLabel();
        BANCO2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        DATA_INTERVALO2 = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DATA_INTERVALO1 = new com.toedter.calendar.JDateChooser();
        DATA2 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        MES_ = new com.toedter.calendar.JMonthChooser();
        jLabel22 = new javax.swing.JLabel();
        REFAZER_PESQUISA_ = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        SALDO_ATUAL = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Caixa");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Baonco:");

        BANCO1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa Interno", "Sicredi" }));

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

        BOTAO_CANCELAR_EDIÇÃO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar_1.png"))); // NOI18N
        BOTAO_CANCELAR_EDIÇÃO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_CANCELAR_EDIÇÃOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BOTAO_CANCELAR_EDIÇÃOMouseEntered(evt);
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
                                                    .addComponent(jLabel3)
                                                    .addComponent(BANCO1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(77, 77, 77))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DATA1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel2)))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(BOTAO_SALVA_)
                        .addGap(18, 18, 18)
                        .addComponent(BOTAO_REFAZER_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BOTAO_CANCELAR_EDIÇÃO)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ANUIDADE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BANCO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DATA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
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
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(BOTAO_CANCELAR_EDIÇÃO))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BOTAO_SALVA_)
                        .addComponent(BOTAO_REFAZER_)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TELA1Layout = new javax.swing.GroupLayout(TELA1);
        TELA1.setLayout(TELA1Layout);
        TELA1Layout.setHorizontalGroup(
            TELA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TELA1Layout.setVerticalGroup(
            TELA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        FORM_GUIAS.addTab("tab1", TELA1);

        TABELA_PESQUISAR_ALTERAR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Banco", "Histórico", "Documento", "Débito", "Crédito"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABELA_PESQUISAR_ALTERAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELA_PESQUISAR_ALTERARMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABELA_PESQUISAR_ALTERAR);

        BOTAO_PESQUISAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        BOTAO_PESQUISAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_PESQUISAR_MouseClicked(evt);
            }
        });

        BANCO2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa Interno", "Sicredi" }));

        jLabel19.setText("Banco:");

        DATA_INTERVALO2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA_INTERVALO2PropertyChange(evt);
            }
        });

        jLabel25.setText("Intervalo de datas:");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel20.setText("Há");

        DATA_INTERVALO1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA_INTERVALO1PropertyChange(evt);
            }
        });

        DATA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DATA2MouseClicked(evt);
            }
        });
        DATA2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA2PropertyChange(evt);
            }
        });

        jLabel21.setText("Data:");

        MES_.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                MES_PropertyChange(evt);
            }
        });

        jLabel22.setText("Mês:");

        REFAZER_PESQUISA_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        REFAZER_PESQUISA_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REFAZER_PESQUISA_MouseClicked(evt);
            }
        });

        jLabel24.setText("Saldo:");

        SALDO_ATUAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout TELA2Layout = new javax.swing.GroupLayout(TELA2);
        TELA2.setLayout(TELA2Layout);
        TELA2Layout.setHorizontalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TELA2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(TELA2Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel19))
                                .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(TELA2Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel21))
                                .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(TELA2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel22))
                                .addComponent(MES_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25)
                                .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(TELA2Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel20))))
                        .addGroup(TELA2Layout.createSequentialGroup()
                            .addGap(410, 410, 410)
                            .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TELA2Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SALDO_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(REFAZER_PESQUISA_))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BOTAO_PESQUISAR_)))
                .addGap(3, 3, 3))
        );
        TELA2Layout.setVerticalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(REFAZER_PESQUISA_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BOTAO_PESQUISAR_))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TELA2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(5, 5, 5)
                                .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TELA2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(6, 6, 6)
                                .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel20))
                            .addGroup(TELA2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(6, 6, 6)
                                        .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(6, 6, 6)
                                        .addComponent(MES_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6)
                        .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(SALDO_ATUAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        FORM_GUIAS.addTab("Consultar  - Alterar Dados", TELA2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(FORM_GUIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_REFAZER_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_REFAZER_MouseClicked
        limparCampus();
    }//GEN-LAST:event_BOTAO_REFAZER_MouseClicked

    private void BOTAO_SALVA_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVA_MouseClicked
        if (validarObrigatorios()) {
            if ("cadastrar".equals(status)) {
                CC.salvar(preenche_Objeto());
                BANCO1.requestFocus();
                limparCampus();
            } else if ("alterar".equals(status)) {
                CC.alterar(preenche_Objeto());
                limparCampus();
                selecionar_guia(1);
                lista_TABELA_PESQUISAR_ALTERAR();
                limparCampus();
            }
        }
    }//GEN-LAST:event_BOTAO_SALVA_MouseClicked

    private void BOTAO_CANCELAR_EDIÇÃOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_CANCELAR_EDIÇÃOMouseClicked
        String ObjButtons[] = {"Sim", "Não"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Deseja cancelar a alteração dos dados?", "ATENÇÃO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons, ObjButtons[1]);
        if (escolha == 0) {
            limparCampus();
            selecionar_guia(1);

        }
    }//GEN-LAST:event_BOTAO_CANCELAR_EDIÇÃOMouseClicked

    private void BOTAO_CANCELAR_EDIÇÃOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_CANCELAR_EDIÇÃOMouseEntered
        BOTAO_CANCELAR_EDIÇÃO.setToolTipText("AVANÇAR");
    }//GEN-LAST:event_BOTAO_CANCELAR_EDIÇÃOMouseEntered

    private void BOTAO_PESQUISAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_PESQUISAR_MouseClicked
        int m = Calendar.getInstance().get(Calendar.MONTH);

        if (BANCO2.getSelectedIndex() == 0 && data2.equals("") && data1.equals("") && dataUnica1.equals("")) {
            if (mes == m) {
                String ObjButtons[] = {"Sim", "Não"};
                int escolha = JOptionPane.showOptionDialog(null,
                        "Deseja realizar consultas sobre o mês atual?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (escolha == 0) {
                    lista_TABELA_PESQUISAR_ALTERAR_P(banco, data1, data2, dataUnica1, mes);
                } else if (escolha == 1) {
                    lista_TABELA_PESQUISAR_ALTERAR();
                }
            }
        } else {
            banco = String.valueOf(BANCO2.getSelectedItem());
            System.out.println("clico");
            lista_TABELA_PESQUISAR_ALTERAR_P(banco, data1, data2, dataUnica1, mes);
        }
    }//GEN-LAST:event_BOTAO_PESQUISAR_MouseClicked

    private void TABELA_PESQUISAR_ALTERARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELA_PESQUISAR_ALTERARMouseClicked
        linhaSelecionada = TABELA_PESQUISAR_ALTERAR.getSelectedRow();

        String iid = TABELA_PESQUISAR_ALTERAR.getValueAt(linhaSelecionada, 0).toString();
        id_controleCaixa = Integer.parseInt(iid);

        if ("alterar".equals(status)) {
            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja alterar os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                selecionar_guia(0);
                preencherCamposJtable(linhaSelecionada);
                BOTAO_REFAZER_.setVisible(false);
            }
        } else if ("excluir".equals(status)) {
            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja escluir os dados financeiros celecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                CC.excluir(id_controleCaixa);
                lista_TABELA_PESQUISAR_ALTERAR();
                limparCampus();
            }
        }
    }//GEN-LAST:event_TABELA_PESQUISAR_ALTERARMouseClicked

    private void DATA_INTERVALO1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA_INTERVALO1PropertyChange
        cont_data_inter1++;

        if (cont_data_inter1 > 1) {
            String s = ((JTextField) DATA_INTERVALO1.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (dataUnica1.equals("") && mes == 0) {
                    data1 = s; // o (s) ja tem a data formatada em string
                    DATA2.setEnabled(false);
                    DATA2.setDate(null);
                    MES_.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_DATA_INTERVALO1PropertyChange

    private void MES_PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_MES_PropertyChange
        cont_mes++;

        if (cont_mes > 1) {
            if (data1.equals("") && data2.equals("") && dataUnica1.equals("")) {
                mes = MES_.getMonth() + 1; // pega o mes selecionado, a soma de + 1 é porque começa a conta os mes do 0        
                System.out.println("MES: " + mes);
                DATA2.setEnabled(false);
                DATA_INTERVALO1.setEnabled(false);
                DATA_INTERVALO2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_MES_PropertyChange

    private void DATA_INTERVALO2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA_INTERVALO2PropertyChange
        cont_data_inter2++;
        if (cont_data_inter2 > 1) {
            String s = ((JTextField) DATA_INTERVALO2.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (dataUnica1.equals("") && mes == 0) {
                    data2 = s; // o (s) ja tem a data formatada em string
                    DATA2.setEnabled(false);
                    DATA2.setDate(null);
                    MES_.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_DATA_INTERVALO2PropertyChange

    private void DATA2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA2PropertyChange
        cont_data++;
        if (cont_data > 1) {
            String s = ((JTextField) DATA2.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (data1.equals("") && data2.equals("") & mes == 0) {
                    dataUnica1 = s;
                    System.out.println("data unica: " + dataUnica1);
                    DATA_INTERVALO1.setEnabled(false);
                    DATA_INTERVALO1.setDate(null);
                    DATA_INTERVALO2.setEnabled(false);
                    DATA_INTERVALO2.setDate(null);
                    MES_.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_DATA2PropertyChange

    private void REFAZER_PESQUISA_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REFAZER_PESQUISA_MouseClicked
        limparCamposPesquisa();
        SALDO_ATUAL.setText("");
        lista_TABELA_PESQUISAR_ALTERAR();
    }//GEN-LAST:event_REFAZER_PESQUISA_MouseClicked

    private void DATA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DATA2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DATA2MouseClicked

    public boolean validarObrigatorios() {
        boolean ok = false;
        int cont = 0;

        if (BANCO1.getSelectedIndex() == 0 && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o banco desejado para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            BANCO1.requestFocus();
            cont++;
        } else if (DATA1.getDate() == null && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe a data desejada para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            DATA1.requestFocus();
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

        c.setBanco(String.valueOf(BANCO1.getSelectedItem()));
        String dt = df.format(DATA1.getDate());
        c.setData(Util_Controller.STRING_DATE(dt));
        c.setDocumento(DOCUMENTO.getText());

        if (TRANSACAO.getSelectedIndex() == 1) {
            String cr = VALORF.getText().replace(".", "");
            String cre = cr.replace(",", ".");
            c.setCredito(Double.parseDouble(cre));
            c.setDebito(0.0);
        } else if (TRANSACAO.getSelectedIndex() == 2) {
            String de = VALORF.getText().replace(".", "");
            String deb = de.replace(",", ".");
            c.setDebito(Double.parseDouble(deb));
            System.out.println("debito formatado: " + deb);
            c.setCredito(0.0);
        }

        c.setHistorico(HISTORICO.getText());

        if ("alterar".equals(status)) {
            c.setId(id_controleCaixa);
        }

        return c;
    }

    public void limparCampus() {
        BANCO1.setSelectedIndex(0);
        DATA1.setDate(null);
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
                if ("cadastrar".equals(status)) {
                    FORM_GUIAS.setTitleAt(n, "Cadastrar Dados");
                    BOTAO_CANCELAR_EDIÇÃO.setVisible(false);
                } else if ("alterar".equals(status)) {
                    FORM_GUIAS.setTitleAt(n, "Alterar Dados");
                }
                break;
            case 1:
                this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                this.FORM_GUIAS.setEnabledAt(1, true); // desabilita toda a aba 0                 
                if ("cadastrar".equals(status)) {
                    FORM_GUIAS.setTitleAt(0, "Cadastrar Dados");
                    BOTAO_CANCELAR_EDIÇÃO.setVisible(false);
                } else if ("alterar".equals(status)) {
                    FORM_GUIAS.setTitleAt(0, "Alterar Dados");
                }
            default:
                break;
        }
    }

    public void corLinhaJTable() {
        TABELA_PESQUISAR_ALTERAR.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

    public void lista_TABELA_PESQUISAR_ALTERAR() {

        DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
        dtma.setNumRows(0);
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        CC.listar_tabela_alterar().forEach((con) -> {
            String d = "", c = "";
            if (con.getDebito() != 0.0) {
                double t = con.getDebito();
                d = cc_controler.converteMuedaBR(t);
            }
            if (con.getCredito() != 0.0) {
                double e = con.getCredito();
                c = cc_controler.converteMuedaBR(e);
            }

            String da = Util_Controller.DATE_STRING(con.getData());

            dtma.addRow(new Object[]{
                con.getId(),
                da,
                con.getBanco(),
                con.getHistorico(),
                con.getDocumento(),
                d,
                c
            });
        });
        corLinhaJTable();
    }

    public void lista_TABELA_PESQUISAR_ALTERAR_P(String b, String d1, String d2, String d_u, int m) {

        ArrayList<Controle_Caixa> C;
        System.out.println("A1");
        if ("Selecione".equals(b)) {
            System.out.println("0");
            if (!d1.equals("") & !d2.equals("")) {
                System.out.println("1");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data(dt1, dt2);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }
                        String d = Util_Controller.DATE_STRING(cc.getData());

                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else if (d1.equals("") & !d2.equals("")) {
                JOptionPane.showMessageDialog(null, "Informe as duas datas para realizar uma busca por intervalo de datas", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                DATA_INTERVALO1.setFocusable(true);
            } else if (!d1.equals("") & d2.equals("")) {
                JOptionPane.showMessageDialog(null, "Informe as duas datas para realizar uma busca por intervalo de datas", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                DATA_INTERVALO2.setFocusable(true);
            } else if (!d_u.equals("")) {
                System.out.println("2");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d_u);

                C = CC.consultar_data(dt1);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else if (m > 0) {
                System.out.println("3");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                DATAS = cc_controler.totalDiasMes(mes);
                dt1 = DATAS.get(0);
                dt2 = DATAS.get(1);
                System.out.println("data 2 volta: " + dt2);

                C = CC.consultar_data_data(dt1, dt2);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            }
        } else {
            System.out.println("00");
            if (!d1.equals("") & !d2.equals("")) {
                System.out.println("4");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data_banco(dt1, dt2, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }

                c = new Controle_Caixa();
                c = CC.Consultar_Saldo_Atual_data_data(dt1, dt2, b);
                SALDO_ATUAL.setText(cc_controler.CALCULAR_SALDO_ATUAL(c));

            } else if (!d1.equals("")) {
                System.out.println("5");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);

                C = CC.consultar_data_banco(dt1, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else if (!d2.equals("")) {
                System.out.println("6");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_banco(dt2, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else {
                System.out.println("7");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                System.out.println("banco: " + b);

                C = CC.consultar_banco(b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = cc_controler.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = cc_controler.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            c
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            }
        }
    }

    public void limparCamposPesquisa() {
        BANCO2.setSelectedIndex(0);
        BANCO2.setEnabled(true);

        DATA2.setDate(null);
        DATA2.setEnabled(true);
        dataUnica1 = "";

        MES_.setEnabled(true);
        int m = Calendar.getInstance().get(Calendar.MONTH); // pegando o mes atual
        MES_.setMonth(m); // retornando a combobox de mês para o mês atual
        mes = 0;

        DATA_INTERVALO1.setDate(null);
        DATA_INTERVALO1.setEnabled(true);
        data1 = "";

        DATA_INTERVALO2.setDate(null);
        DATA_INTERVALO2.setEnabled(true);
        data2 = "";
    }

    public void preencherCamposJtable(int linha) {
        BANCO1.setSelectedItem(TABELA_PESQUISAR_ALTERAR.getValueAt(linha, 2).toString());
        Date data = Util_Controller.STRING_DATE(TABELA_PESQUISAR_ALTERAR.getValueAt(TABELA_PESQUISAR_ALTERAR.getSelectedRow(), 1).toString());
        DATA1.setDate(data);
        DOCUMENTO.setText(TABELA_PESQUISAR_ALTERAR.getValueAt(linha, 4).toString());
        String d = TABELA_PESQUISAR_ALTERAR.getValueAt(linha, 5).toString();
        String c = TABELA_PESQUISAR_ALTERAR.getValueAt(linha, 6).toString();
        if (!"".equals(d)) {
            TRANSACAO.setSelectedIndex(2);           
            String[] valor = d.split(" ");
            VALORF.setText(valor[1]);
        } else if (!"".equals(c)) {
            TRANSACAO.setSelectedIndex(1);
            String[] valor = c.split(" ");
            VALORF.setText(valor[1]);
        }
        HISTORICO.setText(TABELA_PESQUISAR_ALTERAR.getValueAt(linha, 3).toString());

    }

    public void dadosNAOencontrados() {
        JOptionPane.showMessageDialog(null, "Os dados pesquisados não foram encontrados", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        lista_TABELA_PESQUISAR_ALTERAR();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ANUIDADE;
    private javax.swing.JComboBox<String> BANCO1;
    private javax.swing.JComboBox<Object> BANCO2;
    private javax.swing.JLabel BOTAO_CANCELAR_EDIÇÃO;
    private javax.swing.JLabel BOTAO_PESQUISAR_;
    private javax.swing.JLabel BOTAO_REFAZER_;
    private javax.swing.JLabel BOTAO_SALVA_;
    private com.toedter.calendar.JDateChooser DATA1;
    private com.toedter.calendar.JDateChooser DATA2;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO1;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO2;
    private javax.swing.JTextField DOCUMENTO;
    private javax.swing.JTabbedPane FORM_GUIAS;
    private javax.swing.JTextArea HISTORICO;
    private com.toedter.calendar.JMonthChooser MES_;
    private javax.swing.JLabel REFAZER_PESQUISA_;
    private javax.swing.JLabel SALDO_ATUAL;
    private javax.swing.JTable TABELA_PESQUISAR_ALTERAR;
    public javax.swing.JPanel TELA1;
    public javax.swing.JPanel TELA2;
    private javax.swing.JComboBox<String> TRANSACAO;
    private javax.swing.JTextField VALORF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
