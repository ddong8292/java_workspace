package Exam_04;



import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class WidgetBar extends HBox{
	Button[]btns=new Button[5];
	public WidgetBar() {
		/*for(int i=0; i<btns.length;i++){
			btns[i]=new Button(i+"");
			getChildren().add(btns[i]);
		}*/
	
	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Widget_bar.fxml"));
	fxmlLoader.setRoot(this);
	fxmlLoader.setController(this);
	try {
		fxmlLoader.load();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}
