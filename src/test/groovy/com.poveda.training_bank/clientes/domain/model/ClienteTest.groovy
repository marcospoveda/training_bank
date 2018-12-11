package com.poveda.training_bank.clientes.view

import com.poveda.training_bank.clientes.domain.model.Cliente
import spock.lang.Specification
import spock.lang.Unroll

class ClienteTest extends Specification{

    @Unroll
    def "Cliente Teste"(){

        given:
        Cliente cliente = new Cliente()

        when:
        cliente.setIdCliente(clienteId)
        cliente.setNome(clienteNome)
        cliente.setRg(clienteRg)
        cliente.setEndereco(clienteEndereco)

        then:
        id == cliente.getIdCliente()
        nome == cliente.getNome()
        rg == cliente.getRg()
        endereco == cliente.getEndereco()

        where:

        clienteId   |   clienteNome     |   clienteRg   |   clienteEndereco ||  id  ||  nome      ||     rg        ||  endereco
         1          |   "Marcos"        |   "111111111" |   "BL458"         ||   1  ||  "Marcos"  ||  "111111111"  ||  "BL458"
         2          |   "Teste"         |   "123456789" |   "BL425"         ||   2  ||  "Teste"   ||  "123456789"  ||  "BL425"
         3          |   "Teste2"        |   "012345678" |   "FL"            ||   3  ||  "Teste2"  ||  "012345678"  ||   "FL"
    }
}
