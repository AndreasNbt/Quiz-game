import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * The type Game panel.
 */
public class GamePanel extends JPanel{

    JLabel question_label;
    JLabel timer_label;
    JPanel answers_panel;
    JLabel answer1;
    JLabel answer2;
    JLabel answer3;
    JLabel answer4;

    private long startTime = -1;
    private final Timer timer;
    private long duration=20000;

    /**
     * Instantiates a new Game panel.
     * It is the panel in which the game will be played.
     * It contains a label for the question, a label for the timer and a panel which contains four labels for the possible answers.
     * When created, the GamePanel is added to the mainPanel and is shown when the game begins.
     *
     * @param mainPanel the main panel
     */
    public GamePanel(JPanel mainPanel){

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        question_label = new JLabel();
        question_label.setBackground(Color.BLACK);
        question_label.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        timer_label = new JLabel("00:20:000");
        add(timer_label,gbc);
        timer = new Timer(10, e -> setTimer());



        gbc.ipady = 200;
        add(question_label,gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        answers_panel = new JPanel(new GridLayout(4,2,50,10));
        answer1 = new JLabel();
        answer2 = new JLabel();
        answer3 = new JLabel();
        answer4 = new JLabel();

        JButton l1=new JButton("A / 1");
        l1.setFocusable(false);
        JButton l2=new JButton("B / 2");
        l2.setFocusable(false);
        JButton l3=new JButton("C / 3");
        l3.setFocusable(false);
        JButton l4=new JButton("D / 4");
        l4.setFocusable(false);

        gbc.ipady = 80;

        answers_panel.add(answer1,gbc);
        answers_panel.add(answer2,gbc);
        answers_panel.add(l1,gbc);
        answers_panel.add(l2,gbc);
        answers_panel.add(answer3,gbc);
        answers_panel.add(answer4,gbc);
        answers_panel.add(l3,gbc);
        answers_panel.add(l4,gbc);


        add(answers_panel,gbc);

        mainPanel.add("Game",this);
    }

    /**
     * Starts the timer.
     */
    public void startTimer(){
        timer.start();
    }

    /**
     * Sets the question label.
     *
     * @param question the question
     */
    public void setQuestion(String question)
    {
        question_label.setText(question);
    }


    /**
     * Sets the answer labels.
     *
     * @param answer1 the answer 1
     * @param answer2 the answer 2
     * @param answer3 the answer 3
     * @param answer4 the answer 4
     */
    public void setAnswers(String answer1,String answer2,String answer3,String answer4)
    {
        this.answer1.setText(answer1);
        this.answer2.setText(answer2);
        this.answer3.setText(answer3);
        this.answer4.setText(answer4);
    }

    /**
     * Gets answer 1.
     *
     * @return the answer 1
     */
    public JLabel getAnswer1() {
        return answer1;
    }

    /**
     * Gets answer 2.
     *
     * @return the answer 2
     */
    public JLabel getAnswer2() {
        return answer2;
    }

    /**
     * Gets answer 3.
     *
     * @return the answer 3
     */
    public JLabel getAnswer3() {
        return answer3;
    }

    /**
     * Gets answer 4.
     *
     * @return the answer 4
     */
    public JLabel getAnswer4() {
        return answer4;
    }


    /**
     * Initializes the timer.
     */
    private void setTimer() {
        if (startTime < 0) {
            startTime = System.currentTimeMillis();
        }
        long now = System.currentTimeMillis();
        long clockTime = now - startTime;
        if (clockTime >= duration) {
            clockTime = duration;
            timer.stop();
        }

        SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
        timer_label.setText(df.format(duration - clockTime));
    }

    /**
     * Reset timer.
     */
    public void resetTimer() {
            timer.stop();
            startTime = -1;
            timer_label.setText("00:20:000");
    }

    /**
     * Set duration.
     *
     * @param duration the duration
     */
    public void SetDuration(long duration){
        this.duration=duration;
    }

    public void setVisuable(boolean aFlag){
        timer_label.setVisible(aFlag);
    }

}
