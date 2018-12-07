package com.poveda.training_bank.clientes.repository;

import com.poveda.training_bank.ClientesConfig;
import com.poveda.training_bank.clientes.domain.model.Card;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.view.support.ClienteResource;
import com.poveda.training_bank.infrastructure.exceptions.NotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();



    public void save(Cliente cliente) {
        clientes.add(cliente);
      //  Conta conta = cliente.getConta();
      //  Card card = conta.getCard();
      //  conta.setIdConta(UUID.randomUUID().toString().substring(1, 20));
      //  card.setIdCard(UUID.randomUUID().toString().substring(1, 20));
       // cliente.setIdCliente(UUID.randomUUID().toString().substring(1, 20));  (Gera ID aleatório)
    }

    public Cliente findByNome(String nome) {
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        return null;
    }

   public void delete(String nome) {
        Iterator <Cliente> iterator = clientes.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getNome().equals(nome)){
                iterator.remove();
            }
        }
    }

    public void update(Cliente lista, String id) {
        for(Cliente cliente : clientes){
            if(cliente.getIdCliente().equals(lista.getIdCliente())){
                cliente.setEmail(lista.getEmail());
                cliente.setEndereco(lista.getEndereco());
                cliente.setTelefone(lista.getTelefone());
            }
        }
    }

   public Cliente findById(String idCliente) {

        for(Cliente cliente : clientes){
            if(cliente.getIdCliente().equals(idCliente)){
                return cliente;
            }
        }
        return null;
    }

}
