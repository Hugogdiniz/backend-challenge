package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class StatusRequestDTO implements Serializable {

    private StatusPedido status;
    private Integer itensAprovados;
    private BigDecimal valorAprovado;

    @JsonProperty("pedido")
    private String id;

    public StatusRequestDTO(){

    }
    public StatusRequestDTO(StatusPedido status, Integer itensAprovados, BigDecimal valorAprovado, String id) {
        this.status = status;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.id = id;
    }

    public StatusRequestDTO(Status status) {
        this.id = status.getId();
        this.status = status.getStatusInformado();
        this.itensAprovados = status.getItensAprovados();
        this.valorAprovado = status.getValorAprovado();
    }

    public StatusPedido getStatus() {
        return status;
    }

    public Integer getItensAprovados() {
        return itensAprovados;
    }

    public BigDecimal getValorAprovado() {
        return valorAprovado;
    }

    public String getId() {
        return id;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setItensAprovados(Integer itensAprovados) {
        this.itensAprovados = itensAprovados;
    }

    public void setValorAprovado(BigDecimal valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public void setId(String id) {
        this.id = id;
    }
}


