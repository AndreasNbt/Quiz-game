/**
 * The type Thermometer.
 */
public class Thermometer extends Round{

    private static boolean nextRound=false;

    /**
     * Instantiates a new Thermometer object.
     *
     * @param qnA the qna object
     */
    public Thermometer(QnA qnA){
        this.qna=qnA;
    }


    /**
     * Checks if the answer is correct and increases the number of questions that the player has answered correctly.
     * When that number reaches 5, then the player gets 5000 points and the game proceeds to the next round.
     * @param player the player whose score gets updated.
     * @param answer the users answer on the question.
     */
    @Override
    public void DetermineScore(Player player,String answer) {
        if (AnswerIsCorrect(answer,qna)){
            player.ThermometerAnswersPLusOne();
            if (player.getThermometerAnswers()==5){
                player.setCurrentScore(player.getCurrentScore() + 5000);
                nextRound=true;
            }
        }
    }

    /**
     * The nextRound boolean determines if the game should proceed to the next round.
     *
     * @return the boolean
     */
    public static boolean NextRound(){
        return nextRound;
    }

    /**
     * Resets "nextRound".
     */
    public static void ResetNextRound(){
        nextRound=false;
    }




}
