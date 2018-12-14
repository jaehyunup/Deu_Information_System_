package CouserManageService;

import mainpackage.View;
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

public class ProfMainView extends JFrame implements View {
	/* 교수의 메인 뷰 클래스*/
	private Container ct;
	private JPanel mainPanel;
	private JButton CourseBtn; //   내 강좌 보기
	private JButton AttendBtn; //  내 강의 보기
	
	ProfMainView(){
		initWindow();
		initComps();
		addComps();
	}
	
	@Override
	public void initComps(){
		ct = getContentPane();
		mainPanel=new JPanel();
		CourseBtn= new JButton("내 강의 관리 및 출석부");
		AttendBtn= new JButton("출석부 보기");
	}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		ct.setLayout(new BorderLayout(5, 5));		
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(CourseBtn);
		//mainPanel.add(AttendBtn);
		ct.add(mainPanel);
	}
	
	@Override
	public void initWindow() {
		setBounds(600,200, 500, 400);
		setTitle("수강관리기능-교수");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getCourseBtn() {
		return this.CourseBtn;
	}
	public JButton getConfigBtn() {
		return this.AttendBtn;
	}
	

	@Override
	public void addListener(ActionListener e) {
		CourseBtn.addActionListener(e);
		AttendBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}


	
}
