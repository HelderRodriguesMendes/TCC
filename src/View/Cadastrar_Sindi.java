/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util;
import Controller.Receptor;
import Controller.Sindicalizado;
import DAO.Sindicalizado_DAO;
import Model.Sindicalizado_Entidade;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author helde
 */
public abstract class Cadastrar_Sindi extends javax.swing.JInternalFrame implements Receptor {

    Sindicalizado_Entidade se = new Sindicalizado_Entidade();

    DateFormat df = DateFormat.getDateInstance();
    Sindicalizado si = new Sindicalizado();

    boolean cont = false, LS, LN, alterar = false, login = true;
    int idade, id = 0, t = 0, erro = 0;
    ;
    String senhaC = "", senha = "";

    public Cadastrar_Sindi() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar_Sindi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cadastrar_Sindi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cadastrar_Sindi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cadastrar_Sindi.class.getName()).log(Level.SEVERE, null, ex);
        }

        validaNumerosLetras();

        addWindowListener(new WindowAdapter() { // para confirna se deseja ralmente sair do sistema
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja realmente sair do sistema?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    dispose();
                }
            }
        });

        VOLTAR.setVisible(false);

    }

    public Sindicalizado_Entidade PREENCHER_OBJETO() {
        int n = 0;
        se.setNome(NOME.getText());
        String dtn = df.format(NASCIMENTO.getDate());
        se.setDataNasci(Util.STRING_DATE(dtn));
        se.setCelular(CELULAR.getText());
        se.setNascionalidade(NASCIONALIDADE.getText());
        se.setEstadoCivil(String.valueOf(ESTADOCIVI.getSelectedItem()));
        se.setCpf(CPF.getText());
        se.setRg(RG.getText());
        String dte = df.format(DATAEXPE.getDate());
        se.setDataExpedicao(Util.STRING_DATE(dte));
        se.setTituloEleito(TITULO_ELEITO.getText());
        if (!"   ".equals(ZONA.getText())) {
            se.setZona(Integer.parseInt(ZONA.getText()));
        }
        if (!"    ".equals(SECAO.getText())) {
            se.setSecao(Integer.parseInt(SECAO.getText()));
        }
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
            se.setTiraLeite("Sim");
        } else {
            se.setTiraLeite("Não");
        }
        se.setNIRF(NIRF.getText());
        se.setAreaPropri(AREAFAZENDA.getText());
        se.setTempoCompra(TEMPOCOMPRA.getText());
        se.setOutrasA(OUTRASATIVI.getText());
        se.setLogin(TXT_LOGIN.getText());
        if (alterar) {
            se.setId(this.id);
            if (t == 100) {
                if (TXT_SENHA.getText().equals(this.senha)) {
                    se.setSenha(this.senhaC);
                } else {
                    TXT_SENHA.setText("");
                    se.setSenha("");
                }
            } else {
                se.setSenha("");
            }
        } else {
            if (TXT_SENHA.getText().equals(this.senha)) {
                se.setSenha(this.senhaC);
            } else {
                se.setSenha("");
                TXT_SENHA.setText("");
            }
        }
        se.setTipo_usuario("sindicalizado");
        se.setResidenciaAtual(RESIDEN_ATUAL.getText());

        return se;
    }

    public boolean validar_obrigatorios() {

        String cpf = "";
        LS = LEITE_S.isSelected();
        LN = LEITE_N.isSelected();

        if ("".equals(NOME.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o nome");
            erro = 1;
            NOME.requestFocus();
        } else if (NASCIMENTO.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento");
            erro = 1;
            NASCIMENTO.requestFocus();
        } else {
            String data = Util.verificar_Data(df.format(NASCIMENTO.getDate()), true);
            idade = Util.idade;

            if ("//".equals(data)) {
                if (idade < 18) {
                    JOptionPane.showMessageDialog(null, "Não é permitido o cadastramento de sindicalizado menor de idade", "Atenção", JOptionPane.ERROR_MESSAGE);
                    erro = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "A data de nascimento do sindicalizado é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                    erro = 1;
                }
                NASCIMENTO.setDate(null);
            }
        }
        if (erro == 0 && "   .   .    -   ".equals(CPF.getText()) || "".equals(CPF.getText())) {
            erro = 1;
            JOptionPane.showMessageDialog(null, "Informe o CPF do sindicalizado ");
            CPF.requestFocus();
        } else {
            cpf = si.verificar_CPF(CPF.getText());
            if ("".equals(cpf) && erro == 0) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O CPF do sindicalizado é invalido", "Atenção CPF invalido", JOptionPane.ERROR_MESSAGE);
                CPF.setText("   .   .    -   ");
                CPF.requestFocus();
            }
        }

        if ((erro == 0) && "       ".equals(RG.getText()) || "".equals(RG.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o RG");
            RG.requestFocus();
            erro = 1;
        } else {
            String R_G = si.validadar_RG(RG.getText());
            if ("".equals(R_G)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado é invalido", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
                RG.setText("       ");
                RG.requestFocus();
            } else if ("-7".equals(R_G)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado deve conter 7 números", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
            } else if ("+7".equals(R_G)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado deve conter apenas 7 números", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (DATAEXPE.getDate() == null && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe a data de expedição do RG");
            DATAEXPE.requestFocus();
            erro = 1;
        } else if (erro == 0) {
            String data = Util.verificar_Data(df.format(DATAEXPE.getDate()), false);
            if ("//".equals(data)) {
                JOptionPane.showMessageDialog(null, "A data de Expedição do RG do sindicalizado é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                erro = 1;
                DATAEXPE.setDate(null);
                DATAEXPE.requestFocus();
            }
        }
        if ("".equals(NASCIONALIDADE.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe a nascionalidade");
            NASCIONALIDADE.requestFocus();
            erro = 1;
        } else if ("".equals(PAI.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe a filiação paterna");
            PAI.requestFocus();
            erro = 1;
        } else if ("".equals(MAE.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe a filiação materna");
            MAE.requestFocus();
            erro = 1;
        } else if ("".equals(NOMEFAZENDA.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe o nome da propriedade rural");
            NOMEFAZENDA.requestFocus();
            erro = 1;
        } else if ("".equals(LOGRADOURO.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe o logradouro da propriedade rural");
            LOGRADOURO.requestFocus();
            erro = 1;
        } else if ("".equals(MUNICEDE.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe o municipio cede da propriedade rural");
            MUNICEDE.requestFocus();
            erro = 1;
        } else if (LS == false && LN == false && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe se a comercialização de leite na propriedade rural");
            jLabel27.requestFocus();
            erro = 1;
        } else if ("".equals(AREAFAZENDA.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe a area da propriedade rural");
            AREAFAZENDA.requestFocus();
            erro = 1;
        } else if ("".equals(TEMPOCOMPRA.getText()) && erro == 0) {
            JOptionPane.showMessageDialog(null, "Informe o tempo de compra da propriedade rural");
            TEMPOCOMPRA.requestFocus();
            erro = 1;
        } else if ("".equals(TXT_LOGIN.getText()) && erro == 0) {
            erro = 1;
            JOptionPane.showMessageDialog(null, "Informe o login de acesso ao sistema");
            TXT_LOGIN.requestFocus();
        } else if (!alterar && erro == 0) {
            if ("".equals(TXT_SENHA.getText()) && erro == 0) {
                JOptionPane.showMessageDialog(null, "Informe a senha de acesso ao sistema");
                erro = 1;
            }
        } else if (t == 5 && erro == 0) {
            if ("".equals(TXT_SENHA.getText()) && erro == 0) {
                JOptionPane.showMessageDialog(null, "Informe a senha de acesso ao sistema");
                TXT_SENHA.requestFocus();
                erro = 1;
            }
        } else if (!"(  ) 9     -     ".equals(CELULAR.getText()) && erro == 0) {        // DAQUI PRA BAIXO COMEÇA A VALIDAÇÃO DOS QUE NÃO SÃO OBRIGATÓRIOS 
            String TEL = si.validadar_Telefone(CELULAR.getText());
            if ("".equals(TEL)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O telefone do sindicalizado é invalido", "Atenção", JOptionPane.ERROR_MESSAGE);
                CELULAR.setText("(  ) 9     -     ");
                CELULAR.requestFocus();
            }
        } else if (!"".equals(RESERVISTA.getText()) && erro == 0) {
            String RESER = si.validarReservista(RESERVISTA.getText());
            if ("".equals(RESER)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O número da reservista do sindicalizado é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                RESERVISTA.setText("");
                RESERVISTA.requestFocus();
            }
        } else if (!"              ".equals(TITULO_ELEITO.getText()) && erro == 0) {
            String titu = si.validar_Titulo_Eleitor(TITULO_ELEITO.getText());
            if ("".equals(titu)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O titulo de eleitor do sindicalizado é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                TITULO_ELEITO.setText("              ");
                TITULO_ELEITO.requestFocus();
            }
        } else if (!"   ".equals(ZONA.getText()) && erro == 0) {
            String zona = si.validar_zona(ZONA.getText());
            if ("".equals(zona)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "A zona do titulo de eleitor do sindicalizado é invalida.", "Atenção", JOptionPane.ERROR_MESSAGE);
                ZONA.setText("   ");
                ZONA.requestFocus();
            }
        } else if (!"    ".equals(SECAO.getText()) && erro == 0) {
            String secao = si.validar_secao(SECAO.getText());
            if ("".equals(secao)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "A seção do titulo de eleitor do sindicalizado é invalida.", "Atenção", JOptionPane.ERROR_MESSAGE);
                SECAO.setText("   ");
                SECAO.requestFocus();
            }
        } else if (!"   .   .   .   - ".equals(CODINCRA.getText()) && erro == 0) {
            String codI = si.validaCodIncra(CODINCRA.getText());
            if ("".equals(codI)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O código do INCRA do sindicalizado é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                CODINCRA.setText("   .   .   .   - ");
                CODINCRA.requestFocus();
            }
        } else if (!" .   .   - ".equals(NIRF.getText()) && erro == 0) {
            String nirf = si.validarNIRF(NIRF.getText());
            if ("".equals(nirf)) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O número do NIRF do sindicalizado é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                NIRF.setText(" .   .   - ");
                NIRF.requestFocus();
            }
        }
        if (erro == 0) {
            cont = true;
        } else if (erro == 1) {
            cont = false;
        }

        return cont;
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void limparCampus() {
        NOME.setText("");
        NASCIMENTO.setDate(null);
        ESTADOCIVI.setSelectedIndex(0);
        CPF.setText("");
        CELULAR.setText("");
        RG.setText("");
        DATAEXPE.setDate(null);
        NASCIONALIDADE.setText("");
        RESERVISTA.setText("");
        CATEGORIA.setText("");
        TITULO_ELEITO.setText("");
        ZONA.setText("");
        SECAO.setText("");
        PAI.setText("");
        MAE.setText("");
        NOMEFAZENDA.setText("");
        AREAFAZENDA.setText("");
        LOGRADOURO.setText("");
        NIRF.setText("");
        MUNICEDE.setText("");
        TEMPOCOMPRA.setText("");
        CODINCRA.setText("");
        LEITE_S.setSelected(false);
        LEITE_N.setSelected(false);
        OUTRASATIVI.setText("");
        TXT_LOGIN.setText("");
        TXT_SENHA.setText("");
        RESIDEN_ATUAL.setText("");

    }

    public void validaNumerosLetras() {
        Util.soLetras(NOME);
        Util.soNumeros(RG);
        Util.soLetras(NASCIONALIDADE);
        Util.soNumeros(RESERVISTA);
        Util.soNumeros(TITULO_ELEITO);
        Util.soNumeros(ZONA);
        Util.soNumeros(SECAO);
        Util.soLetras(PAI);
        Util.soLetras(MAE);
        Util.soLetras(NOMEFAZENDA);
        Util.soLetras(MUNICEDE);
        Util.soLetras(RESIDEN_ATUAL);
    }

    public void preencher_campus_alteracao(Sindicalizado_Entidade si) {

        NOME.setText(si.getNome());
        NASCIMENTO.setDate(si.getDataNasci());
        ESTADOCIVI.setSelectedItem(si.getEstadoCivil());
        CPF.setText(si.getCpf());
        CELULAR.setText(si.getCelular());
        RG.setText(si.getRg());
        DATAEXPE.setDate(si.getDataExpedicao());
        NASCIONALIDADE.setText(si.getNascionalidade());
        RESERVISTA.setText(si.getReservista());
        CATEGORIA.setText(si.getCategoria());
        TITULO_ELEITO.setText(si.getTituloEleito());
        if (si.getZona() == 0) {
            ZONA.setText("");
        } else {
            ZONA.setText(String.valueOf(si.getZona()));
        }
        if (si.getSecao() == 0) {
            SECAO.setText("");
        } else {
            SECAO.setText(String.valueOf(si.getSecao()));
        }
        PAI.setText(si.getPai());
        MAE.setText(si.getMae());
        NOMEFAZENDA.setText(si.getNomeFazenda());
        AREAFAZENDA.setText(si.getAreaPropri());
        LOGRADOURO.setText(si.getLogradouro());
        NIRF.setText(si.getNIRF());
        MUNICEDE.setText(si.getMuniciSede());
        TEMPOCOMPRA.setText(si.getTempoCompra());
        CODINCRA.setText(si.getCodINCRA());
        if ("sim".equals(si.getTiraLeite())) {
            LEITE_S.setSelected(true);
            LEITE_N.setSelected(false);
        } else {
            LEITE_S.setSelected(false);
            LEITE_N.setSelected(true);
        }
        OUTRASATIVI.setText(si.getOutrasA());
        TXT_LOGIN.setText(si.getLogin());
        RESIDEN_ATUAL.setText(si.getResidenciaAtual());

        this.alterar = true;
        TXT_SENHA.setEnabled(false);
        this.id = si.getId();
        VOLTAR.setVisible(true);
        BT_ATU.setVisible(false);
    }

    @Override
    public void receber(String senhaC, String senha) {
        TXT_SENHA.setText(senha);
        TXT_SENHA.setEnabled(true);
        this.senhaC = senhaC;
        this.senha = senha;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NOME = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        CELULAR = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        CPF = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ESTADOCIVI = new javax.swing.JComboBox<>();
        RG = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PAI = new javax.swing.JTextField();
        MAE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NASCIONALIDADE = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TITULO_ELEITO = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        ZONA = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        SECAO = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        RESERVISTA = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        CATEGORIA = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        NASCIMENTO = new com.toedter.calendar.JDateChooser();
        DATAEXPE = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        TXT_LOGIN = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        TXT_SENHA = new javax.swing.JTextField();
        RESIDEN_ATUAL = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BT_ATU = new javax.swing.JLabel();
        BOTAO_SALVAR_ = new javax.swing.JLabel();
        VOLTAR = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar sindicalizado");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Nome:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");

        jLabel7.setText("Data de nascimento:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");

        try {
            CELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9#### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CELULAR.setToolTipText("");
        CELULAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CELULARActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.### - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");

        jLabel11.setText("Estado civil:");

        ESTADOCIVI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Casado", "Solteiro", "Viúvo", "Divorciado", " " }));

        try {
            RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");
        jLabel31.setPreferredSize(new java.awt.Dimension(13, 30));

        jLabel4.setText("RG:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Pai:");

        PAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PAIMouseEntered(evt);
            }
        });

        MAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MAEMouseEntered(evt);
            }
        });

        jLabel6.setText("Mãe:");

        jLabel47.setText("FILIAÇÃO:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel50.setText("*");
        jLabel50.setIconTextGap(8);
        jLabel50.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel51.setText("*");
        jLabel51.setIconTextGap(8);
        jLabel51.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel50)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel51)
                .addGap(4, 4, 4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel50)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Data de expedição:");

        jLabel2.setText("Celular:");

        NASCIONALIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NASCIONALIDADEActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel52.setText("*");
        jLabel52.setIconTextGap(8);

        jLabel9.setText("Nascionalidade:");

        try {
            TITULO_ELEITO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("Titulo de eleitor:");

        try {
            ZONA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Zona:");

        try {
            SECAO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        SECAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SECAOActionPerformed(evt);
            }
        });

        jLabel15.setText("Seção:");

        try {
            RESERVISTA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setText("Reservista:");

        jLabel17.setText("Categoria:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel32)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)
                        .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel52))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(9, 9, 9)
                        .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(3, 3, 3)
                                        .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel13)
                                        .addGap(4, 4, 4)
                                        .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102)
                                .addComponent(jLabel14))
                            .addComponent(jLabel12))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(jLabel15)
                                .addGap(6, 6, 6)
                                .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11))
                    .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel33))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel20.setText("Nome da propriedade rural:");

        jLabel21.setText("Logradouro:");

        jLabel22.setText("Municipio cede:");

        jLabel23.setText("Código do imovel no INCRA:");

        jLabel24.setText("Numero NIRF:");

        jLabel25.setText("Area da prorpiedade:");

        jLabel26.setText("Tempo de compra da propriedade:");

        jLabel28.setText("Outras atividades:");

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

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel48.setText("Login:");

        jLabel49.setText("Senha:");

        TXT_SENHA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_SENHAFocusGained(evt);
            }
        });
        TXT_SENHA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXT_SENHAMouseClicked(evt);
            }
        });
        TXT_SENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_SENHAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel49)
                .addGap(2, 2, 2)
                .addComponent(TXT_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(TXT_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel10.setText("Residência atual:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(804, 804, 804)
                        .addComponent(jLabel29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(4, 4, 4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(3, 3, 3)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MUNICEDE)
                                    .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(jLabel25)
                                        .addGap(3, 3, 3)
                                        .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel44))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel26)
                                        .addGap(1, 1, 1)
                                        .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel45)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel40))
                                    .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(LEITE_S)
                                        .addGap(6, 6, 6)
                                        .addComponent(LEITE_N)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel46))))
                            .addComponent(RESIDEN_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(jLabel44)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addComponent(jLabel40)
                    .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MUNICEDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(jLabel45)
                    .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jLabel41)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LEITE_N, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(LEITE_S))))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RESIDEN_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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

        VOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        VOLTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VOLTARMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(BT_ATU)
                        .addGap(41, 41, 41)
                        .addComponent(BOTAO_SALVAR_))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(VOLTAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOTAO_SALVAR_))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PAIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAIMouseEntered
        PAI.setToolTipText("Filiação");
    }//GEN-LAST:event_PAIMouseEntered

    private void MAEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MAEMouseEntered
        MAE.setToolTipText("Filiação");
    }//GEN-LAST:event_MAEMouseEntered

    private void CELULARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CELULARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CELULARActionPerformed

    private void NASCIONALIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NASCIONALIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NASCIONALIDADEActionPerformed

    private void RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGActionPerformed
        DATAEXPE.setEnabled(true);
    }//GEN-LAST:event_RGActionPerformed

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
        boolean v;
        Sindicalizado_DAO sd = new Sindicalizado_DAO();
        if (erro == 1) {
            erro = 0;
        }
        v = validar_obrigatorios();
        if (v) {
            if (!alterar) {
                if ("".equals(PREENCHER_OBJETO().getSenha()) && t == 100 && "".equals(TXT_SENHA.getText())) {
                    validar_obrigatorios();
                } else {
                    login = sd.SALVAR(PREENCHER_OBJETO());
                    if (login) {
                        limparCampus();
                        NOME.requestFocus();
                    } else {
                        TXT_LOGIN.setText("");
                        TXT_LOGIN.requestFocus();
                    }
                }
            } else {
                if ("".equals(PREENCHER_OBJETO().getSenha())) {
                    if (t != 100) {                // NÃO CLICOU PARA ALTERAR SENHA
                        login = sd.alterar_sind(PREENCHER_OBJETO(), this.id);
                        if (login) {
                            Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
                            pas.setVisible(true);
                            Interface.DESKTOP.add(pas);
                            pas.setPosicao();
                            this.dispose();
                        } else {
                            TXT_LOGIN.setText("");
                            TXT_LOGIN.requestFocus();
                        }
                    } else {
                        String ObjButtons[] = {"Sim", "Não"};
                        int PromptResult = JOptionPane.showOptionDialog(null,
                                "Tem certeza que não deseja alterar a senha?", "ATENÇÃO",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                ObjButtons, ObjButtons[1]);
                        if (PromptResult == 0) {
                            login = sd.alterar_sind(PREENCHER_OBJETO(), this.id);
                            if (!login) {
                                Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
                                pas.setVisible(true);
                                Interface.DESKTOP.add(pas);
                                pas.setPosicao();
                                this.dispose();
                            } else {
                                TXT_LOGIN.setText("");
                                TXT_LOGIN.requestFocus();
                            }
                        } else if (PromptResult == 1) {
                            t = 5;
                            validar_obrigatorios();
                        }
                    }
                } else {

                    login = sd.alterar_sind(PREENCHER_OBJETO(), this.id);
                    if (login) {
                        Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
                        pas.setVisible(true);
                        Interface.DESKTOP.add(pas);
                        pas.setPosicao();
                        this.dispose();
                    } else {
                        TXT_LOGIN.setText("");
                        TXT_LOGIN.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_BOTAO_SALVAR_MouseClicked

    private void SECAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SECAOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SECAOActionPerformed

    private void TXT_SENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_SENHAActionPerformed


    }//GEN-LAST:event_TXT_SENHAActionPerformed

    private void TXT_SENHAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXT_SENHAMouseClicked
        if ("".equals(TXT_SENHA.getText())) {
            Alterar_senha as = new Alterar_senha(this);
            Interface.DESKTOP.add(as);
            as.setVisible(true);
            as.setPosicao();
            t = 100;
        }
    }//GEN-LAST:event_TXT_SENHAMouseClicked

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited

    }//GEN-LAST:event_jPanel5MouseExited

    private void TXT_SENHAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_SENHAFocusGained
//        if (evt.getSource() == TXT_SENHA) {
//            if ("".equals(TXT_SENHA.getText())) {
//                Alterar_senha as = new Alterar_senha(this);
//                Interface.DESKTOP.add(as);
//                as.setVisible(true);
//                as.setPosicao();
//                t = 100;
//            }
//        }
    }//GEN-LAST:event_TXT_SENHAFocusGained

    private void VOLTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VOLTARMouseClicked
        Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
        Interface.DESKTOP.add(pas);
        pas.setVisible(true);
        pas.setPosicao();
        this.dispose();
    }//GEN-LAST:event_VOLTARMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AREAFAZENDA;
    private javax.swing.JLabel BOTAO_SALVAR_;
    private javax.swing.JLabel BT_ATU;
    private javax.swing.JTextField CATEGORIA;
    private javax.swing.JFormattedTextField CELULAR;
    private javax.swing.JFormattedTextField CODINCRA;
    private javax.swing.JFormattedTextField CPF;
    private com.toedter.calendar.JDateChooser DATAEXPE;
    private javax.swing.JComboBox<String> ESTADOCIVI;
    private javax.swing.JCheckBox LEITE_N;
    private javax.swing.JCheckBox LEITE_S;
    private javax.swing.JTextField LOGRADOURO;
    private javax.swing.JTextField MAE;
    private javax.swing.JTextField MUNICEDE;
    private com.toedter.calendar.JDateChooser NASCIMENTO;
    private javax.swing.JTextField NASCIONALIDADE;
    private javax.swing.JFormattedTextField NIRF;
    private javax.swing.JTextField NOME;
    private javax.swing.JTextField NOMEFAZENDA;
    private javax.swing.JTextPane OUTRASATIVI;
    private javax.swing.JTextField PAI;
    private javax.swing.JFormattedTextField RESERVISTA;
    private javax.swing.JTextField RESIDEN_ATUAL;
    private javax.swing.JFormattedTextField RG;
    private javax.swing.JFormattedTextField SECAO;
    private javax.swing.JTextField TEMPOCOMPRA;
    private javax.swing.JFormattedTextField TITULO_ELEITO;
    private javax.swing.JTextField TXT_LOGIN;
    public javax.swing.JTextField TXT_SENHA;
    private javax.swing.JLabel VOLTAR;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
