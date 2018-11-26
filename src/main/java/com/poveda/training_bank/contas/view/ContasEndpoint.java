package com.poveda.training_bank.contas.view;


import com.poveda.training_bank.contas.service.Contas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ContasEndpoint {

  //  private final AtomicLong id = new AtomicLong();

   @RequestMapping("/contas")
    public Contas contas(@RequestParam(value = "id", defaultValue = "1") long id){
        return new Contas(1, 500.00, 1);
    }


}
