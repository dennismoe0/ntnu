public class meatprice {
    
    public static void main(String[] args) {

        // Oppgave: Kjøttdeig av merke A
        // koster kr 35,90 for 450 gram, mens kjøttdeig av merke B koster kr 39,50 for 500 gram.
        // Hvilket merke er billigst?

        double meat_price_1 = 35.90; //kjøttdeig 1, 450g
        double meat_price_2 = 39.50; //kjøttdeig 2, 500g
        int meat_weight_1 = 450;     //kjøttdeig 1
        int meat_weight_2 = 500;     //kjøttdeig 2

        double grampris1 = meat_price_1 / meat_weight_1; //=0.079778kr pr gram
        double grampris2 = meat_price_2 / meat_weight_2; //=0.079kr pr gram


        //operasjon som sjekker hvilken grampris som er høyest, og outputter den andre om det er sant
        if (grampris1 > grampris2)
            System.out.print("Kjøttdeigen som koster 39.50kr for 500g er billigst");
        else
            System.out.print("Kjøttdeigen 35.90kr for 450g er billgist");

    }

}
