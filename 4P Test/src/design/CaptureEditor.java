package design;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CaptureEditor extends BorderPane implements Initializable {
	@FXML Button btn_capture;
	@FXML Button btn_Save;
	@FXML Button btn_Load;
	@FXML Button btn_Pen;
	@FXML Button btn_Eraser;
	@FXML ColorPicker colorPicker;
	FileInputStream fis;
	FileOutputStream fos;
	GraphicsContext gc;
	@FXML Canvas canvas;
	@FXML VBox vbox;
	boolean isPen = false;
	boolean iseraser=false;
	Image image_pen, image_eraser;
	StackPane stackPane;
	Color color = Color.BLACK;
	
	int x = 0;
	int y = 0;
	String[] img={
			"file:///C:/java_workspace/DB0829/res/1.jpg"
			,"file:///C:/java_workspace/DB0829/res/7.jpg"
			,"file:///C:/java_workspace/DB0829/res/3.jpg"
			,"file:///C:/java_workspace/DB0829/res/4.jpg"
			,"file:///C:/java_workspace/DB0829/res/5.jpg"
			,"file:///C:/java_workspace/DB0829/res/6.jpg"
	};
	ArrayList<ImageView>list=new ArrayList<ImageView>();
	
	public CaptureEditor() {//���� �޼���
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("capture_editor.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
			this.getStylesheets().add(getClass().getResource("capture.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		gc = canvas.getGraphicsContext2D();
		right_img();
		image_pen= new Image(getClass().getClassLoader().getResource("pen.png").toExternalForm());
		image_eraser=new Image(getClass().getClassLoader().getResource("eraser.png").toExternalForm());
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		btn_capture.setOnMouseClicked(event -> btn_capture(event));
		btn_Save.setOnMouseClicked(event -> btn_Save(event));
		btn_Load.setOnMouseClicked(event -> btn_Load(event));
		btn_Pen.setOnMouseClicked(event->btn_pen(event));
		canvas.setOnMousePressed(event->penMousePressed(event));
		canvas.setOnMouseDragged(event->penMouseDragged(event));
		canvas.setOnMouseReleased(event->penMouseReleased(event));
		btn_Eraser.setOnMouseClicked(event->eraser(event));
		colorPicker.setOnAction(event->colorChange(event));
	}



	private void colorChange(ActionEvent event) {
		color = colorPicker.getValue();
	}

	private void penMousePressed(MouseEvent event) {
		double x = event.getX();
		double y = event.getY() ;
		if(isPen == true){
			gc.setStroke(color);
			gc.setLineWidth(3);
			gc.beginPath();
			gc.moveTo(x, y + 27.0);
		}
		if(iseraser == true){	//���찳ȿ��
			gc.setStroke(Color.WHITE);
			gc.setLineWidth(8);
			gc.beginPath();
			gc.moveTo(x, y+27.0);
		}
	}

	private void penMouseDragged(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		if(isPen == true){
		    gc.lineTo(x, y+ 27.0);
		    gc.stroke();
		}
		if(iseraser == true){
			 gc.lineTo(x, y+27.0);
			 gc.stroke();
		}
	}
	private void penMouseReleased(MouseEvent event) {
		if(isPen == true){
			gc.closePath();
		}else{
			gc.closePath();
		}
	}

	private void btn_pen(MouseEvent event) {
		isPen = !isPen;
		iseraser=false;
		
		//�� Ŀ�� �����ϱ�
		//Scene scene=new Scene(this);
		if(isPen == true){
			AppMain.scene.setCursor(new ImageCursor(image_pen));
		}else{
			AppMain.scene.setCursor(Cursor.DEFAULT);
		}
		
		
	}
	
	private void eraser(MouseEvent event) {
		iseraser = !iseraser;
		isPen=false;
		
		//���찳 Ŀ�� �����ϱ�
		if(iseraser==true){
			AppMain.scene.setCursor(new ImageCursor(image_eraser));
		}else{
			AppMain.scene.setCursor(Cursor.DEFAULT);
		}
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
		gc.drawImage(image, 0.0, 0.0);
	}

	private void btn_Save(MouseEvent event) {
		String path = "C:/Users/student/Downloads/game2.png";
		File file = new File("C:/Users/student/Downloads/game.png");
		//System.out.println(file.getName());
		
		try {
			fis=new FileInputStream(file);
			fos=new FileOutputStream(path);
			int data;
			byte[] b = new byte[1024];
			while((data=fis.read(b))!=-1){
				//System.out.println(data);
				fos.write(b);
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if(fos !=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void btn_Load(MouseEvent event) {
		
		
				
	}
	public void right_img(){
		//�̹��� ��ü�� �����ϰ� ������ ��ü�� �ּ� ���� ArrayList�� add
		for(int i=0; i<img.length; i++){
			Image image=new Image(img[i], 230.0, 450.0, true, true);
			ImageView iv = new ImageView(image);
			iv.setId(i+"");
			iv.setOnMouseClicked(event->ImageClickEvent(event));
			list.add(iv);
		}
		
		//�̹����� VBox
		for(int i=0; i<list.size(); i++){
			vbox.getChildren().add(list.get(i));
		}
	}
	private void ImageClickEvent(MouseEvent event) {
		double width = getWidth() - 250.0;
		double height = getHeight() - 50.0;
		ImageView obj = (ImageView)event.getSource();

		Image canvasImg = new Image(img[Integer.parseInt(obj.getId())], width, height, true, true);
		canvas.setWidth(width);
		canvas.setHeight(height);
		
		gc.drawImage(canvasImg, 0.0, 0.0);
		
	}
}
