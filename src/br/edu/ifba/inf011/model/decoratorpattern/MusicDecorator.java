package br.edu.ifba.inf011.model.decoratorpattern;

/*
DECORATOR EM UM DECORATOR
*/
public abstract class MusicDecorator implements Music {
    protected Music novaMusic;
    public String nome;

    public MusicDecorator(Music novaMusic) {
        this.novaMusic = novaMusic;
    }

    @Override
    public String getNome() {
        return this.novaMusic.getNome();
    }

    @Override
    public String execute() {
        return this.novaMusic.execute();
    }

    @Override
    public void reset() {
        this.novaMusic.reset();
    }

    @Override
    public Boolean isFinished() {
        return this.novaMusic.isFinished();
    }

    @Override
    public String play() {
        return novaMusic.play();
    }

}
