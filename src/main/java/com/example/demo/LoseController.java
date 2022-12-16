package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Displays screen when user does not reach 2048 tile
 */
public class LoseController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label myScore;
    public void initialize() {
        int finalScore = (int) GameScene.getScore();
        myScore.setText("Your score: " + String.valueOf(finalScore));
    }

    /**
     * Load next screen
     * @param event
     * @throws IOException
     */
    public void button(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/HighScore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
