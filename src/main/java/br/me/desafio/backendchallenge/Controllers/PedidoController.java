package br.me.desafio.backendchallenge.Controllers;

import br.me.desafio.backendchallenge.entities.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Pedido")
public class PedidoController {

    @GetMapping
    public ResponseEntity<Pedido> findAll() {
        Pedido p = new Pedido(1L);
        return ResponseEntity.ok().body(p);
    }
}
