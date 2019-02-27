/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Sindicalizado_Entidade;
import Model.Entidadades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class AdministradorDAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void salvar_ADMIN(Administrador usu) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("insert into admin(nome, telefone, tipo_usuario, login, senha) values (?, ?, ?, ?, ?)");
            pst.setString(1, usu.getNome());
            pst.setString(2, usu.getTelefone());
            pst.setString(3, usu.getTipo_usuario());
            pst.setString(4, usu.getLogin());
            pst.setString(5, usu.getSenha());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar administrador");
            System.out.println(e);
        }
    }

    public ArrayList<Administrador>Listar_Tabela(){
        con = Conexao_banco.conector();
        
        ArrayList<Administrador>AD = new ArrayList();
        
        try {
            pst = con.prepareStatement("select id_admin, nome, telefone, login from admin");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Administrador ad = new Administrador();
                
                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setTelefone(rs.getString("telefone"));
                ad.setLogin(rs.getString("login"));
                
                AD.add(ad);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return AD;
    }
    public ArrayList<Administrador>Pesquisar_Nome(String nome){
        con = Conexao_banco.conector();
        
        ArrayList<Administrador>AD = new ArrayList();
        
        try {
            pst = con.prepareStatement("select id_admin, nome, telefone, login from admin where nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Administrador ad = new Administrador();
                
                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setTelefone(rs.getString("telefone"));
                ad.setLogin(rs.getString("login"));
                
                AD.add(ad);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return AD;
    }
}
