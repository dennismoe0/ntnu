class TellerOgNevner {
   private int nevner; // int for nevner
   private int teller; // int for teller

    // Konstruktør for teller og nevner

   public TellerOgNevner(int teller, int nevner) {

    // If for å sjekke om nevner == 0
    if (nevner == 0) {
        throw new IllegalArgumentException("Nevner kan ikke være lik 0");
    }

    this.teller = teller;
    this.nevner = nevner;
    forenkle();

   }

   // Kun teller, setter nevner til 1
   public TellerOgNevner(int teller) {
    this.teller = teller;
    this.nevner = 1;
    forenkle();

   }

    // GCD = greatest common denominator, altså fellesnevner for de to brøkene
    // /= deler brok1 på brok2 og setter resultatverdien som verdien til brok1 videre, forenklet forkaring
   private void forenkle() {
    int gcd = finnGCD(teller, nevner);
    this.teller /= gcd;
    this.nevner /= gcd;
   }

   private int finnGCD(int a, int b) { //"Eucleadian algorithm"
    if (b == 0) {
        return Math.abs(a);
    }
    return finnGCD(b, a % b); // b = teller, resten av a % b er nevner, forenklet brøk
    }

   // Get metoder, gjør det mulig for klientprogrammet å få tak i teller og nevner
   public int getTeller() {
    return teller;
   }

   public int getNevner() {
    return nevner;
   }


   /*
    *  Addere er å addere
    */
    public void addere(TellerOgNevner brok) { // (a/b) + (c/d) = (a*d + b*c) / (b*d)
        this.teller = this.teller * brok.getNevner() + this.nevner * brok.getTeller();
        this.nevner = this.nevner * brok.getNevner();
        forenkle();
    }
    public void subtrahere(TellerOgNevner brok) {
        this.teller = this.teller * brok.getNevner() - brok.getTeller() * this.nevner;
        this.nevner = this.nevner * brok.getNevner();
        forenkle();
    }
    public void multiplisere(TellerOgNevner brok) {
        this.teller = this.teller * brok.getTeller();
        this.nevner = this.nevner * brok.getNevner();
        forenkle();
    }

    public void dividere(TellerOgNevner brok) {
        if (brok.getTeller() == 0) {
            throw new IllegalArgumentException("Kan ikke dele med 0.");
        }
        this.teller = this.teller * brok.getNevner();
        this.nevner = this.nevner * brok.getTeller();
        forenkle(); 
    }
}

/*  
Klassen skal ha to konstruktører:
• Den ene konstruktøren tar teller og nevner som argument. Hvis nevneren er 0, skal et
unntaksobjekt av typen IllegalArgumentException kastes.
*/