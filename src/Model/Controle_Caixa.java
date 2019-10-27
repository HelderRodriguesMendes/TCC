/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author helde
 */
public class Controle_Caixa {
    private String banco;
    private Date data;
    private String historico;
    private String documento;
    private double debito;
    private double credito;
    private double Soma_credito;
    private double Soma_debito;
    private double saldo_atual;
    private double novo_saldo;
    private int id;
    private int excluido;

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the debito
     */
    public double getDebito() {
        return debito;
    }

    /**
     * @param debito the debito to set
     */
    public void setDebito(double debito) {
        this.debito = debito;
    }

    /**
     * @return the credito
     */
    public double getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * @return the Soma_credito
     */
    public double getSoma_credito() {
        return Soma_credito;
    }

    /**
     * @param Soma_credito the Soma_credito to set
     */
    public void setSoma_credito(double Soma_credito) {
        this.Soma_credito = Soma_credito;
    }

    /**
     * @return the Soma_debito
     */
    public double getSoma_debito() {
        return Soma_debito;
    }

    /**
     * @param Soma_debito the Soma_debito to set
     */
    public void setSoma_debito(double Soma_debito) {
        this.Soma_debito = Soma_debito;
    }

    /**
     * @return the saldo_atual
     */
    public double getSaldo_atual() {
        return saldo_atual;
    }

    /**
     * @param saldo_atual the saldo_atual to set
     */
    public void setSaldo_atual(double saldo_atual) {
        this.saldo_atual = saldo_atual;
    }

    /**
     * @return the novo_saldo
     */
    public double getNovo_saldo() {
        return novo_saldo;
    }

    /**
     * @param novo_saldo the novo_saldo to set
     */
    public void setNovo_saldo(double novo_saldo) {
        this.novo_saldo = novo_saldo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public PreparedStatement prepareStatement(String insert_into_ControleDeCaixa_banco_data_hi, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the excluido
     */
    public int getExcluido() {
        return excluido;
    }

    /**
     * @param excluido the excluido to set
     */
    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }
}
