import java.util.Scanner;

/**
 * A client program to interact with Oppgaveoversikt and manage students.
 */
public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Oppgaveoversikt oversikt = new Oppgaveoversikt(10);  // Max 10 students
            
            // Manually adding two students directly
            oversikt.getStudenter()[0] = new Student("Anna", 5);
            oversikt.getStudenter()[1] = new Student("Bjørn", 8);
            oversikt.setAntStud(2); // Update the count of students manually
            System.out.println("Pre-created students: Anna with 5 tasks, and Bjørn with 8 tasks.");
            
            boolean running = true;
            
            while (running) {
                System.out.println("\n--- Oppgaveoversikt Menu ---");
                System.out.println("1. Legg til student");
                System.out.println("2. Øk antall oppgaver for student");
                System.out.println("3. Se antall oppgaver for en student");
                System.out.println("4. Se alle studenter");
                System.out.println("5. Avslutt");
                System.out.print("Velg et alternativ: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        // Add a new student
                        System.out.print("Navn på student: ");
                        String navn = scanner.nextLine();
                        System.out.print("Antall oppgaver gjort: ");
                        int antOppg = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        oversikt.getStudenter()[oversikt.getAntStud()] = new Student(navn, antOppg);
                        oversikt.setAntStud(oversikt.getAntStud() + 1); // Increment student count
                        System.out.println("Student " + navn + " lagt til.");
                        pause(3000); // Pause for 3 seconds
                    }
                    
                    case 2 -> {
                        // Increase assignment count
                        System.out.print("Navn på student: ");
                        String studentNavn = scanner.nextLine();
                        System.out.print("Antall oppgaver å legge til: ");
                        int økning = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        if (oversikt.okAntallOppgaverSpesifikk(studentNavn, økning)) {
                            System.out.println("Oppdatering fullført for " + studentNavn);
                        } else {
                            System.out.println("Fant ikke student med navn " + studentNavn);
                        }
                        pause(3000); // Pause for 3 seconds
                    }
                    
                    case 3 -> {
                        // View assignments for a student
                        System.out.print("Navn på student: ");
                        String studentName = scanner.nextLine();
                        int oppgaver = oversikt.getSpesifikkAntallOppg(studentName);
                        if (oppgaver != -1) {
                            System.out.println(studentName + " har gjort " + oppgaver + " oppgaver.");
                        } else {
                            System.out.println("Fant ikke student med navn " + studentName);
                        }
                        pause(3000); // Pause for 3 seconds
                    }
                    
                    case 4 -> {
                        // View all students
                        System.out.println("Oversikt over alle studenter:");
                        System.out.println(oversikt.toString());
                        pause(3000); // Pause for 3 seconds
                    }
                    
                    case 5 -> {
                        // Exit
                        running = false;
                        System.out.println("Avslutter programmet.");
                    }
                    
                    default -> System.out.println("Ugyldig valg, prøv igjen.");
                }
            }
        }
    }

    /**
     * Pauses the execution for the specified amount of milliseconds.
     * 
     * @param milliseconds the amount of time to pause in milliseconds.
     */
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Interruption occurred.");
        }
    }
}