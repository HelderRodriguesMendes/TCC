package Model.DAO;

import Controller.Login;
import Model.Conexao_banco;
import Model.Entidadades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyFade;

/**
 *
 * @author helde
 */
public class LoginDAO {

    ResultSet rs;
    PreparedStatement pst = null;
    Connection con;

    public boolean logar(Usuario usu) {
        boolean adm = false;
        String senhaTela = usu.getSenha();
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select id_usuario, tipo_usuario from usuario where login = " + "'" + usu.getLogin() + "'" + "and senha = " + "'" + usu.getSenha() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {
                usu.setId(rs.getInt("id_usuario"));
                usu.setTipo_usuario(rs.getString("tipo_usuario"));
                Login lo = new Login();
                adm = lo.perfilUser(usu);

            } else {
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
        return adm;
    }
}
