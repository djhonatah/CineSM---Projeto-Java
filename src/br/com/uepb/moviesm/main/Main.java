package br.com.uepb.moviesm.main;

import br.com.uepb.moviesm.calculator.RecommendationFilter;
import br.com.uepb.moviesm.calculator.TimeCalculator;
import br.com.uepb.moviesm.models.Episode;
import br.com.uepb.moviesm.models.Movie;
import br.com.uepb.moviesm.models.Series;
import br.com.uepb.moviesm.user.user;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criando Usuarios
        user Usuario1 = new user();
        Usuario1.adicionarUsuario("Leon","0001"); // Adicionando usuário "Leon" com senha "0001"
        user Usuario2 = new user();
        Usuario2.adicionarUsuario("AA","00"); // Adicionando usuário "AA" com senha "00"

        // Autenticando Usuarios
        System.out.println("Autenticação: " + Usuario1.autenticarUsuario("Leon","0001")); // Autenticando usuário "Leon" com senha "0001"
        System.out.println("Autenticação: " + Usuario1.autenticarUsuario("Leon","0002")); // Tentativa de autenticação falha para o usuário "Leon" com senha "0002"
        System.out.println("Autenticação: " + Usuario2.autenticarUsuario("AA","00")); // Autenticando usuário "AA" com senha "00"
        System.out.println("Autenticação: " + Usuario2.autenticarUsuario("AA","000")); // Tentativa de autenticação falha para o usuário "AA" com senha "000"

        // Criando filmes e séries
        Movie harryPotter1 = new Movie("Harry Potter e a Pedra Filosofal", 2001);
        harryPotter1.setDurationInMinutes(152); // Definindo a duração do filme "Harry Potter e a Pedra Filosofal"

        Series lost = new Series("Lost", 2000);
        lost.setSeasons(10); // Definindo o número de temporadas da série "Lost"
        lost.setEpisodesPerSeasons(10); // Definindo o número de episódios por temporada da série "Lost"
        lost.setMinutesPerEpisode(50); // Definindo a duração de cada episódio da série "Lost"

        Movie avatar1 = new Movie("Avatar", 2023);
        avatar1.setDurationInMinutes(200); // Definindo a duração do filme "Avatar"

        // Exibindo informações
        System.out.println("----- Informações sobre Harry Potter 1 -----");
        System.out.println("Duração do filme: " + harryPotter1.getDurationInMinutes()); // Exibindo a duração do filme "Harry Potter e a Pedra Filosofal"
        harryPotter1.displaysTechnicalSheet(); // Exibindo a ficha técnica do filme "Harry Potter e a Pedra Filosofal"
        harryPotter1.evaluate(8); // Avaliando o filme "Harry Potter e a Pedra Filosofal" com nota 8
        harryPotter1.evaluate(5); // Avaliando o filme "Harry Potter e a Pedra Filosofal" com nota 5
        harryPotter1.evaluate(10); // Avaliando o filme "Harry Potter e a Pedra Filosofal" com nota 10
        System.out.println("Total de avaliações: " + harryPotter1.getTotalRatings()); // Exibindo o total de avaliações do filme "Harry Potter e a Pedra Filosofal"
        System.out.println("Média Avaliações: " + harryPotter1.averageReviews()); // Exibindo a média das avaliações do filme "Harry Potter e a Pedra Filosofal"
        System.out.println("\n");

        System.out.println("----- Informações sobre Lost -----");
        lost.displaysTechnicalSheet(); // Exibindo a ficha técnica da série "Lost"
        System.out.println("Duração para maratonar Lost: " + lost.getDurationInMinutes()); // Exibindo a duração total para maratonar a série "Lost"
        System.out.println("\n");

        System.out.println("----- Informações sobre Avatar 1 -----");
        System.out.println("Duração do filme: " + avatar1.getDurationInMinutes()); // Exibindo a duração do filme "Avatar"
        System.out.println("\n");

        System.out.println("----- Tempo total para maratonar todos -----");
        TimeCalculator calculadora = new TimeCalculator();
        calculadora.inclui(harryPotter1); // Incluindo o filme "Harry Potter e a Pedra Filosofal" na lista para maratonar
        calculadora.inclui(avatar1); // Incluindo o filme "Avatar" na lista para maratonar
        calculadora.inclui(lost); // Incluindo a série "Lost" na lista para maratonar
        System.out.println("Total de Tempo pra maratonar todos: " + calculadora.getTotalTime()); // Exibindo o tempo total para maratonar todos os filmes e séries incluídos
        System.out.println("\n");

        System.out.println("----- Recomendação para Harry Potter 1 -----");
        RecommendationFilter filtro = new RecommendationFilter();
        System.out.print("Recomendacao " + harryPotter1.getName() + ":");
        filtro.filter(harryPotter1); // Filtrando recomendações para o filme "Harry Potter e a Pedra Filosofal"
        System.out.println("\n");

        System.out.println("----- Informações sobre o episódio de Lost -----");
        Episode episodio = new Episode();
        episodio.setNumber(1); // Definindo o número do episódio
        episodio.setSeries(lost); // Associando o episódio à série "Lost"
        episodio.setTotalViews(300); // Definindo o total de visualizações do episódio
        filtro.filter(episodio); // Filtrando recomendações para o episódio
        System.out.println("\n");

        // Criando e avaliando um filme
        System.out.println("----- Informações sobre Hulk -----");
        var filmeArthur = new Movie("Hulk", 2003);
        filmeArthur.setDurationInMinutes(200); // Definindo a duração do filme "Hulk"
        filmeArthur.evaluate(10); // Avaliando o filme "Hulk" com nota 10
        System.out.println("\n");

        // Trabalhando com uma lista de filmes
        System.out.println("----- Informações sobre Lista de Filmes -----");
        ArrayList<Movie> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeArthur); // Adicionando o filme "Hulk" à lista de filmes
        listaDeFilmes.add(harryPotter1); // Adicionando o filme "Harry Potter e a Pedra Filosofal" à lista de filmes
        listaDeFilmes.add(avatar1); // Adicionando o filme "Avatar" à lista de filmes
        System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size()); // Exibindo o tamanho da lista de filmes
    }
}
