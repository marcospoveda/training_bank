package com.poveda.training_bank.clientes.application.impl;

import com.poveda.training_bank.clientes.domain.model.Cliente;

public interface ClienteService {

    void save(Cliente cliente);

    Cliente findByNome(String nome);

    void delete(String nome);

    void update(Cliente cliente, String id);
}
