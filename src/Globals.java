/**
 * Globals class holds the number of rounds the game is
 * going to last and the number of questions each round will have.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */


public class Globals {
    private  int numberOfRounds;
    private  int numberOfQuestions;

    /**
     * Globals constructor sets the numberOfRounds and the numberOfQuestions variables.
     * @param numOfRounds Sets it equal to numberOfRounds variable.
     * @param numOfQuestions Sets it equal to numberOfQuestions variable.
     */
    Globals(int numOfRounds, int numOfQuestions) {
        numberOfRounds = numOfRounds;
        numberOfQuestions = numOfQuestions;
    }

    /**
     * @return the value of numberOfRounds variable.
     */
    public int getNumberOfRounds() {
        return numberOfRounds;
    }
    /**
     * @return the value of numberOfQuestions variable.
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * @param numberOfRounds Sets its value to numberOfRounds variable.
     */
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
    /**
     * @param numberOfQuestions Sets its value to numberOfQuestions variable.
     */
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}


