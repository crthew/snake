package com.snake.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.BLACK;

public class GameLaunch extends Application {

    private static final int TILE_SIZE = 20;
    private static final int GAME_HEIGHT = 1000;
    private static final int GAME_WIDTH = 1000;

    private Canvas canvas;
    private BorderPane root;

    private GameLogic gameLogic = new GameLogic();

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        this.canvas = new Canvas(GAME_HEIGHT, GAME_WIDTH);
        root.setCenter(canvas);
        drawGame();
        stage.setScene(scene);
        stage.show();
    }

    private void drawGame() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Snake snake = gameLogic.getSnake();
        for(Position pos : snake.getSnakeBody()) {
            gc.fillRect(pos.getX(), pos.getY(), TILE_SIZE, TILE_SIZE);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
