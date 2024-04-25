public class ListaEncadeada {
    public ElementoAluno primeiro;
    public ElementoAluno ultimo;

    public ListaEncadeada(){
        primeiro = new ElementoAluno(null);
        ultimo = primeiro;
    }

    public void inserir(Aluno novo){
        ElementoAluno novoElemento = new ElementoAluno(novo);

        ultimo.proximo = novoElemento;
        ultimo = novoElemento;
    }

    public Aluno localizar(Aluno quem){
        ElementoAluno aux = primeiro.proximo;

        while(aux!=null){
            if(quem.igual(aux.meuAluno))
                return aux.meuAluno;
            else aux = aux.proximo;
        }
        return null;
    }

    public Aluno retirar(Aluno quem){
        ElementoAluno aux = primeiro;

        while(aux.proximo!=null){
            if(quem.igual(aux.proximo.meuAluno)){
                //código da retirada
                ElementoAluno auxRet = aux.proximo;
                
                aux.proximo = auxRet.proximo;
                auxRet.proximo = null;
                if(auxRet == ultimo)
                    ultimo = aux;

                return auxRet.meuAluno;
            }
            else aux = aux.proximo;
        }
        return null;
    }

    public void imprimir(){
        ElementoAluno aux = primeiro.proximo;
        
        while(aux!=null){
            System.out.println(aux.meuAluno.nome + " - "+ aux.meuAluno.mat);
            aux = aux.proximo;
        }
        System.out.println("FIM DA LISTA.");
    }

    
}
