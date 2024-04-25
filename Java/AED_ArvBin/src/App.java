import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static ABB inserirNaArvore(Aluno quem, ABB arvore){
        if (arvore==null)
            arvore = new ABB(quem);
        else
            arvore = arvore.inserir(quem, arvore);
        
        return arvore;

    }
    
    public static ABB carregarAlunos(String arq) throws FileNotFoundException, InterruptedException{
        File arquivo = new File(arq);
        Scanner leitor = new Scanner(arquivo);
        ABB arvore = null;

        String dadosAluno;

        while(leitor.hasNextLine()){
            dadosAluno = leitor.nextLine();
            String[] dados = dadosAluno.split(";");
            Aluno novo = new Aluno(dados[1], Integer.parseInt(dados[0]));
            arvore = inserirNaArvore(novo, arvore);
        }

        leitor.close();
        return arvore;
    }

    
    public static void main(String[] args) throws Exception {
        
         ABB turma = carregarAlunos("ALUNOS.TXT");
         System.out.println(turma.emOrdem(turma));
         System.out.println();

         Aluno buscar = turma.buscar(new Aluno("", 66993), turma);
         System.out.println(buscar.dadosAluno());
         System.out.println();

         System.out.println(turma.emOrdem(turma));

    }
}
