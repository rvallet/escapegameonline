package main.java.game;

import main.java.utils.PropertiesReader;

public class LaunchGame {

    public static void main(String[] args) {
        System.out.println("*** from Main class LaunchGame *** ");
        start();
        PropertiesReader pr = new PropertiesReader();
        System.out.println(pr.getIntProp("settings.nbDigit"));
        System.out.println(pr.getIntProp("settings.nbTries"));
        System.out.println(pr.getBoolProp("settings.devMode"));

        System.out.println("*** from Lauching ChallengerMode *** ");
        ChallengerMode CMgame = new ChallengerMode(pr.getIntProp("settings.nbDigit"), pr.getIntProp("settings.nbTries"), pr.getBoolProp("settings.devMode"));
        System.out.println(CMgame.generateSecretNum());

    }

    public static void start(){
        System.out.println("You're not prepared !!!");
    }
}