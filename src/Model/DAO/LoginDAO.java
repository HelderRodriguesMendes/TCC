package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Administrador;
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
    

    int id = 0;
    String perf = "";

    public void logarAdmin(String login, String senha) {
        System.out.println("login: " + login);
        System.out.println("senha: " + senha);
        con = Conexao_banco.conector();
        try {
            
            pst = con.prepareStatement("select id_admin, tipo_usuario from admin where login = " + "'" + login + "'" + "and senha = " + "'" + senha + "'");
            rs = pst.executeQuery();
            System.out.println("AQUI");
            while (rs.next()) {
                id = (rs.getInt("id_admin"));
                perf = (rs.getString("tipo_usuario"));
                 
                 System.out.println("TIPO USUARIO: " + perf);
                if ("Administrador".equals(perf)) {
                    Tela_Login tl = new Tela_Login();
                    tl.abrirInterface(perf, id);
                    
                } else {
                    logarSind(login, senha);
                }
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
    }

    public void logarSind(String login, String senha) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select id_sindicalizado, tipo_usuario from sindicalizado where login = " + "'" + login + "'" + "and senha = " + "'" + senha + "'");
            rs = pst.executeQuery();

            while (rs.next()) {
                id = (rs.getInt("id_admin"));
                perf = (rs.getString("tipo_usuario"));
                if ("sindicalizado".equals(perf)) {
                    Tela_Login tl = new Tela_Login();
                    tl.abrirInterface(perf, id);
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema");
            System.out.println(e);
        }
    }
}
