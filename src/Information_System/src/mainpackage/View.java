package mainpackage;

import java.awt.event.ActionListener;

public interface View {
	public abstract void initComps();
	public abstract void addComps();
	public abstract void initWindow();
	public abstract void addListener(ActionListener e);
	public abstract void dispose();
}
