package CouserManageService;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.Format;
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

public class StudentRankView extends JFrame implements View, Observer {
	private Container ct;
	private Object RankTableRow[][] = { { "Row0,col0", "Row0,col1", "Row0,col2", "Row0,col3", "Row0,col4" },
			{ "Row1,col0", "Row1,col1", "Row1,col2", "Row1,col3", "Row1,col4" }, };
	private Object RankTableColName[] = { "강좌 이름", "교수명", "개설학과", "학점", "성적" };
	private JTable RankTable;
	private JScrollPane scrollPane;
	private JPanel RankInfoPanel;
	private JButton OKBtn;
	private JLabel HakjumLabel;
	private JLabel HakjumVal;
	private JLabel GradeLabel;
	private JLabel GradeVal;
	private JLabel infolabel;

	public StudentRankView() {
		initComps();
		addComps();
		initWindow();
	}

	@Override
	public void initComps() {
		ct = getContentPane();
		// TODO Auto-generated method stub
		ct.setLayout(null);

		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(6, 17, 488, 260);
		ct.add(TablePanel);

		RankTable = new JTable(RankTableRow, RankTableColName);
		RankTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		scrollPane = new JScrollPane(RankTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(447, 210));
		TablePanel.add(scrollPane);
		infolabel = new JLabel("            * 총 취득 학점과 성적은 현재 성적이 입력되어진 과목 기준으로 책정되어집니다.        ");
		infolabel.setSize(260,20);
		TablePanel.add(infolabel);
		
		HakjumLabel = new JLabel("총 취득 학점 :");
		TablePanel.add(HakjumLabel);

		HakjumVal = new JLabel("    ");
		TablePanel.add(HakjumVal);

		GradeLabel = new JLabel("평균 성적 :");
		TablePanel.add(GradeLabel);

		GradeVal = new JLabel();
		TablePanel.add(GradeVal);

		RankInfoPanel = new JPanel();
		RankInfoPanel.setBounds(6, 289, 488, 156);
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

	public JButton getOkButton() {
		return this.OKBtn;
	}

	public void setRankTable(Object[][] List) {
		int hakjumtemp = 0; // 총 취득 학점 
		int totalhakjum=0;
		
		int totalgradehak=0; // 성적 * 학점값 
		DefaultTableModel Tablemodel = new DefaultTableModel(List, RankTableColName);
		for (int i = 0; i < List.length; i++) {
			hakjumtemp=0;
			if (!List[i][4].equals("F")) { // 성적이 F가 아닐때				
				if (List[i][4].equals("A")) {
					hakjumtemp=Integer.parseInt((String) List[i][3]);// 학점 문자열을 숫자로변환
					totalhakjum=totalhakjum+hakjumtemp;
					totalgradehak=totalgradehak+(hakjumtemp*4);
				}
				else if (List[i][4].equals("B")) {
					hakjumtemp =+Integer.parseInt((String) List[i][3]);// 학점 문자열을 숫자로변환
					totalhakjum=totalhakjum+hakjumtemp;
					totalgradehak=totalgradehak+(hakjumtemp*3);

				}
				else if (List[i][4].equals("C")) {
					hakjumtemp =+Integer.parseInt((String) List[i][3]);// 학점 문자열을 숫자로변환
					totalhakjum=totalhakjum+hakjumtemp;
					totalgradehak=totalgradehak+(hakjumtemp*3);
				}
				else if (List[i][4].equals("D")) {
					hakjumtemp=+Integer.parseInt((String) List[i][3]);// 학점 문자열을 숫자로변환
					totalhakjum=totalhakjum+hakjumtemp;
					totalgradehak=totalgradehak+(hakjumtemp);
				}			
			}
		}
		
		HakjumVal.setText(String.format("%d 점                     ", totalhakjum));
		GradeVal.setText(String.format("          %.1f 점", ((float)totalgradehak/totalhakjum)));

		RankTable.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}

	@Override
	public void update(int i, Object[][] Table) {
		System.out.println("랭크 목록갱신합니다");
		setRankTable(Table);
	}

	@Override
	public void update(String info) {
		// TODO Auto-generated method stub

	}

}
