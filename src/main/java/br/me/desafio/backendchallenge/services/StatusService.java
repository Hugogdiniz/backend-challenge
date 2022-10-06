package br.me.desafio.backendchallenge.services;

import br.me.desafio.backendchallenge.dto.StatusRequestDTO;
import br.me.desafio.backendchallenge.dto.StatusResponseDTO;
import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Pedido;
import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.enums.StatusPedido;
import br.me.desafio.backendchallenge.repositories.PedidoRepository;
import br.me.desafio.backendchallenge.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService implements Serializable {

    @Autowired
    private final PedidoRepository repository;

    public StatusService(PedidoRepository repository) {this.repository = repository; }

    public StatusResponseDTO create(StatusRequestDTO obj) {

        List<StatusPedido> temp = new ArrayList<>();
        Optional<Pedido> obj2 = repository.findById(obj.getId());
        int qtdTotal = 0;
        BigDecimal valorTotal = new BigDecimal(0);

        if (obj2.isEmpty()) {
            temp.add(StatusPedido.CODIGO_PEDIDO_INVALIDO);


        } else {
            Pedido pedido = obj2.get();
            if (obj.getStatus() == StatusPedido.REPROVADO) {
                temp.add(StatusPedido.REPROVADO);
            } else {
                for (Item i : pedido.getItens()) {
                    qtdTotal += i.getQtd();
                    valorTotal = valorTotal.add(i.getPrecoUnitario().multiply(new BigDecimal(i.getQtd())));
                }

                if (obj.getItensAprovados() < qtdTotal) {
                    temp.add(StatusPedido.APROVADO_QTD_A_MENOR);
                }

                if (obj.getItensAprovados() > qtdTotal) {
                    temp.add(StatusPedido.APROVADO_QTD_A_MAIOR);
                }

                if (valorTotal.compareTo(obj.getValorAprovado()) == -1) {

                    temp.add(StatusPedido.APROVADO_VALOR_A_MAIOR);
                }

                if(valorTotal.compareTo(obj.getValorAprovado())== 1) {
                    temp.add(StatusPedido.APROVADO_VALOR_A_MENOR);
                }

                if(obj.getItensAprovados() == qtdTotal && valorTotal.compareTo(obj.getValorAprovado())== 0){
                    temp.add(StatusPedido.APROVADO);
                }
            }





        }

        StatusResponseDTO statusDTO = new StatusResponseDTO(obj.getId(),temp);

        return statusDTO;
    }
}
