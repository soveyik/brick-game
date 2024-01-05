package com.example.demo4;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GameLabel extends Label {
    GameLabel(){
        setFont(new Font(30));
        setLayoutY((double)ballgame.height / 2);
        setVisible(false);
    }
    public void show(String message){
        setText(message);
        System.out.println(getWidth());
        setLayoutX((double) ballgame.width /2 -100);
        setVisible(true);
    }
    public void clear(){
        setVisible(false);
    }
}
