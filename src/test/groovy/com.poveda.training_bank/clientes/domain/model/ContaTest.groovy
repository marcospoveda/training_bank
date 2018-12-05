package com.poveda.training_bank.clientes.domain.model

import com.poveda.training_bank.clientes.infratest.AbstractIntegrationGroovySpec
import spock.lang.Specification
import spock.lang.Unroll

class ContaTest extends Specification{

    @Unroll
    def "Conta Teste"(){

        given:
        Conta conta = new Conta()

        when:
        conta.setIdConta(contaId)
        conta.setNumero(numeroConta)
        conta.setAgencia(agenciaConta)
        conta.setSaldo(saldoConta)

        then:
        id == conta.getIdConta()
        numero == conta.getNumero()
        agencia == conta.getAgencia()
        saldo == conta.getSaldo()

        where:

        contaId | numeroConta | agenciaConta |  saldoConta ||  id  || numero || agencia ||   saldo
          "1"   |    1234     |    1011      |     1200    ||  "1" ||  1234  ||  1011   ||   1200
          "2"   |    1410     |    1011      |     5000    ||  "2" ||  1410  ||  1011   ||   5000




    }

}
