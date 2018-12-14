package LectureManageSystem;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

public class LectureNewView extends JFrame implements View{
	private Container lecFrame;
	JPanel lecPanel;
	JTable lecTable;
	JButton ok;
	JTextField courseNum, courseName, dept, grade, info ;
	private Object AllCourseColName[]= { "강좌번호,","강좌이름","개설학과","담당교수","학점","설명"}; //테이블 컬럼명 지정
	private JList<Object> prof;
	private Object name[]= {" "};
	private String selectProf="";
	private JLabel selectName;
	private  JLabel label;
	private JScrollPane jScrollPane;
	private JLabel num;
	private JLabel cname;
	private JLabel de;
	private JLabel gra;
	private JLabel in;
	private JLabel profName;
	private JScrollPane professor;
	private JLabel na;
	private JButton ReturnBtn;


	
	public LectureNewView(){
		lecTable=new JTable();
		ok=new JButton("확인");
		courseNum=new JTextField("");
		courseName=new JTextField("");
		dept=new JTextField("");
		grade=new JTextField("");
		info=new JTextField("");
		initComps();
		addComps();
		initWindow();
		
	}

	
	public JButton getOk() {
		return ok;
	}

	public String getCourseNum() {
		return courseNum.getText();
	}

	public String getInfo() {
		return info.getText();
	}

	public String getCourseName() {
		return courseName.getText();
	}

	public String getDept() {
		return dept.getText();
	}

	public String getGrade() {
		return grade.getText();
	}
	public void setAllCourseRowList(Object[][] List) { //데이터베이스에서 강좌 목록을 테이블에 저장하는 메소드
		DefaultTableModel Tablemodel=new DefaultTableModel(List,AllCourseColName);
		lecTable.setModel(Tablemodel);
		lecPanel.repaint();
	}

	@Override
	public void addListener(ActionListener e) {
		// TODO Auto-generated method stub
		ok.addActionListener(e);
		ReturnBtn.addActionListener(e);

	}

	@Override
	public void addMouseListener(MouseListener e) {
		// TODO Auto-generated method stub
		lecTable.addMouseListener(e);
		prof.addMouseListener(e);
	}
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}
	public String getSelectProf() {
		return selectProf;
	}

	public void setSelectProf(String selectProf) {
		this.selectProf = selectProf;
		selectName.setText(this.selectProf);
	}

	public void setName(Object[] name) {
		this.name=name;
		prof.setListData(name);
	}

	public JList<Object> getProf() {
		return prof;
	}

	@Override
	public void initComps() {
		lecFrame=getContentPane();
		lecPanel=new JPanel();
		lecPanel.setLayout(null);
		lecPanel.setBounds(0,0,600,600);
		lecFrame.add(lecPanel);
	//	lecTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		label=new JLabel("개설된 강좌 목록");
		label.setBounds(30, 5 , 100, 30);
		jScrollPane=new JScrollPane(lecTable);
		
		jScrollPane.setBounds(30, 30, 400, 400);
		lecPanel.add(label);
		lecPanel.add(jScrollPane);
			
		num=new JLabel("강좌 번호");
		num.setBounds(450, 20, 100, 30);
		courseNum.setColumns(20);
		courseNum.setBounds(450, 50, 100, 30);
		lecPanel.add(num);
		lecPanel.add(courseNum);
		
		cname=new JLabel("강좌 이름");
		cname.setBounds(450, 80, 100, 30);
		courseName.setColumns(20);
		courseName.setBounds(450, 110, 100, 30);
		lecPanel.add(courseName);
		lecPanel.add(cname);
		
		de=new JLabel("개설 학과");
		de.setBounds(450, 140, 150, 30);
		dept.setColumns(20);
		dept.setBounds(450, 170, 100, 30);
		lecPanel.add(de);
		lecPanel.add(dept);
		
		gra=new JLabel("학점 수");
		gra.setBounds(450, 200, 100, 30);
		grade.setColumns(5);
		grade.setBounds(450, 230, 100, 30);
		lecPanel.add(gra);
		lecPanel.add(grade);
		
		 in=new JLabel("설명");
		in.setBounds(450, 260, 100, 30);
		info.setColumns(50);
		info.setBounds(450, 290, 100, 30);
		lecPanel.add(in);
		lecPanel.add(info);
		
		profName=new JLabel("담당 교수"); //디비에서 교수 이름을 리스트로 담아온다.
		profName.setBounds(450, 320, 100, 30);
		prof=new JList<Object>(name);
		
		prof.setSelectionMode(1);
		
		professor=new JScrollPane(prof);
		professor.setBounds(450, 350, 100, 20);
		lecPanel.add(professor);
		lecPanel.add(profName);
		
		na=new JLabel("선택된 교수");
		na.setBounds(450, 380, 100, 30);
		selectName=new JLabel(selectProf);
		selectName.setBounds(450, 410, 100, 30);
		lecPanel.add(na);
		lecPanel.add(selectName);
		
		ok.setBounds(450, 490, 100, 30);
		lecPanel.add(ok);
		
		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(20,490,100,50);
		lecPanel.add(ReturnBtn);
			
	}

	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		setTitle("새로운 강좌 등록 시스템");
		setBounds(400,200,600, 600);
		setResizable(false);
		setVisible(true);
		// TODO Auto-generated method stub
		
	}
	
	
}
