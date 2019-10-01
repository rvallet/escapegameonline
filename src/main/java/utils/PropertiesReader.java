package main.java.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    /* Class variable */
    private String contentLanguage;
    private static Logger logger = LogManager.getLogger(PropertiesReader.class.getName());

    /* Tools */
    Properties prop = new Properties();
    Properties content = new Properties();

    /* Class constructor */
    public PropertiesReader() {
        String propLanguage = getProp("settings.language").trim();
        switch(propLanguage) {
            case "fr-FR" :
                this.contentLanguage = getProp("settings.languageChoiceFR");
                break;
            case "en-US" :
                this.contentLanguage = getProp("settings.languageChoiceEN");
                break;
            default:
                this.contentLanguage ="game_content_fr-FR.properties";
                logger.info("Default file game_content_fr-FR.properties is loaded.\nFailed to recognize entry in parameter settings.language : "+propLanguage+"\nPlease check this entry or/and add this new case into PropertiesReader.java");
        }
    }

    /* Class Methods */
    /**
     * Method to get a String in the game_settings.properties file.
     * @author Rémy VALLET
     * @param propName the name of the properties
     * @return String of the propName contained in game_settings.properties
     */
    public String getProp (String propName) {
        String result=null;
        try {
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("game_settings.properties");
            if (input != null) {
                //load a properties file from class path, inside static method
                prop.load(input);
                //display information if "propName" doesn't exist anymore
                if (prop.getProperty(propName) == null) {
                    logger.info(propName + " has not been found.\n Check its existence in file game_settings.properties");
                }
                //display information if value "propName" is empty
                if (prop.getProperty(propName).length() <1) {
                    logger.info(propName+" is empty.\n Check its value in file game_settings.properties");
                }
                //get the property value and print it out
                result = prop.getProperty(propName);
            } else {
                logger.info("game_settings.properties file did not load correctly.\nCheck if the file exist with the correct name in the resources folder");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method to get an Int in the game_settings.properties file.
     * @author Rémy VALLET
     * @param propName the name of the properties
     * @return int of the propName contained in game_settings.properties
     */
    public int getIntProp (String propName) {
        if (propName != null && getProp(propName.trim()) != null && Integer.parseInt(getProp(propName)) > 0) {
            return Integer.parseInt(getProp(propName.trim()));
        } else {
            logger.info("Unreachable requested property.\nCheck the submitted name on this properties file");
            return 0;
        }
    }

    /**
     * Method to get a boolean in the game_settings.properties file.
     * @author Rémy VALLET
     * @param propName the name of the properties
     * @return Boolean of the propName contained in game_settings.properties
     */
    public Boolean getBoolProp (String propName) {
        return Boolean.valueOf(getProp(propName).trim().toLowerCase());
    }

    /**
     * Method to get a String in the game_content_xx-XX.properties files.
     * @author Rémy VALLET
     * @param contentName the name of the properties
     * @return String of the contentName contained in game_content_xx-XX.properties
     */
    public String getContent (String contentName) {
        String result=null;
        try {
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream(this.contentLanguage);

            if (input != null) {
                //load a properties file from class path, inside static method
                content.load(input);
                if (content.getProperty(contentName).length() < 1) {
                    logger.info(contentName+" is empty or has not been found.\n Check its existence in file game_settings.properties");
                }
                //get the property value and print it out
                result = content.getProperty(contentName);
            } else {
                logger.info(this.contentLanguage+" file did not load correctly.\nCheck if the file exist with the correct name in the resources folder");
            }

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException occurred.",e);
        }
        return result;
    }
}
