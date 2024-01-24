package br.com.uepb.moviesm.calculator;

public interface Classifiable {
     // Método que retorna a classificação do objeto.
     default int getClassification() {
          return 0;
     }
}
