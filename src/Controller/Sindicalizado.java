package Controller;

/**
 *
 * @author helde
 */
public class Sindicalizado {

    boolean z = false;

    public String verificar_CPF(String CPF, int id) {
        boolean ok;
        String a, b, c, d;

        switch (CPF.length()) {
            case 11: {
                String[] array = new String[11];
                for (int i = 0; i < 11; i++) {
                    array[i] = "" + CPF.charAt(i);
                }

                a = array[0];
                a += array[1];
                a += array[2];

                b = array[3];
                b += array[4];
                b += array[5];

                c = array[6];
                c += array[7];
                c += array[8];

                d = array[9];
                d += array[10];

                CPF = a + "." + b + "." + c + "-" + d;
                z = true;
                break;
            }
            case 14: {
                String[] array = new String[14];
                for (int i = 0; i < 14; i++) {
                    array[i] = "" + CPF.charAt(i);
                }
                if (!".".equals(array[3]) || !".".equals(array[7]) || !"-".equals(array[11])) {

                    a = array[0];
                    a += array[1];
                    a += array[2];

                    b = array[4];
                    b += array[5];
                    b += array[6];

                    c = array[8];
                    c += array[9];
                    c += array[10];

                    d = array[12];
                    d += array[13];

                    CPF = a + "." + b + "." + c + "-" + d;
                    z = true;
                }
                break;
            }
            default:
                CPF = "..- ok2";
                break;
        }
        if (z) {
            if ("000.000.000-00".equals(CPF)) {
                CPF = "..- ok";
            }
        }
        return CPF;
    }

    public String validadar_Telefone(String tel) {
        String TELEFONE = "";

        switch (tel.length()) {
            case 11: {
                //64981235651
                String[] array = new String[11];
                for (int i = 0; i < 11; i++) {
                    array[i] = "" + tel.charAt(i);
                }
                TELEFONE = "(";
                TELEFONE += array[0];
                TELEFONE += array[1];
                TELEFONE += ")";
                TELEFONE += " ";
                TELEFONE += array[2];
                TELEFONE += array[3];
                TELEFONE += array[4];
                TELEFONE += array[5];
                TELEFONE += array[6];
                TELEFONE += " ";
                TELEFONE += "-";
                TELEFONE += " ";
                TELEFONE += array[7];
                TELEFONE += array[8];
                TELEFONE += array[9];
                TELEFONE += array[10];
                z = true;
                break;
            }
            case 9: {
                TELEFONE = "falto DD";
                break;
            }
            case 13: {
                //64 98123-5651
                String[] array = new String[13];
                for (int i = 0; i < 13; i++) {
                    array[i] = "" + tel.charAt(i);
                }
                if (" ".equals(array[2]) && "-".equals(array[8])) {
                    TELEFONE = "(";
                    TELEFONE += array[0];
                    TELEFONE += array[1];
                    TELEFONE += ")";
                    TELEFONE += array[2];
                    TELEFONE += array[3];
                    TELEFONE += array[4];
                    TELEFONE += array[5];
                    TELEFONE += array[6];
                    TELEFONE += array[7];
                    TELEFONE += " ";
                    TELEFONE += array[8];
                    TELEFONE += " ";
                    TELEFONE += array[9];
                    TELEFONE += array[10];
                    TELEFONE += array[11];
                    TELEFONE += array[12];
                    z = true;
                } else {
                    TELEFONE = "";
                }
                break;
            }
            case 12: {
                //64 981235651
                String[] array = new String[12];
                for (int i = 0; i < 12; i++) {
                    array[i] = "" + tel.charAt(i);
                }
                if (" ".equals(array[2])) {
                    TELEFONE = "(";
                    TELEFONE += array[0];
                    TELEFONE += array[1];
                    TELEFONE += ")";
                    TELEFONE += array[2];
                    TELEFONE += array[3];
                    TELEFONE += array[4];
                    TELEFONE += array[5];
                    TELEFONE += array[6];
                    TELEFONE += array[7];
                    TELEFONE += " ";
                    TELEFONE += "-";
                    TELEFONE += " ";
                    TELEFONE += array[8];
                    TELEFONE += array[9];
                    TELEFONE += array[10];
                    TELEFONE += array[11];
                    z = true;
                } else {
                    TELEFONE = "";
                }
                break;
            }
            case 17: {     //(64) 98123 - 5651
                String[] array = new String[17];
                for (int i = 0; i < 17; i++) {
                    array[i] = "" + tel.charAt(i);
                }
                TELEFONE = array[0];
                TELEFONE += array[1];
                TELEFONE += array[2];
                TELEFONE += array[3];
                TELEFONE += array[4];
                TELEFONE += array[5];
                TELEFONE += array[6];
                TELEFONE += array[7];
                TELEFONE += array[8];
                TELEFONE += array[9];
                TELEFONE += array[10];
                TELEFONE += array[11];
                TELEFONE += array[12];
                TELEFONE += array[13];
                TELEFONE += array[14];
                TELEFONE += array[15];
                TELEFONE += array[16];
                z = true;
            }
            case 14: {     //(64) 981235651
                String[] array = new String[14];
                for (int i = 0; i < 14; i++) {
                    array[i] = "" + tel.charAt(i);
                }
                if ("(".equals(array[0]) && ")".equals(array[3]) && " ".equals(array[4])) {
                    TELEFONE = array[0];
                    TELEFONE += array[1];
                    TELEFONE += array[2];
                    TELEFONE += array[3];
                    TELEFONE += array[4];
                    TELEFONE += array[5];
                    TELEFONE += array[6];
                    TELEFONE += array[7];
                    TELEFONE += array[8];
                    TELEFONE += array[9];
                    TELEFONE += " ";
                    TELEFONE += "-";
                    TELEFONE += " ";
                    TELEFONE += array[10];
                    TELEFONE += array[11];
                    TELEFONE += array[12];
                    TELEFONE += array[13];
                    z = true;
                } else {
                    TELEFONE = "";
                }
            }
        }
        if (z) {
            if ("(00) 00000 - 0000".equals(TELEFONE)) {
                TELEFONE = "";
            }
        }
        return TELEFONE;
    }

