package com.poveda.training_bank.clientes.view.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@JsonPropertyOrder({
        "idCliente",
        "nome",
        "rg",
        "cpf",
        "endereco",
        "telefone",
        "email",
        "_links",
        "_has-account"
})
@Relation(collectionRelation = "clientes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteResource extends ResourceSupport {

    @JsonProperty(value = "idCliente")
    private Long idCliente;
    private String nome;
    private String rg;
    private Long cpf;
    private String endereco;
    private Long telefone;
    private String email;
    //private ContaResource conta;

    public ClienteResource(Long idCliente) {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  /* public ContaResource getConta() {
        return conta;
    }

    public void setConta(ContaResource conta) {
        this.conta = conta;
    }*/
}
