package Controller;

/**
 *
 * @author helde
 */
public class Sindicalizado {

    boolean z = false;

    public String verificar_CPF(String CPF) {
        if ("000.000.000 - 00".equals(CPF)) {
            CPF = "";
        }
        return CPF;
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
    
    public String validarNIRF(String NIRF){
        if("0.000.000-0".equals(NIRF)){
            NIRF = "";
        }
        return NIRF;
    }
}
