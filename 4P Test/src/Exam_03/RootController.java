package Exam_03;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Handler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable{
	@FXML Button btn;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn.setOnAction(event->HandlerBtn2Action(event));
		
	}


	private void HandlerBtn2Action(ActionEvent event) {
		System.out.println("Å¬¸¯");
	}

}
