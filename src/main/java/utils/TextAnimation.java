package utils;

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
}
