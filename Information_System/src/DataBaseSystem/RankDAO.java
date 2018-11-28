package DataBaseSystem;

import java.util.ArrayList;
import java.util.List;

import mainpackage.loginSpec;

public interface RankDAO {    
    // MemberDAOservice dao = MemberDAOServiceImpl.getInstance();
    /**
     *강좌  삽입(가입, 생성)
     * @param userID
     * @return 교수의 아이디에 해당하는 강좌목록 RankVO 객체 리스트 
     */
    abstract List<RankVO> getProfCourse(loginSpec sp);
    
  
    /**
     * 해당 학생의 성적을 조회
     * 
     * @return 해당 학생 RankVO 객체 리스트
     */
    abstract List<RankVO> getMyRank(loginSpec spec);
    
    /**
     * 강좌  청강중인 학생 리스트가져오기(조회)
     * @param userID
     * @return 교수의 아이디에 해당하는 강좌목록 RankVO 객체 리스트 
     */
    abstract List<RankVO> getStuList(String coursenum);
 
    /**
     * 교수의 학생에 대한 성적입력(수정) - 수정인 이유는,기존에 ENROLMENT에 수강내역이 다 담겨있고, RANK가 NULL로 기본값이 되어있기 때문이다. 
     * @param userID
     * @return 성공시 true, 실패시 false 
     */
    abstract boolean setStuList(String stdnum,String Coursenum,String Rank);
 
    
}
