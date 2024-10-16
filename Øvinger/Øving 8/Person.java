/**
 * Represents a person with first name, last name, and birth year.
 * 
 * @author Dennis Moe
 */
public class Person {
    private final String firstName;  // The person's first name.
    private final String lastName;   // The person's last name.
    private final int birthYear;     // The person's birth year.

    /**
     * Constructor to initialize a Person object.
     * 
     * @param firstName  The first name of the person.
     * @param lastName   The last name of the person.
     * @param birthYear  The birth year of the person.
     */
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    // Getters

    /**
     * Gets the first name of the person.
     * 
     * @return The person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the person.
     * 
     * @return The person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the birth year of the person.
     * 
     * @return The person's birth year.
     */
    public int getBirthYear() {
        return birthYear;
    }
}