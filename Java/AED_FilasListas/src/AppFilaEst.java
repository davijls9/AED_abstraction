import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 * Quero guardar nome, matrícula e 4 notas para alunos.
 * Depois, quero verificar qual aluno teve a melhor nota.
 * Depois, quero verificar quantos alunos tiverem nota acima da média da turma.
 * Vamos guardar notas para 5 alunos.
 * 
 */

 
public class AppFilaEst {
    static int quantasNotas = 4;
 
    static FilaEstatica lerDadosParaFilaEstatica(String nome) throws FileNotFoundException{
        File arqdados = new File(nome);
        Scanner leitor = new Scanner(arqdados);

        int quantosAlunos = Integer.parseInt(leitor.nextLine());
        FilaEstatica turma = new FilaEstatica();

        for(int i=0; i<quantosAlunos;i++){
            String linha = leitor.nextLine();
            Aluno novo = new Aluno(linha);
            boolean funfou = turma.enfileirar(novo);
            if(!funfou)
                System.out.println("Fila cheia, não foi possível inserir o aluno "+(i+1));
        }
        leitor.close();
        return turma;
    }

    static Aluno alunoComMaiorNota(FilaEstatica turma){
        double maior = 0d;
        Aluno maiorAluno = turma.dados[0];

        for(int i=1; i<turma.quantidade;i++){
            if(turma.dados[i].notaFinal() >  maior){
                maior = turma.dados[i].notaFinal();
                maiorAluno = turma.dados[i];
            }
        }
        return maiorAluno;
    }
    
 

   
    
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

    static void salvarDados(Aluno[] turma, FileWriter arquivo) throws IOException{
        for(int i=0; i<turma.length; i++){
            if(turma[i]!=null){
                String linha = turma[i].nome+";"+turma[i].matricula+";";
                for(int j = 0; j<quantasNotas; j++){
                    linha+= turma[i].notas[j]+";";
                }
                arquivo.write(linha+"\n");
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

    public static void main(String[] args) throws Exception {
        FilaEstatica turma = lerDadosParaFilaEstatica("dadosAlunos.txt");
        
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        do{
            opcao = menu(teclado);
            switch(opcao){
                case 1: limparTela();
                        Aluno novoAluno = criarAluno(teclado);
                        turma.enfileirar(novoAluno);                                          
                        pausa(teclado);
                    break;
                case 2: limparTela();
                        System.out.println("PESQUISAR ALUNA/O:");
                        int matBusca;
                        System.out.print("Digite a matrícula: ");
                        matBusca = Integer.parseInt(teclado.nextLine());
                        Aluno qual = new Aluno(matBusca); //objeto MOCK (não é real)
                        Aluno buscado = turma.pesquisar(qual);
                        if(buscado!=null){
                            System.out.println("Aluna/o: "+buscado.nome+" - Matric: "+buscado.matricula);
                        }
                        else
                            System.out.println("Aluna/o não encontrada/o");

                        pausa(teclado);
                    break;
                case 3: limparTela();
                        System.out.println("Ainda não implementado! Que tal tentar?");
                        pausa(teclado);
                    break;
                case 5: limparTela();
                    System.out.println(turma.dadosFila()); 
                   
                    pausa(teclado);
                break;
                case 6: limparTela();
                       
                       System.out.println("RETIRAR ALUNA/O:");
                       Aluno retirado = turma.desenfileirar();
                       if(retirado!=null){
                           System.out.println("Aluna/o: "+retirado.nome+" - Matric: "+retirado.matricula);
                           System.out.println();
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
