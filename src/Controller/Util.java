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
        int d, m, a, cont = 0;
        d = Integer.parseInt(di);
        m = Integer.parseInt(me);
        a = Integer.parseInt(an);

        SimpleDateFormat ANO = new SimpleDateFormat("yyyy");
        SimpleDateFormat MES = new SimpleDateFormat("MM");
        SimpleDateFormat DIA = new SimpleDateFormat("dd");
        int ANO_Atual = Integer.valueOf(ANO.format(new Date()));
        int MES_Atual = Integer.valueOf(MES.format(new Date()));
        int DIA_Atual = Integer.valueOf(DIA.format(new Date()));
        
        
        if(d == 0 || d == 00){
            ok = false;
        }else if(m == 0 || m == 00){
            ok = false;
        }else if(a == 0 || a == 00){
            ok = false;
        }else if(a > ANO_Atual){
            ok = false;
        }else if(a == ANO_Atual){
            if(d > DIA_Atual || m > MES_Atual){
                ok = false;
            }
        }else{
            ok = true;
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
}
