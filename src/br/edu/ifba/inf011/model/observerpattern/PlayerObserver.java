package br.edu.ifba.inf011.model.observerpattern;

import br.edu.ifba.inf011.model.iteratorpattern.Player;

/* PADRÃO OBSERVER*/
public interface PlayerObserver {
    void atualizar(Player player);
}