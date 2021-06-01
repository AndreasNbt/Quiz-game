
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class contains a list of all the Questions.
 * The questions are stored in seperate .txt files depending on their category.
 * It also contains functions that determine each question that the player will have to answer
 * and present all the possible answers to him randomized.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */

public class QnA {
    private final ArrayList<Question> list;
    private final ArrayList<imgQuestion> imglist;
    private Question question;


    /**
     * QnA constructor reads the different text files that contain the questions
     * and via ImportQuests() function stocks each of them into an arraylist
     * that holds them all.
     *
     * @throws FileNotFoundException in case a file is not found.
     */

    public QnA() throws FileNotFoundException {
        list = new ArrayList<>();
        imglist = new ArrayList<>();

        File File1=new File("Questions\\SportQuestions.txt");
        Scanner scan=new Scanner(File1);
        ImportQuests(scan,"Sports");

        File File2=new File("Questions\\HistoryQuestions.txt");
        scan=new Scanner(File2);
        ImportQuests(scan,"History");

        File File3=new File("Questions\\CinemaQuestions.txt");
        scan=new Scanner(File3);
        ImportQuests(scan,"Cinema");

        File File4=new File("Questions\\MusicQuestions.txt");
        scan=new Scanner(File4);
        ImportQuests(scan,"Music");

        File File5=new File("Questions\\ScienceQuestions.txt");
        scan=new Scanner(File5);
        ImportQuests(scan,"Science");

        File File6=new File("Questions\\GeographyQuestions.txt");
        scan=new Scanner(File6);
        ImportQuests(scan,"Geography");

        File File7=new File("Questions\\imageQuestions");
        scan=new Scanner(File7);
        ImportImageQuests(scan);
    }


    /**
     * Reads all the content of the file that gets passed and creates
     * a Question object which saves the question ,the possible answers ,
     * the right answer and the category of the question and finally stocks
     * its into an arraylist.
     *
     * @param data is the path of the file
     * @param category sets the category of the question.
     */
    private void ImportQuests(Scanner data,String category){
        while(data.hasNext()){
            Question quest=new Question(data);
            quest.setCategory(category);
            list.add(quest);
        }

    }

    /**
     * Reads all the content of the file that gets passed and creates
     * an imgQuestion object which saves the question ,the possible answers ,
     * the right answer, the category and the icon of the question and finally stocks
     * its into an arraylist.
     * @param data is the path of the file
     */
    private void ImportImageQuests(Scanner data) {
        int i=1;
        while (data.hasNext()){
            imgQuestion quest = new imgQuestion(data);
            imglist.add(quest);

        }
    }

    /**
     * First, determines if the question will be with or without an image.
     * Then chooses a random question from the appropriate list ,sends it to be displayed
     * and then removes this specific question from the list so it cannot be chosen again.
     */
    public void DetermineQuestion() {
        Random rand = new Random();

        int randQuest = rand.nextInt(2);

        switch (randQuest) {
            case 0:
                randQuest = rand.nextInt(list.size());
                System.out.println("randQuest");
                question = list.get(randQuest);
                list.remove(randQuest);
                break;
            case 1:
                randQuest = rand.nextInt(imglist.size());
                System.out.println("THS MANAS SOU");
                question = imglist.get(randQuest);
                imglist.remove(randQuest);
                break;
        }
    }

    /**
     * @return the current question.
     */
    public Question getQuestion() {
        return question;
    }



}
