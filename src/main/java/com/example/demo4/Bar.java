package com.example.demo4;

import javafx.scene.shape.Rectangle;

public class Bar extends Rectangle implements CollisionDetect{
    public static final double witdh = 100.0d;
    public static final double heigth = 20.0d;
    Bar(){
        super(ballgame.width/2, ballgame.height - 40,100,20);
        setArcHeight(20);
        setArcWidth(20);
    }
    public CollisionFrom isCollision(Ball ball){
        if(ball.getDirection() == Ball.Direction.TOP_RIGHT ||ball.getDirection()==Ball.Direction.TOP_LEFT) return null;

        if(getBoundsInParent().intersects(ball.getBoundsInParent())){
            double ballPosY =  ball.getCenterY();
            if(getY()< ballPosY && getY()+heigth >ballPosY){
                return CollisionFrom.VERTICAL;
            }
            else{
                return CollisionFrom.HORIZONTAL;
            }
        }
        return null;
    }

}


