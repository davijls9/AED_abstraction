/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe Fila de Prioridades com array/vetor
 */
public class HeapArray {
    
    int tamanhoMaximo;
    int tamanhoAtual;
    DadoGenerico[] dados;

    /**
     * Construtor para heap de tamanho pré-definido
     * @param maximo O tamanho máximo da heap
     */
    public HeapArray(int maximo){
        tamanhoMaximo = maximo;
        tamanhoAtual = 0;
        dados = new DadoGenerico[tamanhoMaximo];
    }

    /**
     * Procedimento auxiliar para verificar a subida de elementos prioritários.
     * @param posicao Posição a ser verificada
     */
    public void upheap(int posicao){

        if(posicao==0)  // base da recursividade: raiz(pos 0) não tem pai
            return;
        else{
            int pai = (posicao-1)/2;

            if(dados[posicao].prioritario(dados[pai])){
                DadoGenerico aux = dados[posicao];
                dados[posicao] = dados[pai];
                dados[pai] = aux;

                upheap(pai);    //só precisa verificar o pai se houve troca.
            }
        }
    }

    public boolean inserir(DadoGenerico novo){
        if(tamanhoAtual < tamanhoMaximo){
            dados[tamanhoAtual] = novo;
            upheap(tamanhoAtual);
            tamanhoAtual++;
            return true;
        }
        else
            return false;
    }

    public int verificarFilhos(int posicao){
        int primeiroFilho = 2*posicao+1;
        int segundoFilho = 2*posicao+2;

        if(dados[segundoFilho] == null)
            return primeiroFilho;
        else{
            if(dados[primeiroFilho].prioritario(dados[segundoFilho]))
                return primeiroFilho;
            else
                return segundoFilho;  
        }

    }

    public void downheap(int posicao){
        int primeiroFilho = 2*posicao+1;

        if(primeiroFilho <= tamanhoAtual){
            int maisImportante = verificarFilhos(posicao);

            if(!dados[posicao].prioritario(dados[maisImportante])){
                    DadoGenerico aux = dados[posicao];
                    dados[posicao] = dados[maisImportante];
                    dados[maisImportante] = aux;
                    downheap(maisImportante);
            }
        }
        else
            return;


    }

    public DadoGenerico retirar(){
        if(tamanhoAtual > 0){
            DadoGenerico retirada = dados[0];
            tamanhoAtual--;
            dados[0] = dados[tamanhoAtual];
            dados[tamanhoAtual] = null;
            downheap(0);
            return retirada;
        }
        else
            return null;
    }  
    
    // public String imprimirFila(){
    //     StringBuilder aux = new StringBuilder("Fila: \n");
    //     for(int i=0; i<tamanhoAtual; i++)
    //         aux.append(dados[i].nome + " -> ");

    //     aux.append("null\n");
    //     return aux.toString();
    // }
}
