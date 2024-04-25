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

/**
 * Versão sem uso de classe: 3 vetores separados com os dados
 */
public class AppSimples {
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
            if(somarNotas(i) > media )
                cont++;
        }
        return cont;
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
        lerDadosArquivo("dadosAlunos.txt");
        String melhorNota = alunoMaiorNota();
        double media = mediaDaTurma();
        int quantos = quantosAcimaDaMediaDaTurma();
        System.out.println("Melhor nota é de "+melhorNota);
        System.out.println(quantos+" alunos acima da média de "+media);
        System.out.println("FIM");

        System.out.println("FIM DA EXECUÇÃO.");


    }
}
