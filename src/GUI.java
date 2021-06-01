import javax.swing.*;
import java.awt.*;


/**
 * The type Gui.
 */
public class GUI extends JFrame {


    MenuBar options_menu;
    JPanel mainPanel;
    CardLayout cardLayout;
    JPanel menuPanel;
    JPanel gamePanel;
    JPanel titlePanel;
    JPanel resultsPanel;


    /**
     * Instantiates a new Gui.
     * First, the frame gets initialized and two panels are added to it, one to the north and one to the south of the BorderLayout.
     * In the center, a mainPanel gets created which is set to cardLayout.
     * CardLayout will allow switching panels depending on the player's actions.
     * Then, gamePanel and menuPanel are created, followed by the MenuBar in the top-left and the menuPanel gets shown.
     */
    public GUI()
    {
        Globals gl = new Globals(6, 5);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Buzz");
        setSize(1080, 720);

        titlePanel = new JPanel();
        titlePanel.setBackground(Color.MAGENTA);
        JLabel title = new JLabel("Welcome to Buzz!");
        title.setFont(new Font("Times Roman",Font.ITALIC,20));
        titlePanel.add(title);
        add(titlePanel,BorderLayout.NORTH);

        resultsPanel = new JPanel();
        resultsPanel.setBackground(Color.MAGENTA);
        JLabel results = new JLabel("");
        results.setFont(new Font("Times Roman",Font.BOLD,15));
        resultsPanel.add(results);
        add(resultsPanel,BorderLayout.SOUTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel();

        mainPanel.setLayout(cardLayout);

        GamePanel gamePanel = new GamePanel(mainPanel);
        new MenuPanel(this,gl,mainPanel,cardLayout,gamePanel,title,results);



        add(mainPanel,BorderLayout.CENTER);

        options_menu = new MenuBar(this,mainPanel,cardLayout,gamePanel,title,results);
        cardLayout.show(mainPanel,"Menu");


        setVisible(true);

   }
}


