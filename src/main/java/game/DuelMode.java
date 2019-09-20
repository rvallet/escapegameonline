package main.java.game;

import main.java.utils.PropertiesReader;
import main.java.utils.ScannerTools;

/**
 * Search for an X number combination in Duel mode :
 * The player and the AI of the computer play in turn.
 * The first to find the secret combination of the other is the winnner!
 * @author Rémy VALLET
 */
public class DuelMode {

    /* Class variable */
    private String name; //The name of the game mode to display
    private Boolean playAgain; //is the human player want to play again this mode ?

    /* Tools */
    static PropertiesReader pr = new PropertiesReader(); //instance of PropertiesReader (easiest reading type : String, Int & Boolean)

    /* Class constructor */
    public DuelMode() {
        //TODO: move name string to properties file
        this.name = "Duel Mode";
        this.playAgain = true;
    }

    /* RUN */
    public void run(){
        DefenderMode dmGame = new DefenderMode();
        ChallengerMode cmGame = new ChallengerMode();
        DuelMode duelGame = new DuelMode();
        Boolean isWon = false;

        String devMode=pr.getContent("content.dev.1")+dmGame.getSecretNum()+" "+pr.getContent("content.dev.2");
        if (dmGame.getDevMode()) {System.out.println(devMode);}
        System.out.println(pr.getContent("content.duel.msg1"));
        System.out.println(pr.getContent("content.duel.msg2"));
        while(!cmGame.getNumFound() && !dmGame.getNumFound() && duelGame.getPlayAgain()) {
            System.out.println(pr.getContent("content.duel.msg3"));

            String dmHumanAnswer;
            do {
                System.out.print(pr.getContent("content.duel.msg4"));
                dmHumanAnswer = ScannerTools.readLine();
            } while (!ScannerTools.isValidAnswerDigits(dmHumanAnswer));
            dmGame.checkHumanAnswer(dmHumanAnswer);

            if (!dmGame.getNumFound()) {
                System.out.println(pr.getContent("content.duel.msg5") + dmGame.generateAnswer(dmHumanAnswer));
                System.out.print(pr.getContent("content.duel.msg6"));
                System.out.println(cmGame.generateSecretNum());
/*            }
        else if (!cmGame.getNumFound()){
            System.out.println(pr.getContent("content.cm.msg7"));*/
            } else if (dmGame.getNumFound() && !cmGame.getNumFound()) {
                System.out.println(pr.getContent("content.dm.msg7") + dmGame.getSecretNum());
            }
            String cmHumanAnswer;
            if (!dmGame.getNumFound()) {

                System.out.println(pr.getContent("content.duel.msg7"));
                do {
                    System.out.print(pr.getContent("content.cm.msg5"));
                    cmHumanAnswer = ScannerTools.readLine();
                } while (!ScannerTools.isValidAnswerOperatorsSign(cmHumanAnswer));
                cmGame.checkHumanAnswer(cmHumanAnswer);


            if (!cmGame.getNumFound()) {
                cmGame.adjustMinMax(cmHumanAnswer);
            } else if (!dmGame.getNumFound()) {
                System.out.println(pr.getContent("content.dm.msg6") + dmGame.getSecretNum());
                System.out.println(pr.getContent("content.cm.msg6.1") + cmGame.getSecretNum() + " " + pr.getContent("content.cm.msg6.2") + cmGame.getAttemptsNum() + " " + pr.getContent("content.cm.msg6.3"));
            }
        }
            if (!cmGame.getNumFound() && !dmGame.getNumFound())
        System.out.println(pr.getContent("content.duel.msg8.1")+cmGame.getAttemptsNum()+pr.getContent("content.duel.msg8.2"));
        }
    }
    /* Getters and Setters */
    //Todo: remove unused setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(Boolean playAgain) {
        this.playAgain = playAgain;
    }
}
