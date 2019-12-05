/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author helde
 */
public class Controle_caixa_Controller {

    Controle_Caixa_DAO CD = new Controle_Caixa_DAO();
    Controle_Caixa c;

    public String CALCULAR_SALDO_ATUAL(Controle_Caixa cc) {

        cc.setSaldo_atual(cc.getSoma_credito() - cc.getSoma_debito());

        String valo = Util_Controller.converteMuedaBR(cc.getSaldo_atual());

        return valo;
    }

    public ArrayList totalDiasMes(int mes) {
        ArrayList<Date> DATAS1;
        Calendar datas = new GregorianCalendar();
        datas.set(Calendar.MONTH, mes - 1);//2
        int quantidadeDias = datas.getActualMaximum(Calendar.DAY_OF_MONTH);
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

    public String mesRelatorio(String data1, String data2) {
        String MES_RELATORIO = "";

        String M1 = "";
        String[] da1 = data1.split("/");
        String[] da2 = data2.split("/");
        String dt1 = da1[1];
        String dt2 = da2[1];
        String ANO = da1[2];

        int mes1 = Integer.parseInt(dt1);
        int mes2 = Integer.parseInt(dt2);

        if (mes1 != mes2) {
            MES_RELATORIO = data1 + " Á " + data2;
        } else if (mes1 == mes2) {
            switch (mes1) {
                case 1:
                    M1 = "JANEIRO";
                    break;
                case 2:
                    M1 = "FEVEREIRO";
                    break;
                case 3:
                    M1 = "MARÇO";
                    break;
                case 4:
                    M1 = "ABRIL";
                    break;
                case 5:
                    M1 = "MAIO";
                    break;
                case 6:
                    M1 = "JUNHO";
                    break;
                case 7:
                    M1 = "JULHO";
                    break;
                case 8:
                    M1 = "AGOSTO";
                    break;
                case 9:
                    M1 = "SETEMBRO";
                    break;
                case 10:
                    M1 = "OUTUBRO";
                    break;
                case 11:
                    M1 = "NOVEMBRO";
                    break;
                case 12:
                    M1 = "DEZEMBRO";
                    break;
                default:
                    break;
            }
            MES_RELATORIO = M1 + " de " + ANO;
        }
       return MES_RELATORIO;
    }
}
