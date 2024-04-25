package app;

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
  * Classe para uma pilha de cartas de baralho (sem POO)
  */
class Pilha{
    //elementos de controle
    public Elemento topo;
    public Elemento fundo;  

    
    /** 
     * Construtor. Cria uma pilha com elemento topo sentinela.
     */
    public Pilha(){
        this.topo = new Elemento(null);
        fundo = topo;
    }

    /**
     * Empilha uma carta recebida por parâmetro
     * @param qual A carta a ser empilhada.
     */
    public void empilhar(Carta qual){
        Elemento novo = new Elemento(qual);
        novo.proximo = topo.proximo;        // a nova carta entra "por cima" da atual (que fica após o topo sentinela)
        topo.proximo = novo;
        if (topo == fundo)                  //"empurramos" o fundo, se for a primeira carta
            fundo = novo;
    }
    
    /**
     * Retorna se a pilha está vazia
     * @return True/false para pilha vazia ou não
     */
    public boolean vazia(){
         return (topo == fundo);
    }

    /// <summary>
    /// 
    /// </summary>
    /// <returns></returns>
    
    /**
     * Desempilha e retorna uma carta (ou nulo)
     * @return A carta que estava em cima da pilha; nulo em caso de pilha vazia
     */
    public Carta desempilhar(){
        if (vazia()) return null;   //se não houver carta na pilha, nulo
        else
        {
            Elemento aux = topo.proximo;    //sempre quem sai é o seguinte ao topo sentinela
            topo.proximo = aux.proximo;
            if (aux == fundo)               //caso seja a última carta, 'voltar' o fundo
                fundo = topo;
            else
                aux.proximo = null;         //se não for a última, zerar o ponteiro por segurança

            return aux.meuDado;             //retornamos o dado (carta)
        }
    }

    
    /**
     * Verifica e retorna o topo da pilha, sem retirar
     * @return A carta no topo da pilha, ou nulo
     */ 
    public Carta verificarTopo(){
        if (vazia()) return null;   //vazio: retorna nulo
        else return topo.proximo.meuDado;   //a carta do topo, sem retirar
    }

    

    /**
     * Retorna uma string representando a pilha, do topo ao fundo
     */
    @Override
     public String toString(){
        //obs: pode ser feito de maneira mais eficiente utilizando-se StringBuilder
        
        Elemento aux = topo.proximo;    //o primeiro "de verdade" (depois do sentinela)
        String resposta = "";
        while (aux != null) //enquanto tiver carta...
        {
            resposta += aux.meuDado.toString(); //pegamos os dados da carta e acumulamos na variável
            resposta += "\n";                   // \n para pular linha (imprimir um pouco mais organizado)
            aux = aux.proximo;                  // vai para o próximo da pilha. 
        }
        return resposta;
    }

}