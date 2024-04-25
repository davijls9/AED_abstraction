import java.util.Random;
import java.util.Scanner;



public class App {


    public void xulambs(){
        String s1 = "João";
        String s2 = "Ana";
        s1.compareTo(s2);       // vai retornar um número positivo (João é "maior")

        s1 = "Alvaro";
        s1.compareTo(s2);       // vai retornar um número negativo (Alvaro é "menor")

        s1 = "Ana";
        s1.compareTo(s2);       // vai retornar 0 (são iguais)
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Random sorteio = new Random(System.currentTimeMillis());
        ABB arvoreTurma; 
        Aluno novo ;
        String[] nomes = {"Renato", "Erik", "Vinicius", "Geovanna", "Matheus",
                          "Weslley", "Stephany", "Hugo", "Gustavo", "João"};

        int mat = 100_000 + sorteio.nextInt(900_000);
        novo = new Aluno(nomes[0], mat);
        novo.lancarNota(0, 60 + sorteio.nextInt(40));
        
        arvoreTurma = new ABB(novo);

        for (int i = 1; i < nomes.length; i++) {
            mat = 100_000 + sorteio.nextInt(900_000);
            novo = new Aluno(nomes[i], mat);
            novo.lancarNota(0, 60+ sorteio.nextInt(40));
            arvoreTurma.inserir(novo, arvoreTurma);
        }

        System.out.println(arvoreTurma.dadosArvore(arvoreTurma));

        System.out.println("================================");
        int opcao;
        System.out.print("1 para buscar ou 2 para retirar: ");
        opcao = Integer.parseInt(teclado.nextLine());

        if(opcao == 1){
            System.out.print("Entre uma matrícula para buscar: ");
            int matBusca = Integer.parseInt(teclado.nextLine());

            Aluno alunoBusca = new Aluno("", matBusca);

            Aluno achou = arvoreTurma.buscar(alunoBusca, arvoreTurma);

            if(achou!=null)
                System.out.println(achou.dadosAluno());
            else
                System.out.println("Aluno "+matBusca+" não existe.");
        }
        else{
            System.out.print("Entre uma matrícula para retirar: ");
            int matRet = Integer.parseInt(teclado.nextLine());

            Aluno alunoRet = new Aluno("", matRet);     //objeto MOCK 

            arvoreTurma.retirar(alunoRet, arvoreTurma);

            System.out.println("Nova turma:");
            System.out.println(arvoreTurma.dadosArvore(arvoreTurma));
            
        }
        teclado.close();
    }
}

//     R
//    / \
//   e   d
//  /
// x     x e R d