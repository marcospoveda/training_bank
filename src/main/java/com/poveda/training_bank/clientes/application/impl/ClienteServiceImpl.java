package com.poveda.training_bank.clientes.application.impl;

import com.poveda.training_bank.ClientesConfig;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.ClienteValidator;
import com.poveda.training_bank.clientes.repository.ClienteRepository;
import com.poveda.training_bank.infrastructure.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    private ClienteValidator clienteValidator;

    @Autowired
    public ClienteServiceImpl(ClienteValidator validator){
        this.clienteValidator = validator;
        this.clienteRepository = ClientesConfig.config();
    }

    @Override
    public void save(Cliente cliente) {
        clienteValidator.checkRules(cliente);
        clienteRepository.save(cliente);
    }

   @Override
    public Cliente findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public void delete(String nome) {
        clienteRepository.delete(nome);
    }

    @Override
    public void update(Cliente cliente, Long id) {
        clienteRepository.update(cliente, id);
    }

    @Override
    public Cliente findById(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }


}
