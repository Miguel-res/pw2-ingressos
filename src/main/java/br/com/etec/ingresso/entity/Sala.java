package br.com.etec.ingresso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBL_SALA")
public class Sala {
    @Id
    @Column(name = "ID_SALA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "NR_PRECO")
    private double preco;

    @Column(name = "DT_EXCLUSAO")
    private LocalDateTime dataExclusao;
}
