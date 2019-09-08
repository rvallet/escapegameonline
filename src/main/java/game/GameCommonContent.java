package main.java.game;

import main.java.utils.PropertiesReader;
import main.java.utils.ScannerTools;
import main.java.utils.TextAnimation;

public class GameCommonContent {
    static PropertiesReader pr = new PropertiesReader();
    static Boolean playAgain = false;

    public static void gameIntroduction() throws InterruptedException {
        TextAnimation.gradualText(pr.getContent("content.intro1"));
        TextAnimation.gradualText(pr.getContent("content.intro2"));
        System.out.println("");
        TextAnimation.gradualText(pr.getContent("content.intro3"));
        TextAnimation.gradualText(pr.getContent("content.intro4"));
        TextAnimation.gradualText(pr.getContent("content.intro5"));
        System.out.println(" ");
        System.out.println(pr.getContent("content.intro.mode1"));
        System.out.println(pr.getContent("content.intro.mode2"));
        System.out.println(pr.getContent("content.intro.mode3"));
        System.out.println(" ");
    }
    public static void gameStartMenu(){
        System.out.println(pr.getContent("content.msg1"));
        System.out.println(pr.getContent("content.msg1.deco0"));
        System.out.println(pr.getContent("content.msg1.mode1"));
        System.out.println(pr.getContent("content.msg1.mode2"));
        System.out.println(pr.getContent("content.msg1.mode3"));
        System.out.println(pr.getContent("content.msg1.deco0"));

        System.out.print("Human> ");
        switch (ScannerTools.readLine()) {
            case "1":
                do {
                    new ChallengerMode().run();
                    GameCommonContent.gameEndMenu();
                } while (playAgain);
                break;
            case "2":
                playAgain=true;
                System.out.println("2");
                break;
            case "3":
                playAgain=true;
                System.out.println("3");
                break;
            default:
                //Todo : log4j
                System.err.println("Vous devez entrer un choix parmis ceux proposés (chiffre : 1, 2 ou 3)");
        }
    }
    public static void gameEndMenu(){
        System.out.println("*******************    Menu     ******************");
        System.out.println("1 - Rejouer une partie identique ?     (taper '1')");
        System.out.println("2 - Choisir un autre mode de jeu ?     (taper '2')");
        System.out.println("3 - Quitter l'application ?            (taper '3')");
        System.out.println("**************************************************");
        System.out.println(" ");
        System.out.print("Human > ");
        String choice = ScannerTools.readLine();
        switch (choice) {
            case "1":
                System.out.println("Choix n°1 : Nouvelle partie");
                playAgain=true;
                break;
            case "2":
                System.out.println("Choix n°2 : Retour au menu");
                playAgain=false;
                gameStartMenu();
                break;
            case "3":
                System.out.println("Choix n°3 : Quitter le programme");
                playAgain=false;
                break;
            default:
                System.out.println("Vous devez faire un choix parmis ceux proposés");
                break;
        }
    }
}
