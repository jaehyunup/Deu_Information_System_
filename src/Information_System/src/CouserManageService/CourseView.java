package CouserManageService;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import mainpackage.loginSpec;

public interface CourseView  {
	/* 수강관리기능을 정의하는 인터페이스,학생 ,교수 ,수업 담당자의 뷰를 정의한다.*/
    public static final String S_TITLE = " 수강 관리 기능";
    /*수강관리기능이라는 뷰 타이틀은 다 같으니 상수 선언 */
    //public abstract void CourseView(loginSpec spec);
	public abstract void initComps();
	public abstract void addComps();
	public abstract void initWindow();
	public abstract void addListener(ActionListener e);
	public abstract void dispose();
	public abstract ArrayList<JButton> getButtonList();
}
