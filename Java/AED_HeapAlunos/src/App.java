import java.util.Random;
import java.util.Scanner;

public class App {
    
    static String[] nomes = {"Renato", "Geovanna", "Gustavo", "Arthur", "João",
                             "Hugo", "Stephany", "Carlos", "Maria Luiza", "Eric"};
    static Random sorteio = new Random(System.currentTimeMillis());
    
    static void testeAluno(){
        HeapArray filaPrioAlunos = new HeapArray(10);
        int quantAlunos = nomes.length;
        
        for(int i=0; i<quantAlunos; i++){
            Aluno novo = new Aluno(nomes[i]);
            novo.lancarNota(10+ sorteio.nextInt(15));
            novo.lancarNota(10+ sorteio.nextInt(15));
            novo.lancarNota(10+ sorteio.nextInt(15));
            novo.lancarNota(10+ sorteio.nextInt(15));
            System.out.println(novo.nome + " - nota "+novo.notaFinal());
            filaPrioAlunos.inserir(novo);
        }
      
        System.out.println("-----------------------");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        Aluno maiorNota = (Aluno)filaPrioAlunos.retirar();
        Aluno viceNota = (Aluno)filaPrioAlunos.retirar();
        System.out.println("Maior nota: "+maiorNota.nome+" com "+maiorNota.notaFinal());
        System.out.println("Segunda nota: "+viceNota.nome+" com "+viceNota.notaFinal());
        
        System.out.println("FIM");
        teclado.close();
    }

    static void testeProdutos(){
        HeapArray filaPrioProd = new HeapArray(10);
        int quantAlunos = nomes.length;
        
        for(int i=0; i<quantAlunos; i++){
            Produto novo = new Produto(nomes[i]);
            System.out.println(novo.descricao+ " - R$ "+novo.preco);
            filaPrioProd.inserir(novo);
        }
      
        System.out.println("-----------------------");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        Produto maisCaro = (Produto)filaPrioProd.retirar();
        Produto vicePreco = (Produto)filaPrioProd.retirar();
        System.out.println("Mais caro: "+maisCaro.descricao+" - R$ "+maisCaro.preco);

        System.out.println("Segundo: "+vicePreco.descricao+" - R$ "+vicePreco.preco);
        
        System.out.println("FIM");
        teclado.close();
    }
    public static void main(String[] args) throws Exception {
        testeProdutos(); 
       
    }
}
