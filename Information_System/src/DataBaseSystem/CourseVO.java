package DataBaseSystem;

import mainpackage.loginSpec;

public class CourseVO {
	private String CourseNo;
    private String CourseName;
    private String CourseDept;
    private String CourseProf;
    private String CourseGrade;
    private String CourseInfo;
    
    public CourseVO() {}
    /**
     * 멤버 필드 초기화 생성자
     *
     * @param userId 회원 아이디
     * @param userPw 회원 패쓰워드
     */

    /**
     * 객체 필드들(내용) 확인
     * @see java.lang.Object#toString()
     */
 
    public CourseVO(String CourseNo,String CourseName,String CourseDept,String CourseProf,String CourseGrade,String CourseInfo) {
    		this.CourseNo = CourseNo;
    		this.CourseName = CourseName;
    		this.CourseDept = CourseDept;
    		this.CourseProf = CourseProf;
    		this.CourseGrade = CourseGrade;
    		this.CourseInfo=CourseInfo;
}
    @Override
    public String toString() {
        return String.format("CourseVO [ 강좌 번호=%s, "
                                     + "강좌 이름=%s,"+"개설학과 =%s,"+"교수=%s,"+"학점 =%s,"+"강좌 정보 =%s,",CourseNo,CourseName,CourseDept,CourseProf,CourseGrade,CourseInfo);
       
       
    }
 
    public String getCourseNo() {
        return CourseNo;
    }
 
 
    public String getCourseName() {
		return CourseName;
	}


	public String getCourseDept() {
		return CourseDept;
	}


	public String getCourseProf() {
		return CourseProf;
	}


	public String getCourseGrade() {
		return CourseGrade;
	}



	public String getCourseInfo() {
		return CourseInfo;
	}

 
    public void setCourseNo(String courseNo) {
		this.CourseNo = courseNo;
	}

	public void setCourseName(String courseName) {
		this.CourseName = courseName;
	}

	public void setCourseDept(String courseDept) {
		this.CourseDept = courseDept;
	}

	public void setCourseProf(String courseProf) {
		this.CourseProf = courseProf;
	}

	public void setCourseGrade(String courseGrade) {
		this.CourseGrade = courseGrade;
	}

	public void setCourseInfo(String courseInfo) {
		this.CourseInfo = courseInfo;
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
        if (!(obj instanceof CourseVO)) { //userVO객체와 타입이 다르다면.
            return false;
        }
        CourseVO other = (CourseVO) obj;  
        // 만약 같은 객체라면 obj를 other userVO로캐스팅.
      
        if (CourseNo == null) {
            if (other.CourseNo != null) {
                return false;
            }
        } else if (!CourseName.equals(other.CourseName)) {
            return false;
        }
        
        if (CourseDept == null) {
            if (other.CourseDept != null) {
                return false;
            }
        } else if (!CourseDept.equals(other.CourseDept)) {
            return false;
        }
       
        
        if (CourseProf == null) {
            if (other.CourseProf != null) {
                return false;
            }
        } else if (!CourseProf.equals(other.CourseProf)) {
            return false;
        }
        
        if (CourseGrade == null) {
            if (other.CourseGrade != null) {
                return false;
            }
        } else if (!CourseGrade.equals(other.CourseGrade)) {
            return false;
        }
        if (CourseInfo == null) {
            if (other.CourseInfo != null) {
                return false;
            }
        } else if (!CourseInfo.equals(other.CourseInfo)) {
            return false;
        }
       // 같은 UserVO 객체라면 true를 반환한다.
        return true;
    }

	
 
}
