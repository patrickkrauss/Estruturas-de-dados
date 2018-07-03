package Arvores.ArvoreN_Aria;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }


    public NoArvore<T> buscar(T info) {
        return (buscar(raiz, info));
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no != null) {
            if (no.getInfo().equals(info))
                return no;
            else {
                NoArvore a = buscar(no.getPrimeiro(), info);
                if(a==null)
                    return buscar(no.getProximo(), info);
                return a;

            }
        }
        return null;
    }

    public boolean pertence(T info) {
        return (pertence(raiz, info));
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null)
            return false;
        else if (no.getInfo().equals(info))
            return true;
        else
            return pertence(no.getProximo(), info) || pertence(no.getPrimeiro(), info);
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "<>";
        return obterRepresentacaoTextual(raiz);
    }

    /*private String obterRepresentacaoTextual(NoArvore<T> no) {
        String conteudo = "<" + no.getInfo();
        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            conteudo += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        conteudo += ">";
        return conteudo;
    }*/

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null)
            return "";
        else
            return "<" + no.getInfo().toString() + obterRepresentacaoTextual(no.getPrimeiro()) + ">" + obterRepresentacaoTextual(no.getProximo());
    }

    public int contarNos() {
        if (estaVazia())
            return 0;
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null)
            return 0;
        else
            return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
    }

    public boolean estaVazia() {
        return raiz == null;
    }

}


