package com.example.demo4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class Game extends Pane implements GameOver{
    private Ball ball;
    private Bar bar;
    private GameLabel gamelabel;
    private Timeline timeline;
    private boolean startGame= false;
    private final int countOfRows =5;
    private final int countBricksInRow = 5;
    private Brick [][] bricks = new Brick[countOfRows][countBricksInRow];

    Game(){
        gamelabel.setBackground(Background.fill(Paint.valueOf("blue")));
        setWidth(ballgame.width);
        setHeight(ballgame.height);

        ball = new Ball(this:: gameOver);
        bar = new Bar();
        gamelabel = new GameLabel();

        getChildren().addAll(ball,bar,gamelabel);

        setOnMouseMoved(e -> bar.setX(e.getX()-Bar.witdh / 2));
        setOnMouseClicked(this::startGame);
        for(int i = 0; i <countOfRows; i++){
            for(int j =0; j<countBricksInRow; j++){
                bricks[i][j] = new Brick(i,j);
                getChildren().add(bricks[i][j]);
            }
        }
        timeline = new Timeline(new KeyFrame(Duration.millis(5),this::move));
        timeline.setCycleCount(-1);
    }
    private void startGame(MouseEvent mouseevent){
        if(startGame) return;
        timeline.play();
    }
private void move(ActionEvent actionEvent){
        CollisionDetect.CollisionFrom collision = null;
        ball.move();

        collision = bar.isCollision(ball);
        if(collision != null){
            ball.setDirection(collision);
            return;
        }
        for (int i = 0; i<countOfRows; i++){
            for(int j = 0; j < countBricksInRow; j++){
                collision = bricks[i][j].isCollision(ball);
                if(collision != null){
                    ball.setDirection(collision);
                }
            }
        }
}
    @Override
    public void gameOver() {
        startGame = false;
        timeline.stop();
        gamelabel.show("OYUN SONU... \n TEKRAR DENEMEK İÇİN TIKLAYIN");
    }
}



