package quiz.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import quiz.Member_DTO.MemberDTO;
import quiz.common.CommonService;
import quiz.common.CommonServiceImpl;

public class MemberController implements Initializable{
	Parent root;
	MemberService ms;
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}
	public void membershipProc() {
		System.out.println("회원가입 클릭");
		ms.membershipProc();
	}
	public void memberCancle() {
		System.out.println("취소 클릭");
		ms.memberCancle();
	}
}



