package four.person.web.browser.widgetbar;

import java.io.IOException;
import java.util.ArrayList;

import four.person.web.browser.capture.CaptureEditor;
import four.person.web.browser.main.AppMain;
import four.person.web.browser.settings.Settings;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class WidgetBarController{
	final double scrollMinPos = 0.0;
	final double scrollMaxPos = 100.0;
	double scrollCurPos = 0.0;
	WidgetBar widgetBar;
	ArrayList<WidgetButton> listBtn;
	WidgetRect prevRect = null;
	WidgetButton clickedBtn = null;
	
	ContextMenu widgetBarMenu, btnMenu, splitMenu;
	MenuItem[] widgetBarMenuItem, btnSizeMenuItem;
	MenuItem btnDeleteItem;
	RadioMenuItem[] splitRadioMenuItem;
	
	boolean isEdit = false;
	boolean isMaximize = true;
	
	public static Settings settings;
	public static CaptureEditor captureEditor;
	
	HBox hboxDomain;
	
	public WidgetBarController(WidgetBar widgetBar) {
		this.widgetBar = widgetBar;
		listBtn = widgetBar.listBtn;
		widgetBarMenu = widgetBar.widgetBarMenu;
		btnMenu = widgetBar.btnMenu;
		widgetBarMenuItem = widgetBar.widgetBarMenuItem;
		btnSizeMenuItem = widgetBar.btnSizeMenuItem;
		btnDeleteItem = widgetBar.btnDeleteMenuItem;
		splitMenu = widgetBar.splitMenu;
		splitRadioMenuItem = widgetBar.splitRadioMenuItem;

		for(int i=0; i<widgetBar.btnName.length; ++i){
			listBtn.get(i).setOnMouseClicked(event -> btnMouseClicked(event));
			listBtn.get(i).setOnMouseDragged(event -> btnMouseDragged(event));
			listBtn.get(i).setOnMouseReleased(event -> btnMouseReleased(event));
		}
        
		for(int i=0; i<widgetBarMenuItem.length; ++i){
			widgetBarMenuItem[i].setOnAction(event->widgetBarMenuHandler(event));
		}
		
		for(int i=0; i<btnSizeMenuItem.length; ++i){
			btnSizeMenuItem[i].setOnAction(event->btnSizeMenuHandler(event));
		}
		
		
		btnDeleteItem.setOnAction(event->btnDeleteHandler(event));
		
		splitRadioMenuItem[0].setOnAction(event->noSplitWebViewHandler(event));
		splitRadioMenuItem[1].setOnAction(event->twoSplitWebViewHandler(event));
		splitRadioMenuItem[2].setOnAction(event->fourSplitWebViewHandler(event));
		
		this.widgetBar.setOnMouseClicked(event->WidgetBarMouseRightClicked(event));
		this.widgetBar.setOnScroll(event->WidgetBarHorizontalScroll(event));
	}
	
	private void noSplitWebViewHandler(ActionEvent event) {
		//분할 없음
		System.out.println("분할 없음");
	}

	private void twoSplitWebViewHandler(ActionEvent event) {
		//2 분할
		System.out.println("2 분할");
	}

	private void fourSplitWebViewHandler(ActionEvent event) {
		//4 분할
		System.out.println("4 분할");
	}

	private void btnDeleteHandler(ActionEvent event) {
		int row = clickedBtn.getRow();
		int col = clickedBtn.getCol();
		WidgetRect targetRect = null;
		for(int i=0; i<WidgetBar.listRect.size(); ++i){
			if(row == WidgetBar.listRect.get(i).getRow() && col == WidgetBar.listRect.get(i).getCol()){
				targetRect = WidgetBar.listRect.get(i);
			}
		}
		int idxTargetRect = Integer.parseInt(targetRect.getId());
		if(clickedBtn.isBigger()){
			WidgetRect[] nearRect = new WidgetRect[4];
			nearRect[0] = WidgetBar.listRect.get(idxTargetRect);
			nearRect[1] = WidgetBar.listRect.get(idxTargetRect+1);
			nearRect[2] = WidgetBar.listRect.get(idxTargetRect+widgetBar.numOfRect);
			nearRect[3] = WidgetBar.listRect.get(idxTargetRect+widgetBar.numOfRect+1);		
			nearRect[0].setIsFill(false);
			nearRect[1].setIsFill(false);
			nearRect[2].setIsFill(false);
			nearRect[3].setIsFill(false);
		}else{
			WidgetBar.listRect.get(idxTargetRect).setIsFill(false);
		}
		widgetBar.getChildren().remove(clickedBtn);
		widgetBar.listBtn.remove(clickedBtn);
	}

	private void btnSizeMenuHandler(ActionEvent event) {
		Object obj = event.getSource();
		if(obj.equals(btnSizeMenuItem[0])){
			//크게
			int row = clickedBtn.getRow();
			int col = clickedBtn.getCol();
			WidgetRect targetRect = null;
			
			for(int i=0; i<WidgetBar.listRect.size(); ++i){
				WidgetRect r = WidgetBar.listRect.get(i);
				if(row == r.getRow() && col == r.getCol()){
					targetRect = r;
				}
			}
			int idxTargetRect = Integer.parseInt(targetRect.getId());

			boolean isFill = false;
			WidgetRect[] nearRect = new WidgetRect[4];
			if(targetRect.getRow() == 0 && idxTargetRect != widgetBar.numOfRect-1){
				//targetRect의 row가 0 일 때
				nearRect[0] = WidgetBar.listRect.get(idxTargetRect);
				nearRect[1] = WidgetBar.listRect.get(idxTargetRect + 1);
				nearRect[2] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect);
				nearRect[3] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect + 1);
			}else if(targetRect.getRow() == 1 && idxTargetRect != widgetBar.numOfRect-1){
				nearRect[0] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect);
				nearRect[1] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect + 1);
				nearRect[2] = WidgetBar.listRect.get(idxTargetRect);
				nearRect[3] = WidgetBar.listRect.get(idxTargetRect + 1);
			}else if(targetRect.getRow() == 0 && idxTargetRect == widgetBar.numOfRect-1){
				nearRect[0] = WidgetBar.listRect.get(idxTargetRect - 2);
				nearRect[1] = WidgetBar.listRect.get(idxTargetRect - 1);
				nearRect[2] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect - 2);
				nearRect[3] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect - 1);
			}else if(targetRect.getRow() == 1 && idxTargetRect == widgetBar.numOfRect-1){
				nearRect[0] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect - 2);
				nearRect[1] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect - 1);
				nearRect[2] = WidgetBar.listRect.get(idxTargetRect - 2);
				nearRect[3] = WidgetBar.listRect.get(idxTargetRect - 1);
			}
			// 주변에 빈 공간이 있는 지 확인
			for (int i = 1; i < nearRect.length; ++i) {
				if (nearRect[i].getIsFill()) {
					isFill = true;
				}
			}
			if (!isFill) {
				clickedBtn.setBigger(true);
				clickedBtn.setSize(55.0);
				clickedBtn.setPrefSize(clickedBtn.getSize(), clickedBtn.getSize());
				nearRect[0].setIsFill(true);
				nearRect[1].setIsFill(true);
				nearRect[2].setIsFill(true);
				nearRect[3].setIsFill(true);
				if(idxTargetRect != widgetBar.numOfRect-1){
					clickedBtn.setLayoutX(WidgetBar.listRect.get(idxTargetRect).getLayoutX());
					clickedBtn.setLayoutY(WidgetBar.listRect.get(idxTargetRect).getLayoutY());
				}else{
					clickedBtn.setLayoutX(WidgetBar.listRect.get(idxTargetRect-1).getLayoutX());
					clickedBtn.setLayoutY(WidgetBar.listRect.get(idxTargetRect-1).getLayoutY());
				}
			} else {
				clickedBtn.setBigger(true);
				clickedBtn.setSize(55.0);
				clickedBtn.setPrefSize(clickedBtn.getSize(), clickedBtn.getSize());
				//빈 공간이 없을 때 빈 공간을 찾기
				for(int i=0; i<widgetBar.numOfRect-1; ++i){
					nearRect[0] = WidgetBar.listRect.get(i);
					nearRect[1] = WidgetBar.listRect.get(i + 1);
					nearRect[2] = WidgetBar.listRect.get(i + widgetBar.numOfRect);
					nearRect[3] = WidgetBar.listRect.get(i + widgetBar.numOfRect + 1);
					if(targetRect.equals(nearRect[0])){
						if (!nearRect[1].getIsFill() && !nearRect[2].getIsFill() && !nearRect[3].getIsFill()) {
							nearRect[1].setIsFill(true);
							nearRect[2].setIsFill(true);
							nearRect[3].setIsFill(true);
							
							clickedBtn.setLayoutX(WidgetBar.listRect.get(i).getLayoutX());
							clickedBtn.setLayoutY(WidgetBar.listRect.get(i).getLayoutY());
							clickedBtn.setCol(nearRect[0].getCol());
							clickedBtn.setRow(nearRect[0].getRow());
							break;
						}
					}else{
						if (!nearRect[0].getIsFill() && !nearRect[1].getIsFill() && !nearRect[2].getIsFill() && !nearRect[3].getIsFill()) {
							targetRect.setIsFill(false);
							nearRect[0].setIsFill(true);
							nearRect[1].setIsFill(true);
							nearRect[2].setIsFill(true);
							nearRect[3].setIsFill(true);
							
							clickedBtn.setLayoutX(WidgetBar.listRect.get(i).getLayoutX());
							clickedBtn.setLayoutY(WidgetBar.listRect.get(i).getLayoutY());
							clickedBtn.setCol(nearRect[0].getCol());
							clickedBtn.setRow(nearRect[0].getRow());
							break;
						}
					}
				}
			}
		}else if(obj.equals(btnSizeMenuItem[1])){
			//작게
			int row = clickedBtn.getRow();
			int col = clickedBtn.getCol();
			WidgetRect targetRect = null;
			
			for(int i=0; i<WidgetBar.listRect.size(); ++i){
				WidgetRect r = WidgetBar.listRect.get(i);
				if(row == r.getRow() && col == r.getCol()){
					targetRect = r;
				}
			}	
			int idxTargetRect = Integer.parseInt(targetRect.getId());

			WidgetRect[] nearRect = new WidgetRect[3];
			nearRect[0] = WidgetBar.listRect.get(idxTargetRect + 1);
			nearRect[1] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect);
			nearRect[2] = WidgetBar.listRect.get(idxTargetRect + widgetBar.numOfRect + 1);
			
			for(int i=0; i<nearRect.length; ++i){
				nearRect[i].setIsFill(false);
			}
			
			clickedBtn.setBigger(false);
			clickedBtn.setSize(25.0);
			clickedBtn.setPrefSize(clickedBtn.getSize(), clickedBtn.getSize());
		}
	}

	private void WidgetBarHorizontalScroll(ScrollEvent event) {
		 if (event.getDeltaY() > 0){
			 if(scrollCurPos <= scrollMinPos)
				 widgetBar.root.topScroll.setHvalue(scrollMinPos);
			 else
				 widgetBar.root.topScroll.setHvalue(scrollCurPos = scrollCurPos-0.25);
		 }
         else{
        	 if(scrollCurPos >= scrollMaxPos)
				 widgetBar.root.topScroll.setHvalue(scrollMaxPos);
			 else
				 widgetBar.root.topScroll.setHvalue(scrollCurPos = scrollCurPos+0.25);
         }
	}

	private void btnMouseClicked(MouseEvent event) {
		clickedBtn = (WidgetButton)event.getSource();
		if(event.getButton() == MouseButton.PRIMARY && isEdit == false){
			switch (clickedBtn.getId()) {
			case "close":
				browserClose();
				break;
			case "resize":
				browserResize(clickedBtn);
				break;
			case "minimize":
				browserMinimize();
				break;
			case "split":
				splitMenu.show(clickedBtn, event.getScreenX(), event.getScreenY());
				break;
			case "domain":
				showInputDomain();
				break;
			case "capture":
				showCaptureEditor();
				break;
			}
		}else if(event.getButton() == MouseButton.SECONDARY && isEdit == true){
			if(clickedBtn.isBigger()){
				//크면
				btnSizeMenuItem[0].setDisable(true);
				btnSizeMenuItem[1].setDisable(false);
			}else{
				//작으면
				btnSizeMenuItem[0].setDisable(false);
				btnSizeMenuItem[1].setDisable(true);
			}
			btnMenu.show(clickedBtn, event.getScreenX(), event.getScreenY());
		}
	}
	private void showCaptureEditor() {
		WritableImage image = AppMain.webView.snapshot(new SnapshotParameters(), null);	
		if(captureEditor == null){
			captureEditor = new CaptureEditor(image);
		}
		AppMain.center.getChildren().add(captureEditor);
	}

	private void showInputDomain(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("domain/domain.fxml"));
		HBox hboxDomain = null;
		if(hboxDomain == null){
			try {
				hboxDomain = fxmlLoader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		AppMain.webViewWrapper.setTop(hboxDomain);
	}
	private void browserMinimize() {
		AppMain.stage.setIconified(true);
	}

	private void browserResize(WidgetButton btn) {
		if(isMaximize == true){
			btn.setStyle("-fx-background-image: url('//res/icons/resize_max.png');");
			AppMain.stage.setWidth(AppMain.DEFAULT_WIDTH);
			AppMain.stage.setHeight(AppMain.DEFAULT_HEIGHT);
			isMaximize = false;
		}else{
			btn.setStyle("-fx-background-image: url('//res/icons/resize.png');");
			AppMain.stage.setWidth(AppMain.width);
			AppMain.stage.setHeight(AppMain.height);
			isMaximize = true;
		}
	}

	private void browserClose() {
		Platform.exit();
	    System.exit(0);
	}

	private void WidgetBarMouseRightClicked(MouseEvent event) {
		if(event.getButton() == MouseButton.SECONDARY){
			widgetBarMenu.show(widgetBar, event.getScreenX(), event.getScreenY());
		}else if(event.getButton() == MouseButton.PRIMARY){
			widgetBarMenu.hide();
		}
	}

	private void btnMouseReleased(MouseEvent event) {
		if(isEdit == false)
			return;
		if(event.getButton() == MouseButton.SECONDARY)
			return;
		
		WidgetButton btn = (WidgetButton)event.getSource();
		if(!btn.isBigger()){
			double btnX = btn.getLayoutX();
			double btnY = btn.getLayoutY();
			double minDist = Double.MAX_VALUE;
			WidgetRect targetRect = null;
			WidgetButton targetBtn = null;

			for (int i = 0; i < WidgetBar.listRect.size(); ++i) {
				WidgetRect rect = WidgetBar.listRect.get(i);
				double rectX = rect.getLayoutX();
				double rectY = rect.getLayoutY();
				double dist = Math.sqrt(Math.pow(rectX - btnX, 2.0) + Math.pow(rectY - btnY, 2.0));
				if (minDist > dist) {
					minDist = dist;
					targetRect = rect;
				}
			}
			for (int i = 0; i < listBtn.size(); ++i) {
				if (listBtn.get(i).getRow() == targetRect.getRow() && listBtn.get(i).getCol() == targetRect.getCol()) {
					targetBtn = listBtn.get(i);
				}
			}
			if (prevRect == null) {
				return;
			}
			
			if (targetRect.getIsFill()) {
				btn.setLayoutX(targetRect.getLayoutX());
				btn.setLayoutY(targetRect.getLayoutY());
				btn.setRow(targetRect.getRow());
				btn.setCol(targetRect.getCol());
				targetBtn.setLayoutX(prevRect.getLayoutX());
				targetBtn.setLayoutY(prevRect.getLayoutY());
				targetBtn.setRow(prevRect.getRow());
				targetBtn.setCol(prevRect.getCol());
				prevRect = null;
			} else {
				btn.setLayoutX(targetRect.getLayoutX());
				btn.setLayoutY(targetRect.getLayoutY());
				btn.setRow(targetRect.getRow());
				btn.setCol(targetRect.getCol());
				targetRect.setIsFill(true);
				prevRect.setIsFill(false);
				prevRect = null;
			}
		}else{
			double btnX = btn.getLayoutX();
			double btnY = btn.getLayoutY();
			double minDist = Double.MAX_VALUE;
			WidgetRect targetRect = null;
			int idxPrevRect = Integer.parseInt(prevRect.getId());

			for (int i = 0; i < widgetBar.numOfRect; ++i) {
				WidgetRect rect = WidgetBar.listRect.get(i);
				double rectX = rect.getLayoutX();
				double rectY = rect.getLayoutY();
				double dist = Math.sqrt(Math.pow(rectX - btnX, 2.0) + Math.pow(rectY - btnY, 2.0));
				if (minDist > dist) {
					minDist = dist;
					targetRect = rect;
				}
			}
			WidgetRect[] nearRect = new WidgetRect[4];
			int idxTargetRect = Integer.parseInt(targetRect.getId());
			nearRect[0] = WidgetBar.listRect.get(idxTargetRect);
			nearRect[1] = WidgetBar.listRect.get(idxTargetRect+1);
			nearRect[2] = WidgetBar.listRect.get(idxTargetRect+widgetBar.numOfRect);
			nearRect[3] = WidgetBar.listRect.get(idxTargetRect+widgetBar.numOfRect+1);
			
			ArrayList<WidgetButton> nearBtn = new ArrayList<WidgetButton>();
			
			for (int i = 0; i < listBtn.size(); ++i) {
				if(listBtn.get(i).equals(btn))
					continue;
				for(int j=0; j<nearRect.length; ++j){
					if (listBtn.get(i).getRow() == nearRect[j].getRow() && listBtn.get(i).getCol() == nearRect[j].getCol()) {
						nearBtn.add(listBtn.get(i));
					}
				}
			}
			if(nearBtn.size() == 0){
				for(int i=0; i<nearRect.length; ++i){
					nearRect[i].setIsFill(true);
				}
				btn.setRow(nearRect[0].getRow());
				btn.setCol(nearRect[0].getCol());
				btn.setLayoutX(nearRect[0].getLayoutX());
				btn.setLayoutY(nearRect[0].getLayoutY());
				WidgetBar.listRect.get(idxPrevRect).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+1).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).setIsFill(false);
				prevRect = null;
			}else{
				for(int i=0; i<nearRect.length; ++i){
					nearRect[i].setIsFill(true);
				}
				btn.setRow(nearRect[0].getRow());
				btn.setCol(nearRect[0].getCol());
				btn.setLayoutX(nearRect[0].getLayoutX());
				btn.setLayoutY(nearRect[0].getLayoutY());
				WidgetBar.listRect.get(idxPrevRect).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+1).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).setIsFill(false);
				WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).setIsFill(false);
				
				for(int i=0; i<nearBtn.size(); ++i){
					if(i == 0){
						if(idxPrevRect- idxTargetRect == 1){
							WidgetBar.listRect.get(idxPrevRect+1).setIsFill(true);
							nearBtn.get(i).setRow(WidgetBar.listRect.get(idxPrevRect+1).getRow());
							nearBtn.get(i).setCol(WidgetBar.listRect.get(idxPrevRect+1).getCol());
							nearBtn.get(i).setLayoutX(WidgetBar.listRect.get(idxPrevRect+1).getLayoutX());
							nearBtn.get(i).setLayoutY(WidgetBar.listRect.get(idxPrevRect+1).getLayoutY());
						}else{
							WidgetBar.listRect.get(idxPrevRect).setIsFill(true);
							nearBtn.get(i).setRow(WidgetBar.listRect.get(idxPrevRect).getRow());
							nearBtn.get(i).setCol(WidgetBar.listRect.get(idxPrevRect).getCol());
							nearBtn.get(i).setLayoutX(WidgetBar.listRect.get(idxPrevRect).getLayoutX());
							nearBtn.get(i).setLayoutY(WidgetBar.listRect.get(idxPrevRect).getLayoutY());
						}
					}else if(i == 1){
						WidgetBar.listRect.get(idxPrevRect+1).setIsFill(true);
						nearBtn.get(i).setRow(WidgetBar.listRect.get(idxPrevRect+1).getRow());
						nearBtn.get(i).setCol(WidgetBar.listRect.get(idxPrevRect+1).getCol());
						nearBtn.get(i).setLayoutX(WidgetBar.listRect.get(idxPrevRect+1).getLayoutX());
						nearBtn.get(i).setLayoutY(WidgetBar.listRect.get(idxPrevRect+1).getLayoutY());
					}else if(i == 2){
						WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).setIsFill(true);
						nearBtn.get(i).setRow(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).getRow());
						nearBtn.get(i).setCol(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).getCol());
						nearBtn.get(i).setLayoutX(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).getLayoutX());
						nearBtn.get(i).setLayoutY(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect).getLayoutY());
					}else{
						WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).setIsFill(true);
						nearBtn.get(i).setRow(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).getRow());
						nearBtn.get(i).setCol(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).getCol());
						nearBtn.get(i).setLayoutX(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).getLayoutX());
						nearBtn.get(i).setLayoutY(WidgetBar.listRect.get(idxPrevRect+widgetBar.numOfRect+1).getLayoutY());
					}
				}
				prevRect = null;
			}
		}
		
	}

	private void btnMouseDragged(MouseEvent event) {
		if(isEdit == false)
			return;
		if(event.getButton() == MouseButton.SECONDARY)
			return;
		
		WidgetButton btn = (WidgetButton)event.getSource();
		if (!btn.isBigger()) {
			int row = btn.getRow();
			int col = btn.getCol();
			if (prevRect == null) {
				for (int i = 0; i < WidgetBar.listRect.size(); ++i) {
					if (WidgetBar.listRect.get(i).getRow() == row && WidgetBar.listRect.get(i).getCol() == col) {
						prevRect = WidgetBar.listRect.get(i);
					}
				}
			}
			btn.toFront();
			if (event.getSceneY() + (btn.getHeight() / 2) >= widgetBar.height) {
				btn.setLayoutY(widgetBar.height - btn.getSize());
			} else {
				btn.setLayoutY(event.getSceneY() - (btn.getHeight() / 2));
			}
			btn.setLayoutX(event.getSceneX() - (btn.getWidth() / 2));
		}else{
			int row = btn.getRow();
			int col = btn.getCol();
			if (prevRect == null) {
				for (int i = 0; i < WidgetBar.listRect.size(); ++i) {
					if (WidgetBar.listRect.get(i).getRow() == row && WidgetBar.listRect.get(i).getCol() == col) {
						prevRect = WidgetBar.listRect.get(i);
					}
				}
			}
			btn.toFront();
			if (event.getSceneY() + (btn.getHeight() / 2) >= widgetBar.height) {
				btn.setLayoutY(widgetBar.height - btn.getSize());
			} else {
				btn.setLayoutY(event.getSceneY() - (btn.getHeight() / 2));
			}
			btn.setLayoutX(event.getSceneX() - (btn.getWidth() / 2));
		}
	}
	
	private void widgetBarMenuHandler(ActionEvent event) {
		Object obj = event.getSource();
		if(obj.equals(widgetBarMenuItem[0])){
			if(isEdit == false){
				isEdit = true;
				startEditWidgetBar();
			}else{
				isEdit = false;
				endEditWidgetBar();
			}
		}else if(obj.equals(widgetBarMenuItem[1])){
			if(settings == null){
				settings = new Settings();
			}
			AppMain.center.getChildren().add(settings);
		}
	}
	private void endEditWidgetBar() {
		widgetBarMenuItem[0].setText("편집");
		for(int i=0; i<WidgetBar.listRect.size(); ++i){
			WidgetBar.listRect.get(i).setStyle("-fx-stroke-dash-array: 2 3 2 3; -fx-stroke-width: 0; -fx-stroke: black;"); 
			WidgetBar.listRect.get(i).setStroke(Color.TRANSPARENT);
		}
	}

	private void startEditWidgetBar(){
		widgetBarMenuItem[0].setText("편집 종료");
		for(int i=0; i<WidgetBar.listRect.size(); ++i){
			WidgetBar.listRect.get(i).setStyle("-fx-stroke-dash-array: 2 3 2 3; -fx-stroke-width: 0.8; -fx-stroke: black;"); 
		}
	}
}
