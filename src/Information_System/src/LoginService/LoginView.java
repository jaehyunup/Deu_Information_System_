package LoginService;

import java.awt.*;
import javax.swing.*;


//로그인 GUI
public class LoginView extends JFrame{
	private JFrame loginframe;
	private JTextField userid;
	private JTextField userpw;
//	private loginSpec loginspec;
//	private loginType logintype;
	
	public LoginView() {
		super ("대학정보시스템");

		loginframe = new JFrame();
		loginframe.setBounds(800, 300, 500, 300);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		
		
		JLabel label = new JLabel("동의 대학교 정보 시스템");
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		label.setBounds(170, 10, 500, 59);
		loginframe.getContentPane().add(label);
		
		/*
		JLabel label_3 = new JLabel("로그인 종류");
		label_3.setBounds(276, 70, 110, 16);
		mainframe.getContentPane().add(label_3);
		
		JRadioButton studentLogin = new JRadioButton("학생");
		studentLogin.setBounds(276, 98, 141, 23);
		mainframe.getContentPane().add(studentLogin);
		
		JRadioButton professorLogin = new JRadioButton("교수");
		professorLogin.setBounds(276, 133, 141, 23);
		mainframe.getContentPane().add(professorLogin);
		
		JRadioButton csmanager = new JRadioButton("수강 관리자 ");
		csmanager.setBounds(276, 168, 141, 23);
		mainframe.getContentPane().add(csmanager);
		
		JRadioButton bamanager = new JRadioButton("학사 관리자");
		bamanager.setBounds(276, 203, 141, 23);
		mainframe.getContentPane().add(bamanager);
		
		ButtonGroup loginTypeGroup = new ButtonGroup();
		
		loginTypeGroup.add(studentLogin);
		loginTypeGroup.add(professorLogin);
		loginTypeGroup.add(csmanager);
		loginTypeGroup.add(bamanager);
		*/
		
		
		JButton LoginBtn = new JButton("로그인");
		LoginBtn.setBounds(300, 110, 100, 100);
		//LoginBtn.setSize(100, 100);
		//LoginBtn.setLocation(441, 125);
		loginframe.getContentPane().add(LoginBtn);
		
		userid = new JTextField();
		userid.setBounds(84, 120, 130, 26);
		loginframe.getContentPane().add(userid);
		userid.setColumns(10);
		
		userpw = new JTextField();
		userpw.setBounds(84, 183, 130, 26);
		loginframe.getContentPane().add(userpw);
		userpw.setColumns(10);
		
		JLabel label_1 = new JLabel("아이디");
		label_1.setBounds(84, 97, 61, 16);
		loginframe.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("비밀번호");
		label_2.setBounds(84, 158, 61, 16);
		loginframe.getContentPane().add(label_2);
		
		LoginController controller = new LoginController(this);
		LoginBtn.addActionListener(controller);
		
		loginframe.setVisible(true);
	}
	
	public JTextField getUserid() {
		return userid;
	}
	
	public void setUserid(JTextField userid) {
		this.userid = userid;
	}
	
	public JTextField getUserpw() {
		return userpw;
	}
	
	public void setUserpw(JTextField userpw) {
		this.userpw = userpw;
	}
	
}
