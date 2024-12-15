package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.*;

public class Snake {
    private final int TILE_SIZE;
    private final ArrayList<GridPosition> SNAKE_BODY = new ArrayList<>();

    public Snake(int x, int y, int tileSize) {
        TILE_SIZE = tileSize;
        SNAKE_BODY.add(new GridPosition(x,y, TILE_SIZE));
    }

    public void moveSnake(KeyCode dir) {
        if(SNAKE_BODY.size() > 1) {
            for(int i = SNAKE_BODY.size() - 1; i >= 1; i--) {
                SNAKE_BODY.get(i).setPos(SNAKE_BODY.get(i - 1));
            }
        }
        if(dir == W || dir == A || dir == S || dir == D) {
            switch (dir) {
                case W -> SNAKE_BODY.get(0).moveUp();
                case A -> SNAKE_BODY.get(0).moveLeft();
                case S -> SNAKE_BODY.get(0).moveDown();
                case D -> SNAKE_BODY.get(0).moveRight();
            }
        }

    }
    public void growSnake() {
        GridPosition newSnake = new GridPosition(SNAKE_BODY.getLast().getX(), SNAKE_BODY.getLast().getY(), TILE_SIZE);
        newSnake.moveLeft();

        System.out.println("new snake: " + newSnake.getX() + " | " + newSnake.getY());
        System.out.println("old snake: " + SNAKE_BODY.getLast().getX() + " | " + SNAKE_BODY.getLast().getY());
        SNAKE_BODY.add(newSnake);
    }

    public ArrayList<GridPosition> getSnakeBody() {
        return SNAKE_BODY;
    }
    public ArrayList<GridPosition> getSnakeTail() {
        ArrayList<GridPosition> snakeTail = new ArrayList<>();
        for(int i = 1; i < SNAKE_BODY.size(); i++) {
            snakeTail.add(SNAKE_BODY.get(i));
        }
        return snakeTail;
    }
    public GridPosition getHead() {
        return SNAKE_BODY.getFirst();
    }

    public int getLength() {
        return SNAKE_BODY.size();
    }

}
