/*
    Name: Viki Shi
    PID:  A17704905
 */

import java.util.Arrays;

/**
 * Uses CharQueue.java to perform a DNA to protein sequence
 *
 * @author Viki Shi
 * @since 4/17/2024
 */
class ProteinSynthesis {
    private static final int CODON_SIZE = 3;
    /**
     * Helper method to cast a CharQueue into a string
     * @param codonQueue a CharQueue representing the codon
     * @return string value of codonQueue
     * **/
    public String convertQueues(CharQueue codonQueue){
        // Create a StringBuilder to construct the string representation of the codon
        StringBuilder codonStr = new StringBuilder();

        // Iterate through the CharQueue and append each character to the StringBuilder
        while (!codonQueue.isEmpty()) {
            char c = codonQueue.dequeue();
            codonStr.append(c);
        }

        return codonStr.toString();
    }
     /**
      * Helper method to determine if codon is AUG
      * @param codonCheck a CharQueue representing the codon
      * @return boolean if codon is 'A','U','G'
      * **/
    public boolean checkQueues(CharQueue codonCheck){
        CharQueue check = new CharQueue(CODON_SIZE);
        check.enqueue('A');
        check.enqueue('U');
        check.enqueue('G');

        for (int i = 0; i < CODON_SIZE; i++) {
            char expectedChar = check.dequeue();
            char actualChar = codonCheck.dequeue();
            if (actualChar != expectedChar) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that translates all Ts to Us
     * @param dna a string representing the DNA
     * @return the rna, a CharQueue object with all DNA values but T is now U
     * @throws IllegalArgumentException if input isnt divisible by 3
     */
    public CharQueue transcribeDNA(String dna) {
        CharQueue rna = new CharQueue(dna.length());
        if (dna.length()%CODON_SIZE!=0){
            throw new IllegalArgumentException("input must be divisible by 3");
        }
        char[] charArray = dna.toCharArray();
        for (char c : charArray) {
            if (c == 'T') {
                rna.enqueue('U');
            } else {
                rna.enqueue(c);
            }
        }

        return rna;
    }

    /**
     * Returns the protein based on amino acids in RNA
     * @param rna a CharQueue object representing the RNA
     * @return the protein, a CharQueue object with all RNA codons translated
     * **/
    public CharQueue translateRNA(CharQueue rna) {
        CharQueue codon = new CharQueue(CODON_SIZE);
        CharQueue sequence = new CharQueue(rna.size());
        while (rna.size() > 0) {
            for (int q = 0; q < CODON_SIZE; q++) {
                char elem = rna.dequeue();
                codon.enqueue(elem);
            }
            if (checkQueues(codon)) {
                sequence.enqueue('A');
                sequence.enqueue('U');
                sequence.enqueue('G');
                while (rna.size() > 0) {
                    char amino3 = rna.dequeue();
                    sequence.enqueue(amino3);
                }
                codon.clear();
                break;
            }
            codon.clear(); // if codon isnt AUG, clears the codon to check next
        }

        CharQueue translation = new CharQueue(sequence.size());
        while (!sequence.isEmpty()) {
            for (int i = 0; i < CODON_SIZE; i++) {
                char elem = sequence.dequeue();
                codon.enqueue(elem);
            }
            if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                while (!sequence.isEmpty()) {
                    char finalElem = sequence.dequeue();
                    translation.enqueue(finalElem);
                }
                break;
            }
            for (int y = 0; y < CODON_SIZE; y++) {
                char keptElem = codon.dequeue();
                translation.enqueue(keptElem);
            }
            codon.clear();
        }


        // now we have the final sequence (translation). need to find the amino acid
        CharQueue protein = new CharQueue(translation.size());
        while (!translation.isEmpty()) {
            for (int g = 0; g < CODON_SIZE; g++) {
                char elem = translation.dequeue();
                codon.enqueue(elem);
                // adds into codon
            }
            char amino;
            String stringCodon = convertQueues(codon);
            amino = CodonMap.getAminoAcid(stringCodon);
            protein.enqueue(amino);
        }
        return protein;
    }
}
