package com.poveda.training_bank.clientes.view;


import com.poveda.training_bank.clientes.service.Clientes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ClientesEndpoint {

    private final AtomicLong id = new AtomicLong();


    @RequestMapping("/clientes")
    public Clientes clientes(@RequestParam(value = "name", defaultValue = "Marcos") String name){
        return new Clientes(id.incrementAndGet(),String.format(name));
    }

}
