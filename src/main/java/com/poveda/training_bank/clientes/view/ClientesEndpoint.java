package com.poveda.training_bank.clientes.view;


import com.poveda.training_bank.clientes.application.impl.ClienteService;
import com.poveda.training_bank.clientes.domain.model.Card;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.view.support.CardResource;
//import com.poveda.training_bank.clientes.view.support.links.ClienteResourceAssembler;
import com.poveda.training_bank.clientes.view.support.ClienteResource;
import com.poveda.training_bank.clientes.view.support.ClienteResourceAssembler;
import com.poveda.training_bank.clientes.view.support.ContaResource;
import com.poveda.training_bank.infrastructure.exceptions.NotFoundException;
import com.poveda.training_bank.infrastructure.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class ClientesEndpoint {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteResourceAssembler clienteResourceAssembler;



    @Autowired
    public ClientesEndpoint(ClienteService service){
        this.service = service;
    }

    @PostMapping(path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente save(@RequestBody Cliente cliente){
        service.save(cliente);
        System.out.println("Cliente criado com sucesso" + cliente);
        return cliente;
    }

    @GetMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findByName(@RequestParam(value = "nome") String nome){
        System.out.println("Busca por Nome");
        if(StringUtils.isBlank(nome)) throw new ValidationException("Requisicao invalida");
        Cliente cliente = service.findByNome(nome);

        if(cliente == null) throw new NotFoundException("Cliente not found");
        return cliente;
    }

   @GetMapping(path = "/clientes/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteResource findById(@PathVariable Long idCliente){
        System.out.println("Busca por ID");

        if(idCliente == null) throw new ValidationException("Solicitacao invalida");

        final Cliente clienteResource = service.findById(idCliente);

        if(clienteResource == null) throw new NotFoundException("Cliente inexistente, id " + idCliente);

        return clienteResourceAssembler.toResource(clienteResource);

            //return HttpStatus.OK;
    }

    @GetMapping(path = "/clientes/{idCliente}/contas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaResource findConta(@PathVariable Long idCliente){
       System.out.println("Busca por conta");

       if(idCliente == null) throw new ValidationException("Conta invalida");

       final Cliente cliente = service.findById(idCliente);

       if(cliente == null) throw new NotFoundException("Conta inexistente");

       Conta conta = cliente.getConta();


       return clienteResourceAssembler.toResource(cliente, conta);
    }

    @GetMapping(path = "/clientes/{idCliente}/contas/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardResource findCard(@PathVariable Long idCliente){
       System.out.println("Busca Cartões");

       final Cliente cliente = service.findById(idCliente);
       Conta conta = cliente.getConta();
       Card card = conta.getCard();

       return clienteResourceAssembler.toResource(cliente, conta, card);
    }

    @DeleteMapping(value = "/clientes/{nome}")
    public void delete(@PathVariable String nome){
        if(StringUtils.isBlank(nome)) throw new ValidationException("Cliente invalido");
        service.delete(nome);
        System.out.println("Cliente removido com sucesso");

    }

    @PutMapping(value = "/clientes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente update(@RequestBody Cliente cliente,
                          @PathVariable Long id){
        service.update(cliente, id);
        System.out.println("Cliente atualizado com sucesso");
        return cliente;
    }

}
