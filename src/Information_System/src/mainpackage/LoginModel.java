package mainpackage;

import DataBaseSystem.userDAO;
import DataBaseSystem.userDataBaseService;

/*
 * 사용자관리기능의 모델 클래스.
 * loginAccount 메서드는 컨트롤러에서 받아온 아이디와 비밀번호를 
 * 데이터베이스시스템 객체를 통해 데이터베이스로 보내준다.
 * changePW 메서드는 컨트롤러를 통해 변경할 비밀번호를 받아온 뒤,
 * spec객체에 저장되어 있는 아이디와 변경할 비밀번호를 데이터베이스객체를 통해 데이터베이스시스템으로 보내서 업데이트에 성공할 수 있다.
 */

public class LoginModel implements Model {
	static private loginSpec spec;
	
	public LoginModel() {
		
	}
	
	public void setSpec(loginSpec spec) {
		this.spec = spec;
	}
	
	public boolean loginAccount(String id, String pw) {
    	userDAO dao = userDataBaseService.getInstance();
    	
    	try {
			if (dao.findAccount(id, pw)) {
				System.out.println("로그인성공");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return false;
    }
	
	public boolean changePW(String newpw) {
		String id = spec.getId();
		userDAO dao = userDataBaseService.getInstance();
		
		try {
			if(dao.updatePW(id, newpw)) {
				System.out.println("변경성공");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
