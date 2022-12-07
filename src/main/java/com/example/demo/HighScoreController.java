package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HighScoreController {

    @FXML
    private Label myScore;
    @FXML
    private Label myLabel;
    @FXML
    TextField textField;

    public void initialize(){
        int scoreEnd = (int) GameScene.getScore();
        myScore.setText("Your score: "+String.valueOf(scoreEnd));
    }
    public void Submit(ActionEvent event){
        myLabel.setText(textField.getText());
    }
}
