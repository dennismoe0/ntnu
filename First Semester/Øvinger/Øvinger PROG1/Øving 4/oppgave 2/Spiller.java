import java.util.Random;

class Spiller {
    private int sumPoeng;
    private Random terning;

    public Spiller() {
        this.sumPoeng = 0;
        this.terning = new Random();
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public void kastTerningen() {
        int terningkast = terning.nextInt(6) + 1; // Tilfeldig tall mellom 1 og 6
        System.out.println("Terningkast: " + terningkast);

        if (terningkast == 1) {
            sumPoeng = 0; // Nullstill poeng hvis terningkast er 1
        } else {
            sumPoeng += terningkast;
        }
    }

    public boolean erFerdig() {
        return sumPoeng >= 100;
    }

    public void justerPoeng(int trekk) {
        sumPoeng -= trekk;
        if (sumPoeng < 0) {
            sumPoeng = 0;
        }
    }
}
