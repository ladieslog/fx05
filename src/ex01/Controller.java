package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
public class Controller implements Initializable{
	Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		addComboBox();
	}
	public void addComboBox() {
		ComboBox<String> cmbAge=(ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge !=null) {
			cmbAge.getItems().addAll("20대 미만","20대","30대","40대 이상");
		}
		
	}
	
	public void viewProc() {
		System.out.println("확인 버튼 클릭");
		boolean gender =getGender();
		int hobby =getHobby();
		String age =getComboBox();
		   System.out.println(gender);
           System.out.println(hobby);
           System.out.println(age);
           
           try {
        	   Stage primaryStage =new Stage();
       
       		FXMLLoader loader =new FXMLLoader(getClass().getResource("../ex02/test.fxml"));
       		Parent root =loader.load();
       		Scene scene =new Scene(root);
       		
       		
       		primaryStage.setScene(scene);
       		primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
           
           
	}
	public boolean getGender() {
		RadioButton rdoMan =(RadioButton)root.lookup("#rdoMan");
		if(rdoMan.isSelected())return true;
		else return false;
	}
	public int getHobby() {
		int hobby=0;
		CheckBox music =(CheckBox)root.lookup("#chkMusic");
		CheckBox sport =(CheckBox)root.lookup("#chkSport");
		CheckBox movie =(CheckBox)root.lookup("#chkMovie");
		if(music.isSelected()) {hobby+=1;}
		if(sport.isSelected()) {hobby+=2;}
		if(movie.isSelected()) {hobby+=4;}
		
		return hobby;
	}
	public String getComboBox() {
		ComboBox<String> cmbAge=(ComboBox<String>)root.lookup("#cmbAge");
		String age =cmbAge.getValue().toString();
		if(age==null) {
			System.out.println("콤보박스를 선택해 주세요");
		}else {
			age=cmbAge.getValue().toString();
		}
		return age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
