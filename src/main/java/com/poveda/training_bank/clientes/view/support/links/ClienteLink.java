package com.poveda.training_bank.clientes.view.support.links;

import org.springframework.hateoas.Link;

public class ClienteLink {

    private static final String CLIENTE = "/clientes/{idCliente}";

    public static Link buildUsing(Long idCliente){
        return new Link(CLIENTE.replace("{idCliente}", idCliente.toString()));
    }
}
