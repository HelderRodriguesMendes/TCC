/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Sindicalizado;
import Controller.Util;
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
public class Cadastrar_Sindicalizado extends javax.swing.JInternalFrame {

    Sindicalizado_Entidade se = new Sindicalizado_Entidade();

    DateFormat df = DateFormat.getDateInstance();
    Sindicalizado si = new Sindicalizado();

    boolean cont = false, LS, LN, alterar = false, login = true;
    int idade, id = 0, t = 0, erro = 0;
    ;
    String senhaC = "", senha = "";

    public Cadastrar_Sindicalizado() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cadastrar_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cadastrar_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cadastrar_Sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
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
        se.setResidenciaAtual(RESIDEN_ATUAL.getText());
        se.setExcluido(0);

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
            cpf = si.validar_CPF(CPF.getText());
            if ("".equals(cpf) && erro == 0) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O CPF do sindicalizado é invalido", "Atenção CPF invalido", JOptionPane.ERROR_MESSAGE);
                CPF.setText("   .   .    -   ");
                CPF.requestFocus();
            } else {
                String i;
                if (alterar) {
                    i = si.verificar_CPF(CPF.getText(), id);
                } else {
                    i = si.verificar_CPF(CPF.getText(), 0);
                }
                if ("tem dono".equals(i)) {
                    erro = 1;
                    JOptionPane.showMessageDialog(null, "O CPF informado já esta cadastrado", "Atenção CPF invalido", JOptionPane.ERROR_MESSAGE);
                    CPF.setText("");
                    CPF.requestFocus();
                }
            }
        }

        if ((erro == 0) && "       ".equals(RG.getText()) || "".equals(RG.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o RG");
            RG.requestFocus();
            erro = 1;
        } else {
            String R_G = si.validadar_RG(RG.getText());
            if ("".equals(R_G) && erro == 0) {
                erro = 1;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado é invalido", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
                RG.setText("       ");
                RG.requestFocus();
            } else {
                String i;
                if (alterar) {
                    i = si.verificar_RG(RG.getText(), id);
                } else {
                    i = si.verificar_RG(RG.getText(), 0);
                }
                if ("tem dono".equals(i)) {
                    erro = 1;
                    JOptionPane.showMessageDialog(null, "O RG informado já esta cadastrado", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
                    RG.setText("");
                    RG.requestFocus();
                }
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
        RESIDEN_ATUAL.setText("");

    }

    public final void validaNumerosLetras() {
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
        RESIDEN_ATUAL.setText(si.getResidenciaAtual());

        this.alterar = true;
        this.id = si.getId();
        VOLTAR.setVisible(true);
        BT_ATU.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        NOMEFAZENDA = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        LOGRADOURO = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        MUNICEDE = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        AREAFAZENDA = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        TEMPOCOMPRA = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        CODINCRA = new javax.swing.JFormattedTextField();
        NIRF = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        LEITE_S = new javax.swing.JCheckBox();
        LEITE_N = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OUTRASATIVI = new javax.swing.JTextPane();
        RESIDEN_ATUAL = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        CELULAR = new javax.swing.JFormattedTextField();
        jLabel79 = new javax.swing.JLabel();
        CPF = new javax.swing.JFormattedTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        ESTADOCIVI = new javax.swing.JComboBox<>();
        RG = new javax.swing.JFormattedTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        PAI = new javax.swing.JTextField();
        MAE = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        NASCIONALIDADE = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        TITULO_ELEITO = new javax.swing.JFormattedTextField();
        jLabel93 = new javax.swing.JLabel();
        ZONA = new javax.swing.JFormattedTextField();
        jLabel94 = new javax.swing.JLabel();
        SECAO = new javax.swing.JFormattedTextField();
        jLabel95 = new javax.swing.JLabel();
        RESERVISTA = new javax.swing.JFormattedTextField();
        jLabel96 = new javax.swing.JLabel();
        CATEGORIA = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        NASCIMENTO = new com.toedter.calendar.JDateChooser();
        DATAEXPE = new com.toedter.calendar.JDateChooser();
        jLabel98 = new javax.swing.JLabel();
        NOME = new javax.swing.JTextField();
        VOLTAR = new javax.swing.JLabel();
        BT_ATU = new javax.swing.JLabel();
        BOTAO_SALVAR_ = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel45.setText("Nome da propriedade rural:");

        jLabel46.setText("Logradouro:");

        jLabel59.setText("Municipio cede:");

        jLabel60.setText("Código do imovel no INCRA:");

        jLabel61.setText("Numero NIRF:");

        jLabel62.setText("Area da prorpiedade:");

        jLabel63.setText("Tempo de compra da propriedade:");

        jLabel64.setText("Outras atividades:");

        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel65MouseClicked(evt);
            }
        });

        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 0, 0));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel67.setText("*");
        jLabel67.setIconTextGap(8);
        jLabel67.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 0, 0));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel68.setText("*");
        jLabel68.setIconTextGap(8);
        jLabel68.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 0));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel69.setText("*");
        jLabel69.setIconTextGap(8);
        jLabel69.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 0, 0));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel70.setText("*");
        jLabel70.setIconTextGap(8);
        jLabel70.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 0, 0));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel71.setText("*");
        jLabel71.setIconTextGap(8);
        jLabel71.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

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

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 0, 0));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel73.setText("*");
        jLabel73.setIconTextGap(8);
        jLabel73.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jScrollPane1.setViewportView(OUTRASATIVI);

        jLabel74.setText("Residência atual:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel65)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel45)
                                .addGap(4, 4, 4)
                                .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel67)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel62)
                                .addGap(3, 3, 3)
                                .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel70)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel59)
                                .addGap(3, 3, 3)
                                .addComponent(MUNICEDE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel69)
                                .addGap(84, 84, 84))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel46)
                                .addGap(4, 4, 4)
                                .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(jLabel61)
                                .addGap(4, 4, 4)
                                .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel60)
                                .addGap(4, 4, 4)
                                .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(4, 4, 4)
                                .addComponent(LEITE_S)
                                .addGap(6, 6, 6)
                                .addComponent(LEITE_N)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel73))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(1, 1, 1)
                                .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel71))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel74)
                        .addGap(4, 4, 4)
                        .addComponent(RESIDEN_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)))
                .addGap(32, 32, 32))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel66)
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NOMEFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AREAFAZENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62))
                    .addComponent(jLabel70)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel45))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MUNICEDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel59))
                    .addComponent(jLabel69)
                    .addComponent(jLabel71)
                    .addComponent(TEMPOCOMPRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CODINCRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LOGRADOURO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46))
                            .addComponent(jLabel68)
                            .addComponent(NIRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel61)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RESIDEN_ATUAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel64))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel73)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LEITE_N, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(LEITE_S)))))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel75.setText("Nome:");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 0));
        jLabel76.setText("*");

        jLabel77.setText("Data de nascimento:");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 0, 0));
        jLabel78.setText("*");

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

        jLabel79.setText("CPF:");

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.### - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 0));
        jLabel80.setText("*");

        jLabel81.setText("Estado civil:");

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

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 0, 0));
        jLabel82.setText("*");
        jLabel82.setPreferredSize(new java.awt.Dimension(13, 30));

        jLabel83.setText("RG:");

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel84.setText("Pai:");

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

        jLabel85.setText("Mãe:");

        jLabel86.setText("FILIAÇÃO:");

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 0, 0));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel87.setText("*");
        jLabel87.setIconTextGap(8);
        jLabel87.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 0, 0));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel88.setText("*");
        jLabel88.setIconTextGap(8);
        jLabel88.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel87)
                .addGap(26, 26, 26)
                .addComponent(jLabel85)
                .addGap(4, 4, 4)
                .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel88)
                .addGap(4, 4, 4))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88)
                    .addComponent(jLabel87)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)
                        .addComponent(jLabel85)
                        .addComponent(MAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel86)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel89.setText("Data de expedição:");

        jLabel90.setText("Celular:");

        NASCIONALIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NASCIONALIDADEActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 0, 0));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel91.setText("*");
        jLabel91.setIconTextGap(8);

        jLabel92.setText("Nascionalidade:");

        try {
            TITULO_ELEITO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel93.setText("Titulo de eleitor:");

        try {
            ZONA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel94.setText("Zona:");

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

        jLabel95.setText("Seção:");

        try {
            RESERVISTA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel96.setText("Reservista:");

        jLabel97.setText("Categoria:");

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 0, 0));
        jLabel98.setText("*");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addGap(12, 12, 12)
                                .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel75)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel92)
                                        .addGap(6, 6, 6)
                                        .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel91))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel76)))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel96)
                                    .addGap(3, 3, 3)
                                    .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel77)
                                    .addGap(116, 116, 116)
                                    .addComponent(jLabel78)
                                    .addGap(47, 47, 47)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel81)
                                            .addGap(3, 3, 3)
                                            .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel97)
                                            .addGap(9, 9, 9)
                                            .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(82, 82, 82)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel79)
                                            .addGap(6, 6, 6)
                                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel80))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel93)
                                            .addGap(4, 4, 4)
                                            .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(4, 4, 4)
                        .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addGap(4, 4, 4)
                        .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addGap(4, 4, 4)
                        .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel98))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addGap(6, 6, 6)
                        .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel81))
                                    .addComponent(ESTADOCIVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel79))
                                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel80))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel77))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NASCIMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel78))))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel97)
                                    .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RESERVISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TITULO_ELEITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel96)
                                            .addComponent(jLabel93)))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel75)
                                    .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel90))
                                    .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel92)
                                    .addComponent(NASCIONALIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel83))
                            .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DATAEXPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel89)
                                    .addComponent(jLabel98)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ZONA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SECAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel95))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        VOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        VOLTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VOLTARMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(578, 578, 578)
                        .addComponent(BT_ATU)
                        .addGap(41, 41, 41)
                        .addComponent(BOTAO_SALVAR_))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(VOLTAR)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOTAO_SALVAR_))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel65MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel65MouseClicked

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel66MouseClicked

    private void CELULARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CELULARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CELULARActionPerformed

    private void RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGActionPerformed
        DATAEXPE.setEnabled(true);
    }//GEN-LAST:event_RGActionPerformed

    private void PAIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAIMouseEntered
        PAI.setToolTipText("Filiação");
    }//GEN-LAST:event_PAIMouseEntered

    private void MAEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MAEMouseEntered
        MAE.setToolTipText("Filiação");
    }//GEN-LAST:event_MAEMouseEntered

    private void NASCIONALIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NASCIONALIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NASCIONALIDADEActionPerformed

    private void SECAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SECAOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SECAOActionPerformed

    private void VOLTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VOLTARMouseClicked
        Pesquisar_Alterar_sindicalizado pas = new Pesquisar_Alterar_sindicalizado();
        Interface.DESKTOP.add(pas);
        pas.uso = "alterar";
        pas.setVisible(true);
        pas.setPosicao();
        this.dispose();
    }//GEN-LAST:event_VOLTARMouseClicked

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
                sd.SALVAR(PREENCHER_OBJETO());
                limparCampus();
                NOME.requestFocus();
            } else {
                sd.alterar_sind(PREENCHER_OBJETO(), this.id);
                limparCampus();
                NOME.requestFocus();
            }
        }
    }//GEN-LAST:event_BOTAO_SALVAR_MouseClicked


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
    private javax.swing.JLabel VOLTAR;
    private javax.swing.JFormattedTextField ZONA;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
