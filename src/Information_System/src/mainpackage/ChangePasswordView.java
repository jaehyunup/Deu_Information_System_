package mainpackage;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 암호변경 GUI를 담당하는 클래스.
 */

public class ChangePasswordView extends JFrame implements View{
	private Container ct;
	private JPasswordField newPw;
	private JPasswordField confirmPw;
    private JLabel label_0;
	private JButton ChangeBtn;
	private JButton ReturnBtn;

	private JLabel label_1;
	private JLabel label_2;
	
	public ChangePasswordView() {
		 initComps();
		 addComps();
		 initWindow();
	}
	

	@Override
	public void initComps(){
		ct=getContentPane();
		ct.setLayout(null);
		label_0= new JLabel("암호 변경");
		label_0.setBounds(210, 10, 500, 59);
		
		ChangeBtn = new JButton("변경");
		ChangeBtn.setBounds(300, 103, 100, 100);

		newPw = new JPasswordField();
		newPw.setBounds(90, 113, 130, 26);
		newPw.setColumns(10);
		

		confirmPw = new JPasswordField();
		confirmPw.setBounds(90, 183, 130, 26);
		confirmPw.setColumns(10);
		
		label_1 = new JLabel("새 비밀번호");
		label_1.setBounds(90, 90, 300, 16);
	
		label_2 = new JLabel("새 비밀번호 확인 ");
		label_2.setBounds(90, 158, 300, 16);
		
		ReturnBtn = new JButton("돌아가기");
		ReturnBtn.setBounds(20, 230, 100, 20);
		
	}
	
	@Override
	public void addComps() {
		ct.add(label_0);
		ct.add(ChangeBtn);
		ct.add(newPw);
		ct.add(label_1);
		ct.add(label_2);
		ct.add(confirmPw);
		ct.add(ReturnBtn);
		

	}
	

	@Override
	public void initWindow() { //  창초기화
		setBounds(500, 200, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setVisible(true);
	}
	
	public void okMessage() {
		JOptionPane.showMessageDialog(null, "패스워드 변경 성공! 다시 로그인이 필요합니다", "변경 성공", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ckMessage() {
		JOptionPane.showMessageDialog(null, "두 비밀번호가 다릅니다.", "경고", JOptionPane.WARNING_MESSAGE);
	}
	
	public void pwMessage() {
		JOptionPane.showMessageDialog(null, "비밀번호는 영대소문자, 숫자포함 총 7자리로 구성되어야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
	}
	
	public void emptyMessage() {
		JOptionPane.showMessageDialog(null, "빈칸을 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	}

	public JButton getChangeBtn() {
		return ChangeBtn;
	}


	public void setChangeBtn(JButton changeBtn) {
		ChangeBtn = changeBtn;
	}



	public JPasswordField getNewpw() {
		return newPw;
	}
	
	public void setNewpw(JPasswordField newpw) {
		newPw = newpw;
	}
	
	public JPasswordField getConfirmpw() {
		return confirmPw;
	}
	
	public void setConfirmpw(JPasswordField confirmpw) {
		confirmPw = confirmpw;
	}
	


	public JButton getReturnBtn() {
		return ReturnBtn;
	}


	public void setReturnBtn(JButton returnBtn) {
		ReturnBtn = returnBtn;
	}


	@Override
	public void addListener(ActionListener e) {
		// TODO Auto-generated method stub
		ChangeBtn.addActionListener(e);
		ReturnBtn.addActionListener(e);
	}

}
