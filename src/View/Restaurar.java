/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util;
import DAO.AdministradorDAO;
import DAO.Sindicalizado_DAO;
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
public class Restaurar extends javax.swing.JInternalFrame {

    int cont = 0;

    public Restaurar() {
        initComponents();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Restaurar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Restaurar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Restaurar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Restaurar.class.getName()).log(Level.SEVERE, null, ex);
        }

        Util.soLetras(TXT_NOME);
    }

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void pesquisar_nome_SIND(String nome) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Sindicalizado_DAO sd = new Sindicalizado_DAO();

        sd.pesquisar_restaurar(nome).forEach((sind) -> {
            dtma.addRow(new Object[]{
                sind.getId(),
                sind.getNome(),
                sind.getCelular(),
                sind.getRg(),
                sind.getCpf()
            });
        });
    }

    public void pesquisar_nome_ADM(String nome) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        String rg = "";
        String cpf = "";

        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        AdministradorDAO ad = new AdministradorDAO();

        ad.pesquisar_restaurar(nome).forEach((adm) -> {
            dtma.addRow(new Object[]{
                adm.getId(),
                adm.getNome(),
                adm.getCelular(),
                rg,
                cpf
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TXT_NOME = new javax.swing.JTextField();
        JB_SIND = new javax.swing.JButton();
        JB_ADM = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Restaurar");

        jLabel1.setText("Nome:");

        JB_SIND.setText("Sindicalizado");
        JB_SIND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SINDActionPerformed(evt);
            }
        });

        JB_ADM.setText("Administrador");
        JB_ADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ADMActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_SIND)
                        .addGap(42, 42, 42)
                        .addComponent(JB_ADM))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_SIND)
                    .addComponent(JB_ADM))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_SINDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SINDActionPerformed
        pesquisar_nome_SIND(TXT_NOME.getText());
        cont = 1;
    }//GEN-LAST:event_JB_SINDActionPerformed

    private void JB_ADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ADMActionPerformed
        pesquisar_nome_ADM(TXT_NOME.getText());
        cont = 2;
    }//GEN-LAST:event_JB_ADMActionPerformed

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        String ObjButtons[] = {"Sim", "Não"};
        int PromptResult = JOptionPane.showOptionDialog(null,
                "Realmente deseja realizar a restauração?", "ATENÇÃO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            if (cont == 1) {
                Sindicalizado_DAO sd = new Sindicalizado_DAO();
                sd.restaurar(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
                TXT_NOME.setText("");
            }else if(cont == 2){
                AdministradorDAO ad = new AdministradorDAO();
                ad.restaurar(Integer.parseInt(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString()));
                TXT_NOME.setText("");
            }
        }
    }//GEN-LAST:event_TABELAMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_ADM;
    private javax.swing.JButton JB_SIND;
    private javax.swing.JTable TABELA;
    private javax.swing.JTextField TXT_NOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
