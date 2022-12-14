package br.me.desafio.backendchallenge.services;

import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.repositories.PedidoRepository;
import br.me.desafio.backendchallenge.services.exceptions.DatabaseException;
import br.me.desafio.backendchallenge.services.exceptions.ResourceNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    @Autowired
    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }


    public Pedido save(Pedido pedido) {
            associaItensApedido(pedido);
            return repository.save(pedido);
    }

    public List<Pedido> findAll() {
        return repository.findAll();

    }

    public Pedido findById(String id) {
        Optional<Pedido> pedidoLocalizado = repository.findById(id);
        return pedidoLocalizado.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void delete (String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }


    }

    public Pedido update(String id, Pedido pedido) {
        try {
            Pedido entity = repository.getReferenceById(id);
            updateData(entity, pedido);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }


    }

    private void updateData(Pedido entity, Pedido pedido) {
        entity.getItens().clear();
        for (Item iten : pedido.getItens()) {
            iten.setPedido(entity);
        }
        entity.getItens().addAll(pedido.getItens());
    }


    private void associaItensApedido(Pedido pedido) {
        List<Item> itens = pedido.getItens();
        if (itens == null || itens.isEmpty()) {
            throw new ServiceException("Lista de Itens Nula ou Vazia.");
        }
        pedido.setItens(new ArrayList<>());
        for (Item item: itens) {
            pedido.addItem(item);
        }
    }
}
