package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mainpackage.loginSpec;

public class RankDataBaseService implements RankDAO{
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
    // DB 연결정보
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String oracleURL = ":@sedb.deu.ac.kr:1521:orcl";
	private static final String oracleID = "";
	private static final String oraclePW = "";
 
    // 싱글턴(singleton) 패턴
 
    private static RankDataBaseService instance = null;
 
    private RankDataBaseService() {
 
    }
 
    public static final RankDataBaseService getInstance() {
 
        if (instance == null) {
            instance = new RankDataBaseService();
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
    
    
    
  

	@Override
	public List<RankVO> getMyRank(loginSpec spec) {
		List<RankVO> RankCourses = new ArrayList<RankVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT CNAME,CPROF,CGRADE,CDEPT,CRANK"
				        + " FROM SECOURSE s join (SELECT CNO,CRANK FROM SEENROLMENTLIST WHERE SNUM='"+spec.getId()+"')r on s.CNO=r.CNO"; // SECOURSE 테이블 전체조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		RankVO RankCourse = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RankCourse = new RankVO();// 대처법 : 레코드 (record,row)
				RankCourse.setCourseName(rs.getString("CNAME"));
				RankCourse.setCourseProf(rs.getString("CPROF"));
				RankCourse.setCourseDept(rs.getString("CDEPT"));
				RankCourse.setCourseGrade(rs.getString("CGRADE"));
				RankCourse.setCourseRank(rs.getString("CRANK"));
				RankCourses.add(RankCourse);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("[데이터베이스]성적 가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return RankCourses;
	}

	
	 
    /**
     *  교수가 진행하는 강의목록 get 
     * 
     * @param conn DB연결 객체
     * @param pstmt SQL 해석 객체
     * @param rs 결과셋 객체
     */
	@Override
	public List<RankVO> getProfCourse(loginSpec spec) {
		List<RankVO> RankCourses = new ArrayList<RankVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT CNO,CNAME,CDEPT"
				        + " FROM SECOURSE " // SECOURSE 테이블 전체조회
				        +" WHERE CPROF=(SELECT PNAME FROM SEPROFESSOR WHERE PNUM='" + spec.getId()+"')";
				        
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		RankVO RankCourse = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RankCourse = new RankVO();// 대처법 : 레코드 (record,row)
				RankCourse.setCourseNum(rs.getString("CNO"));
				RankCourse.setCourseName(rs.getString("CNAME"));
				RankCourse.setCourseDept(rs.getString("CDEPT"));
				RankCourses.add(RankCourse);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("[데이터베이스]성적 가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return RankCourses;
		
	}

	@Override
	public List<RankVO> getStuList(String coursenum) {
		List<RankVO> CourseStdList = new ArrayList<RankVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT e.SNUM,s.SNAME,s.SDEPT,e.CRANK FROM SEENROLMENTLIST e join (SELECT * FROM SESTUDENT) s on e.SNUM=s.SNUM WHERE CNO='"+coursenum+"'";
				        
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		RankVO CourseStd = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseStd = new RankVO();// 대처법 : 레코드 (record,row)
				CourseStd.setCourseNum(rs.getString("SNUM"));
				CourseStd.setCourseName(rs.getString("SNAME"));
				CourseStd.setCourseDept(rs.getString("SDEPT"));
				CourseStd.setCourseRank(rs.getString("CRANK"));
				CourseStdList.add(CourseStd);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("[데이터베이스]성적 가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return CourseStdList;
		
	}

	@Override
	public boolean setStuList(String stdnum,String coursenum,String Rank) {
	        Connection conn = null;// 연결 객체
	        PreparedStatement pstmt = null;// SQL 해석 객체
	        String sql = "UPDATE SEENROLMENTLIST SET CRANK='"+Rank+"' WHERE SNUM='"+stdnum+"' AND CNO='"+coursenum+"'";
	 
	        conn = this.getConnection(); // DB연결
	        try {
	            pstmt = conn.prepareStatement(sql); // SQL 해석
	 
	            if (pstmt.executeUpdate() == 1) {
	                System.out.println("성공적으로 성적 정보를 저장하였습니다.");
	            } else {
	                System.out.println("성적 저장에 실패 했습니다");
	                return false;
	            }
	 
	        } catch (SQLException e) {
	            System.out.println("insertMember SQLE : ");
	            e.printStackTrace();
	        } finally {
	            this.closeAll(conn, pstmt, null);
	        }
        	return true;

	}
	
}
