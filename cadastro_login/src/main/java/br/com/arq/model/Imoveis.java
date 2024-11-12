package br.com.arq.model;


import java.util.Arrays;

import jakarta.persistence.*;

@Entity

public class Imoveis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImovel;

    private String nomeImagemImovel;
    private Integer tipoImovel;
    private Integer estadoImovel;
    private Integer cidadeImovel;
    private Integer quartoImovel;
    private Integer banheiroImovel;
    private Integer piscinaImovel;
    private Integer wifiImovel;
    private Integer garagemImovel;
    private Integer hidromassagemImovel;
    private Integer banheiraImovel;
    private Integer saunaImovel;
    private String sobreImovel;
    private String telefoneImovel;

    public Imoveis() {
    }

    public Imoveis(Integer idImovel, String nomeImagemImovel, Integer tipoImovel, Integer estadoImovel, Integer cidadeImovel, Integer quartoImovel, Integer piscinaImovel, Integer garagemImovel, Integer banheiroImovel, Integer wifiImovel, Integer hidromassagemImovel, Integer saunaImovel, Integer banheiraImovel, String sobreImovel, String telefoneImovel) {
        this.idImovel = idImovel;
        this.nomeImagemImovel = nomeImagemImovel;
        this.tipoImovel = tipoImovel;
        this.estadoImovel = estadoImovel;
        this.cidadeImovel = cidadeImovel;
        this.quartoImovel = quartoImovel;
        this.piscinaImovel = piscinaImovel;
        this.garagemImovel = garagemImovel;
        this.banheiroImovel = banheiroImovel;
        this.wifiImovel = wifiImovel;
        this.hidromassagemImovel = hidromassagemImovel;
        this.saunaImovel = saunaImovel;
        this.banheiraImovel = banheiraImovel;
        this.sobreImovel = sobreImovel;
        this.telefoneImovel = telefoneImovel;
    }

    @Override
    public String toString() {
        return "Imoveis{" +
                "idImovel=" + idImovel +
                ", nomeImagemImovel=" + nomeImagemImovel +
                ", tipoImovel=" + tipoImovel +
                ", estadoImovel=" + estadoImovel +
                ", cidadeImovel=" + cidadeImovel +
                ", quartoImovel=" + quartoImovel +
                ", banheiroImovel=" + banheiroImovel +
                ", piscinaImovel=" + piscinaImovel +
                ", wifiImovel=" + wifiImovel +
                ", garagemImovel=" + garagemImovel +
                ", hidromassagemImovel=" + hidromassagemImovel +
                ", banheiraImovel=" + banheiraImovel +
                ", saunaImovel=" + saunaImovel +
                ", sobreImovel='" + sobreImovel + '\'' +
                ", telefoneImovel='" + telefoneImovel + '\'' +
                '}';
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public String getNomeImagemImovel() {
        return nomeImagemImovel;
    }

    public Integer getTipoImovel() {
        return tipoImovel;
    }

    public Integer getEstadoImovel() {
        return estadoImovel;
    }

    public Integer getCidadeImovel() {
        return cidadeImovel;
    }

    public Integer getQuartoImovel() {
        return quartoImovel;
    }

    public Integer getBanheiroImovel() {
        return banheiroImovel;
    }

    public Integer getPiscinaImovel() {
        return piscinaImovel;
    }

    public Integer getWifiImovel() {
        return wifiImovel;
    }

    public Integer getGaragemImovel() {
        return garagemImovel;
    }

    public Integer getHidromassagemImovel() {
        return hidromassagemImovel;
    }

    public Integer getBanheiraImovel() {
        return banheiraImovel;
    }

    public Integer getSaunaImovel() {
        return saunaImovel;
    }

    public String getSobreImovel() {
        return sobreImovel;
    }

    public String getTelefoneImovel() {
        return telefoneImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public void setNomeImagemImovel(String nomeImagemImovel) {
        this.nomeImagemImovel = nomeImagemImovel;
    }

    public void setTipoImovel(Integer tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public void setEstadoImovel(Integer estadoImovel) {
        this.estadoImovel = estadoImovel;
    }

    public void setCidadeImovel(Integer cidadeImovel) {
        this.cidadeImovel = cidadeImovel;
    }

    public void setQuartoImovel(Integer quartoImovel) {
        this.quartoImovel = quartoImovel;
    }

    public void setBanheiroImovel(Integer banheiroImovel) {
        this.banheiroImovel = banheiroImovel;
    }

    public void setPiscinaImovel(Integer piscinaImovel) {
        this.piscinaImovel = piscinaImovel;
    }

    public void setWifiImovel(Integer wifiImovel) {
        this.wifiImovel = wifiImovel;
    }

    public void setGaragemImovel(Integer garagemImovel) {
        this.garagemImovel = garagemImovel;
    }

    public void setHidromassagemImovel(Integer hidromassagemImovel) {
        this.hidromassagemImovel = hidromassagemImovel;
    }

    public void setBanheiraImovel(Integer banheiraImovel) {
        this.banheiraImovel = banheiraImovel;
    }

    public void setSaunaImovel(Integer saunaImovel) {
        this.saunaImovel = saunaImovel;
    }

    public void setSobreImovel(String sobreImovel) {
        this.sobreImovel = sobreImovel;
    }

    public void setTelefoneImovel(String telefoneImovel) {
        this.telefoneImovel = telefoneImovel;
    }
}
