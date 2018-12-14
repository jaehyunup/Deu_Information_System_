package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDataBaseService implements ProfessorDAO {

	
	// 실질적으로 데이터베이스와 접근하는 DAO 클래스
		// DB 연결정보
		private static final String oracleDriver = "oracle.jdbc.OracleDriver";
		private static final String oracleURL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
		private static final String oracleID = "";
		private static final String oraclePW = "";

		// 싱글턴(singleton) 패턴

		private static ProfessorDataBaseService instance = null;

		private ProfessorDataBaseService() {

		}

		public static final ProfessorDataBaseService getInstance() {

			if (instance == null) {
				instance = new ProfessorDataBaseService();
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
	public List<ProfessorVO> getAllProfessor() {
		List<ProfessorVO> Professor = new ArrayList<ProfessorVO>();// 리턴값을 만들어줘야지~!
		Connection conn = this.getConnection();// 연결 객체
		PreparedStatement pstmt = null;// SQL 해석 객체
		String sql = "SELECT PNAME FROM SEPROFESSOR"; // SEPROFESSOR 테이블에서 교수 이름 조회
		ResultSet rs = null;// row(결과) 집합(set)
//	        MemberVO member = new MemberVO();//주의 같은 레코드 반복 인쇄! =>오류!
		ProfessorVO prof = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL 해석
			rs = pstmt.executeQuery();
			while (rs.next()) {
				prof = new ProfessorVO();// 대처법 : 레코드 (record,row)
				prof.setProfName(rs.getString("PNAME"));
				Professor.add(prof);
			}
			// SQL 실행
		} catch (Exception e) {
			System.out.println("교수 조회 실패: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return Professor;
	}

}
