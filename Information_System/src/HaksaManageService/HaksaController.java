package HaksaManageService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface HaksaController{
	//private HaksaInsert insert;
	//private HaksaSystem haksasystem;
	
	public void setView(HaksaView view);
	
	public void setHaksaName(String name); 
	public void setHaksaNum(String num);
	public void setHaksaDept(String dept);
	public void setHaksaJumin(String jumin);
	
	public String getHaksaName(); 
	
	public void actionPerformed(ActionEvent e);
}
