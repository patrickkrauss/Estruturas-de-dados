package Arvores.ArvoreBinaria;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return (pertence(raiz, info));
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null)
            return false;
        else if (no.getInfo().equals(info))
            return true;
        return (pertence(no.getEsquerda(), info)) || pertence(no.getDireita(), info);
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

    /*private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null)
            return 0;
        return 1 + contarNos(no.getEsquerda())
                + contarNos(no.getDireita());
    }*/

    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {
        if (no == null)
            return 0;
        if (no.getEsquerda() == null && no.getDireita() == null)
            return 1 + contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
        return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }

}
