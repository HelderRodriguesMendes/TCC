/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Anuidade_Controller;
import Controller.Controle_caixa_Controller;
import Controller.Formatar_JTextField;
import Controller.Util_Controller;
import DAO.Anuidade_DAO;
import DAO.Conexao_banco;
import DAO.Controle_Caixa_DAO;
import DAO.Sindicalizado_DAO;
import Model.Anuidade;
import Model.Controle_Caixa;
import Model.Propriedades_Rurais;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author helde
 */
public class ControleCaixa_VIEW extends javax.swing.JInternalFrame {

    Connection conexao = null;
    NumberFormat numberCurrencyFormat = NumberFormat.getCurrencyInstance();

    public ControleCaixa_VIEW() {
        initComponents();
        lista_TABELA_PESQUISAR_ALTERAR();
        listarTabela_Anuidades();
        TABELA_PESQUISAR_ALTERAR.getTableHeader().setReorderingAllowed(false);

        LISTA_COMBOBOX();
        conexao = Conexao_banco.conector();
        VOLTAR.setVisible(false);
        VALORF.setDocument(new Formatar_JTextField());
        VALORF.setHorizontalAlignment(JTextField.RIGHT);

    }
    Controle_Caixa c;
    DateFormat df = DateFormat.getDateInstance();
    Controle_Caixa_DAO CC = new Controle_Caixa_DAO();
    Controle_caixa_Controller cc_controler = new Controle_caixa_Controller();
    ArrayList<Date> DATAS = new ArrayList<>();
    Anuidade_Controller AC = new Anuidade_Controller();
    Propriedades_Rurais sr;
    Anuidade_DAO AD = new Anuidade_DAO();
    Sindicalizado_DAO SD = new Sindicalizado_DAO();

