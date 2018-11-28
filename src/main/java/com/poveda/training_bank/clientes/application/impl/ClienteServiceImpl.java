package com.poveda.training_bank.clientes.application.impl;

import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.repository.ClienteRepository;
import com.poveda.training_bank.clientes.view.support.ClienteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

   /*@Override
    public Cliente findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
*/
    @Override
    public void delete(String nome) {
        clienteRepository.delete(nome);
    }

    @Override
    public void update(Cliente cliente, String id) {
        clienteRepository.update(cliente, id);
    }

    @Override
    public Cliente findById(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }


}
