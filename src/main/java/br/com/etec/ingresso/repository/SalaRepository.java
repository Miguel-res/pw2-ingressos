package br.com.etec.ingresso.repository;

import br.com.etec.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
