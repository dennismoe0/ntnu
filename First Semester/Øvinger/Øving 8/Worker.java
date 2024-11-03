import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a worker with personal information, salary, and employment details.
 * 
 * @author Dennis Moe
 */
public class Worker {
    private final Person personalInfo;  // Immutable Person object.
    private final int workerID;         // Worker number.
    private double monthlySalary;       // Monthly salary.
    private final int employmentYear;   // Year of employment/year of hiring.
    private double taxPercentage;       // Tax percentage of salary.

    /**
     * Constructor to initialize a Worker object.
     * 
     * @param personalInfo     The personal information of the worker.
     * @param workerID         The unique worker number.
     * @param employmentYear   The year the worker was hired.
     * @param monthlySalary    The worker's monthly salary.
     * @param taxPercentage    The percentage of the salary that is taxed.
     */
    public Worker(Person personalInfo, int workerID, int employmentYear, double monthlySalary, double taxPercentage) {
        this.personalInfo = personalInfo;
        this.workerID = workerID;
        this.employmentYear = employmentYear;
        this.monthlySalary = monthlySalary;
        this.taxPercentage = taxPercentage;
    }

    // Getters.

    /**
     * Gets the personal information of the worker.
     * 
     * @return The worker's personal information.
     */
    public Person getPersonalInfo() {
        return personalInfo;
    }

    /**
     * Gets the worker's unique ID.
     * 
     * @return The worker ID.
     */
    public int getWorkerID() {
        return workerID;
    }

    /**
     * Gets the year the worker was hired.
     * 
     * @return The worker's employment year.
     */
    public int getEmploymentYear() {
        return employmentYear;
    }

    /**
     * Gets the worker's monthly salary.
     * 
     * @return The worker's monthly salary.
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * Gets the percentage of salary that is taxed.
     * 
     * @return The tax percentage.
     */
    public double getTaxPercentage() {
        return taxPercentage;
    }

    // Setters.

    /**
     * Sets the worker's monthly salary.
     * 
     * @param monthlySalary The new monthly salary for the worker.
     */
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * Sets the worker's tax percentage.
     * 
     * @param taxPercentage The new tax percentage for the worker.
     */
    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * Represents the tax information with monthly and yearly tax.
     */
    public class TaxInfo {
        private final double monthlyTax;
        private final double yearlyTax;

        /**
         * Constructor for tax information.
         * 
         * @param monthlyTax The monthly tax amount.
         * @param yearlyTax  The yearly tax amount.
         */
        public TaxInfo(double monthlyTax, double yearlyTax) {
            this.monthlyTax = monthlyTax;
            this.yearlyTax = yearlyTax;
        }

        /**
         * Gets the monthly tax amount.
         * 
         * @return The monthly tax.
         */
        public double getMonthlyTax() {
            return monthlyTax;
        }

        /**
         * Gets the yearly tax amount.
         * 
         * @return The yearly tax.
         */
        public double getYearlyTax() {
            return yearlyTax;
        }
    }

    /**
     * Calculates and returns the worker's taxes paid monthly and yearly.
     * 
     * @return A TaxInfo object containing both monthly and yearly tax values.
     */
    public TaxInfo taxesPaid() {
        double monthlyTax = (this.monthlySalary * (this.taxPercentage / 100));
        double yearlyTax = (10 * monthlySalary) + (0.5 * monthlySalary);
        return new TaxInfo(monthlyTax, yearlyTax);
    }

    /**
     * Calculates and returns the yearly salary before tax.
     * 
     * @return The yearly salary before tax.
     */
    public double yearlySalaryBeforeTax() {
        return this.monthlySalary * 12;
    }

    /**
     * Returns the worker's name in the format "Lastname, Firstname".
     * 
     * @return The worker's name in formal format.
     */
    public String FormalWorkerName() {
        return personalInfo.getLastName() + ", " + personalInfo.getFirstName();
    }

    /**
     * Calculates and returns the worker's age.
     * 
     * @return The worker's age.
     */
    public int workerAge() {
        GregorianCalendar kalender = new GregorianCalendar();
        int currentYear = kalender.get(Calendar.YEAR);
        int birthYear = personalInfo.getBirthYear();
        return currentYear - birthYear;
    }

    /**
     * Calculates and returns the number of years the worker has been employed.
     * 
     * @return The number of years employed.
     */
    public int employmentTime() {
        GregorianCalendar kalender = new GregorianCalendar();
        int currentYear = kalender.get(Calendar.YEAR);
        int employedYear = getEmploymentYear();
        return currentYear - employedYear;
    }

    /**
     * Checks if the worker has worked for more than the specified number of years.
     * 
     * @param yearsToCheck The number of years to compare against.
     * @return True if the worker has worked longer than the specified years, otherwise false.
     */
    public boolean yearChecker(int yearsToCheck) {
        GregorianCalendar kalender = new GregorianCalendar();
        int currentYear = kalender.get(Calendar.YEAR);
        int yearsWorked = currentYear - this.employmentYear;
        return yearsWorked > yearsToCheck;
    }
}