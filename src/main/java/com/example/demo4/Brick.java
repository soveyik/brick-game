package com.example.demo4;

import javafx.scene.shape.Rectangle;



public class Brick extends Rectangle implements CollisionDetect {
    public static final int width = 100;
    public static final int height = 20;
    public static final int margin = 15;

    private boolean isVisible = true;

    Brick(int col, int row) {
        super(col * width + margin * (col + 1), row * height + margin * (row + 3), width, height);
        setArcHeight(20);
        setArcWidth(20);
    }

    @Override
    public CollisionFrom isCollision(Ball ball) {
        if (!isVisible) return null;

        if (getBoundsInParent().intersects(ball.getBoundsInParent())) {
            isVisible = false;
            setVisible(false);
            if (getY() < ball.getCenterY() && getY() + height > ball.getCenterY()) {
                return CollisionFrom.VERTICAL;
            } else {
                return CollisionFrom.HORIZONTAL;
            }

        }
        return null;
    }
}
