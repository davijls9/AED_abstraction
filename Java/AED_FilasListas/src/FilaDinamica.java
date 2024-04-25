public class FilaDinamica {
    
    /**
     * Elementos de controle. O primeiro é um sentinela.
     */
    public ElementoAluno primeiro, ultimo;

    /**
     * Cria uma fila dinâmica vazia com elemento sentinela.
     */
    public FilaDinamica(){
        primeiro = new ElementoAluno(null);
        ultimo = primeiro;
    }

    /**
     * Verifica se a fila está vazia
     * @return TRUE para fila vazia, FALSE caso contrário
     */
    public boolean filaVazia(){
        return (primeiro == ultimo);
    }

    /**
     * Enfileira um aluno
     * @param quem O aluno a ser armazenado
     */
    public void enfileirar(Aluno quem){
        ElementoAluno novo = new ElementoAluno(quem);

        ultimo.proximo = novo;
        ultimo = novo;
    }

    /**
     * Desenfileira o primeiro aluno da fila
     * @return Um aluno, ou null se fila vazia
     */
    public Aluno desenfileirar(){
        if(filaVazia())
            return null;
        
        ElementoAluno aux = primeiro.proximo;
        primeiro.proximo = aux.proximo;
        aux.proximo = null;
        if(aux == ultimo)
            ultimo = primeiro;
        return aux.dadosAluno;
    }

    /**
     * Retorna os dados da turma em string
     * @return Uma string com os dados da turma.
     */
    public String imprimir(){
        if(filaVazia())
            return "FILA VAZIA!!!";

        StringBuilder sb = new StringBuilder("FILA: \n");
        ElementoAluno aux = primeiro.proximo;
        while(aux != null){
            sb.append(aux.dadosAluno.matricula+ ": "+aux.dadosAluno.nome+"\n");
            aux = aux.proximo;   
        }
        sb.append("====================");
        return sb.toString();
    }

}
