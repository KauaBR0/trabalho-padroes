package br.edu.ifba.inf011.model.decoratorpattern;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* LEAF EM UM COMPOSITE*/
/* CONCRETE DECORATOR EM UM DECORATOR*/
public class MusicNotas extends MusicDecorator {
	
	private List<String> notas;
	private String nome;
	private int linha;

	public MusicNotas(Music novaMusic) throws IOException {
		super(novaMusic);
		this.nome = novaMusic.getNome();
		this.notas = ResourceLoader.instance().loadNotas(nome);
		this.reset();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		 this.linha = 0;
		novaMusic.reset();
	}

	public Boolean isFinished() {
		return this.linha >= this.notas.size();
	}

	public String play() {
		String output = this.notas.get(this.linha++);
		if (!novaMusic.isFinished()) {
			output = novaMusic.play() + "\n" + output;
		}
		return output;
	}

	public void setAcordes(List<String> acordes) {
		this.notas = acordes;
	}

	public String execute() {
		reset();
		StringBuilder output = new StringBuilder();
		while (!isFinished()) {
			output.append(play()).append("\n");
		}
		return output.toString();
	}
}
