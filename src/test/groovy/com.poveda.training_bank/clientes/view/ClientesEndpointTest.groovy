package com.poveda.training_bank.clientes.view


import com.poveda.training_bank.clientes.infratest.AbstractIntegrationGroovySpec
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.NOT_FOUND

@ContextConfiguration()
class ClientesEndpointTest extends AbstractIntegrationGroovySpec{

   // @Shared HashMap<String, Cliente> clienteDataSet

    def setupSpec(){
        sceneryLoaderHelper.load("clientes/clientes-endpoint-cenarios.json")
    }


    @Unroll("Busca de Clientes por Nome, cenario [#expectedBody]")
    def "Busca Cliente por Nome"(){
        given:
            def uri = "/clientes"

        when:
            def mvc = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("nome", nome)).andReturn()

        then:
            mvc.response.status == status.value()
            mvc.response.contentAsString == this.sceneryLoaderHelper.getRequestScenery(expectedBody).getJson()

        where:
          nome    ||       expectedBody       ||  status
        "Marcos"  ||   "Cliente encontrado"   ||    OK
        "Teste"   ||   "Cliente not found"    ||   NOT_FOUND
        " "       ||   "Requisicao invalida"  ||   BAD_REQUEST
    }

//-----------------------------------------------------------------------------------------------------------------//

    @Unroll("Busca de cliente por ID, cenario: [#expectedBody]")
    def "Busca Cliente ID"(){
        given:
            def uri = "/clientes/${idCliente}"


        when:
            def mvc = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn()

        then:
            mvc.response.status == status.value()
            mvc.response.contentAsString == this.sceneryLoaderHelper.getRequestScenery(expectedBody).getJson()

        where:
        idCliente ||      expectedBody           ||   status
            1     ||    "Cliente localizado"     ||     OK
            50    ||    "Cliente inexistente"    ||     NOT_FOUND
            ' '   ||    "Solicitacao invalida"   ||     BAD_REQUEST
    }

//--------------------------------------------------------------------------------------------------------------//

    @Unroll("Busca cliente pelo nome, cenario: [#expectedBody]")
    def "Deleta Cliente"(){
        given:
            def uri = "/clientes/${nome}"

        when:
            def mvc = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn()

        then:
            mvc.response.status == status.value()
            mvc.response.contentAsString == this.sceneryLoaderHelper.getRequestScenery(expectedBody).getJson()

        where:
          nome    ||            expectedBody          ||  status
        "Teste"   ||      "Cliente nao localizado"    ||    NOT_FOUND
        " "       ||       "Cliente invalido"         ||    BAD_REQUEST
    }

//-------------------------------------------------------------------------------------------------------------//

    @Unroll("Busca de contas, cenario: [#expectedBody]")
    def "Busca Contas"(){
        given:
            def uri = "/clientes/${idCliente}/contas"

        when:
            def mvc = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn()

        then:
            mvc.response.status == status.value()
            mvc.response.contentAsString == this.sceneryLoaderHelper.getRequestScenery(expectedBody).getJson()

        where:
        idCliente  ||      expectedBody      ||   status
           1       ||    "Conta localizada"  ||    OK
           51      ||    "Conta inexistente" ||    NOT_FOUND
          ' '      ||    "Conta invalida"    ||    BAD_REQUEST
    }

/*    def idTeste = "20"

    def "teste cliente"(){
        given:
        Cliente cliente = new Cliente()
        cliente.setIdCliente(idTeste)

        when:
        def id = cliente.getIdCliente()
        def uri = "localhost:8080/clientes/${id}"


        then:
        id == "20"
        uri == "localhost:8080/clientes/20"
    }

*/

   /* def setupSpec(){
        Cliente cliente = new Cliente("10", "Marcos", "111111111", 111111111, 123456789, "BL458", "sit_mpoveda@uolinc.com")
    }



    def "Criar cliente"() {
        given:
        String valor = "10"

        when:
        def uri = mockMvc.perform(MockMvcRequestBuilders.get("/clientes/${valor}")).andReturn()

        then:
        uri == "/clientes/10"


    }*/

}
