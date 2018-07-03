package exercicio10;

public abstract class ListaAbstract<T> {

    private T[] info;
    private int tamanho;

    public ListaAbstract() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
    public T[] getInfo() {
        return info;
    }

    public ListaAbstract(T... values) {
        this();
        if (values.length <= 10) {
            for (int i = 0; i < values.length; i++) {
                info[i] = values[i];
            }
            tamanho = values.length;
        } else {
            info = (T[]) new Object[values.length];
            tamanho = values.length;
            for (int i = 0; i < values.length; i++) {
                info[i] = values[i];
            }
        }
    }

    protected void redimensionar() {
        T[] aux = info;
        info = (T[]) new Object[info.length + 10];
        for (int i = 0; i < aux.length; i++) {
            info[i] = aux[i];
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }


    public abstract void inserir(T value);

    public void retirar(T value) {                 //todo
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(value)) {
                tamanho--;
                if (i == info.length - 1) {
                    info[i] = null;
                    return;
                } else {
                    for (int z = i; z < tamanho; z++) {
                        info[z] = info[z + 1];
                    }
                    info[tamanho] = null;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Valor nao encontrado");
    }

    public abstract int buscar(T value);

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao > info.length - 1) {
            throw new IndexOutOfBoundsException("Pocisao invalida");
        } else if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Pocisao não ocupada");

        } else {
            return info[posicao];
        }
    }

    @Override
    public String toString() {
        if (tamanho == 0)
            return "";

        StringBuilder result = new StringBuilder(info.length * 2); // assure that string will not resize
        for (int i = 0; i < tamanho; i++) {
            result.append(info[i]).append(",");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    public void exibir() {
        System.out.println("[" + toString().replaceAll(",", "][") + "]");
    }

    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public void inverter() {
        T auxValor;
        for (int i = 0; i < tamanho / 2; i++) {
            auxValor = info[tamanho - i - 1];
            info[tamanho - i - 1] = info[i];
            info[i] = auxValor;
        }
    }
}

