
/**
 * Round is an abstract class that implements the base logic of each round.
 * It will get inherited by every round type class (RightAnswer,Bet...)
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */

abstract class Round {

    protected QnA qna;

    public abstract void DetermineScore(Player player, String answer);

    /**
     * Checks if the player's answer is correct.
     *
     * @param Answer the users answer.
     * @param qna    the asked question
     * @return true if its correct ,false if its wrong.
     */
    protected boolean AnswerIsCorrect(String Answer, QnA qna) {

        if (qna.getQuestion().GetAnswer().equals(Answer)) {
            System.out.println("Correct");
            return true;
        } else {
            System.out.println("False");
            return false;
        }


    }
}






