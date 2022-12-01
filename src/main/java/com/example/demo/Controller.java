package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.Main.*;
public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Scene gameScene;
    private Group gameRoot;


    /**public void startMenuSwitch(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     */

    public void startMenuSwitch(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        //Color.rgb(189, 177, 92));
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, COLOUR);
        setGameScene(gameScene);
        stage.setScene(gameScene);
        GameScene game = new GameScene();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);

        stage.show();
    }


    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myBackgroundPicker;
    public void changeBackground(ActionEvent event){
        Color myColor = myBackgroundPicker.getValue();
        myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        COLOUR = myColor;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
}
