import java.util.Scanner;

public class App {

    // #region utilidades
    static void pausa(Scanner teclado) {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // #endregion

    // #region regras do jogo

    /**
     * Verifica se uma carta serviu de acordo com a regra da paciência
     * 
     * @param c    A carta a ser verificada
     * @param mesa A pilha da mesa atual
     * @return TRUE se a carta pode ser jogada na mesa, FALSE se não pode
     */
    public static boolean cartaServiu(Carta c, PilhaCartas mesa) {

        boolean resposta = true;

        if (c.corNaipe() == mesa.peek().corNaipe())
            resposta = false;
        else if (c.valor() != mesa.peek().valor() - 1)
            resposta = false;

        return resposta;
    }

    /**
     * Desempilha de uma pilha e joga em outra. Usada para retornar do morto para o
     * monte.
     * 
     * @param origem  A pilha para desempilhar
     * @param destino A pilha para empilhar
     */
    public static void virarBaralho(PilhaCartas origem, PilhaCartas destino) {
        while (!origem.pilhaVazia()) {
            destino.push(origem.pop());
        }
    }

    /**
     * Verifica se o "jogo" acabou (encontrou um ás)
     * 
     * @param mesa Pilha da mesa
     * @return TRUE se achou um ás no topo da mesa, FALSE caso contrário
     */
    public static boolean acabou(PilhaCartas mesa) {
        return (mesa.peek().face.equals("A"));
    }
    // #endregion

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        Baralho baralho = new Baralho(); // baralho com 52 cartas. vetor de cartas.

        PilhaCartas monte = new PilhaCartas(); // de onde eu vou tirar as cartas
        PilhaCartas mesa = new PilhaCartas(); // sequencia de cartas
        PilhaCartas morto = new PilhaCartas(); // cartas descartadas.

        Carta cartaMesa;
        Carta cartaMao;

        baralho.embaralhar();

        // criar o monte de cartas. copio do baralho e empilho no monte.
        for (int i = 0; i < baralho.tamanho; i++) {
            monte.push(baralho.cartas[i]);
        }

        // pegando a carta de cima do monte para virar na mesa
        mesa.push(monte.pop());

        cartaMesa = mesa.peek(); // observar a mesa, sem desempilhar

        System.out.println("Carta na mesa: " + cartaMesa.toString());

        do {
            System.out.println("Virando morto para o monte...");
            virarBaralho(morto, monte);

            while (!acabou(mesa) && !monte.pilhaVazia()) {

                cartaMao = monte.pop(); // tirando uma carta do monte

                if (!cartaServiu(cartaMao, mesa)) {
                    System.out.println("Não serviu: " + cartaMao.toString());
                    morto.push(cartaMao);
                } else {
                    System.out.println("Serviu e foi para a mesa: " + cartaMao.toString());
                    mesa.push(cartaMao);
                    pausa(teclado);
                    limparTela();
                    System.out.println("Carta na mesa: " + mesa.peek().toString());
                }
            }
        } while (!acabou(mesa));

        System.out.println("Fim de jogo");

    }

}
