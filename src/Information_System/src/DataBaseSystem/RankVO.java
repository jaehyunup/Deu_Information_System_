package DataBaseSystem;

public class RankVO {
    private String CourseNum;
    private String CourseName;
    private String CourseProf;
    private String CourseDept;
    private String CourseGrade;
    private String CourseRank;

    
    public RankVO() {}
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
    
    public RankVO(String CourseName,String CourseProf,String CourseDept,String CourseGrade,String CourseRank) {
    		this.CourseName = CourseName;
    		this.CourseProf = CourseProf;
    		this.CourseDept = CourseDept;
    		this.CourseGrade = CourseGrade;
    		this.CourseRank=CourseRank;
}
    public RankVO(String CourseNum,String CourseName,String CourseDept) {
    	this.CourseNum=CourseNum;
    	this.CourseName = CourseName;
		this.CourseDept = CourseDept;
}
    @Override
    public String toString() {
        return String.format("LankVO [강좌 이름=%s,"+"담당교수 =%s,"+"개설학과 =%s,"+"학점 =%s,"+"성적  =%s,"
        			,CourseName,CourseProf,CourseDept,CourseGrade,CourseRank);
       
       
    }
 

	public String getCourseNum() {
		return CourseNum;
	}

	public void setCourseNum(String courseNum) {
		CourseNum = courseNum;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseProf() {
		return CourseProf;
	}

	public void setCourseProf(String courseProf) {
		CourseProf = courseProf;
	}

	public String getCourseDept() {
		return CourseDept;
	}

	public void setCourseDept(String courseDept) {
		CourseDept = courseDept;
	}

	public String getCourseGrade() {
		return CourseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		CourseGrade = courseGrade;
	}

	public String getCourseRank() {
		return CourseRank;
	}

	public void setCourseRank(String courseRank) {
		CourseRank = courseRank;
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
        RankVO other = (RankVO) obj;  
        // 만약 같은 객체라면 obj를 other userVO로캐스팅.
      
        if (CourseName == null) {
            if (other.CourseName != null) {
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
        if (CourseRank == null) {
            if (other.CourseRank != null) {
                return false;
            }
        } else if (!CourseRank.equals(other.CourseRank)) {
            return false;
        }
       // 같은 UserVO 객체라면 true를 반환한다.
        return true;
    }

}
