/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Anuidade_DAO;
import DAO.Controle_Caixa_DAO;
import Model.DadosAnuidade;
import Model.Propriedades_Rurais;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author helde
 */
public class Anuidade_Controller {

    Anuidade_DAO AD = new Anuidade_DAO();
    Controle_Caixa_DAO CC = new Controle_Caixa_DAO();
    Propriedades_Rurais sr;
    String sindicalizado_classificado = "";
    DadosAnuidade d;
    NumberFormat numberCurrencyFormat = NumberFormat.getCurrencyInstance();
    

    public boolean ultima_Anuidade_Recebida(int anoEscolhido) {        
        boolean ok = true;
        int ano, cont = 0;
        ArrayList<Integer> ANO = AD.verificarAnuidadesGeradas();

        for (int i = 0; i < ANO.size(); i++) {
            ano = (int) ANO.get(i);
            if (anoEscolhido == ano) {
                cont++;
            }
        }
        if (cont > 0) {
            ok = false;
        }
        return ok;
    }

    public String calcularAnuidade(int id_sindicalizado) {
        d  = new DadosAnuidade();       
        double somaTerras, resutado = 0, alqueires;
        String valor;
        
        somaTerras = CC.somaHectares(id_sindicalizado);      
        
        alqueires = somaTerras * 4.8;
        
        d = classificarProdutor(alqueires);
        
        if(null != sindicalizado_classificado)switch (sindicalizado_classificado) {
            case "pequeno":
                resutado = (d.getSalario() * d.getPequenoProdutor_porcen()) / 100;
                break;
            case "medio":
                resutado = (d.getSalario() * d.getMedioProdutor_porcen()) / 100;
                break;
            case "grande":
                resutado = (d.getSalario() * d.getGrandeProdutor_porcen()) / 100;
                break;
            default:
                break;
        }       
        valor = Util_Controller.converteMuedaBR(resutado);
        return valor;
    }

    public DadosAnuidade classificarProdutor(double propriedade){
        d = new DadosAnuidade();
        
        d = AD.buscarDados();
        
        if(propriedade == d.getPequenoProdutor_t1()||(propriedade > d.getPequenoProdutor_t1()) && propriedade <= d.getPequenoProdutor_t2()){
            sindicalizado_classificado = "pequeno";
        }else if(propriedade > d.getMedioProdutor_t1()&& propriedade <= d.getMedioProdutor_t2()){
            sindicalizado_classificado = "medio";
        }else if( propriedade > d.getGrandeProdutor() || propriedade == d.getGrandeProdutor()){
            sindicalizado_classificado = "grande";
        }
        return d;
    }
    
    public String formatar(String s) {
        numberCurrencyFormat.setMaximumFractionDigits(2);
        String replaceable = String.format("[%s\\s,.]", NumberFormat.getCurrencyInstance().getCurrency().getSymbol());
        String cleanString = s.replaceAll(replaceable, "");

        double parsed = Double.parseDouble(cleanString);
        String formatted = numberCurrencyFormat.format((parsed / 100));        
        return formatted;
    }
}
