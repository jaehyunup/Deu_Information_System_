package CouserManageService;

import java.util.ArrayList;
import java.util.List;

import DataBaseSystem.CourseDataBaseService;
import DataBaseSystem.HaksaVO;
import DataBaseSystem.RankDataBaseService;
import DataBaseSystem.RankVO;
import mainpackage.Model;
import mainpackage.loginSpec;

public class CSmanagerPaymentModel  implements Model{
	private List<HaksaVO> StudentList;
	private loginSpec spec;
	private Object[][] StudentListRow;
	private ArrayList<Observer> list = new ArrayList<Observer>();



	public CSmanagerPaymentModel() {
			
	}

	CSmanagerPaymentModel(loginSpec spec) {
		this.spec = spec;
	}

	
	public Object[][] getStudentList() { //수강 신청을 한 모든학생들 리스트 가져오기.
		this. StudentList=CourseDataBaseService.getInstance().getEnrolStuList(); // 모든 학생리스트 가져오기
		StudentListRow = new Object[StudentList.size()][4];
		/*
		 * courses는 CourseVO 객체를 리스트로 담아두고 있다. 이것을 뷰에 들어갈수 있도록 적절하게 꾸며주는 로직을 만들어주는게 모델의
		 * 역할이다. 따라서 바로 리턴할것이 아니라 리스트를 가공해서 뷰가 잘알아먹게끔 쓸만하게 만들어 보내야 한다 이 메서드를 통해 영향을 받는
		 * View는 StudentEnrolmentView 의 Object 형의 AllCourseRow[][] 이다 . 그럼 그에맞게 반환해 보자
		 * 2차원 배열이기때문에 0,0 에는 강좌번호, 0,1에는 강좌이름 0,2이제는 개설학과, 0,3에는 교수,0,4에는 학점이 들어간다.
		 * 강좌정보는 다른방식으로보게 되어있으니 제외..
		 */
		for (int i = 0; i < this.StudentList.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			StudentListRow[i][0] = this.StudentList.get(i).getHaksaNum();
			StudentListRow[i][1] = this.StudentList.get(i).getHaksaName();
			StudentListRow[i][2] = this.StudentList.get(i).getHaksaDept();
			StudentListRow[i][3]= this.StudentList.get(i).getHaksaJumin();
		}
		
		notifyObserversCourseList(0);

		return StudentListRow;
	}
	
	public void registerObserver(Observer o) {
		list.add(o);
	}

	public void notifyObserversCourseList(int i) { // 등록된 모든 구독자 옵저버들에게 업데이트를 알린다.(내 수강 목록 모델의 변경을 알림)
		switch(i) {
		case 0:
			for (Observer o : list) {
				o.update(0,StudentListRow);
			}
			break;
		}
	
	}
}
