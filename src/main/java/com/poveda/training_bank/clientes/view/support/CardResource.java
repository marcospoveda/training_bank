package com.poveda.training_bank.clientes.view.support;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.poveda.training_bank.clientes.domain.model.Bandeira;
import com.poveda.training_bank.clientes.domain.model.TipoCard;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@JsonPropertyOrder({
        "idCard",
        "numeroCard",
        "limite",
        "bandeira",
        "tipoCard",
        "_links",
        "_account",
        "_owned-by"
})
@Relation(collectionRelation = "cards")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResource extends ResourceSupport {

    @JsonProperty(value = "idCard")
    private Long idCard;
    private Long numeroCard;
    private Long limite;

    private Bandeira bandeira;

    private TipoCard tipoCard;

    public CardResource(Long idCard) {
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Long getNumeroCard() {
        return numeroCard;
    }

    public void setNumeroCard(Long numeroCard) {
        this.numeroCard = numeroCard;
    }

    public Long getLimite() {
        return limite;
    }

    public void setLimite(Long limite) {
        this.limite = limite;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public TipoCard getTipoCard() {
        return tipoCard;
    }

    public void setTipoCard(TipoCard tipoCard) {
        this.tipoCard = tipoCard;
    }
}
