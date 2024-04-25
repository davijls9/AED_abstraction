public class ElementoAluno {
    public Aluno meuAluno;
    public ElementoAluno proximo;

    public ElementoAluno(Aluno dado){
        meuAluno = dado;
        proximo = null;
    }
}
