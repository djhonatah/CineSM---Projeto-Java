package br.com.uepb.moviesm.exception;

public class YearConversionErrorException extends RuntimeException {
    // Atributo para armazenar a mensagem de erro
    private String message;
    // Construtor que recebe uma mensagem de erro ao instanciar a exceção
    public YearConversionErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
