import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    ProteinSynthesis obj;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        obj = new ProteinSynthesis();
}
    @Test
    public void transcribe1() {
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
    @Test
    public void transcribe2() {
        String dna = "ATCATC";
        String expectedRna = "AUCAUC";
        CharQueue actualRna = obj.transcribeDNA(dna);

        assertTrue(dna.length() == expectedRna.length());

        for (int i = 0; i < dna.length(); i++) {
            assertEquals(actualRna.dequeue(), expectedRna.charAt(i));
        }
    }
    @Test
    public void transcribe3() {
        String dna = "ATGCTATGT";
        String expectedRna = "AUGCUAUGU";
        CharQueue actualRna = obj.transcribeDNA(dna);

        assertTrue(dna.length() == expectedRna.length());

        for (int i = 0; i < dna.length(); i++) {
            assertEquals(actualRna.dequeue(), expectedRna.charAt(i));
        }
    }
    @Test
    public void transcribe4() {
        assertThrows(IllegalArgumentException.class, () -> {
            String dna = "ATGCTATG";
            obj.transcribeDNA(dna);
        });
    }
    @Test
    public void translate1() {
        CharQueue inputRna = new CharQueue(9);
        inputRna.enqueue('A');
        inputRna.enqueue('U');
        inputRna.enqueue('G');
        inputRna.enqueue('C');
        inputRna.enqueue('U');
        inputRna.enqueue('A');
        inputRna.enqueue('U');
        inputRna.enqueue('G');
        inputRna.enqueue('U');

        CharQueue expectedProtein = new CharQueue(3);
        expectedProtein.enqueue('M');
        expectedProtein.enqueue('L');
        expectedProtein.enqueue('C');

        CharQueue actualProtein = obj.translateRNA(inputRna);
        for (int i = 0; i < 3; i++) {
            char expectedChar = expectedProtein.dequeue(); // Expected character
            char actualChar = actualProtein.dequeue(); // Actual character

            // Compare actual and expected characters
            assertEquals(expectedChar, actualChar);
        }
    }
}