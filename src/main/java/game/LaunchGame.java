package game;

import main.java.utils.PropertiesReader;

public class LaunchGame {

    public static void main(String[] args) {
        System.out.println("*** from Main class LaunchGame *** ");
        start();
        PropertiesReader pr = new PropertiesReader();
        System.out.println(pr.getProp("settings.nbDigit"));
        System.out.println(pr.getProp("settings.nbTries"));
        System.out.println(Boolean.getBoolean(pr.getProp("settings.devMode")));
    }

    public static void start(){
        System.out.println("You're not prepared !!!");
    }
}