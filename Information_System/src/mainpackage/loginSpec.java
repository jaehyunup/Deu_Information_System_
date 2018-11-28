package mainpackage;




public class loginSpec {
	// 로그인 할때 필요한 로그인 스펙 객체를 생성한다.
	private String id;
	private String pw;
	private loginType logintype;
	public loginSpec(String id, String pw, loginType logintype) {
		 this.id=id;
		 this.pw=pw;
		 this.logintype=logintype;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public loginType getLogintype() {
		return logintype;
	}
	
	
	
}
