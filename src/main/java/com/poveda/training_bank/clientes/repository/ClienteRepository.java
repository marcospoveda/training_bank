package com.poveda.training_bank.clientes.repository;

import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.view.support.ClienteResource;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    /*public Cliente findByNome(String nome) {
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        return null;
    }*/

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

   public Cliente findById(Long idCliente) {
        for(Cliente cliente : clientes){
            if(cliente.getIdCliente().equals(idCliente)){
                return cliente;
            }
        }
        return null;
    }

}
