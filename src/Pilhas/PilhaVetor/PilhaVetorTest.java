package Pilhas.PilhaVetor;

import Pilhas.Execoes.PilhaCheiaException;
import Pilhas.Execoes.PilhaVaziaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaVetorTest {

    private PilhaVetor<Integer> pilha;

    private void inserirValoresParaTeste() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
    }

    @BeforeEach
    void setUp() {
        pilha = new PilhaVetor<>(5);
    }

    @Test
    void testeEstaVaziaTrue() {
        assertTrue(pilha.estaVazia());
    }

    @Test
    void testeEstaVaziaFalse() {
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    void testeDesempliharPilha() {
        inserirValoresParaTeste();
        assertEquals(new Integer(30), pilha.pop());
        assertEquals(new Integer(20), pilha.pop());
        assertEquals(new Integer(10), pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    void testeExecaoPilhaCheia() {
        pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        try {
            pilha.push(40);
            fail("Should have throw an exception");
        } catch (PilhaCheiaException e) {
            return;
        }
    }

    @Test
    void testeExecaoPilhaVazia() {
        try {
            pilha.pop();
            fail("Should have throw an exception");
        } catch (PilhaVaziaException e) {
            return;
        }
    }

    @Test
    void testePeek() {
        inserirValoresParaTeste();
        assertEquals(new Integer(30), pilha.peek());
    }

    @Test
    void testePop() {
        inserirValoresParaTeste();
        assertEquals(new Integer(30), pilha.pop());
        assertEquals("20,10", pilha.toString());
    }

    @Test
    void testeLiberar() {
        inserirValoresParaTeste();
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

    @Test
    void testeContatenacao() {
        inserirValoresParaTeste();
        PilhaVetor<Integer> pilhaAuxiliar = new PilhaVetor<Integer>(2);
        pilhaAuxiliar.push(40);
        pilhaAuxiliar.push(50);

        pilha.concatenar(pilhaAuxiliar);

        assertEquals("50,40,30,20,10", pilha.toString());
        assertEquals("50,40", pilhaAuxiliar.toString());
    }

    @Test
    void testeToString(){
        inserirValoresParaTeste();
        assertEquals("30,20,10",pilha.toString());
    }

    @Test
    void testeToStringComUmElemento(){
        pilha.push(10);
        assertEquals("10",pilha.toString());
    }

    @Test
    void testeToStringVazio(){
        assertEquals("",pilha.toString());
    }

}