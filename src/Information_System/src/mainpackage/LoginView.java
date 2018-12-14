package mainpackage;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 로그인 View 
 */

public class LoginView extends JFrame implements View{
	private Container ct;
	private JTextField userid;
	private JPasswordField userpw;
	private JButton LoginBtn;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	public LoginView() {
		 initComps();
		 addComps();
		 initWindow();

	}
	
	
	public void initComps(){
		ct=getContentPane();
		ct.setLayout(null);
		label = new JLabel("동의 대학교 정보 시스템");
		label.setBounds(170, 10, 500, 59);
		LoginBtn = new JButton("로그인");
		LoginBtn.setBounds(300, 110, 100, 100);

		userid = new JTextField();
		userid.setBounds(84, 120, 130, 26);
		userid.setColumns(10);


		userpw = new JPasswordField();
		userpw.setBounds(84, 183, 130, 26);
		userpw.setColumns(10);


		label_1 = new JLabel("아이디");
		label_1.setBounds(84, 97, 61, 16);


		label_2 = new JLabel("비밀번호");
		label_2.setBounds(84, 158, 61, 16);


	}
	
	public void addComps() {
		ct.add(label);
		ct.add(LoginBtn);
		ct.add(userid);
		ct.add(userpw);
		ct.add(label_1);
		ct.add(label_2);
	}
	

	
	public void initWindow() { //  창초기화
		setBounds(470, 210, 500, 300);
		setTitle("로그인");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public void ckMessage() {
		JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.", "경고", JOptionPane.WARNING_MESSAGE);
	}
	
	public void idMessage() {
		JOptionPane.showMessageDialog(null, "아이디는 1개의 영대문자, 3개의 숫자로 이루어져 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
	}
	
	public void emptyMessage() {
		JOptionPane.showMessageDialog(null, "빈칸을 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	}
	
	public JButton getLoginBtn() {
		return LoginBtn;
	}


	public void setLoginBtn(JButton loginBtn) {
		LoginBtn = loginBtn;
	}


	public JTextField getUserid() {
		return userid;
	}
	
	
	public JPasswordField getUserpw() {
		return userpw;
	}

	
	@Override
	public void addListener(ActionListener e) { //컨트롤러에서  이  메서드를 불러서 해당 뷰의 리스너로 컨트롤러에 구현된 리스너를 등록
		LoginBtn.addActionListener(e);
	}
}
