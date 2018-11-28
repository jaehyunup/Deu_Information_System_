package LoginService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.*;

/* 암호변경 컨트롤러 클래스.
 * 정규식을 이용하여 변경하는 암호가 형식에 맞는지 체크하고, 
 * if문을 이용해 변경하는 암호를 다시 한번 확인한 후,
 * 올바른 암호라면 암호변경에 성공한다.
 */
public class ChangePasswordController implements ActionListener{
	private ChangePasswordView view;
	private ChangePasswordModel model;
	//private loginSpec spec;
	
	public ChangePasswordController(ChangePasswordView view) {
		this.view = view;
		model = new ChangePasswordModel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String npw = view.getNewpw().getText();
		String conpw = view.getConfirmpw().getText();
		String pwPattern = "^[A-Za-z0-9]*$";
		boolean pwcheck = Pattern.matches(pwPattern, npw);
		
		if(!npw.isEmpty() && !conpw.isEmpty()) {
			if(npw.length() == 7 && pwcheck == true) {
				if(npw.equals(conpw)) {
					//model.changePW(npw, conpw);
					System.out.println(npw + "\n" + conpw);
				}
				else {
					JOptionPane.showMessageDialog(null, "두 비밀번호가 다릅니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "다시 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
			
		else {
			JOptionPane.showMessageDialog(null, "빈칸을 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
		}
	}

}
