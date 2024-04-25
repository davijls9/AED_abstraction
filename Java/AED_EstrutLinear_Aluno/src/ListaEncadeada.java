public class ListaEncadeada {
   
    public ElementoAluno primeiro, ultimo;

    public ListaEncadeada(){
        primeiro = new ElementoAluno(null);
        ultimo = primeiro;
    }

    public boolean filaVazia(){
        return (primeiro == ultimo);
    }

    public void inserirPorUltimo(Aluno quem){
        ElementoAluno novo = new ElementoAluno(quem);

        ultimo.proximo = novo;
        ultimo = novo;
    }

    public ElementoAluno localizarPosicao(int posicao){
        ElementoAluno aux = primeiro;
        int pos = 0;
        while((aux != ultimo) && ((pos+1) != posicao)){
            aux = aux.proximo;
            pos++;
        }
        return aux;
    }

    public void inserirNaPosicao(Aluno quem, int posicao){
        ElementoAluno novo = new ElementoAluno(quem);
        ElementoAluno aux = localizarPosicao(posicao);

        novo.proximo = aux.proximo;
        aux.proximo = novo;
        if(aux == ultimo)
            ultimo = novo;
    }



    public String imprimir(){
        if(filaVazia())
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
