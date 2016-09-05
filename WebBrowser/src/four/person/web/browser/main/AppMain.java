package four.person.web.browser.main;

import four.person.web.browser.widgetbar.WidgetBar;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppMain extends Application {
	public static Stage stage;
	public static double DEFAULT_WIDTH = 700;
	public static double DEFAULT_HEIGHT = 700;
	public static BorderPane root = new BorderPane();
	public static StackPane center = new StackPane();
	public static BorderPane webViewWrapper = new BorderPane();
	public static double width;
	public static double height;
	public static ScrollPane topScroll;
	public WidgetBar widgetBar;
	public static int WidgetHeight = 1;
	public double x;
	public double y;
	public static Color widgetBarBackground = Color.WHITE;
	public static WebView webView = new WebView();
	public static WebEngine webEngine = webView.getEngine();
	public static Scene scene;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		stage = primaryStage;
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();	
		
		x = primaryScreenBounds.getMinX();
		y = primaryScreenBounds.getMinY();
		width = primaryScreenBounds.getWidth();
		height = primaryScreenBounds.getHeight();
		
		widgetBar = new WidgetBar(this);
		topScroll = new ScrollPane(widgetBar);
		topScroll.setFitToWidth(false);
		topScroll.setFitToHeight(true);
		topScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
		topScroll.getStylesheets().add(getClass().getResource("scroll.css").toString());
		
		//WebView webView = new WebView();
		//WebEngine webEngine = webView.getEngine();
		webEngine.load("http://naver.com");
		webViewWrapper.setCenter(webView);
		//center.getChildren().add(webView);
		center.getChildren().add(webViewWrapper);
		root.setTop(widgetBar);
		root.setCenter(center);
		root.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setX(x);
		primaryStage.setY(y);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
