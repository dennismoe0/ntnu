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

    public void kastTerningen(){
        int terningkast = terning.nextInt(5) + 1; // Random tall mellom 1-6, 0 - 5 + 1 = 1 - 6
    }


}