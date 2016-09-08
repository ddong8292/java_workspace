package four.person.web.browser.widgetbar.domain;


import java.net.URL;
import java.util.ResourceBundle;

import four.person.web.browser.main.AppMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

public class DomainController implements Initializable{
	@FXML HBox hboxDomain;
	@FXML TextField tfDomain;
	@FXML Button btnLoad, btnExit;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BackgroundFill backgroundFill = new BackgroundFill(AppMain.widgetBarBackground, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		tfDomain.setPrefWidth(AppMain.width - 55.0);
		hboxDomain.setBackground(background);
		btnExit.setOnAction(event->hideDoamin(event));
		tfDomain.setOnKeyPressed(event->loadDomain(event));
		tfDomain.setText(AppMain.webEngine.getLocation());
	}
	private void loadDomain(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER){
			String url = tfDomain.getText();
			if (url.contains("http://")) {
				AppMain.webEngine.load(tfDomain.getText());
			} else {
				AppMain.webEngine.load("http://" + tfDomain.getText());
			}
			String domain = AppMain.webEngine.getLocation();
			tfDomain.setText(domain);
		}
	}
	private void hideDoamin(ActionEvent event) {
		AppMain.webViewWrapper.getChildren().remove(hboxDomain);
	}
}
