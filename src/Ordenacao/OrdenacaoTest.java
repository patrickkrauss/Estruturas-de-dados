package Ordenacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdenacaoTest {

	private Integer[] dados = new Integer[] {70,2,88,15,90,30};
	
	@Test
	void testeBolha() {
		OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
		bolha.setInfo(dados);
		bolha.ordenar();
		assertEquals("2,15,30,70,88,90", bolha.toString());
	}

	@Test
	void testeQuickSort() {
		dados = new Integer[] {70,2,88,15,90,30};
		OrdenacaoQuickSort<Integer> quickSort = new OrdenacaoQuickSort<>();
		quickSort.setInfo(dados);
		quickSort.ordenar();
		assertEquals("2,15,30,70,88,90", quickSort.toString());
	}
	
	@Test
	void testeMergeSort() {
		dados = new Integer[] {70,2,88,15,90,30};
		OrdenacaoMergeSort<Integer> mergeSort = new OrdenacaoMergeSort<>();
		mergeSort.setInfo(dados);
		mergeSort.ordenar();
		assertEquals("2,15,30,70,88,90", mergeSort.toString());
	}
}
