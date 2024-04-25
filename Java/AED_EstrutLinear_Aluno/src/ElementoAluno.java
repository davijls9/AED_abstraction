public class ElementoAluno {
    
    public Aluno dadosAluno;
    public ElementoAluno proximo;

    public ElementoAluno(Aluno quem){
        dadosAluno = quem;
        proximo = null;
    }

}
