package br.com.uepb.moviesm.models;

public record OmdbTitle(String title, String year, String runtime) {
    // Um record automaticamente gera métodos equals(), hashCode() e toString()
    // Além de métodos getters para cada atributo (title, year, runtime)
}
