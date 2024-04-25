
public class Aluno{
    public static final int QTAVALIACOES = 4;
    public int mat;
    public String nome;
    public double[] avaliacoes;
    public int totalAulas;
    public int totalPresenca;

    /*
    * Método construtor
    */
    public Aluno(String nome, int mat){
        this.mat = mat;
        this.nome = nome;
        this.avaliacoes = new double[QTAVALIACOES];
        this.totalAulas = 80;
        this.totalPresenca = 0;
    }

    public void lancarNota(int pos, double valor){
        if(pos<QTAVALIACOES && valor >=0){
            avaliacoes[pos] = valor;
        }
    }
    
    public Aluno clone(){
        Aluno novo = new Aluno(this.nome, this.mat);
        novo.avaliacoes = this.avaliacoes;
        novo.totalAulas = this.totalAulas;
        novo.totalPresenca = this.totalPresenca;
        return novo;
    }
    public boolean igual(Aluno outro){
        if (mat == outro.mat) return true;
        else return false;
    }

    public boolean ehMenorQue(Aluno outro){
        if(mat < outro.mat) return true;
        else return false;
    }

    public double notaFinal(){
        double soma = 0;
        for (double nota : avaliacoes) {
            soma+=nota;
        }
        return soma;
    }
    public String dadosAluno(){
        String auxDados="";
        auxDados+= mat+" - ";
        auxDados+= "Nome: "+nome+"\n";
        auxDados+= "Nota final: ";
        auxDados+= this.notaFinal() +"\n";
        return auxDados;
    }
  

}




