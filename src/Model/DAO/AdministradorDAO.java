/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Administrador_Entidade;
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

    public void salvar_ADMIN(Administrador_Entidade usu) {
        
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

    public ArrayList<Administrador_Entidade> Listar_Tabela() {
        con = Conexao_banco.conector();

        ArrayList<Administrador_Entidade> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, telefone, login from admin");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador_Entidade ad = new Administrador_Entidade();

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

    public ArrayList<Administrador_Entidade> Pesquisar_Nome(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Administrador_Entidade> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, telefone, login from admin where nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador_Entidade ad = new Administrador_Entidade();

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

    public void alterar_ADMIN(Administrador_Entidade adm) {
        con = Conexao_banco.conector();

        if (!"".equals(adm.getSenha())) {
            try {
                pst = con.prepareStatement("update admin set nome = ?, telefone = ?, login = ?, senha = ? where id_admin = ?");
                pst.setString(1, adm.getNome());
                pst.setString(2, adm.getTelefone());
                pst.setString(3, adm.getLogin());
                pst.setString(4, adm.getSenha());
                pst.setInt(5, adm.getId());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar dados administrador");
                System.out.println(e);
            }
        }else{
            try {
                pst = con.prepareStatement("update admin set nome = ?, telefone = ?, login = ? where id_admin = ?");
                pst.setString(1, adm.getNome());
                pst.setString(2, adm.getTelefone());
                pst.setString(3, adm.getLogin());
                pst.setInt(4, adm.getId());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null , "Dados alterados com sucesso");
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar dados administrador");
                System.out.println(e);
            }
        }
    }
}
