package ListaEncadeada.Generica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEncadeadaTest {

    private ListaEncadeada<Integer> list;

    private void inserirValoresParaTeste() {
        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);
    }

    @BeforeEach
    void setUp() {
        list = new ListaEncadeada<>();
    }


    @Test
    void testeInserirUmValor() {
        list.inserir(5);
        assertFalse(list.estaVazia());
    }

    @Test
    void testeInserirTresValores() {
        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        assertEquals("15,10,5", list.toString());
    }

    @Test
    void testeBuscarNaPrimeiraPocisao() {
        inserirValoresParaTeste();
        assertEquals(new NoLista<>(20), list.buscar(20));
    }

    @Test
    void testeBuscarNaMetadeDaLista() {
        inserirValoresParaTeste();
        assertEquals(new NoLista<>(15), list.buscar(15));
    }

    @Test
    void testeBuscarDadoInexistente() {
        inserirValoresParaTeste();
        assertNull(list.buscar(100));
    }

    @Test
    void testeRetirarNaPrimeiraPocisao() {
        inserirValoresParaTeste();
        list.retirar(20);
        assertEquals("15,10,5", list.toString());
    }

    @Test
    void testeRetirarNaMetadeDaLista() {
        inserirValoresParaTeste();
        list.retirar(15);
        assertEquals("20,10,5", list.toString());
    }

    @Test
    void testeObterNoNaPrimeiraPocisao() {
        inserirValoresParaTeste();
        assertEquals(new NoLista<>(20), list.obterNo(0));
    }

    @Test
    void testeObterNoNaUltimaPocisao() {
        inserirValoresParaTeste();
        assertEquals(new NoLista<>(5), list.obterNo(3));
    }

    @Test
    void testeObterNoPocisaoNegativa() {
        inserirValoresParaTeste();
        try {
            list.obterNo(-1);
            fail("Should have throw an exception");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    @Test
    void testeObterNoPocisaoMaiorQueTamanhoLista() {
        inserirValoresParaTeste();
        try {
            list.obterNo(10);
            fail("Should have throw an exception");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    @Test
    void testeObterComprimentoEmListaVazia() {
        assertEquals(0, list.obterComprimento());
    }

    @Test
    void testeObterComprimentoEmListaPreenchida() {
        inserirValoresParaTeste();
        assertEquals(4, list.obterComprimento());
    }

    @Test
    void testeToStringEmListaComValores() {
        inserirValoresParaTeste();
        assertEquals("20,15,10,5", list.toString());
    }

    @Test
    void testeToStringEmListaSemValores() {
        assertEquals("", list.toString());
    }

    @Test
    void testeEstaVaziaTrue() {
        assertTrue(list.estaVazia());
    }

    @Test
    void testeEstaVaziaFalse() {
        inserirValoresParaTeste();
        assertFalse(list.estaVazia());
    }

    @Test
    void testeLiberar() {
        inserirValoresParaTeste();
        NoLista c = list.buscar(20);
        NoLista b = list.buscar(15);
        NoLista a = list.buscar(10);
        NoLista d = list.buscar(5);
        list.liberar();
        assertNull(a.getProximo());
        assertNull(b.getProximo());
        assertNull(c.getProximo());
        assertNull(d.getProximo());
        assertEquals("", list.toString());
    }
}