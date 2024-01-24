package br.com.uepb.moviesm.calculator;

import br.com.uepb.moviesm.models.Movie;
// Classe  que realiza filtragem com base em classificação
public class RecommendationFilter {
    private String recommendation;

    // Método que realiza a filtragem com base na classificação do objeto Classifiable
    public void filter(Classifiable classifiable) {
        // Verifica se a classificação é maior ou igual a 4
        if (classifiable.getClassification() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classifiable.getClassification() >= 2) { // Se não, verifica se é maior ou igual a 2
            System.out.println("Está bem avaliado");
        } else {
            // Se não atender a nenhum dos critérios anteriores
            System.out.println("Adicione a lista pra assistir depois");
        }
    }
}
