package estruturas;

public class ArvoreBinariaPesquisa {
    private class Nodo {
        private int chave;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;

        public Nodo(int chave) {
            this.chave = chave;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa() {
        tamanho = 0;
    }

    public void adicionar(int chave) {
        Nodo n = new Nodo(chave);
        if (raiz == null) {
            raiz = n;
        } else {
            adicionarRecursivo(n, raiz);
        }
        tamanho++;
    }

    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if (n.chave <= pai.chave) {
            if (pai.esquerda == null) {
                pai.esquerda = n;
                n.pai = pai;
            } else {
                adicionarRecursivo(n, pai.esquerda);
            }
        } else {
            if (pai.direita == null) {
                pai.direita = n;
                n.pai = pai;
            } else {
                adicionarRecursivo(n, pai.direita);
            }
        }
    }

    private Nodo obterNodoRecursivo(int chave, Nodo n) {
        if (n == null) return null;
        if (chave == n.chave) return n;
        if (chave < n.chave) return obterNodoRecursivo(chave, n.esquerda);
        return obterNodoRecursivo(chave, n.direita);
    }

    public String caminharPreOrdem() {
        StringBuilder sb = new StringBuilder();
        caminharPreOrdemRecursivo(raiz, sb);
        return sb.toString().trim();
    }

    private void caminharPreOrdemRecursivo(Nodo n, StringBuilder sb) {
        if (n != null) {
            sb.append(n.chave).append(" ");
            caminharPreOrdemRecursivo(n.esquerda, sb);
            caminharPreOrdemRecursivo(n.direita, sb);
        }
    }

    public String caminharPosOrdem() {
        StringBuilder sb = new StringBuilder();
        caminharPosOrdemRecursivo(raiz, sb);
        return sb.toString().trim();
    }

    private void caminharPosOrdemRecursivo(Nodo n, StringBuilder sb) {
        if (n != null) {
            caminharPosOrdemRecursivo(n.esquerda, sb);
            caminharPosOrdemRecursivo(n.direita, sb);
            sb.append(n.chave).append(" ");
        }
    }

    public String caminharCentral() {
        StringBuilder sb = new StringBuilder();
        caminharCentralRecursivo(raiz, sb);
        return sb.toString().trim();
    }

    private void caminharCentralRecursivo(Nodo n, StringBuilder sb) {
        if (n != null) {
            caminharCentralRecursivo(n.esquerda, sb);
            sb.append(n.chave).append(" ");
            caminharCentralRecursivo(n.direita, sb);
        }
    }

    public String caminharLargura() {
        if (raiz == null) return "";

        StringBuilder sb = new StringBuilder();
        Fila fila = new Fila();
        fila.enfileirar(raiz.chave);

        while (!fila.estaVazia()) {
            int chaveAtual = fila.desenfileirar();
            sb.append(chaveAtual).append(" ");
            Nodo n = obterNodoRecursivo(chaveAtual, raiz);
            if (n != null) {
                if (n.esquerda != null) fila.enfileirar(n.esquerda.chave);
                if (n.direita != null) fila.enfileirar(n.direita.chave);
            }
        }
        return sb.toString().trim();
    }

    public String buscarComRastreamento(int chave) {
        StringBuilder sb = new StringBuilder();
        Nodo atual = raiz;
        int visitados = 0;

        while (atual != null) {
            sb.append(atual.chave).append(" ");
            visitados++;

            if (chave == atual.chave) {
                break;
            } else if (chave < atual.chave) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        return sb.toString().trim() + ";" + visitados + ";" + (atual != null && atual.chave == chave);
    }

    public int obterTamanho() {
        return tamanho;
    }

    public String imprimirArvore() {
        StringBuilder sb = new StringBuilder();
        imprimirArvoreRecursivo(raiz, 0, sb);
        return sb.toString();
    }

    private void imprimirArvoreRecursivo(Nodo n, int nivel, StringBuilder sb) {
        if (n != null) {
            imprimirArvoreRecursivo(n.direita, nivel + 1, sb);
            for (int i = 0; i < nivel; i++) {
                sb.append("   ");
            }
            sb.append(n.chave).append("\n");
            imprimirArvoreRecursivo(n.esquerda, nivel + 1, sb);
        }
    }
}