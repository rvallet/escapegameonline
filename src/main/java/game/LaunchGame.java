package main.java.game;

import main.java.utils.PropertiesReader;

public class LaunchGame {

    public static void main(String[] args) throws InterruptedException {
       start();
    }

    public static void start() throws InterruptedException {
        GameCommonContent.gameIntroduction();
        GameCommonContent.gameStartMenu();
    }
}