import main.java.utils.RanChoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UtilsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testRanChoice(){
        boolean result = true;
        int nbTest = 100;
        //TODO: implement properties for mix/max
        int min = 0;
        int max = 9;

        for (int i = 0; i < nbTest; i++) {
            int ranResult = RanChoice.ranChoice(min, max);
            if (ranResult > max || ranResult < min) {
                result = false;
                i=nbTest;
            }
        }
        assertTrue(result);
    }
}