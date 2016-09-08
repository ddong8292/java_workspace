package four.person.web.browser.widgetbar;

import java.util.ArrayList;

import four.person.web.browser.main.AppMain;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class WidgetBar extends AnchorPane{
	public static WidgetBar widgetBar;
	public final static double rectSize = 25.0;
	public final static double padding = 10.0;
	public final static double btnPadding = 5.0;
	public final static String ext = ".png";
	public static ArrayList<WidgetRect> listRect = new ArrayList<WidgetRect>();
	public static ArrayList<WidgetButton> listBtn = new ArrayList<WidgetButton>();
	public static int numOfRect;
	double height;
	double width;
	double alignCenter;
	AppMain root;

	
	String[] btnName = {
			"close",
			"resize",
			"minimize",
			"split",
			"add",
			"domain",
			"home",
			"music",
			"next",
			"prev",
			"refresh",
			"weather",
			"pin",
			"capture"
	};
	
	ContextMenu widgetBarMenu, btnMenu, splitMenu;
	Menu btnSizeMenu;
	MenuItem[] widgetBarMenuItem, btnSizeMenuItem;
	MenuItem btnDeleteMenuItem;
	String[] widgetBarMenuName = {"����", "����"};
	String[] btnSizeMenuName = {"ũ��", "�۰�"};
	String[] splitBtnMenuName = {"���� ����", "2 ����", "4 ����"};
	ToggleGroup splitToggleGroup = new ToggleGroup();
	RadioMenuItem[] splitRadioMenuItem;
		
	WidgetBarController widgetBarController;
			
	public WidgetBar(AppMain root) {
		widgetBar = this;
        this.root = root;
        this.width = root.width - 2*padding;
        if(AppMain.WidgetHeight == 1){
        	this.height = AppMain.WidgetHeight*rectSize + padding*2;
        }else{
        	this.height = AppMain.WidgetHeight*rectSize + btnPadding + padding*2;
        }
		
        this.numOfRect = (int)Math.floor(width/(rectSize+btnPadding));
        this.alignCenter  = (root.width - (rectSize+btnPadding)*numOfRect)/2;
		
		this.widgetBarMenu = new ContextMenu();
		this.widgetBarMenu.setPrefWidth(200.0);
		this.widgetBarMenuItem = new MenuItem[widgetBarMenuName.length];
		
		this.btnMenu = new ContextMenu();
		this.btnSizeMenu = new Menu("ũ�� ����");
		this.btnDeleteMenuItem = new MenuItem("����");
		this.btnSizeMenuItem = new MenuItem[btnSizeMenuName.length];
		
		this.splitMenu = new ContextMenu();
		this.splitToggleGroup = new ToggleGroup();
		this.splitRadioMenuItem = new RadioMenuItem[splitBtnMenuName.length];
		
		this.setPrefHeight(height);
		this.setPrefWidth(root.width-2.0);
		this.setStyle("-fx-background-color: #F0F0F0;");

		for(int i=0; i<AppMain.WidgetHeight; ++i){
			for(int j=0; j<numOfRect; ++j){
				WidgetRect r = new WidgetRect(i, j);
				r.setLayoutX(j*rectSize+alignCenter+j*btnPadding);
				r.setLayoutY(i*rectSize+padding+i*btnPadding);
				r.setRow(i);
				r.setCol(j);
				r.setWidth(rectSize);
				r.setHeight(rectSize);
				r.setFill(Color.TRANSPARENT);
				r.setId(Integer.toString(j));
				this.getChildren().add(r);
				WidgetBar.listRect.add(r);
			}
		}
		
		for(int i=0; i<btnName.length; ++i){
			WidgetButton btn = new WidgetButton(btnName[i], btnName[i] + ext);
			this.getChildren().add(btn);
			listBtn.add(btn);
		}
		
		for(int i=0; i<widgetBarMenuName.length; ++i){
			widgetBarMenuItem[i] = new MenuItem(widgetBarMenuName[i]);
			widgetBarMenu.getItems().add(widgetBarMenuItem[i]);
		}
		
		btnMenu.getItems().addAll(btnSizeMenu, btnDeleteMenuItem);
				
		for(int i=0; i<btnSizeMenuName.length; ++i){
			btnSizeMenuItem[i] = new MenuItem(btnSizeMenuName[i]);
			btnSizeMenu.getItems().add(btnSizeMenuItem[i]);
		}
		
		for(int i=0; i<splitBtnMenuName.length; ++i){
			splitRadioMenuItem[i] = new RadioMenuItem(splitBtnMenuName[i]);
			splitRadioMenuItem[i].setToggleGroup(splitToggleGroup);
			splitMenu.getItems().add(splitRadioMenuItem[i]);
		}
		splitRadioMenuItem[0].setSelected(true);
		
		widgetBarController = new WidgetBarController(this);
	}

	public void changeWidgetBarHeight() {
		
		for(int i=0; i<WidgetBar.listBtn.size(); ++i){
			this.getChildren().remove(WidgetBar.listBtn.get(i));
		}
		
		if (AppMain.WidgetHeight == 1) {
			this.height = AppMain.WidgetHeight * rectSize + padding * 2;
			for(int i=0; i<WidgetBar.listBtn.size(); ++i){
				WidgetBar.listBtn.get(i).setSize(25.0);
				WidgetBar.listBtn.get(i).setPrefWidth(25.0);
				WidgetBar.listBtn.get(i).setPrefHeight(25.0);
				WidgetBar.listBtn.get(i).setBigger(false);
				//row�� ��ġ�� �ٲ���Ѵ�.
				if(WidgetBar.listBtn.get(i).getRow() == 1){
					int col = WidgetBar.listBtn.get(i).getCol();
					if(WidgetBar.listRect.get(col).getIsFill()){
						for(int j=0; j<WidgetBar.listRect.size(); ++j){
							WidgetRect targetRect = WidgetBar.listRect.get(j);
							if(!targetRect.getIsFill()){
								targetRect.setIsFill(true);
								WidgetBar.listBtn.get(i).setLayoutX(targetRect.getLayoutX());
								WidgetBar.listBtn.get(i).setLayoutY(targetRect.getLayoutY());
								WidgetBar.listBtn.get(i).setRow(targetRect.getRow());
								WidgetBar.listBtn.get(i).setCol(targetRect.getCol());
								break;
							}
						}
					}else{
						WidgetBar.listBtn.get(i).setLayoutX(WidgetBar.listRect.get(col).getLayoutX());
						WidgetBar.listBtn.get(i).setLayoutY(WidgetBar.listRect.get(col).getLayoutY());
						WidgetBar.listBtn.get(i).setRow(WidgetBar.listRect.get(col).getRow());
					}
				}
			}
		} else {
			this.height = AppMain.WidgetHeight * rectSize + btnPadding + padding * 2;
		}
		
		for(int i=0; i<WidgetBar.listRect.size(); ++i){
			this.getChildren().remove(WidgetBar.listRect.get(i));
		}
		WidgetBar.listRect.removeAll(WidgetBar.listRect);
		
		this.setPrefHeight(height);
		for(int i=0; i<AppMain.WidgetHeight; ++i){
			for(int j=0; j<numOfRect; ++j){
				WidgetRect r = new WidgetRect(i, j);
				r.setLayoutX(j*rectSize+alignCenter+j*btnPadding);
				r.setLayoutY(i*rectSize+padding+i*btnPadding);
				r.setRow(i);
				r.setCol(j);
				r.setWidth(rectSize);
				r.setHeight(rectSize);
				r.setFill(Color.TRANSPARENT);
				r.setId(Integer.toString(j));
				this.getChildren().add(r);
				WidgetBar.listRect.add(r);
			}
		}
		
		for(int i=0; i<WidgetBar.listBtn.size(); ++i){
			this.getChildren().add(WidgetBar.listBtn.get(i));
			int row = WidgetBar.listBtn.get(i).getRow();
			int col = WidgetBar.listBtn.get(i).getCol();
			for(int j=0; j<WidgetBar.listRect.size(); ++j){
				if(row == WidgetBar.listRect.get(j).getRow() && col == WidgetBar.listRect.get(j).getCol()){
					WidgetBar.listRect.get(j).setIsFill(true);
					break;
				}
			}
		}
	}
}
