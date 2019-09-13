package main.java.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Rémy VALLET
 */
public class ComputeTools {
    private static Logger logger = LogManager.getLogger(ComputeTools.class.getName());

    //TODO: Delete this foolish main
    public static void main(String[] args) {
        System.out.println("*** tests from ComputeTools***");
        logger.debug("\nDefault file game_content_fr-FR.properties is loaded.\nFailed to recognize entry in parameter settings.language : "+"propLanguage"+"\nPlease check this entry or/and add this new case into PropertiesReader.java");
        logger.info("Info Message Logged !!!");
        logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
        System.out.println(ScannerTools.isValidAnswerOperatorsSign("= fds ff ds =+="));
    }
}
