package app;

/**
 * TABELA HASH COM ENDEREÇAMENTO ABERTO
 */
public class TabHash {
    public ElementoHash[] dadosTabela;
    public final int TAMANHO;

    public TabHash(int tam){
        if (tam > 0){
            TAMANHO = tam;
        }
        else
            TAMANHO = 1;
        dadosTabela = new ElementoHash[TAMANHO];
    }

    //#region inserção
    public void inserir(Jogador novo){
        ElementoHash novoElemento = new ElementoHash(novo);
        int pos = novoElemento.hashCode() % TAMANHO;
        int posicaoDeVerdade = determinarPosInsercao(pos);
        dadosTabela[posicaoDeVerdade] = novoElemento;
    }

    /**
     * Método para verificar as colisões antes da inserção efetiva
     * @param inicio Posição inicial (determinada pelo hashInicial)
     * @return
     */
    private int determinarPosInsercao(int inicio){
    
    
    }
    //#endregion
    
    //#region busca
    public Jogador buscar(Jogador quem){
        int pos = quem.hashCode();
        int posDeVerdade = determinarPosBusca(pos, quem);

        if (dadosTabela[posDeVerdade] != null)
            return dadosTabela[posDeVerdade].dado;
        else
            return null;
    }

    /**
     * Método para verificar as colisões durante o processo de busca
     * @param inicio Posição inicial (determinada pelo hashInicial)
     * @param quem Jogador (mock) para a busca efetiva
     * @return A posição com o dado buscado (ou do dado nulo encontrado)
     */
    private int determinarPosBusca(int inicio, Jogador quem){
        
        
    }
    //#endregion

    //#region retirada
    public Jogador retirar(Jogador quem){
        
    }

    //#endregion
    

    /**
     * Impressão de toda a tabela, incluindo linhas vazias.
     */
    @Override
    public String toString(){
        StringBuilder aux = new StringBuilder();
        for(int i=0; i<TAMANHO; i++){
            aux.append(String.format("00", i) + ": ");
            if (dadosTabela[i] != null && dadosTabela[i].valido)
                aux.append(dadosTabela[i].toString()+"\n");
            else
                aux.append("\n");
        }

        return aux.toString();
    }
}