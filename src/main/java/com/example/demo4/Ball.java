package com.example.demo4;

import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;


public class Ball extends Circle {

    public void move() {switch (direction){
        case TOP_LEFT :
            setLayoutX(--posX);
            setLayoutY(--posY);
            if(posX -radius <= 0){
                direction = Direction.TOP_RIGHT;
            }
            if(posY -radius <= 0){
                direction = Direction.BOTTOM_LEFT;
            }
            break;
        case TOP_RIGHT:
            setLayoutX(++posX);
            setLayoutY(--posY);
            if(posX + radius>= ballgame.width){
                direction = Direction.TOP_LEFT;
            }
            if(posY-radius <= 0){
                direction = Direction.BOTTOM_RIGHT;
            }break;
        case BOTTOM_LEFT:
            setLayoutX(--posX);
            setLayoutY(++posY);
            if(posX -radius<= 0){
                direction = Direction.BOTTOM_RIGHT;
            }
            if(posY +radius >= ballgame.height){
                direction = Direction.TOP_LEFT;
            }
            break;
        case BOTTOM_RIGHT:
            setLayoutX(++posX);
            setLayoutY(++posY);
            if(posX+ radius >=ballgame.width){
                direction = Direction.BOTTOM_LEFT;
            }
            if(posY + radius>=ballgame.height){
                direction= Direction.TOP_RIGHT;
            }
            break;
    }
        setCenterX(posX);
        setCenterY(posY);

    }

    public enum Direction {TOP_RIGHT, TOP_LEFT, BOTTOM_RIGHT, BOTTOM_LEFT};
    private Direction direction = Direction.TOP_RIGHT;
    private GameOver gameOver;
    private int posX ;
    private int posY ;
    private Timeline timeline;
    private final int radius =10;


    Ball(GameOver gameOver){
        super(ballgame.width/2, ballgame.height/2,10, Paint.valueOf("red"));

        posX = (int) getCenterX();
        posY = (int) getCenterY();
        this.gameOver = gameOver;
    }

    public void setDirection(CollisionDetect.CollisionFrom collision) {
        switch (direction){
            case TOP_LEFT:
                direction = collision == CollisionDetect.CollisionFrom.VERTICAL ?  Direction.TOP_RIGHT : Direction.BOTTOM_LEFT;
                break;
            case TOP_RIGHT:
                direction = collision == CollisionDetect.CollisionFrom.VERTICAL ?  Direction.TOP_LEFT : Direction.BOTTOM_RIGHT;
                break;
            case BOTTOM_LEFT:
                direction = collision == CollisionDetect.CollisionFrom.VERTICAL ?  Direction.BOTTOM_RIGHT : Direction.TOP_LEFT;
                break;
            case BOTTOM_RIGHT:
                direction = collision == CollisionDetect.CollisionFrom.VERTICAL ?  Direction.BOTTOM_LEFT : Direction.TOP_RIGHT;
                break;
        }
    }


    public Direction getDirection() {
        return direction;
    }

}


