package sample;

import javafx.scene.layout.BorderPane;

public class Enemy extends AbstractCircleUnit implements Unit {


    //todo: private direction decisionpolicy policy
    private Direction direction;
    private static int xSpeed = 1;
    private static int ySpeed = 1;

    public Enemy() {
        direction = new Direction(xSpeed, ySpeed);
    }

    public void move(BorderPane pane) {

        if (this.atEdge(pane, this.getCenterX(), this.getCenterY() - ySpeed) //top
                || this.atEdge(pane, this.getCenterX(), this.getCenterY() + ySpeed) //bottom
                ) {
            direction = new Direction(direction.getDx(), -direction.getDy());
        }

        if (this.atEdge(pane, this.getCenterX() - xSpeed, this.getCenterY()) //left
                || this.atEdge(pane, this.getCenterX() + xSpeed, this.getCenterY()) //right
                ) {
            direction = new Direction(-direction.getDx(), direction.getDy());
        }
        this.move(direction, pane);
    }
}
