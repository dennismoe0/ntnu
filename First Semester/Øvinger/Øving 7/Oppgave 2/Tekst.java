/**
 * Simple client to test different methods in the TekstBehandling class.
 * This client performs various text manipulation operations such as word counting, capitalization,
 * character analysis, and word replacement.
 * 
 * @author Dennis Moe
 */
public class Tekst {

    /**
     * Main method for running the program.
     * Performs several tests on the TekstBehandling class including:
     *  - Printing the original text
     *  - Capitalizing the text
     *  - Counting the number of words, letters, and special characters
     *  - Calculating average word length
     *  - Calculating average words per period
     *  - Replacing specific words
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Test text: A sample passage for text manipulation tests.
        String tekst = 
                """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident, 
                sunt in culpa qui officia deserunt mollit anim id est laborum.
                """;
        
        // Initialize the TekstBehandling object with the sample text
        TekstBehandling tekstBehandling = new TekstBehandling(tekst);

        // Print the original text.
        System.out.println("Original text: " + tekstBehandling.getTekst());

        // Capitalize the text and print the capitalized version.
        TekstBehandling capitalizedText = tekstBehandling.capitalizeText();
        System.out.println("Capitalized text: " + capitalizedText.getTekst());

        // Count the number of words in the text and print the result.
        int wordCount = tekstBehandling.findWords();
        System.out.println("Word count: " + wordCount);

        // Count the number of letters and special characters in the text.
        TekstBehandling.averageWordLengthChecker characterCount = tekstBehandling.new averageWordLengthChecker();
        characterCount.countCharacters();
        System.out.println("Letters count: " + characterCount.normalLetters);
        System.out.println("Symbols count: " + characterCount.specialChars);

        // Calculate and print the average word length (letters per word).
        double averageWordLength = characterCount.calculateAverageWordLength();
        System.out.println("Average word length: " + averageWordLength + " letters per word.");

        // Calculate and print the average number of words per period (sentence).
        double averageWordsPerPeriod = tekstBehandling.averageWords();
        System.out.println("Average words per period: " + averageWordsPerPeriod);

        // Print a blank line for readability.
        System.out.println("");

        // Replace all occurrences of the word "sunt" with "pumba" and print the updated text.
        TekstBehandling updatedTekst = tekstBehandling.replaceWord("sunt", "pumba");
        System.out.println("Updated text: " + updatedTekst.getTekst());
    }
}