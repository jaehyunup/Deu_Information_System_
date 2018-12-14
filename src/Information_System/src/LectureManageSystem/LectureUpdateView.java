package LectureManageSystem;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

public class LectureUpdateView extends JFrame implements View {
	private Container lecFrame;
	private JPanel lecPanel;
	private JTable lecTable;
	private JButton ok;
	private JTextField MinNum, MaxNum, lecName, dept, gradeNum, lecInfo;
	private JList<Object> prof;
	private Object name[]= {"null"};
	private Object AllCourseColName[]= { "강좌번호","강좌이름","개설학과","담당교수","학점", "설명"}; //테이블 컬럼명 지정
	private String selectCNO="", selectProf="";
	private JLabel selectNo, selectName;
	private JButton ReturnBtn;

	
	public LectureUpdateView(){
		initComps();
		addComps();
		initWindow();
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

	public JButton getOk() {
		return ok;
	}

	public void setAllCourseRowList(Object[][] List) { //데이터베이스에서 강좌 목록을 테이블에 저장하는 메소드
		DefaultTableModel Tablemodel=new DefaultTableModel(List,AllCourseColName);
		lecTable.setModel(Tablemodel);
		lecPanel.repaint();
	}
	
	public void setSelectCNO(String selectCNO) {
		this.selectCNO = selectCNO;
		selectNo.setText(this.selectCNO);
	}

	public void setSelectProf(String selectProf) {
		this.selectProf = selectProf;
		selectName.setText(this.selectProf);
	}

	public void setName(Object[] name) {
		// TODO Auto-generated method stub
		this.name=name;
		prof.setListData(name);
	}

	public String getDept() {
		return dept.getText();
	}

	public String getGradeNum() {
		return gradeNum.getText();
	}

	public JTable getLecTable() {
		return lecTable;
	}

	public JList<Object> getProf() {
		return prof;
	}

	public String getSelectCNO() {
		return selectCNO;
	}

	public String getSelectProf() {
		return selectProf;
	}

	public String getLecName() {
		return lecName.getText();
	}

	public String getLecInfo() {
		return lecInfo.getText();
	}
	
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}

	@Override
	public void initComps() {
		// TODO Auto-generated method stub
		lecFrame=getContentPane();
		lecTable=new JTable();
		ok=new JButton("확인");
		lecPanel=new JPanel();
		lecPanel.setLayout(null);
		lecPanel.setBounds(0,0,700,600);
		lecFrame.add(lecPanel);
		
		JLabel label=new JLabel("개설된 강좌 목록");
		label.setBounds(30, 5 , 100, 30);
		JScrollPane jScrollPane=new JScrollPane(lecTable);
		jScrollPane.setBounds(30, 30, 500, 500);
		lecPanel.add(label);
		lecPanel.add(jScrollPane);
		
		
		JLabel cname=new JLabel("강좌 이름");
		cname.setBounds(550, 70, 150, 30);
		lecName=new JTextField();
		lecName.setColumns(20);
		lecName.setBounds(550, 100, 100, 30);
		lecPanel.add(lecName);
		lecPanel.add(cname);
		
		JLabel de=new JLabel("담당 학과");
		de.setBounds(550, 130, 150, 30);
		dept=new JTextField();
		dept.setColumns(20);
		dept.setBounds(550, 160, 100, 30);
		lecPanel.add(de);
		lecPanel.add(dept);
		
		JLabel grade=new JLabel("학점 수");
		grade.setBounds(550, 190, 150, 30);
		gradeNum=new JTextField();
		gradeNum.setColumns(20);
		gradeNum.setBounds(550, 220, 100, 30);
		lecPanel.add(gradeNum);
		lecPanel.add(grade);
		
		JLabel info=new JLabel("강좌 설명");
		info.setBounds(550, 250, 150, 30);
		lecInfo=new JTextField();
		lecInfo.setColumns(20);
		lecInfo.setBounds(550, 280, 100, 30);
		lecPanel.add(info);
		lecPanel.add(lecInfo);
		
		JLabel profName=new JLabel("담당 교수"); //디비에서 교수 이름을 리스트로 담아온다.
		profName.setBounds(550, 310, 100, 30);
		prof=new JList<Object>(name);
		
		prof.setSelectionMode(1);
		
		JScrollPane professor=new JScrollPane(prof);
		professor.setBounds(550, 340, 100, 20);
		lecPanel.add(professor);
		lecPanel.add(profName);
		
		
		JLabel index=new JLabel("선택된 강좌 번호");
		index.setBounds(550, 370, 150, 30);
		selectNo=new JLabel(selectCNO);
		selectNo.setBounds(550, 400, 150, 30);
		lecPanel.add(index);
		lecPanel.add(selectNo);
		
		JLabel p=new JLabel("선택된 교수");
		p.setBounds(550, 430, 150, 30);
		selectName=new JLabel(selectProf);
		selectName.setBounds(550, 455, 150, 30);
		lecPanel.add(p);
		lecPanel.add(selectName);
		
		ok.setBounds(550, 490, 100, 30);
		
		lecPanel.add(ok);
		
		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(550,520,100,30);
		lecPanel.add(ReturnBtn);
	}

	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		setTitle("강좌 정보 변경 시스템");
		setBounds(400,100,700,600);
		setResizable(false);
		setVisible(true);
	}
	
	
}
