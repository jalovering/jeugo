package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class Controller {

    // TODO(jalovering): move these constants inside the player class. These are the stats of the player, so 
    // they should be *inside* the player class, not the controller.
    final static int MOVE_SPEED = 2;
    final static int RUN_FACTOR = 2;

    boolean running, goNorth, goSouth, goEast, goWest;

    @FXML
    private Player player;

    @FXML
    private Enemy enemy;

    @FXML
    private BorderPane pane;

    public void initialize() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
               //todo getplayerdirection function    returns direction
                // TODO(jalovering): move this logic inside player, similar to the move in enemy.
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
                player.move(new Direction(dx, dy), pane);
                enemy.move(pane);
            }
        };
        timer.start();
    }

    private void moveEnemy(){

    }


    @FXML
    private void handleKeyPressed(KeyEvent event) {
        // TODO(jalovering): (3) call the handleKeyEvent from player, i.e. player.handleKeyEvent(...)
        handleKeyEvent(event, true);
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        // TODO(jalovering): (3) call the handleKeyEvent from player, i.e. player.handleKeyEvent(...)
        handleKeyEvent(event, false);
    }

    // TODO(jalovering): (2) move handleKeyEvent inside Player.
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

    private void contactDeath(){
        if(player.getCenterX() + player.getRadius() == enemy.getCenterX() + enemy.getRadius()){
            // restart scene
        }


    }

}
