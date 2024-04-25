import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * Quero guardar nome, matrícula e 4 notas para alunos.
 * Depois, quero verificar qual aluno teve a melhor nota.
 * Depois, quero verificar quantos alunos tiverem nota acima da média da turma.
 * Vamos guardar notas para 5 alunos.
 * 
 */

 
public class AppFilaDin {
    static int quantasNotas = 4;
    
    
    static FilaDinamica lerDadosParaFilaDinamica(String nome) throws FileNotFoundException{
        File arqdados = new File(nome);
        Scanner leitor = new Scanner(arqdados);

        int quantosAlunos = Integer.parseInt(leitor.nextLine());
        FilaDinamica turma = new FilaDinamica();

        for(int i=0; i<quantosAlunos;i++){
            String linha = leitor.nextLine();
            Aluno quem = new Aluno(linha);
            turma.enfileirar(quem);    
        }
        leitor.close();
        return turma;
    }

    static Aluno criarAluno(Scanner teclado){
        System.out.println("ACRESCENTAR ALUNO À TURMA");
        String nome;
        int matricula;
        double nota;
        System.out.print("Nome: ");
        nome = teclado.nextLine();
        System.out.print("Matrícula: ");
        matricula = Integer.parseInt(teclado.nextLine());
        String linhaAluno = nome+";"+matricula+";";
        for(int i=0; i<quantasNotas; i++){
            System.out.print("Nota "+(i+1)+": ");
            nota = Double.parseDouble(teclado.nextLine());
            linhaAluno += nota+";";
        }
        Aluno novoAluno = new Aluno(linhaAluno);
        return novoAluno;
   }

    //#region Utilidades de tela

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Menu para o restaurante
     * @param teclado Scanner de leitura
     * @return Opção do usuário (int)
     */
		public static int menu(Scanner teclado){
			limparTela();
			System.out.println("XULAMBS ACADEMY");
			System.out.println("==========================");
            System.out.println("1 - Novo/adicionar aluno");
            System.out.println("2 - Pesquisar aluno");
            System.out.println("3 - Alunos aprovados");
            System.out.println("4 - Editar dados do aluno");
            System.out.println("5 - Imprimir todos os alunos");
            System.out.println("6 - Retirar da turma");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opção: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        }

    /**
     * Pausa para leitura de mensagens em console
     * @param teclado Scanner de leitura
     */
    static void pausa(Scanner teclado){
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }
    
    //#endregion

    

   
   
 

    public static void main(String[] args) throws Exception {
        FilaDinamica turma = lerDadosParaFilaDinamica("dadosAlunos.txt");
        
        
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        do{
            opcao = menu(teclado);
            switch(opcao){
                case 1: limparTela();
                        Aluno novoAluno = criarAluno(teclado);
                        turma.enfileirar(novoAluno);
                        System.out.println("Aluno adicionado ao fim da turma.");
                        pausa(teclado);
                    break;
                case 2: limparTela();
                        System.out.println("Não implementado para fila dinâmica. Que tal tentar?");
                        pausa(teclado);
                    break;
                case 3: limparTela();
                System.out.println("Não implementado para fila dinâmica. Que tal tentar?");
                        pausa(teclado);
                    break;
                case 5: limparTela();
                    System.out.println(turma.imprimir()); 
                    pausa(teclado);
                break;
                case 6: limparTela();
                       System.out.println("RETIRAR ALUNA/O:");
                       Aluno retirado = turma.desenfileirar();
                       if(retirado!=null){
                           System.out.println("Aluna/o: "+retirado.nome+" - Matric: "+retirado.matricula);
                           System.out.println();
                           System.out.println(turma.imprimir());
                       }
                       else
                           System.out.println("Aluna/o não encontrada/o");
                       pausa(teclado);
                break;
            }
        }while(opcao!=0);

        System.out.println("FIM DA EXECUÇÃO.");


    }
}
