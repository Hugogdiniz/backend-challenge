package br.me.desafio.backendchallenge.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Pedido pedido;

    private String descricao;
    private BigDecimal precoUnitario;
    private Integer qtd;

    public Item() {

    }

    public Item(Long id, String descricao, BigDecimal precoUnitario, Integer qtd) {
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtd = qtd;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && descricao.equals(item.descricao) && precoUnitario.equals(item.precoUnitario) && qtd.equals(item.qtd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, precoUnitario, qtd);
    }
}
