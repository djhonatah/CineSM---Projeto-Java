package br.com.uepb.moviesm.models;

import br.com.uepb.moviesm.exception.YearConversionErrorException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    // Atributos da classe Title
    private String name;              // Nome do título
    private int releaseYear;          // Ano de lançamento do título
    private double sumOfRatings;      // Soma das avaliações do título
    private int totalRatings;         // Número total de avaliações do título
    private int durationInMinutes;    // Duração do título em minutos

    // Construtor
    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    // Construtor que recebe um objeto OmdbTitle para criar um título a partir da resposta da API OMDB
    public Title(OmdbTitle myOmdbTitle) {
        this.name = myOmdbTitle.title();

        // Verifica se o ano tem mais de 4 caracteres e lança uma exceção em caso afirmativo
        if (myOmdbTitle.year().length() > 4) {
            throw new YearConversionErrorException("Não foi possível converter o ano, pois tem mais de 4 caracteres");
        }
        // Converte o ano e a duração para inteiros a partir do formato fornecido pela API OMDB
        this.releaseYear = Integer.parseInt(myOmdbTitle.year());
        this.durationInMinutes = Integer.parseInt(myOmdbTitle.runtime().substring(0, 3));
    }

    // Método getter para obter a soma das avaliações do título
    public double getSumOfRatings() {
        return sumOfRatings;
    }

    // Método getter para obter o número total de avaliações do título
    public int getTotalRatings() {
        return totalRatings;
    }

    // Método getter para obter o nome do título
    public String getName() {
        return name;
    }

    // Método getter para obter o ano de lançamento do título
    public int getReleaseYear() {
        return releaseYear;
    }

    // Método getter para obter a duração do título em minutos
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    // Método setter para definir o nome do título
    public void setName(String name) {
        this.name = name;
    }

    // Método setter para definir o ano de lançamento do título
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    // Método setter para definir a duração do título em minutos
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    // Método para exibir a ficha técnica do título
    public void displaysTechnicalSheet() {
        System.out.println("Nome do filme: " + name);
        System.out.println("Ano de Lançamento: " + releaseYear);
    }

    // Método para avaliar o título, recebendo uma nota e atualizando a soma e o número total de avaliações
    public void evaluate(double note) {
        sumOfRatings += note;
        totalRatings++;
    }

    // Método para calcular a média das avaliações do título
    public double averageReviews() {
        return sumOfRatings / totalRatings;
    }

    // Implementação do método compareTo da interface Comparable para permitir a comparação de títulos
    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    // Sobrescrita do método toString para fornecer uma representação em string do objeto Title
    @Override
    public String toString() {
        return "name: " + name +
                ", releaseYear:" + releaseYear +
                ", duration in minutes: " + durationInMinutes +
                '}';
    }
}
