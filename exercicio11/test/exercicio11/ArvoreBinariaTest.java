/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio11;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leoro
 */
public class ArvoreBinariaTest {

    public ArvoreBinariaTest() {
    }

    
    @Test
    public void testInserir() {
        System.out.println("Inserir");
        ArvoreBinaria instance = new ArvoreBinaria();
        instance.Inserir(50);
        instance.Inserir(30);
        instance.Inserir(70);
        instance.Inserir(40);
        instance.Inserir(25);
        instance.Inserir(75);
        instance.Inserir(65);
        instance.Inserir(35);
        instance.Inserir(60);
        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>",instance.toString());
    }
    
    @Test
    public void testRetirarNoFolha(){
         ArvoreBinaria instance = new ArvoreBinaria();
        instance.Inserir(50);
        instance.Inserir(30);
        instance.Inserir(25);
        instance.Inserir(40);
        instance.retirar(40);
        assertEquals("<50<30<25<><>><>><>>" ,instance.toString());
            
    }
    
    @Test
    public void removerNoComUmFilho(){
        ArvoreBinaria instance = new ArvoreBinaria();
        instance.Inserir(80);
        instance.Inserir(52);
        instance.Inserir(90);
        instance.Inserir(48);
        instance.Inserir(71);
        instance.Inserir(63);
        instance.Inserir(67);
        instance.retirar(71);
        assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>",instance.toString());
    }
    @Test
    public void removerNoComDoisFilho(){
        ArvoreBinaria instance = new ArvoreBinaria();
        instance.Inserir(250);
        instance.Inserir(38);
        instance.Inserir(26);
        instance.Inserir(72);
        instance.Inserir(55);
        instance.Inserir(90);
        instance.Inserir(41);
        instance.Inserir(60);
        instance.Inserir(43);
        instance.Inserir(78);
        instance.Inserir(92);
        instance.Inserir(74);
        instance.Inserir(38);
        instance.retirar(38);
        instance.retirar(38);
        assertEquals("<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>",instance.toString());
    }

    
    

}
