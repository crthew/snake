package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.*;

public class GameLogic {

    private final int MAX_X;
    private final int MAX_Y;
    private final int TILE_SIZE;

    private Snake snake;
    private Apple apple;
    private Grid grid;
    private Direction dir;

    public GameLogic(int tileSize, int maxX, int maxY) {
        this.snake = new Snake(tileSize * 10,tileSize * 10, tileSize);
        this.grid = new Grid();
        this.dir = Direction.DOWN;
        this.TILE_SIZE = tileSize;
        this.MAX_X = maxX;
        this.MAX_Y = maxY;
        this.apple = new Apple(TILE_SIZE, MAX_Y, MAX_X);
    }

    public void tick() {
        snake.moveSnake(dir);
        checkSnakeCollision();
        checkAppleCollision();
    }

    public void setDir(KeyCode key) {
        Direction nextDir = null;
        switch (key) {
            case W -> nextDir = Direction.UP;
            case A -> nextDir = Direction.LEFT;
            case S -> nextDir = Direction.DOWN;
            case D -> nextDir = Direction.RIGHT;
        }
        if(nextDir != null && Direction.flipDirection(dir) == nextDir) {
            quit();
        } else {
            dir = nextDir;
        }
    }

    public Snake getSnake() {
        return snake;
    }
    public Apple getApple() {
        return apple;
    }

    public Grid getGrid() {
        return grid;
    }
    private void checkSnakeCollision() {
        GridPosition snakePos = snake.getHead();
        for (GridPosition bodyPiece : snake.getSnakeTail()) {
            if (bodyPiece.getX() == snakePos.getX() && bodyPiece.getY() == snakePos.getY()) {
                quit();
            }
        }
    }
    private void checkAppleCollision() {
        GridPosition firstApple = getApple().getPosition();
        GridPosition snakePos = snake.getHead();
        if (firstApple.getX() == snakePos.getX() && firstApple.getY() == snakePos.getY()) {
            snake.growSnake();
            apple = new Apple(TILE_SIZE, MAX_Y, MAX_X);
        }
    }

    private void quit() {
        System.exit(0);
    }

}
