package HaksaManageService;

import java.awt.Button;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HaksaUser extends HaksaView{
	Frame frame = new Frame("User 선택하기");
	Button studentUser = new Button("학생");
	Button professorUser = new Button("교수");
	
	public HaksaUser() {
		//createFrame();
		//haksaSetView();
		
	}
	public void createFrame() {
		frame.setLayout(null);
		
		
		frame.add(studentUser);
		studentUser.setBounds(230, 125, 100, 30);
		
		frame.add(professorUser);
		professorUser.setBounds(230, 200, 100, 30);
		
		frame.setSize(600, 400);
		frame.setVisible(true);
		
		//professorUser.addActionListener((ActionListener) haksaController);
		
	}
	
	/*public void haksaSetView(HaksaMainController controller) {
		controller.setView(this);
	}*/
	
	public Button getStuBtn() {
		return studentUser;
	}
	public Button getProfBtn() {
		return professorUser;
	}
	
	@Override
	public void addListener(ActionListener e) {
		studentUser.addActionListener(e);
	}
}
