package ah501.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.nio.file.Paths;

/*
* Author: ah501, idea from mperhez
* This class makes loading FXML views simpler by implementing a method
* that gets an FXML file from its generated URI and returns it as a scene.
 */

public class SceneManager {

    private static String basePath = "src/resources/views/";

    // Fetches an FXML file passed by file name by looking in the base path.
    // Loads it as a pane, which is then passed to create a scene, which is returned.
    public static Scene createFXMLScene(String fxmlFile) throws IOException {

        Pane homePane = (Pane) FXMLLoader.load(
                Paths.get(basePath + fxmlFile).toUri().toURL()
        );
        Scene scene = new Scene(homePane);
        return scene;
    }

}
