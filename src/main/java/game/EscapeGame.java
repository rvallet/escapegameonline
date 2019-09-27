package main.java.game;

import main.java.utils.PropertiesReader;
import java.util.ArrayList;
import java.util.List;

abstract class EscapeGame {
    /* Game settings variable */
    protected int nbDigit; //The number of digit from properties settings
    protected int nbTries; //The limited number of tries to found number
    protected Boolean devMode; //The dev mode from properties settings (useless on this mode)

    /* Class variable */
    protected String name; //The name of the game mode to display
    protected String secretNum; //the secret number we attempts to found
    protected int attemptsNum; //the actual number of tries
    protected List<Integer> minArr=new ArrayList<>(); //the min array adjusted with the human player answer
    protected List<Integer> maxArr=new ArrayList<>(); //the max array adjusted with the human player answer
    protected Boolean numFound; //is the number is found ?
    protected Boolean reachMaxAttempts; //is the max attempts reached ?
    protected Boolean playAgain; //is the human player want to play again this mode ?

    /* Tools */
    public PropertiesReader pr = new PropertiesReader(); //instance of PropertiesReader (easiest reading type : String, Int & Boolean)

    /* Class constructor */
    public EscapeGame(String name){
        this.setName(name);
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
    public String generateSecretNum (){return null;};
    public void adjustMinMax (String userInput){};
    public void checkHumanAnswer(String userInput){};
    public String generateAnswer(String userInput){return null;};
    public void run(){};

    /* Getters and Setters */
    //Todo: remove unused setters

    protected int getNbDigit() {
        return nbDigit;
    }

    protected void setNbDigit(int nbDigit) {
        this.nbDigit = nbDigit;
    }

    protected int getNbTries() {
        return nbTries;
    }

    protected void setNbTries(int nbTries) {
        this.nbTries = nbTries;
    }

    protected Boolean getDevMode() {
        return devMode;
    }

    protected void setDevMode(Boolean devMode) {
        this.devMode = devMode;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = pr.getContent(name);
    }

    protected String getSecretNum() {
        return secretNum;
    }

    protected void setSecretNum(String secretNum) {
        this.secretNum = secretNum;
    }

    protected int getAttemptsNum() {
        return attemptsNum;
    }

    protected void setAttemptsNum(int attemptsNum) {
        this.attemptsNum = attemptsNum;
    }

    protected List<Integer> getMinArr() {
        return minArr;
    }

    protected void setMinArr(List<Integer> minArr) {
        this.minArr = minArr;
    }

    protected List<Integer> getMaxArr() {
        return maxArr;
    }

    protected void setMaxArr(List<Integer> maxArr) {
        this.maxArr = maxArr;
    }

    protected Boolean getNumFound() {
        return numFound;
    }

    protected void setNumFound(Boolean numFound) {
        this.numFound = numFound;
    }

    protected Boolean getReachMaxAttempts() {
        return reachMaxAttempts;
    }

    protected void setReachMaxAttempts(Boolean reachMaxAttempts) {
        this.reachMaxAttempts = reachMaxAttempts;
    }

    protected Boolean getPlayAgain() {
        return playAgain;
    }

    protected void setPlayAgain(Boolean playAgain) {
        this.playAgain = playAgain;
    }

    public PropertiesReader getPr() {
        return pr;
    }

    public void setPr(PropertiesReader pr) {
        this.pr = pr;
    }
}
