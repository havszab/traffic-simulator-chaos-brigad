package entities;

import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import simulation.Simulation;
import util.Globals;
import util.Util;

public class Dodgem extends Entity implements Animatable {


    public static Image maxHp = new Image("car.png");

    private float speed = 1;

    public Dodgem(Pane pane, int x, int y) {
       super(pane);
       this.pane = pane;
       setX(x);
       setY(y);
       setImage(maxHp);
       pane.getChildren().add(this);
       this.setRotate(Util.getRandomIntInRange(0, 90)-45);
    }

    @Override
    public void step() {
        this.setRotate(this.getRotate() + (Util.getRandomIntInRange(0, 30)-15));
        Point2D heading = Util.directionToVector(this.getRotate(), this.speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        for (Entity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent()) && entity != this) {
                if (entity instanceof Dodgem ) {
                    handleCrash();
                } else if (entity instanceof Border) {
                    System.out.println("border");
                    handleCrash();
                }
            }
        }
    }


    private void handleCrash() {
        this.speed *= -1;

    }
}
