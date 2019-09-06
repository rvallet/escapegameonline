package main.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private String contentLanguage;
    Properties prop = new Properties();
    Properties content = new Properties();

    public PropertiesReader() {
        String propLanguage = getProp("settings.language");
        switch(propLanguage) {
            case "fr-FR" :
                this.contentLanguage = getProp("settings.languageChoiceFR");
                break;
            case "en-US" :
                this.contentLanguage = getProp("settings.languageChoiceEN");
                break;
            default: this.contentLanguage ="game_content_fr-FR.properties";
        }
    }

    public String getProp (String propName) {
        String result=null;

        try {
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("game_settings.properties");

            if (input != null) {
                //load a properties file from class path, inside static method
                prop.load(input);

                //get the property value and print it out
                result = prop.getProperty(propName);
            } else {
                //Todo: replace with logger from log4j
                System.err.println("game_settings.properties ne s'est pas chargé correctement");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getIntProp (String propName) {
        return Integer.parseInt(getProp(propName));
    }

    public Boolean getBoolProp (String propName) {
        return Boolean.getBoolean(getProp(propName));
    }

    public String getContent (String contentName) {
        String result=null;

        try {
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream(this.contentLanguage);

            if (input != null) {
                //load a properties file from class path, inside static method
                content.load(input);

                //get the property value and print it out
                result = content.getProperty(contentName);
            } else {
                //Todo: replace with logger from log4j
                System.err.println(this.contentLanguage +" ne s'est pas chargé correctement");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
