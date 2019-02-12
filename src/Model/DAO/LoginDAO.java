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
    boolean adm;

    public boolean logar(Usuario usu) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select tipo_usuario from usuario where login = " + "'" + usu.getLogin() + "'" + "and senha =  " + "'" + usu.getSenha() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {
                usu.setTipo_usuario(rs.getString("tipo_usuario"));
                Login lo = new Login();
                adm = lo.perfilUser(usu.getTipo_usuario());

            } else {
//                new rojerusan.RSNotifyFade("Erro", "Login ou senha incorretos",
//                        7, RSNotifyFade.PositionNotify.TopLef, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
                JOptionPane.showMessageDialog(null, "Login ou senha icorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return adm;
    }
}
