package DataBaseSystem;

import java.util.List;

public interface userDAO {
	//  역할을할  DAO 클래의 원형
    
    // MemberDAOservice dao = MemberDAOServiceImpl.getInstance();
    /**
     * 회원정보 삽입(가입, 생성)
     * 
     * @param memberVO 회원정보 객체(VO)
     * @throws Exception 예외처리
     */
	abstract void insertUser(userVO uservo) throws Exception;
    
    // MemberVO[] getAllMembers() throws Exception;
    // ArrayList<MemberVO> getAllMembers() throws Exception;
    /**
     * 전체 회원정보 조회(검색)
     * 
     * @return 전체 회원정보 객체
     * @throws Exception 예외처리
     */
	abstract List<userVO> getAllUser() throws Exception;
    
    /**
     * 개별 회원정보 조회(검색)
     * 
     * @param memberId 회원 아이디
     * @return 개별 회원정보 객체(VO)
     * @throws Exception 예외처리
     */
	abstract userVO getUser(String memberId) throws Exception;
    
    /**
     * 개별 회원정보 수정(갱신, 변경)
     * 
     * @param memberVO 개별 회원정보 객체
     * @throws Exception 예외처리
     */
	abstract void updateUser(userVO uservo) throws Exception;
    
    
    
    /**
     * 개별 회원정보 삭제
     * 
     * @param memberId 회원 아이디
     * @throws Exception 예외처리
     */
    void deleteUser(String memberId) throws Exception;
    
    

    
    /**
     * 로그인 확인
     * 

    * @param user id : 회원 아이디
     * @param userPw : 회원 비밀번호

     * @throws Exception 예외처리
     */
    public boolean isLogin(String userid,String userPw) throws Exception ;
    
}

