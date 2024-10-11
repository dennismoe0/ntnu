import java.util.Scanner;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialException;

/**
 * The Client class represents a console-based menu for managing worker data.
 * It allows users to select a worker, view and modify their details, and
 * perform various operations, such as calculating taxes and years employed.
 * 
 * The program starts with five pre-registered workers and provides
 * a navigable menu to interact with their data.
 * 
 * Every change prints a confirmation message to indicate that the data has
 * been updated.
 * 
 * @author Dennis Moe
 */
public class Client {

    /**
     * The main method of the Client program, which initializes the workers and
     * provides a console-based menu system for interacting with worker data.
     * Users can view worker information, modify salary and tax details, and
     * calculate various financial and employment details.
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Create 5 Person objects and Worker objects using the Person objects
        Person person1 = new Person("Dennis", "Moe", 2001);
        Worker worker1 = new Worker(person1, 1, 2015, 30000, 24);

        Person person2 = new Person("Even", "Kløvstad", 2001);
        Worker worker2 = new Worker(person2, 2, 2019, 25000, 22);

        Person person3 = new Person("Barack", "Obama", 1961);
        Worker worker3 = new Worker(person3, 3, 1998, 50000, 33);

        Person person4 = new Person("Gangnam", "Style", 2012);
        Worker worker4 = new Worker(person4, 4, 2023, 5000, 12);

        Person person5 = new Person("Ola", "Nordmann", 1984);
        Worker worker5 = new Worker(person5, 5, 2002, 100000, 46);

        // Worker-list

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);

        // Start input for menu

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        /**
         * Main program loop that runs until the user chooses to exit. It displays
         * the worker list and lets the user choose a worker to perform operations on.
         */
        while (running) {
            System.out.println("\nSelect ID number to enable actions with worker:");

            for (int i = 0; i < workers.size(); i++) {
                System.out.println("ID: " + workers.get(i).getWorkerID() + ". Name: " + workers.get(i).FormalWorkerName() + ".");
            }
            System.out.println("Or: " + (workers.size() + 1) + " to exit.");

            System.out.println("Enter ID of chosen worker: ");
            int workerChoice = scanner.nextInt();

            if (workerChoice < 1 || workerChoice > workers.size()) {
                if (workerChoice == workers.size() + 1) {
                    running = false; // Exits the program
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                continue;
            }

            // Get selected worker
            Worker selectedWorker = workers.get(workerChoice - 1); // -1 because of array index. 0 = 1 etc.

            // Worker specific menu
            boolean subMenuRunning = true;

            /**
             * Sub-menu for interacting with the selected worker. Allows viewing and editing
             * the worker's details, such as name, age, salary, tax, and employment duration.
             * Runs in a loop until the user returns to the main menu.
             */
            while (subMenuRunning) {
                System.out.println("\nMenu for: " + selectedWorker.FormalWorkerName() + ".");
                System.out.println("1. Display worker personal information."); // Name, Age.
                System.out.println("2. Monthly & yearly salary and tax percentage."); // Monthly salary and tax percentage.
                System.out.println("3. Monthly and yearly tax.");
                System.out.println("4. Years employed.");
                System.out.println("5. Compare years worked with number.");
                System.out.println("6. Edit monthly salary.");
                System.out.println("7. Edit tax percentage.");
                System.out.println("8. Back to worker selection.");

                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        /**
                         * Displays the worker's full name and age.
                         */
                        System.out.println("Name: " + selectedWorker.getPersonalInfo().getFirstName() + " "
                                + selectedWorker.getPersonalInfo().getLastName() + ". Age: " + selectedWorker.workerAge() + ".");
                        break;

                    case 2:
                        /**
                         * Displays the worker's monthly salary, yearly salary, and tax percentage.
                         */
                        System.out.println("Monthly salary: " + selectedWorker.getMonthlySalary() + " NOK. Tax percentage: " + selectedWorker.getTaxPercentage()
                                + " %.\nYearly salary: " + selectedWorker.yearlySalaryBeforeTax() + " NOK.");
                        break;

                    case 3:
                        /**
                         * Displays the worker's monthly and yearly tax amounts.
                         */
                        Worker.TaxInfo taxInfo = selectedWorker.taxesPaid();
                        System.out.println("Monthly tax amount: " + taxInfo.getMonthlyTax() + " NOK. Yearly tax amount: " + taxInfo.getYearlyTax() + " NOK.");
                        break;

                    case 4:
                        /**
                         * Displays the number of years the worker has been employed.
                         */
                        System.out.println("Years employed: " + selectedWorker.employmentTime() + ".");
                        break;

                    case 5:
                        /**
                         * Compares the worker's employment duration with a user-provided number
                         * and checks if the worker has worked for more than that number of years.
                         */
                        System.out.println("Write a number to check if the worker has worked there for more years.");
                        int yearChoice = scanner.nextInt();

                        if (selectedWorker.yearChecker(yearChoice)) {
                            System.out.println("He has worked there for longer than " + yearChoice + " years.");
                        } else {
                            System.out.println("No, he has not worked there for longer than " + yearChoice +
                                    " years, but he/she has worked there for " + selectedWorker.employmentTime() + " years.");
                        }
                        break;

                    case 6:
                        /**
                         * Prompts the user to enter a new monthly salary and updates the worker's salary.
                         */
                        System.out.println(selectedWorker.getMonthlySalary() + " NOK is the current monthly salary.\nEnter updated salary: ");
                        double newMonthlySalary = scanner.nextDouble();
                        selectedWorker.setMonthlySalary(newMonthlySalary);
                        System.out.println("New monthly salary set to: " + selectedWorker.getMonthlySalary() + " NOK.");
                        break;

                    case 7:
                        /**
                         * Prompts the user to enter a new tax percentage and updates the worker's tax percentage.
                         */
                        System.out.println(selectedWorker.getTaxPercentage() + " is the current tax percentage.\nEnter updated percentage: ");
                        double newMonthlyTax = scanner.nextDouble();
                        selectedWorker.setTaxPercentage(newMonthlyTax);
                        System.out.println("New tax percentage: " + selectedWorker.getTaxPercentage() + " %.");
                        break;

                    case 8:
                        /**
                         * Returns the user to the worker selection menu.
                         */
                        subMenuRunning = false; // Exit worker-specific menu
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

                /**
                 * Introduces a 3-second delay after each action to ensure the user
                 * can see the results before returning to the menu.
                 */
                try {
                    Thread.sleep(3000); // 3 second delay after every case
                } catch (InterruptedException e) {
                    System.out.println("An interruption occurred, continuing...");
                }
            }
        }

        scanner.close();
    }
}