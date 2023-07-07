package br.edu.ifba.inf011.model.iteratorpattern;

import br.edu.ifba.inf011.model.compositepattern.Tocavel;

import java.util.List;

public enum PlayerMode{

	PlayerAll {
		@Override
		public PlayerIterator createIterator(List<Tocavel> tocavels) {
			return new PlayerAll(tocavels);
		}
	},
	RandomMode {
		@Override
		public PlayerIterator createIterator(List<Tocavel> tocavels) {
			return new RandomMode(tocavels);
		}
	},
	RepeatAll {
		@Override
		public PlayerIterator createIterator(List<Tocavel> tocavels) {
			return new RepeatAll(tocavels);
		}
	};

	public abstract PlayerIterator createIterator(List<Tocavel> tocavels);
}

