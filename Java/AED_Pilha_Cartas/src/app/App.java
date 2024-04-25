package app;

import java.util.Random;
import java.util.Scanner;

/**
 * MIT License
 *
 * Copyright(c) 2020 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

 
public class App {
    
        /**
         * Cria um baralho tradicional completo. (vetor: tamanho já conhecido)
         * @return Vetor com 52 cartas (baralho tradicional ordenado)
         */
        public static Carta[] criarBaralho(){
            int naipes = 4; //naipes de 1 a 4 (ver definição da carta)
            int cartas = 13; //posições de 1 a 13 (A até K, na ordem)
            int posicao = 0;    //posição geral do baralho

            Carta[] aux = new Carta[naipes * cartas];
            
            for(int i=1; i<=naipes; i++){
                for (int j = 1; j <= cartas; j++) { 
                    aux[posicao]= new Carta(i, j);      //chama o construtor para cada carta de cada naipe.
                    posicao++;                          //passa para a próxima posição do vetor. 
               }
            }
            return aux;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="baralho"></param>
       
       /**
        * Embaralha um baralho recebido por parâmetro
        * @param baralho O baralho (tradicional) para ser embaralhado.
        */
        static void embaralhar(Carta[] baralho){

            //embaralharemos pegando cada posição do baralho original e trocando com outra sorteada

            Random sorteio = new Random(System.currentTimeMillis());  //para sortear as posições

            for(int i=0; i<baralho.length; i++){        // para cada posição do vetor/baralho...
                int posicao = sorteio.nextInt(baralho.length);  //sorteia-se outra posição
                Carta aux = baralho[i];                 //trocamos a posição atual com a sorteada. 
                baralho[i] = baralho[posicao];
                baralho[posicao] = aux;
            }
        }
        
        /// <summary>
        ///
        ///
        /// </summary>
        /// <param name="args"></param>

        /**
         *  Programa para testar a pilha. Pega a primeira carta, coloca na mesa e, em seguida tenta completar a sequência
         *  com a regra da paciência até encontrar um ás.
         * @param args
         */
        public static void main(String[] args){
            Scanner leitor = new Scanner(System.in);

            Pilha mesa = new Pilha();           //a mesa, representada por uma pilha: sempre uma carta entrará "por cima"
            Carta[] baralho = criarBaralho();   //criamos um baralho
            int posicaoAtual = 1;               //posição a realizar o teste de carta (regra da paciência)
            embaralhar(baralho);    
            
            mesa.empilhar(baralho[0]);  //jogamos/empilhamos a primeira carta do baralho na mesa 
            baralho[0] = null;          //retiramos a carta do baralho

            System.out.println("Início da mesa:" + mesa.verificarTopo());

            while (mesa.verificarTopo().face!="A") {   // até conseguir chegar ao ás

                if (baralho[posicaoAtual] != null) {    //se existe carta na posição atual
                    if ((baralho[posicaoAtual].valor == mesa.verificarTopo().valor - 1) &&      //regra da paciência: valor 1 unidade menor e...
                         (baralho[posicaoAtual].cor() != mesa.verificarTopo().cor()))           //cores opostas das cartas
                    {
                        mesa.empilhar(baralho[posicaoAtual]);           //jogamos/empilhamos na mesa
                        System.out.println("Joguei: " + baralho[posicaoAtual]);   //avisando da jogada
                        baralho[posicaoAtual] = null;                   //retiramos do baralho

                    }
                    else
                        System.out.println("Não joguei: " + baralho[posicaoAtual]);       //apenas avisando que a carta não serve
                }
                leitor.nextLine(); //apenas para esperar o usuário
                posicaoAtual++;         //para testar a próxima posição
                posicaoAtual = posicaoAtual % baralho.length;   //"dá a volta" para o início do baralho, se este terminar. 
            }
            System.out.println("Enter para ver a mesa completa");
            leitor.nextLine(); //apenas para esperar o usuário
            System.out.println("----------");
            System.out.println("FINAL: ");
            System.out.println(mesa);
            leitor.close();
        }

}