    boolean anuidade = false;
    public String status = "";
    public int id_Sind, ano;
    public String nome = "";
    Date dt1 = null, dt2 = null, dt_uni = null;
    String data1 = "", data2 = "", dataUnica1 = "", banco = "";
    int id_controleCaixa = 0, linhaSelecionada, cont_data = 0, cont_mes = 0, cont_data_inter1 = 0, cont_data_inter2 = 0, dataUnica2 = 0, mes = 0, anoRecebidoAnuidade = 0;

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
        VOLTAR = new javax.swing.JLabel();
        TELA2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABELA_PESQUISAR_ALTERAR = new javax.swing.JTable();
        BANCO2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        DATA_INTERVALO2 = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DATA_INTERVALO1 = new com.toedter.calendar.JDateChooser();
        DATA2 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        SALDO_ATUAL = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        NOME_Pesquisar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        STATUS_PA = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        ANOS_CADASTRADOS = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Caixa");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Conta Bacária");

        BANCO1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa ", "Sicredi" }));

        jLabel2.setText("Data:");

        ANUIDADE.setText("Anuidade");
        ANUIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANUIDADEActionPerformed(evt);
            }
        });

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
        jLabel14.setText("Transação Financeira:");

        TRANSACAO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Crédito", "Débito" }));
        TRANSACAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRANSACAOActionPerformed(evt);
            }
        });

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

        VALORF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VALORFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VALORFKeyReleased(evt);
            }
        });

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

        BOTAO_REFAZER_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        BOTAO_REFAZER_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_REFAZER_MouseClicked(evt);
            }
        });

        VOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        VOLTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VOLTARMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(DOCUMENTO, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(4, 4, 4))
                                                .addComponent(BANCO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DATA1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel2)))
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BOTAO_REFAZER_)
                                        .addGap(32, 32, 32)
                                        .addComponent(BOTAO_SALVA_))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ANUIDADE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 71, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VOLTAR))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ANUIDADE)
                                .addGap(59, 59, 59)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DATA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(BOTAO_REFAZER_))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BOTAO_SALVA_)))
                .addContainerGap(13, Short.MAX_VALUE))
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

        FORM_GUIAS.addTab("Cadastrar", TELA1);

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

        BANCO2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa ", "Sicredi" }));

        jLabel19.setText("Banco:");

        DATA_INTERVALO2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA_INTERVALO2PropertyChange(evt);
            }
        });

        jLabel25.setText("Intervalo de datas:");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel20.setText("á");

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

        jLabel24.setText("Saldo:");

        SALDO_ATUAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TELA2Layout = new javax.swing.GroupLayout(TELA2);
        TELA2.setLayout(TELA2Layout);
        TELA2Layout.setHorizontalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel19)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel21))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel25))
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(6, 6, 6)
                .addComponent(SALDO_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        TELA2Layout.setVerticalGroup(
            TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TELA2Layout.createSequentialGroup()
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TELA2Layout.createSequentialGroup()
                        .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TELA2Layout.createSequentialGroup()
                                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel21)))
                                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(TELA2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25)
                                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel20))
                                    .addGroup(TELA2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TELA2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TELA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(SALDO_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        FORM_GUIAS.addTab("Consultar e Alterar", TELA2);

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Celular", "Ano a  receber", "Status de pagamento"
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TABELAMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(TABELA);

        NOME_Pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NOME_PesquisarMouseClicked(evt);
            }
        });
        NOME_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOME_PesquisarActionPerformed(evt);
            }
        });
        NOME_Pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOME_PesquisarKeyPressed(evt);
            }
        });

        jLabel12.setText("Nome:");

        STATUS_PA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Não pago", "Pago" }));
        STATUS_PA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STATUS_PAActionPerformed(evt);
            }
        });

        jLabel13.setText("Status de pagamento");

        ANOS_CADASTRADOS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel28.setText("Ano");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NOME_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel28))
                            .addComponent(ANOS_CADASTRADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(STATUS_PA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)))
                .addGap(1228, 1228, 1228))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NOME_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STATUS_PA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ANOS_CADASTRADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        FORM_GUIAS.addTab("Consultar Taxas Anuais", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        HISTORICO.setEnabled(true);
        TRANSACAO.setEnabled(true);
        ANUIDADE.setEnabled(true);
    }//GEN-LAST:event_BOTAO_REFAZER_MouseClicked

    private void BOTAO_SALVA_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVA_MouseClicked
        if (validarObrigatorios()) {
            if ("cadastrar".equals(status)) {
                if (anuidade) {
                    AD.alterarStatusPagamento(anoRecebidoAnuidade, id_Sind);
                }
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

    private void TABELA_PESQUISAR_ALTERARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELA_PESQUISAR_ALTERARMouseClicked
        linhaSelecionada = TABELA_PESQUISAR_ALTERAR.getSelectedRow();

        String iid = TABELA_PESQUISAR_ALTERAR.getValueAt(linhaSelecionada, 0).toString();
        id_controleCaixa = Integer.parseInt(iid);

        if (null != status) {
            switch (status) {
                case "alterar": {
                    String ObjButtons[] = {"Sim", "Não"};
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Deseja alterar os dados selecionados?", "ATENÇÃO",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            ObjButtons, ObjButtons[1]);
                    if (escolha == 0) {
                        selecionar_guia(0);

                        preencherCamposJtable(linhaSelecionada);
                        BOTAO_REFAZER_.setVisible(false);
                        VOLTAR.setVisible(true);
                    }
                    break;
                }
                case "excluir": {
                    String ObjButtons[] = {"Sim", "Não"};
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Deseja excluir os dados financeiros celecionados?", "ATENÇÃO",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            ObjButtons, ObjButtons[1]);
                    if (escolha == 0) {
                        CC.excluir(id_controleCaixa);
                        lista_TABELA_PESQUISAR_ALTERAR();
                        limparCampus();
                    }
                    break;
                }
                case "restaurar": {
                    String ObjButtons[] = {"Sim", "Não"};
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Deseja restaurar os dados financeiros selecionados?", "ATENÇÃO",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            ObjButtons, ObjButtons[0]);
                    if (escolha == 0) {
                        CC.restaurar(id_controleCaixa);
                        lista_TABELA_RESTAURA_CC();
                        limparCamposPesquisa();
                    }
                    break;
                }
                default:
                    break;
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

                }
            }
        }
    }//GEN-LAST:event_DATA_INTERVALO1PropertyChange

    private void DATA_INTERVALO2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA_INTERVALO2PropertyChange
        cont_data_inter2++;
        if (cont_data_inter2 > 1) {
            String s = ((JTextField) DATA_INTERVALO2.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (dataUnica1.equals("") && mes == 0) {
                    data2 = s; // o (s) ja tem a data formatada em string
                    DATA2.setEnabled(false);
                    DATA2.setDate(null);

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

                }
            }
        }
    }//GEN-LAST:event_DATA2PropertyChange

    private void DATA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DATA2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DATA2MouseClicked

    private void ANUIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANUIDADEActionPerformed
        if (ANUIDADE.isShowing()) {
            anuidade = true;
            listarTabela_Anuidades();
            selecionar_guia(2);
            limparCamposPesquisa_taxas();
            JOptionPane.showMessageDialog(null, "Selecione o sindicalizado proprietário da taxa anual recebida", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ANUIDADEActionPerformed

    private void TRANSACAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRANSACAOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRANSACAOActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        if ("cadastrar".equals(status)) {
            String iid = TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString();
            int i = Integer.parseInt(iid);
            System.out.println("id saindo da tela: " + i);
            nome = TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString();

            String a = TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString();
            ano = Integer.parseInt(a);

            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "A taxa anual recebida realmente é de " + nome + ", " + " referente ao ano " + ano + "?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                recebeAnu(i, ano, nome);
                selecionar_guia(0);
            } else if (escolha == 1) {
                JOptionPane.showMessageDialog(null, "Selecione o sindicalizado desejado", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("alterar".equals(status)) {
            String iid = TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString();
            int i = Integer.parseInt(iid);

            nome = TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString();

            String a = TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString();
            ano = Integer.parseInt(a);

            recebeAnu(i, ano, nome);

        }
    }//GEN-LAST:event_TABELAMouseClicked

    private void NOME_PesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOME_PesquisarMouseClicked

    }//GEN-LAST:event_NOME_PesquisarMouseClicked

    private void NOME_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOME_PesquisarActionPerformed

    }//GEN-LAST:event_NOME_PesquisarActionPerformed

    private void NOME_PesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOME_PesquisarKeyPressed

    }//GEN-LAST:event_NOME_PesquisarKeyPressed

    private void STATUS_PAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STATUS_PAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STATUS_PAActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        if ("relatorio".equals(status)) {
            CC.excluirDatasPesquisa();
        }
    }//GEN-LAST:event_formInternalFrameClosed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String an;
        if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 0 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
            listarTabela_Anuidades();
        } else {
            if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 1 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
                anuidade = true;
                listarTabela_Anuidades();
                anuidade = false;
            } else if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 2 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
                ListaAnuidades_pagas();
            } else if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 1 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                listaAnuidadeNaoPagaAno(ano);
            } else if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 2 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                ListaAnuidades_pagas_ANO(ano);
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 1 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
                ListaAnuidades_Nao_pagas_Nome(NOME_Pesquisar.getText());
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 2 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
                ListaAnuidades_pagas_Nome(NOME_Pesquisar.getText());
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 1 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                ListaAnuidades_Nao_pagas_Nome_Ano(NOME_Pesquisar.getText(), ano);
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 2 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                ListaAnuidades_pagas_Nome_Ano(NOME_Pesquisar.getText(), ano);
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 0 && ANOS_CADASTRADOS.getSelectedIndex() == 0) {
                ListaAnuidades_Nome(NOME_Pesquisar.getText());
            } else if ("".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 0 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                ListaAnuidades_ANO(ano);
            } else if (!"".equals(NOME_Pesquisar.getText()) && STATUS_PA.getSelectedIndex() == 0 && ANOS_CADASTRADOS.getSelectedIndex() > 0) {
                an = String.valueOf(ANOS_CADASTRADOS.getSelectedItem());
                ano = Integer.parseInt(an);
                ListaAnuidades_Nome_ano(NOME_Pesquisar.getText(), ano);
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void TABELAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TABELAMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (BANCO2.getSelectedIndex() == 0 && data2.equals("") && data1.equals("") && dataUnica1.equals("")) {
            lista_TABELA_PESQUISAR_ALTERAR();
        } else {
            banco = String.valueOf(BANCO2.getSelectedItem());
            if ("relatorio".equals(status)) {
                if (data2.equals("") && data1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe as datas para gerar o relatório", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    CC.excluirDatasPesquisa();
                    dt1 = Util_Controller.STRING_DATE(data1);
                    dt2 = Util_Controller.STRING_DATE(data2);
                    CC.salvaDatasPesquisa(dt1, dt2);
                    lista_TABELA_PESQUISAR_ALTERAR_P(banco, data1, data2, dataUnica1);
                }
            } else {
                lista_TABELA_PESQUISAR_ALTERAR_P(banco, data1, data2, dataUnica1);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limparCamposPesquisa();
        SALDO_ATUAL.setText("");
        lista_TABELA_PESQUISAR_ALTERAR();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void VOLTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VOLTARMouseClicked
        selecionar_guia(1);
        limparCampus();
        VOLTAR.setVisible(false);
    }//GEN-LAST:event_VOLTARMouseClicked

    private void VALORFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORFKeyReleased
        String texto = VALORF.getText();
        if (!"".equals(texto)) {
            String valor = AC.formatar(texto);
            VALORF.setText(valor);
        }
    }//GEN-LAST:event_VALORFKeyReleased

    private void VALORFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_VALORFKeyPressed

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
        } else {
            String data = Util_Controller.verificar_Data(df.format(DATA1.getDate()), false);
            if ("//".equals(data)) {
                JOptionPane.showMessageDialog(null, "A data informada é inválida", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                cont++;
                DATA1.setDate(null);
                DATA1.requestFocus();
            }
        }

        if (TRANSACAO.getSelectedIndex() == 0 && cont == 0) {
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

                if ("cadastrar".equals(status)) {
                    this.FORM_GUIAS.setEnabledAt(1, false); // desabilita toda a aba 1        
                    this.FORM_GUIAS.setEnabledAt(2, false); // desabilita toda a aba 1   
                } else if ("alterar".equals(status)) {
                    this.FORM_GUIAS.setTitleAt(n, "Alterar Dados");
                }
                break;
            case 1:
                if (null != status) {
                    switch (status) {
                        case "alterar":
                            this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setEnabledAt(2, true); // desabilita toda a aba 0  
                            break;
                        case "relatorio":
                            this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setEnabledAt(2, false); // desabilita toda a aba 0
                            break;
                        case "excluir":
                            this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setEnabledAt(2, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setTitleAt(1, "Consultar e Excluir");
                            break;
                        case "restaurar":
                            this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setEnabledAt(2, false); // desabilita toda a aba 0
                            this.FORM_GUIAS.setTitleAt(1, "Consultar e Restaurar");
                            lista_TABELA_RESTAURA_CC();
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 2:
                if (anuidade) {
                    this.FORM_GUIAS.setEnabledAt(0, false); // desabilita toda a aba 0
                }
                break;
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

    public final void lista_TABELA_PESQUISAR_ALTERAR() {

        DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
        dtma.setNumRows(0);
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

        TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        if ("restaurar".equals(status)) {
            CC.pesquisar_restaurar().forEach((con) -> {
                String d = "", c = "";
                if (con.getDebito() != 0.0) {
                    double t = con.getDebito();
                    d = Util_Controller.converteMuedaBR(t);
                }
                if (con.getCredito() != 0.0) {
                    double e = con.getCredito();
                    c = Util_Controller.converteMuedaBR(e);
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
        } else {
            CC.listar_tabela_alterar().forEach((con) -> {
                String d = "", c = "";
                if (con.getDebito() != 0.0) {
                    double t = con.getDebito();
                    d = Util_Controller.converteMuedaBR(t);
                }
                if (con.getCredito() != 0.0) {
                    double e = con.getCredito();
                    c = Util_Controller.converteMuedaBR(e);
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
        }

        corLinhaJTable();
    }

    public void lista_TABELA_PESQUISAR_ALTERAR_P(String banco, String d1, String d2, String d_u) {

        ArrayList<Controle_Caixa> C;

        if ("Selecione".equals(banco)) {
            if (!d1.equals("") & !d2.equals("")) {
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data(dt1, dt2);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String de = "", con = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = Util_Controller.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            con = Util_Controller.converteMuedaBR(e);
                        }
                        String d = Util_Controller.DATE_STRING(cc.getData());

                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            con
                        });
                    });
                    corLinhaJTable();
                    c = new Controle_Caixa();
                    c = CC.Consultar_Saldo_Atual_data_data(dt1, dt2);
                    String SALDO = cc_controler.CALCULAR_SALDO_ATUAL(c);
                    SALDO_ATUAL.setText(SALDO);
                    String MES = cc_controler.mesRelatorio(data1, data2);
                    if ("relatorio".equals(status)) {
                        Relatorios(SALDO, dt1, dt2, MES);
                        CC.excluirDatasPesquisa();
                    }
                } else {
                    dadosNAOencontrados();
                }
            } else if (d1.equals("") & !d2.equals("")) {
                JOptionPane.showMessageDialog(null, "Informe duas datas para realizar uma busca por intervalo de datas", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                DATA_INTERVALO1.setFocusable(true);
            } else if (!d1.equals("") & d2.equals("")) {
                JOptionPane.showMessageDialog(null, "Informe duas datas para realizar uma busca por intervalo de datas", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                DATA_INTERVALO2.setFocusable(true);
            } else if (!d_u.equals("")) {
                System.out.println("2");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d_u);

                C = CC.consultar_data(dt1);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", co = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = Util_Controller.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            co = Util_Controller.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            co
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            }
        } else {
            if (!d1.equals("") & !d2.equals("")) {
                System.out.println("4");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data_banco(dt1, dt2, banco);

                if (C != null && !C.isEmpty()) {

                    C.forEach((cc) -> {

                        String de = "", cont = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = Util_Controller.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            cont = Util_Controller.converteMuedaBR(e);
                        }

                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            de,
                            cont
                        });
                    });
                    corLinhaJTable();
                    c = new Controle_Caixa();
                    c = CC.Consultar_Saldo_Atual_data_data_banco(dt1, dt2, banco);
                    String SALDO = cc_controler.CALCULAR_SALDO_ATUAL(c);
                    SALDO_ATUAL.setText(SALDO);
                    String MES = cc_controler.mesRelatorio(data1, data2);
                    if ("relatorio".equals(status)) {
                        Relatorios(SALDO, dt1, dt2, MES);
                        CC.excluirDatasPesquisa();
                    }
                } else {
                    dadosNAOencontrados();
                }
            } else if (!d_u.equals("")) {
                System.out.println("5");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
                dtma.setNumRows(0);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                Date DATAU;

                DATAU = Util_Controller.STRING_DATE(d_u);

                C = CC.consultar_data_banco(DATAU, banco);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = Util_Controller.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = Util_Controller.converteMuedaBR(e);
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
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(60);
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(3).setPreferredWidth(78);

                TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                System.out.println("banco: " + banco);

                C = CC.consultar_banco(banco);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {

                        String de = "", c = "";
                        if (cc.getDebito() != 0.0) {
                            double t = cc.getDebito();
                            de = Util_Controller.converteMuedaBR(t);
                        }
                        if (cc.getCredito() != 0.0) {
                            double e = cc.getCredito();
                            c = Util_Controller.converteMuedaBR(e);
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

        if (!"relatorio".equals(status)) {
            DATA2.setDate(null);
            DATA2.setEnabled(true);
            dataUnica1 = "";
        }

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
        listarTabela_Anuidades();
    }

    public final void LISTA_COMBOBOX() {
        AD.verificarAnuidadesGeradas().forEach((A) -> {
            ANOS_CADASTRADOS.addItem(String.valueOf(A));
        });
    }

    public void corLinhaTabelaAnuidade() {
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

    public final void listarTabela_Anuidades() {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        AN = AD.listar_anuidades_NAO_PAGAS();
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }

    }

    public void listaAnuidadeNaoPagaAno(int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        AN = AD.anuidades_Nao_pagas_ANO(ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_pagas_ANO(int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_pagas_ANO(ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_ANO(int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_ANO(ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_pagas() {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.listar_anuidades_PAGAS();
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_Nao_pagas_Nome(String nome) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_Nao_pagas_Nome(nome);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_pagas_Nome(String nome) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_pagas_Nome(nome);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_Nao_pagas_Nome_Ano(String nome, int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_Nao_pagas_Nome_Ano(nome, ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_pagas_Nome_Ano(String nome, int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_pagas_Nome_Ano(nome, ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_Nome(String nome) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_Nome(nome);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void ListaAnuidades_Nome_ano(String nome, int ano) {
        ArrayList<Anuidade> AN;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(80);
        TABELA.getColumnModel().getColumn(3).setPreferredWidth(100);
        TABELA.getColumnModel().getColumn(4).setPreferredWidth(150);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        AN = AD.anuidades_Nome_Ano(nome, ano);
        if (AN != null && !AN.isEmpty()) {
            AN.forEach((A) -> {
                boolean a = A.isStatusPagamento();
                String s;
                if (a) {
                    s = "Pago";
                } else {
                    s = "Não Pago";
                }
                dtma.addRow(new Object[]{
                    A.getId_sindi(),
                    A.getNome(),
                    A.getCelular(),
                    A.getAnoRecebimento(),
                    s
                });
            });
            corLinhaTabelaAnuidade();
            TABELA.getTableHeader().setReorderingAllowed(false);      // BLOQUIA AS COLUNAS DA TABELA PARA NÃO MOVELAS DO LUGAR
        } else {
            dadosNAOencontrados();
        }
    }

    public void recebeAnu(int id, int ano, String nome) {
        String v;
        if ("cadastrar".equals(status)) {
            Date data = new Date();
            DATA1.setDate(data);
            v = AC.calcularAnuidade(id);
            String[] valor = v.split(" ");
            VALORF.setText(valor[1]);

            String historico = "Anuidade recebida de " + nome + ", " + "ano: " + ano;
            HISTORICO.setText(historico);
            HISTORICO.setEnabled(false);
            
            BANCO1.setSelectedIndex(2);

            TRANSACAO.setSelectedIndex(1);
            TRANSACAO.setEnabled(false);
            id_Sind = id;
            anoRecebidoAnuidade = ano;
            ANUIDADE.setEnabled(false);
        } else if ("alterar".equals(status)) {
            boolean ok = SD.verificaExclusão(id);
            v = AC.calcularAnuidade(id);

            if (ok) {
                JOptionPane.showMessageDialog(null, "O sindicalizado " + nome + " está excluido do sistema." + "\n" + "O valor de sua taxa anual é: " + v + ", referente ao ano: " + ano);
            } else {
                JOptionPane.showMessageDialog(null, "O valor da taxa anual de " + nome + ", referente ao ano " + ano + " é: " + v);
            }
        }
    }

    public void Relatorios(String saldo, Date data1, Date data2, String mes) {
        try {
            HashMap filtro = new HashMap();
            filtro.put("DATA1", data1);
            filtro.put("DATA2", data2);
            filtro.put("SALDO", saldo);
            filtro.put("MES", mes);
            JasperPrint print = JasperFillManager.fillReport("C:\\Users\\helde\\relatorios\\TesteCaixa.jasper", filtro, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório");
            System.out.println(e);
        }
    }

    public void limparCamposPesquisa_taxas() {
        NOME_Pesquisar.setText("");
        STATUS_PA.setSelectedIndex(0);
        ANOS_CADASTRADOS.setSelectedIndex(0);
    }

    public void lista_TABELA_RESTAURA_CC() {

        DefaultTableModel dtma = (DefaultTableModel) TABELA_PESQUISAR_ALTERAR.getModel();
        dtma.setNumRows(0);
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA_PESQUISAR_ALTERAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_PESQUISAR_ALTERAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        CC.pesquisar_restaurar().forEach((con) -> {
            String d = "", c = "";
            if (con.getDebito() != 0.0) {
                double t = con.getDebito();
                d = Util_Controller.converteMuedaBR(t);
            }
            if (con.getCredito() != 0.0) {
                double e = con.getCredito();
                
                c = Util_Controller.converteMuedaBR(e);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ANOS_CADASTRADOS;
    public javax.swing.JCheckBox ANUIDADE;
    private javax.swing.JComboBox<String> BANCO1;
    private javax.swing.JComboBox<Object> BANCO2;
    private javax.swing.JLabel BOTAO_REFAZER_;
    private javax.swing.JLabel BOTAO_SALVA_;
    private com.toedter.calendar.JDateChooser DATA1;
    public com.toedter.calendar.JDateChooser DATA2;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO1;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO2;
    private javax.swing.JTextField DOCUMENTO;
    private javax.swing.JTabbedPane FORM_GUIAS;
    public javax.swing.JTextArea HISTORICO;
    private javax.swing.JTextField NOME_Pesquisar;
    private javax.swing.JLabel SALDO_ATUAL;
    private javax.swing.JComboBox<String> STATUS_PA;
    private javax.swing.JTable TABELA;
    private javax.swing.JTable TABELA_PESQUISAR_ALTERAR;
    public javax.swing.JPanel TELA1;
    public javax.swing.JPanel TELA2;
    public javax.swing.JComboBox<String> TRANSACAO;
    public javax.swing.JTextField VALORF;
    private javax.swing.JLabel VOLTAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
