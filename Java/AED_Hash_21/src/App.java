import java.util.Random;

public class App {
    
    static String[] nomes = { "Joao ", "Ana ", "Jose ", "Catia ", "Pedro ", "Fabiana " };
    static String[] sobrenomes = { "Silva", "Souza", "Oliveira", "Santos", "Alves", "Pereira" };
    static Random rand = new Random(42);

    public static void gerarPessoas(TabHash tab){
              
        for(int i=0 ; i<nomes.length; i++){
            for(int j=0 ; j<sobrenomes.length; j++){
                String nome = nomes[i] + sobrenomes[j];
                int matric = 100_000+rand.nextInt(800_000);
                Aluno nova = new Aluno(nome);
                nova.mat = matric;
                tab.inserir(nova);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        TabHash tabela = new TabHash(29);

        gerarPessoas(tabela);

        tabela.imprimirTudo();
    }
}


/**
 *  TABELA HASH: ARMAZENA O DADO CALCULANDO SUA POSIÇÃO
 *  -- CADA POSIÇÃO DA TABELA ARMAZENA UMA LISTA
 * 
 *  COMO CALCULAR A POSIÇÃO? (FUNÇÃO HASH)
 * 
 * 
 * 
 * 
 * 
 */