public class ListaEncadeada {
   
    /** 
     * Elementos de controle. O primeiro é um sentinela
     */
    public ElementoAluno primeiro, ultimo;

    /**
     * Cria uma lista simplesmente encadeada vazia, com sentinela.
     */
    public ListaEncadeada(){
        primeiro = new ElementoAluno(null);
        ultimo = primeiro;
    }

    /**
     * Verifica se a lista está vazia
     * @return TRUE para lista vazia, FALSE caso contrário
     */
    public boolean listaVazia(){
        return (primeiro == ultimo);
    }

    /**
     * Inserção na última posição (como em uma fila)
     * @param quem Aluno a ser armazenado
     */
    public void inserirPorUltimo(Aluno quem){
        ElementoAluno novo = new ElementoAluno(quem);

        ultimo.proximo = novo;   //próximo do último aponta para o mesmo lugar do novo
        ultimo = novo;          //o último agora está no mesmo lugar do novo
    }

    //
    //  |42| -> |23| -> |08|----->|04|---->|32|¬
    //                                     novo
    //                                     ult
    //         
    /**
     * Localizar uma posição para inserção
     * @param posicao Posição numérica para inserção
     * @return O elemento naquela posição
     */
    public ElementoAluno localizarPosicao(int posicao){
        ElementoAluno aux = primeiro;
        int pos = 0;
        while((aux != ultimo) && ((pos+1) != posicao)){
            aux = aux.proximo;
            pos++;
        }
        return aux;
    }

    /**
     * Inserção posicionada na lista
     * @param quem Aluno a ser armazenado
     * @param posicao Posição desejada
     */
    public void inserirNaPosicao(Aluno quem, int posicao){
        ElementoAluno novo = new ElementoAluno(quem);
        ElementoAluno aux = localizarPosicao(posicao);

        novo.proximo = aux.proximo;
        aux.proximo = novo;
        if(aux == ultimo)
            ultimo = novo;
    }

    /**
     * Pesquisa na lista, por dado chave da classe Aluno
     * @param qual Aluno a ser localizado (mock)
     * @return Aluno ou null, se não encontrado
     */
    public ElementoAluno localizarDado(Aluno qual){
        ElementoAluno aux = primeiro;

        while(aux.proximo!=null && !aux.proximo.dadosAluno.ehIgual(qual)){
            aux = aux.proximo;
        }

        return aux; 
    }

    /**
     * Retira um aluno da lista, pela chave da classe Aluno
     * @param qual Aluno a ser retirado (mock)
     * @return Aluno ou null, se não existente
     */
    public Aluno retirarDado(Aluno qual){
        if(listaVazia())
            return null;
        
        ElementoAluno aux = localizarDado(qual);
        ElementoAluno auxRet = aux.proximo;

        if(auxRet == null)
            return null;
        else{    
            aux.proximo = auxRet.proximo;
            auxRet.proximo = null;

            if(auxRet == ultimo)
                ultimo = aux;

            return auxRet.dadosAluno;
        }
    }


    // P-> |42| -> |23| -> |08|-->|04|-->|32|¬
    //                            aux     ult
    //                                     
    //         

     // P-> |42| -> |23|¬
     //                 aux

     /**
      * Pesquisa e retorna um aluno pela chave da classe
      * @param qual Aluno a ser pesquisado (mock)
      * @return Aluno ou null, se não encontrado
      */
    public Aluno pesquisar(Aluno qual){
        ElementoAluno aux = primeiro.proximo;

        while(aux!=null && !aux.dadosAluno.ehIgual(qual)){
            aux = aux.proximo;
        }

        if(aux == null)
            return null;
        else
            return aux.dadosAluno;
    }

    
    /**
     * Retorna dados da lista em string
     * @return String com dados da lista
     */
    public String imprimir(){
        if(listaVazia())
            return "LISTA VAZIA!!!";

        StringBuilder sb = new StringBuilder("LISTA: \n");
        ElementoAluno aux = primeiro.proximo;
        while(aux != null){
            sb.append(aux.dadosAluno.matricula+ ": "+aux.dadosAluno.nome+"\n");
            aux = aux.proximo;   
        }
        sb.append("====================");
        return sb.toString();
    }
}
