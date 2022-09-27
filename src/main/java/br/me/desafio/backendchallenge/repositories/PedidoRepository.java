package br.me.desafio.backendchallenge.repositories;

import br.me.desafio.backendchallenge.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
