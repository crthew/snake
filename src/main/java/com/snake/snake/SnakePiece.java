package com.snake.snake;

public class SnakePiece {

    private GridPosition position;
    private Direction dir;

    public SnakePiece(int x, int y, int tileSize, Direction dir) {
        this.position = new GridPosition(x, y, tileSize);
        this.dir = dir;
    }

    public GridPosition getPosition() {
        return position;
    }
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    public Direction getDir() {
        return dir;
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
}
