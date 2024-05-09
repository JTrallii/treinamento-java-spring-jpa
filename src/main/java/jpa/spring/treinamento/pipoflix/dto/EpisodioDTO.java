package jpa.spring.treinamento.pipoflix.dto;

import java.time.LocalDate;

public record EpisodioDTO(Integer numeroTemporada,
        String titulo,
        Integer numeroEpisodio) {
}
