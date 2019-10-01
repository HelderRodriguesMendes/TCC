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

    public void salvar_Dados_R(ArrayList<Dados_Rurais> DADOS_R, int ID) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("insert into propriedadeRural(nomeFazenda, logradouro, municipioCede, codigoINCRA, NIRF, "
                    + "areaPropriedade, tempoCompraPropriedade, outrasAtividade, "
                    + "residenciaAtual, excluido, id_sind) values (?,?,?,?,?,?,?,?,?,?,?)");

            for (int i = 0; i < DADOS_R.size(); i++) {
                Dados_Rurais dados_r = DADOS_R.get(i);

                pst.setString(1, dados_r.getNomeFazenda());
                pst.setString(2, dados_r.getLogradouro());
                pst.setString(3, dados_r.getMuniciSede());
                pst.setString(4, dados_r.getCodINCRA());
                pst.setString(5, dados_r.getNIRF());
                pst.setString(6, dados_r.getAreaPropri());
                pst.setString(7, dados_r.getTempoCompra());
                pst.setString(8, dados_r.getOutrasA());
                pst.setString(9, dados_r.getResidenciaAtual());
                pst.setInt(10, dados_r.getExcluido());
                pst.setInt(11, ID);
                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Sindicalizado cadastrado com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar sindicalizado", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao cadastrar sindicalizado: " + e);
        }
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

    public ArrayList<Dados_Pessoais> pesquisar_restaurar(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Dados_Pessoais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, celular, rg, cpf from sindicalizado where excluido = '1'  and nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Dados_Pessoais si = new Dados_Pessoais();
                si.setId(rs.getInt("id_sindicalizado"));
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

    public void restaurar(int id) {
        int a = 0;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update sindicalizado set excluido = ? where id_sindicalizado = ?");
            pst.setInt(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restautação realizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar sindicalizado");
            System.out.println(e);
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
            } catch (Exception e) {
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
}
