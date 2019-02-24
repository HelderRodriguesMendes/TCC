package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Administrador;
import Model.Entidadades.Sindicalizado_Entidade;
import View.Tela_Login;
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
    Administrador adi = new Administrador();
    

    public Administrador logarAdmin(Administrador ad) {

        con = Conexao_banco.conector();
        try {

            pst = con.prepareStatement("select id_admin, tipo_usuario from admin where login = " + "'" + ad.getLogin() + "'" + "and senha = " + "'" + ad.getSenha() + "'");
            rs = pst.executeQuery();

            while (rs.next()) {
                ad.setId(rs.getInt("id_admin"));
                ad.setTipo_usuario(rs.getString("tipo_usuario"));

                if (!"Administrador".equals(ad.getTipo_usuario())) {
                    String login = ad.getLogin();
                    String senha = ad.getSenha();
                   ad = logarSind(login, senha);                  
                } 
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
        return ad;
    }

    public Administrador logarSind(String login, String senha) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select id_sindicalizado, tipo_usuario from sindicalizado where login = " + "'" + login + "'" + "and senha = " + "'" + senha + "'");
            rs = pst.executeQuery();

            while (rs.next()) {
                adi.setId(rs.getInt("id_admin"));
                adi.setTipo_usuario(rs.getString("tipo_usuario"));
                if (!"sindicalizado".equals(adi.getTipo_usuario())) {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                } 
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
        return adi;
    }
}
