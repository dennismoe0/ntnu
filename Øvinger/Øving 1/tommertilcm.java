import java.util.Scanner;

public class tommertilcm {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double tommer;
    double cm;
    double meter;

    System.out.print("Skriv antall tommer du vil konvertere til centimeter: ");

    tommer = scanner.nextDouble();
    cm = tommer*2.54;
    meter = cm/100;

    System.out.printf("%.1f tommer er det samme som %.1f centimeter, eller %.1f meter.", tommer, cm, meter);

    }
}    