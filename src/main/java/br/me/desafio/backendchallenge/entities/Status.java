package br.me.desafio.backendchallenge.entities;

import br.me.desafio.backendchallenge.enums.StatusPedido;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Status implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itensAprovados;
    private BigDecimal valorAprovado;
    private Pedido pedido;
    private StatusPedido statusInformado;
    private List<StatusPedido> status;

    public Status(Long id, Integer itensAprovados, BigDecimal valorAprovado, Pedido pedido, StatusPedido statusInformado, List<StatusPedido> status) {
        this.id = id;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.pedido = pedido;
        this.statusInformado = statusInformado;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatusInformado() {
        return statusInformado;
    }

    public void setStatusInformado(StatusPedido statusInformado) {
        this.statusInformado = statusInformado;
    }

    public List<StatusPedido> getStatus() {
        return status;
    }

    public void setStatus(List<StatusPedido> status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return Objects.equals(id, status1.id) && Objects.equals(itensAprovados, status1.itensAprovados) && Objects.equals(valorAprovado, status1.valorAprovado) && Objects.equals(pedido, status1.pedido) && statusInformado == status1.statusInformado && Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itensAprovados, valorAprovado, pedido, statusInformado, status);
    }
}


