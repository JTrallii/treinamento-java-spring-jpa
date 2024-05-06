package jpa.spring.treinamento.pipoflix.model;


public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    AVENTURA("Adventure"),
    TERROR("Horror"),
    CRIME("Crime");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
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


}

