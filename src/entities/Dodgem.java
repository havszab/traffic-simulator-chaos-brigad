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
    public static Image damaged = new Image("car_damaged.png");
    public static Image broken = new Image("car_broken.png");


    private float speed = 1;
    private float dirChange;
    private int hp = 20;

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
        setRotate(getRotate()+dirChange);
        if (!this.isBroken())
            this.speed += 0.01;
        Point2D heading = Util.directionToVector(this.getRotate(), this.speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        for (Entity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent()) && entity != this && !this.isBroken()) {
                if (entity instanceof Dodgem) {
                    handleCrash();
                } else if (entity instanceof Border) {
                    handleCrash();
                }
            }
        }
    }


    private void handleCrash() {
        this.hp --;
        changeImageBasedOnCondition();
        dirChange = Util.getRandomIntInRange(0, 3) - (float) 1.5;
        this.speed *= -1;
        if (isBroken()) {
            this.speed = 0;
            this.dirChange = 0;
        }


    }

    private boolean isBroken() {
        return this.hp <= 0;
    }

    private void changeImageBasedOnCondition() {
        if (this.hp > 10)
            this.setImage(maxHp);
        else if (this.hp <=10 && this.hp >0)
            this.setImage(damaged);
        else
            this.setImage(broken);
    }
}
