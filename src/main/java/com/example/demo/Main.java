package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    static Color COLOUR = Color.rgb(233, 203, 81); //Used for changing background colour theme

    @Override
    public void start(Stage primaryStage) throws Exception {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/StartScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch(Exception e){
        e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
