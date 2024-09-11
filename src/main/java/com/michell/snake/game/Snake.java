package com.michell.snake.game;

import java.awt.*;
import java.util.LinkedList;

import com.michell.snake.movement.Actions;
import com.michell.snake.movement.Controls;

public class Snake {
    private LinkedList<Point> body; // Lista que almacena los segmentos de la serpiente
    private Controls direction;    // Dirección actual de la serpiente
    private Color color;
    private final int LENGTH = 20;


    public Snake(Point start, Color color) {
        this.body = new LinkedList<>();
        this.body.add(start); // Posición inicial
        this.direction = Controls.RIGHT; // Empieza moviéndose a la derecha
        this.color = color;
    }

    public void move() {
        Point head = body.getFirst();
        Point newPoint = new Point(head);

        // Añadir nueva cabeza al principio
        body.addFirst(Actions.direction(direction, newPoint));
        body.removeLast(); // Eliminar la cola para moverse
    }

    public void setDirection(Controls direction) {
        this.direction = direction;
    }

    public void grow() {
        body.addLast(body.getLast()); // Añadir un nuevo segmento al final
    }

    public void draw(Graphics g) {
        g.setColor(color);
        for (Point point : body) {
            g.fillRect(point.x, point.y, LENGTH, LENGTH);
        }
    }

    public Point getHead() {
        return body.getFirst();
    }

    public LinkedList<Point> getBody(){
        return this.body;
    }

    public synchronized boolean checkCollision(Snake otherSnake) {
        Point myHead = this.getHead();  // Obtener la cabeza de esta serpiente
        LinkedList<Point> otherBody = otherSnake.getBody();  // Obtener el cuerpo de la otra serpiente

        // Recorrer los segmentos de la otra serpiente para verificar si colisionan con mi cabeza
        for (Point segment : otherBody) {
            if (myHead.equals(segment)) {
                return true;  // Colisión detectada
            }
        }
        return false;  // No hubo colisión
    }
}