package ListaEstatica.Inteiros;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class ListaEstaticaTest {

    private ListaEstatica list;

    @BeforeEach
    void setUp() {
        list = new ListaEstatica();
        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);
    }

    @Test
    void testeContrutor() {
        list = new ListaEstatica(5, 10, 15, 20, 25, 30);
        assertEquals("5,10,15,20,25,30", list.toString());
    }

    @Test
    void testeGetTamanho() {
        assertEquals(4, list.getTamanho());
    }

    @Test
    void testeInserir() {
        assertEquals("5,10,15,20", list.toString());
    }

    @Test
    void testeBuscar() {
        assertEquals(2, list.buscar(15));
    }

    @Test
    void testeBuscarElementoInexistente() {
        assertEquals(-1, list.buscar(30));
    }

    @Test
    void testeRetirar() {
        list.retirar(10);
        assertEquals("5,15,20", list.toString());
        assertEquals(3, list.getTamanho());
    }

    @Test
    void testeExecaoRetirar() {
        list = new ListaEstatica();
        list.inserir(1);
        list.inserir(2);
        list.inserir(3);
        list.inserir(4);
        list.inserir(5);
        list.inserir(6);
        list.inserir(7);
        list.inserir(8);
        list.inserir(9);
        list.inserir(10);
        list.retirar(2);
        try{
            list.retirar(-10);
        }catch (Exception e){
            return;
        }
        fail("Should have throw an exception");
    }

    @Test
    void testeInsersaoComRedimensionamento() {
        list = new ListaEstatica();
        list.inserir(1);
        list.inserir(2);
        list.inserir(3);
        list.inserir(4);
        list.inserir(5);
        list.inserir(6);
        list.inserir(7);
        list.inserir(8);
        list.inserir(9);
        list.inserir(10);
        list.inserir(11);
        list.inserir(12);
        list.inserir(13);
        list.inserir(14);
        list.inserir(15);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15",list.toString());
        assertEquals(15,list.getTamanho());
    }

    @Test
    void testeObterElemento() {
        assertEquals(20,list.obterElemento(3));
    }

    @Test
    void testeExecaoObterElemento() {
        try{
            list.obterElemento(5);
        }catch (Exception e){
            return;
        }
        fail("Should have throw an exception");
    }

    @Test
    void testeLiberar() {
        list.liberar();
        assertEquals(true,list.estaVazia());
    }

    @Test
    void testeEstaVazia() {
        list = new ListaEstatica();
        assertEquals(true,list.estaVazia());
    }
}