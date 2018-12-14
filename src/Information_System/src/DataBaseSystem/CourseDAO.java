package DataBaseSystem;

import java.util.List;

import mainpackage.loginSpec;

public interface CourseDAO {    
    // MemberDAOservice dao = MemberDAOServiceImpl.getInstance();
    /**
     *강좌  삽입(가입, 생성)
     * 
     * @param CourseVO  강좌 정보  객체(VO)
     * @throws Exception 예외처리
     */
    abstract void  insertCourse(CourseVO coursevo) throws Exception;
    
  
    /**
     * 전체 강좌 조회(검색)
     * 
     * @return 전체 강좌 객체 리스트
     * @throws Exception 예외처리
     */
    abstract List<CourseVO> getAllCourse();
    
    /**
     * 개별 강좌 조회(검색)
     * 
     * @param CourseName 강좌 이름
     * @return 개별 강좌정보 객체(CourseVO)
     * @throws Exception 예외처리
     */
    abstract CourseVO getCourseSearch(String CourseName);
    
    
   
    /**
     * 전체 강좌 조회(검색)
     * 
     * @return 전체 강좌 객체 리스트
     * @throws Exception 예외처리
     */
    abstract List<CourseVO> getMyCourse(loginSpec spec);
    
    /**
     *  강좌 정보 조회
     * 
     * @return  강좌정보 String 
     * 
     */
    public CourseVO getCourseInfo(String Cnum) ;

  
    /**
     * 개별 강좌 수정(갱신, 변경)
     * 
     * @param CourseVO 개별 강좌정보 객체
     * @throws Exception 예외처리
     */
    abstract void updateCourse(CourseVO coursevo);
    
    
    

    /**
     * 수강인원  조회 
     * 
     * @param CourseNO 강좌번호
     * @throws Exception 예외처리
     */
    abstract String NumberOfPart(String CourseNo);
  
    
    /**
     *  학생의 수강신청( EnrolmentList 테이블에 삽입) 
     *  필수 체크사항 1.최대학점(18학점)을 넘었는지 ?넘었다면 실패.
     *                        2. 같은 과목 수강 신청인지? 같은과목을 신청한다면 실패.
     * @param CourseNO 강좌번호,loginspec 유저정보
     * @Return errno , 0=정상처리 , 1= 중복수강 ,2=학점초과 ,3=SQL 내부문제
     */
    
	abstract int insertStdtoCourse(String courseno, loginSpec spec);    


	  /**
     * 학생 수강신청  강좌삭제(삭제)
     * 
     * @param CourseNO 강좌번호, loginSpec  spec
     * 
     */
    abstract int deleteEnrolment(String courseno,loginSpec spec);    
    
    /**
     *  수강 신청한 모든 학생의 테이블을 반환( 신청 학점도 포함)
     * 
     * @param CourseNO 강좌번호, loginSpec  spec
     * 
     */
    abstract List<HaksaVO> getEnrolStuList();

    abstract void registerLecture(String cno, String pname, String cmax, String cmin);
    
}
