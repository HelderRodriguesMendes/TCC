/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Controle_Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Controle_Caixa_DAO {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void salvar(Controle_Caixa cont) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("Insert into ControleDeCaixa (banco, data, historico, documento, debito, credito, excluido) values (?,?,?,?,?,?,?)");
            pst.setString(1, cont.getBanco());
            java.sql.Date dataSql = new java.sql.Date(cont.getData().getTime());
            pst.setDate(2, dataSql);
            pst.setString(3, cont.getHistorico());
            pst.setString(4, cont.getDocumento());
            pst.setDouble(5, cont.getDebito());
            pst.setDouble(6, cont.getCredito());
            pst.setInt(7, cont.getExcluido());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados financeiros salvos com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, "Erro ao salvar os dados financeiros", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao salvar os dados financeiros: " + e);
        }
    }

    public Controle_Caixa Consultar_Saldo_Atual_data_data_banco(Date data1, Date data2, String banco) {
        Controle_Caixa CC = new Controle_Caixa();
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("select sum(debito) as resultado_Debito, sum(credito) as resultado_Credito from ControleDeCaixa where data between ? and ? and banco = ? and excluido = '0'"); //BUSCA O ULTIMO SALDO QUE TIVER NO BANCO
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            pst.setDate(1, DATASQL1);
            java.sql.Date DATASQL2 = new java.sql.Date(data2.getTime());
            pst.setDate(2, DATASQL2);
            pst.setString(3, banco);
            rs = pst.executeQuery();

            while (rs.next()) {
                CC.setSoma_debito(rs.getDouble("resultado_Debito"));
                CC.setSoma_credito(rs.getDouble("resultado_Credito"));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar saldo \n" + ex);
            System.out.println(ex);
        }
        return CC;
    }
    public Controle_Caixa Consultar_Saldo_Atual_data_data(Date data1, Date data2) {
        Controle_Caixa CC = new Controle_Caixa();
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("select sum(debito) as resultado_Debito, sum(credito) as resultado_Credito from ControleDeCaixa where data between ? and ? and excluido = '0'"); //BUSCA O ULTIMO SALDO QUE TIVER NO BANCO
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            pst.setDate(1, DATASQL1);
            java.sql.Date DATASQL2 = new java.sql.Date(data2.getTime());
            pst.setDate(2, DATASQL2);
            rs = pst.executeQuery();

            while (rs.next()) {
                CC.setSoma_debito(rs.getDouble("resultado_Debito"));
                CC.setSoma_credito(rs.getDouble("resultado_Credito"));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar saldo \n" + ex);
            System.out.println(ex);
        }
        return CC;
    }

    public ArrayList<Controle_Caixa> listar_tabela_alterar() {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where excluido = '0' order by data, day(data)");
            rs = pst.executeQuery();

            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Controle_Caixa> consultar_data_data_banco(Date data1, Date data2, String banco) {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where data between ? and ? and banco = ? and excluido = '0' order by data, day(data)");
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            java.sql.Date DATASQL2 = new java.sql.Date(data2.getTime());
            pst.setDate(1, DATASQL1);
            pst.setDate(2, DATASQL2);
            pst.setString(3, banco);
            rs = pst.executeQuery();
            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Controle_Caixa> consultar_data(Date data1) {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where data = ? and excluido = '0' order by data, day(data)");
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            pst.setDate(1, DATASQL1);
            rs = pst.executeQuery();
            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Controle_Caixa> consultar_data_data(Date data1, Date data2) {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where data between ? and ? and excluido = '0' order by data, day(data)");
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            java.sql.Date DATASQL2 = new java.sql.Date(data2.getTime());
            pst.setDate(1, DATASQL1);
            pst.setDate(2, DATASQL2);
            rs = pst.executeQuery();
            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Controle_Caixa> consultar_banco(String banco) {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where banco = ? and excluido = '0' order by data");
            pst.setString(1, banco);
            rs = pst.executeQuery();
            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }

    public ArrayList<Controle_Caixa> consultar_data_banco(Date data1, String banco) {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where data = ? and banco = ? and excluido = '0' order by data, day(data)");
            java.sql.Date DATASQL1 = new java.sql.Date(data1.getTime());
            pst.setDate(1, DATASQL1);
            pst.setString(3, banco);
            rs = pst.executeQuery();
            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de consultas do contre de caixa", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }
    
    
    
    
    public double somaHectares(int id){
        System.out.println("id na dao da soma de terras: " + id);
        con = Conexao_banco.conector();
        double soma = 0;
        
        try {
            pst = con.prepareStatement("select sum(areaPropriedade) as somaDasPropiedades from propriedadeRural p "
                    + "inner join sindicalizado s on p.id_sind = s.id_sindicalizado where excluidoP = '0' and  id_sind = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()){
                soma = rs.getInt("somaDasPropiedades");
                System.out.println("soma: " + soma);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao somar hectares das propriedades rurais", "Atenção", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao somar hectares das propriedades rurais: " + e);
        }
        return soma;
    }

    
    
    
    
    
    
    
    public void alterar(Controle_Caixa cc) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update ControleDeCaixa set banco = ?, data = ?, historico = ?, documento = ?, debito = ?, credito = ? where id_controleCaixa = ?");
            pst.setString(1, cc.getBanco());
            java.sql.Date dataSql = new java.sql.Date(cc.getData().getTime());
            pst.setDate(2, dataSql);
            pst.setString(3, cc.getHistorico());
            pst.setString(4, cc.getDocumento());
            pst.setDouble(5, cc.getDebito());
            pst.setDouble(6, cc.getCredito());
            pst.setInt(7, cc.getId());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Os dados financeiros foram alterados com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados financeiros", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao alterar os dados financeiros: " + e);
        }
    }

    public void excluir(int id) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update ControleDeCaixa set excluido = '1' where id_controleCaixa = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados financeiros excluidos com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados financeiros", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao excluir dados financeiros: " + e);
        }
    }

    public ArrayList<Controle_Caixa> pesquisar_restaurar() {
        con = Conexao_banco.conector();
        ArrayList<Controle_Caixa> C = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_controleCaixa, banco, data, documento, historico, debito, credito from ControleDeCaixa where excluido = '1' order by data");
            rs = pst.executeQuery();

            while (rs.next()) {
                Controle_Caixa c = new Controle_Caixa();
                c.setId(rs.getInt("id_controleCaixa"));
                c.setBanco(rs.getString("banco"));
                java.util.Date DATA_U = rs.getDate("data");
                c.setData(DATA_U);
                c.setHistorico(rs.getString("historico"));
                c.setDocumento(rs.getString("documento"));
                c.setDebito(rs.getDouble("debito"));
                c.setCredito(rs.getDouble("credito"));
                C.add(c);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao lista dados na tabela de contre de caixa excluidos", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao lista dados na tabela de consultas do contre de caixa: " + e);
        }
        return C;
    }

    public void restaurar(int id) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update ControleDeCaixa set excluido = '0' where id_controleCaixa = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restautação realizada com sucesso");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar dados financeiros");
            System.out.println(e);
        }
    }
    
    public void CriarTabelaDatasPesquisa(Date data1, Date data2){
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("create table datas(data1 date, data2 date, idDatas int primary key not null auto_increment)");
            pst.executeUpdate();
            System.out.println("TABELA CRIADA");
            salvaDatasPesquisa(data1, data2);
            con.close();
        } catch (Exception e) {
            System.out.println(" NÃO SALVO AS DASTAS DE PESQUISA");
        }
    }
    public void salvaDatasPesquisa(Date data1, Date data2){
        System.out.println("helder 2");
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("insert into datas (data1, data2) values (?,?)");
            java.sql.Date dataSqll = new java.sql.Date(data1.getTime());
            java.sql.Date dataSql2 = new java.sql.Date(data2.getTime());
            pst.setDate(1, dataSqll);
            pst.setDate(2, dataSql2);
            pst.executeUpdate();
            System.out.println("SALVO AS DASTAS DE PESQUISA");
            con.close();
        } catch (Exception e) {
            System.out.println(" NÃO SALVO AS DASTAS DE PESQUISA");
        }
    }
    public void excluirDatasPesquisa(){
        int id = ultimoID();

        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("delete from datas where idDatas = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("EXCLUIU A TABELA DASTAS DE PESQUISA");
            con.close();
        } catch (Exception e) {
            System.out.println(" NÃO EXCLUIU A TABELA DASTAS DE PESQUISA");
        }
    }
    public int ultimoID(){
        int i = 0;
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("select max(idDatas) as ID from datas;");
            rs = pst.executeQuery();
            if(rs.next()){
               i =  rs.getInt("ID");
            }
            System.out.println("EXCLUIU A TABELA DASTAS DE PESQUISA");
            con.close();
        } catch (Exception e) {
            System.out.println(" NÃO EXCLUIU A TABELA DASTAS DE PESQUISA");
        }
        return i;
    }
    
    
    
}
