public class Aluno {
    
    String nome;
    int matricula;
    double[] notas;
    int quantasNotas;
    
    //construtor: cria um aluno
    // linha com Joelma;121;12.5;20.8;13.9;19.6
    public Aluno(String linha){
        quantasNotas = 4;
        notas = new double[quantasNotas];
        String[] dadosAlunos = linha.split(";");
        nome = dadosAlunos[0];
        matricula = Integer.parseInt(dadosAlunos[1]);
     
        for(int j=0; j<quantasNotas; j++){
            notas[j] = Double.parseDouble(dadosAlunos[j+2]);
        }
    }

    public double notaFinal(){
        double aux=0d;
        for(int j=0; j<quantasNotas; j++){
            aux+= notas[j];
        }
        return aux;
    }

    public boolean acimaDaMedia(double mediaDaTurma){
        return (notaFinal() > mediaDaTurma);
    }

    public boolean aprovado(double notaMinima){
        return acimaDaMedia(notaMinima);
    }
}


/// DADOS: Aluno  (guarda os dados de interesse)
/// APONTADOR/ELEMENTO: Aluno + ponteiro (mantem a estrutura de dados)
/// ESTR.DADOS (regras de insercao, retirada (pesquisa))