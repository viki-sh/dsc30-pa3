/*
    Name: Viki Shi
    PID:  A17704905
 */

/**
 * Uses CharQueue.java to perform a DNA to protein sequence
 *
 * @author Viki Shi
 * @since 4/17/2024
 */
class ProteinSynthesis {
    /**
     * @param dna a string representing the DNA
     * @return the rna, a CharQueue object with all DNA values but T is now U
     * @throws IllegalArgumentException if input isnt divisible by 3
     */
    public CharQueue transcribeDNA(String dna) {
        int lengthDna = dna.length();
        CharQueue rna = new CharQueue(lengthDna);
        if (dna.length()%3!=0){
            throw new IllegalArgumentException("input must be divisible by 3");
        }
        char[] charArray = dna.toCharArray(); // cast string dna to array
        for (int i=0; i<dna.length(); i++){
            if (charArray[i] == 'T'){
                rna.enqueue('U');
            }else{
                rna.enqueue(charArray[i]);
            }
        }
        return rna;
    }
    /**
     * @param rna a CharQueue object representing the RNA
     * @return the protein, a CharQueue object with all RNA codons translated
     * **/
    public CharQueue translateRNA(CharQueue rna) {
        CharQueue codon = new CharQueue(3);
        // checks each codon
        CharQueue sequence = new CharQueue(rna.size());
        // the sequence after AUG is found
        for (int i = 0; i<rna.size()/3; i++){
            for(int q = 0; q <3; q++){
                char elem = rna.dequeue();
                // current element we are observing
                codon.enqueue(elem);
                // add to codon checker
                if (codon.equals("AUG")) {
                    // if we find start
                    for (int x = 0; x<rna.size(); x++) {
                        char amino3 = rna.dequeue();
                        sequence.enqueue(amino3);
                    } break;
                }
            }
            codon.clear();
            // if codon isnt AUG, clears the codon to check next
        }
        // now we have sequence, all the rna BEFORE a stopping codon
        CharQueue translation = new CharQueue(sequence.size());
        for (int i = 0; i<sequence.size(); i++) {
            // for each nucleotide in sequence
            char elem1 = sequence.dequeue();
            codon.enqueue(elem1);
            // puts into codon to check if ends
            if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")
                    || i == sequence.size()-1){
                break;
                // returns final sequence when hits stopping codon
            }
            // else, dequeues from codon and puts into final sequence
            for (int j = 0; j < 3; j++) {
                char kept = codon.dequeue();
                translation.enqueue(kept);
            }
        }
        // now we have the final sequence (translation). need to find the amino acid
        CharQueue protein = new CharQueue(translation.size()/3);
        for (int v = 0; v < translation.size()/3; v++) {
            for (int g = 0; g < 3; g++) {
                char elem3 = translation.dequeue();
                codon.enqueue(elem3);
                // adds into codon
            }
            String codonString = codon.toString();
            char amino = CodonMap.getAminoAcid(codonString);
            codon.clear();
            protein.enqueue(amino);
        }
        return protein;
    }

}
