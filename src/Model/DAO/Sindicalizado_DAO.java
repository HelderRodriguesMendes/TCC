/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidadades.Sindicalizado_Entidade;
import Model.Conexao_banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Sindicalizado_DAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void SALVAR(Sindicalizado_Entidade se) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareCall("insert into sindicalizado(nome, dataNasci, celular, nascionalidade, naturalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae, nomeFazenda, logradouro, municipioCede, codigoINCRA, tiraLeite, NIRF, areaPropriedade, tempoCompraPropriedade, outrasAtividade) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, se.getNome());
            java.sql.Date DATASQL = new java.sql.Date(se.getDataNasci().getTime());
            pst.setDate(2, DATASQL);
            pst.setString(3, se.getCelular());
            pst.setString(4, se.getNascionalidade());
            pst.setString(5, se.getNaturalidade());
            pst.setString(6, se.getEstadoCivil());
            pst.setString(7, se.getCpf());
            pst.setString(8, se.getRg());
            java.sql.Date DATA = new java.sql.Date(se.getDataExpedicao().getTime());
            pst.setDate(9, DATA);
            pst.setString(10, se.getTituloEleito());
            pst.setInt(11, se.getZona());
            pst.setInt(12, se.getSecao());
            pst.setString(13, se.getReservista());
            pst.setString(14, se.getCategoria());
            pst.setString(15, se.getPai());
            pst.setString(16, se.getMae());
            pst.setString(17, se.getNomeFazenda());
            pst.setString(18, se.getLogradouro());
            pst.setString(19, se.getMuniciSede());
            pst.setString(20, se.getCodINCRA());
            pst.setInt(21, se.getTiraLeite());
            pst.setString(22, se.getNIRF());
            pst.setString(23, se.getAreaPropri());
            pst.setString(24, se.getTempoCompra());
            pst.setString(25, se.getOutrasA());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            System.out.println(e);
        }
    }

}
