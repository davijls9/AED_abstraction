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

 //UMA CLASSE É UM MODELO PARA UM CONJUNTO DE DADOS.
 //UMA CLASSE DEVE REPRESENTAR UMA ENTIDADE DO MUNDO REAL.
 //UMA CLASSE DEVE TER:
 //     -- DADOS DA ENTIDADE
 //     -- MÉTODOS PARA ACESSAR OU MODIFICAR OS DADOS DA ENTIDADE
 //CADA CLASSE GERA UM CONJUNTO DE OBJETOS ÚNICOS/INDIVIDUAIS
 //CADA OBJETO A SER UTILIZADO DEVE SER CRIADO NO NOSSO SISTEMA/APP

public class App {
    static int quantasNotas = 4;
    
    //REPRESENTAM O ALUNO
    static double[][] notas;
    static String[] nomes;
    static int[] matriculas;
    //---FIM DE UM ALUNO

    static void lerDadosArquivo(String nome) throws FileNotFoundException{
        File arqdados = new File(nome);
        Scanner leitor = new Scanner(arqdados);

        int quantosAlunos = Integer.parseInt(leitor.nextLine());

        nomes = new String[quantosAlunos];
        matriculas = new int[quantosAlunos];
        notas = new double[quantosAlunos][quantasNotas];

        for(int i=0; i<quantosAlunos;i++){
            String linha = leitor.nextLine();
            String[] dadosAlunos = linha.split(";");
            nomes[i] = dadosAlunos[0];
            matriculas[i] = Integer.parseInt(dadosAlunos[1]);
         
            for(int j=0; j<quantasNotas; j++){
                notas[i][j] = Double.parseDouble(dadosAlunos[j+2]);
            }
        }
        leitor.close();
    }

    static double somarNotas(int posAluno){
        double aux=0d;
        for(int i=0;i<quantasNotas;i++)
            aux+= notas[posAluno][i];

        return aux;
    }

    static String alunoMaiorNota(){
        double maiorNota = -1d;
        double notaAtual;
        int posMelhorNota=-1;
        for(int i=0; i<nomes.length; i++){
            notaAtual = somarNotas(i);
            if(notaAtual >  maiorNota){
                maiorNota = notaAtual;
                posMelhorNota = i;
            }
        }
        return nomes[posMelhorNota] + " - "+somarNotas(posMelhorNota);

    }

    static double mediaDaTurma(){
        double somaTurma = 0d;
        for(int i=0; i<nomes.length; i++)
            somaTurma += somarNotas(i);

        return somaTurma/nomes.length;
    }

    static int quantosAcimaDaMediaDaTurma(){
        double media = mediaDaTurma();
        int cont=0;
        for(int i=0; i<nomes.length; i++){
            if(somarNotas(i) > mediaDaTurma() )
                cont++;
        }
        return cont;
    }
    
    static void testeSemClasse() throws Exception{
        lerDadosArquivo("dadosAlunos.txt");
        String melhorNota = alunoMaiorNota();
        double media = mediaDaTurma();
        int quantos = quantosAcimaDaMediaDaTurma();
        System.out.println("Melhor nota é de "+melhorNota);
        System.out.println(quantos+" alunos acima da média de "+media);
        System.out.println("FIM");
    }

    static Aluno[] lerDadosParaClasse(String nome) throws FileNotFoundException{
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

    static ListaEncadeada lerDadosParaLista(String nome) throws FileNotFoundException{
        File arqdados = new File(nome);
        Scanner leitor = new Scanner(arqdados);

        int quantosAlunos = Integer.parseInt(leitor.nextLine());
        ListaEncadeada turma = new ListaEncadeada();

        for(int i=0; i<quantosAlunos;i++){
            String linha = leitor.nextLine();
            Aluno quem = new Aluno(linha);
            turma.inserirPorUltimo(quem);    
        }
        leitor.close();
        return turma;
    }

    static FilaEstatica lerDadosParaFila(String nome) throws FileNotFoundException{
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
    
    static double mediaDaTurmaComClasse(Aluno[] turma){
        double somaTurma = 0d;
        for(int i=0; i<turma.length; i++)
            somaTurma += turma[i].notaFinal();

        return somaTurma/turma.length;
    }

    static void testeComClasse() throws FileNotFoundException{
        double notaMinima = 60.0;
        Aluno[] turma = lerDadosParaClasse("dadosAlunos.txt");

        Aluno alunoMaiorNota = alunoComMaiorNota(turma);
        System.out.print("Maior nota: ");
        System.out.print(alunoMaiorNota.nome + " com nota ");
        System.out.printf("%.2f \n", alunoMaiorNota.notaFinal());
        double media = mediaDaTurmaComClasse(turma);

        for(int i=0; i<turma.length; i++){
            boolean acima = turma[i].acimaDaMedia(media);
            boolean aprovado = turma[i].aprovado(notaMinima);
            System.out.print(turma[i].nome+", nota ");
            System.out.printf("%.2f",turma[i].notaFinal());
            if(aprovado)
                System.out.print(" (aprovado)");
            else
                System.out.print(" (reprovado)");

            if(acima)
                    System.out.println(" acima da média da turma de "+media);
            else
                    System.out.println(" abaixo da média da turma de "+media);
        }
        
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
    public static void main(String[] args) throws Exception {
        ListaEncadeada turma = lerDadosParaLista("dadosAlunos.txt");
        
              
        double notaMinima = 60.0;
        int quantasNotas = 4;
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        do{
            opcao = menu(teclado);
            switch(opcao){
                case 1: limparTela();
                        System.out.println("ACRESCENTAR ALUNO À TURMA");
                        String nome;
                        int matricula;
                        double nota;
                        int posicao;
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
                        System.out.print("Posição da inserção: ");
                        posicao = Integer.parseInt(teclado.nextLine());
                        Aluno novoAluno = new Aluno(linhaAluno);
                        turma.inserirNaPosicao(novoAluno, posicao);
                        pausa(teclado);
                    break;
                case 2: limparTela();
                        System.out.println("PESQUISAR ALUNA/O:");
                        String nomeBusca;
                        System.out.print("Digite um trecho do nome: ");
                        nomeBusca = teclado.nextLine();
                       // pesquisarAluno(turma, nomeBusca);
                      //  pesquisarAluno(novosAlunos, nomeBusca);
                        System.out.println("FIM DE PESQUISA");
                        pausa(teclado);
                    break;
                case 3: limparTela();
                        System.out.println("ALUNOS APROVADOS:"); 
                       // alunosAprovados(turma, notaMinima);             
                       // alunosAprovados(novosAlunos, notaMinima);
                        pausa(teclado);
                    break;
                case 5: limparTela();
                    System.out.println(turma.imprimir()); 
                   // alunosAprovados(turma, notaMinima);             
                   // alunosAprovados(novosAlunos, notaMinima);
                    pausa(teclado);
                break;
                case 6: limparTela();
                       // Aluno saiu = turma.desenfileirar();
                       // System.out.println("Saiu: "+saiu.matricula+": "+saiu.nome); 
                   // alunosAprovados(turma, notaMinima);             
                   // alunosAprovados(novosAlunos, notaMinima);
                    pausa(teclado);
                break;
            }
        }while(opcao!=0);

        // FileWriter arquivo = new FileWriter("dadosAlunos.txt", false);
        // int totalAlunos = turma.length+quantosNovosAlunos;
        // arquivo.write(totalAlunos+"\n");
        // salvarDados(turma, arquivo);
        // salvarDados(novosAlunos, arquivo);
        //arquivo.close();
        System.out.println("FIM DA EXECUÇÃO.");


    }
}
