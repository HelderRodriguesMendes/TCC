package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public abstract class Conversao {

    Controle_de_Caixa_ENTIDADES fc = new Controle_de_Caixa_ENTIDADES();

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
//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------

    public static String DATE_STRING(Date f) {
        String dat;
        SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
        dat = fo.format(f);
        return dat;
    }

    public static String verificar_Data(String data) {
        String dia, ano, mes;

        if (data.length() == 8) {
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
            data = dia + "/" + mes + "/" + ano;
        } else {
            String[] array = new String[10];
            for (int i = 0; i < 10; i++) {
                array[i] = "" + data.charAt(i);               
            }
            if ("-".equals(array[2]) && "-".equals(array[5])) {
                dia = array[0];
                dia += array[1];
                mes = array[3];
                mes += array[4];
                ano = array[6];
                ano += array[7];
                ano += array[8];
                ano += array[9];
                data = dia + "/" + mes + "/" + ano;
            } 
        }                
        return data;
    }
}
