package LoginService;

import DataBaseSystem.userDAO;
import DataBaseSystem.userDataBaseService;

public class ChangePasswordModel {
	public ChangePasswordModel() {
		
	}
	
	public boolean changePW(String newpw, String confirmpw) {
		/*
		userDAO dao = userDataBaseService.getInstance();
		
		try {
			if(dao.ChangePW("S001", newpw)) {
				System.out.println(newpw);
				System.out.println("변경성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return false;
	}
}
