package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Filme;
import br.com.etec.ingresso.entity.Sala;
import br.com.etec.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> listar(){

        return salaRepository.findAll();
    }
    List<Long> idsExistentes = List.of(1L, 2L, 3L);

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id){
        var sala1 = salaRepository.findById(id); //Optional<Filme>
        if (sala1.isPresent()) {
            return ResponseEntity.ok(sala1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sala> cadastrar(@RequestBody Sala sala){
        if(sala.getNome().length() > 255){
            return ResponseEntity.badRequest().build();
        }

        if (sala.getPreco() < 5){
            return ResponseEntity.badRequest().build();
        }

        if (sala.getDataExclusao() != null){
            return ResponseEntity.badRequest().build();
        }

        var novaSala = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);

    }

    @PutMapping("/id")
    public ResponseEntity<Sala> atualizar(@RequestBody Sala sala,
                                           @PathVariable Long id){
        var existe = salaRepository.findById(id);

        if(sala.getNome().length() > 255){
            return ResponseEntity.badRequest().build();
        }

        if (sala.getPreco() < 5){
            return ResponseEntity.badRequest().build();
        }

        if (sala.getDataExclusao() != null){
            return ResponseEntity.badRequest().build();
        }

        if (existe.isPresent()) {
            var salaAtualizada = salaRepository.save(sala);
            return ResponseEntity.ok(salaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        var existe = salaRepository.findById(id);
        if (existe.isPresent()) {
            salaRepository.delete(existe.get());
            ResponseEntity.ok().build();
        }
        ResponseEntity.notFound().build();
    }
}

