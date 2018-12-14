package UserManageService;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import mainpackage.View;

/*
 * 로그인 GUI를 담당하는 클래스.
 */

public class LoginView extends JFrame implements View{
	private Container loginFrame;
	private JTextField userid;
	private JTextField userpw;
	private JButton LoginBtn;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	public LoginView() {
		 initWindow();
		 initComps();
		 addComps();
	}
	
	
	public void initComps(){
		loginFrame=getContentPane();
		label = new JLabel("동의 대학교 정보 시스템");
		label.setBounds(170, 10, 500, 59);
		LoginBtn = new JButton("로그인");
		LoginBtn.setBounds(300, 110, 100, 100);

		userid = new JTextField();
		userid.setBounds(84, 120, 130, 26);
		userid.setColumns(10);


		userpw = new JTextField();
		userpw.setBounds(84, 183, 130, 26);
		userpw.setColumns(10);


		label_1 = new JLabel("아이디");
		label_1.setBounds(84, 97, 61, 16);


		label_2 = new JLabel("비밀번호");
		label_2.setBounds(84, 158, 61, 16);


	}
	
	public void addComps() {
		loginFrame.setLayout(null);
		loginFrame.add(label);
		loginFrame.add(LoginBtn);
		loginFrame.add(userid);
		loginFrame.add(userpw);
		loginFrame.add(label_1);
		loginFrame.add(label_2);
	}
	

	
	public void initWindow() { //  창초기화
		setBounds(200, 300, 500, 300);
		setTitle("로그인");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public String getUserid() {
		return userid.getText();
	}
	
	
	public String getUserpw() {
		return userpw.getText();
	}

	
	@Override
	public void addListener(ActionListener e) { //컨트롤러에서  이  메서드를 불러서 해당 뷰의 리스너로 컨트롤러에 구현된 리스너를 등록
		LoginBtn.addActionListener(e);
	}
}
