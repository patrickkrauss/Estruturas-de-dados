package Arvores.ArvoreBinaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArvoreBinariaTest {

    private ArvoreBinaria<Integer> arvore;
    NoArvoreBinaria<Integer> no1;
    NoArvoreBinaria<Integer> no2;
    NoArvoreBinaria<Integer> no3;
    NoArvoreBinaria<Integer> no4;
    NoArvoreBinaria<Integer> no5;
    NoArvoreBinaria<Integer> no6;

    private void inserirValoresParaTeste() {
        arvore.setRaiz(no1);
    }

    @BeforeEach
    void setUp() {
        no4 = new NoArvoreBinaria<>(4);
        no2 = new NoArvoreBinaria<>(2,null,  no4);
        no5 = new NoArvoreBinaria<>(5);
        no6 = new NoArvoreBinaria<>(6);
        no3 = new NoArvoreBinaria<>(3, no5, no6);
        no1 = new NoArvoreBinaria<>(1, no2, no3);
        arvore = new ArvoreBinaria<>();
    }

    @Test
    void testeEstaVaziaTrue() {
        assertTrue(arvore.estaVazia());
    }

    @Test
    void testeEstaVaziaFalse() {
        inserirValoresParaTeste();
        assertFalse(arvore.estaVazia());
    }

    @Test
    void testePertenceTrue() {
        inserirValoresParaTeste();
        assertTrue(arvore.pertence(1));
        assertTrue(arvore.pertence(5));
        assertTrue(arvore.pertence(3));
        assertTrue(arvore.pertence(6));
    }

    @Test
    void testePertenceFalse() {
        inserirValoresParaTeste();
        assertFalse(arvore.pertence(10));
        assertFalse(arvore.pertence(7));
        assertFalse(arvore.pertence(-1));
    }

    @Test
    void testeToString() {
        inserirValoresParaTeste();
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvore.toString());
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
        assertEquals(6, arvore.contarNos());
    }

    @Test
    void testeContarNosFolhasVazio() {
        assertEquals(0, arvore.contarFolhas());
    }

    @Test
    void testeContarNosFolhas() {
        inserirValoresParaTeste();
        assertEquals(3, arvore.contarFolhas());
    }

}
