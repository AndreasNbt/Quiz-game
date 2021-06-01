/**
 * The type Stop the clock.
 */
public class Stop_the_clock extends Round{
    private long remainingTime;

    /**
     * Instantiates a new Stop the clock object.
     *
     * @param qna the qna object
     */
    public Stop_the_clock(QnA qna){
        this.qna= qna;
        this.remainingTime=0;
    }

    /**
     * Checks if the answer is correct and adds one fifth of the players remaining time in milliseconds to the player's score if it is.
     * @param player the player whose score gets updated.
     * @param answer the users answer on the question.
     */
    @Override
    public void DetermineScore(Player player,String answer) {
        if (AnswerIsCorrect(answer, qna)) {

            if (remainingTime != 0) {
                int totalPoints = (int) Math.round(remainingTime * 0.2);
                player.setCurrentScore(player.getCurrentScore() + totalPoints);
            }
        }
    }

    /**
     * Sets remaining time.
     *
     * @param time the time that gets assigned to remainingTime in milliseconds
     */
    public void SetRemainingTime(long time){
        remainingTime=time;

        if (remainingTime<5000)
            remainingTime=5000-remainingTime;
        else
            remainingTime=0;

    }

}
