package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CatalogoLivros {
    private List<Livro> livros = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T lerJson(String localArquivo, Class<T> clazz) throws IOException {
        File arquivo = new File(localArquivo);
        try (FileReader leitor = new FileReader(arquivo)) {
            return gson.fromJson(leitor, clazz);
        }
    }

    public static <T> void escreverJson(String localArquivo, T objeto) throws IOException {
        File arquivo = new File(localArquivo);
        try (FileWriter escritor = new FileWriter(arquivo)) {
            gson.toJson(objeto, escritor);
        }
    }

    public void adicionarLivro(String localArquivo, Livro livro) throws IOException {
        this.livros.add(livro);
        escreverJson(localArquivo, this);
    }

    public void atualizarCopiasLivro(String localArquivo, String titulo, Integer novasCopias) throws IOException {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setExemplares(novasCopias);
                escreverJson(localArquivo, this);
                return;
            }
        }
        throw new IOException("Livro" + titulo + " não disponivel!");
    }

    public String livrosString() {
        StringBuilder livrosString = new StringBuilder();
        for (Livro livro : livros) {
             livrosString.append(livro.toString());
        }
        return livrosString.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalogo:\n");
        for (Livro livro : livros) {
            sb.append(livro.toString());
        }
        return sb.toString();
    }


}
