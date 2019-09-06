package main.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    Properties prop = new Properties();

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
                System.out.println("game_settings.properties ne s'est pas chargé correctement");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
