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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CourseSMainView extends JFrame implements View{ //,Observer {
	private Container ct;
	private JPanel mainPanel;
	private JButton EnrolmentBtn;
	private JButton GradeBtn;
	private JButton ReturnBtn;
	ArrayList<JButton> BtnList=new ArrayList<JButton>();


	
	
	@Override
	public void initComps(){
		ct = getContentPane();
		mainPanel=new JPanel();
		EnrolmentBtn=new JButton("수강 신청");
		GradeBtn=new JButton("금 학기 성적 조회");
		ReturnBtn=new JButton("돌아가기");
		BtnList.add(EnrolmentBtn);
		BtnList.add(GradeBtn);
		}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		ct.setLayout(new BorderLayout(5, 5));		
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(EnrolmentBtn);
		mainPanel.add(GradeBtn);
		mainPanel.add(ReturnBtn);

		ct.add(mainPanel);
	}
	
	@Override
	public void initWindow() {
		setBounds(500,200, 400, 100);
		setTitle("수강 관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public CourseSMainView(){
		initComps();
		addComps();
		initWindow();
	}
	
	public JButton getEnrolmentBtn() {
		return this.EnrolmentBtn;
	}
	
	public JButton getGradeBtn() {
		return this.GradeBtn;
	}
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}

	@Override
	public void addListener(ActionListener e) {
		this.EnrolmentBtn.addActionListener(e);
		this.GradeBtn.addActionListener(e);
		this.ReturnBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}

	
	



	/*
	
	@Override
	public void update(loginType Type) {
		this.repaint();
		System.out.println(Type.toString());
	}
	*/

}