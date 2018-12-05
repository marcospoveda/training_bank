package com.poveda.training_bank.clientes.application.impl;

import com.poveda.training_bank.ClientesConfig;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.ClienteValidator;
import com.poveda.training_bank.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

  //  private Validator clienteValidator;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, Validator validator){
      //  this.clienteValidator = validator;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void save(Cliente cliente) {
    //    clienteValidator.checkRules(cliente);
        this.clienteRepository = ClientesConfig.config();
        clienteRepository.save(cliente);
    }

   @Override
    public Cliente findByNome(String nome) {
       this.clienteRepository = ClientesConfig.config();
        return clienteRepository.findByNome(nome);
    }

    @Override
    public void delete(String nome) {
        this.clienteRepository = ClientesConfig.config();
        clienteRepository.delete(nome);
    }

    @Override
    public void update(Cliente cliente, String id) {
        this.clienteRepository = ClientesConfig.config();
        clienteRepository.update(cliente, id);
    }

    @Override
    public Cliente findById(String idCliente) {
        this.clienteRepository = ClientesConfig.config();
        return clienteRepository.findById(idCliente);
    }


}
