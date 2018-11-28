package CouserManageService;
import java.util.ArrayList;
import mainpackage.loginSpec;
import mainpackage.loginType;

public class StudentMainModel implements CourseModel{
	/* 모델은 구독자(뷰) 에게 모델 업데이트에 대해 통지한다 
	 * 모델은  독립적이고, 리스너에 대해 모르고있다. 
	 * 모델의 메서드가 실행되면 컨트롤러를 통해 뷰를 .*/
		private loginType type;
		//private ArrayList<Observer>list = new ArrayList<Observer>();
		StudentMainModel(loginSpec loginSpec){
			this.type=loginSpec.getLogintype();
		}
		
		/*
		 public void registerObserver(Observer o) {
		 
			list.add(o);
		}
		
		public void notifyObservers() { // 등록된 모든 구독자 옵저버들에게 업데이트를 알린다.
			for(Observer o : list) {
				o.update(type);
			}
		}
		
		public void checkUserType(loginType type) {  // 유저 타입을 체크.
			
			notifyObservers();
		}
	 */
}
