import java.util.Random;

public class Tilfeldig {

    private final Random random;

    public Tilfeldig() {
        this.random = new Random();
    }

    // Genererer et tilfeldig heltall mellom mellom grensen.
    public int nesteHeltall(int nedre, int ovre) {
        return nedre + random.nextInt(ovre - nedre);
    }

    // Genererer et tilfeldig desimaltall mellom grensen.
    public double nesteDesimaltall(double nedre, double ovre) {
        return nedre + (ovre - nedre) * random.nextDouble();
    }

    public static void main(String[] args) {
        // Opprett et objekt av Tilfeldig
        Tilfeldig tilfeldig = new Tilfeldig();

        int tilfeldigHeltall = tilfeldig.nesteHeltall(1, 10);
        double tilfeldigDesimaltall = tilfeldig.nesteDesimaltall(0.0, 1.0);

        // Print resultatet
        System.out.println("Tilfeldig desimaltall: " + tilfeldigDesimaltall);
        System.out.println("Tilfeldig heltall: " + tilfeldigHeltall);
    }
}
