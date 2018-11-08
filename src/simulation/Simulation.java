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
        new Border(this,0,0, "browBG.png");
        new Border(this,0,650, "browBG.png");
        Border lB = new Border(this, -500, 300, "browBG.png");
        lB.setRotate(90);
        Border rB = new Border(this, 500, 300, "browBG.png");
        rB.setRotate(90);


    }
}
