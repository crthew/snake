package com.snake.snake;

import java.util.Random;

public class Apple {

    private static final Random rand = new Random();

    private final GridPosition GRID_POSITION;

    public Apple(int tileSize, int maxY, int maxX) {
        int x = rand.nextInt(maxX);
        int y = rand.nextInt(maxY);
        GRID_POSITION = new GridPosition(x * tileSize, y * tileSize, tileSize);
    }

    public GridPosition getPosition() {
        return GRID_POSITION;
    }
}
