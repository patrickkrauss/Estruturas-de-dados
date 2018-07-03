package Filas.FilaVetor;

import Filas.Execoes.FilaCheiaException;
import Filas.Execoes.FilaVaziaException;
import Filas.Fila;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        info = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite)
            throw new FilaCheiaException();
        int pocisaoInsercao = (inicio + tamanho) % limite;
        info[pocisaoInsercao] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new FilaVaziaException();
        return info[inicio];
    }

    @Override
    public T retirar() {
        T removedItem = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return removedItem;
    }

    @Override
    public void liberar() {
        for (int i = 0; i < tamanho; i++) {
            info[i] = null;
        }
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "";
        StringBuilder result = new StringBuilder(tamanho * 2);

        int cont = tamanho;
        int poc = inicio;
        while (cont > 0) {
            result.append(info[poc]);
            result.append(",");
            if (poc > limite)
                poc = 0;
            poc++;
            cont--;
        }

        return result.toString().substring(0,result.length()-1);
    }

    public FilaVetor criarFilaContatenada(FilaVetor<T> f2) {
        FilaVetor<T> novaFila = new FilaVetor<>(limite + f2.limite);
        StringBuilder values = new StringBuilder((limite + f2.limite) * 2);
        values.append(toString());
        values.append(',');
        values.append(f2.toString());
        String[] arrayOfValues = values.toString().split(",");
        for (String s : arrayOfValues) {
            novaFila.inserir((T) s);
        }
        return novaFila;
    }

    public void encolher(){
        String[] valores = toString().split(",");

    }
}
