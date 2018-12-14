package CouserManageService;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;
import mainpackage.loginSpec;

public class CSmanagerPaymentView extends JFrame implements View,Observer {
/* 수업 담당자의 메인 뷰 클래스*/
	private Container ct;
	private Object StuTableRow[][] = {
			{ "null", "null","null", "null"}
	};
	
	
	private Object StuTableColName[] = { "학번", "학생이름","소속학과","주민등록번호"};
	private JTable StuTable;
	private JPanel StuListPanel;
	private JScrollPane StuScrollPane;
	private JButton PaymentButton; 
	private JButton ReturnBtn;
	private JButton refreshListBtn;

	public CSmanagerPaymentView(){
		initWindow();
		 initComps();
		 addComps();
		
		
	}
	@Override
	public void initComps(){ //뷰초기화
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 800, 500);
		ct= new JPanel();
		setContentPane(ct);
		ct.setLayout(null);
		
		StuListPanel = new JPanel();
		StuListPanel.setBounds(45, 49, 705, 371);
		ct.add(StuListPanel);
		
		StuTable = new JTable(StuTableRow,StuTableColName);
		
		JLabel InsStuLabel = new JLabel("학생 명단");
		StuListPanel.add(InsStuLabel);
		
		StuScrollPane = new JScrollPane(StuTable);
		StuScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		StuScrollPane.setPreferredSize(new Dimension(700, 300));
		StuScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		StuListPanel.add(StuScrollPane);

		refreshListBtn = new JButton(" 학생명단 불러오기");
		StuListPanel.add(refreshListBtn);
		
		PaymentButton = new JButton("청구서 발급하기");
		StuListPanel.add(PaymentButton);
		
		ReturnBtn = new  JButton("돌아가기");
		ReturnBtn.setBounds(6, 443, 117, 29);
		ct.add(ReturnBtn);		}
	
	@Override
	public void addComps() { // 컴포넌트 추가 부분
	
		
	}
	
	@Override
	public void initWindow() { // 뷰 창  초기화
		setBounds(400,200, 600, 400);
		setTitle("수강료 청구서 발급");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	public JButton getPaymentButton() {
		return PaymentButton;
	}
	public void setPaymentButton(JButton paymentButton) {
		PaymentButton = paymentButton;
	}
	public JButton getReturnBtn() {
		return ReturnBtn;
	}
	public void setReturnBtn(JButton returnBtn) {
		ReturnBtn = returnBtn;
	}
	
	
	public JTable getStuTable() {
		return StuTable;
	}
	public void setStuTable(JTable stuTable) {
		StuTable = stuTable;
	}
	public JButton getRefreshListBtn() {
		return refreshListBtn;
	}
	public void setRefreshListBtn(JButton refreshListBtn) {
		this.refreshListBtn = refreshListBtn;
	}
	
	public void setStudentList(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,StuTableColName);
		StuTable.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}
	
	
	@Override
	public void addListener(ActionListener e) {
		PaymentButton.addActionListener(e);
		ReturnBtn.addActionListener(e);
		refreshListBtn.addActionListener(e);
		// TODO Auto-generated method stub
	}
	
	public void addMouserListener(MouseListener i) {
		StuTable.addMouseListener(i);
	}
	@Override
	public void update(int i, Object[][] Table) {
		// TODO Auto-generated method stub
		setStudentList(Table); // 테이블 새로고침
	}
	@Override
	public void update(String info) {
		// TODO Auto-generated method stub
		
	}
	




}
