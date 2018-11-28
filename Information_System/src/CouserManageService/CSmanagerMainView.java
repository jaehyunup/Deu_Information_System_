package CouserManageService;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainpackage.loginSpec;

public class CSmanagerMainView extends JFrame implements CourseView {
/* 수업 담당자의 메인 뷰 클래스*/
	private Container ct;
	private JPanel mainPanel;
	private JButton chargeBtn; // 청구서 발급 버튼 
	ArrayList<JButton> BtnList=new ArrayList<JButton>();

	@Override
	public void initComps(){ //뷰초기화
		ct = getContentPane();
		mainPanel=new JPanel();
		chargeBtn= new JButton("청구서 발급하기");
		BtnList.add(chargeBtn); // 버튼 리스트에 해당 버튼 추가.
		}
	
	@Override
	public void addComps() { // 컴포넌트 추가 부분
		ct.setLayout(new BorderLayout(5, 5));		
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(chargeBtn);
		ct.add(mainPanel);
		
	}
	
	@Override
	public void initWindow() { // 뷰 창  초기화
		setBounds(400,200, 600, 400);
		setTitle(S_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	@Override
	public void addListener(ActionListener e) {
		chargeBtn.addActionListener(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<JButton> getButtonList() {
		// TODO Auto-generated method stub
		return BtnList;
	}


}
