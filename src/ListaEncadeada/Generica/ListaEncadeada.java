package ListaEncadeada.Generica;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista getPrimeiro() {
        return primeiro;
    }

    public void inserir(T value) {
        NoLista<T> novoPrimiro = new NoLista<T>(value);
        novoPrimiro.setProximo(primeiro);
        primeiro = novoPrimiro;
    }

    public void exibir() {
        System.out.println("[" + toString().replaceAll(",", "][") + "]");
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista buscar(T value) {  //pq esse metodo falha se o equals nao esta sobreescrito no NoLista
        NoLista current = primeiro;
        while (current != null) {
            if (current.getInfo() == value)
                return current;
            current = current.getProximo();
        }
        return null;
    }

    public void retirar(T value) {
        NoLista<T> current = primeiro;
        NoLista<T> anterior = null;
        while (current != null && !current.getInfo().equals(value)) {
            anterior = current;
            current = current.getProximo();
        }

        if (current != null) {
            if (anterior == null)
                primeiro = current.getProximo();
            else
                anterior.setProximo(current.getProximo());
        }
    }

    public int obterComprimento() {
        NoLista current = primeiro;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getProximo();
        }
        return size;
    }

    public NoLista obterNo(int position) {
        if (position < 0)
            throw new IndexOutOfBoundsException("Pocisao nao pode ser negativa");

        NoLista current = primeiro;
        int lenght = 0;
        while (lenght < position) {
            current = current.getProximo();
            if (current == null)
                break;
            lenght++;
        }
        if (position == lenght)
            return current;
        else
            throw new IndexOutOfBoundsException("Pocisao maior que tamanho da lista");
    }

    public String toString() {
        if (primeiro == null)
            return "";
        StringBuilder values = new StringBuilder(primeiro.toString());
        NoLista current = primeiro.getProximo();
        while (current != null) {
            values.append(",");
            values.append(current.getInfo());
            current = current.getProximo();
        }
        return values.toString();
    }

    public void liberar() {                   // pode estar errado
        if (primeiro == null)
            return;
        NoLista<T> preview = null;
        NoLista<T> current = primeiro;
        while (current != null) {
            preview = current;
            current = current.getProximo();
            preview.setProximo(null);
            preview.setInfo(null);
        }
        primeiro = null;
    }
}

