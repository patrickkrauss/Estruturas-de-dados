package exercicio10;

/*import org.junit.After;

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import org.junit.Test;
import static org.junit.Assert.*;*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaOrdenadaTest {

    @Test
    public void testInserir() {

        System.out.println("inserir");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(100);

        instance.inserir(20);

        instance.inserir(70);

        instance.inserir(1);



        assertEquals("1,20,70,100", instance.toString());

    }

    @Test
    public void testBuscar1() {

        System.out.println("buscar1");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(0);

        instance.inserir(10);

        instance.inserir(20);

        instance.inserir(30);

        instance.inserir(40);

        instance.inserir(50);

        instance.inserir(60);

        instance.inserir(70);

        instance.inserir(80);

        instance.inserir(90);

        instance.inserir(100);



        assertEquals(2, instance.buscar(20));

    }

    @Test
    public void testBuscar2() {

        System.out.println("buscar2");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(0);

        instance.inserir(10);

        instance.inserir(20);

        instance.inserir(30);

        instance.inserir(40);

        instance.inserir(50);

        instance.inserir(60);

        instance.inserir(70);

        instance.inserir(80);

        instance.inserir(90);

        instance.inserir(100);



        assertEquals(4, instance.buscar(40));

    }

    @Test
    public void testBuscar3() {

        System.out.println("buscar3");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(0);

        instance.inserir(10);

        instance.inserir(20);

        instance.inserir(30);

        instance.inserir(40);

        instance.inserir(50);

        instance.inserir(60);

        instance.inserir(70);

        instance.inserir(80);

        instance.inserir(90);

        instance.inserir(100);



        assertEquals(7, instance.buscar(70));

    }

    @Test
    public void testBuscar4() {

        System.out.println("buscar4");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(0);

        instance.inserir(10);

        instance.inserir(20);

        instance.inserir(30);

        instance.inserir(40);

        instance.inserir(50);

        instance.inserir(60);

        instance.inserir(70);

        instance.inserir(80);

        instance.inserir(90);

        instance.inserir(100);



        assertEquals(10, instance.buscar(100));

    }

    @Test
    public void testBuscar5() {

        System.out.println("buscar5");

        ListaOrdenada instance = new ListaOrdenada();

        instance.inserir(0);

        instance.inserir(10);

        instance.inserir(20);

        instance.inserir(30);

        instance.inserir(40);

        instance.inserir(50);

        instance.inserir(60);

        instance.inserir(70);

        instance.inserir(80);

        instance.inserir(90);

        instance.inserir(100);

        assertEquals(-1, instance.buscar(85));

    }

}
