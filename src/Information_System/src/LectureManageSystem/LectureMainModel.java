package LectureManageSystem;


import java.util.List;

import DataBaseSystem.CourseDataBaseService;
import DataBaseSystem.CourseVO;
import DataBaseSystem.ProfessorDataBaseService;
import DataBaseSystem.ProfessorVO;
import mainpackage.Model;

public class LectureMainModel implements Model{
	private String state;
	private List<CourseVO> CourseList; //개설된 강좌 정보를 담을 객체
	private List<ProfessorVO> ProfessorList;
	private Object[][] AllCourseRow;
	private Object[] Professor;
	private String dept, courseNum, courseName;
	
	public LectureMainModel() {
		state="main"; //초기 상태는 main 상태
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state=state;
	}
	
	public void setCourseList(){
		this.CourseList = CourseDataBaseService.getInstance().getAllCourse();
		this.AllCourseRow = new Object[CourseList.size()][6];
		
		for (int i = 0; i < this.CourseList.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			AllCourseRow[i][0] = this.CourseList.get(i).getCourseNo();
			AllCourseRow[i][1] = this.CourseList.get(i).getCourseName();
			AllCourseRow[i][2] = this.CourseList.get(i).getCourseDept();
			AllCourseRow[i][3] = this.CourseList.get(i).getCourseProf();
			AllCourseRow[i][4] = this.CourseList.get(i).getCourseGrade();
			AllCourseRow[i][5] = this.CourseList.get(i).getCourseInfo();
		}
	}
	
	public void setProfessorList() {
		this.ProfessorList = ProfessorDataBaseService.getInstance().getAllProfessor();
		this.Professor = new Object[ProfessorList.size()];
		
		for (int i = 0; i < this.ProfessorList.size(); i++) { // 교수 이름 저장
			Professor[i] = this.ProfessorList.get(i).getProfName();
		}
	}

	public Object[][] getAllCourseRow() {
		setCourseList();
		return AllCourseRow;
	}
	
	public void register(String cno, String pname, String cmax, String cmin) {
		CourseDataBaseService.getInstance().registerLecture(cno, pname, cmax, cmin);
	}
	
	public void newRegister(String cno, String cname, String cdept, String cgrade, String cinfo, String pname) {
		CourseDataBaseService.getInstance().newRegister(cno, cname, cdept, cgrade, cinfo, pname);
	}

	public Object[] getProfessorRow() {
		setProfessorList();
		return Professor;
	}

	public void delete(String cno) {
		// TODO Auto-generated method stub
		CourseDataBaseService.getInstance().delete(cno);
	}
	
	public void update(String cno, String cname, String cdept, String pname, String cgrade, String cinfo) {
		CourseDataBaseService.getInstance().update(cno, cname, cdept, pname, cgrade, cinfo);
	}
	
}
