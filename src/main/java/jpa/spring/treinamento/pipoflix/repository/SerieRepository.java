package jpa.spring.treinamento.pipoflix.repository;

import jpa.spring.treinamento.pipoflix.model.Categoria;
import jpa.spring.treinamento.pipoflix.model.Episodio;
import jpa.spring.treinamento.pipoflix.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    //Primeiramente, para compormos o nome deste método, utilizaremos find.
    //Portanto, estamos especificando que o método será chamado de find e
    //seremos responsáveis por buscar informações com base em um critério.
    //Qual será o critério? Queremos realizar a busca pelo nome da série.
    //Na classe Serie.java , o nome da série é definido pelo atributo titulo.
    //O que precisamos fazer? findByTitulo. Precisamos usar exatamente o nome do
    //atributo da classe. Assim, não importa o que está no banco de dados. Pode
    //ser que no banco tenhamos colocado o nome dessa coluna como "nome da série",
    //pode ser diferente, mas para utilizarmos com a JPA, deve ser exatamente o nome do atributo.
    //Estamos nos referindo à aplicação, assim, estamos olhando para a
    //classe Java e não para a tabela do banco de dados.
    //A JPA vai se basear nisso. Portanto, faremos um findByTitulo. Queremos buscar uma série pelo título.
    //No entanto, lembramos que o título contém letras maiúsculas e minúsculas, e, às vezes,
    //não queremos o título completo. Por exemplo, temos "The Last of Us," mas queremos
    //pesquisar apenas por "Last" para verificar se ele encontra para nós.
    //Portanto, o que precisamos fazer é usar um método contains, da mesma forma que fazíamos com streams.
    //Usando o método Containing
    //Neste ponto, realizaremos a verificação se o conjunto de dados contém a palavra-chave que estamos buscando.
    //Usaremos o comandofindByTituloContainingIgnoreCase(). Este comando é insensível a
    //letras maiúsculas e minúsculas, ou seja, ele ignora essa diferença ao realizar a comparação.
    //Vamos passar o nome da série como parâmetro para esta query. Desta forma, a nova estrutura
    //será algo como: findByTituloContainingIgnoreCase(String nomeSerie).
    //Como resultado deste comando, podemos ter duas situações:
    //Encontrar uma série que corresponda à palavra-chave;
    //Não encontrar.
    //Portanto, definimos que o retorno deste método será um Optional de série,
    // Optional<Serie>.

    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);

    //JPQL se refere a Java Persistence Query Language, ou seja, Linguagem de Consulta de Persistência Java.
    //Portanto, é uma linguagem de consulta própria do JPA, do controle de persistência do Java.
    //Escreveremos as consultas de maneira diferente, mas notaremos que fará total sentido, afinal,
    //estaremos trabalhando com classes e atributos.

    //Codigo em JPQL
    //Para indicar que estamos trabalhando com um parâmetro, adicionamos dois pontos antes do totalTemporadas
    //Caso não fosse usar o JPQL, a busca seria dessa forma:
    //select * from series WHERE series.total_temporadas <= 5 AND series.avaliacao >= 7.5 que seria buscado no BD
    @Query("select s from Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaEAvaliacao(int totalTemporadas, double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiosPorSerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> episodiosPorSerieEAno(Serie serie, int anoLancamento);

    @Query("SELECT s FROM Serie s " +
            "JOIN s.episodios e " +
            "GROUP BY s " +
            "ORDER BY MAX(e.dataLancamento) DESC LIMIT 5")
    List<Serie> encontrarEpisodiosMaisRecentes();

}






















