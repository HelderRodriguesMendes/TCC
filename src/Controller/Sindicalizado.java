package Controller;

import DAO.Dados_Sindicalizado_Pessoais_DAO;
import DAO.Dados_Sindicalizado_Rurais_DAO;
import Model.Dados_Pessoais;
import Model.Dados_Rurais;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author helde
 */
public class Sindicalizado {


    boolean z = false;
    public int ANO_Atual = 0, MES_Atual = 0, DIA_Atual = 0;
    Dados_Sindicalizado_Pessoais_DAO dsp = new Dados_Sindicalizado_Pessoais_DAO();
    Dados_Sindicalizado_Rurais_DAO dsr = new Dados_Sindicalizado_Rurais_DAO();

    public String validar_CPF(String CPF) {
        if ("000.000.000 - 00".equals(CPF)) {
            CPF = "";
        }
        return CPF;
    }

    public String verificar_CPF(String cpf, int id) {
        int ID = 0;
        String i = "";
        if (id > 0) {
            ID = id;
        }
        i = dsp.verificarCPF_BANCO(cpf, id);
        if (!"".equals(i) && !"nao cadastrado".equals(i) && !"tem dono".equals(i)) {
            id = Integer.parseInt(i);
            if (ID == id) {
                i = "mesmo dono";
            } else {
                i = "tem dono";
            }
        }
        return i;
    }

    public String validadar_Telefone(String tel) {
        if ("(00) 90000 - 0000".equals(tel)) {
            tel = "";
        }
        return tel;
    }

    public String validadar_RG(String rg) {
        if (rg.length() == 7) {
            if ("0000000".equals(rg)) {
                rg = "";
            }
        } else if (rg.length() > 7) {
            rg = "+7";
        } else {
            rg = "-7";
        }
        return rg;
    }

    public String verificar_RG(String rg, int id) {
        int ID = 0;
        String i = "";
        if (id > 0) {
            ID = id;
        }
        i = dsp.verificarRG_BANCO(rg, id);
        if (!"".equals(i) && !"nao cadastrado".equals(i) && !"tem dono".equals(i)) {
            id = Integer.parseInt(i);
            if (ID == id) {
                i = "mesmo dono";
            } else {
                i = "tem dono";
            }
        }
        return i;
    }

    public String validar_Titulo_Eleitor(String titulo) {
        if ("0000 0000 0000".equals(titulo)) {
            titulo = "";
        }
        return titulo;
    }

    public String validar_zona(String zona) {
        if ("000".equals(zona)) {
            zona = "";
        }
        return zona;
    }

    public String validar_secao(String secao) {
        if ("0000".equals(secao)) {
            secao = "invalida";
        }
        return secao;
    }

    public String validarReservista(String reser) {
        String RESER = null;
        if ("000000".equals(reser)) {
            RESER = "";
        }
        return RESER;
    }

    public String validaCodIncra(String codin) {
        if ("000.000.000.000-0".equals(codin)) {
            codin = "";
        }
        return codin;
    }

    public String verificar_INCRA(String incra, int id) {
        int ID = 0;
        String i = "";
      
        i = dsr.verificarINCRA_BANCO(incra, id);
        if (!"".equals(i) && !"nao cadastrado".equals(i) && !"tem dono".equals(i)) {
            System.out.println("helder");
            ID = Integer.parseInt(i);
            if (ID == id) {
                i = "mesmo dono";
            } else {
                i = "tem dono";
            }
        }
        return i;
    }

    public String validarNIRF(String NIRF) {
        if ("0.000.000-0".equals(NIRF)) {
            NIRF = "";
        }
        return NIRF;
    }

    public String verificar_NIRF(String NIRF, int id) {
        int ID = 0;
        String i = "";
        if (id > 0) {
            ID = id;
        }
        i = dsr.verificarNIRF_BANCO(NIRF, ID);
        if (!"".equals(i) && !"nao cadastrado".equals(i) && !"tem dono".equals(i)) {
            id = Integer.parseInt(i);
            if (ID == id) {
                i = "mesmo dono";
            } else {
                i = "tem dono";
            }
        }
        return i;
    }

    public int aniversario(Dados_Pessoais se, boolean ok) {
        int idade = 0;
        SimpleDateFormat ANO = new SimpleDateFormat("yyyy");
        SimpleDateFormat MES = new SimpleDateFormat("MM");
        SimpleDateFormat DIA = new SimpleDateFormat("dd");
        ANO_Atual = Integer.valueOf(ANO.format(new Date()));
        MES_Atual = Integer.valueOf(MES.format(new Date()));
        DIA_Atual = Integer.valueOf(DIA.format(new Date()));
        if (ok) {
            String nasc = Util.DATE_STRING(se.getDataNasci());
            String[] da = nasc.split("/");
            int ano = Integer.parseInt(da[2]);
            idade = ANO_Atual - ano;
        }
        return idade;
    }
}
