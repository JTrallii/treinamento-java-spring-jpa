package jpa.spring.treinamento.pipoflix.controller;

import jpa.spring.treinamento.pipoflix.dto.EpisodioDTO;
import jpa.spring.treinamento.pipoflix.dto.SerieDTO;
import jpa.spring.treinamento.pipoflix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> encontrarEpisodiosMaisRecentes() {
        return servico.encontrarEpisodiosMaisRecentes();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todos")
    public List<EpisodioDTO> obterTodasAsTemporadas(@PathVariable Long id) {
        return servico.obterTodasAsTemporadas(id);
    }
}





























