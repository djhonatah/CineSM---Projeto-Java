package br.com.uepb.moviesm.models;

import br.com.uepb.moviesm.calculator.Classifiable;

// Classe Episode que representa um episódio de uma série
public class Episode implements Classifiable {
    // Atributos da classe Episode
    private int number;          // Número do episódio
    private String name;         // Nome do episódio
    private Series series;       // Série à qual o episódio pertence
    private int totalViews;      // Número total de visualizações do episódio

    // Método getter para obter o número total de visualizações do episódio
    public int getTotalViews() {
        return totalViews;
    }

    // Método setter para definir o número total de visualizações do episódio
    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    // Método getter para obter o número do episódio
    public int getNumber() {
        return number;
    }

    // Método setter para definir o número do episódio
    public void setNumber(int number) {
        this.number = number;
    }

    // Método getter para obter o nome do episódio
    public String getNome() {
        return name;
    }

    // Método setter para definir o nome do episódio
    public void setNome(String nome) {
        this.name = nome;
    }

    // Método getter para obter a série à qual o episódio pertence
    public Series getSeries() {
        return series;
    }

    // Método setter para definir a série à qual o episódio pertence
    public void setSeries(Series series) {
        this.series = series;
    }

    // Implementação do método da interface Classifiable para obter a classificação do episódio
    @Override
    public int getClassification() {
        // Atribui uma classificação de 4 se o número total de visualizações for maior que 100, caso contrário, atribui 2
        if (totalViews > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
