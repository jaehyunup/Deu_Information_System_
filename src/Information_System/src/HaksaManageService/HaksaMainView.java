package HaksaManageService;

import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainpackage.View;

public class HaksaMainView extends JFrame implements View{
	private Container ct;
	
	private JButton ProfBtn;
	private JButton StuBtn;
	private JButton ReturnBtn;

	
	public HaksaMainView() {
		initComps();
		addComps();
		initWindow();
	}
	
	@Override
	public void initComps() {
		ct=getContentPane();		
		ProfBtn = new JButton("교수 정보 관리");
		StuBtn = new JButton("학생 정보 관리");	
		ReturnBtn=new JButton("돌아가기");
	}

	@Override
	public void addComps() {
		ct.add(ProfBtn);
		ProfBtn.setBounds(70, 30, 150, 50);
		ct.add(StuBtn);
		StuBtn.setBounds(70, 110, 150, 50);
		ct.add(ReturnBtn);
		ReturnBtn.setBounds(70, 190, 150, 50);
	}
	@Override
	public void initWindow() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(580,200,300, 300);
		setVisible(true);
	}
	
	public JButton getStuBtn() {
		return ProfBtn;
	}
	
	public JButton getProfBtn() {
		return StuBtn;
	}
	
	public JButton getReturnBtn() {
		return this.ReturnBtn;
	}

	@Override
	public void addListener(ActionListener e) {
		ProfBtn.addActionListener(e);
		StuBtn.addActionListener(e);		
		ReturnBtn.addActionListener(e);
	}
	

	
}
