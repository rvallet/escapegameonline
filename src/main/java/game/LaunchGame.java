package main.java.game;

import main.java.utils.PropertiesReader;

public class LaunchGame {
/* static PropertiesReader pr = new PropertiesReader();*/

    public static void main(String[] args) {
        System.out.println("*** from Main class LaunchGame *** ");
        start();

        System.out.println("*** from Lauching ChallengerMode *** ");
        ChallengerMode cmGame = new ChallengerMode();
        System.out.println(cmGame.generateSecretNum());
        System.err.println("Tentative : "+cmGame.getTentativeNum());
        System.out.println(cmGame.getMinArr());
        System.out.println(cmGame.getMaxArr());
        cmGame.adjustMinMax("-==+");
        System.out.println("updatedMin : "+cmGame.getMinArr());
        System.out.println("updatedMax : "+cmGame.getMaxArr());
        System.out.println("Number : "+cmGame.getSecretNum());
        System.out.println(cmGame.generateSecretNum());
        System.err.println("Tentative : "+cmGame.getTentativeNum());
        System.out.println("Number : "+cmGame.getSecretNum());

    }

    public static void start(){
        System.out.println("You're not prepared !!!");
    }
}