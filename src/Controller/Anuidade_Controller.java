/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Anuidade_DAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public boolean ultima_Anuidade_Recebida() {
        System.out.println("aqui 1");
        ArrayList<Integer> ANO = UD.ultimoAnoRecebido();

        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int a;
        boolean ok = false;
        System.out.println("aqui 2");

        if (ANO != null && !ANO.isEmpty()) {
            for (int i = 0; i < ANO.size(); i++) {
                a = (int) ANO.get(i);
                System.out.println("letra a: " + a);
                if (anoAtual > a) {
                    ok = true;
                }
            }
        }else{
            ok = true;
        }
        return ok;
    }
}
