public class Valuta {
    private String navn;
    private double kurs;

    // Konstruktør
    public Valuta(String navn, double kurs) {
        this.navn = navn; // Initialiserer 'navn'
        this.kurs = kurs; // Initialiserer 'kurs'
    }

    // Metode for å konverte fra andre valutaer til norske kroner
    // belop = beløp, altså antall av valutaen til norske kroner
    public double tilNorskeKroner(double belop) {
        return belop * kurs;
    }

    // Metode for å konverte fra norske kroner til andre valutaer
    // belop = antall kroner
    public double fraNorskeKroner(double belop) {
        return belop / kurs;
    }

    // Getter som gjør navn tilgjengelig for valutaklient.java, f.eks. "Dollar"/"Euro"
    public String getNavn() {
        return navn;
    }

}