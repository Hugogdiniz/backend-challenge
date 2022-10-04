package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.enums.StatusPedido;

import java.io.Serializable;
import java.math.BigDecimal;

public class StatusRequestDTO implements Serializable {

    private StatusPedido status;
    private Integer itensAprovados;
    private BigDecimal valorAprovado;
    private String pedido;


    public StatusRequestDTO(StatusPedido status, Integer itensAprovados, BigDecimal valorAprovado, String pedido) {
        this.status = status;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.pedido = pedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Integer getItensAprovados() {
        return itensAprovados;
    }

    public void setItensAprovados(Integer itensAprovados) {
        this.itensAprovados = itensAprovados;
    }

    public BigDecimal getValorAprovado() {
        return valorAprovado;
    }

    public void setValorAprovado(BigDecimal valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

}


