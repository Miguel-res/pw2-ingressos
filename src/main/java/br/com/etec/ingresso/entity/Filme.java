package br.com.etec.ingresso.entity;

import br.com.etec.ingresso.enums.CategoriaFilmeEnum;
import br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etec.ingresso.enums.SimNaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor

public class Filme {
    private Long id;
    private String nome;
    private Integer duracao;
    private CategoriaFilmeEnum categoria;
    private ClassificacaoIndicativaEnum classificacao;
    private Integer ano;
    private String capa;
    private String diretor;
    private String elenco;
    private String descricao;
    private Double avaliacao;
    private SimNaoEnum emCartaz;
    private LocalDateTime dataExclusao;
}
