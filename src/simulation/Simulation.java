package simulation;

import entities.Border;
import entities.Dodgem;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import util.Globals;

public class Simulation extends Pane {

    Simulation() {

    }

    public void start() {
        initDodgems();
        initBorder();
        Globals.simulationLoop = new SimulationLoop(this);
        Globals.simulationLoop.start();
    }

    private void initDodgems() {
        for (int i = 0; i < 10; i++) {
            new Dodgem(this, 200 + i * 80, 350);
        }
    }

    private void initBorder(){
        new Border(this,-50,0, "left.png");
        new Border(this,960,0, "right.png");
        new Border(this,0,-50, "top.png");
        new Border(this,0,660, "button.png");
    }
}
