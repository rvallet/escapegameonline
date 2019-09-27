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
    public String getProp (String propName) {
        String result=null;

        try {
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("game_settings.properties");

            if (input != null) {
                //load a properties file from class path, inside static method
                prop.load(input);
                if (prop.getProperty(propName).length() <1) {
                    logger.info(propName+" is empty or has not been found.\n Check its existence in file game_settings.properties");
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

    public int getIntProp (String propName) {
        if (propName != null && getProp(propName.trim()) != null && Integer.parseInt(getProp(propName)) > 0) {
            return Integer.parseInt(getProp(propName.trim()));
        } else {
            logger.info("Unreachable requested property.\nCheck the submitted name on this properties file");
            return 0;
        }
    }

    public Boolean getBoolProp (String propName) {
        return Boolean.valueOf(getProp(propName).trim().toLowerCase());
    }

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
            logger.error("IOException occured.",e);
        }
        return result;
    }
}
