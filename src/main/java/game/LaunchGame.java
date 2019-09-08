package main.java.game;

import main.java.utils.PropertiesReader;
import main.java.utils.ScannerTools;
import main.java.utils.TextAnimation;

public class LaunchGame {
 static PropertiesReader pr = new PropertiesReader();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*** from Main class LaunchGame *** ");
        start();

        System.out.println("*** from Lauching ChallengerMode *** ");
        /*ChallengerMode cmGame = new ChallengerMode();
        System.out.println(cmGame.generateSecretNum());*/
 /*       System.err.println("Tentative : "+cmGame.getTentativeNum());
        System.out.println(cmGame.getMinArr());
        System.out.println(cmGame.getMaxArr());
        cmGame.adjustMinMax("-==+");
        System.out.println("updatedMin : "+cmGame.getMinArr());
        System.out.println("updatedMax : "+cmGame.getMaxArr());
        System.out.println("Number : "+cmGame.getSecretNum());
        System.out.println(cmGame.generateSecretNum());
        System.err.println("Tentative : "+cmGame.getTentativeNum());
        System.out.println("Number : "+cmGame.getSecretNum());*/

    }

    public static void start() throws InterruptedException {
        TextAnimation.gradualText(pr.getContent("content.intro1"));
        TextAnimation.gradualText(pr.getContent("content.intro2"));
        System.out.println("");
        TextAnimation.gradualText(pr.getContent("content.intro3"));
        TextAnimation.gradualText(pr.getContent("content.intro4"));
        TextAnimation.gradualText(pr.getContent("content.intro5"));
        System.out.println("");
        System.out.println(pr.getContent("content.intro.mode1"));
        System.out.println(pr.getContent("content.intro.mode2"));
        System.out.println(pr.getContent("content.intro.mode3"));
        System.out.println("");
        System.out.println(pr.getContent("content.msg1"));
        System.out.println(pr.getContent("content.msg1.deco0"));
        System.out.println(pr.getContent("content.msg1.mode1"));
        System.out.println(pr.getContent("content.msg1.mode2"));
        System.out.println(pr.getContent("content.msg1.mode3"));
        System.out.println(pr.getContent("content.msg1.deco0"));



        System.out.print("Human> ");
        switch(ScannerTools.readLine()){
            case "1":
                System.out.println("Choix n°1 : Mode challenger");
                ChallengerMode cmGame = new ChallengerMode();
                while(!cmGame.getNumFound() && !cmGame.getReachMaxAttempts() && cmGame.getPlayAgain()) {
                    System.out.print("Enigma> Je propose le code ");
                    System.out.println(cmGame.generateSecretNum());
                    System.out.println("Enigma> Quel est votre réponse ?");
                    System.out.println(" *** Tentative n°" + cmGame.getAttemptsNum() + " sur " + pr.getProp("settings.nbTries") + " ***");
                    System.out.print("Human > ");
                    if (cmGame.getAttemptsNum() == Integer.parseInt(pr.getProp("settings.nbTries"))) {
                        cmGame.setReachMaxAttempts(true);
                    }
                    String humanAnswer = ScannerTools.readLine();
                    cmGame.checkHumanAnswer(humanAnswer);
                    if (!cmGame.getNumFound()) {
                        cmGame.adjustMinMax(humanAnswer);
                    } else {
                        System.out.println("La combinaison étais donc "+cmGame.getSecretNum()+" (trouvé en "+cmGame.getAttemptsNum()+" tentatives)");
                    }
                }
                break;
            case"2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("3");
                break;
            default:
                //Todo : log4j
                System.err.println("Vous devez entrer un choix parmis ceux proposés (chiffre : 1, 2 ou 3)");
        };
        System.out.println("******************    Menu     ********************************");
        System.out.println("1 - Rejouer une partie en "+"NomDuModeEnCours"+" ? (taper '1')");
        System.out.println("2 - Choisir un autre mode de jeu ?                 (entrer '2')");
        System.out.println("3 - Quitter l'application ?                        (entrer '3')");
        System.out.println("***************************************************************");
        System.out.println(" ");
        System.out.print("Human > ");
        String choice = ScannerTools.readLine();
    }
}