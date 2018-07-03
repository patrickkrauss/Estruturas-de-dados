/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio10;

/**
 *
 * @author leoro
 */
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
