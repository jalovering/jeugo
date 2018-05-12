package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    player.setRadius(50);
}


}
