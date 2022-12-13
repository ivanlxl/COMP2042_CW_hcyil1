package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Handles loading the high scores and saving the user's username and scores to the high score file.
 */
public class HighScoreController {

    @FXML
    private Label myScore;
    @FXML
    private TextArea textArea;
    @FXML
    TextField textField;
    FileChooser fileChooser = new FileChooser();
    int scoreEnd;

    public void initialize(){
        scoreEnd = (int) GameScene.getScore();
        myScore.setText("Your score: "+String.valueOf(scoreEnd));

        /**
         * Choose the file to open the high score lists
         */
        fileChooser.setInitialDirectory(new File("C:\\Users\\ivanl\\OneDrive\\Desktop\\UNM\\Year 2\\2022 Autum Sem\\2042 Software Maintenance\\COMP2042LeeIvanXinLiang\\COMP2042_CW_hcyil1\\src\\main\\resources\\High Score Files"));
        File file = fileChooser.showOpenDialog(new Stage());
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                textArea.appendText( scanner.nextLine()+ "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void Submit(ActionEvent event){
        textArea.appendText(textField.getText() + " : " + scoreEnd + "\n"); //Adds username + score to text area
        /**
         * Saves whatever is in the text area
         */
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null){
            saveFile(file, textArea.getText());
        }
    }

    /**
     * Function for saving to file
     * @param file
     * @param scores
     */
    public void saveFile(File file, String scores){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(scores);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
