package DataBaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HaksaDataBaseService implements HaksaDAO{
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String oracleURL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
	private static final String oracleID = "";
	private static final String oraclePW = "";
 
    private static HaksaDataBaseService instance = null;
 
    private HaksaDataBaseService() {
 
    }
 
    public static final HaksaDataBaseService getInstance() {
 
        if (instance == null) {
            instance = new HaksaDataBaseService();
        }
 
        return instance;
    }
 
 
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
 
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
    @Override
    public void insertHaksa(String user,String num, String name, String dept,String jumin) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        int error;
        if(user.equals("student")) {
        	sql = "INSERT INTO SESTUDENT VALUES ('"+num+"','"+name+"','"+dept+"','"+jumin+"',substr('"+jumin+"',instr('"+jumin+"','-')+1))";
        }
        else {
        	sql = "INSERT INTO SEPROFESSOR VALUES ('"+num+"','"+name+"','"+dept+"','"+jumin+"',substr('"+jumin+"',instr('"+jumin+"','-')+1))";
        }
 
        conn = this.getConnection(); // DB�뿰寃�
        try {
            pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
           // pstmt.setString(1, haksavo.getHaksaName());
           // pstmt.setString(2, haksavo.getUserPw());
 
            error= pstmt.executeUpdate() ;
            
            if (error == 1) {
               // System.out.println("오라클 연결 성공");
            } else if(error==0) {
                //System.out.println("오라클 연결 실패");
            }
        } catch (SQLException e) {
            System.out.println("insertMember SQLE : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, null);
        }
    }
    
    @Override
    public List<HaksaVO> getHaksaInfo(String user,String num,String name){
    	List<HaksaVO> searchInfo = new ArrayList<HaksaVO>();
    	
    	Connection conn = this.getConnection();// �뿰寃� 媛앹껜
		PreparedStatement pstmt = null;// SQL �빐�꽍 媛앹껜
		String sql;
		if(user.equals("student")) {
			sql = "SELECT SNUM,SNAME,SDEPT,SJUMIN FROM SESTUDENT WHERE SNUM='"+num+"' AND SNAME='"+name+"'"; // SECOURSE �뀒�씠釉� �쟾泥댁“�쉶
		}
		else {
			sql = "SELECT PNUM,PNAME,PDEPT,PJUMIN FROM SEPROFESSOR WHERE PNUM='"+num+"' AND PNAME='"+name+"'";
		}
		
		ResultSet rs = null;// row(寃곌낵) 吏묓빀(set)
//	        MemberVO member = new MemberVO();//二쇱쓽 媛숈� �젅肄붾뱶 諛섎났 �씤�뇙! =>�삤瑜�!
		HaksaVO HaksaInfo = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
			rs = pstmt.executeQuery();
			HaksaInfo = new HaksaVO();
			if (rs.next()) {
				//HaksaInfo = new HaksaVO();// ��泥섎쾿 : �젅肄붾뱶 (record,row)
				if(user.equals("student")) {
					HaksaInfo = new HaksaVO();
					HaksaInfo.setHaksaNum(rs.getString("SNUM"));
					HaksaInfo.setHaksaName(rs.getString("SNAME"));
					HaksaInfo.setHaksaDept(rs.getString("SDEPT"));
					HaksaInfo.setHaksaJumin(rs.getString("SJUMIN"));
					searchInfo.add(HaksaInfo);
				}
				else {
					HaksaInfo = new HaksaVO();
					HaksaInfo.setHaksaNum(rs.getString("PNUM"));
					HaksaInfo.setHaksaName(rs.getString("PNAME"));
					HaksaInfo.setHaksaDept(rs.getString("PDEPT"));
					HaksaInfo.setHaksaJumin(rs.getString("PJUMIN"));
					searchInfo.add(HaksaInfo);
				}
				
			}
			else {
				searchInfo.add(HaksaInfo);
			}
			// SQL �떎�뻾
		} catch (Exception e) {
			//System.out.println("[�뜲�씠�꽣踰좎씠�뒪]�꽦�쟻 媛��졇�삤湲� �떎�뙣: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
    	
    	return searchInfo;
    }
    
    @Override
    public List<HaksaVO> getAllHaksaInfo(String user){
    	List<HaksaVO> searchInfo = new ArrayList<HaksaVO>();
    	
    	Connection conn = this.getConnection();// �뿰寃� 媛앹껜
		PreparedStatement pstmt = null;// SQL �빐�꽍 媛앹껜
		String sql;
		if(user.equals("student")) {
			sql = "SELECT * FROM SESTUDENT"; // SECOURSE �뀒�씠釉� �쟾泥댁“�쉶
		}
		else {
			sql = "SELECT * FROM SEPROFESSOR";
		}
		
		ResultSet rs = null;// row(寃곌낵) 吏묓빀(set)
//	        MemberVO member = new MemberVO();//二쇱쓽 媛숈� �젅肄붾뱶 諛섎났 �씤�뇙! =>�삤瑜�!
		HaksaVO HaksaInfo = null;
		try {
			pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//HaksaInfo = new HaksaVO();// ��泥섎쾿 : �젅肄붾뱶 (record,row)
				if(user.equals("student")) {
					HaksaInfo = new HaksaVO();
					HaksaInfo.setHaksaNum(rs.getString("SNUM"));
					HaksaInfo.setHaksaName(rs.getString("SNAME"));
					HaksaInfo.setHaksaDept(rs.getString("SDEPT"));
					HaksaInfo.setHaksaJumin(rs.getString("SJUMIN"));
					searchInfo.add(HaksaInfo);
				}
				else {
					HaksaInfo = new HaksaVO();
					HaksaInfo.setHaksaNum(rs.getString("PNUM"));
					HaksaInfo.setHaksaName(rs.getString("PNAME"));
					HaksaInfo.setHaksaDept(rs.getString("PDEPT"));
					HaksaInfo.setHaksaJumin(rs.getString("PJUMIN"));
					searchInfo.add(HaksaInfo);
				}
			}
			// SQL �떎�뻾
		} catch (Exception e) {
			//System.out.println("[�뜲�씠�꽣踰좎씠�뒪]�꽦�쟻 媛��졇�삤湲� �떎�뙣: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
    	
    	return searchInfo;
    }
    
    @Override
    public int updateHaksa(String user,String num, String name, String dept,String jumin) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        int error=1;
        if(user.equals("student")) {
        	sql = "UPDATE SESTUDENT SET SNAME='"+name+"', SDEPT='"+dept+"', SJUMIN='"+jumin+"' WHERE SNUM='"+num+"'";
        }
        else {
        	sql = "UPDATE SEPROFESSOR SET PNAME='"+name+"', PDEPT='"+dept+"', PJUMIN='"+jumin+"' WHERE PNUM='"+num+"'";
        }
        conn = this.getConnection(); // DB�뿰寃�
        try {
            pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
           // pstmt.setString(1, haksavo.getHaksaName());
           // pstmt.setString(2, haksavo.getUserPw());
 
            error= pstmt.executeUpdate() ;
            
            if (error == 1) {
            	System.out.print(sql);
            } else if(error==0) {
            	// 실
            }
 
        } catch (SQLException e) {
            System.out.println("UPDATE SQL : "+sql);
            e.printStackTrace();
        } finally {
 
            this.closeAll(conn, pstmt, null);
        }
        return error;
    }
    
    @Override
    public int deleteHaksaInfo(String user,String num, String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        int error;
        if(user.equals("student")) {
        	sql = "DELETE FROM SESTUDENT WHERE SNUM='"+num+"' AND SNAME='"+name+"'";
        }
        else {
        	sql = "DELETE FROM SEPROFESSOR WHERE PNUM='"+num+"' AND PNAME='"+name+"'";
        }
        conn = this.getConnection(); // DB�뿰寃�
        try {
            pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
           // pstmt.setString(1, haksavo.getHaksaName());
           // pstmt.setString(2, haksavo.getUserPw());
 
            error= pstmt.executeUpdate() ;
            
            if (error == 1) {
            } else if(error==0) {
            	return 0;
                //System.out.println("오라클 연결 실패");
            }
            else {
            	return 0;
            }
 
        } catch (SQLException e) {
            System.out.println("insertMember SQLE : ");
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, null);
        }
    	return 1;

    }
    @Override
    public boolean confirmHaksa(String user, String num){
    	boolean result=true;
    	
    	Connection conn = this.getConnection();// �뿰寃� 媛앹껜
		PreparedStatement pstmt = null;// SQL �빐�꽍 媛앹껜
		String sql;
		if(user.equals("student")) {
			sql = "SELECT SNUM FROM SESTUDENT WHERE SNUM='"+num+"'"; // SECOURSE �뀒�씠釉� �쟾泥댁“�쉶
		}
		else {
			sql = "SELECT PNUM FROM SEPROFESSOR WHERE PNUM='"+num+"'";
		}
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql); // SQL �빐�꽍
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result=false;
			}
			// SQL �떎�뻾
		} catch (Exception e) {
			//System.out.println("[�뜲�씠�꽣踰좎씠�뒪]�꽦�쟻 媛��졇�삤湲� �떎�뙣: ");
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
    	
    	return result;
    }
}
