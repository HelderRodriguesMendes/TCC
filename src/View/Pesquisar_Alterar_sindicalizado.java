/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Conversao;
import Controller.Login;
import Model.DAO.Sindicalizado_DAO;
import Model.Entidadades.Sindicalizado_Entidade;
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

    int cont = 0;
    int con = 0;

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

        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
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
        jPanel1 = new javax.swing.JPanel();
        TXT_NovaSenha = new javax.swing.JLabel();
        NOVA_SENHA = new javax.swing.JTextField();
        TXT_CONFIR_SENHA = new javax.swing.JLabel();
        CONFIR_SENHA = new javax.swing.JTextField();
        ALTERA_S = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
                "ID", "Nome", "Data de nascimento", "Telefone", "Nascionalidade", "Naturalidade", "Estado civil", "CPF", "RG", "Data de Expedição", "Titulo de Eleitor", "Zona", "Seção", "Reservistal", "Categoria", "Nome do pai", "Nome da mãe", "Nome da propriedade rural", "Logradouro", "Municipio cede", "Código no INCRA", "Número no NIRF", "Area da propriedade rural", "Tempo de compra da propriedade", "Outras atividades", "Login", "Comercialização de leite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TXT_NovaSenha.setText("Nova senha:");

        TXT_CONFIR_SENHA.setText("Confirma senha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXT_NovaSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NOVA_SENHA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXT_CONFIR_SENHA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CONFIR_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TXT_NovaSenha))
                    .addComponent(NOVA_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CONFIR_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_CONFIR_SENHA))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ALTERA_S.setText("Alterar senha");
        ALTERA_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALTERA_SActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(524, 524, 524)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ALTERA_S)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BOTAO_PESQUISAR_)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(ALTERA_S))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_PESQUISAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_PESQUISAR_ActionPerformed
        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
        if ("".equals(NOME.getText()) && "".equals(CPF.getText()) && "".equals(RG.getText())) {
            listar_Tabela();
        } else {
            pesquisar_Sind(NOME.getText(), CPF.getText(), RG.getText());
        }
    }//GEN-LAST:event_BOTAO_PESQUISAR_ActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        cont = 10;
        ALTERA_S.setVisible(true);
    }//GEN-LAST:event_TABELAMouseClicked

    private void ALTERA_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALTERA_SActionPerformed
        jPanel1.setVisible(true);
        con = 5;
    }//GEN-LAST:event_ALTERA_SActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cont == 10) {
            sd.alterar_sind(PREENCHER_OBJETO());
            listar_Tabela();
            limparCampus();
            jPanel1.setVisible(false);
            ALTERA_S.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um sindicalizado na tabela para a alteração de dados", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
    }//GEN-LAST:event_NOMEMouseClicked

    private void CPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPFMouseClicked
        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
    }//GEN-LAST:event_CPFMouseClicked

    private void RGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RGMouseClicked
        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
    }//GEN-LAST:event_RGMouseClicked

    public void listar_Tabela() {
        String leite;
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sd.listar_Tabela().forEach((sin) -> {
            String dn = Conversao.DATE_STRING(sin.getDataNasci());
            String de = Conversao.DATE_STRING(sin.getDataExpedicao());
            dtma.addRow(new Object[]{
                sin.getId(),
                sin.getNome(),
                dn,
                sin.getCelular(),
                sin.getNascionalidade(),
                sin.getNaturalidade(),
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
                sin.getTiraLeite()
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
                sin.getNaturalidade(),
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
                sin.getTiraLeite()
            });
        });

    }

    public Sindicalizado_Entidade PREENCHER_OBJETO() {
        se.setId(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
        se.setNome(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString());
        String da = TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString();
        String daVe = Conversao.verificar_Data(da);        
        se.setDataNasci(Conversao.STRING_DATE(daVe));        
        se.setCelular(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString());
        se.setNascionalidade(TABELA.getValueAt(TABELA.getSelectedRow(), 4).toString());
        se.setNaturalidade(TABELA.getValueAt(TABELA.getSelectedRow(), 5).toString());
        se.setEstadoCivil(TABELA.getValueAt(TABELA.getSelectedRow(), 6).toString());
        se.setCpf(TABELA.getValueAt(TABELA.getSelectedRow(), 7).toString());
        se.setRg(TABELA.getValueAt(TABELA.getSelectedRow(), 8).toString());
        String dat = TABELA.getValueAt(TABELA.getSelectedRow(), 9).toString();
        String datVe = Conversao.verificar_Data(dat);
        se.setDataExpedicao(Conversao.STRING_DATE(datVe));
        se.setTituloEleito(TABELA.getValueAt(TABELA.getSelectedRow(), 10).toString());
        se.setZona(Integer.parseInt((TABELA.getValueAt(TABELA.getSelectedRow(), 11).toString())));
        se.setSecao(Integer.parseInt((TABELA.getValueAt(TABELA.getSelectedRow(), 12).toString())));
        se.setReservista(TABELA.getValueAt(TABELA.getSelectedRow(), 13).toString());
        se.setCategoria(TABELA.getValueAt(TABELA.getSelectedRow(), 14).toString());
        se.setPai(TABELA.getValueAt(TABELA.getSelectedRow(), 15).toString());
        se.setMae(TABELA.getValueAt(TABELA.getSelectedRow(), 16).toString());
        se.setNomeFazenda(TABELA.getValueAt(TABELA.getSelectedRow(), 17).toString());
        se.setLogradouro(TABELA.getValueAt(TABELA.getSelectedRow(), 18).toString());
        se.setMuniciSede(TABELA.getValueAt(TABELA.getSelectedRow(), 19).toString());
        se.setCodINCRA(TABELA.getValueAt(TABELA.getSelectedRow(), 20).toString());
        se.setNIRF(TABELA.getValueAt(TABELA.getSelectedRow(), 21).toString());
        se.setAreaPropri(TABELA.getValueAt(TABELA.getSelectedRow(), 22).toString());
        se.setTempoCompra(TABELA.getValueAt(TABELA.getSelectedRow(), 23).toString());
        se.setOutrasA(TABELA.getValueAt(TABELA.getSelectedRow(), 24).toString());
        se.setLogin(TABELA.getValueAt(TABELA.getSelectedRow(), 25).toString());
        se.setTiraLeite(TABELA.getValueAt(TABELA.getSelectedRow(), 26).toString());
        if (con == 5) {
            se.setSenha(lo.validar_nova_senha(NOVA_SENHA.getText(), CONFIR_SENHA.getText()));
        } else {
            se.setSenha("");
        }
        return se;
    }

    public void limparCampus() {
        NOME.setText("");
        RG.setText("");
        CPF.setText("");
        NOVA_SENHA.setText("");
        CONFIR_SENHA.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALTERA_S;
    private javax.swing.JButton BOTAO_PESQUISAR_;
    private javax.swing.JTextField CONFIR_SENHA;
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField NOME;
    private javax.swing.JTextField NOVA_SENHA;
    private javax.swing.JTextField RG;
    private javax.swing.JTable TABELA;
    private javax.swing.JLabel TXT_CONFIR_SENHA;
    private javax.swing.JLabel TXT_NovaSenha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}