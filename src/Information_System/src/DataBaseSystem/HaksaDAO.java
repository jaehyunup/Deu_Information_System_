package DataBaseSystem;

import java.util.List;

public interface HaksaDAO {
	
	abstract void insertHaksa(String user,String num,String name, String dept, String jumin) ;
	abstract int updateHaksa(String user,String num,String name, String dept, String jumin) ;
	abstract List<HaksaVO> getHaksaInfo(String user,String num,String name);
	abstract List<HaksaVO> getAllHaksaInfo(String user);
	abstract int deleteHaksaInfo(String user,String num, String name);
	
	abstract boolean confirmHaksa(String user,String num);
}
