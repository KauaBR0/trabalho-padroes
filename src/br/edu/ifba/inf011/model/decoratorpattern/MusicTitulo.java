package br.edu.ifba.inf011.model.decoratorpattern;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* LEAF EM UM COMPOSITE*/
/* CONCRETE DECORATOR EM UM DECORATOR*/
public class MusicTitulo implements Music {

    private List<String> linhas;
    private String nome;
    private Integer linha;

    public MusicTitulo(String nome) throws IOException {
        this.nome = nome;
        this.reset();
        this.linhas = Arrays.asList("Tocando Música: " + nome);
    }

    public String getNome() {

        return this.nome;
    }

    public void reset() {
        this.linha = 0;
    }

    public Boolean isFinished() {
        return this.linha >= this.linhas.size();
    }

    public String play() {
        return this.linhas.get(this.linha++);
    }

    public String execute() {
        reset();
        StringBuilder output = new StringBuilder();
        output.append(getNome()).append("\n");
        linha++;
        return output.toString();
    }
}
