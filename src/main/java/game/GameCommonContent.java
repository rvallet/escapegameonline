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
                playAgain=false;
                do {
                    new ChallengerMode().run();
                    GameCommonContent.gameEndMenu();
                } while (playAgain);
                break;
            case "2":
                playAgain=false;
                do {
                    System.out.println("2");
                } while (playAgain);
                break;
            case "3":
                playAgain=false;
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
        int choice = ScannerTools.readInt(3);
        switch (choice) {
            case 1:
                System.out.println("*** Nouvelle partie ***");
                playAgain=true;
                break;
            case 2:
                System.out.println("*** Retour au menu ***");
                playAgain=false;
                gameStartMenu();
                break;
            case 3:
                System.out.println("*** Quitter le programme ***");
                playAgain=false;
                System.exit(0);
                break;
            default:
                System.out.println("Vous devez faire un choix parmis ceux proposés");
                break;
        }
    }
}
