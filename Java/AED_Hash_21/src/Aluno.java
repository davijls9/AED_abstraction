 
public class Aluno{
    public static final int QUANTNOTAS=4;
    public int mat; //matrícula de 6 dígitos
    public String nome;
    public double notas[];
    public int totalAulas;
    public int totalPresenca;

    /*
    * Método construtor
    */
    public Aluno(String nome){
        this.mat = 1;
        this.nome = nome;
        this.notas = new double[QUANTNOTAS];
        this.totalAulas = 80;
        this.totalPresenca = 0;
    }

    public boolean lancarNota(int qual, double valor){
        if(qual<QUANTNOTAS){
            if(valor>=0.0)
                notas[qual] = valor;
            return true;
        }
        else
            return false;
    }

    public boolean igual(Aluno outro){
        if (mat == outro.mat) return true;
        else return false;
    }

    public boolean maiorNota(Aluno outro){
        Aluno aux = (Aluno)outro;
        
        if(this.calcNotaFinal() > aux.calcNotaFinal())
            return true;
        else
            return false;
    }

    public double calcNotaFinal(){
        double aux = 0d;

        for(int i=0 ; i<this.notas.length; i++)
            aux += notas[i];
        
        //for (double notaParcial : notas) 
        //    aux += notaParcial;

        return aux;
    }

    public double calcFrequencia(){
            double freq = (double)totalPresenca/totalAulas;
            return freq;
    }
    
 
    public boolean aprovado(){
        if((calcFrequencia()>=0.75) && (calcNotaFinal()>=60)) 
            return true;
        else 
            return false;
    }

    @Override
    public int hashCode(){
        //matrícula de 6 dígitos. (entre 100.000 e 999.999)
        //quadrado da matrícula, pegar terceiro e quinto
        //valor entre 10.000.000.000 e 999.998.000.001
        //ex: 10.000.284.572, para tirar os dois últimos: tirar o resto de 100
        
        long quadrado = (long)Math.pow(mat, 2.0d);
        long terceiro = (quadrado % 1000) / 100;
        long quinto  = (quadrado % 100_000) / 10_000;
        int code = (int) (terceiro*10 + quinto);

        return code;
    }

    public String dadosAluno(){
        String auxDados="";
        auxDados+= mat+" - ";
        auxDados+= "Nome: "+nome+"\n";
        auxDados+= "Notas: ";
        for(int n=0; n<QUANTNOTAS; n++){
            auxDados += String.format("%2.2f ", notas[n]);        //notas formatadas com 2 casas decimais
        }
        auxDados+="\nNota final: "+ String.format("%2.2f", calcNotaFinal())+"\n";   

        return auxDados;
    }
  

}




