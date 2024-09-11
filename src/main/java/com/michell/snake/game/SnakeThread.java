package com.michell.snake.game;


public class SnakeThread extends Thread {
    private Snake snake;
    private Snake otherSnake;
    private GamePanel gamePanel;
    private boolean running = true;

    public SnakeThread(Snake snake, Snake otherSnake, GamePanel gamePanel) {
        this.snake = snake;
        this.otherSnake = otherSnake;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(100); // Pausa entre movimientos
                snake.move();      // Mover la serpiente
                gamePanel.repaint();
                if (snake.checkCollision(otherSnake)) {
                    running = false;  // Detener el juego si hay colisión
                    System.out.println("¡Colisión detectada entre las serpientes!");
                }
                stopSnake();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + snake.getHead());
        }
    }

    public void stopSnake() {
        if (
                snake.getHead().x >= 800 - 20 ||
                snake.getHead().y >= 800 - 20 ||
                snake.getHead().y <= 0 ||
                snake.getHead().x <= 0
        ) {
            this.running = false;
        }
    }

}