package jpa.spring.treinamento.pipoflix.dto;
import jpa.spring.treinamento.pipoflix.model.Categoria;

public record SerieDTO(Long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String atores,
                       String poster,
                       String sinopse) {
}
