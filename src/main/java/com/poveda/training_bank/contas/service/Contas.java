package com.poveda.training_bank.contas.service;

import com.poveda.training_bank.clientes.service.Clientes;

public class Contas {

    private final long id;
    private final double saldo;
    private final long clientId;

    public Contas(long id, double saldo, long clientId){
        this.id = id;
        this.saldo = saldo;
        this.clientId = clientId;
    }

    public long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public long getClientId() {
        return clientId;
    }
}
