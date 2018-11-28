package LoginService;

import DataBaseSystem.userDataBaseService;

public class Test {
	public static void main (String[] args) {
		
		if(userDataBaseService.getInstance().getConnection() != null) {
			System.out.println("Database connection success");
			new LoginView();
		}
	}

}
