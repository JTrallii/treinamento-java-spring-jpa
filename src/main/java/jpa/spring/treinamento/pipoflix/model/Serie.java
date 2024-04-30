package jpa.spring.treinamento.pipoflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jpa.spring.treinamento.pipoflix.service.ConsultaChatGPT;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    //Podemos voltar para a classe Serie e começar a modificar os dados recebidos.
    //Primeiramente, criaremos um construtor. Da mesma forma que a classe Episodio
    //recebe DadosEpisodio, agora a classe Serie receberá um objeto DadosSerie.
    //Exatamente, iniciaremos a associação e transformação de valores, pois em DadosSerie,
    //tudo vem em String, e agora já sabemos haver alguns valores que queremos tratar
    //de forma diferente, como avaliacao e genero.

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return
                "Genero = " + genero +
                " Titulo = " + titulo +
                " Total de temporadas = " + totalTemporadas +
                " Avaliações = " + avaliacao +
                " Atores = " + atores +
                " Poster = " + poster +
                " Sinopse = " + sinopse;
    }
}
