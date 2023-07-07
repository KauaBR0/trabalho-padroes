package br.edu.ifba.inf011;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.edu.ifba.inf011.model.decoratorpattern.*;
import br.edu.ifba.inf011.model.iteratorpattern.Player;
import br.edu.ifba.inf011.model.compositepattern.Playlist;
import br.edu.ifba.inf011.model.iteratorpattern.PlayerMode;
import br.edu.ifba.inf011.model.iteratorpattern.PlayerIterator;
import br.edu.ifba.inf011.model.observerpattern.PlayerObserver;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao implements PlayerObserver {

	private final Player player;

	public Aplicacao() {
		this.player = new Player();
		this.player.addObserver(this);
	}

	private void teste() throws IOException, InterruptedException {
		ResourceLoader resource = ResourceLoader.instance();

		Music music =  resource.comLetraCifra("Lullaby");
		Music music2 =  resource.ComLetraCifraTraducao("GodSaveTheQueen", "pt");
		Music music3 =  resource.ComLetraTraducao("ReelAroundFountain", "pt");
		Music music4 =  resource.ComCifra("GodSaveTheQueen");


		Playlist playlist = new Playlist("Teste");

		playlist.add(music2);
		playlist.add(music4);

		player.add(playlist);
		player.add(music);
		player.add(music3);

		PlayerIterator iterator = player.createIterator();

		/*Decide o modo que será usado*/
		while (iterator.temProximo()) {
			System.out.println(iterator.proximo().execute());
			Thread.sleep(1000);

			int randomNumber = new Random().nextInt(1, 101);
			if (randomNumber <= 20) {
				player.setMode(PlayerMode.RepeatAll);
				iterator = player.createIterator();
			} else if (randomNumber <= 35) {
				player.setMode(PlayerMode.RandomMode);
				iterator = player.createIterator();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Aplicacao aplicacao = new Aplicacao();
		aplicacao.teste();
	}

	@Override
	public void atualizar(Player player) {
		System.out.printf("Tocando no modo:" + player.getMode() + " \n");
	}
}
