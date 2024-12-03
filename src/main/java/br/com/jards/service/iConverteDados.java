package br.com.jards.service;

public interface iConverteDados {
    <T> T oberDados(String json, Class<T> classe);
}
