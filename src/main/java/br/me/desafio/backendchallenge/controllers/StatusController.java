package br.me.desafio.backendchallenge.controllers;

import br.me.desafio.backendchallenge.dto.StatusRequestDTO;
import br.me.desafio.backendchallenge.dto.StatusResponseDTO;
import br.me.desafio.backendchallenge.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusResponseDTO create(@RequestBody StatusRequestDTO statusDTO) {
            StatusResponseDTO obj = service.create(statusDTO);
        return obj;

    }

}

