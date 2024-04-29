package jpa.spring.treinamento.pipoflix.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
