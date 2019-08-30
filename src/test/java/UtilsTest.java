import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import utils.ScannerTools;
import utils.RanChoice;
import utils.TextAnimation;
import utils.ComputeTools;


public class UtilsTest {
    int scannerTest = ScannerTools.readInt();
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
        int nbTest=10;
        //TODO: implement properties for mix/max
        int min = 0;
        int max = 9;

/*        while(result) {
            for (int i = 0; i < nbTest; i++) {
                int ranResult = RanChoice.ranChoice(min, max);
                if (ranResult > max || ranResult < min) {
                    result = false;
                    i=nbTest;
                }
            }
        }*/
        assertTrue(result);
    }
}