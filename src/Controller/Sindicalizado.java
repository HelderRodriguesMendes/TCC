package Controller;

/**
 *
 * @author helde
 */
public class Sindicalizado {

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
                if ("000.000.000-00".equals(CPF)) {
                    CPF = "..- ok";
                }
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
                    if ("000.000.000-00".equals(CPF)) {
                        CPF = "..- ok";
                    }
                }
                break;
            }
            default:
                CPF = "..- ok2";
                break;
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
                if ("(00) 00000 - 0000".equals(TELEFONE)) {
                    TELEFONE = "";
                }
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
                    if ("(00) 00000 - 0000".equals(TELEFONE)) {
                        TELEFONE = "";
                    }
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
                    if ("(00) 00000 - 0000".equals(TELEFONE)) {
                        TELEFONE = "";
                    }
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
                } else {
                    TELEFONE = "";
                }
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
        } else if(rg.length() > 7){
            RG = "+7";             
        }else{
            RG = "-7";
        }
        return RG;
    }
}
