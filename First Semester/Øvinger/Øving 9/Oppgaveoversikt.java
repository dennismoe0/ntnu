/**
 * This class manages an overview of students and the number of assignments they have completed.
 */
public class Oppgaveoversikt {
    private Student[] studenter; // Array to store multiple students.
    private int antStud = 0; // Number of students

    /**
     * Constructs an Oppgaveoversikt with a maximum number of students.
     * 
     * @param maksAntallStudenter the maximum number of students that can be stored.
     */
    public Oppgaveoversikt(int maksAntallStudenter) {
        studenter = new Student[maksAntallStudenter];
    }

    /**
     * Returns the number of students currently registered.
     *
     * @return the number of students.
     */
    public int getAntStud() {
        return antStud;
    }

    /**
     * Returns the array of students.
     *
     * @return the array of Student objects.
     */
    public Student[] getStudenter() {
        return studenter;
    }

    /**
     * Registers a new student if there is space.
     *
     * @param navn   the name of the student.
     * @param antOppg the initial number of assignments completed by the student.
     */
    public void registrerStudent(String navn, int antOppg) {
        if (antStud < studenter.length) {
            studenter[antStud] = new Student(navn, antOppg);
            antStud++;
        } else {
            System.out.println("Klassen er full, ikke plass til flere studenter.");
        }
    }

    /**
     * Sets the number of students in the system.
     *
     * @param antStud the number of students.
     */
    public void setAntStud(int antStud) {
        this.antStud = antStud;
    }

    /**
     * Returns the total number of registered students.
     *
     * @return the number of students registered.
     */
    public int studentCount() {
        return antStud;
    }

    /**
     * Prints the details of all registered students.
     */
    public void printStudents() {
        for (int i = 0; i < antStud; i++) {
            System.out.println(studenter[i].toString());
        }
    }

    /**
     * Returns the number of assignments completed by a specific student.
     *
     * @param navn the name of the student.
     * @return the number of assignments completed by the student, or -1 if the student is not found.
     */
    public int getSpesifikkAntallOppg(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // -1 to show invalid input if student not found
    }

    /**
    * Increases the number of assignments for a specific student.
    * 
    * @param navn   the name of the student.
    * @param økning the number of additional assignments completed.
    * @return true if the student was found and updated, false otherwise.
    */
    public boolean okAntallOppgaverSpesifikk(String navn, int økning) {
       for (int i = 0; i < antStud; i++) { // Iterate over all students
           if (studenter[i].getNavn().equals(navn)) { // If the student's name matches
               studenter[i].økAntOppg(økning); // Increase assignment count
               return true; // Operation successful
           }
       }
       return false; // Student not found
    }
    @Override // Override to display all students in a string and not memory adress
        public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < antStud; i++) {
            result.append(studenter[i].toString()).append("\n");
        } 
        return result.toString();
    }
}