/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class UsuarioDAO {
    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;
    
    public void salvar_ADMIN(Usuario usu){
        con = Conexao_banco.conector();
        
        try {
            pst = con.prepareStatement("insert into usuario(nome, telefone, tipo_usuario, login, senha) values (?, ?, ?, ?, ?)");
            pst.setString(1, usu.getNome());
            pst.setString(2, usu.getTelefone());
            pst.setString(3, usu.getTipo_usuario());
            pst.setString(4, usu.getLogin());
            pst.setString(5, usu.getSenha());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar administrador");
            System.out.println(e);
        }
    }
}
