/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Util_DAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void excluir(int id, String tipo) {
        con = Conexao_banco.conector();

        try {
            if ("sind".equals(tipo)) {
                pst = con.prepareStatement("update sindicalizado set excluido = ? where id_sindicalizado = ?");
            } else if ("adm".equals(tipo)) {
                pst = con.prepareStatement("update admin set excluido = ? where id_admin = ?");
            }
            pst.setInt(1, 1);
            pst.setInt(2, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir os dados");
            System.out.println(e);
        }
    }
    public void Acessar_Facebook(){
        try {
            URI link = new URI("https://www.facebook.com/Sindicato-Rural-de-Aren%C3%B3polis-395277340679811/");
            Desktop.getDesktop().browse(link);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
