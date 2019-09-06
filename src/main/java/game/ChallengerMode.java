package main.java.game;
import main.java.utils.PropertiesReader;
import main.java.utils.RanChoice;

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
    private String secretNum;
    private int tentativeNum;
/*    private int min=0;
    private int max=9;*/
    private List<Integer> minArr=new ArrayList<>();
    private List<Integer> maxArr=new ArrayList<>();

    /* Tools :  PropertiesReader */
    static PropertiesReader pr = new PropertiesReader();

    /* Class constructor */
    public ChallengerMode() {
        this.nbDigit = pr.getIntProp("settings.nbDigit");
        this.nbTries = pr.getIntProp("settings.nbTries");
        this.devMode = pr.getBoolProp("settings.devMode");
        this.tentativeNum=0;
        for (int i=0; i<pr.getIntProp("settings.nbDigit"); i++) {
            this.minArr.add(0);
            this.maxArr.add(9);
        }
    }

    public String generateSecretNum () {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.nbDigit; i++){
            sb.append(RanChoice.ranChoice(this.minArr.get(i), this.maxArr.get(i)));
        }
        setSecretNum(sb.toString());
        setTentativeNum(getTentativeNum()+1);
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

    /* Getter and Setter */
    public String getSecretNum() {
        return secretNum;
    }

    public void setSecretNum(String secretNum) {
        this.secretNum = secretNum;
    }

    public int getTentativeNum() {
        return tentativeNum;
    }

    public void setTentativeNum(int tentativeNum) {
        this.tentativeNum = tentativeNum;
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
}
