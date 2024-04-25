public class App {
    
    static void somar(int a, int b){
        a = a+b;
        System.out.println(a);
    }
    
    static int somarInt(int a, int b){
        a = a+b;
        System.out.println(a);
        return a;
    }

    static void dadosAluno(Aluno a){
        System.out.println(a.nome +" - "+a.matricula);
    }

    static void mudarDadosAluno(Aluno a){
        a.nome = "Maria";
        a.matricula = 4223;
    }

    static void criarNovoAluno(Aluno a){
        a = new Aluno("Maria", 4223);
    }
    public static void main(String[] args) throws Exception {
        
    }
}
