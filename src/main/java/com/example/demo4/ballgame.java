package com.example.demo4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ballgame extends Application {

    public static final int width = 400;
    public static  final int height =600;
    @Override
    public void start(Stage stage) throws IOException {


        Scene scene = new Scene(new Game(), width,height);
        stage.setTitle("BALL GAME");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}
