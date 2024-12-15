package com.snake.snake;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.paint.Color.*;

public class GameLaunch extends Application {

    private static final int TILE_SIZE = 20;
    private static final int GAME_HEIGHT = 1000;
    private static final int GAME_WIDTH = 1000;
    private static final int TICK_TIME = 100;
    private static final Color SNAKE_COLOUR = GREEN;
    private static final Color APPLE_COLOUR = RED;

    private Canvas canvas;
    private BorderPane root;


    private GameLogic gameLogic = new GameLogic(TILE_SIZE, GAME_HEIGHT/TILE_SIZE, GAME_WIDTH/TILE_SIZE);
    private Timer tickTimeline = new Timer();

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        this.canvas = new Canvas(GAME_HEIGHT, GAME_WIDTH);
        root.setCenter(canvas);
        drawGame();
        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(event -> updKey(event));
        tickTimeline.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 0, TICK_TIME);
    }

    private void tick() {
        gameLogic.tick();
        drawGame();
    }

    private void drawGame() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Snake snake = gameLogic.getSnake();
        for(GridPosition pos : snake.getSnakeBody()) {
            gc.setFill(SNAKE_COLOUR);
            gc.fillRect(pos.getX(), pos.getY(), TILE_SIZE, TILE_SIZE);
        }

            GridPosition pos = gameLogic.getApple().getPosition();
            gc.setFill(APPLE_COLOUR);
            gc.fillRect(pos.getX(), pos.getY(), TILE_SIZE, TILE_SIZE);
    }

    private void updKey(KeyEvent e) {
        System.out.println(e.getCode());
        gameLogic.setKey(e.getCode());
    }

    public static void main(String[] args) {
        launch();
    }

}
