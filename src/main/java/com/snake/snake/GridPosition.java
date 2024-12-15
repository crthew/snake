package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class GridPosition {
    private final ArrayList<KeyCode> MOVES = new ArrayList<>();
    private final int TILE_SIZE;
    private int x;
    private int y;

    public GridPosition(int x, int y, int tileSize) {
        this.x = x;
        this.y = y;
        this.TILE_SIZE = tileSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y = y - TILE_SIZE;
    }

    public void moveDown() {
        y = y + TILE_SIZE;
    }

    public void moveLeft() {
        x = x - TILE_SIZE;
    }

    public void moveRight() {
        x = x + TILE_SIZE;
    }

    public void setPos(GridPosition pos) {
        x = pos.getX();
        y = pos.getY();
    }
}
