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

    boolean running, goNorth, goSouth, goEast, goWest;

    @FXML
    private Circle player;

    public void initialize(){

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                movePlayer(1,1);
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
        player.setRadius(400);

        System.out.println(event.getCode());
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        player.setRadius(50);

        System.out.println(event.getCode());
    }

}
