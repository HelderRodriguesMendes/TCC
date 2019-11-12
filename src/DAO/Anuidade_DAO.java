/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Anuidade;
import Model.DadosAnuidade;
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
public class Anuidade_DAO {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public DadosAnuidade D_A;

    public boolean verificaCadastro(String v) {
        boolean ok = false;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("select * from dadosAnuidade");
            rs = pst.executeQuery();
            if ("verificar".equals(v)) {
                if (rs.next()) {
                    ok = true;
                }
            } else if ("buscar".equals(v)) {
                D_A = new DadosAnuidade();
                while (rs.next()) {
                    D_A.setId(rs.getInt("id_dadosAnuidade"));
                    D_A.setSalario(rs.getDouble("salario"));
                    D_A.setPequenoProdutor_t1(rs.getInt("pequenoProdutor_t1"));
                    D_A.setPequenoProdutor_t2(rs.getInt("pequenoProdutor_t2"));
                    D_A.setPequenoProdutor_porcen(rs.getInt("pequenoProdutor_porcen"));
                    D_A.setMedioProdutor_t1(rs.getInt("medioProdutor_t1"));
                    D_A.setMedioProdutor_t2(rs.getInt("medioProdutor_t2"));
                    D_A.setMedioProdutor_porcen(rs.getInt("medioProdutor_porcen"));
                    D_A.setGrandeProdutor(rs.getInt("grandeProdutor"));
                    D_A.setGrandeProdutor_porcen(rs.getInt("grandeProdutor_porcen"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar cadastro de dados para calculos da anuidade", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }

    public void salvar_Dados_Para_Calculos(DadosAnuidade DA) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("insert into dadosAnuidade (salario, pequenoProdutor_t1, pequenoProdutor_t2, pequenoProdutor_porcen, medioProdutor_t1, medioProdutor_t2, medioProdutor_porcen, grandeProdutor, grandeProdutor_porcen) values (?,?,?,?,?,?,?,?,?)");
            pst.setDouble(1, DA.getSalario());
            pst.setInt(2, DA.getPequenoProdutor_t1());
            pst.setInt(3, DA.getPequenoProdutor_t2());
            pst.setInt(4, DA.getPequenoProdutor_porcen());
            pst.setInt(5, DA.getMedioProdutor_t1());
            pst.setInt(6, DA.getMedioProdutor_t2());
            pst.setInt(7, DA.getMedioProdutor_porcen());
            pst.setInt(8, DA.getGrandeProdutor());
            pst.setInt(9, DA.getGrandeProdutor_porcen());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados para cálculos salvos com sucesso");
            con.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar os dados para cálculos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao cadastrar os dados para cálculos: " + e);
        }
    }

    public void alterar(DadosAnuidade DA) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update dadosAnuidade set salario = ?, pequenoProdutor_t1 = ?, pequenoProdutor_t2 = ?, pequenoProdutor_porcen = ?, medioProdutor_t1 = ?, medioProdutor_t2 = ?, medioProdutor_porcen = ?, grandeProdutor = ?, grandeProdutor_porcen = ?");
            pst.setDouble(1, DA.getSalario());
            pst.setInt(2, DA.getPequenoProdutor_t1());
            pst.setInt(3, DA.getPequenoProdutor_t2());
            pst.setInt(4, DA.getPequenoProdutor_porcen());
            pst.setInt(5, DA.getMedioProdutor_t1());
            pst.setInt(6, DA.getMedioProdutor_t2());
            pst.setInt(7, DA.getMedioProdutor_porcen());
            pst.setInt(8, DA.getGrandeProdutor());
            pst.setInt(9, DA.getGrandeProdutor_porcen());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados para cálculos alterados com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados para cálculos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao alterar os dados para cálculos: " + e);
        }
    }

    public void buscarSindicalizadosAnuais(int ano) {
        ArrayList<Integer> ID = new ArrayList<>();
        con = Conexao_banco.conector();
        int id = 0;

        try {
            pst = con.prepareStatement("select id_sindicalizado from sindicalizado where excluidoS = '0' ");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_sindicalizado");
                ID.add(id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar sindicalizados para gerar débitos anuais", "Atenção", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao pesquisar sindicalizados para gerar débitos anuais: " + e);
        }
        gerarDebitosAnuais(ano, ID);
    }

    public void gerarDebitosAnuais(int ano, ArrayList ID) {
        for (int i = 0; i < ID.size(); i++) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("insert into recebimentoAnuidade (anoRecebimento, statusPagamento, id_sindica, excluido) values (?,?,?,?)");
                pst.setInt(1, ano);
                pst.setBoolean(2, false);
                int iid = (int) ID.get(i);
                pst.setInt(3, iid);
                pst.setBoolean(4, false);
                pst.executeUpdate();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar débitos anuais", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Débitos anuais gerados com sucesso");

    }

    public ArrayList verificarAnuidadesGeradas() {
        
        int ano;
        con = Conexao_banco.conector();
        ArrayList<Integer> ANO = new ArrayList<>();
        try {
            pst = con.prepareStatement("select distinct(anoRecebimento) from recebimentoAnuidade where excluido = '0' order by anoRecebimento desc");
            rs = pst.executeQuery();

            while (rs.next()) {
                ano = rs.getInt("anoRecebimento");
                ANO.add(ano);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os anos de anuidades que já foram gerados", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao buscar os anos de anuidades que já foram recebidas: " + e);
        }
        return ANO;
    }
//##########################################################################################################################################################################################################################################################
//##########################################################################################################################################################################################################################################################
//##########################################################################################################################################################################################################################################################
    public ArrayList<Anuidade> listar_anuidades_Geral_Atual() {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> Anu = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado order by nome, anoRecebimento");
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                Anu.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return Anu;
    }

    public ArrayList<Anuidade> anuidades_Nao_pagas_ANO(int ano) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '0' and anoRecebimento = ?");
            pst.setInt(1, ano);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }

    public ArrayList<Anuidade> anuidades_pagas_ANO(int ano) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '1' and anoRecebimento = ?");
            pst.setInt(1, ano);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }
    
    public ArrayList<Anuidade> anuidades_Nao_pagas_Nome(String nome) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '0' and nome = ?");
            pst.setString(1, nome);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }
    
    public ArrayList<Anuidade> anuidades_pagas_Nome(String nome) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '1' and nome = ?");
            pst.setString(1, nome);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }
    
    public ArrayList<Anuidade> anuidades_Nao_pagas_Nome_Ano(String nome, int ano) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '0' and nome = ? and anoRecebimento = ?");
            pst.setString(1, nome);
            pst.setInt(2, ano);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }
    
    public ArrayList<Anuidade> anuidades_pagas_Nome_Ano(String nome, int ano) {
        con = Conexao_banco.conector();
        ArrayList<Anuidade> A = new ArrayList<>();

        try {
            pst = con.prepareStatement("select nome, celular, anoRecebimento, statusPagamento from recebimentoAnuidade a inner join sindicalizado s on a.id_sindica = s.id_sindicalizado where statusPagamento = '1' and nome = ? and anoRecebimento = ?");
            pst.setString(1, nome);
            pst.setInt(2, ano);
            rs = pst.executeQuery();

            while (rs.next()) {
                Anuidade a = new Anuidade();
                a.setNome(rs.getString("nome"));
                a.setCelular(rs.getString("celular"));
                a.setAnoRecebimento(rs.getInt("anoRecebimento"));
                a.setStatusPagamento(rs.getBoolean("statusPagamento"));
                A.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar débitos anuais não pagos", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao listar débitos anuais não pagos: " + e);
        }
        return A;
    }
}
