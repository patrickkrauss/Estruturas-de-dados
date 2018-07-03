package ListaDuplamenteEncadeada.Generica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDuplamenteEncadeadaTest {

    private ListaDuplamenteEncadeada<Integer> list;

    private void inserirValoresParaTeste() {
        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);
    }

    @BeforeEach
    void setUp() {
        list = new ListaDuplamenteEncadeada<>();
    }

    @Test
    void testeConstrutor() {
        assertTrue(list.estaVazia());
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
    void testeBuscarNaPrimeiraPocisao(){
        inserirValoresParaTeste();
        assertEquals(new NoListaDupla<>(20),list.buscar(20));
    }

    @Test
    void testeBuscarNaMetadeDaLista() {
        inserirValoresParaTeste();
        assertEquals(new NoListaDupla<>(10), list.buscar(10));
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
        assertEquals("15,10,5",list.toString());
    }

    @Test
    void testeRetirarNaMetadeDaLista() {
        inserirValoresParaTeste();
        list.retirar(10);
        assertEquals("20,15,5",list.toString());
    }

    @Test
    void testeRetirarNaUltimaPocisao() {
        inserirValoresParaTeste();
        list.retirar(5);
        assertEquals("20,15,10",list.toString());
    }

    @Test
    void testeObterNoNaPrimeiraPocisao() {
        inserirValoresParaTeste();
        assertEquals(new NoListaDupla<>(20),list.obterNo(0));
    }

    @Test
    void testeObterNoNaUltimaPocisao() {
        inserirValoresParaTeste();
        assertEquals(new NoListaDupla<>(5),list.obterNo(3));
    }

    @Test
    void testeObterNoPocisaoNegativa() {
        inserirValoresParaTeste();
        try {
            list.obterNo(-1);
            fail("Should have throw an exception");
        }catch (IndexOutOfBoundsException e){
            return;
        }
    }

    @Test
    void testeObterNoPocisaoMaiorQueTamanhoLista() {
        inserirValoresParaTeste();
        try {
            list.obterNo(10);
            fail("Should have throw an exception");
        }catch (IndexOutOfBoundsException e){
            return;
        }
    }

    @Test
    void testeObterComprimentoEmListaVazia() {
        assertEquals(0,list.obterComprimento());
    }

    @Test
    void testeObterComprimentoEmListaPreenchida() {
        inserirValoresParaTeste();
        assertEquals(4,list.obterComprimento());
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
        NoListaDupla c = list.buscar(20);
        NoListaDupla b = list.buscar(15);
        NoListaDupla a = list.buscar(10);
        NoListaDupla d = list.buscar(5);
        list.liberar();
        assertNull(a.getProximo());
        assertNull(a.getAnterior());
        assertNull(b.getProximo());
        assertNull(b.getAnterior());
        assertNull(c.getProximo());
        assertNull(c.getAnterior());
        assertNull(d.getProximo());
        assertNull(d.getAnterior());
        assertEquals("", list.toString());
    }

}