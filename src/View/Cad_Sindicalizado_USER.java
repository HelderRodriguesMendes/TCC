/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.UsuarioDAO;
import Model.Entidadades.Sindicalizado_Entidade;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helde
 */
public class Cad_Sindicalizado_USER extends javax.swing.JInternalFrame {

    Sindicalizado_Entidade se = new Sindicalizado_Entidade();
    String escolha = "";

    public Cad_Sindicalizado_USER() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cad_Sindicalizado_USER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cad_Sindicalizado_USER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cad_Sindicalizado_USER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cad_Sindicalizado_USER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void Listar_Tabela_Pesquisa(Sindicalizado_Entidade se, String ESC) {
        DefaultTableModel dtmMA = (DefaultTableModel) TABELA.getModel();
        dtmMA.setNumRows(0);
        UsuarioDAO ud = new UsuarioDAO();
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if ("NCR".equals(ESC)) {
            ud.PesquisarNCR(se).forEach((s) -> {
                dtmMA.addRow(new Object[]{
                    s.getId(),
                    s.getNome(),
                    s.getCpf(),
                    s.getRg()
                });
            });
//        }else if("CR".equals(ESC)){
//            ud.PesquisarCR(se).forEach((s) -> {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            });
//        }else if("NC".equals(ESC)){
//            ud.PesquisarNC(se).forEach((s) -> {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            });
//        }else if("NR".equals(ESC)){
//            for (Sindicalizado_Entidade s : ud.PesquisarNR(se)) {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            }
//        }else if("N".equals(ESC)){
//            for (Sindicalizado_Entidade s : ud.PesquisarN(se)) {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            }
//        }else if("C".equals(ESC)){
//            for (Sindicalizado_Entidade s : ud.PesquisarC(se)) {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            }
//        }else if("R".equals(ESC)){
//            for (Sindicalizado_Entidade s : ud.PesquisarR(se)) {
//                dtmMA.addRow(new Object[]{
//                    s.getId(),
//                    s.getNome(),
//                    s.getCpf(),
//                    s.getRg()
//                });
//            }
        }
    }

    public Sindicalizado_Entidade preencherObjeto() {
        se.setNome(TXT_NOME.getText());
        se.setCpf(TXT_CPF.getText());
        se.setRg(TXT_RG.getText());
        return se;
    }

    public void limparCampus() {
        TXT_NOME.setText("");
        TXT_CPF.setText("");
        TXT_RG.setText("");
        TXT_LOGIN.setText("");
        TXT_SENHA.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_NOME = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXT_CPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        TXT_RG = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXT_LOGIN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TXT_SENHA = new javax.swing.JTextField();
        BOTAO_SALVAR_ = new javax.swing.JLabel();
        BT_ATU = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("Cadastrar Usuário");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CPF", "RG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TABELA);

        jLabel1.setText("Pesquise e selecione o sindicalizado abaixo:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        try {
            TXT_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ### - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("RG:");

        try {
            TXT_RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Login:");

        jLabel8.setText("Senha:");

        BOTAO_SALVAR_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        BOTAO_SALVAR_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_SALVAR_MouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_SENHA))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(BOTAO_SALVAR_)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(TXT_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(TXT_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TXT_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TXT_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BT_ATU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BOTAO_SALVAR_))
                        .addGap(19, 19, 19)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void BOTAO_SALVAR_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVAR_MouseClicked

    }//GEN-LAST:event_BOTAO_SALVAR_MouseClicked

    private void BT_ATUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseClicked
        limparCampus();
    }//GEN-LAST:event_BT_ATUMouseClicked

    private void BT_ATUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ATUMouseEntered
        BT_ATU.setToolTipText("Limpar campus");
    }//GEN-LAST:event_BT_ATUMouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
//        if (!"".equals(TXT_NOME.getText())) {
//            if (!"            -   ".equals(TXT_CPF.getText())) {
//                if (!"       ".equals(TXT_RG.getText())) {
//                    escolha = "NCR";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha); // TEM AS 3 ESCOLHAS
//                } else {
//                    escolha = "NC";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//                }
//            } else {
//                if (!"       ".equals(TXT_RG.getText())) {
//                    escolha = "NR";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//                } else {
//                    escolha = "N";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//                }
//            }
//        } else {
//            if (!"            -   ".equals(TXT_CPF.getText())) {
//                if (!"       ".equals(TXT_RG.getText())) {
//                    escolha = "CR";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//                } else {
//                    escolha = "C";
//                    Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//                }
//            } else {
//                escolha = "R";
//                Listar_Tabela_Pesquisa(preencherObjeto(), escolha);
//            }
//        }


    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BOTAO_SALVAR_;
    private javax.swing.JLabel BT_ATU;
    private javax.swing.JTable TABELA;
    private javax.swing.JFormattedTextField TXT_CPF;
    private javax.swing.JTextField TXT_LOGIN;
    private javax.swing.JTextField TXT_NOME;
    private javax.swing.JFormattedTextField TXT_RG;
    private javax.swing.JTextField TXT_SENHA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
