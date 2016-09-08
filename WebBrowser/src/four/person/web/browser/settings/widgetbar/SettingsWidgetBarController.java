package four.person.web.browser.settings.widgetbar;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

import four.person.web.browser.main.AppMain;
import four.person.web.browser.widgetbar.WidgetBar;
import javafx.beans.binding.When;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SettingsWidgetBarController implements Initializable{
	@FXML RadioButton radBtnMinHeigth, radBtnMaxHeigth;
	@FXML Button btnApply;
	@FXML ColorPicker colorPicker;
	ToggleGroup tgWidgetBarHeight;
	int widgetHeight;
	
	public SettingsWidgetBarController() {
		tgWidgetBarHeight = new ToggleGroup();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radBtnMinHeigth.setToggleGroup(tgWidgetBarHeight);
		radBtnMinHeigth.setUserData(1);
		radBtnMaxHeigth.setToggleGroup(tgWidgetBarHeight);
		radBtnMaxHeigth.setUserData(2);
		
		tgWidgetBarHeight.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				widgetHeight = Integer.parseInt(newValue.getUserData().toString());
			}
		});
		btnApply.setOnAction(event->changeWidgetBarHeight(event));
		
		if(AppMain.WidgetHeight == 1){
			tgWidgetBarHeight.selectToggle(radBtnMinHeigth);
		}else{
			tgWidgetBarHeight.selectToggle(radBtnMaxHeigth);
		}
		colorPicker.setOnAction(event->WidgetBarColorChange(event));
		colorPicker.setValue(Color.WHITE);
	}

	private void WidgetBarColorChange(ActionEvent event) {
		Paint fill = colorPicker.getValue();
		BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		WidgetBar.widgetBar.setBackground(background);
	}

	private void changeWidgetBarHeight(ActionEvent event) {
		AppMain.WidgetHeight = this.widgetHeight;
		WidgetBar.widgetBar.changeWidgetBarHeight();
	}
}
