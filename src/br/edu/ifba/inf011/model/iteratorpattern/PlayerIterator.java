package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

/*ITERATOR INTERFACE EM UM ITERATOR*/

public interface PlayerIterator {

    boolean temProximo();

    Tocavel proximo();
}
