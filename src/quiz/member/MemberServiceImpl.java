package quiz.member;

import ex01.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import quiz.Member_DTO.MemberDTO;
import quiz.common.CommonService;
import quiz.common.CommonServiceImpl;

public class MemberServiceImpl implements MemberService{
	Parent root;
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대","40대 이상");
		}
	}
	public void memberCancle() {
		System.out.println("취소 클릭");
		CommonService cs = new CommonServiceImpl();
		cs.setRoot(root);
		cs.windowClose();
	}
	public void check() {
		TextField tx = (TextField)root.lookup("#fxName");
		TextField pf = (TextField)root.lookup("#fxPw");
		if(tx.getText().isEmpty()) {
			alertMethod("이름은 필수 항목입니다");
			tx.requestFocus();
		}
		else if(pf.getText().isEmpty()) {
			alertMethod("비밀번호 필수 항목입니다");
		}
	}
	public void alertMethod(String msg) {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		String age = null;
		if(cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해 주세요");
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}
	public boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if( rdoMan.isSelected() ) return true;
		else return false;
	}
	@Override
	public void membershipProc() {
		MemberDTO dto = new MemberDTO();

		check();

		dto.setName( ((TextField)root.lookup("#fxName")).getText() );
		dto.setAge( getComboBox() );
		dto.setGender( getGender() );

		System.out.println( dto.getName() );
		System.out.println( dto.getAge() );
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}
}