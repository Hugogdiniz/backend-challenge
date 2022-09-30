package br.me.desafio.backendchallenge.controllers;

import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido pedidoEncontrado = service.findById(id);
        return ResponseEntity.ok().body(pedidoEncontrado);

    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido save(@RequestBody Pedido pedido) {
        return service.save(pedido);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
         service.delete(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido = service.update(id, pedido);
        return ResponseEntity.ok().body(pedido);

    }
}
