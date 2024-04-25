public class FilaEstatica {
    
    final int TAM_MAXIMO = 5; //lembre-se: final --> é uma constante
    int quantidade = 0;
    Aluno dados[] = new Aluno[TAM_MAXIMO];

    /**
     * Inserção em uma fila estática de alunos
     * @param novo Novo aluno a ser armazenado
     * @return TRUE se havia espaço e foi inserido; FALSE caso contrário
     */
    boolean enfileirar(Aluno novo){
        boolean resposta = false;
        if(quantidade < TAM_MAXIMO){
            dados[quantidade] = novo;
            quantidade++;
            resposta = true;
        }
        return resposta;
    }

    /**
     * Retira (desenfileira) o primeiro aluno da fila
     * @return Um aluno, ou null caso a fila esteja vazia
     */
    Aluno desenfileirar(){   //para que serve um parâmetro? para informar algo 
                             //que o método não sabe.
        Aluno saida = null;
        if(quantidade > 0){
            saida = dados[0];
            for(int i = 1; i<quantidade; i++){
                 dados[i-1] = dados[i];
            }
            quantidade--;
        }
        return saida;
    }

    String dadosFila(){
        StringBuilder aux = new StringBuilder("FILA\n==========\n");

        for(int i = 0; i<quantidade; i++){
            aux.append((i+1) + " - "+dados[i].nome+ " Matrícula: "+dados[i].matricula+"\n");
        }

        return aux.toString();
    }




}
