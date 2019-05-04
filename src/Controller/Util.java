package Controller;

import Controller.Entidades.Controle_de_Caixa_ENTIDADES;
import View.FluxoCaixa;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author helde_000
 */
public abstract class Util {

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
                mes = array[2];
                mes += array[3];
                ano = array[4];
                ano += array[5];
                ano += array[6];
                ano += array[7];

                ok = validar_Data(dia, mes, ano, niver);
                if (ok) {
                    data = dia + "/" + mes + "/" + ano;
                } else {
                    data = "//";
                }
                break;
            }
            case 10: {  //  29/10/1996
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
                    if (ok) {
                        data = dia + "/" + mes + "/" + ano;
                    } else {
                        data = "//";
                    }
                } else {
                    dia = array[0];
                    dia += array[1];
                    mes = array[3];
                    mes += array[4];
                    ano = array[6];
                    ano += array[7];
                    ano += array[8];
                    ano += array[9];
                    ok = validar_Data(dia, mes, ano, niver);
                    if (ok) {
                        data = dia + "/" + mes + "/" + ano;
                    } else {
                        data = "//";
                    }
                }
                break;
            }
            default:
                break;
        }
        if (data.length() == 9 || data.length() < 8 || data.length() > 10) {
            data = "//";
        }
        return data;
    }

    public static boolean validar_Data(String di, String me, String an, boolean niver) {
        int d, m, a;
        d = Integer.parseInt(di);
        m = Integer.parseInt(me);
        a = Integer.parseInt(an);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int ANO_Atual = Integer.valueOf(sdf.format(new Date()));

        if (d > 31 || d == 0 || d == 00) {
            ok = false;
        } else if (m > 12 || m == 0 || m == 00) {
            ok = false;
        } else {
            ok = a <= ANO_Atual && a != 0 && a != 00;
        }

        if (ok) {
            if (niver) {
                idade = ANO_Atual - a;

                if (idade < 18) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void soLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){   // evento de teclas pressionadas no teclado
               char c = e.getKeyChar();         // captura a letra ou o numero digitado
               if(Character.isDigit(c)){        // verifica si o que foi digitado é numeros
                   e.consume();                 // não permite digitar numeros
               }
            }
        });
    }
    
    public static void soNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){   // evento de teclas pressionadas no teclado
               char c = e.getKeyChar();         // captura a letra ou o numero digitado
               if(!Character.isDigit(c)){        // verifica si o que foi digitado é letras
                   e.consume();                 // não permite digitar letras
               }
            }
        });
    }
}
