/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Controle_Caixa_DAO;
import Model.Controle_Caixa;

/**
 *
 * @author helde
 */
public class Controle_caixa_Controller {

    Controle_Caixa_DAO CD = new Controle_Caixa_DAO();
    Controle_Caixa c;

    public double calcularDebito(Controle_Caixa fc) {
        c = new Controle_Caixa();
        c = CD.Consultar_Saldo_Atual(fc);
        fc.setNovo_saldo(CALCULAR_SALDO_ATUAL(c) - fc.getDebito());
        return fc.getNovo_saldo();
    }

    public double CALCULAR_SALDO_ATUAL(Controle_Caixa cc) {
        if (cc.getSoma_credito() > cc.getSoma_debito()) {
            cc.setSaldo_atual(cc.getSoma_credito() - cc.getSoma_debito());
        } else if (cc.getSoma_credito() < cc.getSoma_debito()) {
            cc.setSaldo_atual(cc.getSoma_debito() - cc.getSoma_credito());
        } else if (cc.getSoma_credito() == cc.getSoma_debito()) {
            cc.setSaldo_atual(cc.getSoma_credito() - cc.getSoma_debito());
        }

        return cc.getSaldo_atual();
    }
}
