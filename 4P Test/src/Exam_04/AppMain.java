package Exam_04;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{
	
	
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp=new BorderPane();
		HBox hbox=new HBox();
		hbox.getChildren().add(new Button("��ư"));
		hbox.getChildren().add(new Button("��ư"));
		hbox.getChildren().add(new Button("��ư"));
		hbox.getChildren().add(new Button("��ư"));
		hbox.getChildren().add(new Button("��ư"));
		
		
		WidgetBar bar =new WidgetBar();
		
		
		bp.setTop(bar);
		bp.setCenter(new TextArea());
		Scene scene=new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	public static void main(String[] args) {
		launch(args);

	}	

}
