package br.me.desafio.backendchallenge.entities;

import java.io.Serializable;
import java.util.Objects;

public class Pedido implements Serializable {
    private long id;



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



