package ListaDuplamenteEncadeada.Generica;


import java.util.Objects;

class NoListaDupla<T> {

    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public NoListaDupla(T info) {
        setInfo(info);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoListaDupla<?> that = (NoListaDupla<?>) o;
        return Objects.equals(getInfo(), that.getInfo());
    }
}
