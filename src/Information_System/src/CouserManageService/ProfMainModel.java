package CouserManageService;

import mainpackage.Model;
import mainpackage.loginSpec;
import mainpackage.loginType;

public class ProfMainModel implements Model {
	private loginType type;
	//private ArrayList<Observer>list = new ArrayList<Observer>();
	public ProfMainModel(loginSpec loginSpec){
		this.type=loginSpec.getLogintype();
	}
}
