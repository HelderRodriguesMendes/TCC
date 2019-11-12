/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author helde
 */
public class Anuidade extends Sindicalizado_Pessoais{
    private int anoRecebimento;
    private boolean statusPagamento;
    private Date dataDoPagamento;
    private double valor;

    /**
     * @return the anoRecebimento
     */
    public int getAnoRecebimento() {
        return anoRecebimento;
    }

    /**
     * @param anoRecebimento the anoRecebimento to set
     */
    public void setAnoRecebimento(int anoRecebimento) {
        this.anoRecebimento = anoRecebimento;
    }

    /**
     * @return the dataDoPagamento
     */
    public Date getDataDoPagamento() {
        return dataDoPagamento;
    }

    /**
     * @param dataDoPagamento the dataDoPagamento to set
     */
    public void setDataDoPagamento(Date dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the statusPagamento
     */
    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    /**
     * @param statusPagamento the statusPagamento to set
     */
    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    
    
}
