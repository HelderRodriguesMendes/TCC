/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Carmen
 */
public class Dados_Sindicalizado_Rurais_DAO {
    
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
                }else{
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

        if (id > 0) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("select id_sind from propriedadeRural where codigoINCRA = ?");
                pst.setString(1, incra);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int i = rs.getInt("id_sind");                
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
}
