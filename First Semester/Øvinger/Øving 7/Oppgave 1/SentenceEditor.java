/**
 * The SentenceEditor class gives an example of the NyString class.
 * It shortens a sentence, and removes a specific letter from a sentence.
 * 
 * @author Dennis Moe
 */
public class SentenceEditor {

    /**
     * The main method that runs the program.
     * It performs sentence shortening and letter removal on a given sentence.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Example sentence
        String sentence = "Dette er en testsetning, den er ikke veldig lang.";

        // Creates a NyString object
        NyString nyString = new NyString(sentence);

        // Applies the shortening method and prints the shortened sentence
        NyString shortenedNyString = nyString.shortenSentence();
        String shortened = shortenedNyString.getSentence();  // Get the shortened sentence
        System.out.println("Forkortet setning: " + shortened);

        // Apply removeLetter-method to remove 'e' and print the modified sentence
        NyString modifiedNyString = nyString.removeLetter('e');
        String modifiedSentence = modifiedNyString.getSentence();  // Get the modified sentence
        System.out.println("Setning uten bokstaven e: " + modifiedSentence);
    }
}
