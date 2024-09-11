package com.michell.snake.game;

import javax.swing.*;

public class SnakeGame extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

    public SnakeGame() {
        this.setTitle("Multiplayer Snake Game");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new GamePanel(WIDTH, HEIGHT));
        this.pack();
        this.setLocationRelativeTo(null); // Center window
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }

}