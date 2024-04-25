package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    static void carregarDados(String nomeArq, Fila fila) throws FileNotFoundException{
        File arq = new File(nomeArq);
        Scanner leitor = new Scanner(arq);

        
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            String nome = detalhes[0];
            int matric = Integer.parseInt(detalhes[1]);
            float nota = Float.parseFloat(detalhes[2]);
            Estudante novo = new Estudante(nome, matric);
            novo.setNota(nota);
            fila.adicionar(novo);
            
        }
        leitor.close();
    }
    public static void main(String[] args) throws Exception {
        Fila filaAlunos = new Fila();
        final String nomeArq = "dadosAlunos.txt";

        carregarDados(nomeArq, filaAlunos);
        System.out.println(filaAlunos);
        System.out.println("\n");
        Estudante primeiro = (Estudante)filaAlunos.retirar();

        System.out.println(filaAlunos);

    }
}