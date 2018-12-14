package mainpackage;


public enum loginType {
	STUDENT,PROFESSOR,BAMANAGER,CSMANAGER;
	
	public String toString() {
	    switch(this) {
	      case STUDENT: return "student"; // 학생
	      case PROFESSOR: return "professor"; // 교수
	      case BAMANAGER: return "bamanager"; //학사관리자
	      case CSMANAGER: return "csmanager"; //수업담당자 
	      default:       return "unspecified";
	    }
	  }
		
}
