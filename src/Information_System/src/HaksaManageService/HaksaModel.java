package HaksaManageService;

import java.util.List;

import DataBaseSystem.HaksaDAO;
import DataBaseSystem.HaksaDataBaseService;
import DataBaseSystem.HaksaVO;
import mainpackage.Model;

public class HaksaModel implements Model{
	private String user;
	private String name;
	private String num;
	private String dept;
	private String jumin;
	private String[] modifyData=new String[5];
	private List<HaksaVO> searchInfo;
	private String[][] info;
	private String[][] allInfo;
	
	private boolean result;
	
	public HaksaModel() {
		
	}
	public void setUser(String user) {
		this.user=user;
	}
	
	public void setmodifyData(String num,String name,String dept,String jumin1,String jumin2) {
		modifyData[0]=num;
		modifyData[1]=name;
		modifyData[2]=dept;
		modifyData[3]=jumin1;
		modifyData[4]=jumin2;		
	}
	
	public String getUser() {
		return user;
	}
	public String[] getmodifyData() {
		
		return this.modifyData;
	}
	
	public boolean setHaksaInfo(String num, String name, String dept, String jumin) { // 학사 정보 수정
		this.num=num;
		this.name=name;
		this.dept=dept;
		this.jumin=jumin;		
		if(HaksaDataBaseService.getInstance().confirmHaksa(user,num)) { // 성공여부.{
			 HaksaDataBaseService.getInstance().insertHaksa(user,num,name,dept,jumin);
			 return true;
		}
		else {
			return false;
		}
		
	}
	

	public void searchHaksaInfo(String num,String name) { // 학사 조회
		this.num=num;
		this.name=name;
		this.searchInfo=HaksaDataBaseService.getInstance().getHaksaInfo(user,num,name);
	}
	
	public int changeHaksaInfo(String num, String name, String dept, String jumin) { //학사 정보 수정
		this.num=num;
		this.name=name;
		this.dept=dept;
		this.jumin=jumin;
		return HaksaDataBaseService.getInstance().updateHaksa(user,num,name,dept,jumin); 
	}
	
	public int deleteHaksaInfo(String num,String name) { // 학사 정보 삭제
		this.num=num;
		this.name=name;
		int e= HaksaDataBaseService.getInstance().deleteHaksaInfo(user,num,name);
		return e;
	}
	
	public String[][] getHaksaInfo() { // 학사 정보 getter
		this.info=new String[searchInfo.size()][4];
		for (int i = 0; i < this.searchInfo.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			info[i][0] = this.searchInfo.get(i).getHaksaNum();
			info[i][1] = this.searchInfo.get(i).getHaksaName();
			info[i][2] = this.searchInfo.get(i).getHaksaDept();
			info[i][3] = this.searchInfo.get(i).getHaksaJumin();
		}
		return info;
	}
	
	public String[][] getHaksaAllInfo() { // 모든 교수 학생 정보
	
		this.searchInfo = HaksaDataBaseService.getInstance().getAllHaksaInfo(user);
		this.allInfo = new String[searchInfo.size()][4];
		
		for (int i = 0; i < this.searchInfo.size(); i++) { // 검색된 강좌의 개수 만큼의행을 생성
			allInfo[i][0] = this.searchInfo.get(i).getHaksaNum();
			allInfo[i][1] = this.searchInfo.get(i).getHaksaName();
			allInfo[i][2] = this.searchInfo.get(i).getHaksaDept();
			allInfo[i][3] = this.searchInfo.get(i).getHaksaJumin();
		}
		
		return allInfo;
	}
}
