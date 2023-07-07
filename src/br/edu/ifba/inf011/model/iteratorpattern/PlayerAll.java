package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

import java.util.List;

/*CONCRETE ITERATOR EM UM ITERATOR*/
public class PlayerAll implements PlayerIterator {

    private Integer index;
    private final List<Tocavel> tocavels;

    public PlayerAll(List<Tocavel> tocavels) {
        this.tocavels = tocavels;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.tocavels.size();
    }

    @Override
    public Tocavel proximo() {
        if(this.temProximo()) {
            return tocavels.get(index++);
        }
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}