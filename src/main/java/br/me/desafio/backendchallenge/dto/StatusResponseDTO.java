package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.enums.StatusPedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatusResponseDTO implements Serializable {

    private String pedido;
    private List<StatusPedido> status = new ArrayList<>();

    public StatusResponseDTO(String pedido, List<StatusPedido> status) {
        this.pedido = pedido;
        this.status = status;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public List<StatusPedido> getStatus() {
        return status;
    }

    public void setStatus(List<StatusPedido> status) {
        this.status = status;
    }
}
