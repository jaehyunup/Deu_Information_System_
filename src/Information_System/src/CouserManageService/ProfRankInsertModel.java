package CouserManageService;

import java.util.ArrayList;
import java.util.List;

import DataBaseSystem.CourseVO;
import DataBaseSystem.RankDataBaseService;
import DataBaseSystem.RankVO;
import mainpackage.Model;
import mainpackage.loginSpec;

public class ProfRankInsertModel  implements Model{
	private List<RankVO> myCourseList;
	private List<RankVO> myStdList;
	private loginSpec spec;
	private Object[][] ProfCourseRow;
	private Object[][] CourseStuRow;;


	ProfRankInsertModel() {
			
	}

	public ProfRankInsertModel(loginSpec spec) {
		this.spec = spec;
	}

	
	/*@return 강의번호,강의이름,개설학과*/
	public Object[][] getProfRankList() { // 교수의 모든 강좌 리스트 가져오기
		this. myCourseList=RankDataBaseService.getInstance().getProfCourse(spec);
		ProfCourseRow = new Object[myCourseList.size()][3];
		/*
		 * courses는 CourseVO 객체를 리스트로 담아두고 있다. 이것을 뷰에 들어갈수 있도록 적절하게 꾸며주는 로직을 만들어주는게 모델의
		 * 역할이다. 따라서 바로 리턴할것이 아니라 리스트를 가공해서 뷰가 잘알아먹게끔 쓸만하게 만들어 보내야 한다 이 메서드를 통해 영향을 받는
		 * View는 StudentEnrolmentView 의 Object 형의 AllCourseRow[][] 이다 . 그럼 그에맞게 반환해 보자
		 * 2차원 배열이기때문에 0,0 에는 강좌번호, 0,1에는 강좌이름 0,2이제는 개설학과, 0,3에는 교수,0,4에는 학점이 들어간다.
		 * 강좌정보는 다른방식으로보게 되어있으니 제외..
		 */
		for (int i = 0; i < this.myCourseList.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			ProfCourseRow[i][0] = this.myCourseList.get(i).getCourseNum();
			ProfCourseRow[i][1] = this.myCourseList.get(i).getCourseName();
			ProfCourseRow[i][2] = this.myCourseList.get(i).getCourseDept();
		}
		return ProfCourseRow;
	}
	
	public Object[][] getStuList(String coursenum){
		this. myStdList=RankDataBaseService.getInstance().getStuList(coursenum);
		CourseStuRow = new Object[myStdList.size()][4];
		/*
		 * courses는 CourseVO 객체를 리스트로 담아두고 있다. 이것을 뷰에 들어갈수 있도록 적절하게 꾸며주는 로직을 만들어주는게 모델의
		 * 역할이다. 따라서 바로 리턴할것이 아니라 리스트를 가공해서 뷰가 잘알아먹게끔 쓸만하게 만들어 보내야 한다 이 메서드를 통해 영향을 받는
		 * View는 StudentEnrolmentView 의 Object 형의 AllCourseRow[][] 이다 . 그럼 그에맞게 반환해 보자
		 * 2차원 배열이기때문에 0,0 에는 강좌번호, 0,1에는 강좌이름 0,2이제는 개설학과, 0,3에는 교수,0,4에는 학점이 들어간다.
		 * 강좌정보는 다른방식으로보게 되어있으니 제외..
		 */
		for (int i = 0; i < this.myStdList.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			CourseStuRow[i][0] = this.myStdList.get(i).getCourseNum();
			CourseStuRow[i][1] = this.myStdList.get(i).getCourseName();
			CourseStuRow[i][2] = this.myStdList.get(i).getCourseDept();
			CourseStuRow[i][3] = this.myStdList.get(i).getCourseRank();
		}		
		return CourseStuRow;
	}
	
	public void RankInsert(String Stdnum,String Coursenum,String Rank) {
		
		//if(RankDataBaseService.getInstance().setStuList(Stdnum, Coursenum, Rank)) {
		
		RankDataBaseService.getInstance().setStuList(Stdnum, Coursenum, Rank);
		//	return true;
		//}
			/*
		else {
			System.out.println("성적 정보 삽입 ERROR ! [MODEL].");
			return false;	

		}*/
	}
}
