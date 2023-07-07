package br.edu.ifba.inf011.model.compositepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
COMPONENTE em um COMPOSITE
*/
public class Playlist implements Tocavel {

	private String nome;
	private List<Tocavel> tocavels;

	public Playlist(String nome) {
		this.nome = nome;
		this.tocavels = new ArrayList<>();
	}

	public void add(Tocavel tocavel) {
		this.tocavels.add(tocavel);
	}

	public String getNome() {
		return this.nome;
	}

	public Tocavel randomize() {
		List<Tocavel> allTocavels = getAllTocaveis();
		int randomIndex = new Random().nextInt(allTocavels.size());
		return allTocavels.get(randomIndex);
	}

	public String execute() {
		StringBuilder output = new StringBuilder();
		output.append("Tocando playlist: ").append(this.nome).append(" ").append("\n");
		for (Tocavel tocavel : this.tocavels) {
			output.append(tocavel.execute()).append("\n");
		}
		return output.toString();
	}

	private List<Tocavel> getAllTocaveis() {
		List<Tocavel> allTocavels = new ArrayList<>();
		for (Tocavel tocavel : this.tocavels) {
			if (tocavel instanceof Playlist) {
				allTocavels.addAll(((Playlist) tocavel).getAllTocaveis());
			} else {
				allTocavels.add(tocavel);
			}
		}
		return allTocavels;
	}
}