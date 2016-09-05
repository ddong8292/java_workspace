package design;

import four.person.web.browser.capture.CaptureEditor;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{
	static Stage stage;
	static Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		CaptureEditor captureEditor = new CaptureEditor();
		scene=new Scene(captureEditor);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
