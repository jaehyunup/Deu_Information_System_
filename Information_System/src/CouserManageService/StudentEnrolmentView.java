package CouserManageService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class StudentEnrolmentView extends JFrame implements CourseView {
	private Container ct;

	private JButton courseJoinButton;
	private JButton courseCancleButton;
	private JButton courseInfoButton;

	private JPanel CourseInfoPanel;
	private JPanel myCourseListPanel ;
	private JPanel allCoursePanel ;
	private JTable allCourseList;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;

	private JTable myCourseList;
	
	
	ArrayList<JButton> BtnList=new ArrayList<JButton>();
	private Object AllCourseRow[][]={ {"준비","Row0,col1","Row0,col2","Row0,col3","Row0,col4"}};
	/*{ {"Row0,col0","Row0,col1","Row0,col2","Row0,col3","Row0,col4"},
	}
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"},
			{"Row1,col0","Row1,col1","Row1,col2"}

};
   */  
	private Object MyCourseRow[][]= { {"Row0,col0","Row0,col1","Row0,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"}
};


    private Object AllCourseColName[]= { "강좌번호,","강좌이름","개설학과","담당교수","학점"};
    
    private Object MyCourseColName[]={ "강좌번호,","강좌이름","개설학과","담당교수","학점"};

	StudentEnrolmentView(){
		initWindow();
		initComps();
		addComps();
		
	}
	
	@Override
	public void initComps(){
		ct = getContentPane();
		
		CourseInfoPanel = new JPanel(); // 개설 강좌 정보
		CourseInfoPanel.setBounds(37, 265, 447, 178);
		
		myCourseListPanel = new JPanel(); // 내가 가입한 강좌
		myCourseListPanel.setBounds(551, 41, 385, 333);
		
		allCoursePanel = new JPanel(); // 개설강좌 목록
		allCoursePanel.setBounds(37, 33, 447, 169);
				
		allCourseList = new JTable(AllCourseRow,AllCourseColName);
		
		scrollPane = new JScrollPane(allCourseList);		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(447, 160));
		allCoursePanel.add(scrollPane);
	    
		ct.setLayout(null);
		ct.add(CourseInfoPanel);
		ct.add(myCourseListPanel);
		
		myCourseList = new JTable(MyCourseRow,MyCourseColName);
		scrollPane2= new JScrollPane(myCourseList);		
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setPreferredSize(new Dimension(447, 160));
		
		myCourseListPanel.add(scrollPane2);
		ct.add(allCoursePanel);
		
		 courseJoinButton = new JButton("수강신청 하기");
		courseJoinButton.setBounds(124, 214, 117, 29);
		ct.add(courseJoinButton);
		
		courseInfoButton = new JButton("강좌정보 보기");
		courseInfoButton.setBounds(242, 214, 117, 29);
		ct.add(courseInfoButton);
		
		 courseCancleButton = new JButton("수강 취소하기");
		 courseCancleButton.setBounds(679, 418, 117, 29);
		ct.add(courseCancleButton);
		
		JLabel allCourseLabel = new JLabel();
		allCourseLabel.setText("개설강좌 목록");
		allCourseLabel.setBounds(37, 17, 71, 16);
		ct.add(allCourseLabel);
		
		JLabel myCourseLabel = new JLabel();
		myCourseLabel.setText("나의 수강신청 내역");
		myCourseLabel.setBounds(551, 17, 106, 16);
		ct.add(myCourseLabel);


	}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
	
	
	

	    }
	
	@Override
	public void initWindow() {
		setBounds(400, 200, 950, 600);
		setTitle(S_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
  /*학생의 수강신청 뷰*/
	
	public JButton getCourseJoinButton() {
		return this.courseJoinButton;
	}
	
	public JButton getCourseInfoButton() {
		return this.courseInfoButton;
	}
	
	public JButton getCourseCancleButton() {
		return this.courseCancleButton;
	}

	public void setAllCourseRowList(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,AllCourseColName);
		allCourseList.setModel(Tablemodel);;
		ct.revalidate();
		ct.repaint();
	}
	
	public void setMyCourseRowList(Object[][] List) {
		DefaultTableModel Tablemodel=new DefaultTableModel(List,MyCourseColName);
		myCourseList.setModel(Tablemodel);
		ct.revalidate();
		ct.repaint();
	}
	@Override
	public void addListener(ActionListener e) {
		courseCancleButton.addActionListener(e);
		courseJoinButton.addActionListener(e);
		courseInfoButton.addActionListener(e);
		// TODO Auto-generated method stub
		
	}

@Override
public ArrayList<JButton> getButtonList() {
	// TODO Auto-generated method stub
	return null;
}

	
}
