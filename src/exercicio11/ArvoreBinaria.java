package exercicio11;

public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria p = getRaiz();
        while (p != null && (info.compareTo((T) p.getInfo()) != 0)) {
            if (info.compareTo((T) p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return p;
    }

    public void Inserir(T info) {
        NoArvoreBinaria novo = new NoArvoreBinaria(info);
        NoArvoreBinaria p = getRaiz();
        NoArvoreBinaria pai = null;
        if (p == null) {
            setRaiz(novo);
        } else {
            p = getRaiz();
            while (true) {
                pai = p;
                if (info.compareTo((T) p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    public void retirar(T info) {
        NoArvoreBinaria p = getRaiz();
        NoArvoreBinaria pai = null;
        boolean filhoEsquerda = false;

        while (p != null && (info.compareTo((T) p.getInfo()) != 0)) {
            pai = p;
            if (info.compareTo((T) p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }
        if (p != null) {// Folha
            if (p.getEsquerda() == null && p.getDireita() == null) {
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda == true) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else {
                if (p.getDireita() == null) {//No Com um filho
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {
                        if (filhoEsquerda == true) {
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                } else {
                    if (p.getEsquerda() == null) {
                        if (p == getRaiz()) {
                            setRaiz(p.getEsquerda());
                        } else {
                            if (filhoEsquerda == true) {
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else {//nó com 2 filhos
                        NoArvoreBinaria sucessor = extrairSucessor(p);
                        if (p == getRaiz()) {
                            setRaiz(sucessor);
                        } else {
                            if (filhoEsquerda == true) {
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);
                            }
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }

            }
        }
    }

    public NoArvoreBinaria extrairSucessor(NoArvoreBinaria excluir) {
        NoArvoreBinaria p = excluir.getDireita();
        NoArvoreBinaria paiSucessor = excluir;
        NoArvoreBinaria sucessor = excluir;

        while (p != null) {
            paiSucessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();
        }
        if (sucessor != excluir.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        return sucessor;
    }
}
