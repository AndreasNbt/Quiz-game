import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Panel handling.
 */
public class PanelHandling {


    GamePanel gamePanel;
    QnA qna;
    ArrayList<Player> players;
    JLabel results;
    JLabel title;

    /**
     * Instantiates a new PanelHandling object.
     * Initializes all of the class variables
     *
     * @param gamePanel the game panel
     * @param qna       the qna object
     * @param players   the players
     * @param results   the results label
     */
    public PanelHandling(GamePanel gamePanel,QnA qna ,ArrayList<Player> players,JLabel title, JLabel results){
        this.gamePanel=gamePanel;
        this.qna=qna;
        this.players=players;
        this.results=results;
        this.title = title;

    }

    /**
     * Resets the game panel.
     */
    public void resetPanel(){
        gamePanel.setQuestion(null);
        gamePanel.setAnswers(null,null,null,null);
    }

    /**
     * Sets the game panel.
     * Initializes the question label and the answer labels and also begins the timer.
     */
    public void setPanel() {
        ArrayList<String> possible_answers = qna.getQuestion().GetPossibleAnswers();
        Collections.shuffle(possible_answers);
        gamePanel.setAnswers(possible_answers.get(0), possible_answers.get(1), possible_answers.get(2), possible_answers.get(3));
        gamePanel.setQuestion(qna.getQuestion().GetQuestion());
        gamePanel.startTimer();
    }


    public void SetTitlePanel(String title){
        this.title.setText(title);
    }

    /**
     * Sets the result panel.
     * Each player's score gets shown alongside their name.
     */
    public void SetResultPanel(){
        if (players.size()==1){
            results.setText(players.get(0).getName() + " : " + players.get(0).getCurrentScore());
        }else
            results.setText(players.get(0).getName() + " : " + players.get(0).getCurrentScore() +
                    "                                                                  "+
                    players.get(1).getName() + " : " + players.get(1).getCurrentScore());
    }
}
