package com.snake.snake;

public class GameLogic {

    private Snake snake;
    private Grid grid;

    public GameLogic() {
        this.snake = new Snake(0,0);
        this.grid = new Grid();
    }

    public Snake getSnake() {
        return snake;
    }

    public Grid getGrid() {
        return grid;
    }

}
