package com.poveda.training_bank.clientes.service;

public class Clientes {

    private final long id;
    private final String nome;
    /*private final String email;
    private final String endereco;
    private final String plano;
    private final long telefone;

    public Clientes(long id, String nome, String email, String endereco, String plano, long telefone){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.plano = plano;
        this.telefone = telefone;
    }*/

    public Clientes(long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public long getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    /*public String getEmail(){
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getPlano(){
        return this.plano;
    }

    public long getTelefone() {
        return this.telefone;
    }*/
}
