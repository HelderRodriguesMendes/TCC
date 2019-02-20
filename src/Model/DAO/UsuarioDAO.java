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
public class UsuarioDAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void salvar_ADMIN(Administrador usu) {
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
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar administrador");
            System.out.println(e);
        }
    }

    public ArrayList<Sindicalizado_Entidade> PesquisarNCR(Sindicalizado_Entidade s) {
        con = Conexao_banco.conector();
        System.out.println("NOME: " + s.getNome());
        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
            try {
                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where nome = " + "'" + s.getNome() + "'" + "and cpf = " + "'" + s.getCpf() + "'" + "and rg = " + "'" + s.getRg() + "'");
                rs = pst.executeQuery();

                if (rs.next()) {
                    while (rs.next()) {
                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
                        se.setId(rs.getInt("id_sindicalizado"));
                        se.setNome(rs.getString("nome"));
                        se.setCpf(rs.getString("cpf"));
                        se.setRg(rs.getString("rg"));
                        SIND.add(se);
                    }
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados  1");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 1", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(e);
            }
        return SIND;
    }

//    public ArrayList<Sindicalizado_Entidade> PesquisarNC(Sindicalizado_Entidade s) {
//        
//        con = Conexao_banco.conector();
//        System.out.println("NOME: " + s.getNome());
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where nome = " + "'" + s.getNome() + "'" + "and cpf = " + "'" + s.getCpf() + "'");
//                rs = pst.executeQuery();
//                System.out.println("AQUII");
//                if (rs.next()) {
//                    while (rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        SIND.add(se);
//                    }
//                    con.close();
//                    return SIND;
//                } else {
//                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 2");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 2", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;
//    }
//    
//    public ArrayList<Sindicalizado_Entidade> PesquisarCR(Sindicalizado_Entidade s) {
//        con = Conexao_banco.conector();
//        System.out.println("NOME: " + s.getNome());
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where cpf = " + "'" + s.getCpf() + "'" + "and rg = " + "'" + s.getRg() + "'");
//                rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    while (rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        SIND.add(se);
//                    }
//                    con.close();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 3");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 3", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;
//    }
//    
//    public ArrayList<Sindicalizado_Entidade> PesquisarNR(Sindicalizado_Entidade s) {
//        con = Conexao_banco.conector();
//        System.out.println("NOME: " + s.getNome());
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where nome = " + "'" + s.getNome() + "'" + "and rg = " + "'" + s.getRg() + "'");
//                rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    while(rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        SIND.add(se);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 4");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 4", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;    
//    }
//    
//    public ArrayList<Sindicalizado_Entidade> PesquisarN(Sindicalizado_Entidade s) {
//        con = Conexao_banco.conector();
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where nome = 'Bruno'");
//                rs = pst.executeQuery();
//                
////                if (rs.next()) {
////                    System.out.println("NOME N: " + s.getNome());
//                    while (rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        System.out.println("CPF: " + se.getCpf());
//                        SIND.add(se);
//                    }
//                    con.close();
////                } else {
////                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 5");
////                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 5", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;
//    }
//    
//    public ArrayList<Sindicalizado_Entidade> PesquisarC(Sindicalizado_Entidade s) {
//        con = Conexao_banco.conector();
//        System.out.println("NOME: " + s.getNome());
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where cpf = " + "'" + s.getCpf() + "'");
//                rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    while (rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        SIND.add(se);
//                    }
//                    con.close();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 6");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 6", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;
//    }
//    
//    public ArrayList<Sindicalizado_Entidade> PesquisarR(Sindicalizado_Entidade s) {
//        con = Conexao_banco.conector();
//        System.out.println("NOME: " + s.getNome());
//        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();
//            try {
//                pst = con.prepareStatement("select id_sindicalizado, nome, cpf, rg from sindicalizado where rg = " + "'" + s.getRg() + "'");
//                rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    while (rs.next()) {
//                        Sindicalizado_Entidade se = new Sindicalizado_Entidade();
//                        se.setId(rs.getInt("id_sindicalizado"));
//                        se.setNome(rs.getString("nome"));
//                        se.setCpf(rs.getString("cpf"));
//                        se.setRg(rs.getString("rg"));
//                        SIND.add(se);
//                    }
//                    con.close();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Não foi encontrado o sindicalizado correspondente aos dados informados 7");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao pesquisar por sindicalizado 7", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(e);
//            }
//        return SIND;
//    }
}
