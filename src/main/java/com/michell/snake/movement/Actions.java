package com.michell.snake.movement;

import java.awt.*;

public final class Actions implements IActions{

    public static int DISTANCE = 10;
    // Don't instance this class
    private Actions(){

    }

    public static Point direction(Controls controls, Point newPoint) {
        switch (controls) {
            case UP -> newPoint.y -= DISTANCE;
            case DOWN -> newPoint.y += DISTANCE;
            case LEFT -> newPoint.x -= DISTANCE;
            case RIGHT -> newPoint.x += DISTANCE;
        }
        return newPoint;
    }
}
