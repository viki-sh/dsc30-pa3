import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    @Test
    public void transcribe1() {
        ProteinSynthesis obj = new ProteinSynthesis();
        String dna = "ATGATCTCGTAA";
        int lengthDna = dna.length();
        CharQueue expectedRna = new CharQueue(lengthDna);
        expectedRna.enqueue('A');
        expectedRna.enqueue('U');
        expectedRna.enqueue('G');
        expectedRna.enqueue('A');
        expectedRna.enqueue('U');
        expectedRna.enqueue('C');
        expectedRna.enqueue('U');
        expectedRna.enqueue('C');
        expectedRna.enqueue('G');
        expectedRna.enqueue('U');
        expectedRna.enqueue('A');
        expectedRna.enqueue('A');

        CharQueue actualRna = obj.transcribeDNA(dna);

        for (int i = 0; i < lengthDna; i++) {
            char expectedChar = expectedRna.dequeue();
            char actualChar = actualRna.dequeue();
            assertEquals(expectedChar, actualChar);
        }
    }
}