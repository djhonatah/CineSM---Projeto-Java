package br.com.uepb.moviesm.main;

import br.com.uepb.moviesm.exception.YearConversionErrorException;
import br.com.uepb.moviesm.models.OmdbTitle;
import br.com.uepb.moviesm.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal MainWithSearch que realiza busca de filmes usando a API OMDB
public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Criação de um Scanner para leitura do console
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Title> titulos = new ArrayList<>();

        // Configuração do Gson para manipulação de JSON
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        // Loop para permitir múltiplas buscas até que o usuário digite "sair"
        while (!busca.equalsIgnoreCase("sair")) {
            // Solicita ao usuário que digite um filme para busca
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            // Verifica se o usuário deseja sair do programa
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            // Construção do URL para consulta na API OMDB
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=ef6562";
            System.out.println(endereco);

            try {
                // Realiza a requisição HTTP para a API OMDB
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Obtém a resposta em formato JSON
                String json = response.body();
                System.out.println(json);

                // Converte o JSON para um objeto OmdbTitle usando Gson
                OmdbTitle meuTituloOmdb = gson.fromJson(json, OmdbTitle.class);
                System.out.println(meuTituloOmdb);

                // Converte o OmdbTitle para um objeto Title
                Title meuTitulo = new Title(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                // Adiciona o título à lista de títulos
                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (YearConversionErrorException e) {
                System.out.println(e.getMessage());
            }
        }

        // Exibe a lista de títulos obtidos
        System.out.println(titulos);

        // Escreve a lista de títulos em um arquivo JSON chamado "filmes.json"
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou corretamente!");
    }
}
