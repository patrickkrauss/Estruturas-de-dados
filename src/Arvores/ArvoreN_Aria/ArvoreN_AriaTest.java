package Arvores.ArvoreN_Aria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArvoreN_AriaTest {

    private Arvore<Integer> arvore;
    NoArvore<Integer> no1;
    NoArvore<Integer> no2;
    NoArvore<Integer> no3;
    NoArvore<Integer> no4;
    NoArvore<Integer> no5;
    NoArvore<Integer> no6;
    NoArvore<Integer> no7;
    NoArvore<Integer> no8;
    NoArvore<Integer> no9;
    NoArvore<Integer> no10;

    private void inserirValoresParaTeste() {
        arvore.setRaiz(no1);
    }

    @BeforeEach
    void setUp() {
        no5 = new NoArvore<>(5);
        no6 = new NoArvore<>(6);
        no7 = new NoArvore<>(7);
        no2 = new NoArvore<>(2, no7, no6, no5);
        no8 = new NoArvore<>(8);
        no3 = new NoArvore<>(3, no8);

        no9 = new NoArvore<>(9);
        no10 = new NoArvore<>(10);
        no4 = new NoArvore<>(4, no10, no9);

        no1 = new NoArvore<>(1, no4, no3, no2);
        arvore = new Arvore<>();
        /*no5 = new NoArvore<>(5);
        no6 = new NoArvore<>(6);
        no7 = new NoArvore<>(7);
        no2 = new NoArvore<>(2, no5, no6, no7);
        no8 = new NoArvore<>(8);
        no3 = new NoArvore<>(3, no8);

        no9 = new NoArvore<>(9);
        no10 = new NoArvore<>(10);
        no4 = new NoArvore<>(4, no9, no10);

        no1 = new NoArvore<>(1, no2, no3, no4);
        arvore = new Arvore<>();*/
    }

    @Test
    void testePertenceTrue() {
        inserirValoresParaTeste();
        assertTrue(arvore.pertence(2));
        assertTrue(arvore.pertence(5));
        assertTrue(arvore.pertence(3));
        assertTrue(arvore.pertence(8));
        assertTrue(arvore.pertence(10));
    }

    @Test
    void testePertenceFalse() {
        inserirValoresParaTeste();
        assertFalse(arvore.pertence(0));
        assertFalse(arvore.pertence(11));
        assertFalse(arvore.pertence(55));
        assertFalse(arvore.pertence(-1));
    }

    @Test
    void testeBuscarTrue() {
        inserirValoresParaTeste();
        assertEquals(new Integer(2),arvore.buscar(2).getInfo());
        assertEquals(new Integer(5),arvore.buscar(5).getInfo());
        assertEquals(new Integer(3),arvore.buscar(3).getInfo());
        assertEquals(new Integer(8),arvore.buscar(8).getInfo());
        assertEquals(new Integer(10),arvore.buscar(10).getInfo());
    }

    @Test
    void testeBuscarFalse() {
        inserirValoresParaTeste();
        assertNull(arvore.buscar(0));
        assertNull(arvore.buscar(11));
        assertNull(arvore.buscar(55));
        assertNull(arvore.buscar(-1));
    }

    @Test
    void testeToString() {
        inserirValoresParaTeste();
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    void testeToStringVazio() {
        assertEquals("<>", arvore.toString());
    }

    @Test
    void testeContarNosVazio() {
        assertEquals(0, arvore.contarNos());
    }

    @Test
    void testeContarNos() {
        inserirValoresParaTeste();
        assertEquals(10, arvore.contarNos());
    }

}
