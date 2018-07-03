package Pilhas.Execoes;

public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException() {
        super("A pilha esta vazia");
    }
}
