package LectureManageSystem;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

public class LectureDeleteView extends JFrame implements View {

	private Container lecFrame;
	private JPanel lecPanel;
	private JTable lecTable;
	private JButton ok;
	private JLabel selectNo;
	private Object AllCourseColName[]= { "강좌번호","강좌이름","개설학과","담당교수","학점"}; //테이블 컬럼명 지정
	private String selectCNO;
	private JLabel label;
	private JLabel index;
	private JScrollPane jScrollPane;
	private JButton ReturnBtn;

	public LectureDeleteView(){
		initComps();
		addComps();
		initWindow();
	}
	@Override
	public void initComps() {
		lecFrame=getContentPane();

		lecPanel=new JPanel();
		lecPanel.setLayout(null);
		lecPanel.setBounds(0,0,600,400);
	
		lecFrame.add(lecPanel);
		lecTable=new JTable();
		label=new JLabel("개설된 강좌 목록");
		label.setBounds(30, 5 , 100, 30);
		jScrollPane=new JScrollPane(lecTable);
		
		jScrollPane.setBounds(30, 30, 500, 250);
		lecPanel.add(label);
		lecPanel.add(jScrollPane);
		
		index=new JLabel("선택된 강좌 번호");
		index.setBounds(30, 300, 150, 30);
		selectNo=new JLabel(selectCNO);
		selectNo.setBounds(150, 300, 150, 30);
		lecPanel.add(index);
		lecPanel.add(selectNo);
		
		ok=new JButton("확인");
		ok.setBounds(450, 320, 100, 30);
		lecPanel.add(ok);
		
		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(40,320,100,30);
		lecPanel.add(ReturnBtn);

	}
	

	@Override
	public void addListener(ActionListener e) {
		// TODO Auto-generated method stub
		ok.addActionListener(e);
		ReturnBtn.addActionListener(e);
	}
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}
	public String getSelectCNO() {
		return selectCNO;
	}

	@Override
	public void addMouseListener(MouseListener e) {
		// TODO Auto-generated method stub
		lecTable.addMouseListener(e);
	}

	public JButton getOk() {
		return ok;
	}

	public void setAllCourseRowList(Object[][] List) { //데이터베이스에서 강좌 목록을 테이블에 저장하는 메소드
		DefaultTableModel Tablemodel=new DefaultTableModel(List,AllCourseColName);
		lecTable.setModel(Tablemodel);
		lecPanel.repaint();
		lecPanel.repaint();
		
	}

	public JTable getLecTable() {
		return lecTable;
	}

	public void setSelectCNO(String selectCNO) {
		// TODO Auto-generated method stub
		this.selectCNO = selectCNO;
		selectNo.setText(this.selectCNO);
		
	}

	

	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		setTitle("강좌 삭제 서비스");
		setBounds(400,200,600, 400);
		setResizable(false);		
		setVisible(true);
	}
	
	
}
