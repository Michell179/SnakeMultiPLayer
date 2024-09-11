package com.michell.snake.game;

import com.michell.snake.movement.Controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Snake snake1, snake2;
    private SnakeThread snakeThread1, snakeThread2;

    public GamePanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);

        // Crear las serpientes
        snake1 = new Snake(new Point(100, 100), Color.GREEN);
        snake2 = new Snake(new Point(200, 200), Color.BLUE);

        // Crear los threads para controlar las serpientes
        snakeThread1 = new SnakeThread(snake1, snake2, this);
        snakeThread2 = new SnakeThread(snake2, snake1, this);

        // Iniciar los threads
        snakeThread1.start();
        snakeThread2.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake1.draw(g);
        snake2.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Control de la serpiente 1 (WASD)
        if (key == KeyEvent.VK_W) snake1.setDirection(Controls.UP);
        if (key == KeyEvent.VK_S) snake1.setDirection(Controls.DOWN);
        if (key == KeyEvent.VK_A) snake1.setDirection(Controls.LEFT);
        if (key == KeyEvent.VK_D) snake1.setDirection(Controls.RIGHT);

        // Control de la serpiente 2 (flechas)
        if (key == KeyEvent.VK_I) snake2.setDirection(Controls.UP);
        if (key == KeyEvent.VK_K) snake2.setDirection(Controls.DOWN);
        if (key == KeyEvent.VK_J) snake2.setDirection(Controls.LEFT);
        if (key == KeyEvent.VK_L) snake2.setDirection(Controls.RIGHT);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
