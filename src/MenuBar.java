import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The type Menu bar.
 */
public class MenuBar {

    JFrame frame;
    Globals gl;
    JPanel mainPanel;
    CardLayout cardLayout;
    GamePanel gamePanel;
    JLabel title;
    JLabel results;

    /**
     * Class constructor.
     * Initializes all the variables and then calls CreateMenu()
     *
     * @param frame      the frame
     * @param mainPanel  the main panel
     * @param cardLayout the card layout
     */
    public MenuBar(JFrame frame, JPanel mainPanel, CardLayout cardLayout,GamePanel gamePanel, JLabel title, JLabel results)
    {
        this.frame = frame;
        this.gl = new Globals(6,5);
        this.mainPanel = mainPanel;
        this.gamePanel = gamePanel;
        this.cardLayout = cardLayout;
        this.title = title;
        this.results = results;
        CreateMenu();
    }

    /**
     * Create the MenuBar.
     * The MenuBar contains one Menu, named "Options" which also contains four MenuItems.
     * The help_item shows the player an info message which explains how the game is played.
     * The restart_item allows the player to restart the game.
     * The quit_to_main_menu_item allows the player to quit to the main menu.
     * The quit_to_desktop_item exits the game.
     */
    void CreateMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");


        JMenuItem help_item = new JMenuItem("Help");
        help_item.addActionListener(e -> {
            final String rules = ("There are 5 different round types in Buzz:" + "\n" + "@Right Answer" +"\n" + "@Bet" +"\n" +"@Fast Answer" +"\n" +"@Stop the clock" +"\n" +"@Thermometer" +"\n" +
                    "In Right answer, each player picks the answer he thinks is correct and if he gets it right, he wins 1000 points!"+ "\n" +
                    "In Bet, each player has to bet either 250,500,750 or 1000 points after being shown the type of the next question. If he then chooses the correct answer he wins those points otherwise he loses them( keep in mind that the score can be negative) !"+"\n"+
                    "In Fast Answer, the player who answers faster wins more points! 1000 points for the player who answers first and 500 for the rest ( if answered correctly of course) !"+"\n"+
                    "In Stop the clock, all players have to answer before the time runs out. Again the faster player wins more points! He gets one fifth times the time he has left in miliseconds."+"\n"+
                    "In Thermometer, the first player to answer 5 questions correctly wins 5000 points!");
            JOptionPane.showMessageDialog(frame,rules, "Game rules",JOptionPane.INFORMATION_MESSAGE);
        });
        JMenuItem restart_item = new JMenuItem("Restart");
        restart_item.addActionListener(e -> {
            String[] options12 = {"Confirm" , "Cancel"};
            int x = JOptionPane.showOptionDialog(frame, "Are you sure you want to restart the game?", "Buzz",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null, options12, options12[1]);
            if (x == 0) {
                cardLayout.show(mainPanel,"Menu");
                String players = JOptionPane.showInputDialog(frame,
                        "How many players will be playing? ", 1);
                int i;
                ArrayList<Player> playerArrayList = new ArrayList<>();
                for (i = 0; i < Integer.parseInt(players); i++) {
                    String name = JOptionPane.showInputDialog(frame, "Enter the name of player " + (i + 1));
                    playerArrayList.add(new Player(name));
                }
                cardLayout.show(mainPanel, "Game");
                try {
                    new GuiGameLogic(frame, playerArrayList, gl, mainPanel, cardLayout, gamePanel, title, results);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });



        JMenuItem quit_to_main_menu_item = new JMenuItem("Exit to main menu");
        quit_to_main_menu_item.addActionListener(e -> {
            String[] options1 = {"Confirm", "Cancel"};
            int x = JOptionPane.showOptionDialog(frame, "Are you sure you want to go back to the main menu?", "Buzz", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1[1]);
            if (x == 0) {
                cardLayout.show(mainPanel,"Menu");
            }
        });

        JMenuItem quit_to_desktop_item = new JMenuItem("Exit to desktop");
        quit_to_desktop_item.addActionListener(e -> {
            String[] options1 = {"Confirm", "Cancel"};
            int x = JOptionPane.showOptionDialog(frame, "Are you sure you want to exit the game?", "Buzz", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1[1]);
            if (x == 0) {
                System.exit(0);
            }
        });

        options.add(help_item);
        options.add(restart_item);
        options.add(quit_to_main_menu_item);
        options.add(quit_to_desktop_item);

        menuBar.add(options);
        frame.setJMenuBar(menuBar);
    }

}
