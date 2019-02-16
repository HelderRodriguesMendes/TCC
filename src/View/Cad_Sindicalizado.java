/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Conversao;
import Model.DAO.Sindicalizado_DAO;
import Model.Entidadades.Sindicalizado_Entidade;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public class Cad_Sindicalizado extends javax.swing.JInternalFrame {

    Sindicalizado_Entidade se = new Sindicalizado_Entidade();
    Sindicalizado_DAO sd = new Sindicalizado_DAO();
    Conversao conv = new Conversao();
    boolean cont = false, LS, LN;

    public Cad_Sindicalizado() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cad_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cad_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cad_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cad_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sindicalizado_Entidade PREENCHER_OBJETO() {
        se.setNome(NOME.getText());
        se.setDataNasci(conv.STRING_DATE(NASCIMENTO.getText()));
        se.setCelular(CELULAR.getText());
        se.setNascionalidade(NASCIONALIDADE.getText());
        se.setNaturalidade(NATURALIDADE.getText());
        se.setEstadoCivil(String.valueOf(ESTADOCIVI.getSelectedItem()));
        se.setCpf(CPF.getText());
        se.setRg(RG.getText());
        se.setDataExpedicao(conv.STRING_DATE(DATAEXPE.getText()));
        se.setTituloEleito(TITULO_ELEITO.getText());
        se.setZona(Integer.parseInt(ZONA.getText()));
        se.setSecao(Integer.parseInt(SECAO.getText()));
        se.setReservista(RESERVISTA.getText());
        se.setCategoria(CATEGORIA.getText());
        se.setPai(PAI.getText());
        se.setMae(MAE.getText());
        se.setNomeFazenda(NOMEFAZENDA.getText());
        se.setLogradouro(LOGRADOURO.getText());
        se.setMuniciSede(MUNICEDE.getText());
        se.setCodINCRA(CODINCRA.getText());
        LS = LEITE_S.isSelected();
        if (LS == true) {
            se.setTiraLeite(1);
        } else {
            se.setTiraLeite(0);
        }
        se.setNIRF(NIRF.getText());
        se.setAreaPropri(AREAFAZENDA.getText());
        se.setTempoCompra(TEMPOCOMPRA.getText());
        se.setOutrasA(OUTRASATIVI.getText());
        return se;
    }

    public boolean validar_obrigatorios() {
        LS = LEITE_S.isSelected();
        LN = LEITE_N.isSelected();
        if ("".equals(NOME.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o nome");
            NOME.requestFocus();
        } else if ("  /  /    ".equals(NASCIMENTO.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento");
            NASCIMENTO.requestFocus();
        } else if ("            -   ".equals(CPF.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o CPF");
            CPF.requestFocus();
        } else if ("       ".equals(RG.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o RG");
            RG.requestFocus();
        } else if ("  /  /    ".equals(DATAEXPE.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a data de expedição do RG");
            DATAEXPE.requestFocus();
        } else if ("                 ".equals(TITULO_ELEITO.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o titulo de eleitor");
            TITULO_ELEITO.requestFocus();
        } else if ("   ".equals(ZONA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a zona do titulo de eleitor");
            ZONA.requestFocus();
        } else if ("    ".equals(SECAO.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a seção do titulo de eleitor");
            SECAO.requestFocus();
        } else if ("".equals(RESERVISTA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a reservista");
            RESERVISTA.requestFocus();
        } else if ("".equals(CATEGORIA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a categoria da reservista");
            CATEGORIA.requestFocus();
        } else if ("".equals(NOMEFAZENDA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o nome da propriedade rural");
            NOMEFAZENDA.requestFocus();
        } else if ("".equals(LOGRADOURO.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o logradouro da propriedade rural");
            LOGRADOURO.requestFocus();
        } else if ("".equals(MUNICEDE.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o municipio cede da propriedade rural");
            MUNICEDE.requestFocus();
        } else if ("   .   .   .   - ".equals(CODINCRA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o código no INCRA da propriedade rural");
            CODINCRA.requestFocus();
        } else if (LS == false && LN == false) {
            JOptionPane.showMessageDialog(null, "Informe se a comercialização de leite na propriedade rural");
            jLabel27.requestFocus();
        } else if (" .   .   - ".equals(NIRF.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o numero no NIRF da propriedade rural");
            NIRF.requestFocus();
        } else if ("".equals(AREAFAZENDA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe a area da propriedade rural");
            AREAFAZENDA.requestFocus();
        } else if ("".equals(TEMPOCOMPRA.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o tempo de compra da propriedade rural");
            TEMPOCOMPRA.requestFocus();
        } else {
            cont = true;
        }
        return cont;
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void limparCampus() {
        NOME.setText("");
        NASCIMENTO.setText("");
        CELULAR.setText("");
        NASCIONALIDADE.setText("");
        NATURALIDADE.setText("");
        ESTADOCIVI.setSelectedIndex(0);
        CPF.setText("");
        RG.setText("");
        DATAEXPE.setText("");
        TITULO_ELEITO.setText("");
        ZONA.setText("");
        SECAO.setText("");
        RESERVISTA.setText("");
        CATEGORIA.setText("");
        PAI.setText("");
        MAE.setText("");
        NOMEFAZENDA.setText("");
        LOGRADOURO.setText("");
        MUNICEDE.setText("");
        CODINCRA.setText("");
        LEITE_S.setSelected(false);
        LEITE_N.setSelected(false);
        NIRF.setText("");
        AREAFAZENDA.setText("");
        TEMPOCOMPRA.setText("");
        OUTRASATIVI.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NOME = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CELULAR = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        CPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        RG = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        PAI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        MAE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        NASCIMENTO = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        NASCIONALIDADE = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        NATURALIDADE = new javax.swing.JTextField();
        DATAEXPE = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        RESERVISTA = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CATEGORIA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ESTADOCIVI = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        TITULO_ELEITO = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        SECAO = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ZONA = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        NOMEFAZENDA = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        LOGRADOURO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        MUNICEDE = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        AREAFAZENDA = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        TEMPOCOMPRA = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        SALVAR_1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        CODINCRA = new javax.swing.JFormattedTextField();
        NIRF = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        LEITE_S = new javax.swing.JCheckBox();
        LEITE_N = new javax.swing.JCheckBox();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OUTRASATIVI = new javax.swing.JTextPane();
        BT_ATU = new javax.swing.JLabel();
        BOTAO_SALVAR_ = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("Cadastrar sindicalizado");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("Dados pessoais");

        jLabel1.setText("Nome:");

        jLabel2.setText("Celular:");

        try {
            CELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9#### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CELULAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CELULARActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ### - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("RG:");

        try {
            RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Pai:");

        PAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PAIMouseEntered(evt);
            }
        });

        jLabel6.setText("Mãe:");

        MAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MAEMouseEntered(evt);
            }
        });

        jLabel7.setText("Data de nascimento:");

        try {
            NASCIMENTO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Nascionalidade:");

        NASCIONALIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NASCIONALIDADEActionPerformed(evt);
            }
        });

        jLabel10.setText("Naturalidade:");

        try {
            DATAEXPE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Data de expedição:");

        jLabel16.setText("Reservista:");

        jLabel17.setText("Categoria:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");
        jLabel31.setPreferredSize(new java.awt.Dimension(13, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel37.setText("*");
        jLabel37.setIconTextGap(8);
        jLabel37.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel38.setText("*");
        jLabel38.setIconTextGap(8);

        jLabel11.setText("Estado civil:");

        ESTADOCIVI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Casado", "Solteiro", "Viúvo", "Divorciado", " " }));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Titulo de eleitor:");

        try {
            TITULO_ELEITO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("*");
        jLabel34.setIconTextGap(8);
        jLabel34.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel15.setText("Seção:");

        try {
            SECAO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel36.setText("*");
        jLabel36.setIconTextGap(8);
        jLabel36.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel14.setText("Zona:");

        try {
            ZONA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel35.setText("*");
        jLabel35.setIconTextGap(8);
        jLabel35.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel35)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel15)
                        .addGap(6, 6, 6)
                        .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel47.setText("FILIAÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(4, 4, 4)
                                .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel4)
                                .addGap(4, 4, 4)
                                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(8, 8, 8)
                                .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(3, 3, 3)
                                .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel33)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11)
                                .addGap(4, 4, 4)
                                .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel47))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel32)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(NATURALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(NATURALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel11))
                                            .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel47))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel16))
                            .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel5)
                            .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setText("Nome da propriedade rural:");

        jLabel21.setText("Logradouro:");

        jLabel22.setText("Municipio cede:");

        jLabel23.setText("Código do imovel no INCRA:");

        jLabel24.setText("Numero NIRF:");

        jLabel25.setText("Area da prorpiedade:");

        jLabel26.setText("Tempo de compra da propriedade:");

        jLabel28.setText("Outras atividades:");

        SALVAR_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SALVAR_1MouseClicked(evt);
            }
        });

        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel39.setText("*");
        jLabel39.setIconTextGap(8);
        jLabel39.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel40.setText("*");
        jLabel40.setIconTextGap(8);
        jLabel40.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 0, 0));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel41.setText("*");
        jLabel41.setIconTextGap(8);
        jLabel41.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 0, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel42.setText("*");
        jLabel42.setIconTextGap(8);
        jLabel42.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel43.setText("*");
        jLabel43.setIconTextGap(8);
        jLabel43.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel44.setText("*");
        jLabel44.setIconTextGap(8);
        jLabel44.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel45.setText("*");
        jLabel45.setIconTextGap(8);
        jLabel45.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        try {
            CODINCRA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            NIRF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel27.setText("Comencializa leite:");

        LEITE_S.setText("Sim");

        LEITE_N.setText("Não");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel46.setText("*");
        jLabel46.setIconTextGap(8);
        jLabel46.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jScrollPane1.setViewportView(OUTRASATIVI);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(SALVAR_1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel28)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel43)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel44)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel26)
                                .addGap(4, 4, 4)
                                .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(4, 4, 4)
                                .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel39)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel21)
                                .addGap(4, 4, 4)
                                .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel40)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel22)
                                .addGap(4, 4, 4)
                                .addComponent(MUNICEDE, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel41)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel42))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addGap(3, 3, 3)
                                .addComponent(LEITE_S)
                                .addGap(6, 6, 6)
                                .addComponent(LEITE_N)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel46)))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(MUNICEDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jLabel42)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addComponent(jLabel43)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LEITE_S))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LEITE_N))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel46))
                    .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(SALVAR_1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel28))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        BT_ATU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        BT_ATU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ATUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BT_ATUMouseEntered(evt);
            }
        });

        BOTAO_SALVAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        BOTAO_SALVAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_SALVAR_MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home (1).png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(488, 488, 488)
                .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BOTAO_SALVAR_)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOTAO_SALVAR_))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Dados pessoais");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CELULARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CELULARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CELULARActionPerformed

    private void NASCIONALIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NASCIONALIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NASCIONALIDADEActionPerformed

    private void SALVAR_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SALVAR_1MouseClicked
        boolean r = validar_obrigatorios();
        if (r == true) {
            sd.SALVAR(PREENCHER_OBJETO());
        }
    }//GEN-LAST:event_SALVAR_1MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void BT_ATUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseClicked
        limparCampus();
    }//GEN-LAST:event_BT_ATUMouseClicked

    private void BT_ATUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseEntered
        BT_ATU.setToolTipText("Limpar campus");
    }//GEN-LAST:event_BT_ATUMouseEntered

    private void BOTAO_SALVAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVAR_MouseClicked
        boolean v = false;
        v = validar_obrigatorios();
        if (v) {
            sd.SALVAR(PREENCHER_OBJETO());
            limparCampus();
        }
    }//GEN-LAST:event_BOTAO_SALVAR_MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void PAIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAIMouseEntered
        PAI.setToolTipText("Filiação");
    }//GEN-LAST:event_PAIMouseEntered

    private void MAEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MAEMouseEntered
        MAE.setToolTipText("Filiação");
    }//GEN-LAST:event_MAEMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AREAFAZENDA;
    private javax.swing.JLabel BOTAO_SALVAR_;
    private javax.swing.JLabel BT_ATU;
    private javax.swing.JTextField CATEGORIA;
    private javax.swing.JFormattedTextField CELULAR;
    private javax.swing.JFormattedTextField CODINCRA;
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JFormattedTextField DATAEXPE;
    private javax.swing.JComboBox<String> ESTADOCIVI;
    private javax.swing.JCheckBox LEITE_N;
    private javax.swing.JCheckBox LEITE_S;
    private javax.swing.JTextField LOGRADOURO;
    private javax.swing.JTextField MAE;
    private javax.swing.JTextField MUNICEDE;
    private javax.swing.JFormattedTextField NASCIMENTO;
    private javax.swing.JTextField NASCIONALIDADE;
    private javax.swing.JTextField NATURALIDADE;
    private javax.swing.JFormattedTextField NIRF;
    private javax.swing.JTextField NOME;
    private javax.swing.JTextField NOMEFAZENDA;
    private javax.swing.JTextPane OUTRASATIVI;
    private javax.swing.JTextField PAI;
    private javax.swing.JTextField RESERVISTA;
    private javax.swing.JFormattedTextField RG;
    private javax.swing.JLabel SALVAR_1;
    private javax.swing.JFormattedTextField SECAO;
    private javax.swing.JTextField TEMPOCOMPRA;
    private javax.swing.JFormattedTextField TITULO_ELEITO;
    private javax.swing.JFormattedTextField ZONA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
