package br.me.desafio.backendchallenge.repositories;

import br.me.desafio.backendchallenge.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

}
