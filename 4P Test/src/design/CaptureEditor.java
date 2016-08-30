package design;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CaptureEditor extends BorderPane implements Initializable {
	@FXML Button btn_capture;
	@FXML Button btn_Save;
	@FXML Button btn_Load;
	FileInputStream fis;
	FileOutputStream fos;
	@FXML Canvas canvas;
	@FXML VBox vbox;
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_capture.setOnMouseClicked(event -> btn_capture(event));
		btn_Save.setOnMouseClicked(event -> btn_Save(event));
		btn_Load.setOnMouseClicked(event -> btn_Load(event));
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
		right_img();
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
		//이미지 객체를 생성하고 생성한 객체의 주소 값을 ArrayList에 add
		for(int i=0; i<img.length; i++){
			Image image=new Image(img[i], 230.0, 450.0, true, true);
			ImageView iv = new ImageView(image);
			iv.setOnMouseClicked(event->ImageClickEvent(event));
			list.add(iv);
		}
		
		//이미지를 VBox
		for(int i=0; i<list.size(); i++){
			vbox.getChildren().add(list.get(i));
		}
	}

	private void ImageClickEvent(MouseEvent event) {
		double width = getWidth() - 250.0;
		double height = getHeight() - 50.0;
		ImageView obj = (ImageView)event.getSource();
		//obj.setFitHeight(height);
		//obj.setFitWidth(width);
		//Image canvasImg = new
		canvas.setWidth(width);
		canvas.setHeight(height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(obj.getImage(), 0.0, 0.0);
	}
}
