/**
 * The player class actually represents the characteristics
 * of a user inside the game.The class holds the name and
 * the score of the player and has functions to set or
 * return them both.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */


public class Player {
    private final String name;
    private int currentScore;
    private int pointsBet;
    private int thermometerAnswers;

    /**
     * Class constructor
     * When a player object is crated this function
     * sets his current score to 0 and assigns his name to the name variable.
     * @param name The player's name.
     */

    public Player(String name) {
        this.name = name;
        currentScore = 0;
        pointsBet = 0;
        thermometerAnswers = 0;
    }

    /**
     * @return the player name.
     */

    public String getName() {
        return name;
    }


    /**
     * @param score Sets the score
     */

    public void setCurrentScore(int score){
        currentScore = score;
    }

    /**
     * @return the current score.
     */

    public int getCurrentScore() {
        return currentScore;
    }

    public void setPointsBet(int pointsBet) {
        this.pointsBet = pointsBet;
    }

    public int getPointsBet() {
        return pointsBet;
    }

    public void ThermometerAnswersPLusOne(){
        thermometerAnswers++;
    }

    public int getThermometerAnswers(){
        return thermometerAnswers;
    }

    public void setThermometerAnswers(int thermometerAnswers){
        this.thermometerAnswers=thermometerAnswers;
    }
}
