package simulation;

import javafx.animation.AnimationTimer;
import util.Globals;

public class SimulationLoop extends AnimationTimer {


    @Override
    public void handle(long now) {


        Globals.simulationObjects.addAll(Globals.newSimulationObjects);
        Globals.newSimulationObjects.clear();

        Globals.simulationObjects.removeAll(Globals.oldSimulationObjects);
        Globals.oldSimulationObjects.clear();

    }
}
