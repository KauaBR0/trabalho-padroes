package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

import java.util.List;

/* CONCRETE ITERATOR EM UM INTERATOR */
public class RepeatAll implements PlayerIterator {

    private final List<Tocavel> tocavels;
    private Integer index;

    public RepeatAll(List<Tocavel> tocavels) {
        this.tocavels = tocavels;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return true;
    }

    @Override
    public Tocavel proximo() {
        if (index >= tocavels.size()) {
            reset();
        }
        Tocavel tocavel = tocavels.get(index);
        index++;
        return tocavel;
    }

    public void reset() {
        this.index = 0;
    }
}