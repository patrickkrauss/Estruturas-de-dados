package Filas.FilaVetor;


import Filas.Execoes.FilaCheiaException;
import Filas.Execoes.FilaVaziaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaVetorTest {

    private FilaVetor<Integer> fila;

    private void inserirValoresParaTeste() {
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
    }

    @BeforeEach
    void setUp() {
        fila = new FilaVetor<>(5);
    }

    @Test
    void testeEstaVaziaTrue() {
        assertTrue(fila.estaVazia());
    }

    @Test
    void testeEstaVaziaFalse() {
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    void testeDesempliharfila() {
        inserirValoresParaTeste();
        assertEquals(new Integer(10), fila.retirar());
        assertEquals(new Integer(20), fila.retirar());
        assertEquals(new Integer(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    void testeExecaofilaCheia() {
        fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        try {
            fila.inserir(40);
            fail("Should have throw an exception");
        } catch (FilaCheiaException e) {
            return;
        }
    }

    @Test
    void testeExecaofilaVazia() {
        try {
            fila.retirar();
            fail("Should have throw an exception");
        } catch (FilaVaziaException e) {
            return;
        }
    }

    @Test
    void testePeek() {
        inserirValoresParaTeste();
        assertEquals(new Integer(10), fila.peek());
    }

    @Test
    void testePop() {
        inserirValoresParaTeste();
        assertEquals(new Integer(10), fila.retirar());
        assertEquals("20,30", fila.toString());
    }

    @Test
    void testeLiberar() {
        inserirValoresParaTeste();
        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    @Test
    void testeContatenacao() {
        inserirValoresParaTeste();
        FilaVetor<Integer> filaAuxiliar = new FilaVetor<Integer>(2);
        filaAuxiliar.inserir(40);
        filaAuxiliar.inserir(50);

        assertEquals("10,20,30,40,50", fila.criarFilaContatenada(filaAuxiliar).toString());
    }

    @Test
    void testeToString() {
        inserirValoresParaTeste();
        assertEquals("10,20,30", fila.toString());
    }

    @Test
    void testeToStringComUmElemento() {
        fila.inserir(10);
        assertEquals("10", fila.toString());
    }

    @Test
    void testeToStringVazio() {
        assertEquals("", fila.toString());
    }

    @Test
    void
    meuTest() {
        inserirValoresParaTeste();
        fila.encolher();
    }

}