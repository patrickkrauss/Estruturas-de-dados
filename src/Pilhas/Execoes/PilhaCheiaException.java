package Pilhas.Execoes;

public class PilhaCheiaException extends RuntimeException {

    public PilhaCheiaException(){
        super("A pilha esta cheia");
    }
}
