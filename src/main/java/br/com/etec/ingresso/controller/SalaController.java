package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Sala;
import br.com.etec.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> listar(){

        return salaRepository.findAll();
    }
    List<Long> idsExistentes = List.of(1L, 2L, 3L);
}
