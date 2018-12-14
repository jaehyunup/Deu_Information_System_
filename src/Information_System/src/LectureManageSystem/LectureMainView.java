package LectureManageSystem;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

import mainpackage.View;

public class LectureMainView extends JFrame implements View{
	
	private Container lecFrame;
	private JPanel lecPanel;
	private JButton register, new_register, update, delete;
	private JButton ReturnBtn;

	public LectureMainView() {
		initComps();
		addComps();
		initWindow();
	}


	public JButton getRegister() {
		return register;
	}

	public JButton getNew_register() {
		return new_register;
	}

	public JButton getUpdate() {
		return update;
	}

	public JButton getDelete() {
		return delete;
	}
	public JButton getReturnBtn() {
	 return ReturnBtn;
	}
	

	public void addListener(ActionListener e) {
		register.addActionListener(e);
		new_register.addActionListener(e);
		delete.addActionListener(e);
		update.addActionListener(e);
		ReturnBtn.addActionListener(e);

		
	}

	@Override
	public void addMouseListener(MouseListener i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initComps() {
		lecFrame=getContentPane();
		lecPanel=new JPanel();
		lecPanel.setLayout(null);
		lecPanel.setBounds(0,0,600,400);
		lecFrame.add(lecPanel);
		register=new JButton("강의 등록");
		new_register=new JButton("새로운 강좌 등록");
		delete=new JButton("강좌 삭제");
		update=new JButton("강좌 정보 변경");
		ReturnBtn=new JButton("돌아가기");
		register.setBounds(120, 50, 150, 50);
		new_register.setBounds(120, 120, 150, 50);
		delete.setBounds(120, 190, 150, 50);
		update.setBounds(120,260, 150,50);
		ReturnBtn.setBounds(120,330, 150,50);

	}

	@Override
	public void addComps() {
		lecPanel.add(register);
		lecPanel.add(new_register);
		lecPanel.add(delete);
		lecPanel.add(update);
		lecPanel.add(ReturnBtn);
	}

	@Override
	public void initWindow() {
		setTitle("수업 관리 서비스");
		setBounds(500,200,400, 460);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);		
		setVisible(true);
		// TODO Auto-generated method stub
		
	}

}
