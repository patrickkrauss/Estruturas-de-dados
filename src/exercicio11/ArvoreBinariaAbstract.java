package exercicio11;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return (buscar(raiz, info) != null);
    }

    public abstract NoArvoreBinaria<T> buscar(T info); //{
    //    return (buscar(raiz, info));
    //  }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null || no.getInfo().equals(info))
            return no;
        NoArvoreBinaria<T> t = buscar(no.getEsquerda(), info);
        if (t != null)
            return t;
        return buscar(no.getDireita(), info);
    }

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null)
            return "<>";
        return "<" + no.getInfo() + (arvorePre(no.getEsquerda()) + arvorePre(no.getDireita())) + ">";
    }


    public int contarNos() {
        return contarNos(raiz, 0);
    }

    private int contarNos(NoArvoreBinaria<T> no, int quantidade) {
        if (no == null)
            return quantidade;
        quantidade++;
        if (no.getEsquerda() != null)
            return quantidade + contarNos(no.getEsquerda(), quantidade);
        if (no.getDireita() != null)
            return quantidade + contarNos(no.getDireita(), quantidade);
        return quantidade;
    }

}
