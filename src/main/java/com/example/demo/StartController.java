package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static com.example.demo.Main.*;

/**
 * Displays the main menu and prompts for theme selection and grid size
 */
public class StartController implements Initializable {

    private Stage stage;
    private Scene gameScene;
    private Group gameRoot;

    public void startMenuSwitch(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, COLOUR);
        setGameScene(gameScene);
        stage.setScene(gameScene);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, stage);

        stage.show();
    }

    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myBackgroundPicker;

    @FXML
    private Label gridLabel;
    @FXML
    private ChoiceBox choiceBox;
    private String[] grids = {"4", "5", "6"};

    /**
     * Change the colour of the background, changing the theme
     * @param event
     */
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().addAll(grids);
        choiceBox.setOnAction(this::getGrid);
    }

    /**
     * Set the grid dimensions to be whatever the user selects
     * @param event
     */
    private void getGrid(Event event) {
        String currentGrid = (String) choiceBox.getValue();
        gridLabel.setText(currentGrid);
        GameScene num = new GameScene();
        num.setGRID(Integer.parseInt(currentGrid));
    }
}