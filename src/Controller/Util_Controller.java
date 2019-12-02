package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author helde_000
 */
public abstract class Util_Controller {

    private static String dia, ano, mes;
    public static int idade = 0;
    public static boolean ok;

    public static Date STRING_DATE(String dt) {
        System.out.println("daata: " + dt);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date daS = null;
        try {
            daS = new java.util.Date(format.parse(dt).getTime());
        } catch (ParseException ex) {

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
        String[] da = data.split("/");
        dia = da[0];
        mes = da[1];
        ano = da[2];

        ok = validar_Data(dia, mes, ano, niver);
        if (ok) {
            data = dia + "/" + mes + "/" + ano;
        } else {
            data = "//";
        }
        return data;
    }

    public static boolean validar_Data(String di, String me, String an, boolean niver) {
        int d, m, a;
        d = Integer.parseInt(di);
        m = Integer.parseInt(me);
        a = Integer.parseInt(an);

        SimpleDateFormat ANO = new SimpleDateFormat("yyyy");
        SimpleDateFormat MES = new SimpleDateFormat("MM");
        SimpleDateFormat DIA = new SimpleDateFormat("dd");
        int ANO_Atual = Integer.valueOf(ANO.format(new Date()));
        int MES_Atual = Integer.valueOf(MES.format(new Date()));
        int DIA_Atual = Integer.valueOf(DIA.format(new Date()));

        if (a > ANO_Atual) {
            ok = false;
        } else if (a == ANO_Atual) {
            if (m == MES_Atual) {
                ok = d <= DIA_Atual;
            } else {
                ok = m < MES_Atual;
            }
        } else {
            ok = true;
        }

        if (ok && niver) {
            ok = IDADE(a);
        }
        return ok;
    }

    public static boolean IDADE(int ANO) {
        SimpleDateFormat ANOO = new SimpleDateFormat("yyyy");
        int ANO_Atual = Integer.valueOf(ANOO.format(new Date()));

         idade = ANO_Atual - ANO;

        ok = idade >= 18;
        return ok;
    }

    public static void soLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {   // evento de teclas pressionadas no teclado
                char c = e.getKeyChar();         // captura a letra ou o numero digitado
                if (Character.isDigit(c)) {        // verifica si o que foi digitado é numeros
                    e.consume();                 // não permite digitar numeros
                }
            }
        });
    }

    public static void soNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {   // evento de teclas pressionadas no teclado
                char c = e.getKeyChar();         // captura a letra ou o numero digitado
                if (!Character.isDigit(c)) {        // verifica si o que foi digitado é letras
                    e.consume();                 // não permite digitar letras
                }
            }
        });
    }
    
    public static int selectNull( int id){
        if(id == 0 || id < 0){
            JOptionPane.showMessageDialog(null, "Dados não encontrados");
            id = 0;
        }
        return id;
    }   
    
    public static String converteMuedaBR(double valor) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String va = currencyFormatter.format(valor);
        return va;
    }
}
