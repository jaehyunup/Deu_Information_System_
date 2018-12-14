package CouserManageService;

import mainpackage.loginSpec;
import mainpackage.View;

import mainpackage.loginType;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoursePMainView extends JFrame implements View {
	/* 교수의 메인 뷰 클래스*/
	private Container ct;
	private JPanel mainPanel;
	private JButton CourseBtn; //   내 강좌 보기
	private JButton AttendBtn; //  내 강의 보기

	private JButton ReturnBtn;
	public CoursePMainView(){
		initWindow();
		initComps();
		addComps();
	}
	
	@Override
	public void initComps(){
		ct = getContentPane();
		CourseBtn= new JButton("강의 관리 및 출석부 보기");
		CourseBtn.setBounds(40,20,200,50);
		AttendBtn= new JButton("출석부 보기");
		AttendBtn.setBounds(140,100,100,50);

		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(90,120,100,50);

		

	}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		ct.setLayout(null);		
		ct.add(CourseBtn);
		//ct.add(AttendBtn);
		ct.add(ReturnBtn);
		
	}
	
	@Override
	public void initWindow() {
		setBounds(570,200, 280, 230);
		setTitle("수강 관리 메뉴-교수");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getCourseBtn() {
		return this.CourseBtn;
	}
	public JButton getConfigBtn() {
		return this.AttendBtn;
	}
	
	public JButton getReturnBtn() {
		return ReturnBtn;
	}
	@Override
	public void addListener(ActionListener e) {
		CourseBtn.addActionListener(e);
		AttendBtn.addActionListener(e);
		ReturnBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}


	
}
