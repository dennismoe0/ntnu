import java.util.Scanner;

public class tidskonvertering2 {
    public static void main(String[] args) {

        int totale_sekunder;
        int timer;
        int gjenværende_sekunder;
        int minutter;
        int sekunder;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv antall sekunder du vil konvertere til timer, minutter og sekunder");

        totale_sekunder = scanner.nextInt(); //input for sekunder ønsket å konvertere
       
        timer = totale_sekunder / 3600; //kalkulerer antall sekunder, uten rest. 3600 sekunder blir 1 time.
        gjenværende_sekunder = totale_sekunder % 3600; //restsekunder, % er rest etter divisjon

        minutter = gjenværende_sekunder / 60; //gjenværende sekunder er rest av timeskalkulasjonen, som betyr det er under 60 minutter med sekunder, disse deles på 60 for å få antall minutter som var i rest.
        sekunder = gjenværende_sekunder % 60; //ettersom int deles i hele tall, er resten etter minuttkalkulasjon de resterende sekundene som alltid vil være under 60


        System.out.println("Timer: " + timer + ", minutter: " + minutter + " og sekunder: " + sekunder ++);


        scanner.close();
    }
}    