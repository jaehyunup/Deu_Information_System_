package UserManageService;

import DataBaseSystem.userDAO;
import DataBaseSystem.userDataBaseService;
import mainpackage.loginSpec;

/*
 * 사용자관리기능의 모델 클래스.
 * Login컨트롤러와 ChangePassword컨트롤러가 함께 쓰인다.
 * loginAccount 메서드는 아이디와 비밀번호, 아이디의 첫 문자를 받아온 뒤 데이터베이스와 비교해주고
 * 그 값이 참이라면 아이디 첫문자에 따라 loginSpec객체를 생성해준다.
 * changePW 메서드는 변경할 비밀번호를 받아온 뒤, spec객체에 저장되어 있는 아이디와 변경할 비밀번호를 데이터베이스로 보내서
 * 업데이트에 성공할 수 있다.
 */

public class UserModel {
	static private loginSpec spec;
	
	public UserModel() {
		
	}
	
	public UserModel(loginSpec spec) {
		UserModel.spec = spec;
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
