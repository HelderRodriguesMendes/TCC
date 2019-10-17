/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Sindicalizado;
import Model.Dados_Pessoais;
import Model.Dados_Rurais;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Carmen
 */
public class Dados_Sindicalizado_Pessoais_DAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    
    Dados_Pessoais dp = new Dados_Pessoais();
    
    int id = 0, dia = 0, mes = 0;
    
    public boolean niver = true;

    
    public int salvar_Dados_P(Dados_Pessoais dp) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("insert into sindicalizado(nome, dataNasci, celular, nascionalidade, "
                    + "estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, "
                    + "pai, mae, excluido) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)", Statement.RETURN_GENERATED_KEYS);     //Statement.RETURN_GENERATED_KEYS Retorna o ID do sindicalizado que é gerado altomaticamente depois que salva os dados

            pst.setString(1, dp.getNome());
            java.sql.Date DATASQL = new java.sql.Date(dp.getDataNasci().getTime());
            pst.setDate(2, DATASQL);
            pst.setString(3, dp.getCelular());
            pst.setString(4, dp.getNascionalidade());
            pst.setString(5, dp.getEstadoCivil());
            pst.setString(6, dp.getCpf());
            pst.setString(7, dp.getRg());
            java.sql.Date DATA = new java.sql.Date(dp.getDataExpedicao().getTime());
            pst.setDate(8, DATA);
            pst.setString(9, dp.getTituloEleito());
            pst.setInt(10, dp.getZona());
            pst.setInt(11, dp.getSecao());
            pst.setString(12, dp.getReservista());
            pst.setString(13, dp.getCategoria());
            pst.setString(14, dp.getPai());
            pst.setString(15, dp.getMae());
            pst.setInt(16, 0);
            pst.executeUpdate();

            rs = pst.getGeneratedKeys(); // pega o ID que é retornado do comando de insert
            if (rs.next()) {
                id = rs.getInt(1);
            }

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados pessoais", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao salvar dados pessoais: " + e);
        }
        return id;
    }

    
     public void alterar_Dados_P(Dados_Pessoais dp) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("update sindicalizado set nome = ?, dataNasci = ?, celular = ?, nascionalidade = ?, "
                    + "estadoCivil = ?, cpf = ?, rg = ?, dataExpedi = ?, tituloEleito = ?, zona = ?, secao = ?, reservista = ?, categoria = ?, "
                    + "pai = ?, mae = ?, excluido = ? where id_sindicalizado = ?");

            pst.setString(1, dp.getNome());
            java.sql.Date DATASQL = new java.sql.Date(dp.getDataNasci().getTime());
            pst.setDate(2, DATASQL);
            pst.setString(3, dp.getCelular());
            pst.setString(4, dp.getNascionalidade());
            pst.setString(5, dp.getEstadoCivil());
            pst.setString(6, dp.getCpf());
            pst.setString(7, dp.getRg());
            java.sql.Date DATA = new java.sql.Date(dp.getDataExpedicao().getTime());
            pst.setDate(8, DATA);
            pst.setString(9, dp.getTituloEleito());
            pst.setInt(10, dp.getZona());
            pst.setInt(11, dp.getSecao());
            pst.setString(12, dp.getReservista());
            pst.setString(13, dp.getCategoria());
            pst.setString(14, dp.getPai());
            pst.setString(15, dp.getMae());
            pst.setInt(16, 0);
            pst.setInt(17, dp.getId_sindi());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Os dados do sindicalizado foram alterados com sucesso");

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados do sindicalizado", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao alterar os dados do sindicalizado: " + e);
        }
    }
        
    public String verificarCPF_BANCO(String cpf, int id) {
        String ID = "";

        if (id > 0) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select id_sindicalizado from sindicalizado where cpf = ?");
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int i = rs.getInt("id_sindicalizado");                
                    ID = String.valueOf(i);
                }else{
                    ID = "nao cadastrado";
                }
                con.close();
            } catch (SQLException e) {
            }
        } else {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select cpf from sindicalizado where cpf = ?");
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                if (rs.next()) {
                        ID = "tem dono";
                }
                con.close();
            } catch (Exception e) {
            }
        }
        return ID;
    }
     
    
    public String verificarRG_BANCO(String rg, int id) {
        String ID = "";

        if (id > 0) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select id_sindicalizado from sindicalizado where rg = ?");
                pst.setString(1, rg);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int i = rs.getInt("id_sindicalizado");                
                    ID = String.valueOf(i);
                }else{
                    ID = "nao cadastrado";
                }
                con.close();
            } catch (Exception e) {
            }
        } else {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select rg from sindicalizado where rg = ?");
                pst.setString(1, rg);
                rs = pst.executeQuery();

                if (rs.next()) {
                        ID = "tem dono";
                }
                con.close();
            } catch (Exception e) {
            }
        }
        return ID;
    }
        
    
    public ArrayList<Dados_Pessoais> pesquisar_restaurar(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, celular, rg, cpf from sindicalizado where excluido = '1'  and nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();
                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                si.setCelular(rs.getString("celular"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                SIND.add(si);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaturar sindicalizado");
            System.out.println(e);
        }
        return SIND;
    }
     
    
    public void niver() {
        con = Conexao_banco.conector();
        Sindicalizado si = new Sindicalizado();
        si.aniversario(dp, false);
        dia = si.DIA_Atual;
        mes = si.MES_Atual;
        try {
            pst = con.prepareStatement("select nome, dataNasci, celular from  sindicalizado where day(dataNasci) = ? and month(dataNasci) = ? and excluido = '0'");
            pst.setInt(1, dia);
            pst.setInt(2, mes);
            rs = pst.executeQuery();

            while (rs.next()) {
                dp.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                dp.setDataNasci(DATA_U);
                dp.setCelular(rs.getString("celular"));
                int idade = si.aniversario(dp, true);
                if ("(  ) 9     -     ".equals(dp.getCelular())) {
                    dp.setCelular("");
                }
                JOptionPane.showMessageDialog(null, "Os sindicalizados aniversariantes de hoje são:" + "\n" + dp.getNome() + "\n" + "Telefone: " + dp.getCelular() + "\n" + "Idade: " + idade, "Atenção", JOptionPane.INFORMATION_MESSAGE);
                niver = false;
            }
        } catch (Exception e) {
        }
    }
    
    
    public ArrayList<Dados_Pessoais> listar_Tabela_Dados_Pessoais() {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' order by nome");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return SIND;
    }
    
        
    public ArrayList<Dados_Pessoais> pesquisar_nome_cpf_rg(String nome, String cpf, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and nome like ? and cpf like ? and rg like ?");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + cpf + "%");
            pst.setString(3, "%" + rg + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
       
    
    public ArrayList<Dados_Pessoais> pesquisar_nome_cpf(String nome, String cpf) {
        System.out.println("aqii");
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and nome like ? and cpf like ?");
            System.out.println("helde");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + cpf + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
              
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
        
    
    public ArrayList<Dados_Pessoais> pesquisar_nome_rg(String nome, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and nome like ? and rg like ?");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + rg + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }    
    
    
    public ArrayList<Dados_Pessoais> pesquisar_nome(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                System.out.println("nome: " + si.getNome());
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
      
    
    public ArrayList<Dados_Pessoais> pesquisar_cpf_rg(String cpf, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and cpf like ? and rg like ?");
            pst.setString(1, "%" + cpf + "%");
            pst.setString(2, "%" + rg + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
      
    
    public ArrayList<Dados_Pessoais> pesquisar_cpf(String cpf) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and cpf like ?");
            pst.setString(1, "%" + cpf + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
    
        
    public ArrayList<Dados_Pessoais> pesquisar_rg(String rg) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae from sindicalizado where excluido = '0' and rg like ?");
            pst.setString(1, "%" + rg + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();

                si.setId_sindi(rs.getInt("id_sindicalizado"));
                si.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                si.setDataNasci(DATA_U);
                si.setCelular(rs.getString("celular"));
                si.setNascionalidade(rs.getString("nascionalidade"));
                si.setEstadoCivil(rs.getString("estadoCivil"));
                si.setCpf(rs.getString("cpf"));
                si.setRg(rs.getString("rg"));
                java.util.Date data_EX = rs.getDate("dataExpedi");
                si.setDataExpedicao(data_EX);
                si.setTituloEleito(rs.getString("tituloEleito"));
                si.setZona(rs.getInt("zona"));
                si.setSecao(rs.getInt("secao"));
                si.setReservista(rs.getString("reservista"));
                si.setCategoria(rs.getString("categoria"));
                si.setPai(rs.getString("pai"));
                si.setMae(rs.getString("mae"));
                
                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }
}
