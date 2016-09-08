package four.person.web.browser.settings.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SettingsBasicController implements Initializable{
	//settings_basic.fxml
	@FXML RadioButton radBtnDefault, radBtnCustom;
	@FXML TextField tfDomain;
	ToggleGroup tgBasic;
	public SettingsBasicController() {
		tgBasic = new ToggleGroup();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//기본 설정 페이지 이벤트
		radBtnDefault.setToggleGroup(tgBasic);
		radBtnCustom.setToggleGroup(tgBasic);
		
		tgBasic.selectToggle(radBtnDefault);
	}

}
