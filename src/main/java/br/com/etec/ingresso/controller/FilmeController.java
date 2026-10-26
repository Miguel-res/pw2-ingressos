package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Filme;
import br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etec.ingresso.enums.SimNaoEnum;
import br.com.etec.ingresso.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listar(){

        return filmeRepository.findAll();
    }
    List<Long> idsExistentes = List.of(1L, 2L, 3L);

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        var filme1 = filmeRepository.findById(id); //Optional<Filme>
        if (filme1.isPresent()) {
            return ResponseEntity.ok(filme1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme){
        var novoFilme = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme,
                           @PathVariable Long id){
        var existe = filmeRepository.findById(id);
        if (existe.isPresent()) {
            var filmeAtualizado = filmeRepository.save(filme);
            return ResponseEntity.ok(filmeAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        var existe = filmeRepository.findById(id);
        if (existe.isPresent()) {
            filmeRepository.delete(existe.get());
            ResponseEntity.ok().build();
        }
        ResponseEntity.notFound().build();
    }
}
