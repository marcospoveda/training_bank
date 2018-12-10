package com.poveda.training_bank.clientes.view.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.poveda.training_bank.clientes.domain.model.Conta;
import com.poveda.training_bank.clientes.domain.model.TipoConta;
import com.poveda.training_bank.clientes.domain.model.TipoPlano;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@JsonPropertyOrder({
        "idConta",
        "numero",
        "agencia",
        "saldo",
        "tipoConta",
        "tipoPlano",
        "_links",
        "_owned-by",
        "_has-card"
})
@Relation(collectionRelation = "contas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResource extends ResourceSupport {


    @JsonProperty(value = "id")
    private Long idConta;
    private Long numero;
    private Long agencia;
    private Long saldo;

    private TipoConta tipoConta;

    private TipoPlano tipoPlano;

    public ContaResource(Conta conta) {
    }

    public ContaResource() {

    }

    public ContaResource(Long idConta) {
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
