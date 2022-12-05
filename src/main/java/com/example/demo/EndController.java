package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class EndController {
    @FXML
    private Label myScore;

    @FXML
    void buttonScore() {
        int scoreEnd = (int) GameScene.getScore();
        myScore.setText("Your score: "+String.valueOf(scoreEnd));
    }
}
