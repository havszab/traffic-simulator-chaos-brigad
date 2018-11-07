package simulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Simulation simulation = new Simulation();
        primaryStage.setTitle("Dodgem simulator");
        primaryStage.setScene(new Scene(simulation, 1000, 700));
        primaryStage.show();
        simulation.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
