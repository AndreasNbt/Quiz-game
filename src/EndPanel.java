import javax.swing.*;
import java.awt.*;
import java.util.*;

public class EndPanel extends JPanel {


    public EndPanel(JFrame frame, JPanel mainPanel, CardLayout cardLayout, JLabel title, JLabel results, ArrayList<Player> players)  {


        setLayout(new GridBagLayout());

        title.setText("Thanks for playing Buzz! See you later!");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JPanel score_results = new JPanel();
        score_results.setLayout(new BoxLayout(score_results, BoxLayout.Y_AXIS));

        JLabel results_player1 = new JLabel();
        results_player1.setText(players.get(0).getName() + ", you finished with a score of " + players.get(0).getCurrentScore() +" points !");


        HighScoreFiles finalScore= new HighScoreFiles();
        finalScore.AddScore(players.get(0).getName(),players.get(0).getCurrentScore());

        score_results.add(results_player1);

        if (players.size() == 2) {
            JLabel results_player2 = new JLabel();
            results_player2.setText(players.get(1).getName() + ", you finished of a score of " + players.get(1).getCurrentScore() + " points !");
            score_results.add(results_player2);
            finalScore.AddScore(players.get(1).getName(),players.get(1).getCurrentScore());
        }

        add(score_results,gbc);
        JPanel highScores;
        highScores=finalScore.getHighScores();
        add(highScores,gbc);

        gbc.anchor = GridBagConstraints.SOUTH;

        JPanel buttons = new JPanel();
        JButton back_to_main_menu = new JButton("Back to main menu");
        back_to_main_menu.addActionListener(e -> cardLayout.show(mainPanel,"Menu"));

        buttons.add(back_to_main_menu);

        JButton quit = new JButton("Quit");
        quit.addActionListener(e -> System.exit(0));

        buttons.add(quit);

        add(buttons,gbc);


        mainPanel.add("End",this);

    }
}
