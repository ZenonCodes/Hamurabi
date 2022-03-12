package hammurabi;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class LostMindPhrasesTest {

    @Test
    void setPhrase() throws IOException {
        // Given
        LostMindPhrases getPhrase = new LostMindPhrases();
        // When
        String output = getPhrase.setPhrase();
        // Then
        System.out.println(output);
    }
}