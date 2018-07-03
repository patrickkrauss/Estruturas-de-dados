package Ordenacao;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

	@Override
	public void ordenar() {
		int n = getInfo().length-1;
		mergeSort(0, n);
	}
	
	private void mergeSort(int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(inicio, meio);
			mergeSort(meio+1, fim);
			merge(inicio, fim, meio);
		}
	}
	
	private void merge(int inicio, int fim, int meio) {
		int tamanhoEsquerda = meio - inicio + 1;		
		T[] info = getInfo();
		T[] esquerda = (T[]) new Comparable[tamanhoEsquerda];
		
		for(int i = 0; i < tamanhoEsquerda; i++)
			esquerda[i] = info[inicio+i];
		
		int tamanhoDireita = fim - meio;		
		T[] direita = (T[]) new Comparable[tamanhoDireita];
		for(int i = 0; i < tamanhoDireita; i++)
			direita[i] = info[meio+1+i];
		
		int cEsquerda = 0;
		int cDireita = 0;
		
		int i;
		for(i = inicio; i <= fim; i++) {
			if((cEsquerda < tamanhoEsquerda) && (cDireita < tamanhoDireita)) {
				if(esquerda[cEsquerda].compareTo(direita[cDireita]) < 0) {
					info[i] = esquerda[cEsquerda];
					cEsquerda++;
				}else {
					info[i] = direita[cDireita];
					cDireita++;
				}
			}else {
				break;
			}
		}
		
		while(cEsquerda < tamanhoEsquerda) {
			info[i] = esquerda[cEsquerda];
			cEsquerda++;
			i++;
		}
		
		while(cDireita < tamanhoDireita) {
			info[i] = direita[cDireita];
			cDireita++;
			i++;
		}
	}
}
