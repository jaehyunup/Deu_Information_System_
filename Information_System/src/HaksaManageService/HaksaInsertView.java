package HaksaManageService;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class HaksaInsertView extends HaksaView{
	
	
	Frame frame = new Frame("학사 새 등록");
	
	Button register = new Button("등록하기");
	Button cancel = new Button("취소하기");
	
	TextField numText = new TextField();
	TextField nameText = new TextField();
	TextField deptText = new TextField();
	TextField juminText = new TextField();
	
	JLabel numLb=new JLabel("학번");;
	JLabel nameLb=new JLabel("이름");
	JLabel deptLb=new JLabel("학과");
	JLabel juminLb=new JLabel("주민번호");
	
	
	public HaksaInsertView() {
		/*super(user);
		if(user.equals("student")) {
			numLb=new JLabel("�븰踰�");
		}
		else {
			numLb=new JLabel("援먯닔踰덊샇");
		}*/
		//createFrame();
		//haksaSetView();
	}
	
	public void createFrame() {
		//System.out.println(user+"�깉 �벑濡� �떆�뒪�뀥");
		frame.add(numLb);
		numLb.setBounds(170, 100, 50, 30);
		frame.add(numText);
		numText.setBounds(230, 100, 100, 30);
		
		frame.add(nameLb);
		nameLb.setBounds(180, 150, 50, 30);
		frame.add(nameText);
		nameText.setBounds(230, 150, 100, 30);
		
		frame.add(deptLb);
		deptLb.setBounds(180, 200, 50, 30);
		frame.add(deptText);
		deptText.setBounds(230, 200, 100, 30);
		
		frame.add(juminLb);
		juminLb.setBounds(150, 250, 80, 30);
		frame.add(juminText);
		juminText.setBounds(230, 250, 100, 30);
		
		frame.add(register);
		register.setBounds(180, 300, 100, 30);
		frame.add(cancel);
		cancel.setBounds(290, 300, 100, 30);
		
		frame.setLayout(null);
		frame.setSize(600, 400);
		frame.setVisible(true);
		
		//register.addActionListener((ActionListener) haksaController);
		//ActionListener e = null;
		
		//register.addActionListener(e);
		//cancel.addActionListener((ActionListener) haksaController);
		
	}
	/*public void haksaSetView(HaksaMainController controller) {
		controller.setView(this);
	}*/
	public Button getRegisterBtn() {
		return register;
	}
	public Button getCancelBtn() {
		return cancel;
	}
	
	public String getName() {
		return nameText.getText();
	}
	public String getNum() {
		return numText.getText();
	}
	public String getDept() {
		return deptText.getText();
	}
	public String getJumin() {
		return juminText.getText();
	}

	@Override
	public void addListener(ActionListener e) {
		register.addActionListener(e);
		cancel.addActionListener(e);
	}
}
