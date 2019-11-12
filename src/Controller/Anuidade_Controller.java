/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Anuidade_DAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author helde
 */
public class Anuidade_Controller {

    Anuidade_DAO UD = new Anuidade_DAO();

    public static String converteMuedaBR(double valor) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String va = currencyFormatter.format(valor);
        return va;
    }

    public boolean ultima_Anuidade_Recebida(int anoEscolhido) {
        System.out.println("passo 2");
        boolean ok = true;
        int ano, cont = 0;
        ArrayList<Integer> ANO = UD.verificarAnuidadesGeradas();
        
        for(int i = 0; i < ANO.size(); i++){
            ano = (int) ANO.get(i);
            System.out.println("ANO DO BANCO: " + ano);
            if(anoEscolhido == ano){
                cont++;
            }
        }
        if(cont > 0){
            ok = false;
        }
        
        return ok;
    }
}
