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
public class Conversao {
    Controle_de_Caixa_ENTIDADES fc = new Controle_de_Caixa_ENTIDADES();
    public Date STRING_DATE(String dt){
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
    public String DATE_STRING(Date f){
        String dat;
        SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
        dat = fo.format(f);
        return dat;
    }
//-------------------------------------------------------------------------------------------------------    
//-------------------------------------------------------------------------------------------------------    
    public String INVERTE_DATA(String dat){ //inverte a data de dia, mes e ano, para ano, mes e dia
        String [] DAT;
        String DATA, ano, mes, dia;

        DAT = dat.split("/");
        dia = String.valueOf(DAT[0]);
        mes = String.valueOf(DAT[1]);
        ano = String.valueOf(DAT[2]);
        
        DATA = ano + "-" + mes + "-" + dia;
        
        return DATA;
    }
        
}
