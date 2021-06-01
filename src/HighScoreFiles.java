import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HighScoreFiles {
    private final String[] fileScores;
    private final String[] fileNames;

    public HighScoreFiles(){
        fileScores=new String[6];
        fileNames=new String[6];

    }

    public void AddScore(String playersName,int playersScore){
        Read(playersName,playersScore);
        Sort();
        Write();
        getHighScores();
    }

    private void Read(String playersName,int playersScore){
        try(BufferedReader in =new BufferedReader(new FileReader("scores.txt"));
            BufferedReader in1 =new BufferedReader(new FileReader("Names.txt"))) {
            String score,name;
            int i=0;
            while ((score = in.readLine()) != null && (name = in1.readLine()) != null ) {
                fileScores[i]=score;
                fileNames[i]=name;
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        fileScores[5]=String.valueOf(playersScore);
        fileNames[5]=playersName;
    }

    private void Write(){
        try(BufferedWriter out1 =new BufferedWriter(new FileWriter("HighScores.txt"));
            BufferedWriter out2 =new BufferedWriter(new FileWriter("scores.txt"));
            BufferedWriter out3 =new BufferedWriter(new FileWriter("Names.txt")))
        {

            for (int i=0;i<5;i++){
                out1.write(fileNames[i] + " : " +fileScores[i] + "\n");
                out2.write(fileScores[i] + "\n");
                out3.write(fileNames[i] + "\n");

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void Sort(){

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5-i; j++)
                if(Integer.parseInt(fileScores[j])<Integer.parseInt(fileScores[j+1])){
                    String temp = fileScores[j+1];
                    fileScores[j+1] = fileScores[j];
                    fileScores[j] = temp;

                    String temp2=fileNames[j+1];
                    fileNames[j+1] = fileNames[j];
                    fileNames[j] = temp2;

                }
    }

    public JPanel getHighScores(){
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(" High Scores "));
        try(BufferedReader in =new BufferedReader(new FileReader("HighScores.txt"))){

            String l;
            while ((l=in.readLine())!=null){
                JLabel label=new JLabel(l);
                label.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                panel.add(label);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return panel;
    }
}
