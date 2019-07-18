/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Sindicalizado;
import Model.Sindicalizado_Entidade;
import java.awt.Desktop;
import java.net.URI;
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
    public boolean sind = true, niver = true;

    public boolean SALVAR(Sindicalizado_Entidade se) {
        login = verificar_login(se);
        if (login) {
            con = Conexao_banco.conector();
            try {
                pst = con.prepareStatement("insert into sindicalizado(nome, dataNasci, celular, nascionalidade, "
                        + "estadoCivil, cpf, rg, dataExpedi, tituloEleito, zona, secao, reservista, categoria, "
                        + "pai, mae, nomeFazenda, logradouro, municipioCede, codigoINCRA, tiraLeite, NIRF, "
                        + "areaPropriedade, tempoCompraPropriedade, outrasAtividade, tipo_usuario, login, senha, "
                        + "residenciaAtual, excluido) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
                pst.setInt(29, se.getExcluido());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O login desejado ja existe no sistema", "Atenção", JOptionPane.INFORMATION_MESSAGE);
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
        con = Conexao_banco.conector();

        ArrayList<Sindicalizado_Entidade> SIND = new ArrayList<>();

        try {
            if (!"".equals(nome) && !"".equals(cpf)) {
                if (!"".equals(rg)) {
                    pst = con.prepareStatement("select * from sindicalizado where nome like ? and cpf like ? and rg like ? and excluido = '0'");
                    pst.setString(1, "%" + nome + "%");
                    pst.setString(2, "%" + cpf + "%");
                    pst.setString(3, "%" + rg + "%");
                    rs = pst.executeQuery();
                } else {
                    pst = con.prepareStatement("select * from sindicalizado where nome like ? and cpf like ?");
                    pst.setString(1, "%" + nome + "%");
                    pst.setString(2, "%" + cpf + "%");
                    rs = pst.executeQuery();
                }
            } else if (!"".equals(nome) && !"".equals(rg)) {
                pst = con.prepareStatement("select * from sindicalizado where nome like ? and rg like ?");
                pst.setString(1, "%" + nome + "%");
                pst.setString(2, "%" + rg + "%");
                rs = pst.executeQuery();
            } else if (!"".equals(rg) && !"".equals(cpf)) {
                pst = con.prepareStatement("select * from sindicalizado where cpf like ? and rg like ?");
                pst.setString(1, "%" + cpf + "%");
                pst.setString(2, "%" + rg + "%");
                rs = pst.executeQuery();
            } else if (!"".equals(nome)) {
                System.out.println("nome aqui: " + nome);
                pst = con.prepareStatement("select * from sindicalizado where nome like ?");
                pst.setString(1, "%" + nome + "%");
                rs = pst.executeQuery();
            } else if (!"".equals(cpf)) {
                pst = con.prepareStatement("select * from sindicalizado where cpf like ?");
                pst.setString(1, "%" + cpf + "%");
                rs = pst.executeQuery();
            } else {
                pst = con.prepareStatement("select * from sindicalizado where rg like ? ");
                pst.setString(1, "%" + rg + "%");
                rs = pst.executeQuery();
            }

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Dados não encontrados no sistema", "Atençãoo", JOptionPane.ERROR_MESSAGE);
                sind = false;
            }

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

    public boolean alterar_sind(Sindicalizado_Entidade se, int ID) {
        login = verificar_login(se);

        if (login) {
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
                    pst.setString(26, se.getResidenciaAtual());
                    pst.setInt(27, se.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
                    System.out.println(e);
                }
            } else {
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
                    pst.setString(28, se.getResidenciaAtual());
                    pst.setInt(29, se.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
                    System.out.println(e);
                }
            }
        } else if (this.id == ID) {
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
                    pst.setString(26, se.getResidenciaAtual());
                    pst.setInt(27, se.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    con.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
                    System.out.println(e);
                }
            } else {
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
                    pst.setString(28, se.getResidenciaAtual());
                    pst.setInt(29, se.getId());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    login = true;
                    con.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados sindicalizado");
                    System.out.println(e);
                }
            }
            login = true;
        } else {
            JOptionPane.showMessageDialog(null, "O login desejado ja existe no sistema", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        return login;
    }

    public boolean verificar_login(Sindicalizado_Entidade se) {
        con = Conexao_banco.conector();
        boolean lo = true;
        try {
            pst = con.prepareStatement("select login, id_sindicalizado from sindicalizado where login = ?");
            pst.setString(1, se.getLogin());
            rs = pst.executeQuery();

            if (rs.next()) {
                lo = false;
                this.id = rs.getInt("id_sindicalizado");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return lo;
    }

    public void niver() {
        con = Conexao_banco.conector();
        Sindicalizado_Entidade se = new Sindicalizado_Entidade();

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
                if("(  ) 9     -     ".equals(se.getCelular())){
                    se.setCelular("");
                }
                JOptionPane.showMessageDialog(null, "Os sindicalizados aniversariantes de hoje são:" + "\n" + se.getNome() + "\n" + "Telefone: " + se.getCelular() + "\n" + "Idade: " + idade);
                niver = false;
            }
        } catch (Exception e) {
        }
    }
    
    public void Acessar_Facebook(){
        try {
            URI link = new URI("https://www.facebook.com/Sindicato-Rural-de-Aren%C3%B3polis-395277340679811/");
            Desktop.getDesktop().browse(link);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
