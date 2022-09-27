package br.me.desafio.backendchallenge.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Pedido implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    // private List<Item> itens;
    // private StatusPedido status;


    public Pedido() {
    }

    public Pedido(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



