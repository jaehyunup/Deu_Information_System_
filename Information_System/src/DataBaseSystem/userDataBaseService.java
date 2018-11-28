package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDataBaseService implements userDAO {
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
    // DB 연결정보
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String oracleURL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
	private static final String oracleID = "a20143266";
	private static final String oraclePW = "20143266";
 
    // 싱글턴(singleton) 패턴
 
    private static userDataBaseService instance = null;
 
    private userDataBaseService() {
 
    }
 
    public static final userDataBaseService getInstance() {
 
        if (instance == null) {
            instance = new userDataBaseService();
        }
 
        return instance;
    }
 
    /**
     * DB 연결(connect)
     * 
     * @return DB연결 객체
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(oracleDriver);
            try {
                conn = DriverManager.getConnection(oracleURL, oracleID, oraclePW);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("DAO getConnection : " + oracleDriver);
            e.printStackTrace();
        }
        return conn;
 
    }
 
    /**
     * DB연결 자원 반납
     * 
     * @param conn DB연결 객체
     * @param pstmt SQL 해석 객체
     * @param rs 결과셋 객체
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();// 유효성검사 후 자원 반납
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("DB close");
            e.printStackTrace();
        }
 
    }
 
    //회원정보 삽입(가입,생성)
    @Override
    public void insertUser(userVO uservo) {
        Connection conn = null;// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,sysdate)";
 
        conn = this.getConnection(); // DB연결
        try {
            pstmt = conn.prepareStatement(sql); // SQL 해석
            pstmt.setString(1, uservo.getUserId());
            pstmt.setString(2, uservo.getUserPw());
 
            if (pstmt.executeUpdate() == 1) {
                System.out.println("성공적으로 회원 정보를 저장하였습니다.");
            } else {
                System.out.println("회원정보 저장에 실패 했습니다.");
            }
 
        } catch (SQLException e) {
            System.out.println("insertMember SQLE : ");
            e.printStackTrace();
        } finally {
 
            this.closeAll(conn, pstmt, null);
        }
    }
 
    //전체회원 정보 조회(검색)
    @Override
    public List<userVO> getAllUser() throws Exception {
        
        List<userVO> users = new ArrayList<userVO>();//리턴값을 만들어줘야지~!
        
        Connection conn = this.getConnection();// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "SELECT * FROM member";
        ResultSet rs = null;// row(결과) 집합(set)
        
//        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
        userVO user =null; 
        try {
 
            pstmt = conn.prepareStatement(sql); // SQL 해석
            rs = pstmt.executeQuery();
 
            while (rs.next()) {
 
                user = new userVO();//대처법 : 레코드 (record,row)
                user.setUserId(rs.getString("member_id"));
                user.setUserPw(rs.getString("member_pw"));
                
                users.add(user);
 
            }
 
            // SQL 실행
 
        } catch (Exception e) {
            System.out.println("get ALL USER Error : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return users;
        
 
    }
  //개별 회원 정보 조회(검색)
    @Override
    public boolean isLogin(String userid,String userPw) throws Exception {
        Connection conn = this.getConnection();// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "SELECT * FROM USER WHERE user_id=? AND user_pw=?"; // USER 테이블에서 아이디에 해당하는 사람.
        ResultSet rs = null;// row(결과) 집합(set)
        userVO user = new userVO(); // 유저 데이터 객체생성.
        try {
 
            pstmt = conn.prepareStatement(sql); // SQL 해석
            pstmt.setString(1, userid);
            pstmt.setString(2, userPw);
 
            rs = pstmt.executeQuery();
 
            while (rs.next()) {
                user.setUserId(rs.getString("user_id")); //해당 Resultset의 member id,pw 를 get한다.
                user.setUserPw(rs.getString("user_pw")); 
            }
 
        } catch (Exception e) {
            System.out.println("select user Error : ");
            e.printStackTrace();
            return false;
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return true; // 회원 정보를 검색 및 userVO로 반환
 
    }
    
    //개별 회원 정보 조회(검색)
    @Override
    public userVO getUser(String userid) throws Exception {
        Connection conn = this.getConnection();// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "SELECT * FROM USER WHERE user_id=?"; // USER 테이블에서 아이디에 해당하는 사람.
        ResultSet rs = null;// row(결과) 집합(set)
        userVO user = new userVO(); // 유저 데이터 객체생성.
 
        try {
 
            pstmt = conn.prepareStatement(sql); // SQL 해석
            pstmt.setString(1, userid);
 
            rs = pstmt.executeQuery();
 
            while (rs.next()) {
                user.setUserId(rs.getString("member_id")); //해당 Resultset의 member id,pw 를 get한다.
                user.setUserPw(rs.getString("member_pw")); 
            }
 
        } catch (Exception e) {
            System.out.println("select user Error : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return user; // 회원 정보를 검색 및 userVO로 반환
 
    }
    
    //개별 회원 정보 수정(갱신,변경)
    @Override
    public void updateUser(userVO uservo) throws Exception {
 
        Connection conn = this.getConnection();// 연결 객체 받기
        PreparedStatement pstmt = null;// SQL 해석 객체
        // Statement 사용시 SQL
        /*
         * String sql = "UPDATE member SET member_pw = '"+
         * memberVO.getMemberPw() +"'," +
         * "member_addr = '"+memberVO.getMemberAddr()+"' " +
         * "WHERE member_id = '"+memberVO.getMemberId()+"'";
         */
 
        // PreparedStatement 사용시 SQL
        /*
         * String sql = "UPDATE member SET member_pw=?," +
         * "                  member_addr=? " + "      WHERE member_id=?";
         */
 
        StringBuilder sql = new StringBuilder();
        /*
         * sql.append("UPDATE member SET "); sql.append("      member_pw=?,");
         * sql.append("      member_addr=? "); sql.append("WHERE member_id=?");
         */
     
        
        /*userTable  에서 해당 userid에 해당하는 userpw를 update(변경)하는 메서드*/
 
        sql.append("UPDATE USER SET ")
            .append("       user_pw=?,")
            .append(" WHERE user_id=?");
 
        try {
            pstmt = conn.prepareStatement(sql.toString());
 
            // SQL 인자처리
            pstmt.setString(1, uservo.getUserPw());
            pstmt.setString(2, uservo.getUserId());
 
            // SQL 실행
 
            if (pstmt.executeUpdate() == 1) {
                System.out.println("회원정보 수정에 성공하였습니다.");
 
            } else {
                System.out.println("회원정보 수정에 실패하였습니다.");
            }
        } catch (Exception e) {
            System.out.println("update User Error : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, null);
        }
 
    }
 
    //개별 회원 정보 삭제
    @Override
    public void deleteUser(String memberId) throws Exception {
        
        Connection conn = this.getConnection();// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "DELETE USER WHERE user_id=?";
        try {
 
            pstmt = conn.prepareStatement(sql); // SQL 해석
            pstmt.setString(1, memberId);
            if(pstmt.executeUpdate()==1){
                System.out.println("회원정보를 성공적으로 삭제했습니다.");
            }else{
                System.out.println("회원정보 삭제에 실패했습니다.");
            }
            
        } catch (Exception e) {
            System.out.println("delete user  Error : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return;
    }
 
}