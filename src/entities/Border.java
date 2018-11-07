package entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Border extends Entity {
    //public static Image backgroundHp = new Image("brown1.png");

    public Border(Pane pane, int x, int y, String imagePath) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        setImage(new Image(imagePath));
        pane.getChildren().add(this);
    }
}
