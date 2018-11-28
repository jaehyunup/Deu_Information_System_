package CouserManageService;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class StudentRankView extends JFrame implements CourseView{
	private Container ct;
	private Object RankTableRow[][] = {
			{ "Row0,col0", "Row0,col1", "Row0,col2", "Row0,col3", "Row0,col4" },
			{ "Row1,col0", "Row1,col1", "Row1,col2", "Row1,col3", "Row1,col4" },
	};
	private Object RankTableColName[] = { "강좌 이름", "교수명", "개설학과", "학점", "성적" };
	private JTable RankTable;
	private JScrollPane scrollPane;
	private JPanel RankInfoPanel;
	private JButton OKBtn;
	
	
	StudentRankView(){
		initComps();
		addComps();
		initWindow();
	}
	@Override
	public void initComps() {
		ct=getContentPane();
		// TODO Auto-generated method stub
		ct.setLayout(null);

		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(6, 17, 488, 375);
		ct.add(TablePanel);

		RankTable = new JTable(RankTableRow, RankTableColName);
		RankTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		scrollPane = new JScrollPane(RankTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(447, 160));
		TablePanel.add(scrollPane);

		RankInfoPanel = new JPanel();
		RankInfoPanel.setBounds(6, 237, 488, 146);
		ct.add(RankInfoPanel);
		
		OKBtn = new JButton("확인");
		RankInfoPanel.add(OKBtn);
	}

	
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 500, 600);
		setTitle("성적확인");
		setVisible(true);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(ActionListener e) {
		OKBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}
	public JButton getOkButton(){
		return this.OKBtn;
	}
	
	
	public void setRankTable(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,RankTableColName);
		RankTable.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}

	@Override
	public ArrayList<JButton> getButtonList() {
		// TODO Auto-generated method stub
		return null;
	}
	
  }


