package mainpackage;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InformationSystem {
	private  JFrame mainframe;
	private JTextField userid;
	private JTextField userpw;
	private loginSpec loginspec;
	private loginType logintype;

	public static void main(String[] args) {
		InformationSystem mainwindow=new InformationSystem();
			
		// GUI 실행부 끝 아래로 코드 작성.
	}

	/**
	 * Create the application.
	 */
	public InformationSystem(){ // 메인 윈도우 생성자  
		initialize();
	}

	private void initialize() { // GUI 초기화
		mainframe = new JFrame();
		mainframe.setBounds(400,200, 600, 400);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().setLayout(null);
		

		JLabel label = new JLabel("동의 대학교 정보 시스템");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		label.setBounds(6, 6, 588, 59);
		mainframe.getContentPane().add(label);
		
		JRadioButton studentLogin = new JRadioButton("학생");
		studentLogin.setBounds(276, 94, 141, 23);
		mainframe.getContentPane().add(studentLogin);
		
		JRadioButton professorLogin = new JRadioButton("교수");
		professorLogin.setBounds(276, 129, 141, 23);
		mainframe.getContentPane().add(professorLogin);
		
		JRadioButton csmanager = new JRadioButton("수강 관리자 ");
		csmanager.setBounds(276, 164, 141, 23);
		mainframe.getContentPane().add(csmanager);
		
		JRadioButton bamanager = new JRadioButton("학사 관리자");
		bamanager.setBounds(276, 199, 141, 23);
		mainframe.getContentPane().add(bamanager);
		
		ButtonGroup loginTypeGroup = new ButtonGroup();
		
		loginTypeGroup.add(studentLogin);
		loginTypeGroup.add(professorLogin);
		loginTypeGroup.add(csmanager);
		loginTypeGroup.add(bamanager);
		
		JButton LoginBtn = new JButton("로그인");
		LoginBtn.setSize(100, 100);
		LoginBtn.setLocation(441, 125);
		mainframe.getContentPane().add(LoginBtn, BorderLayout.EAST);
		

		
		userid = new JTextField();
		userid.setBounds(84, 120, 130, 26);
		mainframe.getContentPane().add(userid);
		userid.setColumns(10);
		
		userpw = new JTextField();
		userpw.setBounds(84, 183, 130, 26);
		mainframe.getContentPane().add(userpw);
		userpw.setColumns(10);
		
		JLabel label_1 = new JLabel("아이디");
		label_1.setBounds(87, 97, 61, 16);
		mainframe.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("비밀번호");
		label_2.setBounds(84, 141, 61, 16);
		mainframe.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("로그인 종류");
		label_3.setBounds(276, 66, 110, 16);
		mainframe.getContentPane().add(label_3);
		
		ActionListener loginclick=new ActionListener() {  // 버튼 클릭 리스너 생성
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					loginspec=new loginSpec(userid.getText(), userpw.getText(), loginType.PROFESSOR);
					loginpage lp=new loginpage(loginspec);
			}
		};
		LoginBtn.addActionListener(loginclick); //로그인 버튼에 리스너 등록
		mainframe.setVisible(true);

		
	}
}
	
	

