package simulation;

import entities.Dodgem;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import util.Globals;

public class Simulation extends Pane {

    Simulation() {

    }

    public void start() {
        Scene scene =  getScene();
        initDodgems();
        Globals.simulationLoop = new SimulationLoop(this);
        Globals.simulationLoop.start();
    }

    private void initDodgems() {
        for (int i = 0; i < 10; i++) {
            new Dodgem(this, 200 + i * 80, 350);
        }

    }
}
