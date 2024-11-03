import java.util.Scanner;

public class primtall {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // String som blir brukt til å "fortsette" programmet.
        String fortsett;

        // do-while løkke for å gjøre at programmet kjører, men kan brukes på nytt om ønskelig
        // uten å restarte programmet.
        do {
            // Bruker skriver inn et tall for å sjekke om det er et primtall
            System.out.print("Skriv inn et tall for å sjekke om det er et primtall: ");
            int number = scanner.nextInt();

            // Bruker boolean til å lagre verdien true inntil det er motbevist.
            // Motbevisning/bevis kommer etter.
            boolean erPrimtall = true;

            // Om tallet/number er mindre eller lik 1 er det ikke et primtall
            if (number <= 1) {
                erPrimtall = false;
            } else {

                // Om tallet er større enn 1 settes i til 2.
                // Om tallet er større enn 2 vil i øke i størrelse til det er like stort.
                // Om det er like stort uten at det er rest er det et primtall og
                // verdien vil forbli true.
                for (int i = 2; i < number; i++) {
                    // Om tallet kan deles på i (som ikke er lik 1 eller tallet) og rest er det ikke et primtall.
                    // Det skal kun kunne deles på 1 som har blitt sjekket, 
                    // og om ingen tall gir rest er det et primtall.
                    if (number % i == 0) {
                    erPrimtall = false; 
                    break;
                    }
                }
            }
            
            // Om erPrimtall fortsatt er true vil programmet si det.
            // Om erPrimtall har blitt false vil programmet si det.
            if (erPrimtall) {
                System.out.println(number + " er et primtall.");
            } else {
                System.out.println(number + " er ikke et primtall.");
            }

            // Spør om personen vil kjøre programmet på nytt
            System.out.print("Vil sjekke et annet tall? skriv 'ja' eller 'nei': ");
            fortsett = scanner.next(); // går til nest scanner om neste del er true, som er første scanner i klassen

        }
        // equalsIgnoreCase sammenligner to strings og gir false og true.
        // løkken fortsetter altså om fortsett sin verdi = true, 
        // og stopper om fortsett sin verdi = false.
        while (fortsett.equalsIgnoreCase("ja")); 
        
        scanner.close();
    }
}