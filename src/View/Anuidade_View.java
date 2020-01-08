/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Anuidade_Controller;
import Controller.Formatar_JTextField;
import Controller.Util_Controller;
import DAO.Anuidade_DAO;
import Model.DadosAnuidade;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author helde
 */
public class Anuidade_View extends javax.swing.JInternalFrame {

    DadosAnuidade D_A;
    Anuidade_DAO AD = new Anuidade_DAO();
    Anuidade_Controller ac = new Anuidade_Controller();
    int id = 0, ano = 0;
    public String status = "";

    public Anuidade_View() {
        initComponents();
        validaNumerosLetras();
        SALARIO.setDocument(new Formatar_JTextField());
        SALARIO.setHorizontalAlignment(JTextField.RIGHT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        FORM_GUIAS = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PEQUENO_P1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PEQUENO_P2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PORCEN_PEQUENO_P = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        MEDIO_P1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MEDIO_P2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PORCEN_MEDIO_P = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GRANDE_P = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        PORCEN_GRANDE_P = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        SALARIO = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        BOTAO_SALVAR = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        BOTAO_EDITAR_DADOS = new javax.swing.JButton();
        PAINEL_GERAR_ANUI_A1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        BOTAO_GERAR_DEBITOS_ANUAIS_1 = new javax.swing.JButton();
        ANO1 = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setIconifiable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Pequeno produtor");

        jLabel3.setText("Até:");

        jLabel4.setText("Alqueires");

        jLabel11.setText("Porcentagem (%)");

        jLabel21.setBackground(new java.awt.Color(204, 0, 102));
        jLabel21.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("*");
        jLabel21.setToolTipText("");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel21.setAlignmentY(0.0F);
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel21.setIconTextGap(1);
        jLabel21.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel21.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel21.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel22.setBackground(new java.awt.Color(204, 0, 102));
        jLabel22.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("*");
        jLabel22.setToolTipText("");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel22.setAlignmentY(0.0F);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel22.setIconTextGap(1);
        jLabel22.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel22.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel22.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PEQUENO_P1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(PEQUENO_P2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(PORCEN_PEQUENO_P, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PEQUENO_P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PEQUENO_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel4))
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(PORCEN_PEQUENO_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel11)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Médio produtor");

        jLabel5.setText("Até:");

        jLabel6.setText("Alqueires");

        jLabel12.setText("Porcentagem (%)");

        jLabel23.setBackground(new java.awt.Color(204, 0, 102));
        jLabel23.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("*");
        jLabel23.setToolTipText("");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel23.setAlignmentY(0.0F);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel23.setIconTextGap(1);
        jLabel23.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel23.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel23.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel24.setBackground(new java.awt.Color(204, 0, 102));
        jLabel24.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("*");
        jLabel24.setToolTipText("");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel24.setAlignmentY(0.0F);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel24.setIconTextGap(1);
        jLabel24.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel24.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel24.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(MEDIO_P1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(MEDIO_P2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(PORCEN_MEDIO_P, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MEDIO_P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(MEDIO_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(PORCEN_MEDIO_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Grande produtor");

        jLabel15.setText("Acima de");

        jLabel16.setText("Alqueires");

        jLabel17.setText("Porcentagem (%)");

        jLabel26.setBackground(new java.awt.Color(204, 0, 102));
        jLabel26.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("*");
        jLabel26.setToolTipText("");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel26.setAlignmentY(0.0F);
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel26.setIconTextGap(1);
        jLabel26.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel26.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel26.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel27.setBackground(new java.awt.Color(204, 0, 102));
        jLabel27.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("*");
        jLabel27.setToolTipText("");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel27.setAlignmentY(0.0F);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel27.setIconTextGap(1);
        jLabel27.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel27.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel27.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(5, 5, 5)
                        .addComponent(GRANDE_P, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(PORCEN_GRANDE_P, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(5, 5, 5)
                            .addComponent(PORCEN_GRANDE_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel14)
                            .addGap(5, 5, 5)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(GRANDE_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jLabel16))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setText("Salário:");

        SALARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SALARIOKeyReleased(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(204, 0, 102));
        jLabel25.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("*");
        jLabel25.setToolTipText("");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel25.setAlignmentY(0.0F);
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel25.setIconTextGap(1);
        jLabel25.setMaximumSize(new java.awt.Dimension(14, 40));
        jLabel25.setMinimumSize(new java.awt.Dimension(14, 40));
        jLabel25.setPreferredSize(new java.awt.Dimension(14, 10));
        jLabel25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        BOTAO_SALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_1.png"))); // NOI18N
        BOTAO_SALVAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_SALVARMouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizaz.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });

        BOTAO_EDITAR_DADOS.setText("Editar Dados");
        BOTAO_EDITAR_DADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_EDITAR_DADOSActionPerformed(evt);
            }
        });

        PAINEL_GERAR_ANUI_A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PAINEL_GERAR_ANUI_A1.setPreferredSize(new java.awt.Dimension(250, 49));

        jLabel29.setText("Ano a receber:");

        BOTAO_GERAR_DEBITOS_ANUAIS_1.setText("Gerar Débitos Anuais");
        BOTAO_GERAR_DEBITOS_ANUAIS_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTAO_GERAR_DEBITOS_ANUAIS_1MouseClicked(evt);
            }
        });
        BOTAO_GERAR_DEBITOS_ANUAIS_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_GERAR_DEBITOS_ANUAIS_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PAINEL_GERAR_ANUI_A1Layout = new javax.swing.GroupLayout(PAINEL_GERAR_ANUI_A1);
        PAINEL_GERAR_ANUI_A1.setLayout(PAINEL_GERAR_ANUI_A1Layout);
        PAINEL_GERAR_ANUI_A1Layout.setHorizontalGroup(
            PAINEL_GERAR_ANUI_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL_GERAR_ANUI_A1Layout.createSequentialGroup()
                .addGroup(PAINEL_GERAR_ANUI_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL_GERAR_ANUI_A1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BOTAO_GERAR_DEBITOS_ANUAIS_1))
                    .addGroup(PAINEL_GERAR_ANUI_A1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(PAINEL_GERAR_ANUI_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ANO1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PAINEL_GERAR_ANUI_A1Layout.setVerticalGroup(
            PAINEL_GERAR_ANUI_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL_GERAR_ANUI_A1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel29)
                .addGap(2, 2, 2)
                .addComponent(ANO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BOTAO_GERAR_DEBITOS_ANUAIS_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel20))
                            .addComponent(SALARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(BOTAO_SALVAR)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PAINEL_GERAR_ANUI_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BOTAO_EDITAR_DADOS)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(5, 5, 5)
                                        .addComponent(SALARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BOTAO_SALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(PAINEL_GERAR_ANUI_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BOTAO_EDITAR_DADOS)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FORM_GUIAS.addTab("", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FORM_GUIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOTAO_SALVARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_SALVARMouseClicked
        if ("cadastrar".equals(status)) {
            if (validarObrigatórios()) {
                AD.salvar_Dados_Para_Calculos(preencher_objeto());
                limparCampos();
            }
        } else if ("alterar".equals(status)) {
            if (validarObrigatórios()) {
                AD.alterar(preencher_objeto());
                limparCampos();
                BOTAO_EDITAR_DADOS.setVisible(true);
                BOTAO_SALVAR.setEnabled(false);
            }
        }
    }//GEN-LAST:event_BOTAO_SALVARMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        if ("cadastrar".equals(status)) {
            limparCampos();
        }else if ("alterar".equals(status)) {
            limparCampos();
            BOTAO_SALVAR.setEnabled(false);
            BOTAO_EDITAR_DADOS.setVisible(true);
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void BOTAO_EDITAR_DADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_EDITAR_DADOSActionPerformed
        D_A = AD.buscarDados();
        preecherCampus(D_A);
        BOTAO_SALVAR.setEnabled(true);
        BOTAO_EDITAR_DADOS.setVisible(false);
    }//GEN-LAST:event_BOTAO_EDITAR_DADOSActionPerformed

    private void BOTAO_GERAR_DEBITOS_ANUAIS_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTAO_GERAR_DEBITOS_ANUAIS_1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BOTAO_GERAR_DEBITOS_ANUAIS_1MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void BOTAO_GERAR_DEBITOS_ANUAIS_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_GERAR_DEBITOS_ANUAIS_1ActionPerformed
        ano = ANO1.getYear();
        boolean ok = false;
        ok = ac.ultima_Anuidade_Recebida(ano);
        if(!ok){
            JOptionPane.showMessageDialog(null, "O sistema já possui taxas anuais cadastradas para o ano escolhido");
        }else{
            String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja cadastrar taxas anuais para os sindicalizados referente ao ano " + ano + "?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[0]);
                if (PromptResult == 0) {
                    AD.buscarSindicalizadosAnuais(ano);
                }
        }
    }//GEN-LAST:event_BOTAO_GERAR_DEBITOS_ANUAIS_1ActionPerformed

    private void SALARIOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SALARIOKeyReleased
        String texto = SALARIO.getText();
        if (!"".equals(texto)) {
            String valor = ac.formatar(texto);
            SALARIO.setText(valor);
        }
    }//GEN-LAST:event_SALARIOKeyReleased

    public void setPosicao() { // faz o formulario aparecer centralizado na tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        if ("cadastrar".equals(status)) {
            BOTAO_EDITAR_DADOS.setVisible(false);

        } else if ("alterar".equals(status)) {

            BOTAO_SALVAR.setEnabled(false);
            ANO1.setEnabled(false);
            BOTAO_GERAR_DEBITOS_ANUAIS_1.setEnabled(false);
        }
    }

    public final void validaNumerosLetras() {
        PEQUENO_P1.setDocument(new Formatar_JTextField());
        PEQUENO_P1.setHorizontalAlignment(JTextField.RIGHT);
        PEQUENO_P2.setDocument(new Formatar_JTextField());
        PEQUENO_P2.setHorizontalAlignment(JTextField.RIGHT);                
        Util_Controller.soNumeros(PORCEN_PEQUENO_P);
        
        MEDIO_P1.setDocument(new Formatar_JTextField());
        MEDIO_P1.setHorizontalAlignment(JTextField.RIGHT);
        MEDIO_P2.setDocument(new Formatar_JTextField());
        MEDIO_P2.setHorizontalAlignment(JTextField.RIGHT);
        Util_Controller.soNumeros(PORCEN_MEDIO_P);
        
        GRANDE_P.setDocument(new Formatar_JTextField());
        GRANDE_P.setHorizontalAlignment(JTextField.RIGHT);
        Util_Controller.soNumeros(PORCEN_GRANDE_P);
    }

    public boolean validarObrigatórios() {
        int i = 0;
        boolean ok = false;
        if ("".equals(PEQUENO_P1.getText()) && i == 0) {
            i++;
            informeDados();
            PEQUENO_P1.requestFocus();
        } else if ("".equals(PEQUENO_P2.getText()) && i == 0) {
            i++;
            informeDados();
            PEQUENO_P2.requestFocus();
        } else if ("".equals(PORCEN_PEQUENO_P.getText()) && i == 0) {
            i++;
            informeDados();
            PORCEN_PEQUENO_P.requestFocus();
        } else if ("".equals(MEDIO_P1.getText()) && i == 0) {
            i++;
            informeDados();
            MEDIO_P1.requestFocus();
        } else if ("".equals(MEDIO_P2.getText()) && i == 0) {
            i++;
            informeDados();
            MEDIO_P2.requestFocus();
        } else if ("".equals(PORCEN_MEDIO_P.getText()) && i == 0) {
            i++;
            informeDados();
            PORCEN_MEDIO_P.requestFocus();
        } else if ("".equals(GRANDE_P.getText()) && i == 0) {
            i++;
            informeDados();
            GRANDE_P.requestFocus();
        } else if ("".equals(PORCEN_GRANDE_P.getText()) && i == 0) {
            i++;
            informeDados();
            PORCEN_GRANDE_P.requestFocus();
        }

        if (i == 0) {
            ok = true;
        }
        return ok;
    }

    public void informeDados() {
        JOptionPane.showMessageDialog(null, "Informe todos os dados obrigatórios", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }

    public DadosAnuidade preencher_objeto() {
        D_A = new DadosAnuidade();

        D_A.setPequenoProdutor_t1(Double.parseDouble(PEQUENO_P1.getText().replace(",", ".")));
        D_A.setPequenoProdutor_t2(Double.parseDouble(PEQUENO_P2.getText().replace(",", ".")));
        D_A.setPequenoProdutor_porcen(Integer.parseInt(PORCEN_PEQUENO_P.getText()));
        D_A.setMedioProdutor_t1(Double.parseDouble(MEDIO_P1.getText().replace(",", ".")));
        D_A.setMedioProdutor_t2(Double.parseDouble(MEDIO_P2.getText().replace(",", ".")));
        D_A.setMedioProdutor_porcen(Integer.parseInt(PORCEN_MEDIO_P.getText()));
        D_A.setGrandeProdutor(Double.parseDouble(GRANDE_P.getText().replace(",", ".")));
        D_A.setGrandeProdutor_porcen(Integer.parseInt(PORCEN_GRANDE_P.getText()));
        String cr = SALARIO.getText().replace(".", "");
        String cre = cr.replace(",", ".");
        D_A.setSalario(Double.parseDouble(cre));
        if ("alterar".equals(status)) {
            D_A.setId(id);
        }

        return D_A;
    }

    public void preecherCampus(DadosAnuidade D_A) {
        PEQUENO_P1.setText(String.valueOf(D_A.getPequenoProdutor_t1()));
        PEQUENO_P2.setText(String.valueOf(D_A.getPequenoProdutor_t2()));
        PORCEN_PEQUENO_P.setText(String.valueOf(D_A.getPequenoProdutor_porcen()));
        MEDIO_P1.setText(String.valueOf(D_A.getMedioProdutor_t1()));
        MEDIO_P2.setText(String.valueOf(D_A.getMedioProdutor_t2()));
        PORCEN_MEDIO_P.setText(String.valueOf(D_A.getMedioProdutor_porcen()));
        GRANDE_P.setText(String.valueOf(D_A.getGrandeProdutor()));
        PORCEN_GRANDE_P.setText(String.valueOf(D_A.getGrandeProdutor_porcen()));
        String v = Util_Controller.converteMuedaBR(D_A.getSalario());
        String[] valor = v.split(" ");
        SALARIO.setText(valor[1]);
        id = D_A.getId();
    }

    public void blouiarCampos() {
        PEQUENO_P1.setEnabled(false);
        PEQUENO_P2.setEnabled(false);
        PORCEN_PEQUENO_P.setEnabled(false);
        MEDIO_P1.setEnabled(false);
        MEDIO_P2.setEnabled(false);
        PORCEN_MEDIO_P.setEnabled(false);
        GRANDE_P.setEnabled(false);
        PORCEN_GRANDE_P.setEnabled(false);
        SALARIO.setEnabled(false);
    }

    public void desblouiarCampos() {
        PEQUENO_P1.setEnabled(true);
        PEQUENO_P2.setEnabled(true);
        PORCEN_PEQUENO_P.setEnabled(true);
        MEDIO_P1.setEnabled(true);
        MEDIO_P2.setEnabled(true);
        PORCEN_MEDIO_P.setEnabled(true);
        GRANDE_P.setEnabled(true);
        PORCEN_GRANDE_P.setEnabled(true);
        SALARIO.setEnabled(true);
    }

    public void limparCampos() {
        PEQUENO_P1.setText("");
        PEQUENO_P2.setText("");
        PORCEN_PEQUENO_P.setText("");
        MEDIO_P1.setText("");
        MEDIO_P2.setText("");
        PORCEN_MEDIO_P.setText("");
        GRANDE_P.setText("");
        PORCEN_GRANDE_P.setText("");
        SALARIO.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ANO1;
    public javax.swing.JButton BOTAO_EDITAR_DADOS;
    private javax.swing.JButton BOTAO_GERAR_DEBITOS_ANUAIS_1;
    private javax.swing.JLabel BOTAO_SALVAR;
    private javax.swing.JTabbedPane FORM_GUIAS;
    private javax.swing.JTextField GRANDE_P;
    private javax.swing.JTextField MEDIO_P1;
    private javax.swing.JTextField MEDIO_P2;
    private javax.swing.JPanel PAINEL_GERAR_ANUI_A1;
    private javax.swing.JTextField PEQUENO_P1;
    private javax.swing.JTextField PEQUENO_P2;
    private javax.swing.JTextField PORCEN_GRANDE_P;
    private javax.swing.JTextField PORCEN_MEDIO_P;
    private javax.swing.JTextField PORCEN_PEQUENO_P;
    private javax.swing.JTextField SALARIO;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
