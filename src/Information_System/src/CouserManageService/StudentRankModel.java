package CouserManageService;

import java.util.ArrayList;
import java.util.List;

import DataBaseSystem.CourseDataBaseService;
import DataBaseSystem.CourseVO;
import DataBaseSystem.RankDataBaseService;
import DataBaseSystem.RankVO;
import mainpackage.Model;
import mainpackage.loginSpec;

public class StudentRankModel  implements Model{
	List<RankVO> myRankList;
	loginSpec spec;
	CourseVO CourseinfoVO;
	Object[][] MyRankRow;
	
	private ArrayList<Observer> RankOList = new ArrayList<Observer>();


	StudentRankModel() {

	}

	public StudentRankModel(loginSpec spec) {
		this.spec = spec;
	}

	public Object[][] getMyRankList() { // 모든 강좌 리스트
		this. myRankList=RankDataBaseService.getInstance().getMyRank(spec);
		MyRankRow = new Object[myRankList.size()][5];
		/*
		 * courses는 CourseVO 객체를 리스트로 담아두고 있다. 이것을 뷰에 들어갈수 있도록 적절하게 꾸며주는 로직을 만들어주는게 모델의
		 * 역할이다. 따라서 바로 리턴할것이 아니라 리스트를 가공해서 뷰가 잘알아먹게끔 쓸만하게 만들어 보내야 한다 이 메서드를 통해 영향을 받는
		 * View는 StudentEnrolmentView 의 Object 형의 AllCourseRow[][] 이다 . 그럼 그에맞게 반환해 보자
		 * 2차원 배열이기때문에 0,0 에는 강좌번호, 0,1에는 강좌이름 0,2이제는 개설학과, 0,3에는 교수,0,4에는 학점이 들어간다.
		 * 강좌정보는 다른방식으로보게 되어있으니 제외..
		 */

		for (int i = 0; i < this.myRankList.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			MyRankRow[i][0] = this.myRankList.get(i).getCourseName();
			MyRankRow[i][1] = this.myRankList.get(i).getCourseProf();
			MyRankRow[i][2] = this.myRankList.get(i).getCourseDept();
			MyRankRow[i][3] = this.myRankList.get(i).getCourseGrade();
			MyRankRow[i][4] = this.myRankList.get(i).getCourseRank();
		}
		notifyObserversCourseList(0);
		return MyRankRow;
	}
	
	public void registerObserver(Observer o) {
		RankOList.add(o);
	}

	public void notifyObserversCourseList(int i) { // 등록된 모든 구독자 옵저버들에게 업데이트를 알린다.(내 수강 목록 모델의 변경을 알림)
		switch(i) {
		case 0:
			for (Observer o : RankOList) {
				o.update(0,MyRankRow);
			}
			break;
		case 1:
			for (Observer o : RankOList) {
				o.update(1,MyRankRow);
			}
			break;
			
		}
	
	}
}
