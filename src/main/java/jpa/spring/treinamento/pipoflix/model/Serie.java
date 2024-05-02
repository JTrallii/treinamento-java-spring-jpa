package jpa.spring.treinamento.pipoflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jpa.spring.treinamento.pipoflix.service.ConsultaChatGPT;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;

    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    //@Transient
    @OneToMany(mappedBy = "serie")
    private List<Episodio> episodios = new ArrayList<>();

    //Nesse momento, será retornado um erro no terminal. O log nos diz que não temos um construtor
    //padrão para a entidade Serie. Uma exigência da JPA é que tenhamos um construtor padrão.
    //A partir da implementação da classe em Java, o construtor padrão é fornecido. Mas a
    //partir do momento que criamos outro construtor, não é mais fornecido. Precisamos explicitar isso.
    //Então, na classe Serie, como tínhamos Serie() baseado em DadosSerie, agora temos que
    //adicionar um construtor padrão também.
    //Para isso, usaremos public Serie(). O construtor padrão é somente isso, sem nenhum
    //parâmetro, seguido de abertura e fechamento de chaves.
    //A JPA exige que tenhamos isso; para conseguir recuperar os dados do banco e
    //representar como um objeto do tipo Serie, precisamos ter o construtor padrão.
    public Serie(){}



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
        this.sinopse = dadosSerie.sinopse();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
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
