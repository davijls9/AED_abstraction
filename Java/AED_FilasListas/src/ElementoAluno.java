public class ElementoAluno {
    
    public Aluno dadosAluno;
    public ElementoAluno proximo;  //apontador 

    public ElementoAluno(Aluno quem){
        dadosAluno = quem;
        proximo = null;
    }
//aluno
}
