package com.poveda.training_bank.clientes.infratest

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.poveda.training_bank.TrainingBankApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(classes = TrainingBankApplication, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class AbstractIntegrationGroovySpec extends Specification{

    static {
        final int PORT = 9090
        new WireMockServer(WireMockConfiguration.wireMockConfig().port(PORT)).start()
        WireMock.configureFor("localhost", PORT)
    }

    protected MockMvc mockMvc

    @Shared SceneryLoaderHelper sceneryLoaderHelper

    def setupSpec(){
        this.sceneryLoaderHelper = new SceneryLoaderHelper()
    }

    @Autowired
    protected WebApplicationContext context

    def setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }
}
