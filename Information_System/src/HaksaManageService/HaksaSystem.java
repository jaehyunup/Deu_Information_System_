package HaksaManageService;

import java.awt.Button;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.util.ArrayList;

public class HaksaSystem extends HaksaView{
	
	public static String user=null;
	String number=null;
	String name=null;
	
	Frame frame = new Frame("학사관리시스템");
	Button haksaInsert = new Button("새등록");
	Button haksaInquire = new Button("조회");
	Button haksaModify = new Button("수정");
	Button haksaDelete = new Button("삭제");
	ArrayList<Button> BtnList=new ArrayList<Button>();
	
	JLabel numLb;
	JLabel nameLb=new JLabel("이름");
	
	TextField numText = new TextField();
	TextField nameText = new TextField();
	public HaksaSystem() {
		
	}
	public HaksaSystem(String user) {
		this.user=user;
		if(user.equals("student")) {
			numLb=new JLabel("학번");
		}
		else {
			numLb=new JLabel("교수번호");
		}
		//createFrame();
		//haksaSetView(HaksaMainController controller);
	}
	public void createFrame() {
		System.out.println(user+"관리 시스템");
		
		frame.add(numLb);
		numLb.setBounds(180, 100, 50, 30);
		frame.add(numText);
		numText.setBounds(230, 100, 80, 30);
		frame.add(nameLb);
		nameLb.setBounds(320, 100, 50, 30);
		frame.add(nameText);
		nameText.setBounds(370, 100, 90, 30);
		
		frame.add(haksaInquire);
		haksaInquire.setBounds(500, 100, 80, 30);
		
		frame.add(haksaInsert);
		haksaInsert.setBounds(200, 550, 100, 30);
		
		frame.add(haksaModify);
		haksaModify.setBounds(350, 550, 100, 30);
		
		frame.add(haksaDelete);
		haksaDelete.setBounds(500, 550, 100, 30);
		
		//haksaInquire.addActionListener((ActionListener) haksaController);
		//ActionListener e = null;
		
		//haksaInquire.addActionListener(e);
		//haksaInsert.addActionListener((ActionListener) haksaController);
		
		BtnList.add(haksaInquire);
		BtnList.add(haksaInsert);
		BtnList.add(haksaModify);
		BtnList.add(haksaDelete);
		
		frame.setLayout(null);
		frame.setSize(800, 700);
		frame.setVisible(true);
	}
	
	/*public void haksaSetView(HaksaMainController controller) {
		controller.setView(this);
	}*/
	
	public Button getHaksaInquireBtn() {
		return haksaInquire;
	}
	public Button getHaksaInsertBtn() {
		return haksaInsert;
	}
	public Button getHaksaModifyBtn() {
		return haksaModify;
	}
	public Button getHaksaDeleteBtn() {
		return haksaDelete;
	}
	public ArrayList<Button> getButtonList() {
		// TODO Auto-generated method stub
		return BtnList;
	}
	@Override
	public void addListener(ActionListener e) {
		haksaInquire.addActionListener(e);
		haksaInsert.addActionListener(e);
		haksaModify.addActionListener(e);
		haksaDelete.addActionListener(e);
	}
}

