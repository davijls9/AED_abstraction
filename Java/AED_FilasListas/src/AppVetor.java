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

 //UMA CLASSE É UM MODELO PARA UM CONJUNTO DE DADOS.
 //UMA CLASSE DEVE REPRESENTAR UMA ENTIDADE DO MUNDO REAL.
 //UMA CLASSE DEVE TER:
 //     -- DADOS DA ENTIDADE
 //     -- MÉTODOS PARA ACESSAR OU MODIFICAR OS DADOS DA ENTIDADE
 //CADA CLASSE GERA UM CONJUNTO DE OBJETOS ÚNICOS/INDIVIDUAIS
 //CADA OBJETO A SER UTILIZADO DEVE SER CRIADO NO NOSSO SISTEMA/APP

public class AppVetor {
    static int quantasNotas = 4;
    
    
    static Aluno[] lerDadosParaVetor(String nome) throws FileNotFoundException{
        File arqdados = new File(nome);
        Scanner leitor = new Scanner(arqdados);

        int quantosAlunos = Integer.parseInt(leitor.nextLine());
        Aluno[] todos = new Aluno[quantosAlunos];

        for(int i=0; i<quantosAlunos;i++){
            String linha = leitor.nextLine();
            todos[i] = new Aluno(linha);    
        }
        leitor.close();
        return todos;
    }
   
     
    static Aluno alunoComMaiorNota(Aluno[] turma){
        double maior = 0d;
        Aluno maiorAluno = null;
        for(int i=0; i<turma.length;i++){
            if(turma[i].notaFinal() >  maior){
                maior = turma[i].notaFinal();
                maiorAluno = turma[i];
            }
        }
        return maiorAluno;
    }
    
    static double mediaDaTurma(Aluno[] turma){
        double somaTurma = 0d;
        for(int i=0; i<turma.length; i++)
            somaTurma += turma[i].notaFinal();

        return somaTurma/turma.length;
    }

    static void pesquisarAluno(Aluno[] turma, String nomeBusca){
        for(int i =0 ; i<turma.length; i++){
            if(turma[i]!=null){
                if(turma[i].nome.contains(nomeBusca)){
                    System.out.println(turma[i].nome + " - "+turma[i].notaFinal());
                }
            }
        }
    }
    
    static void alunosAprovados(Aluno[] turma, double notaMinima){
        for(int i=0 ; i<turma.length; i++){
            if(turma[i]!=null){
                if(turma[i].aprovado(notaMinima))
                    System.out.println(turma[i].nome + " aprovada/o.");
            }
        }
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

    //#region Utilidades de Tela
    
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
        Aluno[] turma = lerDadosParaVetor("dadosAlunos.txt");
        
        double notaMinima = 60.0;
        
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        do{
            opcao = menu(teclado);
            switch(opcao){
                case 1: limparTela();
                        System.out.println("Vetor de tamanho definido. Impossível adicionar.");
                        pausa(teclado);
                    break;
                case 2: limparTela();
                        System.out.println("PESQUISAR ALUNA/O:");
                        String nomeBusca;
                        System.out.print("Digite um trecho do nome: ");
                        nomeBusca = teclado.nextLine();
                        pesquisarAluno(turma, nomeBusca);  
                       
                        pausa(teclado);
                    break;
                case 3: limparTela();
                        System.out.println("ALUNOS APROVADOS:"); 
                       alunosAprovados(turma, notaMinima);             
                  
                        pausa(teclado);
                    break;
                case 5: limparTela();
                    for (Aluno aluno : turma) {
                        System.out.println("Matrícula: "+aluno.matricula+ " - "+aluno.nome);   
                    }
                    System.out.println("FIM DA LISTA");                  
                    pausa(teclado);
                break;
                case 6: limparTela();
                        System.out.println("Vetor fixo. Não se pode retirar neste momento.");
                       pausa(teclado);
                break;
            }
        }while(opcao!=0);

        
        System.out.println("FIM DA EXECUÇÃO.");


    }
}
