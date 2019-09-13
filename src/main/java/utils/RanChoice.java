package main.java.utils;

import java.util.Random;

/**
 * This Class contains methods to easily generate a Random with parameters
 * @author Rémy VALLET
 */
public abstract class RanChoice {

    /**
     * Method that takes as parameter lower and upper bounds to return a random number between these bounds
     * @author Rémy VALLET
     * @param min
     * @param max
     * @return int --> the randomly chosen number
     */
         public static int ranChoice(int min, int max) {
            Random num = new Random();
            return min + num.nextInt(max - min + 1);
        }
}
