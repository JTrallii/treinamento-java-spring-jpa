package jpa.spring.treinamento.pipoflix.model;


public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance" , "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    AVENTURA("Adventure", "Aventura"),
    TERROR("Horror", "Terror"),
    CRIME("Crime", "Crime");

    private String categoriaOmdb;

    private String  categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    //O funcionamento é simples: se o OMDB retornar a palavra "Action", consideramos isso como ACAO;
    //se retornar "Comedy", consideramos isso como COMEDIA.
    //Ou seja, esse método vai interpretar dinamicamente o valor textual vindo do OMDB e irá converter
    //na nossa categoria de enum
    //Podemos observar que se trata de um método estático que percorrerá nossa lista de constantes e,
    //para cada uma delas, se o texto correspondente for igual à categoria do OMDB, ele associará à nossa categoria.

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }


}

