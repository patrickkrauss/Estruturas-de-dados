package ListaDuplamenteEncadeada.Generica;

public class ListaDuplamenteEncadeada<T> {

    private NoListaDupla<T> primeiro;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
    }

    public NoListaDupla getPrimeiro() {
        return primeiro;
    }

    public void inserir(T value) {
        NoListaDupla<T> novoPrimiro = new NoListaDupla<T>(value);
        novoPrimiro.setProximo(primeiro);
        if (primeiro != null)
            primeiro.setAnterior(novoPrimiro);
        primeiro = novoPrimiro;
    }

    public void exibir() {
        System.out.println("[" + toString().replaceAll(",", "][") + "]");
    }

    public boolean estaVazia() {
        if (primeiro == null)
            return true;
        else
            return false;
    }

    public NoListaDupla buscar(T value) {  //pq esse metodo falha se o equals nao esta sobreescrito no NoLista
        NoListaDupla current = primeiro;
        while (current != null) {
            if (current.getInfo() == value)
                return current;
            current = current.getProximo();
        }
        return null;
    }

    public void retirar(T value) {

        NoListaDupla<T> current = primeiro;

        while (current != null) {
            if (current.getInfo() == value) {
                if (current.getProximo() != null && current.getAnterior() != null) {
                    current.getAnterior().setProximo(current.getProximo());
                    return;
                } else if (current.getProximo() == null)
                    current.getAnterior().setProximo(null);
                else if (current.getAnterior() == null)
                    primeiro = current.getProximo();

                return;
            }
            current = current.getProximo();
        }

    }

    public int obterComprimento() {
        NoListaDupla<T> current = primeiro;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getProximo();
        }
        return size;
    }

    public NoListaDupla obterNo(int position) {
        if (position < 0)
            throw new IndexOutOfBoundsException("Pocisao nao pode ser negativa");

        NoListaDupla current = primeiro;
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
        NoListaDupla current = primeiro.getProximo();
        while (current != null) {
            values.append(",");
            values.append(current.getInfo());
            current = current.getProximo();
        }
        return values.toString();
    }

    public String exibirOrdemInversa() {
        String normalOrder = toString();
        StringBuilder result = new StringBuilder(normalOrder.length());
        String[] values = normalOrder.split(",");
        for (int i = values.length - 1; i > 0; i--) {
            result.append(values[i]);
        }
        return result.toString();
    }

    public void liberar() {                   // pode estar errado
        if (primeiro == null)
            return;
        NoListaDupla<T> preview = null;
        NoListaDupla<T> current = primeiro;
        while (current != null) {
            preview = current;
            current = current.getProximo();
            preview.setProximo(null);
            preview.setAnterior(null);
            preview.setInfo(null);
        }
        primeiro = null;
    }


}
