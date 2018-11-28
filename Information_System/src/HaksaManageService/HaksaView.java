package HaksaManageService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class HaksaView {
	public abstract void createFrame();
	//public abstract void haksaSetView(HaksaMainController controller);
	//public abstract void setView(HaksaView view);
	public abstract void addListener(ActionListener e);
}
