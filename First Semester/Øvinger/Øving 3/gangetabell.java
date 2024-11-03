import java.util.Scanner;

public class gangetabell {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Skriver først inn ønsket tall å begynne gangingen på, f.eks. 13
        System.out.print("Skriv inn ønsket tall å starte multiplisering med: ");
        int number = scanner.nextInt();

        // Skriver så inn sifferet man vil begynne å gange f.eks. 13 med, som f.eks. 3.
        // Bruker en do-while løkke for å hindre programmet å stoppe, men heller gi feilmelding om
        // tallet som blir skrevet inn er over 10 
        int first_multiple;
        do {
            System.out.print("Skriv inn ønsket siffer du vil begynne å gange " + number + " med: ");
            first_multiple = scanner.nextInt();
            //Om tallet er over 10 får de feilmelding
            if (first_multiple > 10) {
                System.out.println("Prøv igjen med et tall lik eller mindre enn 10");
            }
        } 
        // Feilmeldingen fortsetter fram til et tall lik eller mindre enn 10 skrives inn
        while (first_multiple > 10);

        // Tredje verdi er antall linjer man ønsker å ha utskrevet, f.eks. 23.
        System.out.print("Skriv inn antall linjer av gangetabellen du vil ha utskrevet: ");
        int wanted_calculations = scanner.nextInt();

        // Lager en variabel som holder styr på antall "multipliseringer". 
        int count = 0;

        // While løkke som vil stoppe programmet når wanted_calculations er mindre enn count.
        while (count < wanted_calculations) {

            // Løkkesteg 1: Printer først fra ønsket tall opp til ti
            // Når programmet har gjort sin første multiplisering, vil i 
            // (first_multiple er i sin første verdi) øke med 1 og det vil også count
            // slik at programmet etterhvert vil stoppe etter wanted_calculations antall linjer
            for (int i = first_multiple; i <= 10 && count < wanted_calculations; i++) {
                System.out.println(number + " * " + i + " = " + (number*i));
                count++;
            }

            // Steg 2: Setter verdien av first_multiple til 1
            // slik at programmet igjen begynner på 1 etter 10.
            first_multiple = 1;

            // Steg 3: Adderer 1 på number slik at neste gjennomgang av
            // løkken vil gå til neste tallet på gangetabellen
            number++;
        }

        //Asvlutter programmet etter alle linjer er skrevet
        scanner.close();

    }
}