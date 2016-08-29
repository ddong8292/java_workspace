package design;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		CaptureEditor captureEditor = new CaptureEditor();
		
		Scene scene=new Scene(captureEditor);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
