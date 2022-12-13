package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WinController {

    @FXML
    private Button Button;

    @FXML
    private AnchorPane winPane;

    @FXML
    private Label myScore;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void button(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/HighScore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

