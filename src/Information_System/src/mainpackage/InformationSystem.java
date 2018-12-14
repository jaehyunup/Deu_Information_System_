package mainpackage;

public class InformationSystem {
	public static void main(String[] args) {
			View view;
			Model model;
			MainController controller;
			view = new LoginView();
			model = new LoginModel();
			controller =new MainController(view,model);
	}
}
	
	

