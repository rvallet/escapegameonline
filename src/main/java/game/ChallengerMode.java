package main.java.game;
import main.java.utils.PropertiesReader;
import main.java.utils.RanChoice;
import main.java.utils.ScannerTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Search for an X number combination in Challenger mode :
 * The AI of the computer plays the role of defender. It defines a combination of X number randomly
 * The player must find the combination based on the response made by the computer to each proposal.
 * The number of tentavites is limited.
 * @author Rémy VALLET
 */
public class ChallengerMode {
    //Todo: put commons variables in parent class and extends this one with a super() constructor

    /* Game settings variable */
    private int nbDigit; //The number of digit from properties settings
    private int nbTries; //The limited number of tries to found number
    private Boolean devMode; //The dev mode from properties settings (useless on this mode)

    /* Class variable */
    private String name; //The name of the game mode to display
    private String secretNum; //the secret number we attempts to found
    private int attemptsNum; //the actual number of tries
    private List<Integer> minArr=new ArrayList<>(); //the min array adjusted with the human player answer
    private List<Integer> maxArr=new ArrayList<>(); //the max array adjusted with the human player answer
    private Boolean numFound; //is the number is found ?
    private Boolean reachMaxAttempts; //is the max attempts reached ?
    private Boolean playAgain; //is the human player want to play again this mode ?

    /* Tools */
    static PropertiesReader pr = new PropertiesReader(); //instance of PropertiesReader (easiest reading type : String, Int & Boolean)

    /* Class constructor */
    public ChallengerMode() {
        //TODO: move name string to properties file
        this.name = "Challenger Mode";
        this.nbDigit = pr.getIntProp("settings.nbDigit");
        this.nbTries = pr.getIntProp("settings.nbTries");
        this.devMode = pr.getBoolProp("settings.devMode");
        this.attemptsNum =0;
        for (int i=0; i<pr.getIntProp("settings.nbDigit"); i++) {
            this.minArr.add(0);
            this.maxArr.add(9);
        }
        this.numFound = false;
        this.reachMaxAttempts = false;
        this.playAgain = true;
    }

    /* Class Methods */

    /**
     * Method to generate a random number in order to found the secret number
     * @author Rémy VALLET
     * @return String of the number to found
     */
    public String generateSecretNum () {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.nbDigit; i++){
            sb.append(RanChoice.ranChoice(this.minArr.get(i), this.maxArr.get(i)));
        }
        setSecretNum(sb.toString());
        setAttemptsNum(getAttemptsNum()+1);
    return sb.toString();
    }

    /**
     * Method to adjust the min and max Arrays with the human player answer
     * @author Rémy VALLET
     * @param userInput The string of operators '+,-,=' contained in the human player answer
     */
    public void adjustMinMax (String userInput) {
        for (int i=0; i<userInput.length(); i++) {
            char temp = userInput.charAt(i);
            //Todo : add logger if sign '+' or '-' out of range (arrays min/max) or secure this input
            switch (temp) {
                case '+':
                    this.minArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i)))+1);
                    break;
                case '-':
                    this.maxArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i)))-1);
                    break;
                case '=':
                    this.minArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i))));
                    this.maxArr.set(i, Integer.parseInt(String.valueOf(getSecretNum().charAt(i))));
                    break;
                default:
                    System.err.println("invalid input" + userInput);
            }
        }
    }

    /**
     * A method to set victory if the human player answer contains only '=' operator
     *
     * @author Rémy VALLET
     * @param userInput The string of operators '+,-,=' contained in the human player answer
     */
    public void checkHumanAnswer (String userInput){
        StringBuilder sbTemp = new StringBuilder();
        for (int i=0; i<pr.getIntProp("settings.nbDigit"); i++) {
            sbTemp.append("=");
        }
        if (userInput.equals(sbTemp.toString())) {
         this.setNumFound(true);
        }
    }

    /* RUN */
    public void run(){
        System.out.println(pr.getContent("content.cm.msg1"));
        ChallengerMode cmGame = new ChallengerMode();
        while(!cmGame.getNumFound() && !cmGame.getReachMaxAttempts() && cmGame.getPlayAgain()) {
            System.out.print(pr.getContent("content.cm.msg2"));
            System.out.println(cmGame.generateSecretNum());
            System.out.println(pr.getContent("content.cm.msg3"));
            System.out.println(pr.getContent("content.cm.msg4.1") + cmGame.getAttemptsNum() + " "+ pr.getContent("content.cm.msg4.2") + pr.getProp("settings.nbTries") + " "+pr.getContent("content.cm.msg4.3"));

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
                System.out.println(pr.getContent("content.cm.msg6.1")+cmGame.getSecretNum()+" "+pr.getContent("content.cm.msg6.2")+cmGame.getAttemptsNum()+" "+pr.getContent("content.cm.msg6.3"));
            }
        }
    }

    /* Getters and Setters */
    //Todo: remove unused setters
    public String getSecretNum() {
        return secretNum;
    }

    public void setSecretNum(String secretNum) {
        this.secretNum = secretNum;
    }

    public int getAttemptsNum() {
        return attemptsNum;
    }

    public void setAttemptsNum(int attemptsNum) {
        this.attemptsNum = attemptsNum;
    }

    public List<Integer> getMinArr() {
        return minArr;
    }

    public void setMinArr(List<Integer> minArr) {
        this.minArr = minArr;
    }

    public List<Integer> getMaxArr() {
        return maxArr;
    }

    public void setMaxArr(List<Integer> maxArr) {
        this.maxArr = maxArr;
    }
    public Boolean getNumFound() {
        return numFound;
    }

    public void setNumFound(Boolean numFound) {
        this.numFound = numFound;
    }

    public Boolean getReachMaxAttempts() {
        return reachMaxAttempts;
    }

    public void setReachMaxAttempts(Boolean reachMaxAttempts) {
        this.reachMaxAttempts = reachMaxAttempts;
    }

    public Boolean getPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(Boolean playAgain) {
        this.playAgain = playAgain;
    }
}