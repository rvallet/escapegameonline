package main.java.game;

import main.java.utils.PropertiesReader;

public class LaunchGame {
    static Boolean mainDevMode = false;

    public static void main(String[] args) throws InterruptedException {
        if (args.length>0 && args[0].equalsIgnoreCase("dev")) {
            mainDevMode=true;
        }
       start();
    }

    public static void start() throws InterruptedException {
        GameCommonContent.gameIntroduction();
        GameCommonContent.gameStartMenu();
    }
}