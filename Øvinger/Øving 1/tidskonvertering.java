import java.util.Scanner;

public class tidskonvertering {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double timer;
    double minutter;
    double sekunder;
    double timer_til_sekunder;
    double minutter_til_sekunder;
    double sekunder_til_sekunder;
    double totalesekunder;


    System.out.print("Skriv antall timer først, så minutter og så sekunder du vil konvertere til sekunder: ");

    timer = scanner.nextDouble();
    timer_til_sekunder = timer*3600;

    minutter = scanner.nextDouble();
    minutter_til_sekunder = minutter*60;

    sekunder = scanner.nextDouble();
    sekunder_til_sekunder = sekunder;

    totalesekunder = timer_til_sekunder+minutter_til_sekunder+sekunder_til_sekunder;

    System.out.printf("%.1f time/timer, %.1f minutt/minutter og %.1f sekund/sekunder er det samme som %.1f sekunder.", timer, minutter, sekunder, totalesekunder);
        
    }
}    