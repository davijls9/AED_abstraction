public class TabHash {
    int capacidade;
    int quantidade;
    ListaEncadeada[] dados;
    
    public TabHash(int cap){
        this.capacidade = cap;
        this.quantidade = 0;
        dados = new ListaEncadeada[this.capacidade];  // o que temos no vetor agora? NADA!!!

        for(int i=0; i<this.capacidade; i++){
            dados[i] = new ListaEncadeada();
        }   //agora sim, temos uma lista vazia em cada posição.
    }

    public int funcaoHash(Aluno aluno){
        int posicao = aluno.hashCode();
        return(posicao % capacidade);
    }

    public void inserir(Aluno aluno){
        int posicao = funcaoHash(aluno);
        dados[posicao].inserir(aluno);
        quantidade++;
    }

    public Aluno buscar(Aluno quem){        //aluno "mock" para busca
        int posicao = funcaoHash(quem);
        Aluno aux = dados[posicao].localizar(quem);
        return aux;
    }

    public void imprimirTudo(){
        
        for(int i=0; i<capacidade; i++){
            System.out.println("Posição "+i);
            dados[i].imprimir(); 
        }
    }
    
}
