package entities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import simulation.Simulation;
import util.Globals;
import util.Util;

public class Dodgem extends Entity implements Animatable {


    public static Image maxHp = new Image("car.png");

    private float speed = 0;

    public Dodgem(Pane pane, int x, int y) {
       super(pane);
       this.pane = pane;
       setX(x);
       setY(y);
       setImage(maxHp);
       pane.getChildren().add(this);
    }

    @Override
    public void step() {
        this.setRotate(this.getRotate()+3);
        Point2D heading = Util.directionToVector(this.getRotate(), this.speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }
}
