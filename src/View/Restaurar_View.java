/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util_Controller;
import DAO.AdministradorDAO;
import DAO.Controle_Caixa_DAO;
import DAO.Sindicalizado_Pessoais_DAO;
import DAO.Sindicalizado_Rurais_DAO;
import Model.Administrador;
import Model.Controle_Caixa;
import Model.Sindicalizado_Pessoais;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helde
 */
public final class Restaurar_View extends javax.swing.JInternalFrame {

    int cont = 0, ID = 0, cont_data = 0, cont_data_inter1 = 0, cont_data_inter2 = 0, dataUnica2 = 0, linhaSelecionada, id_controleCaixa = 0;
    public int NULL = 0;
    boolean nulo = false;        
    String data1 = "", data2 = "", dataUnica1 = "", nome = "", banco = "";
    Date dt1 = null, dt2 = null, dt_uni = null;

    Sindicalizado_Pessoais_DAO dsp = new Sindicalizado_Pessoais_DAO();
    Sindicalizado_Rurais_DAO DADOSR = new Sindicalizado_Rurais_DAO();
     Controle_Caixa_DAO CC = new Controle_Caixa_DAO();

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
        
        TABELA_DADOS_EXCLUIDOS.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_DADOS_EXCLUIDOS.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        
        lista_TABELA_RESTAURA_CC();
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
        } else {
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

        TABELA_P_RESTAURAR.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_P_RESTAURAR.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

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
    
    
public void lista_TABELA_RESTAURAR_CC_P(String b, String d1, String d2, String d_u) {

        ArrayList<Controle_Caixa> C;
        System.out.println("A1");
        if ("Selecione".equals(b)) {
            System.out.println("0");
            if (!d1.equals("") & !d2.equals("")) {
                System.out.println("1");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data(dt1, dt2);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
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
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d_u);

                C = CC.consultar_data(dt1);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
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
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_data_banco(dt1, dt2, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else if (!d1.equals("")) {
                System.out.println("5");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                dt1 = Util_Controller.STRING_DATE(d1);

                C = CC.consultar_data_banco(dt1, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else if (!d2.equals("")) {
                System.out.println("6");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                dt2 = Util_Controller.STRING_DATE(d2);

                C = CC.consultar_data_banco(dt2, b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            } else {
                System.out.println("7");
                DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
                dtma.setNumRows(0);
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

                TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
                TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

                System.out.println("banco: " + b);

                C = CC.consultar_banco(b);

                if (C != null && !C.isEmpty()) {
                    C.forEach((cc) -> {
                        String d = Util_Controller.DATE_STRING(cc.getData());
                        dtma.addRow(new Object[]{
                            cc.getId(),
                            d,
                            cc.getBanco(),
                            cc.getHistorico(),
                            cc.getDocumento(),
                            cc.getDebito(),
                            cc.getCredito()
                        });
                    });
                    corLinhaJTable();
                } else {
                    dadosNAOencontrados();
                }
            }
        }
    }
    
    public void lista_TABELA_RESTAURA_CC() {

        DefaultTableModel dtma = (DefaultTableModel) TABELA_RESTAURAR_CC.getModel();
        dtma.setNumRows(0);
        TABELA_RESTAURAR_CC.getColumnModel().getColumn(2).setPreferredWidth(110);

        TABELA_RESTAURAR_CC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA_RESTAURAR_CC.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO

        CC.pesquisar_restaurar().forEach((con) -> {
            String d = "", c = "";
            if (con.getDebito() != 0.0) {
                double t = con.getDebito();
                d = String.valueOf(t);
            }
            if (con.getCredito() != 0.0) {
                double e = con.getCredito();
                c = String.valueOf(e);
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
    
    public void dadosNAOencontrados() {
        JOptionPane.showMessageDialog(null, "Os dados pesquisados não foram encontrados", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        lista_TABELA_RESTAURA_CC();
    }
    
    public void limparCamposPesquisa_controleCaixa() {
        BANCO2.setSelectedIndex(0);
        BANCO2.setEnabled(true);

        DATA2.setDate(null);
        DATA2.setEnabled(true);
        dataUnica1 = "";

        DATA_INTERVALO1.setDate(null);
        DATA_INTERVALO1.setEnabled(true);
        data1 = "";

        DATA_INTERVALO2.setDate(null);
        DATA_INTERVALO2.setEnabled(true);
        data2 = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        ADMIN_SIND = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        RESTAURA_SIND_ = new javax.swing.JButton();
        RESTAURA_ADM_ = new javax.swing.JButton();
        TXT_NOME = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PROPRIEDADE_RURAL = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABELA_P_RESTAURAR = new javax.swing.JTable();
        NOME_RESTAU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABELA_DADOS_EXCLUIDOS = new javax.swing.JTable();
        CONTROLE_CAIXA = new javax.swing.JPanel();
        BANCO2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        DATA2 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        DATA_INTERVALO2 = new com.toedter.calendar.JDateChooser();
        DATA_INTERVALO1 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        BOTAO_PESQUISAR_ = new javax.swing.JLabel();
        REFAZER_PESQUISA_ = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TABELA_RESTAURAR_CC = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Restaurar");

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

        javax.swing.GroupLayout ADMIN_SINDLayout = new javax.swing.GroupLayout(ADMIN_SIND);
        ADMIN_SIND.setLayout(ADMIN_SINDLayout);
        ADMIN_SINDLayout.setHorizontalGroup(
            ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                        .addComponent(RESTAURA_SIND_)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(RESTAURA_ADM_))
                    .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ADMIN_SINDLayout.setVerticalGroup(
            ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADMIN_SINDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                        .addGroup(ADMIN_SINDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(RESTAURA_SIND_)
                                .addGap(0, 120, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(ADMIN_SINDLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(RESTAURA_ADM_)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Sindicalizado - Administrador", ADMIN_SIND);

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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

        javax.swing.GroupLayout PROPRIEDADE_RURALLayout = new javax.swing.GroupLayout(PROPRIEDADE_RURAL);
        PROPRIEDADE_RURAL.setLayout(PROPRIEDADE_RURALLayout);
        PROPRIEDADE_RURALLayout.setHorizontalGroup(
            PROPRIEDADE_RURALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PROPRIEDADE_RURALLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PROPRIEDADE_RURALLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(NOME_RESTAU, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(153, 153, 153))
        );
        PROPRIEDADE_RURALLayout.setVerticalGroup(
            PROPRIEDADE_RURALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PROPRIEDADE_RURALLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PROPRIEDADE_RURALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(PROPRIEDADE_RURALLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(PROPRIEDADE_RURALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NOME_RESTAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PROPRIEDADE_RURALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(PROPRIEDADE_RURAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Propriedade Rural", jPanel4);

        BANCO2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa Interno", "Sicredi" }));

        jLabel19.setText("Banco:");

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

        DATA_INTERVALO2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA_INTERVALO2PropertyChange(evt);
            }
        });

        DATA_INTERVALO1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DATA_INTERVALO1PropertyChange(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel20.setText("Há");

        jLabel25.setText("Intervalo de datas:");

        BOTAO_PESQUISAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        BOTAO_PESQUISAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_PESQUISAR_MouseClicked(evt);
            }
        });

        REFAZER_PESQUISA_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        REFAZER_PESQUISA_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REFAZER_PESQUISA_MouseClicked(evt);
            }
        });

        TABELA_RESTAURAR_CC.setModel(new javax.swing.table.DefaultTableModel(
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
        TABELA_RESTAURAR_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELA_RESTAURAR_CCMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TABELA_RESTAURAR_CC);

        javax.swing.GroupLayout CONTROLE_CAIXALayout = new javax.swing.GroupLayout(CONTROLE_CAIXA);
        CONTROLE_CAIXA.setLayout(CONTROLE_CAIXALayout);
        CONTROLE_CAIXALayout.setHorizontalGroup(
            CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTROLE_CAIXALayout.createSequentialGroup()
                .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel19)))
                        .addGap(77, 77, 77)
                        .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTROLE_CAIXALayout.createSequentialGroup()
                                .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTROLE_CAIXALayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(82, 82, 82))))
                    .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(REFAZER_PESQUISA_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BOTAO_PESQUISAR_)
                        .addGap(9, 9, 9)))
                .addGap(21, 21, 21))
        );
        CONTROLE_CAIXALayout.setVerticalGroup(
            CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DATA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BANCO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DATA_INTERVALO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DATA_INTERVALO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(CONTROLE_CAIXALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BOTAO_PESQUISAR_))
                    .addGroup(CONTROLE_CAIXALayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(REFAZER_PESQUISA_)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Controle de Caixa", CONTROLE_CAIXA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void DATA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DATA2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DATA2MouseClicked

    private void DATA2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA2PropertyChange
        cont_data++;
        if (cont_data > 1) {
            String s = ((JTextField) DATA2.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (data1.equals("") && data2.equals("")) {
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

    private void DATA_INTERVALO2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA_INTERVALO2PropertyChange
        cont_data_inter2++;
        if (cont_data_inter2 > 1) {
            String s = ((JTextField) DATA_INTERVALO2.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (dataUnica1.equals("")) {
                    data2 = s; // o (s) ja tem a data formatada em string
                    DATA2.setEnabled(false);
                    DATA2.setDate(null);                    
                }
            }
        }
    }//GEN-LAST:event_DATA_INTERVALO2PropertyChange

    private void DATA_INTERVALO1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DATA_INTERVALO1PropertyChange
        cont_data_inter1++;

        if (cont_data_inter1 > 1) {
            String s = ((JTextField) DATA_INTERVALO1.getDateEditor().getUiComponent()).getText(); // verifica se o campo de data esta vazio ou não
            if (!s.equals("")) {
                if (dataUnica1.equals("")) {
                    data1 = s; // o (s) ja tem a data formatada em string
                    DATA2.setEnabled(false);
                    DATA2.setDate(null);
                }
            }
        }
    }//GEN-LAST:event_DATA_INTERVALO1PropertyChange

    private void BOTAO_PESQUISAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_PESQUISAR_MouseClicked
        int m = Calendar.getInstance().get(Calendar.MONTH);

        if (BANCO2.getSelectedIndex() == 0 && data2.equals("") && data1.equals("") && dataUnica1.equals("")) {
            lista_TABELA_RESTAURA_CC();
        } else {
            banco = String.valueOf(BANCO2.getSelectedItem());
            System.out.println("clico");
            lista_TABELA_RESTAURAR_CC_P(banco, data1, data2, dataUnica1);
        }
    }//GEN-LAST:event_BOTAO_PESQUISAR_MouseClicked

    private void REFAZER_PESQUISA_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REFAZER_PESQUISA_MouseClicked
        limparCamposPesquisa_controleCaixa();
        lista_TABELA_RESTAURA_CC();
    }//GEN-LAST:event_REFAZER_PESQUISA_MouseClicked

    private void TABELA_RESTAURAR_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELA_RESTAURAR_CCMouseClicked
        linhaSelecionada = TABELA_RESTAURAR_CC.getSelectedRow();

        String iid = TABELA_RESTAURAR_CC.getValueAt(linhaSelecionada, 0).toString();
        id_controleCaixa = Integer.parseInt(iid);
        
        String ObjButtons[] = {"Sim", "Não"};                  
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Deseja restalrar os dados financeiros selecionados?", "ATENÇÃO",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            ObjButtons, ObjButtons[0]);
                    if (escolha == 0) {
                        CC.restaurar(id_controleCaixa);
                        lista_TABELA_RESTAURA_CC();
                        limparCamposPesquisa_controleCaixa();
                    }
        
    }//GEN-LAST:event_TABELA_RESTAURAR_CCMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADMIN_SIND;
    private javax.swing.JComboBox<Object> BANCO2;
    private javax.swing.JLabel BOTAO_PESQUISAR_;
    private javax.swing.JPanel CONTROLE_CAIXA;
    private com.toedter.calendar.JDateChooser DATA2;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO1;
    private com.toedter.calendar.JDateChooser DATA_INTERVALO2;
    private javax.swing.JTextField NOME_RESTAU;
    private javax.swing.JPanel PROPRIEDADE_RURAL;
    private javax.swing.JLabel REFAZER_PESQUISA_;
    private javax.swing.JButton RESTAURA_ADM_;
    private javax.swing.JButton RESTAURA_SIND_;
    private javax.swing.JTable TABELA;
    private javax.swing.JTable TABELA_DADOS_EXCLUIDOS;
    private javax.swing.JTable TABELA_P_RESTAURAR;
    private javax.swing.JTable TABELA_RESTAURAR_CC;
    private javax.swing.JTextField TXT_NOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
