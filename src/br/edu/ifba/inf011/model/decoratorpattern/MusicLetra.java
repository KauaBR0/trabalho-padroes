package br.edu.ifba.inf011.model.decoratorpattern;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

/*
LEAF EM UM COMPOSITE
CONCRETE DECORATOR EM UM DECORATOR
 */
public class MusicLetra extends MusicDecorator {

    private List<String> letra;
    private String nome;
    private Integer linha;

    public MusicLetra(Music novaMusic) throws IOException {
        super(novaMusic);
        this.nome = novaMusic.getNome();
        this.letra = ResourceLoader.instance().loadLetra(nome);
        this.reset();
    }

    public String getNome() {
        return this.nome;
    }

    public Boolean isFinished() {
        return this.linha >= this.letra.size();
    }

    public String play() {
        String output = this.letra.get(this.linha++);
        if (!novaMusic.isFinished()) {
            output = novaMusic.play() + "\n" + output;
        }
        return output;
    }

    public void reset() {
        this.linha = 0;
        novaMusic.reset();
    }

    public void setAcordes(List<String> acordes) {
        this.letra = acordes;
    }

    public String execute() {
        this.reset();
        StringBuffer str = new StringBuffer();
        while(!this.isFinished()){
            str.append(this.play() + "\n");
        }
        return str.toString();
    }
}
