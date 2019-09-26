package main.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility class for animation and text decoration in the console
 * @author Rémy VALLET
 */
public class TextAnimation {

    /**
     * Make text appear gradually: display text letter by letter with a delay
     * @author Rémy VALLET
     * @param str
     * @throws InterruptedException
     */
    public static void gradualText(String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            Thread.sleep(20);
        }
        System.out.println();
    }

    /**
     * Display text file
     * @author Rémy VALLET
     * @param relPath the relative path of the file
     */
    public static void displayFileText(String relPath) {
        InputStream fr = null;
        BufferedReader br = null;
        try {
            fr = TextAnimation.class.getResourceAsStream(relPath);
            br = new BufferedReader(new InputStreamReader(fr));
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.err.println(relPath);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException | NullPointerException f) {
                f.printStackTrace();
            }
        }
    }
}
