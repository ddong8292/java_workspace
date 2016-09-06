package four.person.web.browser.capture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import four.person.web.browser.main.AppMain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CaptureEditor extends BorderPane implements Initializable {
	@FXML Button btn_capture;
	@FXML Button btn_Save;
	@FXML Button btn_Load;
	@FXML Button btn_Pen;
	@FXML Button btn_Eraser;
	@FXML ColorPicker colorPicker;
	@FXML Button btn_Text;
	FileInputStream fis;
	FileOutputStream fos;
	GraphicsContext gc;
	@FXML Canvas canvas;
	@FXML VBox vbox;
	boolean isPen = false;
	boolean iseraser=false;
	boolean isInputText = false;
	Image image_pen, image_eraser;
	@FXML AnchorPane anchorPane;
	@FXML StackPane stackPane;
	Color color = Color.BLACK;
	Label label;
	TextField text;
	int strLength;
	TextArea ta;
	
	int x = 0;
	int y = 0;

	ArrayList<ImageView>list=new ArrayList<ImageView>();
	ArrayList<TextArea>textdate=new ArrayList<TextArea>();
	ArrayList<File>imgfile=new ArrayList<File>();
	WritableImage image;
	public CaptureEditor(WritableImage image) {//���� �޼���
		this.image = image;
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
		image_pen= new Image(getClass().getClassLoader().getResource("capture/pen_use.png").toExternalForm());
		image_eraser=new Image(getClass().getClassLoader().getResource("capture/eraser_use.png").toExternalForm());
		//addCaptureImage();
	}
	public void initialize(URL location, ResourceBundle resources) {
		colorPicker.setValue(Color.BLACK);
		btn_Save.setOnMouseClicked(event -> btn_Save(event));
		btn_Load.setOnMouseClicked(event -> btn_Load(event));
		btn_Pen.setOnMouseClicked(event->btn_pen(event));
		canvas.setOnMousePressed(event->penMousePressed(event));
		canvas.setOnMouseDragged(event->penMouseDragged(event));
		canvas.setOnMouseReleased(event->penMouseReleased(event));
		anchorPane.setOnMouseClicked(event->addTextArea(event));
		btn_Eraser.setOnMouseClicked(event->eraser(event));
		colorPicker.setOnAction(event->colorChange(event));
		btn_Text.setOnMouseClicked(event->inputText(event));
		
		stackPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				canvas.setWidth(Double.parseDouble(newValue.toString()));
				//gc.drawImage(image, x, y, canvas.getWidth(), canvas.getHeight());
			}
		});
		stackPane.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				canvas.setHeight(Double.parseDouble(newValue.toString()));
				gc.drawImage(image, x, y, canvas.getWidth(), canvas.getHeight());
			}
		});
	}


	private void addTextArea(MouseEvent event) {
		if(isInputText == true){
			strLength = 0;
			ta = new TextArea();
			textdate.add(ta);
			int idx = textdate.size()-1;
			String rgbColor = String.format("#%02X%02X%02X", (int) (color.getRed() * 255),
					(int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
			ta.setStyle("-fx-text-fill:  "+rgbColor);
			ta.setPrefSize(70, 30);
			ta.setLayoutX(event.getX());
			ta.setLayoutY(event.getY());
			ta.setId("input_text");
			anchorPane.getChildren().add(ta);
			ta.requestFocus();
			
			ta.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					System.out.println(newValue.toString());
					if(oldValue == true){
						textdate.get(idx).setStyle("-fx-border-width: 0px;");
						//ta.setDisable(true);
					}
				}
			});
			
			ta.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if(event.getCode() == KeyCode.ENTER ){
						System.out.println(event.getCode());
						double oldValue = ta.getHeight();
						if(ta.getHeight() >= 30.0){
							ta.setPrefHeight(oldValue + 30.0);
							strLength = 0;
						}
					}else{
						strLength++;
						if(ta.getWidth() < 70+(strLength)*12){
							ta.setPrefWidth( 70.0 +(strLength)*12);
						}
					}
				}
			});
		}
	
	}

	private void inputText(MouseEvent event) {
		isInputText = !isInputText;
		if(isInputText == true){
			anchorPane.toFront();
		}
		isPen=false;
		iseraser=false;
		if(isInputText==true){
			AppMain.scene.setCursor(Cursor.TEXT);
		}else{
			AppMain.scene.setCursor(Cursor.DEFAULT);
		}
	}

	private void colorChange(ActionEvent event) {
		color = colorPicker.getValue();

		int idx = textdate.size()-1;
		if(isInputText == true){
			
			String rgbColor = String.format("#%02X%02X%02X", (int) (color.getRed() * 255),
					(int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
			textdate.get(idx).setStyle("-fx-text-fill:  "+rgbColor);
		}
		
	}

	private void penMousePressed(MouseEvent event) {
		double x = event.getX();
		double y = event.getY() ;
		if(isPen == true){
			gc.setStroke(color);
			gc.setLineWidth(3);
			gc.beginPath();
			gc.moveTo(x, y);
		}
		if(iseraser == true){	//���찳ȿ��
			gc.setStroke(Color.WHITE);
			gc.setLineWidth(8);
			gc.beginPath();
			gc.moveTo(x, y);
		}
	}

	private void penMouseDragged(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		if(isPen == true){
		    gc.lineTo(x, y);
		    gc.stroke();
		}
		if(iseraser == true){
			 gc.lineTo(x, y);
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
		if(isPen == true){
			canvas.toFront();
		}else{
			canvas.toBack();
		}
		iseraser=false;
		isInputText=false;
		
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
		if(iseraser == true){
			canvas.toFront();
		}else{
			canvas.toBack();
		}
		isPen=false;
		isInputText=false;
		//���찳 Ŀ�� �����ϱ�
		if(iseraser==true){
			AppMain.scene.setCursor(new ImageCursor(image_eraser));
		}else{
			AppMain.scene.setCursor(Cursor.DEFAULT);
		}
	}


	private void btn_Save(MouseEvent event) {
		saveFile();
	}
	public void saveFile(){
		String path = "C:/4p/test.png";
		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		WritableImage sanpshotImage = stackPane.snapshot(parameters, null);
		File file = new File(path);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(sanpshotImage, null), "png", file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void btn_Load(MouseEvent event) {
		
		
				
	}
	public void right_img(){
		
		//���� ��ü�� ������ ���� ��θ� �Ű����� �־ ����
		File folder=new File("C:/4p");
		//���� �迭�� �����ϰ� ���� ������ ���� ��ü�� listFiles �޼��� ȣ���Ͽ� �ʱ�ȭ.
		File[] listOfFiles=folder.listFiles();
		//�ܼ�â�� ���� �̸� ���.
		//System.out.println(listOfFiles);
		
		//�̹��� ��ü�� �����ϰ� ������ ��ü�� �ּ� ���� ArrayList�� add
		for(int i=0; i<listOfFiles.length; i++){
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
