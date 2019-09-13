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

    /* Unused reader because sc.next seems to saturate memory when user submit many wrong input */
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
     * and contains only the signs '+','-', '=' in Challenger Mode.
     * @author Rémy VALLET
     * @return Boolean --> true if contains only '+','-','+' with the correct length.
     */
    public static Boolean isValidAnswerOperatorsSign(String userInput) {
        return userInput.length()== new PropertiesReader().getIntProp("settings.nbDigit") ? userInput.matches("[-=+]*") : false;
    }

    /**
     * Check if the user has entered the correct string length
     * and contains only digits from 0 to 9 in Defender Mode.
     * @author Rémy VALLET
     * @return Boolean --> true if contains only digit from 0 to 9 with the correct length.
     */
    public static Boolean isValidAnswerDigits (String userInput) {
        return userInput.length()== new PropertiesReader().getIntProp("settings.nbDigit") ? userInput.matches("[0-9]*") : false;
    }
}
