import java.util.Random;

public class Baralho {
    public Carta[] cartas;
    public int tamanho;

    public Baralho() {
        this.cartas = new Carta[52];
        this.tamanho = 52;
        int pos = 0;
        for (Carta.naipes naipe : Carta.naipes.values()) {
            for (int j = 1; j < Carta.faces.length; j++) {
                cartas[pos] = new Carta(j, naipe);
                pos++;
            }
        }
    }

    public void embaralhar() {
        Random num = new Random();

        for (int i = 0; i < 200; i++) {

            int pos = num.nextInt(cartas.length);
            int pos2 = num.nextInt(cartas.length);

            Carta aux = cartas[pos];
            cartas[pos] = cartas[pos2];
            cartas[pos2] = aux;
        }
    }
}
