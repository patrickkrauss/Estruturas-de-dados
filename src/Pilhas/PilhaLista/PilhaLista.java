package Pilhas.PilhaLista;


import Pilhas.Execoes.PilhaVaziaException;
import Pilhas.Pilha;
import Pilhas.PilhaLista.ListaEncadeada.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T removedItem = peek();
        lista.retirar(removedItem);

        return removedItem;
    }

    @Override
    public T peek() {
        if (lista.estaVazia())
            throw new PilhaVaziaException();
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
