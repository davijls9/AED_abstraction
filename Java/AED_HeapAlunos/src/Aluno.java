import java.util.Random;

public class Aluno extends DadoGenerico{
    
    static Random sorteio = new Random();

    String nome; 
    int matricula;  //identificador
    double[] notas;
    int quantasNotas;
    
    public Aluno(int matr){
        matricula = matr;
    }

    public Aluno(String nomeAluno){
        nome = nomeAluno;
        matricula = sorteio.nextInt(999_999);
        quantasNotas = 0;
        notas = new double[4];
    }

    //construtor: cria um aluno
    // linha com Joelma;121;12.5;20.8;13.9;19.6
    // public Aluno(String linha){
    //     quantasNotas = 4;
    //     notas = new double[quantasNotas];
    //     String[] dadosAlunos = linha.split(";");
    //     nome = dadosAlunos[0];
    //     matricula = Integer.parseInt(dadosAlunos[1]);
     
    //     for(int j=0; j<quantasNotas; j++){
    //         notas[j] = Double.parseDouble(dadosAlunos[j+2]);
    //     }
    // }


    @Override
    public boolean ehIgual(DadoGenerico outro){
        Aluno aux = (Aluno)outro;
        if(matricula == aux.matricula)
            return true;
        else 
            return false;
    }

    /**
     * Compara o objeto atual com outro aluno, retornando TRUE se é prioritário.
     * O critério atual de prioridade é a maior nota final. 
     * @param outro O aluno a ser comparado
     * @return TRUE se este aluno é prioritário, FALSE se o outro é prioritário
     */
    @Override
     public boolean prioritario(DadoGenerico outro){
        Aluno aux = (Aluno)outro;
        double minhaNota = notaFinal();
        double notaDoOutro = aux.notaFinal();

        if(minhaNota > notaDoOutro)
            return true;
        else
            return false;
    }

    @Override
    public boolean ehMenor(DadoGenerico outro){
        Aluno aux = (Aluno)outro;
        if(matricula < aux.matricula)
            return true;
        else 
            return false;
    }

    
    public void lancarNota(double nota){
        if(quantasNotas < notas.length){
            notas[quantasNotas] = nota;
            quantasNotas++;
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