package utils;

import java.util.Scanner;

/**
 * @author Rémy VALLET
 */
public abstract class ScannerTools {
    private static Scanner sc = new Scanner(System.in);

    /**
     * @author Rémy VALLET
     * @return int -->
     */
    public static int readInt() {
        return sc.nextInt();
    }

    /**
     * @author Rémy VALLET
     * @return String --> the first word entered by the user
     */
        public static String readWord() {
            return sc.next();
        }

    /**
     * @author Rémy VALLET
     * @return String --> the entire line entered by the user
     */
        public static String readLine() {
            return sc.nextLine();
        }

    //TODO: Delete this foolish main
    public static void main(String[] args) {
        System.out.println("*** tests from ScannerTools***");
    }
}
