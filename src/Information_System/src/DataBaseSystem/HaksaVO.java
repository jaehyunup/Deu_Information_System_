package DataBaseSystem;

public class HaksaVO {
	private String num=null;
	private String name=null;
	private String dept=null;
	private String jumin=null;
	
	public HaksaVO() {}
	
	public HaksaVO(String name) {
		this.name=name;
	}
	
	public void setHaksaNum(String num) {
		this.num=num;
	}
	public void setHaksaName(String name) {
		this.name=name;
	}
	public void setHaksaDept(String dept) {
		this.dept=dept;
	}
	public void setHaksaJumin(String jumin) {
		this.jumin=jumin;
	}
	
	public String getHaksaNum() {
		return num;
	}
	public String getHaksaName() {
		return name;
	}
	public String getHaksaDept() {
		return dept;
	}
	public String getHaksaJumin() {
		return jumin;
	}
	
	
}
