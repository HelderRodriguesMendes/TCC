/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexao_banco;
import Model.Entidadades.Sindicalizado_Entidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sindicalizado_DAO {

    Conexao_banco cb = new Conexao_banco();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;

    public void SALVAR(Sindicalizado_Entidade se) {
        con = Conexao_banco.conector();

        try {
            pst = con.prepareStatement("insert into sindicalizado(nome, dataNasci, celular, nascionalidade, estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, pai, mae, nomeFazenda, logradouro, municipioCede, codigoINCRA, tiraLeite, NIRF, areaPropriedade, tempoCompraPropriedade, outrasAtividade, tipo_usuario, login, senha, residenciaAtual) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, se.getNome());
            java.sql.Date DATASQL = new java.sql.Date(se.getDataNasci().getTime());
            pst.setDate(2, DATASQL);
            pst.setString(3, se.getCelular());
            pst.setString(4, se.getNascionalidade());
            pst.setString(5, se.getEstadoCivil());
            pst.setString(6, se.getCpf());
            pst.setString(7, se.getRg());
            java.sql.Date DATA = new java.sql.Date(se.getDataExpedicao().getTime());
            pst.setDate(8, DATA);
            pst.setString(9, se.getTituloEleito());
            pst.setInt(10, se.getZona());
            pst.setInt(11, se.getSecao());
            pst.setString(12, se.getReservista());
            pst.setString(13, se.getCategoria());
            pst.setString(14, se.getPai());
            pst.setString(15, se.getMae());
            pst.setString(16, se.getNomeFazenda());
            pst.setString(17, se.getLogradouro());
            pst.setString(18, se.getMuniciSede());
            pst.setString(19, se.getCodINCRA());
            pst.setString(20, se.getTiraLeite());
            pst.setString(21, se.getNIRF());
            pst.setString(22, se.getAreaPropri());
            pst.setString(23, se.getTempoCompra());
            pst.setString(24, se.getOutrasA());
            pst.setString(25, se.getTipo_usuario());
            pst.setString(26, se.getLogin());
            pst.setString(27, se.getSenha());
            pst.setString(28, se.getResidenciaAtual());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            System.out.println(e);
        }
    }

    public ArrayList<Sindicalizado_Entidade> listar_Tabela() {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado");
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Entidade si = new Sindicalizado_Entidade();

                si.setId(rs.getInt("id_sindicalizado"));
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
                si.setNomeFazenda(rs.getString("nomeFazenda"));
                si.setLogradouro(rs.getString("logradouro"));
                si.setMuniciSede(rs.getString("municipioCede"));
                si.setCodINCRA(rs.getString("codigoINCRA"));
                si.setTiraLeite(rs.getString("tiraLeite"));
                si.setNIRF(rs.getString("NIRF"));
                si.setAreaPropri(rs.getString("areaPropriedade"));
                si.setTempoCompra(rs.getString("tempoCompraPropriedade"));
                si.setOutrasA(rs.getString("outrasAtividade"));
                si.setResidenciaAtual(rs.getString("residenciaAtual"));
                si.setLogin(rs.getString("login"));

                SIND.add(si);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_Sind(String nome, String cpf, String rg) {
        System.out.println("RG: " + rg);
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where nome like ? and cpf like ? and rg like ?");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + cpf + "%");
            pst.setString(3, "%" + rg + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Entidade si = new Sindicalizado_Entidade();

                si.setId(rs.getInt("id_sindicalizado"));
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
                si.setNomeFazenda(rs.getString("nomeFazenda"));
                si.setLogradouro(rs.getString("logradouro"));
                si.setMuniciSede(rs.getString("municipioCede"));
                si.setCodINCRA(rs.getString("codigoINCRA"));
                si.setTiraLeite(rs.getString("tiraLeite"));
                si.setNIRF(rs.getString("NIRF"));
                si.setAreaPropri(rs.getString("areaPropriedade"));
                si.setTempoCompra(rs.getString("tempoCompraPropriedade"));
                si.setOutrasA(rs.getString("outrasAtividade"));
                si.setResidenciaAtual(rs.getString("residenciaAtual"));
                si.setLogin(rs.getString("login"));

                SIND.add(si);
            }
            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Sindicalizado não encontrado", "Informação", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public void alterar_sind(Sindicalizado_Entidade se) {
        con = Conexao_banco.conector();
        if ("".equals(se.getSenha())) {
            try {
                pst = con.prepareStatement("update sindicalizado set nome = ?, dataNasci = ?, celular = ?, nascionalidade = ?, estadoCivil = ?, cpf = ?, rg = ?, dataExpedi = ?, tituloEleito = ?, zona = ?, secao = ?, reservista = ?, categoria = ?, pai = ?, mae = ?, nomeFazenda = ?, logradouro = ?, municipioCede = ?, codigoINCRA = ?, tiraLeite = ?, NIRF = ?, areaPropriedade = ?, tempoCompraPropriedade = ?, outrasAtividade = ?, login = ?, residenciaAtual = ? where id_sindicalizado = ?");
                pst.setString(1, se.getNome());
                java.sql.Date DATASQL = new java.sql.Date(se.getDataNasci().getTime());
                pst.setDate(2, DATASQL);
                pst.setString(3, se.getCelular());
                pst.setString(4, se.getNascionalidade());
                pst.setString(5, se.getEstadoCivil());
                pst.setString(6, se.getCpf());
                pst.setString(7, se.getRg());
                java.sql.Date DATA = new java.sql.Date(se.getDataExpedicao().getTime());
                pst.setDate(8, DATA);
                pst.setString(9, se.getTituloEleito());
                pst.setInt(10, se.getZona());
                pst.setInt(11, se.getSecao());
                pst.setString(12, se.getReservista());
                pst.setString(13, se.getCategoria());
                pst.setString(14, se.getPai());
                pst.setString(15, se.getMae());
                pst.setString(16, se.getNomeFazenda());
                pst.setString(17, se.getLogradouro());
                pst.setString(18, se.getMuniciSede());
                pst.setString(19, se.getCodINCRA());
                pst.setString(20, se.getTiraLeite());
                pst.setString(21, se.getNIRF());
                pst.setString(22, se.getAreaPropri());
                pst.setString(23, se.getTempoCompra());
                pst.setString(24, se.getOutrasA());
                pst.setString(25, se.getLogin());
                pst.setInt(26, se.getId());
                pst.setString(27, se.getResidenciaAtual());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
                System.out.println(e);
            }
        }else{
            try {
            pst = con.prepareStatement("update sindicalizado set nome = ?, dataNasci = ?, celular = ?, nascionalidade = ?, estadoCivil = ?, cpf = ?, rg = ?, dataExpedi = ?, tituloEleito = ?, zona = ?, secao = ?, reservista = ?, categoria = ?, pai = ?, mae = ?, nomeFazenda = ?, logradouro = ?, municipioCede = ?, codigoINCRA = ?, tiraLeite = ?, NIRF = ?, areaPropriedade = ?, tempoCompraPropriedade = ?, outrasAtividade = ?, tipo_usuario = ?, login = ?, senha = ?, residenciaAtual = ? where id_sindicalizado = ?");
            pst.setString(1, se.getNome());
            java.sql.Date DATASQL = new java.sql.Date(se.getDataNasci().getTime());
            pst.setDate(2, DATASQL);
            pst.setString(3, se.getCelular());
            pst.setString(4, se.getNascionalidade());
            pst.setString(5, se.getEstadoCivil());
            pst.setString(6, se.getCpf());
            pst.setString(7, se.getRg());
            java.sql.Date DATA = new java.sql.Date(se.getDataExpedicao().getTime());
            pst.setDate(8, DATA);
            pst.setString(9, se.getTituloEleito());
            pst.setInt(10, se.getZona());
            pst.setInt(11, se.getSecao());
            pst.setString(12, se.getReservista());
            pst.setString(13, se.getCategoria());
            pst.setString(14, se.getPai());
            pst.setString(15, se.getMae());
            pst.setString(16, se.getNomeFazenda());
            pst.setString(17, se.getLogradouro());
            pst.setString(18, se.getMuniciSede());
            pst.setString(19, se.getCodINCRA());
            pst.setString(20, se.getTiraLeite());
            pst.setString(21, se.getNIRF());
            pst.setString(22, se.getAreaPropri());
            pst.setString(23, se.getTempoCompra());
            pst.setString(24, se.getOutrasA());
            pst.setString(25, se.getTipo_usuario());
            pst.setString(26, se.getLogin());
            pst.setString(27, se.getSenha());
            pst.setInt(28, se.getId());
            pst.setString(29, se.getResidenciaAtual());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
            System.out.println(e);
        }
        }
    }

}
