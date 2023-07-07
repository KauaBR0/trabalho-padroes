package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;
import br.edu.ifba.inf011.model.observerpattern.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

/* PUBLISHER EM UM OBSERVER*/
/* CONCRETE ITERATOR EM UM ITERATOR*/
public class Player implements PlayerIterable {

	private List<Tocavel> tocavels;
	private PlayerMode mode;
	private Integer index;
	private List<PlayerObserver> observers;

	public Player() {
		this.observers = new ArrayList<PlayerObserver>();
		this.setMode(PlayerMode.PlayerAll);
		this.tocavels = new ArrayList<Tocavel>();
		this.reset();
	}

	/**
	 * Notifica todos os observadores registrados que o estado do player foi atualizado.
	 */
	private void notifyObservers() {
		for (PlayerObserver observer : observers) {
			observer.atualizar(this);
		}
	}

	public void addObserver(PlayerObserver playerObserver) {
		if(this.observers == null) {
			this.observers = new ArrayList<PlayerObserver>();
		}
		this.observers.add(playerObserver);
	}

	public void add(Tocavel tocavel) {
		this.tocavels.add(tocavel);
	}

	public void reset() {
		this.index = 0;
	}

	public void removerObserver(PlayerObserver playerObserver) {
		this.observers.remove(playerObserver);
	}

	public String getMode(){
		return this.mode.toString();
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
		notifyObservers();
	}

	@Override
	public PlayerIterator createIterator() {
		return this.mode.createIterator(tocavels);
	}
}
