package br.me.desafio.backendchallenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Pedido pedido;

    private String descricao;
    private BigDecimal precoUnitario;
    private Integer qtd;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Item() {

    }

    public Item(Long id, String descricao, BigDecimal precoUnitario, Integer qtd, Pedido pedido) {
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtd = qtd;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(descricao, item.descricao) && Objects.equals(precoUnitario, item.precoUnitario) && Objects.equals(qtd, item.qtd) && Objects.equals(pedido, item.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, precoUnitario, qtd, pedido);
    }
}



