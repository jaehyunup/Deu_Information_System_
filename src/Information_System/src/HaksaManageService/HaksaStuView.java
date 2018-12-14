package HaksaManageService;

import java.awt.Button;


import java.awt.Container;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

import java.util.ArrayList;
import java.util.Vector;

public class HaksaStuView extends JFrame implements View{
	
	private String userColumn[]= {"학번","이름","학과","주민번호"};
	private String userAll[][]= {};
	
	private Container ct;
	private JTable table;
	private JTable tableAll;
	
	private JButton haksaInsert;
	private JButton haksaInquire;
	private JButton haksaModify;
	private JButton haksaDelete;
	private JButton ReturnBtn;
	private ArrayList<JButton> BtnList;
	private JLabel numLb;
	private JLabel nameLb;
	private TextField numText;
	private TextField nameText;
	
	private JScrollPane scrollpane;
	private JScrollPane scrollpaneAll;
	
	public HaksaStuView() {
		initComps();
		addComps();
		initWindow();
	}


	@Override
	public void initComps() {
		ct=getContentPane();
		nameLb=new JLabel("이름");
        numLb=new JLabel("학번");
		haksaInsert = new JButton("새 등록");
		haksaInquire = new JButton("조회");
		haksaModify = new JButton("수정");
		haksaDelete = new JButton("삭제");
		ReturnBtn = new JButton("돌아가기");
		BtnList=new ArrayList<JButton>();	
		numText = new TextField();
		nameText = new TextField();
		table = new JTable(userAll,userColumn);
		tableAll = new JTable(userAll,userColumn);
		scrollpane=new JScrollPane(table);
		scrollpaneAll=new JScrollPane(tableAll);
	}

	@Override
	public void addComps() {
		ct.add(scrollpaneAll);
		scrollpaneAll.setBounds(50,100,700,150);
		ct.add(numLb);
		numLb.setBounds(165, 300, 55, 30);
		ct.add(numText);
		numText.setBounds(220, 300, 80, 30);
		ct.add(nameLb);
		nameLb.setBounds(320, 300, 50, 30);
		ct.add(nameText);
		nameText.setBounds(370, 300, 90, 30);
		
		ct.add(scrollpane);
		scrollpane.setBounds(50,350,700,150);
		
		ct.add(haksaInquire);
		haksaInquire.setBounds(500, 300, 80, 30);
		
		ct.add(haksaInsert);
		haksaInsert.setBounds(200, 550, 100, 30);
		
		ct.add(haksaModify);
		haksaModify.setBounds(350, 550, 100, 30);
		
		ct.add(haksaDelete);
		haksaDelete.setBounds(500, 550, 100, 30);
		
		ct.add(ReturnBtn);
		ReturnBtn.setBounds(20, 600, 70, 50);
		BtnList.add(haksaInquire);
		BtnList.add(haksaInsert);
		BtnList.add(haksaModify);
		BtnList.add(haksaDelete);
		
	}

	public void initWindow() {
		setTitle("학사관리-학생관리");
		setLayout(null);
		setBounds(370,100,800, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	}
	public void valueAlarm() {
		JOptionPane.showMessageDialog(ct, "값을 입력해주세요.");
	}
	public void selectAlarm() {
		JOptionPane.showMessageDialog(ct, "조회된 내역이 없습니다.");
	}
	public void tableAlarm() {
		JOptionPane.showMessageDialog(ct, "수정할 정보를 선택해주세요.");
	}
	
	public void setHaksaList(String[][] data) {
		DefaultTableModel temp=new DefaultTableModel(data,userColumn); // 리스트에 들어갈 데이터 모델을 생성
		table.setModel(temp); // 기존 테이블의 모델 변경
	}
	public void setAllHaksaList(String[][] data) {
		DefaultTableModel temp=new DefaultTableModel(data,userColumn); // 리스트에 들어갈 데이터 모델 생성
		tableAll.setModel(temp); // 모든학사 정보 리스트 테이블 모델 변경
	}
	public void deleteTablerow(int row) {
		DefaultTableModel temp= (DefaultTableModel)table.getModel(); // 학사 테이블의 모델을 가져온다.
		table.setModel(temp);
		temp.removeRow(row);
	}
	
	public JButton getButtonList(int i) {
		// TODO Auto-generated method stub
		return BtnList.get(i);
	}
	public String getProfName() {
		return nameText.getText();
	}
	public String getProfNum() {
		return numText.getText();
	}
	
	
	public JButton getReturnBtn() {
		return ReturnBtn;
	}


	public void setTableAll(JTable tableAll) {
		this.tableAll = tableAll;
	}


	@Override
	public void addListener(ActionListener e) {
		haksaInquire.addActionListener(e);
		haksaInsert.addActionListener(e);
		haksaModify.addActionListener(e);
		haksaDelete.addActionListener(e);
		ReturnBtn.addActionListener(e);
	}
	public void AddMouseListener(MouseListener e) {
		table.addMouseListener(e);
	}


	public JTable getTableAll() {
		// TODO Auto-generated method stub
		return tableAll;
	}


	public JTable getTable() {
		return table;
	}


	
	

}

