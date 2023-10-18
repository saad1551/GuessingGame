package com.guessinggame.guessinggame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The `App` class is the entry point of the JavaFX application.
 * It extends `Application` and sets up the application's main stage and scene.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Load the primary.fxml file and set up the associated controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        PrimaryController controller = loader.getController();

        // Create a new scene with specified dimensions and set it as the scene for the stage
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Change the root of the scene to the specified FXML file.
     *
     * @param fxml The name of the FXML file to load.
     * @throws IOException if loading the FXML file fails.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Load an FXML file and return its content as a `Parent` object.
     *
     * @param fxml The name of the FXML file to load.
     * @return The loaded `Parent` object representing the FXML content.
     * @throws IOException if loading the FXML file fails.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(); // Start the JavaFX application.
    }
}
