package com.poveda.training_bank.clientes.domain.model;

public class Card {

    private Long idCard;
    private Long numeroCard;
    private Long limite;
    private TipoCard tipoCard;
    private Bandeira bandeira;


    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Long getNumeroCard() {
        return numeroCard;
    }

    public void setNumeroCard(Long numeroCard) {
        this.numeroCard = numeroCard;
    }

    public Long getLimite() {
        return limite;
    }

    public void setLimite(Long limite) {
        this.limite = limite;
    }

    public TipoCard getTipoCard() {
        return tipoCard;
    }

    public void setTipoCard(TipoCard tipoCard) {
        this.tipoCard = tipoCard;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
}
