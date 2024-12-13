package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Snake {

    private final ArrayList<Position> snakeBody = new ArrayList<>();

    public Snake(int x, int y) {
        snakeBody.add(new Position(x,y));
    }

    public void moveSnake(KeyCode dir) {
        switch (dir) {
            case W -> snakeBody.forEach(a -> a.moveUp());
            case A -> snakeBody.forEach(a -> a.moveLeft());
            case S -> snakeBody.forEach(a -> a.moveDown());
            case D -> snakeBody.forEach(a -> a.moveRight());
        }
    }

    public ArrayList<Position> getSnakeBody() {
        return snakeBody;
    }

    public int getLength() {
        return snakeBody.size();
    }

}
