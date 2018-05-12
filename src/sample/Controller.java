package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;
import static javafx.scene.input.KeyCode.SHIFT;
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;

public class Controller {

    final static int MOVE_SPEED = 2;
    final static int RUN_FACTOR = 2;

    boolean running, goNorth, goSouth, goEast, goWest;


    @FXML
    private Circle player;

    public void initialize(){

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
     * @param dx change in x direction.
     * @param dy change in y direction.
     */
    private void movePlayer(int dx, int dy) {
        double x = player.getCenterX();
        double y = player.getCenterY();
        player.setCenterX(x+dx);
        player.setCenterY(y+dy);
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                goNorth = true;
                break;
            case DOWN:
                goSouth = true;
                break;
            case LEFT:
                goWest = true;
                break;
            case RIGHT:
                goEast = true;
                break;
            case SHIFT:
                running = true;
                break;
            default:
                // fall through
        }
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                goNorth = false;
                break;
            case DOWN:
                goSouth = false;
                break;
            case LEFT:
                goWest = false;
                break;
            case RIGHT:
                goEast = false;
                break;
            case SHIFT:
                running = false;
                break;
            default:
                // fall through
        }
    }

}
