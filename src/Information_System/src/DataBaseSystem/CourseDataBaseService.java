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


import javax.swing.JOptionPane;

import mainpackage.loginSpec;

public class CourseDataBaseService implements CourseDAO {
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
	// DB 연결정보
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String oracleURL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
	private static final String oracleID = "";
	private static final String oraclePW = "";

    private final static Logger LOG = Logger.getGlobal();

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
	 * 모든 강좌 리스트 가져오기
	 * 
	 * @return List<CourseVO> courses - "각 강의(CourseVO) 를 List에 모두 넣어서 반환"
	 * 
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
				course.setCoursePart(rs.getString("CPART"));
				courses.add(course);
			}
			// SQL 실행
		} catch (Exception e) {
		LOG.info("모든 강좌가져오기 실패: ");
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return courses;
	}

	/**
	 * 내가 수강신청한 강좌 리스트 가져오기
	 * 
	 * @return List<CourseVO> mycourses - " 내가 신청한 강의(CourseVO) 만 List에 모두 넣어서 반환"
	 */
	@Override
	public List<CourseVO> getMyCourse(loginSpec spec) {
		List<CourseVO> mycourses = new ArrayList<CourseVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "select s.CNO,s.CNAME,s.CDEPT,s.CPROF,s.CGRADE,s.CINFO\n"
				+ "from SECOURSE s join (select * from SEENROLMENTLIST WHERE SNUM='" + spec.getId()
				+ "')e on s.CNO=e.CNO";

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
			LOG.info("수강신청 내역  실패: ");
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
	public CourseVO getCourseInfo(String Cnum) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT CINFO FROM SECOURSE WHERE CNUM='" + Cnum + "'"; // SECOURSE 테이블 전체조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		CourseVO courseinfoVO = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				courseinfoVO = new CourseVO();// 대처법 : 레코드 (record,row)
				courseinfoVO.setCourseInfo(rs.getString("CINFO"));
			}
			// SQL 실행
		} catch (Exception e) {
			LOG.info("[데이터베이스]모든 강좌 정보 가져 오기 실패  ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return courseinfoVO;
	}

	/**
	 * 해당 강좌에 대한 최대 수강인원 확인.
	 * 
	 * @params 강좌 번호
	 * @return 최대 수강인원 return
	 */
	@Override
	public String NumberOfPart(String CourseNo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 학생의 수강신청 요청에 대한 삽입(수강내역에 삽입)
	 * 
	 * @params 강좌번호, 로그인 정보
	 * @return int errono(0:정상삽입완료 1: 이미 수강중인 강좌, 2 : 학점 초과, 3:sql excute error)
	 */
	@Override
	public int insertStdtoCourse(String courseno, loginSpec spec) {

		if (!isSameCourse(courseno, spec)) { // 수강 중복 확인
			return 1; // 수강 중복일시 에러
		} else if (!isMaxHakjum(courseno, spec)) { // 최대 학점 확인
			return 2; // 학점 초과일시 에러
		}

		/* 위에서수강 중복과 최대 학점이라는 제약조건을 뛰어넘어야 아래의 수강 신청 삽입 기능이 작동된다. */
		Connection conn = null;// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "insert into SEENROLMENTLIST values('"+spec.getId()+ "','"+courseno+"','null')";

		conn = this.getConnection(); // DB연결
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수강 신청을  성공 하였습니다.");
			} else {
				System.out.println("수강신청 실패 했습니다");
				return 3;
			}

		} catch (SQLException e) {
			System.out.println("insertMember SQLE : ");
			e.printStackTrace();
			return 3;
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return 0;
	}

	

	/**
	 * 학생 수강신청 강좌삭제(삭제)
	 * 
	 * @param CourseNO 강좌번호, loginSpec spec
	 * @Return errno , 0=정상처리 , 1= 중복수강 ,2=학점초과 ,3=SQL 내부문제
	 * 
	 */
	@Override
	public int deleteEnrolment(String courseno, loginSpec spec) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "DELETE FROM SEENROLMENTLIST WHERE SNUM=? AND CNO=?";
		try {

			pstmt = conn.prepareStatement(sql); // SQL 해석
			pstmt.setString(1, spec.getId());
			pstmt.setString(2, courseno);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("수강정보를 성공적으로 삭제했습니다.");
			} 
			else {
				System.out.println("수강정보 삭제에 실패했습니다.");
				return 1;
			}

		} catch (Exception e) {
			System.out.println("delete user  Error : ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return 0;
	}
	/*
	**
	 * 학생이 현재 max 학점인지 판단.
	 * 
	 * @params 강좌번호, 로그인 정보,
	 * @return bool
	 */
	private boolean isMaxHakjum(String courseno, loginSpec spec) {
		int courseGrd=getCourseGrade(courseno);
		Connection conn = null;// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "select sum(s.CGRADE) from SECOURSE s join (select CNO from SEENROLMENTLIST WHERE SNUM='"
				+ spec.getId() + "')e on s.CNO=e.CNO";
		ResultSet rs = null;// row(결과) 집합(set)
		conn = this.getConnection(); // DB연결
		try {
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


			rs = pstmt.executeQuery();
			if (!rs.first()) {
			    this.closeAll(conn, pstmt, rs);
			    return true;
			}
			while (rs.next()) {
				if (courseGrd+Integer.parseInt(rs.getString("sum(s.CGRADE)")) > 18) { // 18학점이상이라면?
					return false; // 최대학점 초과!
				}	
			}
		
		} catch (SQLException e) {
			System.out.println("수강신청 SQL 에러");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * 학생의 수강신청 요청이 중복수강신청인지 판단.
	 * 
	 * @params 강좌번호, 로그인 정보
	 * @return bool (true : 수강 중복 없음 , false :수강 중복 있음)
	 */
	private boolean isSameCourse(String courseno, loginSpec spec) {
		Connection conn = null;// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체

		String sql = "select CNO from SEENROLMENTLIST WHERE SNUM='" + spec.getId() + "'"; // 수강 내역에서중복이 있는지 확인할 SQL 문
		ResultSet rs = null;// row(결과) 집합(set)
		conn = this.getConnection(); // DB연결

		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (courseno.equals(rs.getString("CNO"))) { // 수강중인 강좌내역에서 현재 신청할 강좌가 이미 있다면?
					return false; // 이미 수강중인 강좌이다.
				}
			}
		} catch (SQLException e) {
			System.out.println("수강신청 SQL 에러");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return true;
	}
	
	private int getCourseGrade(String courseno) {
		int resultGrade=0;
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT CGRADE FROM SECOURSE WHERE CNO='" +courseno+ "'"; // SECOURSE 테이블 전체조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer.parseInt(rs.getString("CGRADE"));
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("모든 강좌가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return resultGrade;
	}
	
	private String Hakjum(String stdno) {
		int courseGrd=getCourseGrade(stdno);
		Connection conn = null;// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "select sum(s.CGRADE) from SECOURSE s join (select CNO from SEENROLMENTLIST WHERE SNUM='"
				+ stdno + "')e on s.CNO=e.CNO"; // 총학점 계산
		ResultSet rs = null;// row(결과) 집합(set)
		String hakjum = null;
		conn = this.getConnection(); // DB연결
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hakjum=rs.getString("sum(s.CGRADE)");
			}
		} catch (SQLException e) {
			System.out.println("수강신청 SQL 에러");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return hakjum; // 인자로 들어온학생의 학점을 반환.
	}

	public ArrayList<String> AllStuList() {
		// 수강신청한 학생의 SNUM 리스트
		Connection conn = null;// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "select SNUM from SEENROLMENTLIST group by SNUM"; /*수강신청한 모든 학생 리스트 */
		ResultSet rs = null;// row(결과) 집합(set)
		ArrayList<String> StuList = new ArrayList<String>();
		conn = this.getConnection(); // DB연결
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuList.add(rs.getString("SNUM"));
			}
		} catch (SQLException e) {
			System.out.println("수강신청한 학생 목록 가져오기 SQL 에러");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
	
		// TODO Auto-generated method stub
		return StuList;
	}

	@Override
	public List<HaksaVO> getEnrolStuList() {
		ArrayList<String> StuList=null;
		ArrayList<String> HakjumList =new ArrayList<String>();
       // 결국연산후 위 두개의 결과값은 각 인덱스가 일치하고, 학생 번호와, 학점값이다.
		
		StuList=AllStuList(); // 수강신청한 학생의 스트링 리스트.
		for(int i=0;i<StuList.size();i++) {
			HakjumList.add(Hakjum(StuList.get(i))); //스트링 리스트에 부합하는 학점을 계산.
		}
		
		// 남은거 = 학생번호를 통해서리스트 행을 하나 만들고, 뒤에학점을 추가해준다.
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "select SNUM,SNAME,SDEPT,SJUMIN from SESTUDENT";
		// SESTUDENT 테이블 에서 해당학생의 정보를 받는다.
		// 
		List<HaksaVO> students = new ArrayList<HaksaVO>();// 리턴값을 만들어줘야지~!

		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		HaksaVO std = null;
		int i=0;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				std = new HaksaVO();// 대처법 : 레코드 (record,row)
				std.setHaksaNum(rs.getString("SNUM"));
				std.setHaksaName(rs.getString("SNAME"));
				std.setHaksaDept(rs.getString("SDEPT"));
				std.setHaksaJumin(rs.getString("SJUMIN"));
				//std.setHakjum(HakjumList.get(i));
				students.add(std);
				i++;
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("모든 강좌가져오기 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return students;
		
		// TODO Auto-generated method stub
	}
@Override
	
public void registerLecture(String cno, String pname, String cmax, String cmin) {
	// TODO Auto-generated method stub
	if (check(cno)==true) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "INSERT INTO SELECTURE VALUES ('"+cno+"', "+cmax+", "+cmin+")";
		ResultSet rs=null;// row(결과) 집합(set)
//        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			// SQL 실행
		} catch (Exception e) {
			System.out.println("강의 등록 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
	
		Connection conn2=this.getConnection();
		PreparedStatement pstmt2=null;
		String sql2="UPDATE SECOURSE SET CPROF='"+pname+"' WHERE CNO='"+cno+"'";
		ResultSet rs2=null;
		try {
			pstmt2 = conn2.prepareStatement(sql2); // SQL 해석
			rs2 = pstmt2.executeQuery();
		// SQL 실행
		} catch (Exception e) {
			System.out.println("강의 등록 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn2, pstmt2, rs2);
		}
	
		Connection conn3=this.getConnection();
		PreparedStatement pstmt3=null;
		String sql3="INSERT INTO SECHECK VALUES ('"+cno+"', 1)";
		ResultSet rs3=null;
		try {
			pstmt3 = conn3.prepareStatement(sql3); // SQL 해석
			rs3 = pstmt3.executeQuery();
			// SQL 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn3, pstmt3, rs3);
		}
	}
}

public void newRegister(String cno, String cname, String cdept, String cgrade, String cinfo, String pname) {
	// TODO Auto-generated method stub
	if(CourseCheck(cno)==true) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "INSERT INTO SECOURSE VALUES ('"+cno+"', '"+cname+"', '"+cdept+"', '"+pname+"', '"+cgrade+"', '"+cinfo+"', 60)";
		ResultSet rs=null;// row(결과) 집합(set)
//        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			// SQL 실행
		} catch (Exception e) {
			System.out.println("강좌 등록 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
	}
}

public void delete(String cno) {
	// TODO Auto-generated method stub
	if(check(cno)==true) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "DELETE FROM SECOURSE WHERE CNO='"+cno+"'";
		ResultSet rs=null;// row(결과) 집합(set)
//        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			// SQL 실행
		} catch (Exception e) {
			System.out.println("강좌 삭제 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
	}
}

public boolean check(String cno) {
	
	Connection conn=this.getConnection();
	PreparedStatement pstmt=null;
	String sql="SELECT * FROM SECHECK WHERE CNO='"+cno+"'";
	ResultSet rs=null;
	try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.isBeforeFirst()) {
			JOptionPane.showMessageDialog(null, "강의가 개설된 적이 있습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return false; // 강의가 개설된 적 있기 때문에 수행 불가
		}
	} catch(Exception e) {
		System.out.println("테이블 조회 실패 : ");
		e.printStackTrace();
	} finally {
		this.closeAll(conn, pstmt, rs);
	}
	return true;
}

public boolean CourseCheck(String cno) {
	
	Connection conn=this.getConnection();
	PreparedStatement pstmt=null;
	String sql="SELECT * FROM SECOURSE WHERE CNO='"+cno+"'";
	ResultSet rs=null;
	try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.isBeforeFirst()) {
			JOptionPane.showMessageDialog(null, "강좌가 개설되어 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return false; // 강의가 개설된 적 있기 때문에 수행 불가
		}
	} catch(Exception e) {
		System.out.println("테이블 조회 실패 : ");
		e.printStackTrace();
	} finally {
		this.closeAll(conn, pstmt, rs);
	}
	return true;
}

public void update(String cno, String cname, String cdept, String pname, String cgrade, String cinfo) {
	if(check(cno)==true) {
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "UPDATE SECOURSE SET CNAME='"+cname+"', CDEPT='"+cdept+"', CPROF='"+pname+"', CGRADE='"+cgrade+"', CINFO='"+cinfo+"' WHERE CNO='"+cno+"'";
		ResultSet rs=null;// row(결과) 집합(set)
//        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			// SQL 실행
		} catch (Exception e) {
			System.out.println("강좌 삭제 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
	}
}

}

