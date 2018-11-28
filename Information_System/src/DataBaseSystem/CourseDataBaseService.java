package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mainpackage.loginSpec;

public class CourseDataBaseService implements CourseDAO {
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
	// DB 연결정보
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String oracleURL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
	private static final String oracleID = "a20143266";
	private static final String oraclePW = "20143266";

	// 싱글턴(singleton) 패턴

	private static CourseDataBaseService instance = null;

	private CourseDataBaseService() {

	}

	public static final CourseDataBaseService getInstance() {

		if (instance == null) {
			instance = new CourseDataBaseService();
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
	 * @param conn  DB연결 객체
	 * @param pstmt SQL 해석 객체
	 * @param rs    결과셋 객체
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
	public void insertCourse(CourseVO coursevo) {

	}

	
	/**
	 *  모든 강좌 리스트 가져오기
	 * 
	 *@return List<CourseVO> courses  - "각 강의(CourseVO) 를  List에 모두 넣어서 반환"
	
	 */
	@Override
	public List<CourseVO> getAllCourse() {
		List<CourseVO> courses = new ArrayList<CourseVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT * FROM SECOURSE"; // SECOURSE 테이블 전체조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		CourseVO course = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				course = new CourseVO();// 대처법 : 레코드 (record,row)
				course.setCourseNo(rs.getString("CNO"));
				course.setCourseName(rs.getString("CNAME"));
				course.setCourseDept(rs.getString("CDEPT"));
				course.setCourseProf(rs.getString("CPROF"));
				course.setCourseGrade(rs.getString("CGRADE"));
				course.setCourseInfo(rs.getString("CINFO"));
				courses.add(course);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("모든 강좌가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return courses;
	}
	
	/**
	 *   내가 수강신청한 강좌 리스트 가져오기
	 *@return List<CourseVO> mycourses  - " 내가 신청한 강의(CourseVO) 만  List에 모두 넣어서 반환"
	 */
	@Override
	public List<CourseVO> getMyCourse(loginSpec spec) {
		List<CourseVO> mycourses = new ArrayList<CourseVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체		
		String sql="select s.CNO,s.CNAME,s.CDEPT,s.CPROF,s.CGRADE,s.CINFO\n" + 
				"from SECOURSE s join (select * from SEENROLMENTLIST WHERE SNUM='"+spec.getId()+"')e on s.CNO=e.CNO";
		
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		CourseVO course = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				course = new CourseVO();// 대처법 : 레코드 (record,row)
				course.setCourseNo(rs.getString("CNO"));
				course.setCourseName(rs.getString("CNAME"));
				course.setCourseDept(rs.getString("CDEPT"));
				course.setCourseProf(rs.getString("CPROF"));
				course.setCourseGrade(rs.getString("CGRADE"));
				course.setCourseInfo(rs.getString("CINFO"));
				mycourses.add(course);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("수강신청 내역  실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return mycourses;
	}
	
	

	@Override
	public CourseVO getCourseSearch(String CourseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCourse(CourseVO coursevo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCourse(String CourseNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public CourseVO getCourseInfo(String Cnum) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT CINFO FROM SECOURSE WHERE CNUM='"+Cnum+"'"; // SECOURSE 테이블 전체조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		CourseVO courseinfoVO= null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				courseinfoVO = new CourseVO();// 대처법 : 레코드 (record,row)
				courseinfoVO.setCourseInfo(rs.getString("CINFO"));
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("모든 강좌가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return courseinfoVO;
	}

}