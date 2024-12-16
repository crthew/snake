package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.*;

public class Snake {
    private final int TILE_SIZE;
    private final ArrayList<SnakePiece> SNAKE_BODY = new ArrayList<>();

    public Snake(int x, int y, int tileSize) {
        TILE_SIZE = tileSize;
        SNAKE_BODY.add(new SnakePiece(x,y, TILE_SIZE, Direction.DOWN));
    }

    public void moveSnake(Direction dir) {
        if(SNAKE_BODY.size() > 1) {
            for(int i = SNAKE_BODY.size() - 1; i >= 1; i--) {
                SNAKE_BODY.get(i).getPosition().setPos(SNAKE_BODY.get(i - 1).getPosition());
                SNAKE_BODY.get(i).setDir(SNAKE_BODY.get(i - 1).getDir());
            }
        }
        SNAKE_BODY.get(0).setDir(dir);
        movePiece(SNAKE_BODY.get(0));
    }
    public void growSnake() {
        SnakePiece newPiece = new SnakePiece(SNAKE_BODY.getLast().getX(), SNAKE_BODY.getLast().getY(), TILE_SIZE, Direction.flipDirection(SNAKE_BODY.getLast().getDir()));
        movePiece(newPiece);
        newPiece.setDir(Direction.flipDirection(newPiece.getDir()));
        SNAKE_BODY.add(newPiece);
    }

    public ArrayList<SnakePiece> getSnakeBody() {
        return SNAKE_BODY;
    }
    public ArrayList<GridPosition> getSnakeTail() {
        ArrayList<GridPosition> snakeTail = new ArrayList<>();
        for(int i = 1; i < SNAKE_BODY.size(); i++) {
            snakeTail.add(SNAKE_BODY.get(i).getPosition());
        }
        return snakeTail;
    }
    public GridPosition getHead() {
        return SNAKE_BODY.getFirst().getPosition();
    }

    public int getLength() {
        return SNAKE_BODY.size();
    }

    private void movePiece(SnakePiece piece) {
        switch (piece.getDir()) {
            case UP -> piece.getPosition().moveUp();
            case LEFT -> piece.getPosition().moveLeft();
            case DOWN -> piece.getPosition().moveDown();
            case RIGHT -> piece.getPosition().moveRight();
        }
    }
}
