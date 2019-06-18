/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util;
import Controller.Login;
import Controller.Sindicalizado;
import DAO.Sindicalizado_DAO;
import Model.Sindicalizado_Entidade;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helde
 */
public class Pesquisar_Alterar_sindicalizado extends javax.swing.JInternalFrame {

    Sindicalizado_DAO sd = new Sindicalizado_DAO();
    Sindicalizado_Entidade se = new Sindicalizado_Entidade();
    Login lo = new Login();
    Sindicalizado si = new Sindicalizado();

    int cont = 0, con = 0, id = 0, idade;
    boolean niver, ok;

    public Pesquisar_Alterar_sindicalizado() {
        initComponents();

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
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CPF = new javax.swing.JTextField();
        RG = new javax.swing.JTextField();

        setIconifiable(true);

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
                "ID", "Nome", "Data de nascimento", "Telefone", "Nascionalidade", "Estado civil", "CPF", "RG", "Data de Expedição", "Titulo de Eleitor", "Zona", "Seção", "Reservistal", "Categoria", "Nome do pai", "Nome da mãe", "Nome da propriedade rural", "Logradouro", "Municipio cede", "Código no INCRA", "Número no NIRF", "Area da propriedade rural", "Tempo de compra da propriedade", "Outras atividades", "Login", "Comercialização de leite", "Residência atual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home (1).png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel3.setText("CPF:");

        jLabel4.setText("RG:");

        CPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CPFMouseClicked(evt);
            }
        });
        CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFActionPerformed(evt);
            }
        });

        RG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RGMouseClicked(evt);
            }
        });
        RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(BOTAO_PESQUISAR_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOTAO_PESQUISAR_))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_PESQUISAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_PESQUISAR_ActionPerformed

        if ("".equals(NOME.getText()) && "".equals(CPF.getText()) && "".equals(RG.getText())) {
            listar_Tabela();
        } else {
            pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
        }
    }//GEN-LAST:event_BOTAO_PESQUISAR_ActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        cont = 10;

        id = Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString());

        Cadastrar_Sindi cs = new Cadastrar_Sindi() {
        };
        cs.preencher_campus_alteracao(PREENCHER_OBJETO());
        cs.setVisible(true);
        Interface.DESKTOP.add(cs);
        cs.setPosicao();
        cs.id = this.id;
        this.dispose();
    }//GEN-LAST:event_TABELAMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMEActionPerformed

    }//GEN-LAST:event_NOMEActionPerformed

    private void CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFActionPerformed

    }//GEN-LAST:event_CPFActionPerformed

    private void RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGActionPerformed

    }//GEN-LAST:event_RGActionPerformed

    private void NOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOMEMouseClicked

    }//GEN-LAST:event_NOMEMouseClicked

    private void CPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPFMouseClicked

    }//GEN-LAST:event_CPFMouseClicked

    private void RGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RGMouseClicked

    }//GEN-LAST:event_RGMouseClicked

    public void listar_Tabela() {
        String leite;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sd.listar_Tabela().forEach((sin) -> {
            String dn = Util.DATE_STRING(sin.getDataNasci());
            String de = Util.DATE_STRING(sin.getDataExpedicao());
            dtma.addRow(new Object[]{
                sin.getId(),
                sin.getNome(),
                dn,
                sin.getCelular(),
                sin.getNascionalidade(),
                sin.getEstadoCivil(),
                sin.getCpf(),
                sin.getRg(),
                de,
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
                sin.getLogin(),
                sin.getTiraLeite(),
                sin.getResidenciaAtual()
            });
        });

    }

    public void pesquisar_Sind(String nome, String cpf, String rg) {
        String leite;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sd.pesquisar_Sind(nome, cpf, rg).forEach((sin) -> {
            dtma.addRow(new Object[]{
                sin.getId(),
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
                sin.getLogin(),
                sin.getTiraLeite(),
                sin.getResidenciaAtual()
            });
        });

    }

    public Sindicalizado_Entidade PREENCHER_OBJETO() {
        se.setId(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
        id = se.getId();
        se.setNome(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString());
        se.setDataNasci(Util.STRING_DATE(TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString()));
        se.setCelular(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString());
        se.setNascionalidade(TABELA.getValueAt(TABELA.getSelectedRow(), 4).toString());
        se.setEstadoCivil(TABELA.getValueAt(TABELA.getSelectedRow(), 5).toString());
        se.setCpf(TABELA.getValueAt(TABELA.getSelectedRow(), 6).toString());
        se.setRg(TABELA.getValueAt(TABELA.getSelectedRow(), 7).toString());
        se.setDataExpedicao(Util.STRING_DATE(TABELA.getValueAt(TABELA.getSelectedRow(), 8).toString()));
        se.setTituloEleito(TABELA.getValueAt(TABELA.getSelectedRow(), 9).toString());
        se.setZona(Integer.parseInt((TABELA.getValueAt(TABELA.getSelectedRow(), 10).toString())));
        se.setSecao(Integer.parseInt((TABELA.getValueAt(TABELA.getSelectedRow(), 11).toString())));
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
        se.setLogin(TABELA.getValueAt(TABELA.getSelectedRow(), 24).toString());
        se.setTiraLeite(TABELA.getValueAt(TABELA.getSelectedRow(), 25).toString());

        return se;
    }

    public void limparCampus() {
        NOME.setText("");
        RG.setText("");
        CPF.setText("");

    }

    public boolean validar_Campus() {
        boolean va = false;

        String dataNas, dataExp;
        int invalido = 0;

        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o nome do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento do sindicalizado " + id);
        } else {
            String dat = TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString();
            niver = true;
            dataNas = Util.verificar_Data(dat, niver);
            idade = Util.idade;
            ok = Util.ok;
            if ("//".equals(dataNas)) {
                invalido = 2;
                if (idade < 18 && idade > 0 && !ok) {
                    JOptionPane.showMessageDialog(null, "Com base a data de nascimento informada, o sindicalizado " + id + "\n" + " se torna menor de idade", "Atenção", JOptionPane.ERROR_MESSAGE);
                    Util.idade = 0;
                    TABELA.setValueAt("", TABELA.getSelectedRow(), 2);
                } else if (!ok && idade == 0) {
                    invalido = 2;
                    JOptionPane.showMessageDialog(null, "A data de nascimento do sindicalizado " + id + "\n" + "é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                    Util.idade = 0;
                    TABELA.setValueAt("", TABELA.getSelectedRow(), 2);
                }
            } else {
                TABELA.setValueAt(dataNas, TABELA.getSelectedRow(), 2);
            }
        }

        if (!"".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString()) && invalido == 0) {
            String tel = TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString();
            String TEL = si.validadar_Telefone(tel);
            if ("".equals(TEL)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O telefone do sindicalizado " + id + "\n" + "é invalido", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 3);
            } else if ("falto DD".equals(TEL)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "Informe o DDD do telefone do sindicalizado " + id);
            } else {
                TABELA.setValueAt(TEL, TABELA.getSelectedRow(), 3);
            }
        }

        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 8).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o RG do sindicalizado " + id);
        } else {
            String rg = TABELA.getValueAt(TABELA.getSelectedRow(), 8).toString();
            String R_G = si.validadar_RG(rg);
            if ("".equals(R_G)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado " + id + "\n" + "é invalido", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 8);
            } else if ("-7".equals(R_G)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado " + id + "\n" + "deve conter 7 números", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
            } else if ("+7".equals(R_G)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O RG do sindicalizado " + id + "\n" + "deve conter apenas 7 números", "Atenção RG invalido", JOptionPane.ERROR_MESSAGE);
            } else {
                TABELA.setValueAt(R_G, TABELA.getSelectedRow(), 8);
            }
        }
        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 9).toString()) && invalido == 0) {
            JOptionPane.showMessageDialog(null, "Informe a data de expedição do RG do sindicalizado " + id);
            invalido = 2;
        } else {
            String dat = TABELA.getValueAt(TABELA.getSelectedRow(), 9).toString();
            niver = false;
            dataExp = Util.verificar_Data(dat, niver);
            if ("//".equals(dataExp)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "A data de expedição do RG do sindicalizado " + id + "\n" + "é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 9);
            } else {
                TABELA.setValueAt(dataExp, TABELA.getSelectedRow(), 9);
            }
        }
        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 10).toString()) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o titulo de eleitor do sindicalizado " + id);
        } else {
            String tito = TABELA.getValueAt(TABELA.getSelectedRow(), 10).toString();
            String TITO = si.validar_Titulo_Eleitor(tito);
            if ("".equals(TITO)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "Titulo de eleitor do sindicalizado " + id + " é invalido" + "\n" + "O titulo deve conter 12 números", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 10);
            } else {
                TABELA.setValueAt(TITO, TABELA.getSelectedRow(), 10);
            }
        }
        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 11).toString()) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a zona do titulo de eleitor do sindicalizado " + id);
        } else {
            String zona = TABELA.getValueAt(TABELA.getSelectedRow(), 11).toString();
            String ZONA = si.validar_zona(zona);
            if ("".equals(ZONA)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "A zona do titulo de eleitor do sindicalizado " + id + " é invalida." + "\n" + " Deve conter 3 números", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else if ("invalida".equals(ZONA)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "A zona do titulo de eleitor do sindicalizado " + id + " é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 11);
            } else {
                TABELA.setValueAt(ZONA, TABELA.getSelectedRow(), 11);
            }
        }

        if ("".equals((TABELA.getValueAt(TABELA.getSelectedRow(), 12).toString())) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a seção do titulo de eleitor do sindicalizado " + id);
        } else {
            String secao = TABELA.getValueAt(TABELA.getSelectedRow(), 12).toString();
            String SECAO = si.validar_secao(secao);
            if ("".equals(SECAO)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "A seção do titulo de eleitor do sindicalizado " + id + " é invalida." + "\n" + " Deve conter 4 números", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else if ("invalida".equals(SECAO)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "A seção do titulo de eleitor do sindicalizado " + id + " é invalida", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 12);
            } else {
                TABELA.setValueAt(SECAO, TABELA.getSelectedRow(), 12);
            }
        }

        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 13).toString()) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a reservista do sindicalizado " + id);
        } else {
            String reser = TABELA.getValueAt(TABELA.getSelectedRow(), 13).toString();
            String RESER = si.validarReservista(reser);
            if ("".equals(RESER)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O número da reservista do sindicalizado " + id + " é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 13);
            } else if ("6n".equals(RESER)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O número da reservista do sindicalizado " + id + " é invalido." + "\n" + "Deve conter 6 números", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                TABELA.setValueAt(RESER, TABELA.getSelectedRow(), 13);
            }
        }
        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 14).toString()) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a categoria da reservista do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 17).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o nome da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 18).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o logradouro da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 19).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o municipio cede da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 20).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o código no INCRA da propriedade rural do sindicalizado " + id);
        } else {
            String codincra = TABELA.getValueAt(TABELA.getSelectedRow(), 20).toString();
            String CODINCRA = si.validaCodIncra(codincra);
            if ("".equals(CODINCRA)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O código do INCRA do sindicalizado " + id + " é invalido.", "Atenção", JOptionPane.ERROR_MESSAGE);
                TABELA.setValueAt("", TABELA.getSelectedRow(), 20);
            } else if ("invalido".equals(CODINCRA)) {
                invalido = 2;
                JOptionPane.showMessageDialog(null, "O código do INCRA do sindicalizado " + id + " deve conter 13 números.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                TABELA.setValueAt(CODINCRA, TABELA.getSelectedRow(), 20);
            }
        }

        if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 26).toString()) && invalido == 0) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe se a comercialização de leite na propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 21).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o numero no NIRF da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 22).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe a area da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 23).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o tempo de compra da propriedade rural do sindicalizado " + id);
        } else if ("".equals(TABELA.getValueAt(TABELA.getSelectedRow(), 25).toString())) {
            invalido = 2;
            JOptionPane.showMessageDialog(null, "Informe o login de acesso ao sistema do sindicalizado " + id);
        } else if (invalido == 0) {
            va = true;
        }
        return va;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTAO_PESQUISAR_;
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField NOME;
    private javax.swing.JTextField RG;
    private javax.swing.JTable TABELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
