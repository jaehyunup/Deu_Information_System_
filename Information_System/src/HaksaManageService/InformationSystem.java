package HaksaManageService;

public class InformationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HaksaModel model=new HaksaModel();
		HaksaView view= new HaksaUser();
		HaksaController haksaController = new HaksaMainController(model,view);
	}

}
