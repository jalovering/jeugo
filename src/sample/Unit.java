package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class Unit extends Circle {


    public boolean atEdge(BorderPane pane, double x, double y){
        if (x >= pane.getWidth() - this.getRadius()) return true;
        if (y >= pane.getHeight() - this.getRadius()) return true;
        if (x <= 0 + this.getRadius()) return true;
        if (y <= 0 + this.getRadius()) return true;
        return false;
    }

    /**
     * Moves this unit given deltas.
     *
     * @param dx change in x direction.
     * @param dy change in y direction.
     */
    protected void move(Direction direction, BorderPane pane) {
        double x = this.getCenterX() + direction.getDx();
        double y = this.getCenterY() + direction.getDy();
        if (atEdge(pane, x, y)) return;
        this.setCenterX(x);
        this.setCenterY(y);
    }

}
