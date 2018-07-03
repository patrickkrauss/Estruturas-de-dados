package Pilhas.PilhaVetor;

import Pilhas.Execoes.PilhaCheiaException;
import Pilhas.Execoes.PilhaVaziaException;
import Pilhas.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public void push(T value) {
        if (tamanho == limite)
            throw new PilhaCheiaException();
        this.info[tamanho] = value;
        tamanho++;
    }

    @Override
    public T pop() {
        T removedItem = peek();
        info[tamanho-1] = null;
        tamanho--;
        return removedItem;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new PilhaVaziaException();
        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        for (int i = 0; i < tamanho; i++) {
            info[i] = null;
        }
        tamanho = 0;
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "";
        StringBuilder result = new StringBuilder(tamanho * 2);
        for (int i = tamanho - 1; i >= 0; i--) {
            result.append(info[i]);
            result.append(",");
        }
        return result.toString().substring(0,result.length()-1);
    }

    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i < p.tamanho; i++) {
            push(p.info[i]);
        }
    }
}
