import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The type Menu panel.
 */
public class MenuPanel extends JPanel{

    JLabel title_label;
    JPanel menu_panel;
    JButton play_button;
    JButton options_button;
    JButton help_button;
    JButton quit_button;

    /**
     * Instantiates a new MenuPanel.
     * The MenuPanel gets added to the mainPanel and is shown to the player when he opens the game.
     * It contains a label named title_label which displays a welcome message to the player.
     * It also contains four buttons.
     * The play_button, which begins the game.
     * The options_button, with which the player can change the number of rounds and the number of questions per round.
     * The help_button, witch shows the player an info message which explains how the game is played.
     * The quit_button, with which the player exits the game.
     *
     * @param frame      the frame
     * @param gl         the Globals object
     * @param mainPanel  the main panel
     * @param cardLayout the card layout
     * @param gamePanel  the game panel
     * @param title      the title label
     * @param results    the results label
     */
    public MenuPanel(JFrame frame, Globals gl,JPanel mainPanel, CardLayout cardLayout,GamePanel gamePanel,JLabel title,JLabel results) {

        setBorder(new EmptyBorder(30,10,10,10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        title_label = new JLabel("What would you like to do?");
        title_label.setSize(new Dimension(200,200));
        title_label.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        add(title_label,gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        menu_panel = new JPanel(new GridBagLayout());

        play_button = new JButton("Play");
        play_button.setSize(new Dimension(200,200));
        play_button.setFont(new Font("TimesRoman",Font.BOLD,20));

        play_button.addActionListener(e -> {
            String players = JOptionPane.showInputDialog(frame,
                    "How many players will be playing? ", 1);
            int i;
            ArrayList<Player> playerArrayList = new ArrayList<>();
            for (i=0;i<Integer.parseInt(players);i++)
            {
                String name = JOptionPane.showInputDialog(frame,"Enter the name of player "+(i+1));
                playerArrayList.add(new Player(name));
            }
            cardLayout.show(mainPanel, "Game");
            try {
                new GuiGameLogic(frame,playerArrayList,gl,mainPanel,cardLayout,gamePanel,title,results);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        });

        menu_panel.add(play_button,gbc);

        options_button = new JButton("Options");
        options_button.setSize(new Dimension(200,200));
        options_button.setFont(new Font("TimesRoman",Font.BOLD,20));

        options_button.addActionListener(e -> {
            String rounds = JOptionPane.showInputDialog(frame,
                    "How many rounds per game do you want?", gl.getNumberOfRounds());
            if(rounds!=null) {
                gl.setNumberOfRounds(Integer.parseInt(rounds));
            }
            String questions = JOptionPane.showInputDialog(frame,
                    "How many questions per round do you want?", gl.getNumberOfQuestions());
            if (questions != null) {
                gl.setNumberOfQuestions(Integer.parseInt(questions));
        }});

        menu_panel.add(options_button,gbc);

        help_button = new JButton("Help");
        help_button.setSize(new Dimension(200,200));
        help_button.setFont(new Font("TimesRoman",Font.BOLD,20));

        help_button.addActionListener(e -> {
            final String rules = ("There are 5 different round types in Buzz:" + "\n" + "@Right Answer" +"\n" + "@Bet" +"\n" +"@Fast Answer" +"\n" +"@Stop the clock" +"\n" +"@Thermometer" +"\n" +
                    "In Right answer, each player picks the answer he thinks is correct and if he gets it right, he wins 1000 points!"+ "\n" +
                    "In Bet, each player has to bet either 250,500,750 or 1000 points after being shown the type of the next question. If he then chooses the correct answer he wins those points otherwise he loses them( keep in mind that the score can be negative) !"+"\n"+
                    "In Fast Answer, the player who answers faster wins more points! 1000 points for the player who answers first and 500 for the rest ( if answered correctly of course) !"+"\n"+
                    "In Stop the clock, all players have to answer before the time runs out. Again the faster player wins more points! He gets one fifth times the time he has left in miliseconds."+"\n"+
                    "In Thermometer, the first player to answer 5 questions correctly wins 5000 points!")+"\n"+
                    "To answer, the player uses the keys A,B,C,D on his keyboard to select the answer that he wants. If it is a 2 player game, then the second player uses the keys 1,2,3,4.";
            JOptionPane.showMessageDialog(frame,rules, "Game rules",JOptionPane.INFORMATION_MESSAGE);
        });

        menu_panel.add(help_button,gbc);

        quit_button = new JButton("Quit");
        quit_button.setSize(new Dimension(200,200));
        quit_button.setFont(new Font("TimesRoman",Font.BOLD,20));

        quit_button.addActionListener(e -> {
            String[] options1 = {"Confirm", "Cancel"};
            int x = JOptionPane.showOptionDialog(frame, "Are you sure you want to exit the game?", "Buzz", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1[1]);
            if (x == 0) {
                System.exit(0);
            }
        });

        menu_panel.add(quit_button,gbc);

        gbc.weighty = 1;
        add(menu_panel,gbc);

        mainPanel.add("Menu",this);


    }


}
