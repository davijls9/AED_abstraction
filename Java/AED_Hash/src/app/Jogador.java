package app;

import java.util.Random;

/** Classe Jogador para exemplo de tabela hash */
public class Jogador {
    static Random sorteio = new Random(System.nanoTime());
    public String nome;
    public int id;      //id deve ser um número de pelo menos seis dígitos
    public int nivel;


    public Jogador(String n, int id){
        this.nome = n;
        if (id >= 100000)
            this.id = id;
        else
            this.id = 100001;

        this.nivel = 1 + sorteio.nextInt(10);
    }

    /**
     * Em Java, toda classe gera seu próprio hashCode: facilita o reaproveitamento de estruturas
     */
    @Override
    public int hashCode(){
        int aux = id;

        aux = aux % 100_000;        //ignorar o primeiro dígito (é 6 para todo mundo)
        aux = aux * aux;            //elevar ao quadrado (aumento da dispersão)
        aux = Math.abs(aux);        //valor absoluto (sem sinal)

        int d1 = aux / 100_000_000;   //operação matemática para extrair um dígito (exemplo abaixo)
        d1 = d1 % 10;

        int d2 = aux / 100_000;       //operação matemática para extrair outro dígito (exemplo abaixo)  
        d2 = d2 % 10;

        int resp = d1 * 10 + d2;       //valor final do hash (primeiro dígito é a dezena)

        return resp;

        ////////////
        //  Ex. extração de dígitos. 
        //  Extrair o segundo dígito de 3.237.496.201
        //  3.237.496.201 / 100.000.000 = 32
        //  32 % 10 = 2 
        //
        //  Extrair o quinto dígito de 3.237.496.201
        //  3.237.496.201 / 100.000 = 32.374
        //  32.274 % 10 = 4 
        ////////////

    }

    @Override
    public String toString()
    {
        return id + " - " + nome;
    }
}