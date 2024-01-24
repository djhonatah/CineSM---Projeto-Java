
package br.com.uepb.moviesm.main;

import br.com.uepb.moviesm.models.Movie;
import br.com.uepb.moviesm.models.Series;
import br.com.uepb.moviesm.models.Title;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainWithLists {
    public static void main(String[] args) {
        // Criando instâncias de Movie e Series
        Movie meuFilme = new Movie("O poderoso chefão", 1970);
        meuFilme.evaluate(9);
        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.evaluate(6);
        var filmeDoPaulo = new Movie("Dogville", 2003);
        filmeDoPaulo.evaluate(10);
        Series lost = new Series("Lost", 2000);

        // Atribuindo uma referência de Movie a f1
        Movie f1 = filmeDoPaulo;

        // Criando uma lista de títulos (Movies e Series)
        ArrayList<Title> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // Iterando sobre a lista e exibindo nomes e classificação dos filmes com classificação maior que 2
        for (Title item : lista) {
            System.out.println(item.getName());
            if (item instanceof Movie filme && filme.getClassification() > 2) {
                System.out.println("Classificação " + filme.getClassification());
            }
        }

        // Criando uma lista de busca por artista
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        // Ordenando a lista de buscaPorArtista e exibindo o resultado
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);

        // Ordenando a lista de títulos e exibindo o resultado
        System.out.println("Lista de títulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        // Ordenando a lista de títulos por ano de lançamento e exibindo o resultado
        lista.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
