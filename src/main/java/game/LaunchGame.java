package main.java.game;

public class LaunchGame {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*** from Main class LaunchGame *** ");
        start();
    }

    public static void start() throws InterruptedException {
        GameCommonContent.gameIntroduction();
        GameCommonContent.gameStartMenu();
    }
}