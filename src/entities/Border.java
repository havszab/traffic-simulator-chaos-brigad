package entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Border extends Entity {
    public static Image backgroundHp = new Image("browBG.png");

    public Border(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        setImage(backgroundHp);
        pane.getChildren().add(this);
    }
}
