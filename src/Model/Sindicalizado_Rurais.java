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
public class Sindicalizado_Rurais extends Sindicalizado_Pessoais {

    private String nomeFazenda;
    private String logradouro;
    private String municiSede;
    private String codINCRA;
    private String NIRF;
    private double areaPropri;
    private Date dataCompra;
    private String outrasA;
    private String residenciaAtual;
    private int id_proprie;
    private boolean tiraLeite;
    private double valorAnuidade;
    /**
     * @return the nomeFazenda
     */
    public String getNomeFazenda() {
        return nomeFazenda;
    }

    /**
     * @param nomeFazenda the nomeFazenda to set
     */
    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the municiSede
     */
    public String getMuniciSede() {
        return municiSede;
    }

    /**
     * @param municiSede the municiSede to set
     */
    public void setMuniciSede(String municiSede) {
        this.municiSede = municiSede;
    }

    /**
     * @return the codINCRA
     */
    public String getCodINCRA() {
        return codINCRA;
    }

    /**
     * @param codINCRA the codINCRA to set
     */
    public void setCodINCRA(String codINCRA) {
        this.codINCRA = codINCRA;
    }

    /**
     * @return the NIRF
     */
    public String getNIRF() {
        return NIRF;
    }

    /**
     * @param NIRF the NIRF to set
     */
    public void setNIRF(String NIRF) {
        this.NIRF = NIRF;
    }

    /**
     * @return the areaPropri
     */
    public double getAreaPropri() {
        return areaPropri;
    }

    /**
     * @param areaPropri the areaPropri to set
     */
    public void setAreaPropri(double areaPropri) {
        this.areaPropri = areaPropri;
    }

    /**
     * @return the outrasA
     */
    public String getOutrasA() {
        return outrasA;
    }

    /**
     * @param outrasA the outrasA to set
     */
    public void setOutrasA(String outrasA) {
        this.outrasA = outrasA;
    }

    /**
     * @return the residenciaAtual
     */
    public String getResidenciaAtual() {
        return residenciaAtual;
    }

    /**
     * @param residenciaAtual the residenciaAtual to set
     */
    public void setResidenciaAtual(String residenciaAtual) {
        this.residenciaAtual = residenciaAtual;
    }

    /**
     * @return the id_proprie
     */
    public int getId_proprie() {
        return id_proprie;
    }

    /**
     * @param id_proprie the id_proprie to set
     */
    public void setId_proprie(int id_proprie) {
        this.id_proprie = id_proprie;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the tiraLeite
     */
    public boolean isTiraLeite() {
        return tiraLeite;
    }

    /**
     * @param tiraLeite the tiraLeite to set
     */
    public void setTiraLeite(boolean tiraLeite) {
        this.tiraLeite = tiraLeite;
    }

    /**
     * @return the valorAnuidade
     */
    public double getValorAnuidade() {
        return valorAnuidade;
    }

    /**
     * @param valorAnuidade the valorAnuidade to set
     */
    public void setValorAnuidade(double valorAnuidade) {
        this.valorAnuidade = valorAnuidade;
    }

}
