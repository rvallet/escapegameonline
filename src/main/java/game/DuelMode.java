package main.java.game;

import main.java.utils.ScannerTools;

/**
 * Search for an X number combination in Duel mode :
 * The player and the AI of the computer play in turn.
 * The first to find the secret combination of the other is the winner!
 * @author Rémy VALLET
 */
public class DuelMode extends EscapeGame{

    /* Class constructor */
    public DuelMode() {
        super("content.dual.name");
    }

    /* RUN */
    public void run(){
        EscapeGame dmGame = new DefenderMode();
        EscapeGame cmGame = new ChallengerMode();
        EscapeGame duelGame = new DuelMode();

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
}
