import java.util.Scanner;

public class valutaklient {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Lager tre valutaer med hjelp av objektet Valuta
        Valuta dollar = new Valuta("USD", 10.58);
        Valuta euro = new Valuta("EURO", 11.77);
        Valuta zimbabwe_dollar = new Valuta("ZWD", 0.029);
         

        // Fancy menyskapning
        // Verdi for om programmet skal avsluttes eller ikke, false til man velger annet.
        boolean avslutt = false;

        while (!avslutt) {
            // boolean som tilbakestiller valg av konvertering før valg (om man skal konvertere flere ganger)
            boolean tilNOK = false;
            boolean fraNOK = false;
            
            System.out.println("------------------");
            System.out.println("Hei!");
            System.out.println("Vennligst velg en valuta:");
            System.out.println("1: Dollar/USD");
            System.out.println("2: Euro/EUR");
            System.out.println("3: Zimbabwean Dollar/ZWD");
            System.out.println("4: Avslutt programmet");
            System.out.println("------------------");

            int valg = scanner.nextInt();

            Valuta valgtValuta = null;

            // Switch tar inn verdier 1-4 (pga 4 cases i denne konteksten) og endrer variablene.
            switch (valg) {
                case 1 -> valgtValuta = dollar;
                case 2 -> valgtValuta = euro;
                case 3 -> valgtValuta = zimbabwe_dollar;
                case 4 -> {
                    avslutt = true;
                    continue;
                }
                default -> {
                    System.out.println("Ugyldig valg, prøv igjen.");
                    continue;
                }
            }
            if (valgtValuta != null) {
                System.out.println("------------------");
                System.out.println("Vil du konvertere til NOK eller fra NOK?");
                System.out.println("1: Til NOK fra " + valgtValuta.getNavn() + ".");
                System.out.println("2: Fra NOK til " + valgtValuta.getNavn() + ".");
                System.out.println("3: Avslutt programmet.");
                System.out.println("------------------");
            }

            int fra_til = scanner.nextInt();


            switch (fra_til) {
                case 1 -> tilNOK = true;
                case 2 -> fraNOK = true;
                case 3 -> {
                     avslutt = true;
                     continue;
                }
                default -> {
                    System.out.println("Ugyldig valg, prøv igjen.");
                    continue;
                }
            }
            
            if (tilNOK == true) {
                System.out.println("------------------");
                System.out.println("Skriv in ønsket mengde av " + valgtValuta.getNavn() + " du vil konvertere til NOK");
                double belop = scanner.nextDouble();
                double nokBelop = valgtValuta.tilNorskeKroner(belop);
                System.out.println(belop + " " + valgtValuta.getNavn() + " er " + nokBelop + " NOK");
                System.out.println("------------------");
            }

            if (fraNOK == true) {
                System.out.println("------------------");
                System.out.println("Skriv inn ønsket beløp NOK du vil konvertere til " + valgtValuta.getNavn());
                double belop = scanner.nextDouble();
                double nokBelop = valgtValuta.fraNorskeKroner(belop);
                System.out.println(belop + " NOK er " + nokBelop + " " + valgtValuta.getNavn());
                System.out.println("------------------");
            }
        
            System.out.println("Ønsker du å konvertere igjen?");
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