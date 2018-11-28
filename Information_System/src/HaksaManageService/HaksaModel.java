package HaksaManageService;

public class HaksaModel {
	private String name;
	private String num;
	private String dept;
	private String jumin;
	
	public HaksaModel() {
		
	}
	public void test() {
		System.out.println("¸ðµ¨Å×½ºÆ®");
	}
	public void setName(String name) {
		this.name=name;
		System.out.println("Model"+name);
	}
	public void setNum(String num) {
		this.num=num;
		System.out.println("Model"+num);
	}
	public void setDept(String dept) {
		this.dept=dept;
		System.out.println("Model"+dept);
	}
	public void setJumin(String jumin) {
		this.jumin=jumin;
		System.out.println("Model"+jumin);
	}
	
	public String getName() {
		return name;
	}
}
