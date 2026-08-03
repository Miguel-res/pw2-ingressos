package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Filme;
import br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etec.ingresso.enums.SimNaoEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @GetMapping
    public List<Filme> listar(){
        Filme filme1 = Filme.builder()
                .id(1L)
                .nome("Matrix")
                .classificacao(ClassificacaoIndicativaEnum.A16)
                .emCartaz(SimNaoEnum.S)
                .build();
        return List.of(filme1);
    }
}
