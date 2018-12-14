package CouserManageService;

import java.util.ArrayList;
import java.util.List;

import DataBaseSystem.CourseDAO;
import DataBaseSystem.CourseDataBaseService;
import DataBaseSystem.CourseVO;
import mainpackage.Model;
import mainpackage.loginSpec;

public class StudentEnrolmentModel implements Model {
	private List<CourseVO> AllCourses;
	private List<CourseVO> myCourses;
	private CourseVO CourseinfoVO;
	private loginSpec spec;
	private Object[][] AllCourseRow;
	private Object[][] MyCourseRow;
	private ArrayList<String> CourseInfoText;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	private int deleteResult;
	// 해당 모델의 값을받는 모델

	StudentEnrolmentModel() {

	}

	public StudentEnrolmentModel(loginSpec spec) {
		this.spec = spec;
	}

	public Object[][] getAllCourseList() { // 모든 강좌 리스트
		this.AllCourses = CourseDataBaseService.getInstance().getAllCourse();
		this.AllCourseRow = new Object[AllCourses.size()][6];
		CourseInfoText = new ArrayList<String>();
		/*
		 * courses는 CourseVO 객체를 리스트로 담아두고 있다. 이것을 뷰에 들어갈수 있도록 적절하게 꾸며주는 로직을 만들어주는게 모델의
		 * 역할이다. 따라서 바로 리턴할것이 아니라 리스트를 가공해서 뷰가 잘알아먹게끔 쓸만하게 만들어 보내야 한다 이 메서드를 통해 영향을 받는
		 * View는 StudentEnrolmentView 의 Object 형의 AllCourseRow[][] 이다 . 그럼 그에맞게 반환해 보자
		 * 2차원 배열이기때문에 0,0 에는 강좌번호, 0,1에는 강좌이름 0,2이제는 개설학과, 0,3에는 교수,0,4에는 학점이 들어간다.
		 * 강좌정보는 다른방식으로보게 되어있으니 제외..
		 */

		for (int i = 0; i < this.AllCourses.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			AllCourseRow[i][0] = this.AllCourses.get(i).getCourseNo();
			AllCourseRow[i][1] = this.AllCourses.get(i).getCourseName();
			AllCourseRow[i][2] = this.AllCourses.get(i).getCourseDept();
			AllCourseRow[i][3] = this.AllCourses.get(i).getCourseProf();
			AllCourseRow[i][4] = this.AllCourses.get(i).getCourseGrade();
			AllCourseRow[i][5] = this.AllCourses.get(i).getCoursePart(); // 수강인원
			CourseInfoText.add(this.AllCourses.get(i).getCourseInfo()); // 수강정보

		}
		notifyObserversCourseList(0);// 모델의 변경을 옵저버들에게알리기./(인자가 0은 전체 수강 강좌 테이블의 갱신을 말한다)
		return AllCourseRow;
	}

	
	public void refreshInfoText(int i) {
		notifyObserverinfocheck(this.CourseInfoText.get(i));
	}

	public Object[][] getMyCourseList() { // 수강 신청한 강좌 리스트 새로뽑기
		this.myCourses = CourseDataBaseService.getInstance().getMyCourse(spec);
		this.MyCourseRow = new Object[myCourses.size()][5];
		for (int i = 0; i < this.myCourses.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			MyCourseRow[i][0] = this.myCourses.get(i).getCourseNo();
			MyCourseRow[i][1] = this.myCourses.get(i).getCourseName();
			MyCourseRow[i][2] = this.myCourses.get(i).getCourseDept();
			MyCourseRow[i][3] = this.myCourses.get(i).getCourseProf();
			MyCourseRow[i][4] = this.myCourses.get(i).getCourseGrade();
		}
		notifyObserversCourseList(1);// 모델의 변경을 옵저버들에게알리기./(인자가 1은 학생의 수강신청내역 테이블의 변경을 말한다)
		return MyCourseRow;
	}

	public String getFocusCourseInfo() {
		this.CourseinfoVO = CourseDataBaseService.getInstance().getCourseInfo(spec.getId());
		return this.CourseinfoVO.getCourseInfo();

	}

	public int setStdCourse(String courseno) { // 이떄,내 수강신청 테이블이 변경되게 되는데 이것을 알릴때 옵저버를쓰면 의존성이 낮아지겠다.
		int errornum = CourseDataBaseService.getInstance().insertStdtoCourse(courseno, spec);
		getMyCourseList(); // 모델에 수강신청한 강좌 리스트 다시 불러오기.
		notifyObserversCourseList(1); // 모델의 변경을 옵저버들에게알리기./(인자가 1은 학생의 수강신청내역 테이블의 변경을 말한다)
		return errornum;
	}

	public int deleteCourse(String courseno) { // 이떄,내 수강신청 테이블이 변경되게 되는데 이것을 알릴때 옵저버를쓰면 의존성이 낮아지겠다.
		deleteResult = CourseDataBaseService.getInstance().deleteEnrolment(courseno, spec);
		getMyCourseList(); // 모델에 수강신청한 강좌 리스트 다시 불러오기.
		notifyObserversCourseList(1);// 모델의 변경을 옵저버들에게알리기./(인자가 1은 학생의 수강신청내역 테이블의 변경을 말한다)
		return deleteResult;
	}

	public void registerObserver(Observer o) {
		list.add(o);
	}

	public void notifyObserversCourseList(int i) { // 등록된 모든 구독자 옵저버들에게 업데이트를 알린다.(내 수강 목록 모델의 변경을 알림)
		switch(i) {
		case 0:
			for (Observer o : list) {
				o.update(0,AllCourseRow);
			}
			break;
		case 1:
			for (Observer o : list) {
				o.update(1,MyCourseRow);
			}
			break;
			
		}
	
	}

	public void notifyObserverinfocheck(String s) {
		for(Observer o :list) {
			o.update(s);
		}
	}

}
