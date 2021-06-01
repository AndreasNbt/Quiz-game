/**
 * RightAnswer class also inherits from the RoundTypes.Round class and implements
 * one of the round types that the game supports.This class determines
 * what question is going to be displayed anb adds 1000 points if the
 * user gives the right answer.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */


public class RightAnswer extends Round{

    /**
     * Prints a message and sets the Player and QnA objects.
     * @param qna a QnA class object.
     */

    public RightAnswer(QnA qna) {
        this.qna = qna;
    }


    /**
     * Checks if the answer is correct and adds 1000 points to the player's sum if it is.
     * @param player the player whose score gets updated.
     * @param answer the users answer on the question.
     */
    @Override
    public void DetermineScore(Player player,String answer) {
        if (AnswerIsCorrect(answer, qna)) {
            player.setCurrentScore(player.getCurrentScore() + 1000);
        }
    }




}
