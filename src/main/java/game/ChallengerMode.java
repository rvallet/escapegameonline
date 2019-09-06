package main.java.game;
import main.java.utils.PropertiesReader;
import main.java.utils.RanChoice;

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
    private int tentativeNum=0;
    private int min=0;
    private int max=9;

    /* Tools :  PropertiesReader */
    PropertiesReader pr = new PropertiesReader();

    /* Class constructor */
    public ChallengerMode(int nbDigit, int nbTries, Boolean devMode) {
        this.nbDigit = nbDigit;
        this.nbTries = nbTries;
        this.devMode = devMode;
    }

    public String generateSecretNum () {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.nbDigit; i++){
            sb.append(RanChoice.ranChoice(this.min, this.max));
        }
        setSecretNum(sb.toString());
        setTentativeNum(getTentativeNum()+1);
    return sb.toString();
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
}
