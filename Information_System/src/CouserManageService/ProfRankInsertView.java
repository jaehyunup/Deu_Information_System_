package CouserManageService;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ProfRankInsertView extends JFrame implements CourseView {

	private Container ct;
	private Object RankTableRow[][] = {
			{ "","",""}
	};
	private Object StuTableRow[][] = {
			{ "","","",""}
	};
	
	private Object RankTableColName[] = { "강의 번호", "강의 이름","개설 학과"};
	
	private Object StuTableColName[] = { "학번","학생 이름", "소속 학과","학점"};

	private JTable RankTable;
	private JTable StuTable;

	private JScrollPane RankTableScrollPane;
	private JPanel StuListPanel;
	
	private JButton GetStuListBtn;
	private JButton GradeInsertBtn;
	private JButton returnBtn;
	
	private JScrollPane StuScrollPane;
	private JLabel InsStuLabel;
	private JPanel profCoursePanel;
	
	private JRadioButton aRank;
	private JRadioButton bRank;
	private JRadioButton cRank;
	private JRadioButton dRank ;
	private JRadioButton fRank;
	private ButtonGroup  RankRadioGroup;

	
	ProfRankInsertView(){
		initWindow();
		initComps();
		addComps();
	}
	@Override
	public void initComps() {
		// TODO Auto-generated method stub
		ct = getContentPane();
		ct.setLayout(null);
		profCoursePanel = new JPanel();
		profCoursePanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		profCoursePanel.setBounds(54, 28, 488, 225);
		ct.add(profCoursePanel);

		RankTable = new JTable(RankTableRow, RankTableColName);
		RankTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		
		Label CListLabel = new Label("내 강의 목록");
		profCoursePanel.add(CListLabel);
		RankTableScrollPane = new JScrollPane(RankTable);
		RankTableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		RankTableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		RankTableScrollPane.setPreferredSize(new Dimension(447, 160));
		profCoursePanel.add(RankTableScrollPane);
		
		GetStuListBtn = new JButton("해당 강의 학생명단보기");
		profCoursePanel.add(GetStuListBtn);
		
		StuListPanel = new JPanel();
		StuListPanel.setBounds(54, 297, 488, 236);
		ct.add(StuListPanel);
		
		StuTable = new JTable(StuTableRow, StuTableColName);
		RankTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		
		InsStuLabel = new JLabel("해당 강의 학생 명단");
		StuListPanel.add(InsStuLabel);
		
		StuScrollPane = new JScrollPane(StuTable);
		StuScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		StuScrollPane.setPreferredSize(new Dimension(447, 160));
		StuScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		StuListPanel.add(StuScrollPane);
		
		
		aRank = new JRadioButton("A");
		StuListPanel.add(aRank);
		bRank = new JRadioButton("B");
		StuListPanel.add(bRank);
		cRank = new JRadioButton("C");
		StuListPanel.add(cRank);
		dRank = new JRadioButton("D");
		StuListPanel.add(dRank);
		fRank = new JRadioButton("F");
		StuListPanel.add(fRank);

		RankRadioGroup = new ButtonGroup();
		
		RankRadioGroup.add(aRank);
		RankRadioGroup.add(bRank);
		RankRadioGroup.add(cRank);
		RankRadioGroup.add(dRank);
		RankRadioGroup.add(fRank);
		
		GradeInsertBtn = new JButton("성적 입력하기");
		StuListPanel.add(GradeInsertBtn);
		
		returnBtn = new JButton("돌아가기");
		returnBtn.setBounds(10, 637, 117, 29);
		ct.add(returnBtn);
		
	}

	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 600, 700);
		setTitle("성적확인");
		setVisible(true);
	}


	public JButton getStuListBtn() {
		return this.GetStuListBtn;
	}
	public JButton getReturnBtn() {
		return this.returnBtn;
	}
	public JButton getInsertBtn() {
		return this.GradeInsertBtn;
	}
	public ButtonGroup getBtnGroup() {
		return this.RankRadioGroup;
	}
	

	public String getSelectedButtonText( ) {
	     for (Enumeration<AbstractButton> buttons = RankRadioGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }
	        return null;
	   }
	
	
	public void setMyCourseList(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,RankTableColName);
		RankTable.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}
	
	public void setFocusCoStuList(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,StuTableColName);
		StuTable.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}
	
	public JTable getStuList() {
		return this.StuTable;
	}
	
	public JTable getMyCourseList() {
		return this.RankTable;
	}

	@Override
	public ArrayList<JButton> getButtonList() {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public void addListener(ActionListener a) {
		// TODO Auto-generated method stub
		GetStuListBtn.addActionListener(a);
		returnBtn.addActionListener(a);
		GradeInsertBtn.addActionListener(a);
	}
	public void AddMouseListener(MouseListener e) {
		RankTable.addMouseListener(e);
	}

}
