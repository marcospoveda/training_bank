package com.poveda.training_bank.clientes.view;


import com.poveda.training_bank.clientes.application.impl.ClienteService;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientesEndpoint {

    private ClienteService service;

    @Autowired
    public ClientesEndpoint(ClienteService service){
        this.service = service;
    }

    @PostMapping(path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente save(@RequestBody Cliente cliente){
        service.save(cliente);
        System.out.println("Cliente criado" + cliente.toString());
        return cliente;
    }

    @GetMapping(path = "/clientes/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findBy(@PathVariable String nome){
        return service.findByNome(nome);
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
        System.out.println("Cliente atualizado");
        return cliente;
    }


}
