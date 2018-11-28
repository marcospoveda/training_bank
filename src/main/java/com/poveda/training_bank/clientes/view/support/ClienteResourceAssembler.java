package com.poveda.training_bank.clientes.view.support;

import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.view.ClientesEndpoint;
import com.poveda.training_bank.clientes.view.support.links.ClienteLink;
import com.poveda.training_bank.clientes.view.support.links.ContaLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClienteResourceAssembler extends ResourceAssemblerSupport<Cliente, ClienteResource> {

    private static final String CUSTOMER_SELF = "/clientes/{idCliente}";
    private static final String CUSTOMER_REL = "/clientes/{idCliente}";
    //private static final String CONTA_SELF = "/clientes/{idCliente}/contas";

    @Autowired
    public ClienteResourceAssembler(){

        super(ClientesEndpoint.class, ClienteResource.class);
    }

    @Override
    public ClienteResource toResource(Cliente cliente){
        ClienteResource resource = new ClienteResource(cliente.getIdCliente());

        resource.setIdCliente(cliente.getIdCliente());
        resource.setNome(cliente.getNome());
        resource.setRg(cliente.getRg());
        resource.setCpf(cliente.getCpf());
        resource.setEndereco(cliente.getEndereco());
        resource.setEmail(cliente.getEmail());
        resource.setTelefone(cliente.getTelefone());

        resource.add(ClienteLink.buildUsing(cliente.getIdCliente()));

        return resource;
    }


    public ContaResource toResource(Cliente cliente, Conta conta){
        ContaResource resource = new ContaResource(conta.getIdConta());

        resource.setIdConta(conta.getIdConta());
        resource.setNumero(conta.getNumero());
        resource.setSaldo(conta.getSaldo());
        resource.setTipoConta(conta.getTipoConta());
        resource.setTipoPlano(conta.getTipoPlano());

       // resource.add(new Link(CONTA_SELF.replace("{idCliente}", clienteResource.getIdCliente().toString())));
        resource.add(ContaLink.buildUsing(cliente.getIdCliente()));
        resource.add(ClienteLink.buildUsing(cliente.getIdCliente()).withRel("owned-by"));


        return resource;


    }
}
