/**
 * Classe Pilha para cartas de um baralho tradicional.
 */

class PilhaCartas {
    public ElementoCarta topo; // topo da pilha (sentinela)

    /**
     * Construtor com elemento sentinela (pilha vazia)
     */
    public PilhaCartas() { // sentinela: o topo nunca vai ter dados reais
        topo = new ElementoCarta(null);
    }

    /**
     * Empilhar. Insere uma carta próxima ao topo
     * 
     * @param c A carta a ser inserida
     */
    public void push(Carta c) { // empilhar
        ElementoCarta elemento = new ElementoCarta(c);
        elemento.proximo = topo.proximo;
        topo.proximo = elemento;
    }

    /**
     * Desempilhar
     * 
     * @return A carta mais próxima do topo ou null, se pilha vazia
     */
    public Carta pop() { // desempilhar
        if (pilhaVazia())
            return null;
        else {
            ElementoCarta aux = topo.proximo; // aux na frente do sentinela
            topo.proximo = aux.proximo; // pulamos o elemento
            aux.proximo = null; // precaução extra
            return aux.minhaCarta;
        }
    }

    /**
     * Verifica a carta do topo, sem retirar
     * 
     * @return A carta do topo, ou null
     */
    public Carta peek() { // observar o topo da pilha, sem retirar
        if (pilhaVazia())
            return null;
        else
            return topo.proximo.minhaCarta;
    }

    /**
     * Sinaliza pilha vazia
     * 
     * @return TRUE para pilha vazia, FALSE caso contrário.
     */
    public boolean pilhaVazia() {
        return (topo.proximo == null);
    }
}