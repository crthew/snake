package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.*;

public class GameLogic {

    private Snake snake;
    private ArrayList<Apple> apples;
    private Grid grid;
    private KeyCode key;

    public GameLogic(int timeSize, int maxX, int maxY) {
        this.snake = new Snake(timeSize * 10,timeSize * 10, timeSize);
        this.grid = new Grid();
        this.key = KeyCode.S;
        this.apples = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            apples.add(new Apple(timeSize, maxY, maxX));
        }
    }

    public void tick() {
        snake.moveSnake(key);
        checkSnakeCollision();
        checkAppleCollision();
    }

    public void setKey(KeyCode key) {
        switch (key) {
            case W -> this.key = W;
            case A -> this.key = A;
            case S -> this.key = S;
            case D -> this.key = D;
        }
    }

    public Snake getSnake() {
        return snake;
    }
    public Apple getApple() {
        return apples.getFirst();
    }

    public Grid getGrid() {
        return grid;
    }
    private void checkSnakeCollision() {
        GridPosition snakePos = snake.getHead();
        for (GridPosition bodyPiece : snake.getSnakeTail()) {
            if (bodyPiece.getX() == snakePos.getX() && bodyPiece.getY() == snakePos.getY()) {
                System.exit(0);
            }
        }
    }

    private void checkAppleCollision() {
        GridPosition firstApple = getApple().getPosition();
        GridPosition snakePos = snake.getHead();
        if (firstApple.getX() == snakePos.getX() && firstApple.getY() == snakePos.getY()) {
            snake.growSnake();
            apples.remove(0);
        }
    }

}
