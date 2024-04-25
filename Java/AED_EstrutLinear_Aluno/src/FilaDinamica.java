public class FilaDinamica {
    
    public ElementoAluno primeiro, ultimo;

    public FilaDinamica(){
        primeiro = new ElementoAluno(null);
        ultimo = primeiro;
    }

    public boolean filaVazia(){
        return (primeiro == ultimo);
    }

    public void enfileirar(Aluno quem){
        ElementoAluno novo = new ElementoAluno(quem);

        ultimo.proximo = novo;
        ultimo = novo;
    }

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
