package ListaEncadeada.Generica;

import java.util.Objects;

class NoLista<T> {

    private T info;
    private NoLista proximo;

    public NoLista(T info) {
        setInfo(info);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return info.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoLista<?> noLista = (NoLista<?>) o;
        return Objects.equals(getInfo(), noLista.getInfo());
    }
}
