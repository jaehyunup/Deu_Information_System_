package LoginService;

import java.awt.*;
import javax.swing.*;

//암호변경 GUI
public class ChangePasswordView extends JFrame{
	private JFrame changepwframe;
	private JTextField newpw;
	private JTextField confirmpw;
	
	public ChangePasswordView() {
		super ("대학정보시스템");

		changepwframe = new JFrame();
		changepwframe.setBounds(800, 300, 500, 300);
		changepwframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changepwframe.getContentPane().setLayout(null);
		
		
		JLabel label = new JLabel("암호 변경");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		label.setBounds(210, 10, 500, 59);
		changepwframe.getContentPane().add(label);
		
		
		JButton ChangeBtn = new JButton("변경");
		ChangeBtn.setBounds(300, 103, 100, 100);
		//LoginBtn.setSize(100, 100);
		//LoginBtn.setLocation(441, 125);
		changepwframe.getContentPane().add(ChangeBtn);
		
		newpw = new JTextField();
		newpw.setBounds(90, 113, 130, 26);
		changepwframe.getContentPane().add(newpw);
		newpw.setColumns(10);
		
		confirmpw = new JTextField();
		confirmpw.setBounds(90, 183, 130, 26);
		changepwframe.getContentPane().add(confirmpw);
		confirmpw.setColumns(10);
		
		JLabel label_1 = new JLabel("새 비밀번호");
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		label_1.setBounds(90, 90, 300, 16);
		changepwframe.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("새 비밀번호 확인 ");
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		label_2.setBounds(90, 158, 300, 16);
		changepwframe.getContentPane().add(label_2);
		
		ChangePasswordController controller = new ChangePasswordController(this);
		ChangeBtn.addActionListener(controller);
		
		changepwframe.setVisible(true);
	}

	public JTextField getNewpw() {
		return newpw;
	}
	
	public void setNewpw(JTextField newpw) {
		this.newpw = newpw;
	}
	
	public JTextField getConfirmpw() {
		return confirmpw;
	}
	
	public void setConfirmpw(JTextField confirmpw) {
		this.confirmpw = confirmpw;
	}
}
