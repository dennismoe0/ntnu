import java.util.Scanner;

public class brokregning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        brok brok1 = null;
        brok brok2 = null;

        boolean avslutt = false;

        while (!avslutt) {

            System.out.println("-------------------");
            System.out.println("Velg et alternativ:");
            System.out.println("1: Teller og nevner.");
            System.out.println("2: Kun teller, nevner = 1.");
            System.out.println("3: Operasjon på to brøker");
            System.out.println("4: Avslutt programmet");
            System.out.println("-------------------");

            int valg = scanner.nextInt();

            switch (valg) {
                // Teller og nevner
                case 1 -> {
                    System.out.println("Skriv inn teller: ");
                    int teller1 = scanner.nextInt();
                    System.out.println("Skriv inn nevner: ");
                    int nevner1 = scanner.nextInt();
                    System.out.println("-------------------");
                    try {
                        brok1 = new brok(teller1, nevner1);
                        System.out.println("Brøken din er: " + brok1.getTeller() + "/" + brok1.getNevner());
                        System.out.println("-------------------");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Feil: " + e.getMessage());
                        System.out.println("-------------------");
                    }
                }

                // Teller
                case 2 -> {
                    System.out.println("Skriv inn teller: ");
                    System.out.println("-------------------");
                    int teller1 = scanner.nextInt();
                    brok1 = new brok(teller1);
                    System.out.println("Brøken din er: " + brok1.getTeller() + "/1");
                }

                // Teller og nevner på to brøker, operasjon
                case 3 -> {
                    
                    // Brøk 1 teller og nevner
                    System.out.println("For brøk 1: ");
                    System.out.println("Skriv inn teller: ");
                    int teller1 = scanner.nextInt();
                    System.out.println("Skriv inn nevner: ");
                    int nevner1 = scanner.nextInt();
                    System.out.println("-------------------");

                    try {
                        brok1 = new brok(teller1, nevner1);
                        System.out.println("Den første brøken din er: " + brok1.getTeller() + "/" + brok1.getNevner());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Feil: " + e.getMessage());
                        continue;
                    }

                    // Brøk 2 teller og nevner
                    System.out.println("For brøk 2:");
                    System.out.println("Skriv inn teller: ");
                    int teller2 = scanner.nextInt();
                    System.out.println("Skriv inn nevner: ");
                    int nevner2 = scanner.nextInt();
                    System.out.println("-------------------");

                    try {
                        brok2 = new brok(teller2, nevner2);
                        System.out.println("Den andre brøken din er: " + brok2.getTeller() + "/" + brok2.getNevner());

                        // Valg av matteoperasjon
                        System.out.println("Velg operasjon: ");
                        System.out.println("1: Summer brøkene.");
                        System.out.println("2: Subtraher brøk 1 med brøk 2");
                        System.out.println("3: Multipliser brøkene.");
                        System.out.println("4. Divider brøkene.");
                        System.out.println("5. Gå tilbake til hovedmeny.");

                        int operasjon = scanner.nextInt();

                        switch (operasjon) {
                            case 1 -> brok1.addere(brok2);
                            case 2 -> brok1.subtrahere(brok2);
                            case 3 -> brok1.multiplisere(brok2);
                            case 4 -> brok1.dividere(brok2);
                            default -> System.out.println("Ugyldig operasjon.");
                        }

                        System.out.println("Svaret er: " + brok1.getTeller() + "/" + brok1.getNevner() + ".");

                    } catch (IllegalArgumentException e) {
                        System.out.println("!!-------------------!!");
                        System.out.println("!!-------------------!!");
                        System.out.println("Feil: " + e.getMessage());
                        System.out.println("!!-------------------!!");
                        System.out.println("!!-------------------!!");
                    }
                }

                // går tilbaker.
                case 4 -> avslutt = true;

                // Default print om ugyldig verdier velges.
                default -> System.out.println("Ugyldig valg, prøv igjen.");
            }

            System.out.println("Ønsker du å utføre en ny operasjon?");
            System.out.println("1: Ja.");
            System.out.println("2: Nei, avslutt programmet.");
            System.out.println("------------------");
            int siste_meny = scanner.nextInt();

            switch (siste_meny) {
                case 1 -> avslutt = false;
                case 2 -> {
                    avslutt = true;
                    continue;
                }
                default -> {
                    System.out.println("Ugyldig valg, prøv igjen.");
                    continue;
                }
            }
        }

        scanner.close();
    }
}
