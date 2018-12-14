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
			//System.out.println("User 선택");
			if(e.getSource().equals(((HaksaUser)this.view).getStuBtn())) {
				System.out.println("학생 시스템");
				this.view = new HaksaSystem("student");
				setView(this.view);
			}
			else {
				System.out.println("교수 시스템");
				haksasystem = new HaksaSystem("professor");	
			}
		}
		
		if(this.view instanceof HaksaSystem) {
			//System.out.println("학사시스템");
			/*if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("조회하기");
			}*/
			if(e.getSource().equals(((HaksaSystem)this.view).getHaksaInsertBtn())) {
				System.out.println("새 등록하기");
				this.view = new HaksaInsertView();
				setView(this.view);
			}
			/*if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("수정하기");
			}
			if(e.getSource().equals(((HaksaSystem)this.view).getButtonList())) {
				System.out.println("삭제하기");
			}*/
			//setView(this.view);
		}
		
		if(this.view instanceof HaksaInsertView) {
			//System.out.println("학사시스템 수정");
			if(e.getSource().equals(((HaksaInsertView)this.view).getRegisterBtn())) {
				System.out.println("등록하기");
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
				//System.out.println("학사시스템 끄기");
				((HaksaInsertView)this.view).frame.dispose();
			}
		}
		
		
	}
	
}
