package main.java.game;

import main.java.utils.PropertiesReader;
import main.java.utils.RanChoice;
import main.java.utils.ScannerTools;
import org.apache.logging.log4j.core.util.JsonUtils;

/**
 * Search for an X number combination in Defender mode :
 * The player plays the role of defender. It defines a combination of X number randomly
 * The IA of the computer must find the combination based on the response made by the player to each proposal.
 * The number of tentavites is limited.
 * @author Rémy VALLET
 */
public class DefenderMode {
    //Todo: put commons variables in parent class and extends this one with a super() constructor

    /* Game settings variable */
    private int nbDigit; //The number of digit from properties settings
    private int nbTries; //The limited number of tries to found number
    private Boolean devMode; //The dev mode from properties settings (useless on this mode)

    /* Class variable */
    private String name; //The name of the game mode to display
    private String secretNum; //the secret number that human user attempts to find
    private int attemptsNum; //the actual number of tries
    private Boolean numFound; //is the number is found ?
    private Boolean reachMaxAttempts; //is the max attempts reached ?
    private Boolean playAgain; //is the human player want to play again this mode ?

    /* Tools */
    static PropertiesReader pr = new PropertiesReader(); //instance of PropertiesReader (easiest reading type : String, Int & Boolean)

    /* Class constructor */
    public DefenderMode() {
        //TODO: move name string to properties file
        this.name = "Defender Mode";
        this.nbDigit = pr.getIntProp("settings.nbDigit");
        this.nbTries = pr.getIntProp("settings.nbTries");
        this.devMode = pr.getBoolProp("settings.devMode");
        this.attemptsNum =0;
        this.numFound = false;
        this.reachMaxAttempts = false;
        this.playAgain = true;
        this.secretNum=generateSecretNum();
    }

    /* Class Methods */
    /**
     * Method to generate a random number of length corresponding to the properties file parameters
     * @author Rémy VALLET
     * @return String of the number the human player have to found
     */
    public String generateSecretNum() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.nbDigit; i++){
            sb.append(RanChoice.ranChoice(0,9));
        }
        setSecretNum(sb.toString());
        return sb.toString();
    }

    /**
     * A method to set victory if the human player answer is equal to the secret number
     *
     * @author Rémy VALLET
     * @param userInput The user input string of the number to found
     */
    public void checkHumanAnswer (String userInput){
        setAttemptsNum(getAttemptsNum()+1);
        if (userInput.equals(getSecretNum())) {
            this.setNumFound(true);
        }
    }

    /**
     * A method to display indications about the number submitted by the human player
     * with a string of operators '+,-,=' which evaluates every digit in the number
     * @author Rémy VALLET
     * @param userInput The user input string of the number to found
     * @return String of operators '+,-,=' which evaluates every digit
     */
    public String generateAnswer(String userInput) {
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < userInput.length(); i++) {
            int userDigit = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            int secretDigit = Integer.parseInt(String.valueOf(getSecretNum().charAt(i)));
            if (userDigit == secretDigit) {
                sbResult.append("=");
            } else if (userDigit > secretDigit) {
                sbResult.append("-");
            } else {
                sbResult.append("+");
            }
        }
        return sbResult.toString();
    }

    /* RUN */
    public void run() {
        DefenderMode dmGame = new DefenderMode();
        String devMode=pr.getContent("content.dev.1")+dmGame.getSecretNum()+" "+pr.getContent("content.dev.2");
        if (dmGame.getDevMode()) {System.out.println(devMode);}
        System.out.println(pr.getContent("content.dm.msg1"));

        while(!dmGame.getNumFound() && !dmGame.getReachMaxAttempts() && dmGame.getPlayAgain()) {
            System.out.println(pr.getContent("content.dm.msg2"));
            String humanAnswer;
            do{
                System.out.print(pr.getContent("content.dm.msg3"));
                humanAnswer = ScannerTools.readLine();
            } while (!ScannerTools.isValidAnswerDigits(humanAnswer));
            dmGame.checkHumanAnswer(humanAnswer);
            if (dmGame.getAttemptsNum() == Integer.parseInt(pr.getProp("settings.nbTries"))) {
                dmGame.setReachMaxAttempts(true);
            }
            if (!dmGame.getNumFound()){
                if (!dmGame.getReachMaxAttempts()) {
                    System.out.println(pr.getContent("content.dm.msg4.1") + dmGame.getAttemptsNum() + " "+pr.getContent("content.dm.msg4.2") + pr.getProp("settings.nbTries") + " " + pr.getContent("content.dm.msg4.3"));
                    System.out.println(pr.getContent("content.dm.msg5") + dmGame.generateAnswer(humanAnswer));
                } else {
                    System.out.println(pr.getContent("content.dm.msg6")+dmGame.getSecretNum());
                }
            } else {
                System.out.println(pr.getContent("content.dm.msg7")+dmGame.getSecretNum());
            }
        }
    }

    /* Getters and Setters */
    //Todo: remove unused setters

    public int getNbDigit() {
        return nbDigit;
    }

    public void setNbDigit(int nbDigit) {
        this.nbDigit = nbDigit;
    }

    public int getNbTries() {
        return nbTries;
    }

    public void setNbTries(int nbTries) {
        this.nbTries = nbTries;
    }

    public Boolean getDevMode() {
        return devMode;
    }

    public void setDevMode(Boolean devMode) {
        this.devMode = devMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
