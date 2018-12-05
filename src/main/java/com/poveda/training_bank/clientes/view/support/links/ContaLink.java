package com.poveda.training_bank.clientes.view.support.links;

import org.springframework.hateoas.Link;

public class ContaLink {

    private static final String CONTA_CLIENTE = "/clientes/{idCliente}/contas";

    public static Link buildUsing(String idCliente){
        return new Link(CONTA_CLIENTE.replace("{idCliente}", idCliente));
    }
}
