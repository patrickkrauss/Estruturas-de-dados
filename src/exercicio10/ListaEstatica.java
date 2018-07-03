package exercicio10;

public class ListaEstatica<T> extends ListaAbstract<T>{
    
    @Override
    public void inserir(T value) {
       T[] info = getInfo();
        if (getTamanho() == info.length) {
            redimensionar();
            info[getTamanho()] = value;
            setTamanho(getTamanho()+ 1);
        } else {
            info[getTamanho()] = value;
            setTamanho(getTamanho() + 1);
        }
    }

    @Override
    public int buscar(T value) {
        T[] info = getInfo();
        for (int i = 0; i < info.length; i++) {
            if (value.equals(info[i]))
                return i;
        }
        return -1;
    }
    
}
