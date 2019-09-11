package main.java.utils;

import java.util.Scanner;

/**
 * @author Rémy VALLET
 */
public abstract class ScannerTools {
    private static Scanner sc = new Scanner(System.in);

    /**
     * @author Rémy VALLET
     * @return String --> the entire line entered by the user
     */
    public static String readLine() {
        return sc.nextLine();
    }

    /**
     * @author Rémy VALLET
     * @return int -->
     */
    public static int readInt(int maxInt) {
        while (!sc.hasNextInt()) {
            System.out.println("Vous devez entrer un choix valide (chiffre entre 1 et "+maxInt+")");
            System.out.print("Human > ");
            sc.next();
        }
        while (sc.nextInt() > maxInt){
            System.out.println("Vous devez entrer un choix valide (chiffre entre 1 et "+maxInt+")");
            System.out.print("Human > ");
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Check if the user has entered the correct string length
     * and contains only the signs '+','-', '='.
     * @author Rémy VALLET
     * @return Boolean -->
     */
    public static Boolean isValidAnswer (String userInput) {
        return userInput.length()== new PropertiesReader().getIntProp("settings.nbDigit") ? userInput.matches("[-=+]*") : false;
    }
}
