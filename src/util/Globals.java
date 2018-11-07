package util;

import entities.Entity;
import simulation.SimulationLoop;

import java.util.Collections;
import java.util.List;

public class Globals {

    public static List<Entity> simulationObjects;
    public static List<Entity> newSimulationObjects;
    public static List<Entity> oldSimulationObjects;

    public static SimulationLoop simulationLoop;

    public static void addGameObject(Entity toAdd) {
        newSimulationObjects.add(toAdd);
    }

    public static void removeGameObject(Entity toRemove) {
        oldSimulationObjects.add(toRemove);
    }

    public static List<Entity> getGameObjects() {
        return Collections.unmodifiableList(simulationObjects);
    }

    public static void removeAllSimulationObjects() {
        for (Entity ent : getGameObjects()) {
            ent.destroy();
        }
    }
}
