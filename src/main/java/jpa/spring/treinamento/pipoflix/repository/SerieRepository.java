package jpa.spring.treinamento.pipoflix.repository;

import jpa.spring.treinamento.pipoflix.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
