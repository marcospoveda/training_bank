package com.poveda.training_bank;

import com.poveda.training_bank.clientes.domain.model.Card;
import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientesConfig {

    @Bean
    public static ClienteRepository config(){

        ClienteRepository clienteRepository = new ClienteRepository();

        Card card = new Card();
        card.setIdCard("1");
        card.setNumeroCard(123L);
        card.setLimite(1200L);

        Conta conta = new Conta();
        conta.setIdConta("1");
        conta.setAgencia(123L);
        conta.setCard(card);
        conta.setNumero(1234L);
        conta.setSaldo(1500L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente("1");
        cliente.setNome("Marcos");
        cliente.setRg("111111111");
        cliente.setCpf(111111111L);
        cliente.setEndereco("Rua Teste");
        cliente.setTelefone(11123456789L);
        cliente.setEmail("teste@uolinc.com");
        cliente.setConta(conta);


        clienteRepository.save(cliente);

        return clienteRepository;
    }

}
