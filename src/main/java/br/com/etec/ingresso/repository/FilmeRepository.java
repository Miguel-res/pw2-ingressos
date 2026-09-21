package br.com.etec.ingresso.repository;

import br.com.etec.ingresso.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
