package main.java.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * This Class contains methods to easily generate a Random with parameters
 * @author Rémy VALLET
 */
public abstract class RanChoice {
    private static Logger logger = LogManager.getLogger(RanChoice.class.getName());
    /**
     * Method that takes as parameter lower and upper bounds to return a random number between these bounds
     * 
     * @author Rémy VALLET
     * @param min
     * @param max
     * @return int --> the randomly chosen number
     */
         public static int ranChoice(int min, int max) {
             if (max - min + 1 <= 0 ) {
/*                 logger.info("RanChoice : min = "+min+" max = "+max);*/
                 return min<max ? min : max;
             } else {
                 Random num = new Random();
                 return min + num.nextInt(max - min + 1);
             }
        }
}
