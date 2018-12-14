
package CouserManageService;
import mainpackage.loginType;

import java.sql.Connection;

import mainpackage.loginSpec;

/*
		 Author : 박재현
		 수강 관리 기능
		 ------------------------------------------------------------------------------------------------------------
		 기능적  이슈
		 1. 학생은 수강 관리 기능에서 수강신청 기능선택을 통해 강의정보를 통해 수강 신청이 가능하다
		 2. 학생은 수강 관리 기능에서 성적 조회 기능을 통해 금학기에 수강한 수강 내역에 대해 교수가 입력한 성적을 볼 수 있다
		 3. 교수는 수강 관리 기능에서 자신의 강좌를 신청한 학생의 명단을 확인 할 수 있다
		 4. 교수는수강 관리 기능에서 자신 강좌 학생 명단을 보고 성적을 입력 할 수 있다
		 5. 교수는 수강 관리 기능에서 출석부 조회 기능을 클릭해서 자신 담당 강의 출석부를 조회할 수 있다
	     6. 수업 담당자는 기존의 수강료 청구서 발급 시스템을 이용하여, 학생에게 수강료 청구서를 발급 할 수 있다.
	      ------------------------------------------------------------------------------------------------------------
*/

public class CourseManageService {
/* CouseManageService 는 수강 관리 기능을 클릭 했을때 생성되어진다. loginSpec 객체의 정보를 통해 학생,교수,수업 담당자의 GUI VIEW 는 달라져야한다 */
	   private loginSpec userSpec;
	   private CourseController controller;
	   private CourseView view;
	   private CourseModel model;
	   
	   	
	   public CourseManageService(loginSpec loginspec){ // 서비스  객체  생성자
		   userSpec=loginspec;
		   initController(loginspec);
	};
	
	 /*loginType에 따라서 GUI가 변경되어야 한다따라서 GUI 변경 모델은  GUI 상태 모델과. 정량화된 데이터를 담을어플리케이션 데이터 모델이 필요하다. */
	/*View 클래스는 데이터를 표시할 UI들의 구성요소가 들어가야함 */
	/* 컨트롤러는 사용자의 액션(마우스클릭,키클릭)등에 의해 실행되는 어플리케이션 코드를 캡슐화 한다.입력과 출력을 생성한다. 모델의 입력을 읽는다 */
	
	
	
   //Login spec에 따라서.보여주는View는 변경되어야 한다
	private void  initController(loginSpec spec) {		
		String Type=spec.getLogintype().toString();	
	//	controller=new MainController(model,view,spec);
		if(Type.equals("student")) { // 학생일때
			view = new StudentMainView(); // 학생 View
			model = new StudentMainModel(spec); // 학생 Model
			//model.registerObserver(view);  // 모델(생산자 )  <-  뷰(구독자)  옵저버 관계 형성
			controller = new MainController(model,view,spec); // 컨트롤러를 통한 뷰와 모델의 연결.			
		}
		else if(Type.equals("professor")) { //교수일떄		
			this.view = new ProfMainView();
			this.model = new ProfMainModel(spec);
			//model.registerObserver(view);  // 모델(생산자 )  <-  뷰(구독자)  옵저버 관계 형성
			controller = new MainController(model,view,spec); // 컨트롤러를 통한 뷰와 모델의 연결.	
		}
		else if(Type.equals("csmanager")) { // 수업 담당자
			   view = new CSmanagerMainView(); //교수  View
				model = new CSmanagerModel(); // 교수 Model
				//model.registerObserver(view);  // 모델(생산자 )  <-  뷰(구독자)  옵저버 관계 형성
				controller = new MainController(model,view,spec); // 컨트롤러를 통한 뷰와 모델의 연결.		
		}
			

	};
}
