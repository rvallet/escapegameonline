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

    /* Game settings variable */
    private int nbDigit;
    private int nbTries;
    private Boolean devMode;

    /* Class variable */
    private String name;
    private String secretNum;
    private int attemptsNum;
    private List<Integer> minArr=new ArrayList<>();
    private List<Integer> maxArr=new ArrayList<>();
    private Boolean numFound;
    private Boolean reachMaxAttempts;
    private Boolean playAgain;

    /* Tools :  PropertiesReader */
    static PropertiesReader pr = new PropertiesReader();

    /* Class constructor */
    public ChallengerMode() {
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

    public String generateSecretNum () {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.nbDigit; i++){
            sb.append(RanChoice.ranChoice(this.minArr.get(i), this.maxArr.get(i)));
        }
        setSecretNum(sb.toString());
        setAttemptsNum(getAttemptsNum()+1);
    return sb.toString();
    }

    public void adjustMinMax (String userInput) {
        for (int i=0; i<userInput.length(); i++) {
            char temp = userInput.charAt(i);
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
    }

    /* Getter and Setter */
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
