package exercicio10;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T value) {
        Object[] info = getInfo();
        if (getTamanho() == info.length) {
            redimensionar();
        }
        info = getInfo();

        for (int i = 0; i <= getTamanho(); i++) {
            if (info[i] == null) {
                info[i] = value;
            } else {
                if (value.compareTo((T) info[i]) <= 0) {
                    for (int j = getTamanho() - 1; j >= i; j--) {
                        info[j + 1] = info[j];
                    }
                    info[i] = value;
                    break;
                }
            }
        }
        setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T value) {
        Object[] info =getInfo();
        int meio, inicio = 0, fim = getTamanho() - 1;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (value.compareTo((T)info[meio]) < 0) {
                fim = meio - 1;
            } else if (value.compareTo((T)info[meio]) > 0) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }
}
