package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatusResponseDTO implements Serializable {

    @JsonProperty("pedido")
    private Long id;
    private List<StatusPedido> status = new ArrayList<>() ;


    public StatusResponseDTO(){

    }

    public StatusResponseDTO(Long id, List<StatusPedido> status) {
        this.id = id;
        this.status = status;
    }

    public Long getPedido() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public List<StatusPedido> getStatus() {
        return status;
    }

    public void setStatus(List<StatusPedido> status) {
        this.status = status;
    }
}
