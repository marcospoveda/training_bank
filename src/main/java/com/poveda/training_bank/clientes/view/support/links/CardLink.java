package com.poveda.training_bank.clientes.view.support.links;

import org.springframework.hateoas.Link;

public class CardLink {

    private static final String CARTAO_CONTA = "/clientes/{idCliente}/contas/cards";

    public static Link buildUsing(String idCliente){
        return new Link(CARTAO_CONTA.replace("{idCliente}", idCliente));
    }

}
