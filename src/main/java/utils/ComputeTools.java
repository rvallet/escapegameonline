package main.java.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Rémy VALLET
 */
public class ComputeTools {
    private static Logger logger = LogManager.getLogger(ComputeTools.class.getName());

    //TODO: Delete this foolish main
    public static void main(String[] args) {
        System.out.println("*** tests from ComputeTools***");
        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
        System.out.println(ScannerTools.isValidAnswer("= fds ff ds =+="));
    }
}
