/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Controle_Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Controle_Caixa_DAO {
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;
    
    public void salvar(Controle_Caixa cont){
        con = Conexao_banco.conector();
     
        try {
            pst = con.prepareStatement("Insert into ControleDeCaixa (banco, data, historico, documento, debito, credito, excluido) values (?,?,?,?,?,?,?)");
            pst.setString(1, cont.getBanco());
            java.sql.Date dataSql = new java.sql.Date(cont.getData().getTime());
            pst.setDate(2, dataSql);
            pst.setString(3, cont.getHistorico());
            pst.setString(4, cont.getDocumento());
            pst.setDouble(5, cont.getDebito());
            pst.setDouble(6, cont.getCredito());
            pst.setInt(7, cont.getExcluido());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados financeiros salvos com sucesso");
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, "Erro ao salvar os dados financeiros", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao salvar os dados financeiros: " + e);
        }
    }
    
    public Controle_Caixa Consultar_Saldo_Atual(Controle_Caixa fdc) {
        con = Conexao_banco.conector();

        try {
            String banco = fdc.getBanco();
            pst = con.prepareStatement("select sum(debito) as resultado_Debito, sum(credito) as resultado_Credito from transacao t inner join ControleDeCaixa f on  t.id_contro = f.id where banco = " + "'" + banco + "'"); //BUSCA O ULTIMO SALDO QUE TIVER NO BANCO
            rs = pst.executeQuery();

            while (rs.next()) {
                fdc.setSoma_debito(rs.getDouble("resultado_Debito"));
                fdc.setSoma_credito(rs.getDouble("resultado_Credito"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar saldo \n" + ex);
            System.out.println(ex);
        }
        return fdc;
    }
}
