/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util;
import Controller.Login;
import Controller.Sindicalizado;
import DAO.Conexao_banco;
import DAO.Sindicalizado_DAO;
import DAO.Util_DAO;
import Model.Dados_Pessoais;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author helde
 */
public class Pesquisar_Alterar_sindicalizado extends javax.swing.JInternalFrame {

    Sindicalizado_DAO sd = new Sindicalizado_DAO();
    Dados_Pessoais se = new Dados_Pessoais();
    
    Sindicalizado si = new Sindicalizado();
    Connection conexao = null;

    int cont = 0, con = 0, id = 0, idade, ID = 0;
    boolean niver, ok;
    public String uso = "";

    public Pesquisar_Alterar_sindicalizado() {
        initComponents();
        conexao = Conexao_banco.conector();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pesquisar_Alterar_sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Pesquisar_Alterar_sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Pesquisar_Alterar_sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Pesquisar_Alterar_sindicalizado.class.getName()).log(Level.SEVERE, null, ex);
        }

        listar_Tabela();
        
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
        BOTAO_PESQUISAR_ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CPF = new javax.swing.JFormattedTextField();
        RG = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Nome:");

        NOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NOMEMouseClicked(evt);
            }
        });
        NOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMEActionPerformed(evt);
            }
        });
        NOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOMEKeyPressed(evt);
            }
        });

        BOTAO_PESQUISAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        BOTAO_PESQUISAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_PESQUISAR_ActionPerformed(evt);
            }
        });

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de nascimento", "Telefone", "Nascionalidade", "Estado civil", "CPF", "RG", "Data de Expedição", "Titulo de Eleitor", "Zona", "Seção", "Reservistal", "Categoria", "Nome do pai", "Nome da mãe", "Nome da propriedade rural", "Logradouro", "Municipio cede", "Código no INCRA", "Número no NIRF", "Area da propriedade rural", "Tempo de compra da propriedade", "Outras atividades", "Comercialização de leite", "Residência atual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jLabel3.setText("CPF:");

        jLabel4.setText("RG:");

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.### - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CPFKeyPressed(evt);
            }
        });

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
        RG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RGKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(BOTAO_PESQUISAR_)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(BOTAO_PESQUISAR_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_PESQUISAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_PESQUISAR_ActionPerformed
        if ("".equals(NOME.getText()) && "   .   .    -   ".equals(CPF.getText()) && "       ".equals(RG.getText())) {
            listar_Tabela();
        } else {
            ID = 0;
            ID = pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
            int r = Util.selectNull(ID);
            if (r == 0 || r < 0) {
                NOME.setText("");
                CPF.setValue(null);
                RG.setValue(null);
                listar_Tabela();
            }
        }
    }//GEN-LAST:event_BOTAO_PESQUISAR_ActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        cont = 10;

        id = Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString());
        if ("alterar".equals(uso)) {

            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja alterar os dados selecionados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                Cadastrar_Sindicalizado cs = new Cadastrar_Sindicalizado() {
                };
//                cs.preencher_campus_alteracao(PREENCHER_OBJETO());
                cs.setTitle("Alterar dados do Sindicalizado");
                cs.setVisible(true);
                Interface.DESKTOP.add(cs);
//                cs.setPosicao();
                cs.id = this.id;
                this.dispose();
            }
        } else if ("excluir".equals(uso)) {
            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Tem certeza que deseja excluir esses dados?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                Util_DAO ud = new Util_DAO();
                ud.excluir(id, "sind");
                listar_Tabela();
            }
        } else if ("relatorio".equals(uso)) {

            String ObjButtons[] = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Deseja emitir um relatório com os dados desse sindicalizado?", "ATENÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, ObjButtons[1]);
            if (escolha == 0) {
                Relatorio(id);
            }
        }

    }//GEN-LAST:event_TABELAMouseClicked

    private void NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMEActionPerformed

    }//GEN-LAST:event_NOMEActionPerformed

    private void NOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOMEMouseClicked

    }//GEN-LAST:event_NOMEMouseClicked

    private void RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGActionPerformed

    }//GEN-LAST:event_RGActionPerformed

    private void NOMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMEKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(NOME.getText()) && "   .   .    -   ".equals(CPF.getText()) && "       ".equals(RG.getText())) {
                listar_Tabela();
            } else {
                ID = 0;
                ID = pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
                int r = Util.selectNull(ID);
                if (r == 0 || r < 0) {
                    NOME.setText("");
                    CPF.setValue(null);
                    RG.setValue(null);
                    listar_Tabela();
                }
            }
        }
    }//GEN-LAST:event_NOMEKeyPressed

    private void RGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RGKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(NOME.getText()) && "   .   .    -   ".equals(CPF.getText()) && "       ".equals(RG.getText())) {
                listar_Tabela();
            } else {
                ID = 0;
                ID = pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
                int r = Util.selectNull(ID);
                if (r == 0 || r < 0) {
                    NOME.setText("");
                    CPF.setValue(null);
                    RG.setValue(null);
                    listar_Tabela();
                }
            }
        }
    }//GEN-LAST:event_RGKeyPressed

    private void CPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(NOME.getText()) && "   .   .    -   ".equals(CPF.getText()) && "       ".equals(RG.getText())) {
                listar_Tabela();
            } else {
                ID = 0;
                ID = pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
                int r = Util.selectNull(ID);
                if (r == 0 || r < 0) {
                    NOME.setText("");
                    CPF.setValue(null);
                    RG.setValue(null);
                    listar_Tabela();
                }
            }
        }
    }//GEN-LAST:event_CPFKeyPressed

    public void listar_Tabela() {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sd.listar_Tabela().forEach((sin) -> {
            String dn = Util.DATE_STRING(sin.getDataNasci());
            String de = Util.DATE_STRING(sin.getDataExpedicao());
            String fone = sin.getCelular();
            if ("(  ) 9     -     ".equals(fone)) {
                fone = "";
            }
            int zo = sin.getZona();
            String zona;
            if (zo == 0) {
                zona = "";
            } else {
                zona = String.valueOf(zo);
            }

            int sec = sin.getSecao();
            String secao;
            if (sec == 0) {
                secao = "";
            } else {
                secao = String.valueOf(sec);
            }

            String inc = sin.getCodINCRA();
            if ("   .   .   .   - ".equals(inc)) {
                inc = "";
            }

            String nirf = sin.getNIRF();
            if (" .   .   - ".equals(nirf)) {
                nirf = "";
            }

            dtma.addRow(new Object[]{
                sin.getId_sindi(),
                sin.getNome(),
                dn,
                fone,
                sin.getNascionalidade(),
                sin.getEstadoCivil(),
                sin.getCpf(),
                sin.getRg(),
                de,
                sin.getTituloEleito(),
                zona,
                secao,
                sin.getReservista(),
                sin.getCategoria(),
                sin.getPai(),
                sin.getMae(),
                sin.getNomeFazenda(),
                sin.getLogradouro(),
                sin.getMuniciSede(),
                inc,
                nirf,
                sin.getAreaPropri(),
                sin.getTempoCompra(),
                sin.getOutrasA(),
                sin.getTiraLeite(),
                sin.getResidenciaAtual()
            });
        });

    }

    public int pesquisar_Sind(String nome, String cpf, String rg) {
        int a = 0;
        System.out.println("aqi 1");
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (!"".equals(nome) && !"   .   .    -   ".equals(cpf) && !"       ".equals(rg)) {
            a = 1;
            sd.pesquisar_nome_cpf_rg(nome, cpf, rg).forEach((sin) -> {
                ID = sin.getId_sindi();
                dtma.addRow(new Object[]{
                    sin.getId_sindi(),
                    sin.getNome(),
                    sin.getDataNasci(),
                    sin.getCelular(),
                    sin.getNascionalidade(),
                    sin.getEstadoCivil(),
                    sin.getCpf(),
                    sin.getRg(),
                    sin.getDataExpedicao(),
                    sin.getTituloEleito(),
                    sin.getZona(),
                    sin.getSecao(),
                    sin.getReservista(),
                    sin.getCategoria(),
                    sin.getPai(),
                    sin.getMae(),
                    sin.getNomeFazenda(),
                    sin.getLogradouro(),
                    sin.getMuniciSede(),
                    sin.getCodINCRA(),
                    sin.getNIRF(),
                    sin.getAreaPropri(),
                    sin.getTempoCompra(),
                    sin.getOutrasA(),
                    sin.getTiraLeite(),
                    sin.getResidenciaAtual()
                });
            });
        } else if (!"".equals(nome)) {
            System.out.println("2");
            a = 1;
            if (!"   .   .    -   ".equals(cpf)) {
                sd.pesquisar_nome_cpf(nome, cpf).forEach((sin) -> {
                    ID = sin.getId_sindi();
                    System.out.println("ID ID " + ID);
                    dtma.addRow(new Object[]{
                        sin.getId_sindi(),
                        sin.getNome(),
                        sin.getDataNasci(),
                        sin.getCelular(),
                        sin.getNascionalidade(),
                        sin.getEstadoCivil(),
                        sin.getCpf(),
                        sin.getRg(),
                        sin.getDataExpedicao(),
                        sin.getTituloEleito(),
                        sin.getZona(),
                        sin.getSecao(),
                        sin.getReservista(),
                        sin.getCategoria(),
                        sin.getPai(),
                        sin.getMae(),
                        sin.getNomeFazenda(),
                        sin.getLogradouro(),
                        sin.getMuniciSede(),
                        sin.getCodINCRA(),
                        sin.getNIRF(),
                        sin.getAreaPropri(),
                        sin.getTempoCompra(),
                        sin.getOutrasA(),
                        sin.getTiraLeite(),
                        sin.getResidenciaAtual()
                    });
                });
            } else if (!"       ".equals(rg)) {
                sd.pesquisar_nome_rg(nome, rg).forEach((sin) -> {
                    ID = sin.getId_sindi();
                    dtma.addRow(new Object[]{
                        sin.getId_sindi(),
                        sin.getNome(),
                        sin.getDataNasci(),
                        sin.getCelular(),
                        sin.getNascionalidade(),
                        sin.getEstadoCivil(),
                        sin.getCpf(),
                        sin.getRg(),
                        sin.getDataExpedicao(),
                        sin.getTituloEleito(),
                        sin.getZona(),
                        sin.getSecao(),
                        sin.getReservista(),
                        sin.getCategoria(),
                        sin.getPai(),
                        sin.getMae(),
                        sin.getNomeFazenda(),
                        sin.getLogradouro(),
                        sin.getMuniciSede(),
                        sin.getCodINCRA(),
                        sin.getNIRF(),
                        sin.getAreaPropri(),
                        sin.getTempoCompra(),
                        sin.getOutrasA(),
                        sin.getTiraLeite(),
                        sin.getResidenciaAtual()
                    });
                });
            } else {
                sd.pesquisar_nome(nome).forEach((sin) -> {
                    ID = sin.getId_sindi();
                    System.out.println("ID ID 2: " + ID);
                    dtma.addRow(new Object[]{
                        sin.getId_sindi(),
                        sin.getNome(),
                        sin.getDataNasci(),
                        sin.getCelular(),
                        sin.getNascionalidade(),
                        sin.getEstadoCivil(),
                        sin.getCpf(),
                        sin.getRg(),
                        sin.getDataExpedicao(),
                        sin.getTituloEleito(),
                        sin.getZona(),
                        sin.getSecao(),
                        sin.getReservista(),
                        sin.getCategoria(),
                        sin.getPai(),
                        sin.getMae(),
                        sin.getNomeFazenda(),
                        sin.getLogradouro(),
                        sin.getMuniciSede(),
                        sin.getCodINCRA(),
                        sin.getNIRF(),
                        sin.getAreaPropri(),
                        sin.getTempoCompra(),
                        sin.getOutrasA(),
                        sin.getTiraLeite(),
                        sin.getResidenciaAtual()
                    });
                });
            }
        } else if (!"   .   .    -   ".equals(cpf)) {
            a = 1;
            if (!"       ".equals(rg)) {
                sd.pesquisar_cpf_rg(cpf, rg).forEach((sin) -> {
                    ID = sin.getId_sindi();
                    dtma.addRow(new Object[]{
                        sin.getId_sindi(),
                        sin.getNome(),
                        sin.getDataNasci(),
                        sin.getCelular(),
                        sin.getNascionalidade(),
                        sin.getEstadoCivil(),
                        sin.getCpf(),
                        sin.getRg(),
                        sin.getDataExpedicao(),
                        sin.getTituloEleito(),
                        sin.getZona(),
                        sin.getSecao(),
                        sin.getReservista(),
                        sin.getCategoria(),
                        sin.getPai(),
                        sin.getMae(),
                        sin.getNomeFazenda(),
                        sin.getLogradouro(),
                        sin.getMuniciSede(),
                        sin.getCodINCRA(),
                        sin.getNIRF(),
                        sin.getAreaPropri(),
                        sin.getTempoCompra(),
                        sin.getOutrasA(),
                        sin.getTiraLeite(),
                        sin.getResidenciaAtual()
                    });
                });
            } else {
                sd.pesquisar_cpf(cpf).forEach((sin) -> {
                    ID = sin.getId_sindi();
                    dtma.addRow(new Object[]{
                        sin.getId_sindi(),
                        sin.getNome(),
                        sin.getDataNasci(),
                        sin.getCelular(),
                        sin.getNascionalidade(),
                        sin.getEstadoCivil(),
                        sin.getCpf(),
                        sin.getRg(),
                        sin.getDataExpedicao(),
                        sin.getTituloEleito(),
                        sin.getZona(),
                        sin.getSecao(),
                        sin.getReservista(),
                        sin.getCategoria(),
                        sin.getPai(),
                        sin.getMae(),
                        sin.getNomeFazenda(),
                        sin.getLogradouro(),
                        sin.getMuniciSede(),
                        sin.getCodINCRA(),
                        sin.getNIRF(),
                        sin.getAreaPropri(),
                        sin.getTempoCompra(),
                        sin.getOutrasA(),
                        sin.getTiraLeite(),
                        sin.getResidenciaAtual()
                    });
                });
            }
        } else if (!"       ".equals(rg)) {
            a = 1;
            sd.pesquisar_rg(rg).forEach((sin) -> {
                ID = sin.getId_sindi();
                dtma.addRow(new Object[]{
                    sin.getId_sindi(),
                    sin.getNome(),
                    sin.getDataNasci(),
                    sin.getCelular(),
                    sin.getNascionalidade(),
                    sin.getEstadoCivil(),
                    sin.getCpf(),
                    sin.getRg(),
                    sin.getDataExpedicao(),
                    sin.getTituloEleito(),
                    sin.getZona(),
                    sin.getSecao(),
                    sin.getReservista(),
                    sin.getCategoria(),
                    sin.getPai(),
                    sin.getMae(),
                    sin.getNomeFazenda(),
                    sin.getLogradouro(),
                    sin.getMuniciSede(),
                    sin.getCodINCRA(),
                    sin.getNIRF(),
                    sin.getAreaPropri(),
                    sin.getTempoCompra(),
                    sin.getOutrasA(),
                    sin.getTiraLeite(),
                    sin.getResidenciaAtual()
                });
            });
        } else if (a == 0) {
            listar_Tabela();
        }
        return ID;
    }

    public Dados_Pessoais PREENCHER_OBJETO() {
        se.setId_sindi(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
        id = se.getId_sindi();
        se.setNome(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString());
        se.setDataNasci(Util.STRING_DATE(TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString()));
        se.setCelular(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString());
        se.setNascionalidade(TABELA.getValueAt(TABELA.getSelectedRow(), 4).toString());
        se.setEstadoCivil(TABELA.getValueAt(TABELA.getSelectedRow(), 5).toString());
        se.setCpf(TABELA.getValueAt(TABELA.getSelectedRow(), 6).toString());
        se.setRg(TABELA.getValueAt(TABELA.getSelectedRow(), 7).toString());
        se.setDataExpedicao(Util.STRING_DATE(TABELA.getValueAt(TABELA.getSelectedRow(), 8).toString()));
        se.setTituloEleito(TABELA.getValueAt(TABELA.getSelectedRow(), 9).toString());
        String zo = (TABELA.getValueAt(TABELA.getSelectedRow(), 10).toString());
        if ("   ".equals(zo)) {
            se.setZona(0);
        } else {
            se.setZona(Integer.parseInt(zo));
        }

        String sec = (TABELA.getValueAt(TABELA.getSelectedRow(), 11).toString());
        if ("    ".equals(sec)) {
            se.setSecao(0);
        } else {
            se.setSecao(Integer.parseInt(sec));
        }
        se.setReservista(TABELA.getValueAt(TABELA.getSelectedRow(), 12).toString());
        se.setCategoria(TABELA.getValueAt(TABELA.getSelectedRow(), 13).toString());
        se.setPai(TABELA.getValueAt(TABELA.getSelectedRow(), 14).toString());
        se.setMae(TABELA.getValueAt(TABELA.getSelectedRow(), 15).toString());
        se.setNomeFazenda(TABELA.getValueAt(TABELA.getSelectedRow(), 16).toString());
        se.setLogradouro(TABELA.getValueAt(TABELA.getSelectedRow(), 17).toString());
        se.setMuniciSede(TABELA.getValueAt(TABELA.getSelectedRow(), 18).toString());
        se.setCodINCRA(TABELA.getValueAt(TABELA.getSelectedRow(), 19).toString());
        se.setNIRF(TABELA.getValueAt(TABELA.getSelectedRow(), 20).toString());
        se.setAreaPropri(TABELA.getValueAt(TABELA.getSelectedRow(), 21).toString());
        se.setTempoCompra(TABELA.getValueAt(TABELA.getSelectedRow(), 22).toString());
        se.setOutrasA(TABELA.getValueAt(TABELA.getSelectedRow(), 23).toString());
        se.setTiraLeite(TABELA.getValueAt(TABELA.getSelectedRow(), 24).toString());
        se.setResidenciaAtual(TABELA.getValueAt(TABELA.getSelectedRow(), 25).toString());

        return se;
    }

    public void limparCampus() {
        NOME.setText("");
        RG.setText("");
        CPF.setText("");

    }

    public void Relatorio(int ID) {
        try {
            HashMap filtro = new HashMap();
            filtro.put("id", ID); // o "id" é o id que criei como parametro la no select do Ireport
            JasperPrint print = JasperFillManager.fillReport("C:\\Users\\helde\\relatorios\\Associado.jasper", filtro, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório");
            System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTAO_PESQUISAR_;
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JTextField NOME;
    private javax.swing.JFormattedTextField RG;
    private javax.swing.JTable TABELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
