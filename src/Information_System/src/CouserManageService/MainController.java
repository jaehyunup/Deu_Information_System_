package CouserManageService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mainpackage.loginSpec;
import mainpackage.loginType;

public class MainController implements CourseController, ActionListener,MouseListener{
	/* 컨트롤러는 뷰와 모델사이를 관장하고 , 이벤트와 로직을 처리한다 . */
	private CourseModel model;
	private CourseView view;
	private loginSpec spec;

	public MainController(CourseModel model, CourseView view, loginSpec spec) {
		// 로그인 스펙의 확인.,로그인 타입에 맞게 뷰와 모델의 선언이 이루어져야한다.
		this.view = view;
		this.model = model;
		this.spec = spec;
		AddListenerToView();
	}

	public void AddListenerToView() {
		this.view.addListener(this);
		if(view instanceof ProfRankInsertView) {
			((ProfRankInsertView)this.view).AddMouseListener(this);
		}
	}
	
	@Override
	public void setView(CourseView view) {

		// TODO Auto-generated method stub
	}

	@Override
	public void setModel(CourseModel model) {
		// TODO Auto-generated method stub
		this.model = model;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.view instanceof StudentMainView) { // 학생의 수강 관리 메인 메뉴일때의 이벤트 리스너 로직
			if (e.getSource().equals(((StudentMainView) this.view).getEnrolmentBtn())) { // 수강 신청 페이지 가는 버튼
				this.view.dispose();
				this.view = new StudentEnrolmentView();
				this.model = new StudentEnrolmentModel(spec);
				((StudentEnrolmentView) this.view)
						.setAllCourseRowList(((StudentEnrolmentModel) this.model).getAllCourseList());
				((StudentEnrolmentView) this.view)
						.setMyCourseRowList(((StudentEnrolmentModel) this.model).getMyCourseList());
				AddListenerToView();

			} else if (e.getSource().equals(((StudentMainView) this.view).getGradeBtn())) { // 성적 확인 버튼이면
				this.view.dispose();
				this.view = new StudentRankView();
				this.model = null;
				this.model = new StudentRankModel(spec);
				AddListenerToView();
				((StudentRankView) this.view).setRankTable(((StudentRankModel) this.model).getMyRankList());

			}
		}

		if (this.view instanceof StudentEnrolmentView) { // 학생의 수강 신청 뷰일떄의 이벤트 리스너 로직
			if (e.getSource().equals(((StudentEnrolmentView) this.view).getCourseJoinButton())) { // 수강 신청 버튼이면

			}
			else if (e.getSource().equals(((StudentEnrolmentView) this.view).getCourseInfoButton())) { // 강좌 정보보기 버튼이면

			}
			else if (e.getSource().equals(((StudentEnrolmentView) this.view).getCourseCancleButton())) { // 수강 취소 버튼이면

			}
		}

		if (this.view instanceof StudentRankView) { // 학생의 성적확인 뷰일떄의 이벤트 리스너 로직
			if (e.getSource().equals(((StudentRankView) this.view).getOkButton())) { // 확인 버튼이면
				this.view.dispose();
				this.view = new StudentMainView();
				AddListenerToView();
			}
		}

		if (this.view instanceof ProfMainView) { // 교수 메인 뷰 일때 리스너
			if (e.getSource().equals(((ProfMainView) this.view).getCourseBtn())) { // 강의 관리 버튼
				System.out.println("what");
				this.view.dispose();
				this.view = new ProfRankInsertView();
				this.model = new ProfRankInsertModel(spec);
				AddListenerToView();
			}

			else if (e.getSource().equals(((ProfMainView) this.view).getConfigBtn())) { // 내 계정관리 버튼

			}
			/**
			 * if (e.getSource().equals(((ProfMainView) this.view).getInsertBtn())) { // 성적
			 * 입력 버튼 System.out.print("gd3");
			 * 
			 * }
			 **/
		}

		if (this.view instanceof ProfRankInsertView) { // 교수 수강 관리 뷰일때 리스너
			if (e.getSource().equals(((ProfRankInsertView) this.view).getStuListBtn())) { // 학생 명단 보기 버튼
				((ProfRankInsertView) this.view).setMyCourseList(((ProfRankInsertModel) this.model).getProfRankList());

			}
			else if (e.getSource().equals(((ProfRankInsertView) this.view).getReturnBtn())) { // 돌아가기 버튼
				this.view.dispose();
				this.view = new ProfMainView();
				this.model = null;
				this.model = new ProfMainModel(spec);
				AddListenerToView();			
				}
			else if (e.getSource().equals(((ProfRankInsertView) this.view).getInsertBtn())) { // 성적 입력 버튼
				JTable courseTable=((ProfRankInsertView)view).getMyCourseList(); // 선택된 뷰의 테이블
				TableModel coursemodel=courseTable.getModel(); //현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
				int courserowcnt=courseTable.getSelectedRow();
				String coursenum=(String)coursemodel.getValueAt(courserowcnt, 0); // String 형의 강좌번호 반환.
				
				JTable StuTable=((ProfRankInsertView)view).getStuList(); // 학생 선택 테이블 가져오기
				TableModel StuModel=StuTable.getModel(); //현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
				int stdrowcnt=StuTable.getSelectedRow(); //학생 리스트에서 선택된 행 번호
				String Stdnum=(String)StuModel.getValueAt(stdrowcnt,0); //String 형의 학번 반환
				
				String Rank=((ProfRankInsertView)view).getSelectedButtonText();
				((ProfRankInsertModel) this.model).RankInsert(Stdnum,coursenum,Rank);
					
				
				
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) { // 교수의 수강관리에서 자신 강좌리스트에서 강좌 클릭시 학생 명단 띄운다
		JTable courseTable=((ProfRankInsertView)view).getMyCourseList(); // 선택된 뷰의 테이블
		TableModel rowmodel=courseTable.getModel(); //현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
		int row=courseTable.getSelectedRow();
		String coursenum=(String)rowmodel.getValueAt(row, 0); // String 형의 강좌번호 반환.
		((ProfRankInsertView)view).setFocusCoStuList(((ProfRankInsertModel) this.model).getStuList(coursenum));		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

// TODO Auto-generated method stub
