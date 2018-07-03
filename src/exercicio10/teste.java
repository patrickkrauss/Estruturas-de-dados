package exercicio10;

public class teste {

    public static void main(String[] args) {
        ListaOrdenada<Integer> lista = new ListaOrdenada();
        
        lista.inserir(1);
        lista.inserir(4);
        lista.inserir(3);
        lista.inserir(3);
        lista.inserir(2);
        lista.inserir(4);
        lista.inserir(7);
        lista.inserir(2);
        lista.inserir(9);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(0);
        lista.inserir(10000);
        lista.inserir(104);
        lista.inserir(1089);
        lista.inserir(108);
        
        
        
        System.out.println(lista.toString());
        System.out.println(lista.buscar(0));
    }
}
