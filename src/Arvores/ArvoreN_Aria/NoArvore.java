
package Arvores.ArvoreN_Aria;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;

    public T getInfo() {
        return info;
    }

    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public NoArvore(T info, NoArvore<T>... filhos) {
        this(info);
        inserirFilhos(filhos);
    }

    public void inserirFilhos(NoArvore<T>... filhos) {
        for (int i = 0; i < filhos.length; i++)
            inserirFilho(filhos[i]);
    }


    public void inserirFilho(NoArvore<T> filho) {
        filho.proximo = primeiro;
        primeiro = filho;
    }

}
