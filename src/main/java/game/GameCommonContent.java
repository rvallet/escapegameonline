package main.java.game;

import main.java.utils.PropertiesReader;
import main.java.utils.ScannerTools;
import main.java.utils.TextAnimation;


public class GameCommonContent {
    private static PropertiesReader pr = new PropertiesReader();
    private static Boolean playAgain = false;

    public static void gameIntroduction() throws InterruptedException {
        TextAnimation.displayFileText(pr.getProp("settings.gameLogo"));
        TextAnimation.gradualText(pr.getContent("content.intro1.1"));
        TextAnimation.gradualText(pr.getContent("content.intro1.2")+pr.getIntProp("settings.nbDigit")+" "+pr.getContent("content.intro1.3")+pr.getIntProp("settings.nbTries")+" "+pr.getContent("content.intro1.4"));
        Thread.sleep(500);
        TextAnimation.gradualText(pr.getContent("content.intro2"));
        Thread.sleep(1000);
        System.out.println("");
        TextAnimation.gradualText(pr.getContent("content.intro3"));
        Thread.sleep(1000);
        TextAnimation.gradualText(pr.getContent("content.intro4"));
        Thread.sleep(1000);
        TextAnimation.gradualText(pr.getContent("content.intro5"));
        Thread.sleep(1000);
        System.out.println(" ");
        System.out.println(pr.getContent("content.intro.mode1"));
        Thread.sleep(500);
        System.out.println(pr.getContent("content.intro.mode2"));
        Thread.sleep(500);
        System.out.println(pr.getContent("content.intro.mode3"));
        Thread.sleep(2000);
        System.out.println(" ");
    }
    public static void gameStartMenu(){
        System.out.println(pr.getContent("content.sm.msg1"));
        System.out.println(pr.getContent("content.sm.msg1.deco0"));
        System.out.println(pr.getContent("content.sm.msg1.mode1"));
        System.out.println(pr.getContent("content.sm.msg1.mode2"));
        System.out.println(pr.getContent("content.sm.msg1.mode3"));
        System.out.println(pr.getContent("content.sm.msg1.deco0"));

        Boolean isValidChoice;
        do {
            System.out.print(pr.getContent("content.sm.msg2"));
            switch (ScannerTools.readLine()) {
                case "1":
                    playAgain = false;
                    isValidChoice=true;
                    do {
                        new ChallengerMode().run();
                        GameCommonContent.gameEndMenu();
                    } while (playAgain);
                    break;
                case "2":
                    playAgain = false;
                    isValidChoice=true;
                    do {
                        new DefenderMode().run();
                        GameCommonContent.gameEndMenu();
                    } while (playAgain);
                    break;
                case "3":
                    playAgain = false;
                    isValidChoice=true;
                    do {
                        new DuelMode().run();
                        GameCommonContent.gameEndMenu();
                    } while (playAgain);
                    break;
                default:
                    isValidChoice=false;
                    System.out.println("");
                    System.out.println(pr.getContent("content.sm.msg3.error"));
            }
        } while (!isValidChoice);
    }
    public static void gameEndMenu(){
        System.out.println(pr.getContent("content.em.deco0"));
        System.out.println(pr.getContent("content.em.msg1.mode1"));
        System.out.println(pr.getContent("content.em.msg1.mode2"));
        System.out.println(pr.getContent("content.em.msg1.mode3"));
        System.out.println(pr.getContent("content.em.deco1"));

        Boolean isValidChoice;
        do {
            System.out.print(pr.getContent("content.em.msg2"));
            switch (ScannerTools.readLine()) {
                case "1":
                    isValidChoice=true;
                    System.out.println(pr.getContent("content.em.msg4.mode1"));
                    playAgain = true;
                    break;
                case "2":
                    isValidChoice=true;
                    System.out.println(pr.getContent("content.em.msg4.mode2"));
                    playAgain = false;
                    gameStartMenu();
                    break;
                case "3":
                    isValidChoice=true;
                    System.out.println(pr.getContent("content.em.msg4.mode3"));
                    playAgain = false;
                    System.exit(0);
                    break;
                default:
                    isValidChoice=false;
                    System.out.println();
                    System.err.println(pr.getContent("content.em.msg4.error"));
                    break;
            }
        } while (!isValidChoice);
    }
}
