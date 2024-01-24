package br.com.uepb.moviesm.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class user {
    // Constantes para o diretório e o arquivo de usuários
    private static final String DIRETORIO_USUARIOS = "usuarios/";
    private static final String ARQUIVO_USUARIOS = DIRETORIO_USUARIOS + "usuarios.txt";
    // Mapa para armazenar os usuários e suas senhas
    private Map<String, String> usuarios;

    // Construtor
    public user() {
        this.usuarios = new HashMap<>();
        carregarUsuarios();
    }

    // Método para adicionar um novo usuário
    public boolean adicionarUsuario(String nome, String senha) {
        // Verifica se o usuário já existe
        if (!usuarios.containsKey(nome)) {
            // Adiciona o usuário ao mapa
            usuarios.put(nome, senha);
            // Cria o arquivo correspondente ao usuário
            criarArquivoUsuario(nome);
            // Salva a lista de usuários no arquivo
            salvarUsuarios();
            return true;
        }
        return false;
    }

    // Método para autenticar um usuário
    public boolean autenticarUsuario(String nome, String senha) {
        return usuarios.containsKey(nome) && usuarios.get(nome).equals(senha);
    }

    // Método privado para criar o arquivo correspondente ao usuário
    private void criarArquivoUsuario(String nomeUsuario) {
        // Caminho do arquivo do usuário
        String nomeArquivo = DIRETORIO_USUARIOS + nomeUsuario + ".txt";
        try {
            // Criação do diretório se não existir
            File diretorio = new File(DIRETORIO_USUARIOS);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            // Criação do arquivo do usuário
            File arquivo = new File(nomeArquivo);
            if (arquivo.createNewFile()) {
                // Escreve algo no arquivo (exemplo: uma saudação)
                FileWriter writer = new FileWriter(arquivo);
                writer.write("Olá, " + nomeUsuario);
                writer.close();
            } else {
                System.out.println("Arquivo do usuário já existe: " + nomeArquivo);
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo do usuário: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    // Método privado para carregar os usuários do arquivo
    private void carregarUsuarios() {
        // Verifica se o arquivo de usuários existe
        File arquivoUsuarios = new File(ARQUIVO_USUARIOS);
        if (!arquivoUsuarios.exists()) {
            System.out.println("Arquivo de usuários não encontrado: " + ARQUIVO_USUARIOS);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuarios))) {
            String linha;
            // Lê cada linha do arquivo e adiciona ao mapa de usuários
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    usuarios.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários do arquivo: " + ARQUIVO_USUARIOS);
            e.printStackTrace();
        }
    }

    // Método privado para salvar os usuários no arquivo
    private void salvarUsuarios() {
        // Cria o arquivo de usuários
        File arquivoUsuarios = new File(ARQUIVO_USUARIOS);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoUsuarios))) {
            // Escreve cada usuário no arquivo
            for (Map.Entry<String, String> entry : usuarios.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuários no arquivo: " + ARQUIVO_USUARIOS);
            e.printStackTrace();
        }
    }
}
