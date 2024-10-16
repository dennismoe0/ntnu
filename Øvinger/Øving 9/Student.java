/**
 * Represents a student with a name and the number of assignments completed.
 */
public class Student {
    /**
     * The name of the student. This field is immutable.
     */
    private final String navn; // Immutable

    /**
     * The number of assignments completed by the student.
     */
    private int antOppg; // Number of assignments completed

    /**
     * Constructs a new Student with the specified name and number of assignments completed.
     *
     * @param navn    the name of the student.
     * @param antOppg the initial number of assignments completed.
     */
    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    /**
     * Returns the name of the student.
     *
     * @return the student's name.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Returns the number of assignments completed by the student.
     *
     * @return the number of assignments completed.
     */
    public int getAntOppg() {
        return antOppg;
    }

    /**
     * Increases the number of assignments completed by the specified amount.
     *
     * @param økning the amount to increase the assignment count by.
     */
    public void økAntOppg(int økning) {
        this.antOppg += økning;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a string containing the student's name and number of assignments completed.
     */
    @Override
    public String toString() {
        return "Student: " + navn + ".\nAntall oppgaver gjort: " + antOppg;
    }
}