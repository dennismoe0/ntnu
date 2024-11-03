/**
 * Class TekstBehandling provides methods to analyze and manipulate text.
 * It can count words, calculate average word lengths, replace words, and capitalize the entire text.
 * 
 * @author Dennis Moe
 */
public class TekstBehandling {
    private final String tekst;

    /**
     * Constructor for TekstBehandling class.
     * 
     * @param tekst the text to be analyzed and manipulated.
     */
    public TekstBehandling(String tekst) {
        this.tekst = tekst;
    }

    /**
     * Getter method for retrieving the original text.
     * 
     * @return the original text.
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Counts the number of words in the text.
     * This method splits the text based on whitespace characters.
     * 
     * @return the number of words in the text.
     */
    public int findWords() {
        int countWords = tekst.split("\\s").length;
        return countWords;
    }

    /**
     * Inner class to count letters and special characters, and calculate average word length.
     */
    public class averageWordLengthChecker {
        int specialChars = 0;
        int normalLetters = 0;

        /**
         * Counts the number of normal letters (A-Z, a-z, å, æ, ø) and special characters (non-whitespace).
         * Iterates through each character in the text and increments the count based on character type.
         */
        public void countCharacters() {
            for (int i = 0; i < tekst.length(); i++) {
                char letter = tekst.charAt(i);
                if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z') ||
                    letter == 'å' || letter == 'Å' || letter == 'æ' || letter == 'Æ' || letter == 'ø' || letter == 'Ø') {
                    normalLetters++;
                } else if (!Character.isWhitespace(letter)) {
                    specialChars++;
                }
            }
        }

        /**
         * Calculates the average word length in the text.
         * This is done by dividing the number of normal letters by the total number of words.
         * 
         * @return the average word length. If the text contains no words, returns 0.
         */
        public double calculateAverageWordLength() {
            int wordCount = findWords(); // Gets total word count
            if (wordCount == 0) return 0; // Avoid division by zero.

            return (double) normalLetters / wordCount; // ensures return is a double
        }
    }

    /**
     * Capitalizes the entire text.
     * 
     * @return a new TekstBehandling object containing the capitalized text.
     */
    public TekstBehandling capitalizeText() {
        String capitalized = tekst.toUpperCase();
        return new TekstBehandling(capitalized);
    }

    /**
     * Calculates the average number of words per period in the text.
     * A period is defined as text separated by punctuation marks such as '.', ',', '!', '?', ':'.
     * 
     * @return the average number of words per period.
     */
    public double averageWords() {
        String[] periods = tekst.split("[\\.\\,\\!\\?\\:]");

        int totalWords = 0;
        int numberOfPeriods = periods.length;

        for (String period : periods) {
            String[] words = period.trim().split("\\s+");
            totalWords += words.length;
        }

        return (double) totalWords / numberOfPeriods;
    }

    /**
     * Replaces all instances of a word in the text with a new word.
     * Only whole words are replaced, not parts of other words.
     * 
     * @param oldWord the word to be replaced.
     * @param newWord the word to replace with.
     * @return a new TekstBehandling object containing the updated text.
     */
    public TekstBehandling replaceWord(String oldWord, String newWord) {
        String updatedTekst = tekst.replaceAll("\\b" + oldWord + "\\b", newWord);
        return new TekstBehandling(updatedTekst);
    }
}