    public String validadar_RG(String rg) {
        String RG = "";
        if (rg.length() == 7) {
            if (!"0000000".equals(rg)) {
                RG = rg;
            }
        } else if (rg.length() > 7) {
            RG = "+7";
        } else {
            RG = "-7";
        }
        return RG;
    }

    public String validar_Titulo_Eleitor(String titulo) {
        //1234 1234 1234
        String TITULO = "";
        if (titulo.length() == 14) {
            String[] array = new String[14];
            for (int i = 0; i < 14; i++) {
                array[i] = "" + titulo.charAt(i);
            }
            if (" ".equals(array[4]) && " ".equals(array[9])) {
                TITULO = array[0];
                TITULO += array[1];
                TITULO += array[2];
                TITULO += array[3];
                TITULO += " ";
                TITULO += array[5];
                TITULO += array[6];
                TITULO += array[7];
                TITULO += array[8];
                TITULO += " ";
                TITULO += array[10];
                TITULO += array[11];
                TITULO += array[12];
                TITULO += array[13];
                z = true;

            }
        } else if (titulo.length() == 12) {
            //123412341234
            String[] array = new String[12];
            for (int i = 0; i < 12; i++) {
                array[i] = "" + titulo.charAt(i);
            }
            TITULO = array[0];
            TITULO += array[1];
            TITULO += array[2];
            TITULO += array[3];
            TITULO += " ";
            TITULO += array[4];
            TITULO += array[5];
            TITULO += array[6];
            TITULO += array[7];
            TITULO += " ";
            TITULO += array[8];
            TITULO += array[9];
            TITULO += array[10];
            TITULO += array[11];
            z = true;
        }
        if (z) {
            if ("0000 0000 0000".equals(TITULO)) {
                TITULO = "";
            }
        }
        return TITULO;
    }
    
    public String validar_zona(String zona){
        String ZONA = "";
           if(zona.length() == 3){
               z = true;
               ZONA = zona;
           }
           if(z){
               if("000".equals(ZONA)){
                   ZONA = "invalida";
               }
           }
        return ZONA;
    }
    public String validar_secao(String secao){
        String SECAO = "";
           if(secao.length() == 4){
               z = true;
               SECAO = secao;
           }
           if(z){
               if("0000".equals(SECAO)){
                   SECAO = "invalida";
               }
           }
        return SECAO;
    }
    public String validarReservista(String reser){
        String RESER = "";
        if(reser.length() == 6){
            RESER = reser;
            z = true;
        }else{
            RESER = "6n";
        }
        if(z){
            if("000000".equals(RESER)){
                RESER = "";
            }
        }
        return RESER;
    }
}
