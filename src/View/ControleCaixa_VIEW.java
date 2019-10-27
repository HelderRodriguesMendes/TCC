/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Util_Controller;
import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;
import java.text.DateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class ControleCaixa_VIEW extends javax.swing.JInternalFrame {
        
    public ControleCaixa_VIEW() {
        initComponents();
    }

    Controle_Caixa c;
    DateFormat df = DateFormat.getDateInstance();
    Controle_Caixa_DAO CD = new Controle_Caixa_DAO();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BANCO = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DATA = new com.toedter.calendar.JDateChooser();
        ANUIDADE = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        DOCUMENTO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TRANSACAO = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VALORF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HISTORICO = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setTitle("Controle de Caixa");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Baonco:");

        BANCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil", "Caixa Interno", "Sicredi" }));

        jLabel2.setText("Data:");

        ANUIDADE.setText("Anuidade");

        jLabel3.setText("Documento:");

        jLabel4.setBackground(new java.awt.Color(204, 0, 102));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("*");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setAlignmentY(0.0F);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.setIconTextGap(1);
        jLabel4.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel4.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel6.setBackground(new java.awt.Color(204, 0, 102));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("*");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel6.setIconTextGap(1);
        jLabel6.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel6.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel6.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Transação financeira:");

        TRANSACAO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Crédito", "Débito" }));

        jLabel7.setBackground(new java.awt.Color(204, 0, 102));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("*");
        jLabel7.setToolTipText("");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel7.setIconTextGap(1);
        jLabel7.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel7.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel7.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel8.setText("Valor Financeiro:");

        jLabel10.setBackground(new java.awt.Color(204, 0, 102));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("*");
        jLabel10.setToolTipText("");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel10.setIconTextGap(1);
        jLabel10.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel10.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel10.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel11.setText("Histórico:");

        HISTORICO.setColumns(20);
        HISTORICO.setRows(5);
        jScrollPane1.setViewportView(HISTORICO);

        jLabel9.setBackground(new java.awt.Color(204, 0, 102));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("*");
        jLabel9.setToolTipText("");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel9.setIconTextGap(1);
        jLabel9.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel9.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel9.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refazer.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(DOCUMENTO, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(BANCO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ANUIDADE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel13))))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BANCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TRANSACAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ANUIDADE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VALORF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        limparCamous();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if(validarObrigatorios()){
            CD.salvar(preenche_Objeto());
            limparCamous();
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    public boolean validarObrigatorios() {
        boolean ok = false;
        int cont = 0;

        if (BANCO.getSelectedIndex() == 0 && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o banco desejado para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            BANCO.requestFocus();
            cont++;
        } else if (DATA.getDate() == null && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe a data desejada para a transação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            DATA.requestFocus();
            cont++;
        } else if (TRANSACAO.getSelectedIndex() == 0 && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o tipode transação financeira", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            TRANSACAO.requestFocus();
            cont++;
        } else if ("".equals(VALORF.getText()) && cont == 0) {
            JOptionPane.showMessageDialog(null, "Informe o valor financeiro da transação");
            VALORF.requestFocus();
            cont++;
        }else if("".equals(HISTORICO.getText()) && cont == 0){
            JOptionPane.showMessageDialog(null, "Informe o hitérico da transação");
            HISTORICO.requestFocus();
            cont++;
        }

        if (cont == 0) {
            ok = true;
        }
        return ok;
    }
    
    public Controle_Caixa preenche_Objeto(){
        c = new Controle_Caixa();
        
        c.setBanco(String.valueOf(BANCO.getSelectedItem()));
        String dt = df.format(DATA.getDate());
        c.setData(Util_Controller.STRING_DATE(dt));
        c.setDocumento(DOCUMENTO.getText());
        
        if(TRANSACAO.getSelectedIndex() == 1){
            c.setCredito(Double.parseDouble(VALORF.getText()));
            c.setDebito(0.0);
        }else if(TRANSACAO.getSelectedIndex() == 2){
            c.setDebito(Double.parseDouble(VALORF.getText()));
            c.setCredito(0.0);
        }
        
        c.setHistorico(HISTORICO.getText());
        
        return c;
    }
    
    public void limparCamous(){
        BANCO.setSelectedIndex(0);
        DATA.setDate(null);
        DOCUMENTO.setText("");
        TRANSACAO.setSelectedIndex(0);
        VALORF.setText("");
        HISTORICO.setText("");
        ANUIDADE.setSelected(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ANUIDADE;
    private javax.swing.JComboBox<String> BANCO;
    private com.toedter.calendar.JDateChooser DATA;
    private javax.swing.JTextField DOCUMENTO;
    private javax.swing.JTextArea HISTORICO;
    private javax.swing.JComboBox<String> TRANSACAO;
    private javax.swing.JTextField VALORF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
