package DataBaseSystem;

import mainpackage.loginSpec;

public class userVO {
		// 유저 데이터를 담을 리터럴 객체
	    private String userid;
	    private String userpw;
	   
	    public userVO() {}
	    /**
	     * 멤버 필드 초기화 생성자
	     *
	     * @param userId 회원 아이디
	     * @param userPw 회원 패쓰워드
	     */
	    public userVO(String userid,String userpw) {
	        this.userid = userid;
	        this.userpw = userpw;
	    }
	    
	    public userVO(loginSpec loginspec) {
	    	this.userid=loginspec.getId();
	    	this.userpw=loginspec.getPw();
	    }
	 
	    /**
	     * 객체 필드들(내용) 확인
	     * @see java.lang.Object#toString()
	     */
	    @Override
	    public String toString() {
	        return String.format("userVO [userID=%s, "
	                                     + "userPW=%s,",userid,userpw);
	       
	       
	    }
	 
	    public String getUserId() {
	        return userid;
	    }
	 
	    public void setUserId(String userpw) {
	        this.userid = userpw;
	    }
	 
	    
	 
	    public String getUserPw() {
	        return userpw;
	    }
	 
	    public void setUserPw(String userpw) {
	        this.userpw = userpw;
	    }
	 

	 
	  
	 
	    /**
	     * 두 객체간 필드 값들 비교 (해쉬 코드값으로 비교)
	     * @see java.lang.Object#hashCode()
	     */
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((userid == null) ? 0 : userid.hashCode());
	        result = prime * result + ((userid == null) ? 0 : userpw.hashCode());
	        return result;
	    }
	 
	    /**
	     * 두 객체간 필드 값들 비교(참/거짓으로 비교)
	     * @see java.lang.Object#equals(java.lang.Object)
	     */
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) { // 객체 자기자신 이라면
	            return true;
	        }
	        if (obj == null) { // 인자로 쓰인 객체가 Null 이라면
	            return false;
	        }
	        if (!(obj instanceof userVO)) { //userVO객체와 타입이 다르다면.
	            return false;
	        }
	        userVO other = (userVO) obj;  
	        // 만약 같은 객체라면 obj를 other userVO로캐스팅.
	      
	        if (userid == null) {
	            if (other.userid != null) {
	                return false;
	            }
	        } else if (!userid.equals(other.userid)) {
	            return false;
	        }
	       
	        
	        if (userpw == null) {
	            if (other.userpw != null) {
	                return false;
	            }
	        } else if (!userpw.equals(other.userpw)) {
	            return false;
	        }
	       // 유저 아이디,비밀번호가 같다면 True를 반환한다. 
	        return true;
	    }
	 
	}

	
