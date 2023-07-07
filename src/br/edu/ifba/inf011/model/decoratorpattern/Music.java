package br.edu.ifba.inf011.model.decoratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

/*
COMPONENTE EM UM DECORETOR
 */
public interface Music extends Tocavel {
	String getNome();
	void reset();
	Boolean isFinished();
	String play();
}
