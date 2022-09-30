package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.repositories.PedidoRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Pedido> findAll() {
            return repository.findAll();

        }

        public Pedido findById(long id) {
            Optional<Pedido> obj = repository.findById(id);
            return obj.get();

        }

        public Pedido save(Pedido pedido) {
            associaItensApedido(pedido);
            return repository.save(pedido);

        }



    private void associaItensApedido(Pedido pedido) {
        List<Item> itens = pedido.getItens();
        if (itens == null || itens.isEmpty()) {
            throw new ServiceException("Lista de Itens Nula ou Vazia.");
        }
        pedido.setItens(new ArrayList<>());
        for (Item item: itens) {
            validaItem(item);
            pedido.addItem(item);
        }
    }

    private void validaItem(Item item) {
        if (item.getDescricao() == null || item.getDescricao().isEmpty() || item.getDescricao().isBlank()){
            throw new ServiceException("Descrição de Item é inválida!");
        }
        if (item.getPrecoUnitario() == null) {
            throw new ServiceException("Preço de Item é inválido!");
        }
        if (item.getQtd() == null || item.getQtd() < 0 ) {
            throw new ServiceException("Quantidade de item é inválida!");
        }
    }
}
