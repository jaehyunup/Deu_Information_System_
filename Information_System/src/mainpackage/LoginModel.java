package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//데이터베이스를 연동하고, 데이터 입출력을 관리하는 클래스

public class LoginModel {
	private String url;
	private String user;
	private String password;
	private Connection conn = null;
	PreparedStatement pstm = null;
	private static LoginModel loginmodel = null;
    
	public static LoginModel getInstance() {
		if(loginmodel == null)
        	loginmodel = new LoginModel();
		
		return loginmodel;
    }
    
    private LoginModel() {
        
    }
    
    public boolean Initalize() { //데이터베이스 초기화 및 접속
        try {
        	user = "a20163333"; //데이터베이스 아이디
        	password = "20163333"; //데이터베이스 패스워드
        	url = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl"; //데이터베이스 주소
        	Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버를 찾아줌
            conn = DriverManager.getConnection(url,user,password); //DB 연결
            System.out.println("Database Connect Success");
            return true;
        } catch (ClassNotFoundException cnfe) {
        	System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
        } catch (SQLException e) {
        	System.out.println("DB 접속실패 : " + e.toString());
        } catch (Exception e) {
        	System.out.println("Unkonwn error");
        	e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean LoginCheck(String id) {
    	ResultSet rs = null;
        String query ="SELECT count(*) FROM LOGIN WHERE id = '"+id+"'";

        try {
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            rs.next();
            if(rs.getInt(1) == 0 ) {
            	System.out.println("Return True");
                return true; 
            }
            else {
            	System.out.println("Return False");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    /*
    public boolean CreateAccount(String id, String pw, int loginType) {
        String query = "INSERT INTO UserDatabase(loginType, id, pw) VALUES (" + loginType + ",'" + id + "', '" + pw + "')";
        
        try {
            pstm = conn.prepareStatement(query);
            pstm.executeUpdate(); //보내기만 하고 받을 데이터 없음
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }        

        return false;
    }*/
    
    public boolean LoginAccount(String id, String pw) { 
    	ResultSet rs = null;
    	String query = "SELECT * FROM LOGIN WHERE id = '" + id + "'";
    		
    	try {
    		pstm = conn.prepareStatement(query);
    		rs = pstm.executeQuery();
    		rs.next();
    		if (pw.equals(rs.getString("pw"))) {
    			return true;
    		}
    		else
    			return false;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			rs.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
    	}

    		return false;
    }
    
    public boolean ChangePW(String id, String pw) {
    	String query = "UPDATE LOGIN set PW ='"+pw+"' WHERE id='"+id+"'";
    	
    	try {
				pstm = conn.prepareStatement(query);
				pstm.executeQuery();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
    }
}

