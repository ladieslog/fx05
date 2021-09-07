package quiz.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import quiz.loginService.LoginService;
import quiz.loginService.LoginServiceImpl;
import quiz.member.MemberProc;
import quiz.member.MemberService;
import quiz.member.MemberServiceImpl;

public class MainController implements Initializable{
	Parent root;
	MemberProc mp;
	LoginService ls;
	public void setRoot(Parent root) {
		this.root = root;
		ls.setRoot(root);
	}
	public void btnOk() {
		//System.out.println("ok");
		ls.loginCheck();
	}
	public void btnCancel() {
		//System.out.println("can");
		ls.loginClose();
	}
	public void btnMemberShip() {
		//System.out.println("mem");
		mp.memberShip();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mp = new MemberProc();
		ls = new LoginServiceImpl();
	}
}