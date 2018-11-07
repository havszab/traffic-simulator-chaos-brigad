package simulation;

import entities.Animatable;
import entities.Entity;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import util.Globals;

public class SimulationLoop extends AnimationTimer {


    public SimulationLoop(Pane pane) {
        super();
    }

    @Override
    public void handle(long now) {

        for (Entity entity : Globals.simulationObjects) {
            if (entity instanceof Animatable)
                ((Animatable) entity).step();
        }

        Globals.simulationObjects.addAll(Globals.newSimulationObjects);
        Globals.newSimulationObjects.clear();

        Globals.simulationObjects.removeAll(Globals.oldSimulationObjects);
        Globals.oldSimulationObjects.clear();

    }
}
