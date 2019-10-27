/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sindicalizado_Rurais;
import View.Sindicalizado_View;
import View.Restaurar_View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sindicalizado_Rurais_DAO {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public String verificarNIRF_BANCO(String nirf, int id) {
        String ID = "";

        if (id > 0) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select id_sind from propriedadeRural where NIRF = ?");
                pst.setString(1, nirf);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int i = rs.getInt("id_sind");
                    ID = String.valueOf(i);
                } else {
                    ID = "nao cadastrado";
                }
                con.close();
            } catch (Exception e) {
            }
        } else {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select NIRF from propriedadeRural where NIRF = ?");
                pst.setString(1, nirf);
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

    public String verificarINCRA_BANCO(String incra, int id) {
        String ID = "";
        System.out.println("ID INCRA: " + id);
        if (id > 0) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select id_sind from propriedadeRural where codigoINCRA = ?");
                pst.setString(1, incra);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int i = rs.getInt("id_sind");
                    ID = String.valueOf(i);
                } else {
                    ID = "nao cadastrado";
                }
                con.close();
            } catch (SQLException e) {
            }
        } else {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select codigoINCRA from propriedadeRural where codigoINCRA = ?");
                pst.setString(1, incra);
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

    public void salvar_Dados_R(Sindicalizado_Rurais dados_r, int ID) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("insert into propriedadeRural(nomeFazenda, logradouro, municipioCede, codigoINCRA, NIRF, "
                    + "areaPropriedade, tempoCompraPropriedade, outrasAtividade, "
                    + "residenciaAtual, excluidoP, id_sind) values (?,?,?,?,?,?,?,?,?,?,?)");

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

            JOptionPane.showMessageDialog(null, "Propriedade rural cadastrada com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar sindicalizado", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao cadastrar sindicalizado: " + e);
        }
    }

    public void alterar_Dados_R(Sindicalizado_Rurais dados_r) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("update propriedadeRural set nomeFazenda = ?, logradouro = ?, municipioCede = ?, codigoINCRA = ?, NIRF = ?, "
                    + "areaPropriedade = ?, tempoCompraPropriedade = ?, outrasAtividade = ?, "
                    + "residenciaAtual = ?, excluidoP = ? where id_propriedadeRural = ?");

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
            pst.setInt(11, dados_r.getId_proprie());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Os dados da propriedade rural foram alterados com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados da propriedade rural", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao alterar os dados da propriedade rural: " + e);
        }
    }

    public void restaurar_SIND(int id) {
        int a = 0;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update sindicalizado set excluidoS = ? where id_sindicalizado = ?");
            pst.setInt(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restautação do sindicalizado realizada com sucesso");
            restaurar_Muitas_Propri(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar sindicalizado");
            System.out.println(e);
        }
    }

    public void restaurar_Muitas_Propri(int id) {
        int a = 0;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update propriedadeRural set excluidoP = ? where id_sind = ?");
            pst.setInt(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restautação das propriedade rurais realizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar sindicalizado");
            System.out.println(e);
        }
    }

    public void restaurar_Uma_Propri(int id) {
        int a = 0;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update propriedadeRural set excluidoP = ? where id_propriedadeRural = ?");
            pst.setInt(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restautação da propriedade rural realizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar sindicalizado");
            System.out.println(e);
        }
    }

    public ArrayList<Sindicalizado_Rurais> listar_Tabela_RURAL(int id_sind) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Rurais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_propriedadeRural, nomeFazenda, logradouro, municipioCede, codigoINCRA, NIRF, areaPropriedade, tempoCompraPropriedade, outrasAtividade, residenciaAtual from propriedadeRural where excluidoP = '0' and id_sind = ?");
            pst.setInt(1, id_sind);
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Rurais si = new Sindicalizado_Rurais();

                si.setId_proprie(rs.getInt("id_propriedadeRural"));
                si.setNomeFazenda(rs.getString("nomeFazenda"));
                si.setLogradouro(rs.getString("logradouro"));
                si.setMuniciSede(rs.getString("municipioCede"));
                si.setCodINCRA(rs.getString("codigoINCRA"));
                si.setNIRF(rs.getString("NIRF"));
                si.setAreaPropri(rs.getString("areaPropriedade"));
                si.setTempoCompra(rs.getString("tempoCompraPropriedade"));
                si.setOutrasA(rs.getString("outrasAtividade"));
                si.setResidenciaAtual(rs.getString("residenciaAtual"));

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Rurais> listar_Tabela_RURAL_ADD(int id_sind, Sindicalizado_Rurais dr, boolean clico) {
        con = Conexao_banco.conector();
        Sindicalizado_View CS = new Sindicalizado_View();

        ArrayList<Sindicalizado_Rurais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_propriedadeRural, nomeFazenda, logradouro, municipioCede, codigoINCRA, NIRF, areaPropriedade, tempoCompraPropriedade, outrasAtividade, residenciaAtual from propriedadeRural where excluidoP = '0' and id_sind = ?");
            pst.setInt(1, id_sind);
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Rurais si = new Sindicalizado_Rurais();

                si.setId_proprie(rs.getInt("id_propriedadeRural"));
                si.setNomeFazenda(rs.getString("nomeFazenda"));
                si.setLogradouro(rs.getString("logradouro"));
                si.setMuniciSede(rs.getString("municipioCede"));
                si.setCodINCRA(rs.getString("codigoINCRA"));
                si.setNIRF(rs.getString("NIRF"));
                si.setAreaPropri(rs.getString("areaPropriedade"));
                si.setTempoCompra(rs.getString("tempoCompraPropriedade"));
                si.setOutrasA(rs.getString("outrasAtividade"));
                si.setResidenciaAtual(rs.getString("residenciaAtual"));

                SIND.add(si);
            }

            if (!clico) {
                SIND.add(dr);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return SIND;
    }

    public boolean excluirPropriedade(int id) {
        boolean ok = false;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update propriedadeRural set excluidoP = '1' where id_sind = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            ok = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir propriedade rural", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao excluir propriedade rural: " + e);
        }
        return ok;
    }

    public boolean excluir_1_Propriedade(int id) {
        boolean ok = false;
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("update propriedadeRural set excluidoP = '1' where id_propriedadeRural = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            ok = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir propriedade rural", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao excluir propriedade rural: " + e);
        }
        return ok;
    }

    public ArrayList<Sindicalizado_Rurais> lista_tabela_propri_res(int I, String no) {
        con = Conexao_banco.conector();
        int cont = 1;
        Restaurar_View res = new Restaurar_View();

        ArrayList<Sindicalizado_Rurais> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_propriedadeRural, nomeFazenda, municipioCede, NIRF, codigoINCRA from propriedadeRural where excluidoP = '1' and id_sind = ?");
            pst.setInt(1, I);
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Rurais si = new Sindicalizado_Rurais();
                cont++;

                si.setId_proprie(rs.getInt("id_propriedadeRural"));
                si.setNomeFazenda(rs.getString("nomeFazenda"));
                si.setMuniciSede(rs.getString("municipioCede"));
                si.setCodINCRA(rs.getString("codigoINCRA"));
                si.setNIRF(rs.getString("NIRF"));
                SIND.add(si);
            }

            if (cont == 1) {
                JOptionPane.showMessageDialog(null, "Não a propriedades rurais excluidas de " + no);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela de propriedades excluidas");
            System.out.println(e);
        }
        res.NULL = cont;
        return SIND;
    }

}
