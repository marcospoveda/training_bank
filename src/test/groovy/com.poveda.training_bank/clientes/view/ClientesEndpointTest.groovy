package com.poveda.training_bank.clientes.view


import com.poveda.training_bank.clientes.infratest.AbstractIntegrationGroovySpec
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.OK

@ContextConfiguration()
class ClientesEndpointTest extends AbstractIntegrationGroovySpec{

   // @Shared HashMap<String, Cliente> clienteDataSet

    def setupSpec(){
        sceneryLoaderHelper.load("clientes/clientes-endpoint-cenarios.json")
    }

    /*def setup(){
        clienteRepository = Mockito.mock(ClienteRepository)
        ServiceLocator.registry(ClienteRepository, this.clienteRepository)

        Cliente cliente = new Cliente("1", "Marcos", "111111111", 111111111, 123456789, "BL458", "sit_mpoveda@uolinc.com");

        //clienteDataSet = new HashMap<>()
        //clienteDataSet.put("1", cliente)

    }*/

    @Unroll
    def "Teste2"(){
        given:
            def uri = "/clientes/${idCliente}"

        when:
            def mvc = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn()

        then:
            mvc.response.status == status.value()
            mvc.response.contentAsString == this.sceneryLoaderHelper.getRequestScenery(expectedBody).getJson()

        where:
        idCliente ||      expectedBody           ||   status
           "1"    ||    "Conta localizada"       ||    OK
       //    "20"   ||    "Conta não localizada"   ||    NOT_FOUND
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
