/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Sindicalizado;
import Model.Sindicalizado_Entidade;
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
    boolean login = true;
    int id = 0, dia = 0, mes = 0;
    public boolean niver = true;

    Sindicalizado_Entidade se = new Sindicalizado_Entidade();

    public boolean SALVAR(Sindicalizado_Entidade se) {
        con = Conexao_banco.conector();
        try {
            System.out.println("aqui 1");
            pst = con.prepareStatement("insert into sindicalizado(nome, dataNasci, celular, nascionalidade, "
                    + "estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, "
                    + "pai, mae, nomeFazenda, logradouro, municipioCede, codigoINCRA, tiraLeite, NIRF, "
                    + "areaPropriedade, tempoCompraPropriedade, outrasAtividade, "
                    + "residenciaAtual, excluido) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("aqui 2");
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
            pst.setString(25, se.getResidenciaAtual());
            pst.setInt(26, se.getExcluido());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            System.out.println(e);
        }
        return login;
    }

    public ArrayList<Sindicalizado_Entidade> listar_Tabela() {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0'");
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

                SIND.add(si);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados na tabela");
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_nome(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Sindicalizado_Entidade si = new Sindicalizado_Entidade();

                si.setId(rs.getInt("id_sindicalizado"));
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_cpf(String cpf) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and cpf like ?");
            pst.setString(1, "%" + cpf + "%");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_nome_cpf_rg(String nome, String cpf, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and nome like ? and cpf like ? and rg like ?");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_nome_cpf(String nome, String cpf) {
        System.out.println("aqii");
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and nome like ? and cpf like ?");
            System.out.println("helde");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + cpf + "%");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_nome_rg(String nome, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and nome like ? and rg like ?");
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + rg + "%");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_cpf_rg(String cpf, String rg) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and cpf like ? and rg like ?");
            pst.setString(1, "%" + cpf + "%");
            pst.setString(2, "%" + rg + "%");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_rg(String rg) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from sindicalizado where excluido = '0' and rg like ?");
            pst.setString(1, "%" + rg + "%");
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

                SIND.add(si);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao listar dados na tabela", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return SIND;
    }

    public void alterar_sind(Sindicalizado_Entidade se, int id) {
        con = Conexao_banco.conector();
        try {
            pst = con.prepareStatement("update sindicalizado set nome = ?, dataNasci = ?, celular = ?, nascionalidade = ?, estadoCivil = ?, cpf = ?, rg = ?, dataExpedi = ?, tituloEleito = ?, zona = ?, secao = ?, reservista = ?, categoria = ?, pai = ?, mae = ?, nomeFazenda = ?, logradouro = ?, municipioCede = ?, codigoINCRA = ?, tiraLeite = ?, NIRF = ?, areaPropriedade = ?, tempoCompraPropriedade = ?, outrasAtividade = ?, residenciaAtual = ? where id_sindicalizado = ?");
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
            pst.setString(25, se.getResidenciaAtual());
            pst.setInt(26, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
            System.out.println(e);
        }
    }

    public void niver() {
        con = Conexao_banco.conector();
        Sindicalizado si = new Sindicalizado();
        si.aniversario(se, false);
        dia = si.DIA_Atual;
        mes = si.MES_Atual;
        try {
            pst = con.prepareStatement("select nome, dataNasci, celular from  sindicalizado where day(dataNasci) = ? and month(dataNasci) = ?");
            pst.setInt(1, dia);
            pst.setInt(2, mes);
            rs = pst.executeQuery();

            while (rs.next()) {
                se.setNome(rs.getString("nome"));
                java.util.Date DATA_U = rs.getDate("dataNasci");
                se.setDataNasci(DATA_U);
                se.setCelular(rs.getString("celular"));
                int idade = si.aniversario(se, true);
                if ("(  ) 9     -     ".equals(se.getCelular())) {
                    se.setCelular("");
                }
                JOptionPane.showMessageDialog(null, "Os sindicalizados aniversariantes de hoje são:" + "\n" + se.getNome() + "\n" + "Telefone: " + se.getCelular() + "\n" + "Idade: " + idade);
                niver = false;
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<Sindicalizado_Entidade> pesquisar_restaurar(String nome) {
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            pst = con.prepareStatement("select id_sindicalizado, nome, celular, rg, cpf from sindicalizado where excluido = '1'  and nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Sindicalizado_Entidade si = new Sindicalizado_Entidade();
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
