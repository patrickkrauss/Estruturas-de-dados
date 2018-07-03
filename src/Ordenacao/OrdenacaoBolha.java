package Ordenacao;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

	@Override
	public void ordenar() {
		T[] info = getInfo();
		int n = info.length;
		boolean trocou;
			
		for (int i = n - 1; i >= 1; i--) {
			trocou = false;
            for (int j = 0; j < i; j++) {
				if(info[j].compareTo(info[j+1]) > 0) {
					trocar(j, j+1);
					trocou = true;
				}
			}
			if(!trocou)
				break;
		}
	}
	
}
