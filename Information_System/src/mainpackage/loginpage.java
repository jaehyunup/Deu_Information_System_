package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;

import CouserManageService.CourseManageService;
import DataBaseSystem.userDAO;
import DataBaseSystem.userDataBaseService;
import DataBaseSystem.userVO;

import java.util.*;
public class loginpage {

	private loginSpec loginSucessSpec;

	public loginpage(loginSpec loginspec) { // 로그인 페이지가 생성될때는, 로그인 스펙 객체를 이어받아서 사용한다.
		login(loginspec);
		//logincheck(loginspec);
	} 
	
	private loginSpec logincheck(loginSpec loginspec) {
		userDAO dao=userDataBaseService.getInstance();  // DAO 객체 생성으로,userDataBaseServic 의인스턴스를 받아온다 
        try {
			if(dao.isLogin(loginspec.getId(), loginspec.getPw())==true){  // DAO에구현되어있는 isLogin메서드를 실행한다 
				//로그인이 성공했을때
				
			}
			else {
				//로그인이 실패했을때
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginspec;

	}

	
	   
	/*
	 이 loginpage는 로그인 후에 나오는 페이지 이고, 여기서 학사관리,수업관리 등등 메뉴가, loginspec에 따라 달라져야 한다.
	따라서 mvc 패턴을 이용해 loginspec 모델에 대한 view 를 생성하고 그를관장하는 컨트롤러에서 이벤트를 통해서다른 뷰로 이동 .
	*/

	void login(loginSpec loginSpec) { // 실제 로그인 메서드
			CourseManageService csService=new CourseManageService(loginSpec);
			 
	}
}
