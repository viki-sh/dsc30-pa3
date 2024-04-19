import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    @Test
    public void transcribe1() {
        ProteinSynthesis obj = new ProteinSynthesis();
        String dna = "ATGATCTCGTAA";
        CharQueue expectedRna = new CharQueue(dna.length());
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

        while (!expectedRna.isEmpty() && !actualRna.isEmpty()) {
            assertEquals(expectedRna.dequeue(), actualRna.dequeue(), "Each character in RNA sequences should match.");
        }
    }
}