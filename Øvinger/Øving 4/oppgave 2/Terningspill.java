public class Terningspill {
    public static void main(String[] args) {
        Spiller spillerA = new Spiller();
        Spiller spillerB = new Spiller();
        int runde = 1;

        while (true) {
            System.out.println("Runde " + runde);
            System.out.println("Spiller A kaster terningen:");
            spillerA.kastTerningen();
            System.out.println("Spiller A poengsum: " + spillerA.getSumPoeng());

            if (spillerA.erFerdig()) {
                System.out.println("Spiller A har vunnet!");
                break;
            }

            System.out.println("Spiller B kaster terningen:");
            spillerB.kastTerningen();
            System.out.println("Spiller B poengsum: " + spillerB.getSumPoeng());

            if (spillerB.erFerdig()) {
                System.out.println("Spiller B har vunnet!");
                break;
            }

            runde++;
            System.out.println("-----------------------------");
        }
    }
}
