package com.poveda.training_bank.clientes.domain.model;

import java.io.Serializable;

public class Conta {
    private String idConta;
    private Long numero;
    private Long agencia;
    private Long saldo;
  //  private TipoConta tipoConta;
   // private TipoPlano tipoPlano;
    private Card card;

    public Conta(){

    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    /*public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }*/

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    /*public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }*/

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Card getCard () {
        return card;
    }

    public void setCard (Card card){
        this.card = card;
    }

}
