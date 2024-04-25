public class ABB {
    Aluno raiz;
    ABB esquerda;
    ABB direita;

    public ABB(Aluno quem){
        raiz = quem;
        esquerda = null;
        direita = null;
    }

    public ABB inserir(Aluno qual, ABB onde){
        if(onde == null){
            ABB novoNodo = new ABB(qual);
            return novoNodo;
        }
        else{
            if(qual.ehMenorQue(onde.raiz))
                onde.esquerda = inserir(qual, onde.esquerda);
            else
                onde.direita = inserir(qual, onde.direita);
        }
        return onde;
    }

    public Aluno buscar(Aluno qual, ABB onde){
        if(onde!=null){
            
            if(qual.igual(onde.raiz))
                return onde.raiz;
            if(qual.ehMenorQue(onde.raiz))
              return buscar(qual, onde.esquerda);
            else
              return buscar(qual, onde.direita);
        }
        else 
            return null;
    }

    public String emOrdem(ABB onde){
        if(onde!=null){
            String aux = emOrdem(onde.esquerda);
            aux+= onde.raiz.dadosAluno();
            aux+= emOrdem(onde.direita);
            return aux;
        }
        else return "";
    }


}
