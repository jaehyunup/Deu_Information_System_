package CouserManageService;

import mainpackage.loginSpec;
import mainpackage.loginType;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProfMainView extends JFrame implements CourseView {
	/* 교수의 메인 뷰 클래스*/
	private Container ct;
	private JPanel mainPanel;
	private JButton CourseBtn; //   내 강좌 보기
	private JButton ConfigBtn; //  내 강의 보기
	ArrayList<JButton> BtnList=new ArrayList<JButton>();
	
	ProfMainView(){
		initWindow();
		initComps();
		addComps();
	}
	
	@Override
	public void initComps(){
		ct = getContentPane();
		mainPanel=new JPanel();
		CourseBtn= new JButton("강의 관리");
	    ConfigBtn= new JButton("사용자 설정 변경");
	}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		ct.setLayout(new BorderLayout(5, 5));		
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(CourseBtn);
		mainPanel.add(ConfigBtn);
		ct.add(mainPanel);
	}
	
	@Override
	public void initWindow() {
		setBounds(400,200, 600, 400);
		setTitle(S_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getCourseBtn() {
		return this.CourseBtn;
	}
	public JButton getConfigBtn() {
		return this.ConfigBtn;
	}
	

	@Override
	public void addListener(ActionListener e) {
		CourseBtn.addActionListener(e);
		ConfigBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<JButton> getButtonList() {
		// TODO Auto-generated method stub
		return BtnList;
	}
	
	
}
