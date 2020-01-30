/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Administrador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class AdministradorDAO {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;
    boolean login = true;
    int id = 0;

    public Administrador logarAdmin(Administrador ad) {

        con = Conexao_banco.conector();
        try {

            pst = con.prepareStatement("select id_admin, excluido from admin where login = " + "'" + ad.getLogin() + "'" + "and senha = " + "'" + ad.getSenha() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {
                ad.setId(rs.getInt("id_admin"));
                ad.setExcluido(rs.getBoolean("excluido"));
            } else {
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
            con.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "O sistema não está conectado com a base de dados", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }
        return ad;
    }

    public boolean salvar_ADMIN(Administrador usu) {
        login = verificar_login(usu);
        if (!login) {
            con = Conexao_banco.conector();

            try {
                pst = con.prepareStatement("insert into admin(nome, celular, login, senha, excluido) values (?, ?, ?, ?,?)");

                pst.setString(1, usu.getNome());
                pst.setString(2, usu.getCelular());
                pst.setString(3, usu.getLogin());
                pst.setString(4, usu.getSenha());
                pst.setBoolean(5, usu.getExcluido());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
                con.close();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar administrador");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O login desejado já existe no sistema", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        return login;
    }

    public ArrayList<Administrador> list_JTable() {
        con = Conexao_banco.conector();

        ArrayList<Administrador> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, celular, login from admin where excluido = '0' order by nome");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador ad = new Administrador();

                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setCelular(rs.getString("celular"));
                ad.setLogin(rs.getString("login"));
                if ("(  )       -      ".equals(ad.getCelular())) {
                    ad.setCelular("");
                }

                AD.add(ad);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return AD;
    }

    public ArrayList<Administrador> select_Name(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Administrador> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, celular, login from admin where excluido = '0' and nome like ? order by nome");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador ad = new Administrador();

                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setCelular(rs.getString("celular"));
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

    public boolean alterar_ADMIN(Administrador adm, int ID) {
        login = verificar_login(adm);

        if (!login) {
            con = Conexao_banco.conector();

            if (!"".equals(adm.getSenha())) {

                try {
                    pst = con.prepareStatement("update admin set nome = ?, celular = ?, login = ?, senha = ? where id_admin = ?");
                    pst.setString(1, adm.getNome());
                    pst.setString(2, adm.getCelular());
                    pst.setString(3, adm.getLogin());
                    pst.setString(4, adm.getSenha());
                    pst.setInt(5, adm.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados do administrador");
                    System.out.println(e);
                }
            } else {
                try {
                    pst = con.prepareStatement("update admin set nome = ?, celular = ?, login = ? where id_admin = ?");
                    pst.setString(1, adm.getNome());
                    pst.setString(2, adm.getCelular());
                    pst.setString(3, adm.getLogin());
                    pst.setInt(4, adm.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados do administrador");
                    System.out.println(e);
                }
            }
        } else if (this.id == ID) {
            con = Conexao_banco.conector();

            if (!"".equals(adm.getSenha())) {

                try {
                    pst = con.prepareStatement("update admin set nome = ?, celular = ?, login = ?, senha = ? where id_admin = ?");
                    pst.setString(1, adm.getNome());
                    pst.setString(2, adm.getCelular());
                    pst.setString(3, adm.getLogin());
                    pst.setString(4, adm.getSenha());
                    pst.setInt(5, adm.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados do administrador");
                    System.out.println(e);
                }
            } else {
                try {
                    pst = con.prepareStatement("update admin set nome = ?, celular = ?, login = ? where id_admin = ?");
                    pst.setString(1, adm.getNome());
                    pst.setString(2, adm.getCelular());
                    pst.setString(3, adm.getLogin());
                    pst.setInt(4, adm.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados do administrador");
                    System.out.println(e);
                }
            }
            login = true;
        } else {
            JOptionPane.showMessageDialog(null, "O login desejado já existe no sistema", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        return login;
    }

    public boolean verificar_login(Administrador adm) {
        con = Conexao_banco.conector();
        boolean lo = false;
        try {
            pst = con.prepareStatement("select id_admin from admin where login = ?");
            pst.setString(1, adm.getLogin());
            rs = pst.executeQuery();

            if (rs.next()) {  // verifico si tem algum login no sistema q é igual ao novo login informado  
                lo = true;
                this.id = rs.getInt("id_admin");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return lo;
    }

    public void restaurar(int id) {
        int a = 0;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update admin set excluido = ? where id_admin = ?");
            pst.setInt(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restauração realizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar administrador");
            System.out.println(e);
        }
    }

    public ArrayList<Administrador> lista_restaurar() {
        con = Conexao_banco.conector();
        ArrayList<Administrador> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, celular, login from admin where excluido = '1'");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador ad = new Administrador();
                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setCelular(rs.getString("celular"));
                ad.setLogin(rs.getString("login"));
                AD.add(ad);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar Administrador 1");
            System.out.println(e);
        }
        return AD;
    }

    public ArrayList<Administrador> pesquisar_restaurar(String no) {
        con = Conexao_banco.conector();
        ArrayList<Administrador> AD = new ArrayList();

        try {
            pst = con.prepareStatement("select id_admin, nome, celular from admin where excluido = '1' and nome like ?");
            pst.setString(1, "%" + no + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador ad = new Administrador();
                ad.setId(rs.getInt("id_admin"));
                ad.setNome(rs.getString("nome"));
                ad.setCelular(rs.getString("celular"));
                AD.add(ad);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar Administrador 1");
            System.out.println(e);
        }
        return AD;
    }

}
