/**
 * Immutable object for text-shortening and letter-removal.
 * String-input + two options.
 * 1. Shortens a sentence to only it's word's first letters: sentence.
 * 2. Or removes wanted letter: removeLetter.
 * Oppgave 1 øving 7.
 * 
 * @author Dennis Moe
 */
public final class NyString {
    private final String sentence;

    /**
     * Constructor to initialize the sentence. Since the class is immutable, no
     * modifications are allowed after the object is created.
     *
     * @param sentence the String sentence to edit. 
     */
    public NyString(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Returns the original sentence stored in this object.
     * This method provides access to the full sentence without modifying it.
     *
     * @return the original sentence stored in the object.
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Shortens the NyString sentence by splitting of the word and combining the
     * first letters of each word.
     * 
     * @return NyString object with only the first letters of each word in a
     *         sentence capitalized.
     */
    public NyString shortenSentence() {
        // Uses spaces to split the words
        String[] words = sentence.split(" "); // New array words with the words split for each space.
        StringBuilder shortened = new StringBuilder(); // Used internally so doesn't affect immutability.

        for (String word : words) { // For each String element in the array words, a new variable word will store
                                    // each split word "chronologically".
                                    // As in it will first store the first word, proccess it and then store the
                                    // potential second word.
                                    // I.e: "Jeg er Dennis", word = "Jeg", then "er", then "Dennis".
            if (!word.isEmpty()) { // If a word is not empty, i.e. not just a space, it appends the first letter to
                                   // shortened.
                shortened.append(word.charAt(0));
            }
        }

        // Convert to capitalized
        String capitalized = shortened.toString().toUpperCase(); // Use to.String() to convert from StrinBuilder to String.

        // Returns shortened NyString object, not changing the original.
        return new NyString(capitalized);
    }

    /**
     * 
     * @param modifiedSentence The original string to remove characters from.
     * @param index position of character to be removed.
     * @return the sentence without any occurances of chosen letter.
     */
    public NyString removeLetter(char letter) {
        String modifiedSentence = sentence;
        int index = modifiedSentence.indexOf(letter); // Finds the first instance of the letter

        // Loop to remove the letter
        while (index != -1) { // Index not being -1 means the letter was found.
            // Removes the letter at the found index (i.e. 4)
            // Removes everything before letter. I.e. "Hello I am Dennis", 
            // Would become "Hell", while (index + 1) would be " I am Dennis"
            // Combined would be "Hell I am Dennis"
            modifiedSentence = modifiedSentence.substring(0, index) + modifiedSentence.substring(index + 1);

            // Searches for any next instance
            index = modifiedSentence.indexOf(letter);
        }
        return new NyString(modifiedSentence);
    }

}