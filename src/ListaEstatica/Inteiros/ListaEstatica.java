package ListaEstatica.Inteiros;

public class ListaEstatica {

    public int[] info;
    public int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    public ListaEstatica(int... values) {
        this();
        if (values.length <= 10) {
            for (int i = 0; i < values.length; i++) {
                info[i] = values[i];
            }
            tamanho = values.length;
        } else {
            info = new int[values.length];
            tamanho = values.length;
            for (int i = 0; i < values.length; i++) {
                info[i] = values[i];
            }
        }
    }

    private void redimensionar() {
        int[] aux = info;
        info = new int[info.length + 10];
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


    public void inserir(int value) {
        if (tamanho == info.length) {
            redimensionar();
            info[tamanho] = value;
            tamanho++;
        } else {
            info[tamanho] = value;
            tamanho++;
        }
    }

    public void retirar(int value) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == value) {
                tamanho--;
                if (i == info.length - 1) {
                    info[i] = 0;
                    return;
                } else {
                    for (int z = i; z < tamanho; z++) {
                        info[z] = info[z + 1];
                    }
                    info[tamanho] = 0;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Value not found");
    }

    public int buscar(int value) {
        for (int i = 0; i < info.length; i++) {
            if (value == info[i])
                return i;
        }
        return -1;
    }

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao > info.length - 1) {
            throw new IndexOutOfBoundsException("Pocisao invalida");
        } else if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Pocisao não ocupada");

        } else {
            return info[posicao];
        }
    }

    public void inserirOrdenado(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if ((valor >= info[i] & valor <= info[i + 1]) || valor <= info[i]) {
                if (tamanho - info.length == 0) {
                    redimensionar();
                    for (int z = i; z < tamanho; z++) {
                        info[z] = info[z + 1];
                    }
                } else {
                    info[i] = valor;
                    for (int a = i + 2; a < tamanho; a++) {
                        info[a] = info[a + 1];
                    }
                    tamanho++;
                }

                return;
            }

        }
        inserir(valor);

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
        info = new int[10];
        tamanho = 0;
    }

}

