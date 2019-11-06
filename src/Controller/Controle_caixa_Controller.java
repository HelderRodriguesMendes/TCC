/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author helde
 */
public class Controle_caixa_Controller {

    Controle_Caixa_DAO CD = new Controle_Caixa_DAO();
    Controle_Caixa c;

    public String CALCULAR_SALDO_ATUAL(Controle_Caixa cc) {
        
        cc.setSaldo_atual(cc.getSoma_credito() - cc.getSoma_debito());
        
        String valo = converteMuedaBR(cc.getSaldo_atual());
        
        return valo;
    }
    
    public String converteMuedaBR(double valor){
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String va = currencyFormatter.format(valor);
        return va;
    }

    public ArrayList totalDiasMes(int mes) {
        System.out.println("aqui 1");
        ArrayList<Date> DATAS1;
        Calendar datas = new GregorianCalendar();
        datas.set(Calendar.MONTH, mes - 1);//2
        int quantidadeDias = datas.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("aqui 2");
        DATAS1 = montarDatas(quantidadeDias, mes);

        return DATAS1;
    }

    public ArrayList montarDatas(int dias, int mes) {
        String data1, data2, m, ano;
        Date d1, d2;
        ArrayList<Date> DATAS = new ArrayList<>();

        int a = Calendar.getInstance().get(Calendar.YEAR); // pegando o mes atual
        ano = String.valueOf(a);
        m = String.valueOf(mes);

        data1 = "01/" + m + "/" + ano;
        data2 = dias + "/" + m + "/" + ano;

        d1 = Util_Controller.STRING_DATE(data1);
        d2 = Util_Controller.STRING_DATE(data2);

        DATAS.add(d1);
        DATAS.add(d2);

        return DATAS;
    }
}
