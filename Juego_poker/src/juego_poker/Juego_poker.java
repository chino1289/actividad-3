package juego_poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jccr
 */
public class Juego_poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }

}

class Card {

    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

class Deck {

    private List<Card> cartas;

    private static final String[] PALOS = {"Tréboles", "Corazones", "Picas", "Diamantes"};
    private static final String[] COLORES = {"Negro", "Rojo"};
    private static final String[] VALORES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

    public Deck() {
        cartas = new ArrayList<>();
        for (String palo : PALOS) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
            for (String valor : VALORES) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cartas.isEmpty()) {
            Card primeraCarta = cartas.remove(0);
            System.out.println(primeraCarta);
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void pick() {
        if (!cartas.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(cartas.size());
            Card cartaAleatoria = cartas.remove(index);
            System.out.println(cartaAleatoria);
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck para repartir una mano.");
        }
    }
}

