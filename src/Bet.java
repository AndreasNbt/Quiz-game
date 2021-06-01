
/**
 * This class implements the round type Bet.
 * The player is asked to bet points before each question and, depending on the answer, either wins or loses them.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */

public class Bet extends Round{

    private int pointsBet;

    /**
     * @param qna a QnA class object.
     */
    public Bet(QnA qna) {

        this.qna = qna;
    }

    /**
     * Checks if the player's answer is correct and either adds or subtracts the amount
     * of points he bet to his total.
     * @param player the player whose score is getting updated
     * @param answer the player's answer on the question.
     */
    @Override
    public void DetermineScore(Player player,String answer) {
        if (AnswerIsCorrect(answer, qna)) {
            player.setCurrentScore(player.getCurrentScore() + pointsBet);
        }else {
            player.setCurrentScore(player.getCurrentScore() - pointsBet);
        }
    }

    public void SetPointBet(int pointsBet){
        this.pointsBet=pointsBet;
    }






}