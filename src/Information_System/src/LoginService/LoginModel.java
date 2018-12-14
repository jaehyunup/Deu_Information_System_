package LoginService;

import DataBaseSystem.userDataBaseService;
import DataBaseSystem.userDAO;


//데이터베이스를 연동하고, 데이터 입출력을 관리하는 클래스

public class LoginModel {
	private String userid;
	private String userpw;
	/*
	private String url;
	private String user;
	private String password;
	private Connection conn = null;
	PreparedStatement pstm = null;
	private static LoginModel loginmodel = null;
    
    */
    public LoginModel() {
       
    }
    
    public boolean loginAccount(String id, String pw) {
    	/*
    	userDAO dao = userDataBaseService.getInstance();
    	try {
			if (dao.loginAccount(id, pw)) {
				System.out.println("로그인성공");
				dao.isLogin(id, pw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	return false;
    }
    
    /*
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
    }*/

    
}

