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
     * 개별  강좌정보 삭제
     * 
     * @param CourseNO 강좌번호
     * @throws Exception 예외처리
     */
    abstract void deleteCourse(String CourseNo);
    
    
}
