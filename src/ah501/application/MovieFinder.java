package ah501.application;

import javafx.application.Application;
import javafx.stage.Stage;

/*
* Author: ah501
* The primary class for the MovieFinder app. Implements start() method that launches the app with the
* home screen on display. Additionally has a main method for launching the application, if necessary.
 */

public class MovieFinder extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("MovieFinder");
		stage.setScene(SceneManager.createFXMLScene("StartScreen.fxml"));

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
