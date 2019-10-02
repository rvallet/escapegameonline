package main.java.game;
import main.java.utils.RanChoice;
import main.java.utils.ScannerTools;

/**
 * Search for an X number combination in Challenger mode :
 * The AI of the computer plays the role of defender. It defines a combination of X number randomly
 * The player must find the combination based on the response made by the computer to each proposal.
 * The number of attempts is limited.
 * @author Rémy VALLET
 */
public class ChallengerMode extends EscapeGame {

    /* Class constructor */
    public ChallengerMode() {
        super("content.cm.name");
    }

    /* Class Methods */

    /**
     * Method to generate a random number in order to found the secret number
     *
     * @return String of the number to found
     * @author Rémy VALLET
     */
    public String generateSecretNum() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nbDigit; i++) {
            sb.append(RanChoice.ranChoice(this.minArr.get(i), this.maxArr.get(i)));
        }
        setSecretNum(sb.toString());
        setAttemptsNum(getAttemptsNum() + 1);
        return sb.toString();
    }

    /**
     * Method to adjust the min and max Arrays with the human player answer
     *
     * @param userInput The string of operators '+,-,=' contained in the human player answer
     * @author Rémy VALLET
     */
    public void adjustMinMax(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char temp = userInput.charAt(i);
            int tempDigit = Integer.parseInt(String.valueOf(getSecretNum().charAt(i)));
            switch (temp) {
                case '+':
                    if ((tempDigit + 1) <= 9 && (this.minArr.get(i) + 1) <= this.maxArr.get(i)) {
                        this.minArr.set(i, tempDigit + 1);
                    } else {
                        System.err.println(pr.getContent("content.cm.err1.1") + tempDigit + pr.getContent("content.cm.err1.2.1") + (i + 1) + pr.getContent("content.cm.err1.3"));
                        if (tempDigit + 1 <= 9) {
                            this.maxArr.set(i, tempDigit + 1);
                        }
                    }
                    break;
                case '-':
                    if ((tempDigit - 1) >= 0 && (this.maxArr.get(i) - 1) >= this.minArr.get(i)) {
                        this.maxArr.set(i, tempDigit - 1);
                    } else {
                        System.err.println(pr.getContent("content.cm.err1.1") + tempDigit + pr.getContent("content.cm.err1.2.2") + (i + 1) + pr.getContent("content.cm.err1.3"));
                        if (tempDigit - 1 >= 0) {
                            this.minArr.set(i, tempDigit - 1);
                        }
                    }
                    break;
                case '=':
                    this.minArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i))));
                    this.maxArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i))));
                    break;
                default:
                    System.err.println("invalid input : " + userInput);
            }
        }
    }

    /**
     * A method to set victory if the human player answer contains only '=' operator
     *
     * @param userInput The string of operators '+,-,=' contained in the human player answer
     * @author Rémy VALLET
     */
    public void checkHumanAnswer(String userInput) {
        StringBuilder sbTemp = new StringBuilder();
        for (int i = 0; i < pr.getIntProp("settings.nbDigit"); i++) {
            sbTemp.append("=");
        }
        if (userInput.equals(sbTemp.toString())) {
            this.setNumFound(true);
        }
    }

    /* RUN */
    public void run() {
        System.out.println(pr.getContent("content.cm.msg1"));
        EscapeGame cmGame = new ChallengerMode();
        while (!cmGame.getNumFound() && !cmGame.getReachMaxAttempts() && cmGame.getPlayAgain()) {
            System.out.print(pr.getContent("content.cm.msg2"));
            System.out.println(cmGame.generateSecretNum());
            System.out.println(pr.getContent("content.cm.msg3"));
            System.out.println(pr.getContent("content.cm.msg4.1") + cmGame.getAttemptsNum() + " " + pr.getContent("content.cm.msg4.2") + pr.getProp("settings.nbTries") + " " + pr.getContent("content.cm.msg4.3"));

            if (cmGame.getAttemptsNum() == Integer.parseInt(pr.getProp("settings.nbTries"))) {
                cmGame.setReachMaxAttempts(true);
            }
            String humanAnswer;
            do {
                System.out.print(pr.getContent("content.cm.msg5"));
                humanAnswer = ScannerTools.readLine();
            } while (!ScannerTools.isValidAnswerOperatorsSign(humanAnswer));
            cmGame.checkHumanAnswer(humanAnswer);
            if (!cmGame.getNumFound()) {
                cmGame.adjustMinMax(humanAnswer);
                if (cmGame.getReachMaxAttempts()) {
                    System.out.println(pr.getContent("content.cm.msg7"));
                }
            } else {
                System.out.println(pr.getContent("content.cm.msg6.1") + cmGame.getSecretNum() + " " + pr.getContent("content.cm.msg6.2") + cmGame.getAttemptsNum() + " " + pr.getContent("content.cm.msg6.3"));
            }
        }
    }
}