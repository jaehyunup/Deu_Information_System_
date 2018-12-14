package LoginService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.*;

/* 로그인 컨트롤러 클래스.
 * LoginView클래스에서 입력 받은 아이디와 패스워드를 체크한다.
 * 정규식을 이용하여 아이디가 형식에 맞는지 체크한 뒤 각 데이터가 존재하는 테이블에서 아이디와 패스워드를 비교해주고,
 * 
 */
public class LoginController implements ActionListener{

	private LoginView view;
	private LoginModel model;
//	private loginType type;
//	private loginSpec spec;
	
	public  LoginController(LoginView view) {
		this.view = view;
		model = new LoginModel();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userid = view.getUserid().getText();
		String userpw = view.getUserpw().getText();
		String idPattern = "^(S|P|H|G)[0-9]*$";
		boolean idcheck = Pattern.matches(idPattern, userid);
		
		if(!userid.isEmpty() && !userpw.isEmpty()) {
			if (userid.length() == 4 && idcheck == true) {
				System.out.println(userid + "\n" + userpw);
				//model.loginAccount(userid, userpw);
				if (userid.charAt(0) == 'S') {
					
					System.out.println("학생입니다.");
				}
				else if(userid.charAt(0) == 'P'){
					System.out.println("교수입니다.");
				}
				else if(userid.charAt(0) == 'H'){
					System.out.println("학사담당 직원입니다.");
				}
				else if(userid.charAt(0) == 'G'){
					System.out.println("수업담당 직원입니다.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "아이디를 다시 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "빈칸을 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
		}
		
		/*
		if(userid != null && !userid.isEmpty()) {
			System.out.println(userid);
			if(!LoginModel.getInstance().LoginCheck(userid)) {
				System.out.println("id 비교 성공");
			} 
			if(userid != null && !userid.isEmpty()) {
				System.out.println("id 성공");
			}else {
				System.out.println("id 실패");
			}
			if(userpw != null && !userpw.isEmpty()) {
				System.out.println("pw 성공");
			}else {
				System.out.println("pw 실패");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "아이디가 올바르지 않습니다.");
		}
		
		*/
		
	}
	

	/*
	private loginSpec loginSucessSpec;
	
	

	public LoginController(loginSpec loginspec) { // 로그인 페이지가 생성될때는, 로그인 스펙 객체를 이어받아서 사용한다.
		this.loginSucessSpec=loginspec;
		//initialize();
			
	}
		private void initialize() { //  GUI 생성 부분 
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	*/

		
}

