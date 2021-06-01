import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GuiGameLogic {

    JFrame frame;
    JLabel title;
    JLabel results;
    ArrayList<Player> players;
    Globals gl;
    JPanel mainPanel;
    CardLayout cardLayout;
    GamePanel gamePanel;
    PanelHandling panelHandling;
    private long startTime;
    private RoundTypes type;
    private final QnA qna;
    private int numOfRounds;
    private int numOfQuestions;
    private boolean player1_answered;
    private boolean player2_answered;

    enum RoundTypes {
        RightAnswer,
        Bet,
        FastAnswer,
        Stop_the_clock,
        Thermometer
    }


    public GuiGameLogic(JFrame frame, ArrayList<Player> playerArrayList, Globals gl, JPanel mainPanel, CardLayout cardLayout, GamePanel gamePanel, JLabel title, JLabel results) throws FileNotFoundException {
        this.frame = frame;
        this.players = playerArrayList;
        this.gl = gl;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        this.gamePanel = gamePanel;

        this.title = title;
        this.results = results;
        this.qna = new QnA();

        numOfRounds = 0;
        numOfQuestions = 0;
        player1_answered=false;
        player2_answered=false;
        panelHandling=new PanelHandling(gamePanel,qna,players,results);

        startGame();
    }

    private void startGame() {
        title.setText("Game will begin soon!");
        panelHandling.SetResultPanel();
        addKeyListeners();
        nextRound();
    }

    private void DetermineRoundType() {
        int randTemp;
        Random rand = new Random();
        if (players.size() == 1)
            randTemp = rand.nextInt(3);
        else
            randTemp = rand.nextInt(5);

        switch (randTemp) {
            case 0:
                type = RoundTypes.RightAnswer;
                break;
            case 1:
                type = RoundTypes.Bet;
                break;
            case 2:
                type = RoundTypes.Stop_the_clock;
                break;
            case 3:
                type = RoundTypes.FastAnswer;
                break;
            case 4:
                type = RoundTypes.Thermometer;
        }

        //type = RoundTypes.Thermometer;
    }




    private void addKeyListeners() {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                switch (Character.toUpperCase(c)) {
                    case 'A':

                        if (!player1_answered) {
                            DetermineScore(players.get(0), gamePanel.getAnswer1().getText());
                            player1_answered=true;
                        }

                        if (players.size()==2){
                            if (player2_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }else {
                            player1_answered = false;
                            nextQuestion();
                        }
                            break;
                    case 'B':

                        if (!player1_answered) {
                            DetermineScore(players.get(0), gamePanel.getAnswer2().getText());
                            player1_answered=true;
                        }

                        if (players.size()==2){
                            if (player2_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }else {
                            player1_answered = false;
                            nextQuestion();
                        }

                        break;
                    case 'C':

                        if (!player1_answered) {
                            DetermineScore(players.get(0), gamePanel.getAnswer3().getText());
                            player1_answered=true;
                        }

                        if (players.size()==2){
                            if (player2_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }else {
                            player1_answered = false;
                            nextQuestion();
                        }
                            break;
                    case 'D':

                        if (!player1_answered) {
                            DetermineScore(players.get(0), gamePanel.getAnswer4().getText());
                            player1_answered=true;
                        }

                        if (players.size()==2){
                            if (player2_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }else {
                            player1_answered = false;
                            nextQuestion();
                        }

                        break;
                    case '1':
                        if (players.size() == 2) {

                            if (!player2_answered) {
                                DetermineScore(players.get(1), gamePanel.getAnswer1().getText());
                                player2_answered=true;
                            }

                            if (player1_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }
                        break;
                    case '2':
                        if (players.size() == 2) {

                            if (!player2_answered) {
                                DetermineScore(players.get(1), gamePanel.getAnswer2().getText());
                                player2_answered=true;
                            }

                            if (player1_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }
                        }
                        break;
                    case '3':

                        if (players.size() == 2) {

                            if (!player2_answered) {
                                DetermineScore(players.get(1), gamePanel.getAnswer3().getText());
                                player2_answered=true;
                            }

                            if (player1_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }

                        }
                        break;
                    case '4':
                        if (players.size() == 2) {

                            if (!player2_answered) {
                                DetermineScore(players.get(1), gamePanel.getAnswer4().getText());
                                player2_answered=true;
                            }

                            if (player1_answered){
                                player2_answered=false;
                                player1_answered=false;
                                nextQuestion();
                            }

                        }
                        break;
                   default:
                       //setPanel();
                    }
            }
        });
    }

    private void DetermineScore(Player player, String Answer){

        if (type==RoundTypes.RightAnswer){
            RightAnswer round=new RightAnswer(qna);
            round.DetermineScore(player,Answer);

        }else if (type==RoundTypes.Bet){

            Bet round=new Bet(qna);
            round.SetPointBet(player.getPointsBet());
            round.DetermineScore(player,Answer);

        }else if(type==RoundTypes.Stop_the_clock){

            long totalTime=System.currentTimeMillis()-startTime;
            Stop_the_clock round=new Stop_the_clock(qna);
            round.SetRemainingTime(totalTime);
            round.DetermineScore(player,Answer);

        }else if (type==RoundTypes.FastAnswer){

            FastAnswer round=new FastAnswer(qna);
            round.DetermineScore(player,Answer);

        }else if (type==RoundTypes.Thermometer){

            Thermometer round=new Thermometer(qna);
            round.DetermineScore(player,Answer);
        }
    }

    private void nextRound() {
        numOfRounds++;
        if (numOfRounds > gl.getNumberOfRounds()) {
            new EndPanel(frame, mainPanel, cardLayout, title, results, players);
            cardLayout.show(mainPanel, "End");
        } else {
            DetermineRoundType();
            if (type == RoundTypes.RightAnswer) {
                title.setText("Right Answer! Choose the correct answer and win 1000 points");
            } else if (type == RoundTypes.Bet) {
                title.setText("Bet! You bet your points. You answer correct, you win them. You answer wrong, you lose them. Good luck!");
            } else if (type == RoundTypes.Stop_the_clock) {
                title.setText("Stop The Clock! Answer as fast as you can...Good luck");
            } else if (type == RoundTypes.Thermometer) {
                title.setText("The player who answers 5 questions first earns 5000 points");
            } else {
                title.setText("The player who answers first and correctly earns 1000 points, the second one 500");
            }

            nextQuestion();
        }
    }

    private void nextQuestion() {

        panelHandling.SetResultPanel();
        gamePanel.setVisuable(false);

        if (type!=RoundTypes.Thermometer) {
            numOfQuestions++;
            boolean check;
            if (numOfQuestions > gl.getNumberOfQuestions()) {
                numOfQuestions = 0;
                nextRound();
            } else {
                if (numOfQuestions != 1) {
                    panelHandling.resetPanel();
                }
                qna.DetermineQuestion();
                gamePanel.resetTimer();
                gamePanel.SetDuration(20000);
                if (type == RoundTypes.Bet) {
                    String category = qna.getQuestion().getCategory();
                    for (Player player : players) {
                        do {
                            try {
                                String m = JOptionPane.showInputDialog(frame, "Bet! This question's category will be " + category + "\n" + "How many points will you bet " +
                                        player.getName() + " ? (250, 500, 750 or 1000)", 500);
                                switch (Integer.parseInt(m)) {
                                    case 250:
                                        gamePanel.resetTimer();
                                        player.setPointsBet(250);
                                        check = true;
                                        break;
                                    case 500:
                                        gamePanel.resetTimer();
                                        player.setPointsBet(500);
                                        check = true;
                                        break;
                                    case 750:
                                        gamePanel.resetTimer();
                                        player.setPointsBet(750);
                                        check = true;
                                        break;
                                    case 1000:
                                        gamePanel.resetTimer();
                                        player.setPointsBet(1000);
                                        check = true;
                                        break;
                                    default:
                                        check = false;
                                }

                            } catch (Exception e) {
                                check = false;
                            }
                        } while (!check);
                    }
                } else if (type == RoundTypes.Stop_the_clock) {
                    gamePanel.setVisuable(true);
                    gamePanel.resetTimer();
                    gamePanel.SetDuration(5000);
                    startTime = System.currentTimeMillis();
                } else if (type == RoundTypes.FastAnswer) {
                    FastAnswer.ResetFirst();
                }
            }
        }else{
            qna.DetermineQuestion();
            gamePanel.resetTimer();
            if (Thermometer.NextRound()) {
                Thermometer.ResetNextRound();
                for (Player player :players){
                    player.setThermometerAnswers(0);
                }
                nextRound();
            }
        }
        gamePanel.resetTimer();
        panelHandling.setPanel();
    }



}



