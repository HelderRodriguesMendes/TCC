package Controller;


import Controller.Entidades.Controle_de_Caixa_ENTIDADES;
import View.FluxoCaixa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helde_000
 */
public abstract class DATE {

    Controle_de_Caixa_ENTIDADES fc = new Controle_de_Caixa_ENTIDADES();

    private static String dia, ano, mes;
    public static int idade = 0;
    public static boolean ok;

    public static Date STRING_DATE(String dt) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date daS = null;
        try {
            daS = new java.util.Date(format.parse(dt).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FluxoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daS;
    }

    public static String DATE_STRING(Date f) {
        String dat;
        SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
        dat = fo.format(f);
        return dat;
    }

    public static String verificar_Data(String data, boolean niver) {
        System.out.println("DTA NASC: " + data);
        boolean ok;
        
        switch (data.length()) {
            //29101996
            case 8: {
                String[] array = new String[8];
                for (int i = 0; i < 8; i++) {
                    array[i] = "" + data.charAt(i);
                }
                dia = array[0];
                dia += array[1];
                System.out.println("DIAA: " + dia);
                mes = array[2];
                mes += array[3];
                ano = array[4];
                ano += array[5];
                ano += array[6];
                ano += array[7];
                
                System.out.println("dia: " + dia + " mes: " + mes + " ano: " + ano);
                ok = validar_Data(dia, mes, ano, niver);
                if(ok){
                    data = dia + "/" + mes + "/" + ano;
                }else{
                    data = "//";
                }
                break;
            }
            case 10: {
                String[] array = new String[10];
                for (int i = 0; i < 10; i++) {
                    array[i] = "" + data.charAt(i);
                }
                if (!"/".equals(array[2]) && !"/".equals(array[5])) {
                    dia = array[0];
                    dia += array[1];
                    mes = array[3];
                    mes += array[4];
                    ano = array[6];
                    ano += array[7];
                    ano += array[8];
                    ano += array[9];
                    
                    ok = validar_Data(dia, mes, ano, niver);
                    if(ok){
                        data = dia + "/" + mes + "/" + ano;
                    }else{
                        data = "//";
                    }
                }else{
                    dia = array[0];
                    dia += array[1];
                    mes = array[3];
                    mes += array[4];
                    ano = array[6];
                    ano += array[7];
                    ano += array[8];
                    ano += array[9];
                    ok = validar_Data(dia, mes, ano, niver);
                    if(ok){
                        data = dia + "/" + mes + "/" + ano;
                    }else{
                        data = "//";
                    }
                }
                break;
            }
            default:
                break;
        }
        if(data.length() == 9 ||data.length() < 8 || data.length() > 10){
            data = "//";
        }
        return data;
    }

        public static boolean validar_Data(String di, String me, String an, boolean niver) {
            int d, m, a;
            d = Integer.parseInt(di);
            m = Integer.parseInt(me);
            a = Integer.parseInt(an);
        System.out.println("RODRIGUES");
            
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int ANO_Atual = Integer.valueOf(sdf.format(new Date()));

        if(d > 31){
            ok = false;
        }else if(m > 12) {
            ok = false;
        }else{
            ok = a <= ANO_Atual;
        }
        
        if(ok){            
            if(niver){
                idade = ANO_Atual - a;
                System.out.println("IDADE: " + idade);
                System.out.println("ano atual: " + ANO_Atual);
                System.out.println("ano nascimento: " + a);
                if(idade < 18){
                    ok = false;
                }
            }
        }
            System.out.println("OK final: " + ok);
        return ok;
    }
}
