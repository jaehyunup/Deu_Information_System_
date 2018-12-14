package HaksaManageService;

import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position.Bias;

import mainpackage.View;

public class HaksaInsertView extends JFrame implements View{
	private String[] dept= {"전산학과","전자공학과","화학공학과","기계공학과","항공우주공학과"};
	
	private Container ct;
	
	private JButton register;
	private JButton cancel;
	
	private TextField numText;
	private TextField nameText;
	private TextField firstJuminText;
	private TextField lastJuminText;
	
	private JLabel numLb;
	private JLabel nameLb;
	private JLabel deptLb;
	private JLabel juminLb;
	private JLabel sign;
	private JComboBox deptCombo;
	
	public HaksaInsertView() {
		initComps();
		addComps();
		initWindow();
	}
	
	
	
	
	
	public void initWindow() {
		setTitle("학사 정보 등록");
		setLayout(null);
		setBounds(350,150,600, 400);
		setVisible(true);
	}
	
	public JButton getRegisterBtn() {
		return register;
	}
	public JButton getCancelBtn() {
		return cancel;
	}
	
	public void valueAlarm() {
		JOptionPane.showMessageDialog(ct, "값을 입력해주세요.");
	}
	public void confirmAlarm(){
		JOptionPane.showMessageDialog(ct, "이미 존재하는 학번/교수번호 입니다.");
	}
	
	public void okAlarm() {
		JOptionPane.showMessageDialog(ct, "성공적으로 추가되었습니다.");

	}
	
	public String getName() {
		return nameText.getText();
	}
	public String getNum() {
		return numText.getText();
	}
	public String getFirstJumin() {
		return firstJuminText.getText();
	}
	public String getLastJumin() {
		return lastJuminText.getText();
	}

	
	public JComboBox getDeptCombo() {
		return deptCombo;
	}







	@Override
	public void addListener(ActionListener e) {
		register.addActionListener(e);
		cancel.addActionListener(e);
		deptCombo.addActionListener(e);
	}

	@Override
	public void initComps() {
		ct= getContentPane();
		
		numLb=new JLabel("학번 / 교번");
		
		nameLb=new JLabel("이름");
		deptLb=new JLabel("학과");
		juminLb=new JLabel("주민번호");
		sign=new JLabel("-");
		
		register = new JButton("등록하기");
		cancel = new JButton("취소하기");
		
		numText = new TextField();
		nameText = new TextField();
		firstJuminText=new TextField();
		lastJuminText=new TextField();
		
		deptCombo = new JComboBox(dept);		
	}

	@Override
	public void addComps() {
		ct.add(numLb);
		numLb.setBounds(150, 100, 55, 30);
		ct.add(numText);
		numText.setBounds(230, 100, 100, 30);
		
		ct.add(nameLb);
		nameLb.setBounds(180, 150, 50, 30);
		ct.add(nameText);
		nameText.setBounds(230, 150, 100, 30);
		
		ct.add(deptLb);
		deptLb.setBounds(180, 200, 50, 30);
		ct.add(deptCombo);
		deptCombo.setBounds(230, 200, 100, 30);
		
		ct.add(juminLb);
		juminLb.setBounds(150, 250, 80, 30);
		ct.add(firstJuminText);
		firstJuminText.setBounds(230, 250, 100, 30);
		ct.add(sign);
		sign.setBounds(340, 250, 10, 30);
		ct.add(lastJuminText);
		lastJuminText.setBounds(355, 250, 100, 30);
		
		ct.add(register);
		register.setBounds(180, 300, 100, 30);
		ct.add(cancel);
		cancel.setBounds(290, 300, 100, 30);
	}

	
	
}
