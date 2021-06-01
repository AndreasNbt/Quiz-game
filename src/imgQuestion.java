import javax.swing.*;
import java.util.Scanner;

public class imgQuestion extends Question{

    ImageIcon icon;

    /**
     * This constructor is reading all the characteristics of a question
     * and saves them into variables.
     *
     * @param data is the scanner that's reading from inside a file.
     */
    public imgQuestion(Scanner data) {
        super(data);
        this.category = data.nextLine();
        this.icon = new ImageIcon(data.nextLine());
    }

    /**
     * This function returns the question's icon.
     * @return the question's icon.
     */
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
