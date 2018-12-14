package mainpackage;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CSMainView extends JFrame implements View {
/*  학생 로그인 첫 화면 (기 분기점)*/
	private Container ct;
	private JButton LogOutBtn;
	private JLabel mainLabel;
	private JButton courseBtn;
	private JButton changePwBtn;
	private JButton PaymentBtn;

	
	
	public CSMainView() {
		 initComps();
		 addComps();
		 initWindow();

	}
	
	
	public void initComps(){
		ct=getContentPane();
		ct.setLayout(null);
		LogOutBtn = new  JButton("로그아웃");
		LogOutBtn.setBounds(6, 243, 117, 29);
		
		mainLabel = new JLabel("대학 정보 전산 시스템");
		mainLabel.setBounds(137, 6, 129, 16);
		
		courseBtn = new JButton("수업 관리 서비스");
		courseBtn.setBounds(137, 68, 117, 40);
		
		PaymentBtn = new JButton("수강료 청구서 발급 서비스");
		PaymentBtn.setBounds(117, 108, 157, 40);
		
		changePwBtn = new JButton("계정 암호 변경");
		changePwBtn.setBounds(137, 148, 117, 40);

	}
	
	public void addComps() {
		ct.add(LogOutBtn);
		ct.add(mainLabel);		
		ct.add(courseBtn);
		ct.add(PaymentBtn);
		ct.add(changePwBtn);



	}
	

	
	public void initWindow() { //  창초기화
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(510, 200, 400, 300);
		setTitle("수업 담당자 - 메인 메뉴");
		setVisible(true);

	}


	public JButton getPaymentBtn() {
		return PaymentBtn;
	}


	public void setPaymentBtn(JButton paymentBtn) {
		PaymentBtn = paymentBtn;
	}


	public JButton getLogOutBtn() {
		return LogOutBtn;
	}


	public void setLogOutBtn(JButton logOutBtn) {
		LogOutBtn = logOutBtn;
	}


	public JButton getCourseBtn() {
		return courseBtn;
	}


	public JButton getChangePwBtn() {
		return changePwBtn;
	}


	public void setChangePwBtn(JButton changePwBtn) {
		this.changePwBtn = changePwBtn;
	}


	@Override
	public void addListener(ActionListener e) {
		courseBtn.addActionListener(e);
		changePwBtn.addActionListener(e);
		LogOutBtn.addActionListener(e);
		PaymentBtn.addActionListener(e);
		
	}
}
