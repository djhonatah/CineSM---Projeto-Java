// Declaração do pacote para a classe Movie
package br.com.uepb.moviesm.models;

// Importação da interface Classifiable do pacote br.com.uepb.moviesm.calculator
import br.com.uepb.moviesm.calculator.Classifiable;

// Classe Movie que representa um filme e estende a classe Title e implementa a interface Classifiable
public class Movie extends Title implements Classifiable {
    // Atributo adicional específico da classe Movie
    private String director;

    // Construtor que chama o construtor da classe Title usando a palavra-chave "super"
    public Movie(String name, int releaseYear) {
        super(name, releaseYear);
    }

    // Método getter para obter o diretor do filme
    public String getDirector() {
        return director;
    }

    // Método setter para definir o diretor do filme
    public void setDirector(String director) {
        this.director = director;
    }

    // Implementação do método da interface Classifiable para obter a classificação do filme
    @Override
    public int getClassification() {
        // Calcula a classificação dividindo a média das avaliações por 2 e convertendo para inteiro
        return (int) averageReviews() / 2;
    }

    // Sobrescrita do método toString para fornecer uma representação em string do objeto Movie
    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}
