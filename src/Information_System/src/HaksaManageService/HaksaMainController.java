package HaksaManageService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HaksaMainController implements HaksaController, ActionListener{
	HaksaModel model;
	HaksaView view;
	
	HaksaSystem haksasystem;
	HaksaInsertView haksaInsertView;
	
	String name;
	String num;
	String dept;
	String jumin;
	
	public HaksaMainController(HaksaModel model,HaksaView view) {
		this.model=model;
		//this.view=view;
		setView(view);
		//this.view.haksaSetView(this);
	}
	
	public void setView(HaksaView view) {
		this.view=view;
		view.createFrame();
		view.addListener((ActionListener)this);
		//System.out.println("setView");
	}
	
	public void setHaksaName(String name){
		model.test();
		//model.setName(name);
		//System.out.println(name);
	}
	public void setHaksaNum(String num){
		model.setNum(num);
	}
	public void setHaksaDept(String dept){
		model.setDept(dept);
	}
	public void setHaksaJumin(String jumin){
		model.setJumin(jumin);
	}
	
	public String getHaksaName(){
		return model.getName();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.view instanceof HaksaUser) {
			//System.out.println("User ����");
			if(e.getSource().equals(((HaksaUser)this.view).getStuBtn())) {
				System.out.println("�л� �ý���");
				this.view = new HaksaSystem("student");
				setView(this.view);
			}
			else {
				System.out.println("���� �ý���");
				haksasystem = new HaksaSystem("professor");	
			}
		}
		
		if(this.view instanceof HaksaSystem) {
			//System.out.println("�л�ý���");
			/*if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("��ȸ�ϱ�");
			}*/
			if(e.getSource().equals(((HaksaSystem)this.view).getHaksaInsertBtn())) {
				System.out.println("�� ����ϱ�");
				this.view = new HaksaInsertView();
				setView(this.view);
			}
			/*if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("�����ϱ�");
			}
			if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("�����ϱ�");
			}*/
			//setView(this.view);
		}
		
		if(this.view instanceof HaksaInsertView) {
			//System.out.println("�л�ý��� ����");
			if(e.getSource().equals(((HaksaInsertView)this.view).getRegisterBtn())) {
				System.out.println("����ϱ�");
				name=((HaksaInsertView)this.view).getName();
				num=((HaksaInsertView)this.view).getNum();
				dept=((HaksaInsertView)this.view).getDept();
				jumin=((HaksaInsertView)this.view).getJumin();
				
				setHaksaName(name);
				//setHaksaNum(num);
				//setHaksaDept(dept);
				//setHaksaJumin(jumin);
				
			}
			if(e.getSource().equals(((HaksaInsertView)this.view).getCancelBtn())) {
				//System.out.println("�л�ý��� ����");
				((HaksaInsertView)this.view).frame.dispose();
			}
		}
		
		
	}
	
}
