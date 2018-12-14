package CouserManageService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import mainpackage.View;

public class StudentEnrolmentView extends JFrame implements View,Observer {

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
	private JButton ReturnBtn;
	private JTextArea infotext;
	
	
	ArrayList<JButton> BtnList=new ArrayList<JButton>();
	private Object AllCourseRow[][]={ {"준비","Row0,col1","Row0,col2","Row0,col3","Row0,col4"}};
	
	private Object MyCourseRow[][]= { {"Row0,col0","Row0,col1","Row0,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"},
				{"Row1,col0","Row1,col1","Row1,col2"}
};


    private Object AllCourseColName[]= { "강좌번호,","강좌이름","개설학과","담당교수","학점","수강인원"};
    
    private Object MyCourseColName[]={ "강좌번호","강좌이름","개설학과","담당교수","학점"};

	public StudentEnrolmentView(){
		initWindow();
		initComps();
		addComps();
	}
	
	@Override
	public void initComps(){
		ct = getContentPane();

		allCoursePanel = new JPanel(); // 개설강좌 목록
		allCoursePanel.setBounds(37, 41, 447, 169);
				

		CourseInfoPanel = new JPanel(); // 개설 강좌 정보
		CourseInfoPanel.setBounds(37, 265, 1110, 230);
		CourseInfoPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		infotext=new JTextArea("[여기에 선택된 강좌의 정보가 나타납니다]");
		infotext.setSize(30,1110);
		CourseInfoPanel.add(infotext);
        // create a line border with the specified color and width
       
		

		myCourseListPanel = new JPanel(); // 내가 가입한 강좌
		myCourseListPanel.setBounds(551, 41, 600, 220);
		
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
		scrollPane2.setPreferredSize(new Dimension(600, 160));
		
		myCourseListPanel.add(scrollPane2);
		ct.add(allCoursePanel);
		
		 courseJoinButton = new JButton("수강신청 하기");
		courseJoinButton.setBounds(124, 214, 117, 40);
		ct.add(courseJoinButton);
		
		courseInfoButton = new JButton("강좌정보 보기");
		courseInfoButton.setBounds(242, 214, 117, 40);
		ct.add(courseInfoButton);
		
		 courseCancleButton = new JButton("수강 취소하기");
		 courseCancleButton.setSize(600,40);
		 myCourseListPanel.add(courseCancleButton);
		
		JLabel allCourseLabel = new JLabel();
		allCourseLabel.setText("개설강좌 목록");
		allCourseLabel.setBounds(37, 17, 71, 16);
		ct.add(allCourseLabel);
		
		JLabel myCourseLabel = new JLabel();
		myCourseLabel.setText("나의 수강신청 내역");
		myCourseLabel.setBounds(551, 17, 106, 16);
		ct.add(myCourseLabel);
		
		ReturnBtn=new JButton("돌아가기");
		ReturnBtn.setBounds(37,510,80,40);
		ct.add(ReturnBtn);

	}
	
	@Override
	public void addComps() {
		// TODO Auto-generated method stub
	

	    }
	
	
	@Override
	public void initWindow() {
		setBounds(120, 150, 1200, 600);
		setTitle("수강신청");
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

	public JButton getReturnButton() {
		return this.ReturnBtn;
	}
	
	public JTable getAllCourseList() {
		return this.allCourseList;
	}
	
	public JTable getMyCourseList() {
		return this.myCourseList;
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
	
	
	public void setCourseInfo(String info) {
		this.infotext.setText(info);
	}
	
	@Override
	public void addListener(ActionListener e) {
		courseCancleButton.addActionListener(e);
		courseJoinButton.addActionListener(e);
		courseInfoButton.addActionListener(e);
		ReturnBtn.addActionListener(e);
	}
	
	public void AddMouseListener(MouseListener l) {
		allCourseList.addMouseListener(l);
	
	}
	
	public void CourseInsertResult(int resultnum) {
		switch(resultnum) {
		 case 0:
		      JOptionPane.showMessageDialog(null, "수강신청 완료", "수강신청", JOptionPane.PLAIN_MESSAGE);
		      break;
		 case 1:
		      JOptionPane.showMessageDialog(null, "같은 과목을 중복수강 신청하였습니다 .", "{ERROR]중복 수강신청", JOptionPane.WARNING_MESSAGE);
		      break;
		 case 2:
		      JOptionPane.showMessageDialog(null, "최대학점을 초과합니다  .", "[ERROR]최대학점초과", JOptionPane.WARNING_MESSAGE);
		      break;
		}	
	}
	
	public void CourseDeleteCheck(int resultnum) {
		switch(resultnum) {
		 case 0:
		      JOptionPane.showMessageDialog(null, "수강삭제 완료", "수강삭제", JOptionPane.PLAIN_MESSAGE);
		      break;
		 case 1:
		      JOptionPane.showMessageDialog(null, "수강 삭제에 실패 하였습니다 .", "{ERROR]수강 삭제 실패", JOptionPane.WARNING_MESSAGE);
		      break;
		}	
	}



@Override
public void update(int i,Object[][] Table) { // 수강 테이블이 변경되었다는것을 인지하는 업데이트메서드
		switch(i) {
		case 0:
			  setAllCourseRowList(Table);
			break;
		case 1:
			  setMyCourseRowList(Table);
			break;
			
		}
 }

@Override
public void update(String info) {
	setCourseInfo(info);	
	}
}



	

