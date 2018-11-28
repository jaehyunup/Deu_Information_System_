package CouserManageService;

import java.util.ArrayList;
import java.util.List;

import DataBaseSystem.CourseDAO;
import DataBaseSystem.CourseDataBaseService;
import DataBaseSystem.CourseVO;
import mainpackage.loginSpec;

public class StudentEnrolmentModel implements CourseModel {
	List<CourseVO> AllCourses;
	List<CourseVO> myCourses;
	CourseVO CourseinfoVO;
	loginSpec spec;
	Object[][] AllCourseRow;
	Object[][] MyCourseRow;

	StudentEnrolmentModel() {

	}

	StudentEnrolmentModel(loginSpec spec) {
		this.spec = spec;
	}

	public Object[][] getAllCourseList() { // 모든 강좌 리스트
		this.AllCourses = CourseDataBaseService.getInstance().getAllCourse();
		this.AllCourseRow = new Object[AllCourses.size()][5];
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
		}
		return AllCourseRow;
	}

	public Object[][] getMyCourseList() { // 수강 신청한 강좌 리스트
		this.myCourses = CourseDataBaseService.getInstance().getMyCourse(spec);
		this.MyCourseRow = new Object[myCourses.size()][5];
		for (int i = 0; i < this.myCourses.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			MyCourseRow[i][0] = this.myCourses.get(i).getCourseNo();
			MyCourseRow[i][1] = this.myCourses.get(i).getCourseName();
			MyCourseRow[i][2] = this.myCourses.get(i).getCourseDept();
			MyCourseRow[i][3] = this.myCourses.get(i).getCourseProf();
			MyCourseRow[i][4] = this.myCourses.get(i).getCourseGrade();
		}
		return MyCourseRow;
	}

	public String getFocusCourseInfo() {
		this.CourseinfoVO = CourseDataBaseService.getInstance().getCourseInfo(spec.getId());
		return this.CourseinfoVO.getCourseInfo();

	}

}
