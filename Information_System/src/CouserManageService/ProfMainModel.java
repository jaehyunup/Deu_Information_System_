package CouserManageService;

import mainpackage.loginSpec;
import mainpackage.loginType;

public class ProfMainModel implements CourseModel {
	private loginType type;
	//private ArrayList<Observer>list = new ArrayList<Observer>();
	ProfMainModel(loginSpec loginSpec){
		this.type=loginSpec.getLogintype();
	}
}
