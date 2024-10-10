import java.util.Scanner;

public class leapyear {
   
    // metode for å sjekke skuddår
    public static void main(String[] args){
        
        int year;

        System.out.println("Skriv inn ønsket år:");

        // input int for ønsket år
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();

        // Om året har 0 i rest når det deles på 4 OG ikke har 0 i rest når det deles på 100 er det skuddår
        // OM de ikke er "true" samtidig, vil året sjekkes for å kunne deles på 400 som vil være skuddår
        // OM ingen av de er mulig, vil året ikke være et skuddår 
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            System.out.println("Året er et skuddår!");
        else 
            System.out.println("Året er ikke et skuddår");

        scanner.close();
    }
}