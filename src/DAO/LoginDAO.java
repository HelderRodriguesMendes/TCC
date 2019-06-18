package DAO;

import DAO.Conexao_banco;
import Model.Administrador_Entidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class LoginDAO {

    ResultSet rs;
    PreparedStatement pst = null;
    Connection con;
    Administrador_Entidade adi = new Administrador_Entidade();

    public Administrador_Entidade logarAdmin(Administrador_Entidade ad) {

        con = Conexao_banco.conector();
        try {

            pst = con.prepareStatement("select id_admin, tipo_usuario from admin where login = " + "'" + ad.getLogin() + "'" + "and senha = " + "'" + ad.getSenha() + "'");
            rs = pst.executeQuery();
            
            if (rs.next()) {
                ad.setId(rs.getInt("id_admin"));
                ad.setTipo_usuario(rs.getString("tipo_usuario"));
            } else {
                String login = ad.getLogin();
                String senha = ad.getSenha();
                Administrador_Entidade adim;
                adim = logarSind(login, senha);
                ad = adim;
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
        return ad;
    }

    public Administrador_Entidade logarSind(String login, String senha) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select id_sindicalizado, tipo_usuario from sindicalizado where login = " + "'" + login + "'" + "and senha = " + "'" + senha + "'");
            rs = pst.executeQuery();

            if (rs.next()) {
                adi.setId(rs.getInt("id_sindicalizado"));
                adi.setTipo_usuario(rs.getString("tipo_usuario"));
            } else {
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
           
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
        return adi;
    }
}
