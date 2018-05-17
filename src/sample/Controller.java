package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class Controller {

    final static int MOVE_SPEED = 2;
    final static int RUN_FACTOR = 2;

    boolean running, goNorth, goSouth, goEast, goWest;

    @FXML
    private Circle player;

    @FXML
    private BorderPane pane;

    public void initialize() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0;
                int dy = 0;
                if (goNorth) dy = -MOVE_SPEED;
                if (goSouth) dy = MOVE_SPEED;
                if (goEast) dx = MOVE_SPEED;
                if (goWest) dx = -MOVE_SPEED;
                if (running) {
                    dx *= RUN_FACTOR;
                    dy *= RUN_FACTOR;
                }
                movePlayer(dx, dy);
            }
        };
        timer.start();
    }

    /**
     * Moves player given deltas.
     *
     * @param dx change in x direction.
     * @param dy change in y direction.
     */
    private void movePlayer(int dx, int dy) {
        double x = player.getCenterX() + dx;
        double y = player.getCenterY() + dy;
        if (x >= pane.getWidth() - player.getRadius()) return;
        if (y >= pane.getHeight() - player.getRadius()) return;
        if (x <= 0 + player.getRadius()) return;
        if (y <= 0 + player.getRadius()) return;
        player.setCenterX(x);
        player.setCenterY(y);
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        handleKeyEvent(event, true);
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        handleKeyEvent(event, false);
    }

    /**
     * moves player based on presed key
     *
     * @param event KeyEvent
     * @param state true/false to determine
     */
    private void handleKeyEvent(KeyEvent event, boolean state){
        switch (event.getCode()) {
            case UP:
            case W:
                goNorth = state;
                break;
            case DOWN:
            case S:
                goSouth = state;
                break;
            case LEFT:
            case A:
                goWest = state;
                break;
            case RIGHT:
            case D:
                goEast = state;
                break;
            case SHIFT:
                running = state;
                break;
            default:
                // Ignore other keys.
        }

    }

}
