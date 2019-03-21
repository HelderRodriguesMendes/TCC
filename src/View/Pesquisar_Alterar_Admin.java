/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Login;
import Model.DAO.AdministradorDAO;
import Model.Entidadades.Administrador_Entidade;
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
public class Pesquisar_Alterar_Admin extends javax.swing.JInternalFrame {

    int cont = 0, con = 0;
    Administrador_Entidade adm = new Administrador_Entidade();
    AdministradorDAO ad = new AdministradorDAO();
    Login lo = new Login();
    
    public Pesquisar_Alterar_Admin() {
        initComponents();
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Pesquisar_Alterar_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        jPanel1.setVisible(false);
        ALTERA_S.setVisible(false);
        LISTAR_TABELA();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ALTERA_S = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TXT_NovaSenha = new javax.swing.JLabel();
        NOVA_SENHA = new javax.swing.JTextField();
        TXT_CONFIR_SENHA = new javax.swing.JLabel();
        CONFIR_SENHA = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("Pesquisar - Alterar Administrador");

        jLabel1.setText("Nome:");

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
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
        if (TABELA.getColumnModel().getColumnCount() > 0) {
            TABELA.getColumnModel().getColumn(0).setResizable(false);
        }

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        ALTERA_S.setText("Alterar senha");
        ALTERA_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALTERA_SActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addGap(21, 66, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ALTERA_S)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(ALTERA_S))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void ALTERA_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALTERA_SActionPerformed
        jPanel1.setVisible(true);
        con = 5;
    }//GEN-LAST:event_ALTERA_SActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        cont  = 10;
        ALTERA_S.setVisible(true);
    }//GEN-LAST:event_TABELAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!"".equals(NOME.getText())){
            Pesquisar_Nome(NOME.getText());
        }else{
            LISTAR_TABELA();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cont == 10){
            ad.alterar_ADMIN(preencher_Objeto());
            LISTAR_TABELA();
            Limpar_campus();
            jPanel1.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    public void LISTAR_TABELA(){
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);
        
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        ad.Listar_Tabela().forEach((admin)->{
            dtma.addRow(new Object[]{
                admin.getId(),
                admin.getNome(),
                admin.getTelefone(),
                admin.getLogin()
            });
        });
    }
    
    public void Pesquisar_Nome(String nome){
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        
        TABELA.getColumnModel().getColumn(2).setPreferredWidth(110);
        
        
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        ad.Pesquisar_Nome(nome).forEach((adm)->{
            dtma.addRow(new Object[]{
                adm.getId(),
                adm.getNome(),
                adm.getTelefone(),
                adm.getLogin()
            });
        });
    }
    public Administrador_Entidade preencher_Objeto(){
        adm.setId(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
        adm.setNome(TABELA.getValueAt(TABELA.getSelectedRow(), 1).toString());        
        if(TABELA.getValueAt(TABELA.getSelectedRow(), 2) != null){
            adm.setTelefone(TABELA.getValueAt(TABELA.getSelectedRow(), 2).toString());
        }else{
            adm.setTelefone("");
        }
        adm.setLogin(TABELA.getValueAt(TABELA.getSelectedRow(), 3).toString());
        if(con == 5){
            adm.setSenha(lo.validar_nova_senha(NOVA_SENHA.getText(), CONFIR_SENHA.getText()));
        }else{
            adm.setSenha("");
        }
        return adm;
    }
     public void Limpar_campus(){
         NOVA_SENHA.setText("");
         CONFIR_SENHA.setText("");
         NOME.setText("");
     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALTERA_S;
    private javax.swing.JTextField CONFIR_SENHA;
    private javax.swing.JTextField NOME;
    private javax.swing.JTextField NOVA_SENHA;
    private javax.swing.JTable TABELA;
    private javax.swing.JLabel TXT_CONFIR_SENHA;
    private javax.swing.JLabel TXT_NovaSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
