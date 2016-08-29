package design;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CaptureEditor extends BorderPane implements Initializable {
	@FXML
	Button btn_capture;
	@FXML
	Canvas canvas;
	int x = 0;
	int y = 0;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_capture.setOnMouseClicked(event -> btn_capture(event));
	}

	private void btn_capture(MouseEvent event) {
		double width = getWidth() - 250.0;
		double height = getHeight() - 50.0;
		System.out.println(canvas.getHeight());
		System.out.println(canvas.getWidth());
		canvas.setWidth(width);
		canvas.setHeight(height);
		Image image = new Image("http://cdn.ddanzi.com/201511-images/50213018.jpg"
				, width, height, true, true);

		//WritableImage image = this.getCenter().snapshot(new SnapshotParameters(), null);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, 0.0, 0.0);
	}

	public CaptureEditor() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("capture_editor.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
