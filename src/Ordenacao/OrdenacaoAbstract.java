package Ordenacao;

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {
	
	private T[] info;
	
	public abstract void ordenar();
	
	public T[] getInfo() {
		return info;
	}
	
	public void setInfo(T[] info) {
		this.info = info;
	}
	
	public void trocar(int a, int b) {
		T temp = info[a];
		info[a] = info[b];
		info[b] = temp;
	}
	
	@Override
	public String toString() {
		String conteudo = "";
		for(int i = 0; i < info.length; i++) {
			conteudo += info[i];
			if(i != info.length-1)
				conteudo+= ",";
		}
		return conteudo;
	}
}
