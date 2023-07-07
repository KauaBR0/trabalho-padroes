package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;
import br.edu.ifba.inf011.model.compositepattern.Playlist;

import java.util.List;
import java.util.Random;

/* CONCRETE ITERATOR EM UM INTERATOR */
public class RandomMode implements PlayerIterator {

    private final Random random;
    private final List<Tocavel> tocavels;

    public RandomMode(List<Tocavel> tocavels) {
        this.tocavels = tocavels;
        this.random = new Random();
    }

    @Override
    public Tocavel proximo() {
        Tocavel playlistItem = tocavels.get(proximoRandom());
        if (playlistItem instanceof Playlist) {
            return ((Playlist) playlistItem).randomize();
        }
        return playlistItem;
    }

    @Override
    public boolean temProximo() {
        return true;
    }

    private int proximoRandom() {
        return random.nextInt(this.tocavels.size());
    }
}