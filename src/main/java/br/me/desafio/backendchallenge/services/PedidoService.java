package br.me.desafio.backendchallenge.services;

import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

        @Autowired
        private PedidoRepository repository;

        public List<Pedido> findAll() {
            return repository.findAll();

        }

        public Pedido findById(long id) {
            Optional<Pedido> obj = repository.findById(id);
            return obj.get();

        }

        public Pedido save(Pedido pedido) {
            return repository.save(pedido);

        }
}
