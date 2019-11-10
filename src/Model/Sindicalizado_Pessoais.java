package Model;

import java.util.Date;

/**
 *
 * @author helde
 */
public class Sindicalizado_Pessoais extends Pessoa {

    private Date dataNasci;
    private String nacionalidade;
    private String estadoCivil;
    private String cpf;
    private String rg;
    private Date dataExpedicao;
    private String tituloEleito;
    private String zona;
    private String secao;
    private String reservista;
    private String categoria;
    private String pai;
    private String mae;
    private int id_sindi;
    private boolean excluido;

    

    /**
     * @return the dataNasci
     */
    public Date getDataNasci() {
        return dataNasci;
    }

    /**
     * @param dataNasci the dataNasci to set
     */
    public void setDataNasci(Date dataNasci) {
        this.dataNasci = dataNasci;
    }

    /**
     * @return the nacionalidade
     */
    public String getNascionalidade() {
        return nacionalidade;
    }

    /**
     * @param nascionalidade the nacionalidade to set
     */
    public void setNascionalidade(String nascionalidade) {
        this.nacionalidade = nascionalidade;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the dataExpedicao
     */
    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * @param dataExpedicao the dataExpedicao to set
     */
    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    /**
     * @return the tituloEleito
     */
    public String getTituloEleito() {
        return tituloEleito;
    }

    /**
     * @param tituloEleito the tituloEleito to set
     */
    public void setTituloEleito(String tituloEleito) {
        this.tituloEleito = tituloEleito;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * @return the secao
     */
    public String getSecao() {
        return secao;
    }

    /**
     * @param secao the secao to set
     */
    public void setSecao(String secao) {
        this.secao = secao;
    }

    /**
     * @return the reservista
     */
    public String getReservista() {
        return reservista;
    }

    /**
     * @param reservista the reservista to set
     */
    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the pai
     */
    public String getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(String pai) {
        this.pai = pai;
    }

    /**
     * @return the mae
     */
    public String getMae() {
        return mae;
    }

    /**
     * @param mae the mae to set
     */
    public void setMae(String mae) {
        this.mae = mae;
    }

    /**
     * @return the excluido
     */
    public boolean getExcluido() {
        return excluido;
    }

    /**
     * @param excluido the excluido to set
     */
    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    /**
     * @return the id_sindi
     */
    public int getId_sindi() {
        return id_sindi;
    }

    /**
     * @param id_sindi the id_sindi to set
     */
    public void setId_sindi(int id_sindi) {
        this.id_sindi = id_sindi;
    }

}
