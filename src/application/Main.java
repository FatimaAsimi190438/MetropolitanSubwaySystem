package application;
	
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	private static Stage NewScene;
	
	public static Stage getNewScene() {
		return NewScene;
	}

	public static void setNewScene(Stage newScene) {
		NewScene = newScene;
	}

	@Override
	public void start(Stage primaryStage) {
		
		try {

			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			Scene scene = new Scene(root,636,696);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NewScene = primaryStage;
			primaryStage.setTitle("Subway Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void NextScene(String nextStage) throws IOException {
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(nextStage));
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
	}

	public static void main(String[] args) throws SQLException {

		Multithreading.retreiveInformation();
		launch(args);
	}
}
