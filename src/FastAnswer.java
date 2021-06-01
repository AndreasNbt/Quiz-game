/**
 * The type Fast answer.
 */
public class FastAnswer extends Round{
    private static boolean first=true;

    /**
     * Instantiates a new Fast answer.
     *
     * @param qnA the qna object which contains all the questions
     */
    public FastAnswer(QnA qnA){
        this.qna=qnA;
    }


    /**
     * Checks if the player's answer is correct.
     * Because "first" is already initialized at true, the first time that this function is called the faster player gets 1000 points.
     * "first" then is set to false, so that the player who answers second gets 500 points.
     * @param player the player whose score is getting updated
     * @param answer the player's answer on the question.
     */
    @Override
    public void DetermineScore(Player player,String answer) {
        if (AnswerIsCorrect(answer, qna)){
            if (first){
                player.setCurrentScore(player.getCurrentScore() + 1000);
                first=false;
            }else {
                player.setCurrentScore(player.getCurrentScore() + 500);
            }
        }
    }

    /**
     * Sets the "first" variable as true.
     */
    public static void ResetFirst(){
        first=true;
    }
}
