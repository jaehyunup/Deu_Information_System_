package LectureManageSystem;

import java.awt.Container;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

public class LectureRegisterView extends JFrame implements View {
	private Container lecFrame;
	private JPanel lecPanel;
	private String selectCNO="", selectProf=""; //관리자가 선택한 강좌번호와 교수 저장 -> 모델로 넘겨줘서 등록할 것.
	private JLabel selectNo, selectName;
	private JTextField MinNum, MaxNum;
	private JButton ok;
	private JButton ReturnBtn;

	private Object AllCourseColName[]= { "강좌번호","강좌이름","개설학과","담당교수","학점"}; //테이블 컬럼명 지정
	private JTable lecTable; 
	private JList<Object> prof;
	private Object name[]= {""};

	public LectureRegisterView(){
		initComps();
		addComps();
		initWindow();
	}
	public JList<Object> getProf() {
		return prof;
	}

	public void setAllCourseRowList(Object[][] List) { //데이터베이스에서 강좌 목록을 테이블에 저장하는 메소드
		DefaultTableModel Tablemodel=new DefaultTableModel(List,AllCourseColName);
		lecTable.setModel(Tablemodel);
		//lecPanel.repaint();
	}
	
	public void setName(Object[] name) {
		this.name=name;
		prof.setListData(this.name);
	}
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}
	@Override
	public void addListener(ActionListener e) {
		// TODO Auto-generated method stub
		ok.addActionListener(e);
		ReturnBtn.addActionListener(e);

	}

	public JButton getOk() {
		return ok;
	}

	public JTable getLecTable() {
		return lecTable;
	}

	public String getSelectCNO() {
		return selectCNO;
	}

	public void setSelectCNO(String selectCNO) {
		this.selectCNO = selectCNO;
		selectNo.setText(this.selectCNO);
	}

	public String getSelectProf() {
		return selectProf;
	}

	public void setSelectProf(String selectProf) {
		this.selectProf = selectProf;
		selectName.setText(this.selectProf);
	}

	public JTextField getMinNum() {
		return MinNum;
	}

	public JTextField getMaxNum() {
		return MaxNum;
	}

	@Override
	public void addMouseListener(MouseListener e) {
		// TODO Auto-generated method stub
		lecTable.addMouseListener(e);
		prof.addMouseListener(e);
	}

	@Override
	public void initComps() {
        lecFrame=getContentPane();
		
		lecTable=new JTable();
		ok=new JButton("확인");
		MinNum=new JTextField("");
		MaxNum=new JTextField("");
		
		
		lecPanel=new JPanel();
		lecPanel.setLayout(null);
		lecPanel.setBounds(0,0,600,400);
		lecFrame.add(lecPanel);
		
		lecTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //단일 선택 설정
		
		JLabel label=new JLabel("개설된 강좌 목록");
		label.setBounds(30, 5 , 100, 30);
		JScrollPane jScrollPane=new JScrollPane(lecTable);
		jScrollPane.setBounds(30, 30, 400, 200);
		lecPanel.add(label);
		lecPanel.add(jScrollPane);
		
		
		JLabel profName=new JLabel("담당 교수"); //디비에서 교수 이름을 리스트로 담아온다.
		profName.setBounds(450, 20, 100, 30);
		prof=new JList<Object>(name);
		
		prof.setSelectionMode(1);
		
		JScrollPane professor=new JScrollPane(prof);
		professor.setBounds(450, 50, 100, 20);
		lecPanel.add(professor);
		lecPanel.add(profName);
		
		JLabel Min=new JLabel("수강 가능 최소  인원");
		Min.setBounds(450, 80, 150, 30);
		MinNum.setColumns(20);
		MinNum.setBounds(450, 110, 100, 30);
		lecPanel.add(MinNum);
		lecPanel.add(Min);
		
		JLabel Max=new JLabel("수강 가능 최대  인원");
		Max.setBounds(450, 150, 150, 30);
		MaxNum.setColumns(20);
		MaxNum.setBounds(450, 180, 100, 30);
		lecPanel.add(MaxNum);
		lecPanel.add(Max);
		
		JLabel index=new JLabel("선택된 강좌 번호");
		index.setBounds(450, 210, 150, 30);
		selectNo=new JLabel(selectCNO);
		selectNo.setBounds(450, 235, 150, 30);
		lecPanel.add(index);
		lecPanel.add(selectNo);
		
		JLabel p=new JLabel("선택된 교수");
		p.setBounds(450, 265, 150, 30);
		selectName=new JLabel(selectProf);
		selectName.setBounds(450, 290, 150, 30);
		lecPanel.add(p);
		lecPanel.add(selectName);
		
		ok.setBounds(450, 320, 100, 30);
		lecPanel.add(ok);	
		
		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(40,320,100,50);
		lecPanel.add(ReturnBtn);
	}

	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		setTitle("강의 등록 서비스");
		setBounds(400,200,600, 400);

		setResizable(false);
		setVisible(true);

	}
}
