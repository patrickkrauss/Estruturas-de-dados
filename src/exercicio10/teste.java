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
public class teste {
    public static void main(String[] args) {
        ListaOrdenada Patrick = new ListaOrdenada();
        
        Patrick.inserir(1);
        Patrick.inserir(4);
        Patrick.inserir(3);
        Patrick.inserir(3);
        Patrick.inserir(2);
        Patrick.inserir(4);
        Patrick.inserir(7);
        Patrick.inserir(2);
        Patrick.inserir(9);
        Patrick.inserir(5);
        Patrick.inserir(6);
        Patrick.inserir(0);
        Patrick.inserir(10000);
        Patrick.inserir(104);
        Patrick.inserir(1089);
        Patrick.inserir(108);
        
        
        
        System.out.println(Patrick.toString());
        System.out.println(Patrick.buscar(0));
    }
}
