package exercicio13;

import Pilhas.PilhaLista.ListaEncadeada.ListaEncadeada;
import Pilhas.PilhaLista.ListaEncadeada.NoLista;

public class MapaDispersao<T> {
   private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }
    private int calcularHash(int chave){
        return chave % info.length;
    }
    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        
        if(info[indice] == null){
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);
        
        info[indice].inserir(noMapa);
        
    }
    public void remover(int chave){
        int indice = calcularHash(chave);
       if(info[indice] != null){
           NoMapa<T> no = new NoMapa<>();
           no.setChave(chave);
           info[indice].retirar(no);
       }
    }
    
   
    public T buscar(int chave){
        int indice = calcularHash(chave);
        if(info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);
            
            NoLista<NoMapa<T>> p;
            p = info[indice].getPrimeiro();
            while(p!=null){
                if(p.getInfo().getChave() == chave)
                    return p.getInfo().getInfo();
                p=p.getProximo();
            }
            
            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if(no !=null){
                return no.getInfo().getInfo();
            }
        }
        return null;
    }
}
