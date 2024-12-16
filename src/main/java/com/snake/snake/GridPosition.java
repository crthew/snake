package com.snake.snake;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class GridPosition {
    private final int TILE_SIZE;
    private final int X_LIMIT;
    private final int Y_LIMIT;
    private int x;
    private int y;

    public GridPosition(int x, int y, int tileSize) {
        this.x = x;
        this.y = y;
        this.X_LIMIT = GameLaunch.getGameWidth();
        this.Y_LIMIT = GameLaunch.getGameHeight();
        this.TILE_SIZE = tileSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        if(y - TILE_SIZE < 0) {
            y = Y_LIMIT;
        } else {
            y = y - TILE_SIZE;
        }
    }

    public void moveDown() {
        if(y + TILE_SIZE > Y_LIMIT) {
            y = 0;
        } else {
            y = y + TILE_SIZE;
        }
    }

    public void moveLeft() {
        if(x - TILE_SIZE < 0) {
            x = X_LIMIT;
        } else {
            x = x - TILE_SIZE;
        }
    }

    public void moveRight() {
        if(x + TILE_SIZE > X_LIMIT) {
            x = 0;
        } else {
            x = x + TILE_SIZE;
        }
    }

    public void setPos(GridPosition pos) {
        x = pos.getX();
        y = pos.getY();
    }
}
