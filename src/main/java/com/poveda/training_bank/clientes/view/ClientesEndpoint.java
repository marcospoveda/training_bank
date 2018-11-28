package com.poveda.training_bank.clientes.view;


import com.poveda.training_bank.clientes.application.impl.ClienteService;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.view.support.ClienteResource;
//import com.poveda.training_bank.clientes.view.support.links.ClienteResourceAssembler;
import com.poveda.training_bank.clientes.view.support.ClienteResourceAssembler;
import com.poveda.training_bank.clientes.view.support.ContaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

   /* @GetMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findBy(@RequestParam(value = "nome") String nome){
        System.out.println("Busca por Nome");
        return service.findByNome(nome);
    }*/

   @GetMapping(path = "/clientes/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteResource findById(@PathVariable Long idCliente){
        System.out.println("Busca por ID");

        final Cliente clienteResource = service.findById(idCliente);

        return clienteResourceAssembler.toResource(clienteResource);
    }

    @GetMapping(path = "/clientes/{idCliente}/contas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaResource findConta(@PathVariable Long idCliente){
       System.out.println("Busca por conta");

       final Cliente cliente = service.findById(idCliente);
       Conta conta = cliente.getConta();

       return clienteResourceAssembler.toResource(cliente, conta);
    }

    @DeleteMapping(value = "/clientes/{nome}")
    public void delete(@PathVariable String nome){
        service.delete(nome);
        System.out.println("Cliente removido com sucesso");
    }

    @PutMapping(value = "/clientes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente update(@RequestBody Cliente cliente,
                          @PathVariable String id){
        service.update(cliente, id);
        System.out.println("Cliente atualizado com sucesso");
        return cliente;
    }

}
