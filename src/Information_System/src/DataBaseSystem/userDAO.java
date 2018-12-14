package DataBaseSystem;

import java.util.List;


public interface userDAO {
	// 컨트롤러 역할을할  DAO 클래의 원형
    
    // MemberDAOservice dao = MemberDAOServiceImpl.getInstance();
    
    /**
     * 로그인 확인
     * 

    * @param user id : 회원 아이디
     * @param userPw : 회원 비밀번호

     * @throws Exception 예외처리
     */
    //public boolean isLogin(String userid,String userPw) throws Exception ;
    
    /**
     * 로그인을 위해 입력된 아이디와 비밀번호를 데이터베이스와 비교
     * 
     * @param id : 입력 받은 아이디
     * @param pw : 입력 받은 비밀번호
     * @return
     */
    public boolean findAccount(String id, String pw) throws Exception;
    
    /**
     * 암호 변경. Password update
     * 
     * @param id: 로그인 된 아이디
     * @param pw: 변경할 비밀번호
     * @return
     * @throws Exception
     */
    public boolean updatePW(String id, String pw) throws Exception;
    
}

