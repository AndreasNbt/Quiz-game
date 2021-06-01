import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains all parts of a question:
 * the question itself ,the answer of it ,all the possible
 * answers and the category and methods to access them.
 *
 * @author Andreas Nalmpantis
 * @author Constantinos Chondrorrizos
 * @version Final
 */

public class Question {
    protected final String question;
    protected final String answer;
    protected final ArrayList<String> possibleAnswers;
    protected String category;

    /**
     * This constructor is reading all the characteristics of a question
     * and saves them into variables.
     * @param data is the scanner that's reading from inside a file.
     */
    public Question(Scanner data){
        possibleAnswers= new ArrayList<>();
        this.question=data.nextLine();
        for (int i=0;i<4;i++){
            possibleAnswers.add(data.nextLine());
        }
        this.answer=data.nextLine();
     }


    /**
     * @return the question.
     */
     public String GetQuestion(){
        return this.question;
    }

    /**
     * @return The answer of the question("a","b","c","d").
     */
     public String GetAnswer(){
        return this.answer;
    }

    /**
     * @return An arraylist with all the possible answers.
     */
     public ArrayList<String> GetPossibleAnswers() {
        return possibleAnswers;
    }

    /**
     * @return the category of the question.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category Sets the  category.
     */
    public void setCategory(String category) {
        this.category = category;
    }




}

