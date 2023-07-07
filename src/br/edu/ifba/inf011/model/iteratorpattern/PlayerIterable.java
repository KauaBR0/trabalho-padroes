package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

/* COLLECTION EM UM ITERATOR */
public interface PlayerIterable {
    void add(Tocavel item);
    PlayerIterator createIterator();
}
