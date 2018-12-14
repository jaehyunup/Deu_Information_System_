package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userDataBaseService implements userDAO {
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
    // DB 연결정보
    private static final String oracleDriver = "oracle.jdbc.driver.OracleDriver";
    private static final String oracleURL = ":@sedb.deu.ac.kr:1521:orcl";
    private static final String oracleID = "";
    private static final String oraclePW = "";
 
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
 
/*
  //개별 회원 정보 조회(검색)
    @Override
    public boolean isLogin(String userid, String userPw) throws Exception {
        Connection conn = this.getConnection();// 연결 객체
        PreparedStatement pstmt = null;// SQL 해석 객체
        String sql = "SELECT * FROM LOGIN WHERE ID=? AND PW=?"; // USER 테이블에서 아이디에 해당하는 사람.
        ResultSet rs = null;// row(결과) 집합(set)
        userVO user = new userVO(); // 유저 데이터 객체생성.
        try {
 
            pstmt = conn.prepareStatement(sql); // SQL 해석
            pstmt.setString(1, userid);
            pstmt.setString(2, userPw);
 
            rs = pstmt.executeQuery();
 
            while (rs.next()) {
                user.setUserId(rs.getString("ID")); //해당 Resultset의 member id,pw 를 get한다.
                user.setUserPw(rs.getString("PW")); 
            }
 
        } catch (Exception e) {
            System.out.println("select user Error : ");
            e.printStackTrace();
            return false;
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return true; // 회원 정보를 검색 및 userVO로 반환
 
    }*/

    //로그인
    public boolean findAccount(String id, String pw) throws Exception {
    	char type = id.charAt(0);
    	String query = null;
    	Connection conn = this.getConnection();
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	userVO user = new userVO(); // 유저 데이터 객체생성.
    	
    	if(type == 'S') {
    		query = "SELECT * FROM SESTUDENT WHERE SNUM = '" + id + "'";
    	}
    	else if(type == 'P') {
    		query = "SELECT * FROM SEPROFESSOR WHERE PNUM = '" + id + "'";
    	}
    	else if(type == 'H' || type == 'G') {
    		query = "SELECT * FROM SEEMPLOYEE WHERE ENUM = '" + id + "'";
    		type = 'E';
    	}
    	
    	try {
    		pstm = conn.prepareStatement(query);
    		rs = pstm.executeQuery();
    		if(rs.next()) {
    			if (pw.equals(rs.getString(type + "PASSWORD"))) {
    				user.setUserId(rs.getString(type + "NUM")); //해당 Resultset의 member id,pw 를 get한다.
    				user.setUserPw(rs.getString(type + "PASSWORD"));
    				//System.out.println(user.getUserId() + "  " + user.getUserPw());
    				return true;
    			}
    			else
    				return false;
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		this.closeAll(conn, pstm, rs);
    	}

    		return false;
    }
    
    //암호 변경
    public boolean updatePW(String id, String pw) throws Exception{
    	char type = id.charAt(0);
    	String query = null;
    	Connection conn = this.getConnection();
    	PreparedStatement pstm = null;
    	if(type == 'S') {
    		query = "UPDATE SESTUDENT set SPASSWORD = '" + pw + "' WHERE SNUM = '" + id + "'";
    	}
    	else if(type == 'P') {
    		query = "UPDATE SEPROFESSOR set PPASSWORD = '" + pw + "' WHERE PNUM = '" + id + "'";
    	}
    	else if(type == 'H' || type == 'G') {
    		query = "UPDATE SEEMPLOYEE set EPASSWORD = '" + pw + "' WHERE ENUM = '" + id + "'";
    	}
    	
    	try {
				pstm = conn.prepareStatement(query);
				pstm.executeQuery();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
	    		this.closeAll(conn, pstm, null);
	    	}
    }


}