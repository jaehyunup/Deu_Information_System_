package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableModel;

import CouserManageService.CSmanagerPaymentModel;
import CouserManageService.CSmanagerPaymentView;
import CouserManageService.CoursePMainView;
import CouserManageService.CourseSMainView;
import CouserManageService.ProfMainModel;
import CouserManageService.ProfRankInsertModel;
import CouserManageService.ProfRankInsertView;
import CouserManageService.StudentEnrolmentModel;
import CouserManageService.StudentEnrolmentView;
import CouserManageService.StudentRankModel;
import CouserManageService.StudentRankView;
import HaksaManageService.HaksaInsertView;
import HaksaManageService.HaksaMainView;
import HaksaManageService.HaksaModel;
import HaksaManageService.HaksaModifyView;
import HaksaManageService.HaksaProfView;
import HaksaManageService.HaksaStuView;
import LectureManageSystem.LectureDeleteView;
import LectureManageSystem.LectureMainModel;
import LectureManageSystem.LectureMainView;
import LectureManageSystem.LectureNewView;
import LectureManageSystem.LectureRegisterView;
import LectureManageSystem.LectureUpdateView;

/* 메인 컨트롤러
 * Author :박재현
 * 이슈 1. 뷰와 모델 사이에서 요청을 처리한다.
 * 이슈 2. 뷰와 모델을 인터페이스 인스턴스로 가짐으로서 View,Model 인터페이스를 구현한
 *             모든 View,Model 과 연결이 가능하다. 
 */

public class MainController implements ActionListener, MouseListener {
	private View view;
	private Model model;
	private loginSpec spec;
	

	public MainController(View view, Model model) {
		this.view = view;
		this.model = model;
		view.addListener(this);
	}

	public void ViewChange(View view) {
		this.view.dispose();// 기존 뷰 가리기
		if (view instanceof LoginView) { // 변경할 뷰가 로그인 뷰라면
			this.view = (LoginView) view; // 뷰 형변환
			((LoginView) view).addListener(this);
		} else if (view instanceof SMainView) { // 변경할 뷰가 학생 메인뷰라면
			this.view = (SMainView) view; // 뷰 변경
			((SMainView) view).addListener(this);
		} else if (view instanceof PMainView) { // 변경할 뷰가 교수 메인뷰라면
			this.view = (PMainView) view; // 뷰 변경
			((PMainView) view).addListener(this);
		} else if (view instanceof BAMainView) { // 변경할 뷰가 학사담당자 메인뷰라면
			this.view = (BAMainView) view; // 뷰 변경
			((BAMainView) view).addListener(this);
		} else if (view instanceof CSMainView) { // 변경할 뷰가 수강 담당자 메인뷰라면
			this.view = (CSMainView) view; // 뷰 변경
			((CSMainView) view).addListener(this);
		} else if (view instanceof ChangePasswordView) { // 변경할 뷰가 암호변경 뷰라면
			this.view = (ChangePasswordView) view; // 뷰 변경
			((ChangePasswordView) view).addListener(this);
		}

		else if (view instanceof CourseSMainView) { // 변경할 뷰가 수강관리 (학생) 뷰라면
			this.view = (CourseSMainView) view; // 뷰 변경
			((CourseSMainView) view).addListener(this);
		} else if (view instanceof StudentEnrolmentView) { // 변경할 뷰가 수강신청 (학생) 뷰라면
			this.view = (StudentEnrolmentView) view; // 뷰 변경
			((StudentEnrolmentView) view).addListener(this);
			((StudentEnrolmentView) view).addMouseListener(this);
		} else if (view instanceof StudentRankView) { // 변경할 뷰가 성적보기 (학생) 뷰라면
			this.view = (StudentRankView) view; // 뷰 변경
			((StudentRankView) view).addListener(this);
			((StudentRankView) view).addMouseListener(this);
		} else if (view instanceof CoursePMainView) { // 변경할 뷰가 수강관리 (교수) 뷰라면
			this.view = (CoursePMainView) view; // 뷰 변경
			((CoursePMainView) view).addListener(this);
			((CoursePMainView) view).addMouseListener(this);
		} else if (view instanceof ProfRankInsertView) { // 변경할 뷰가 성적입력 (교수) 뷰라면
			this.view = (ProfRankInsertView) view; // 뷰 변경
			((ProfRankInsertView) view).addMouseListener(this);
			((ProfRankInsertView) view).addListener(this);
		} else if (view instanceof HaksaMainView) { // 변경할 뷰가 학사 담당자의 학사관리 기능 뷰라면
			this.view = (HaksaMainView) view; // 뷰 변경
			((HaksaMainView) view).addListener(this);
		} else if (view instanceof HaksaProfView) { // 변경할 뷰가 학사 담당자의 교수 관리 기능 뷰라면
			this.view = (HaksaProfView) view; // 뷰 변경
			((HaksaProfView) view).setAllHaksaList(((HaksaModel) model).getHaksaAllInfo());
			((HaksaProfView) view).addListener(this);
			((HaksaProfView) view).addMouseListener(this);
		} else if (view instanceof HaksaStuView) { // 변경할 뷰가 학사 담당자의 학생 관리 기능 뷰라면
			this.view = (HaksaStuView) view; // 뷰 변경
			((HaksaStuView) view).setAllHaksaList(((HaksaModel) model).getHaksaAllInfo());
			((HaksaStuView) view).addListener(this);
			((HaksaStuView) view).addMouseListener(this);
		} else if (view instanceof HaksaInsertView) { // 변경할 뷰가 학사 담당자 학사 정보 추가 뷰라면
			this.view = (HaksaInsertView) view; // 뷰 변경
			((HaksaInsertView) view).addListener(this);

		} else if (view instanceof HaksaModifyView) { // 변경할 뷰가 학사 담당자 학사 정보변경 기능 뷰라면
			((HaksaModel) model).getUser().equals("student");
			this.view = (HaksaModifyView) view; // 뷰 변경
			((HaksaModifyView) this.view).setModifyinit(((HaksaModel) model).getmodifyData()); // 모델에 저장해둔 해당 학사 정보를
																								// 보낸다.
			((HaksaModifyView) this.view).addListener(this);

		} else if (view instanceof CSMainView) { // 변경할 뷰가 수업 담당자 메인 뷰라면
			this.view = (CSMainView) view; // 뷰 변경
			((CSMainView) this.view).addListener(this);

		} else if (view instanceof LectureMainView) { // 변경할 뷰가 수업 담당자 수업관리기능 메인 뷰라면
			((LectureMainModel) model).setState("main");
			this.view = (LectureMainView) view; // 뷰 변경
			((LectureMainView) this.view).addListener(this);
			((LectureMainView) this.view).addMouseListener(this);

		} else if (view instanceof LectureRegisterView) { // 변경할 뷰가 학사 담당자 학사 정보변경 기능 뷰라면
			((LectureMainModel) model).setState("register");
			this.view = (LectureRegisterView) view; // 뷰 변경
			((LectureRegisterView) this.view).addListener(this);
			((LectureRegisterView) this.view).addMouseListener(this);

		} else if (view instanceof LectureNewView) { // 변경할 뷰가 수업 담당자 새 강좌 추가
			((LectureMainModel) model).setState("new_register");
			this.view = (LectureNewView) view; // 뷰 변경
			((LectureNewView) this.view).addListener(this);
			((LectureNewView) this.view).addMouseListener(this);

		} else if (view instanceof LectureUpdateView) { // 변경할 뷰가 수업 담당자 강좌 수정이라면
			((LectureMainModel) model).setState("update");
			this.view = (LectureUpdateView) view; // 뷰 변경
			((LectureUpdateView) this.view).addListener(this);
			((LectureUpdateView) this.view).addMouseListener(this);

		} else if (view instanceof LectureDeleteView) { // 변경할 뷰가 수업 담당자 강좌 삭제 기능 이라면
			((LectureMainModel) model).setState("delete");
			this.view = (LectureDeleteView) view; // 뷰 변경
			((LectureDeleteView) this.view).addListener(this);
			((LectureDeleteView) this.view).addMouseListener(this);
		} else if (view instanceof CSmanagerPaymentView) { // 변경할 뷰가 수업 담당자 청구서 발급 버튼이라면
			this.view = (CSmanagerPaymentView) view; // 뷰 변경
			((CSmanagerPaymentView) this.view).addListener(this);
			((CSmanagerPaymentView) this.view).addMouseListener(this);
		}

	}

	public void ModelChange(Model model) {
		this.model = null;

		if (model instanceof HaksaModel) { // 변경할 모델이 학사 모델이 라면
			this.model = new HaksaModel(); // 모델변경

		} else if (model instanceof LoginModel) { // 변경할 모델이 로그인 모델이라면
			this.model = (LoginModel) model;

		} else if (model instanceof LectureMainModel) { // 변경할 모델이 수업 담당자 모델이 라면
			this.model = new LectureMainModel(); // 수업 담당자 모델로 해당 모델을 변경

		} else if (model instanceof StudentEnrolmentModel) { // 변경할 모델이 학생 수강 신청 모델이 라면
			this.model = (StudentEnrolmentModel) model;
			((StudentEnrolmentModel) model).registerObserver(((StudentEnrolmentView) view)); // 모델의 구독자로 뷰를 추가

		} else if (model instanceof StudentRankModel) { // 변경할 모델이 학생 수강 신청 모델이 라면
			this.model = (StudentRankModel) model;
			((StudentRankModel) model).registerObserver(((StudentRankView) view)); // 모델의 구독자로 뷰를 추가

		} else if (model instanceof CSmanagerPaymentModel) {
			this.model = (CSmanagerPaymentModel) model;
			((CSmanagerPaymentModel) model).registerObserver(((CSmanagerPaymentView) view)); // 모델의 구독자로 뷰를 추가

		}

	}

	
	static String idPattern = "^((S|P|H|G){1})([0-9]{3})$"; //아이디 조건. S,P,H,G로 시작하고  숫자 3자리를 유지하여야 한다.
	static String pwPattern = "^[A-Za-z0-9]{7}$"; //암호 조건. 영문자 및 숫자로 이루어지고 7자리를 유지하여야한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.view instanceof LoginView) { // 교수 수강 관리 뷰일때 리스너
			if (e.getSource().equals(((LoginView) view).getLoginBtn())) { // 로그인 뷰의 로그인 버튼 클릭 이라면
				String userid = ((LoginView) view).getUserid().getText();
				String userpw = new String(((LoginView) view).getUserpw().getPassword());
				boolean idCheck = Pattern.matches(idPattern, userid);
				if (!userid.isEmpty() && !userpw.isEmpty()) {
					if (idCheck == true) { //아이디 제약조건 확인
						if (((LoginModel) model).loginAccount(userid, userpw)) { // 로그인 성공
							switch (userid.charAt(0)) {
							case 'S':
								spec = new loginSpec(userid, userpw, loginType.STUDENT); // 스펙저장
								((LoginModel) model).setSpec(spec);
								// 유저 모델의 SPEC 변경
								ViewChange(new SMainView()); //학생 메인뷰 보여줌
								break;
							case 'P':
								spec = new loginSpec(userid, userpw, loginType.PROFESSOR); // 스펙저장
								((LoginModel) model).setSpec(spec);
								ViewChange(new PMainView()); //교수 메인뷰 보여줌
								break;
							case 'H':
								spec = new loginSpec(userid, userpw, loginType.BAMANAGER); //스펙저장
								((LoginModel) model).setSpec(spec);
								ViewChange(new BAMainView()); //학사담당자 메인뷰 보여줌
								break;
							case 'G':
								spec = new loginSpec(userid, userpw, loginType.CSMANAGER); // 스펙저장
								((LoginModel) model).setSpec(spec);

								ViewChange(new CSMainView()); //수업담당자 메인뷰 보여줌

								break;
							}

						} else {
							((LoginView) view).ckMessage(); //아이디와 비밀번호가 맞지 않을 시 에러메세지
						}
					} else {
						((LoginView) view).idMessage(); //아이디가 조건에 맞지 않을 시 에러메세지
					}
				} else {
					((LoginView) view).emptyMessage(); //빈칸이 있을 시 에러메세지
				}
			}
		}

		else if (this.view instanceof SMainView) { // 학생의 메인 뷰일때
			if (e.getSource().equals(((SMainView) view).getLogOutBtn())) { // 학생메인 ) 로그아웃 버튼이라면
				ViewChange(new LoginView()); // 로그인 뷰로 뷰를 변경 
				ModelChange(new LoginModel()); // 로그인 모델로 모델을 변경
				
			} else if (e.getSource().equals(((SMainView) view).getCourseBtn())) { // 학생메인 ) 수강관리 버튼이라면
				ViewChange(new CourseSMainView()); // 학생 수강관리 메인메뉴로 뷰 변경

			} else if (e.getSource().equals(((SMainView) view).getChangePwBtn())) { // 학생메인 ) 암호변경 버튼이라면
				ViewChange(new ChangePasswordView()); // 암호 변경 뷰로 뷰 를 변경 
				ModelChange(new LoginModel()); // 로그인 모델로 모델을 변경

			}
		}

		else if (this.view instanceof CourseSMainView) { // 학생의 수강 관리 메인 메뉴일때의 이벤트 리스너 로직
			if (e.getSource().equals(((CourseSMainView) this.view).getEnrolmentBtn())) { // 수강 신청 페이지 가는 버튼
				ViewChange(new StudentEnrolmentView());
				ModelChange(new StudentEnrolmentModel(spec));
				((StudentEnrolmentModel) this.model).getMyCourseList(); // 모델에 해당유저의 강좌 리스트를 새로고침하라는명령.
				((StudentEnrolmentModel) this.model).getAllCourseList(); // 모델에 해당유저의 강좌 리스트를 새로고침하라는명령.
				/*
				 * ((StudentEnrolmentView) this.view)
				 * .setAllCourseRowList(((StudentEnrolmentModel)
				 * this.model).getAllCourseList()); // 모든 수강신청 모델의값을 // 수강신청 뷰에 넣기
				 */
				/* 이때옵저버 패턴을 적용함으로서컨트롤러에 의존도를 낮춣 수 있다. */

			} else if (e.getSource().equals(((CourseSMainView) this.view).getGradeBtn())) { // 성적 확인 버튼이면
				ViewChange(new StudentRankView());
				ModelChange(new StudentRankModel(spec));
				((StudentRankModel) this.model).getMyRankList();// 모델을 갱신하라고 한다.

			} else if (e.getSource().equals(((CourseSMainView) this.view).getReturnBtn())) { // 되돌아가기 버튼이면
				ViewChange(new SMainView());

			}
		}

		else if (this.view instanceof StudentEnrolmentView) { // 학생의 수강신청 뷰일때
			if (e.getSource().equals(((StudentEnrolmentView) this.view).getCourseJoinButton())) {  // 수강 신청 버튼이면
				int row = ((StudentEnrolmentView) this.view).getAllCourseList().getSelectedRow(); // 현재마우스로 선택된 테이블의 행 
				String courseno = (String) ((StudentEnrolmentView) this.view).getAllCourseList().getModel().getValueAt(row, 0); // 선택된 행의 강좌 번호.(수강 신청한 강좌의 강좌번호)
				int insresult = ((StudentEnrolmentModel) this.model).setStdCourse(courseno); // 모델에 해당 강좌번호를 수강신청했음을 알린다
				((StudentEnrolmentView) this.view).CourseInsertResult(insresult); // 모델의 에러를 확인
				((StudentEnrolmentModel) this.model).getMyCourseList(); // 모델 해당유저의 강좌 리스트를 새로고침. 이때 옵저버가 이용되어 뷰에 자동으로 알린다
				// ((StudentEnrolmentView)this.view).setMyCourseRowList(((StudentEnrolmentModel)this.model).getMyCourseList());//
				// 모델에게 MyCourseList를 받고뷰에 전달 .
			} else if (e.getSource().equals(((StudentEnrolmentView) this.view).getCourseCancleButton())) { // 수강 취소 버튼이면
				int row = ((StudentEnrolmentView) this.view).getMyCourseList().getSelectedRow();// 현재마우스로 선택된 테이블의 행 모델을
																								// 가져온다~(데이터 가져오기)
				String courseno = (String) ((StudentEnrolmentView) this.view).getMyCourseList().getModel()
						.getValueAt(row, 0); // 선택된 행의 강좌 번호.(수강 신청한 강좌의 강좌번호)
				int deleteResult = ((StudentEnrolmentModel) this.model).deleteCourse(courseno); // 모델에게 수강내역을 삭제하라는 명령
				((StudentEnrolmentView) this.view).CourseDeleteCheck(deleteResult); // 
				((StudentEnrolmentModel) this.model).getMyCourseList(); // 모델에 해당유저의 강좌 리스트를 새로고침하라는명령.

				// ((StudentEnrolmentView)this.view).setMyCourseRowList(((StudentEnrolmentModel)this.model).getMyCourseList());//
				// 모델에게 MyCourseList를 받고뷰에 전달 .
				/* 위의 모델에서 받아서 전달하는 메서드와 같은 형식은 옵저버 패턴을 이용해 의존성을 낮췄다. */
			} else if (e.getSource().equals(((StudentEnrolmentView) this.view).getReturnButton())) { // 되돌아가기 버튼이면
				ViewChange(new CourseSMainView());

			} else if (e.getSource().equals(((StudentEnrolmentView) view).getCourseInfoButton())) {// 강좌정보보기 버튼이면
				int row = ((StudentEnrolmentView) view).getAllCourseList().getSelectedRow();
				((StudentEnrolmentModel) this.model).refreshInfoText(row); // 어레이 스트링형
			}

		}

		else if (this.view instanceof StudentRankView) { // 학생의 성적확인 뷰일떄의 이벤트 리스너 로직
			if (e.getSource().equals(((StudentRankView) this.view).getOkButton())) { // 확인 버튼이면
				ViewChange(new CourseSMainView());
			}
		}

		else if (this.view instanceof PMainView) { // 교수의 메인 뷰일때
			if (e.getSource().equals(((PMainView) view).getLogOutBtn())) { // 교수메인) 메인 뷰- 로그아웃 버튼이라면
				ViewChange(new LoginView());
				ModelChange(new LoginModel());
			} else if (e.getSource().equals(((PMainView) view).getCourseBtn())) { // 교수메인 ) 수업 관리 버튼이라면
				ViewChange(new CoursePMainView());

			} else if (e.getSource().equals(((PMainView) view).getChangePwBtn())) { // 교수메인) 암호변경 버튼이라면
				ViewChange(new ChangePasswordView());
				ModelChange(new LoginModel());


			}
		}

		else if (this.view instanceof CoursePMainView) { // 교수 수강관리기능 선택
			if (e.getSource().equals(((CoursePMainView) this.view).getCourseBtn())) { // 강의 관리 버튼
				ViewChange(new ProfRankInsertView());
				this.model = new ProfRankInsertModel(spec);
			}

			else if (e.getSource().equals(((CoursePMainView) this.view).getConfigBtn())) { // 출석부 예정 버튼

			} else if (e.getSource().equals(((CoursePMainView) this.view).getReturnBtn())) { // 되돌아가기 버튼
				ViewChange(new PMainView());
			}
		}

		else if (this.view instanceof ProfRankInsertView) { // 교수 성적 입력 관리 뷰일때 리스너
			if (e.getSource().equals(((ProfRankInsertView) this.view).getStuListBtn())) { // 교수의 자기자신 강좌 가져오기
				((ProfRankInsertView) this.view).setMyCourseList(((ProfRankInsertModel) this.model).getProfRankList());

			} else if (e.getSource().equals(((ProfRankInsertView) this.view).getReturnBtn())) { // 돌아가기 버튼
				ViewChange(new CoursePMainView());
				this.model = null;
				this.model = new ProfMainModel(spec);

			} else if (e.getSource().equals(((ProfRankInsertView) this.view).getInsertBtn())) { // 성적 입력 버튼
				JTable courseTable = ((ProfRankInsertView) view).getMyCourseList(); // 선택된 뷰의 테이블
				TableModel coursemodel = courseTable.getModel(); // 현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
				int courserowcnt = courseTable.getSelectedRow();
				String coursenum = (String) coursemodel.getValueAt(courserowcnt, 0); // String 형의 강좌번호 반환.

				JTable StuTable = ((ProfRankInsertView) view).getStuList(); // 학생 선택 테이블 가져오기
				TableModel StuModel = StuTable.getModel(); // 현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
				int stdrowcnt = StuTable.getSelectedRow(); // 학생 리스트에서 선택된 행 번호
				String Stdnum = (String) StuModel.getValueAt(stdrowcnt, 0); // String 형의 학번 반환
				String Rank = ((ProfRankInsertView) view).getSelectedButtonText();
				((ProfRankInsertModel) this.model).RankInsert(Stdnum, coursenum, Rank);
			}
			else if (e.getSource().equals(((ProfRankInsertView) this.view).getReturnBtn())) { 
				ViewChange(new CoursePMainView());
			}
		}

		else if (this.view instanceof BAMainView) { // 학사 담당자의 시스템 메인 뷰일때
			if (e.getSource().equals(((BAMainView) view).getLogOutBtn())) { // 학사담당) 메인 뷰- 로그아웃 버튼이라면
				ViewChange(new LoginView());
			} else if (e.getSource().equals(((BAMainView) view).getHaksaBtn())) { // 학사담당 ) 학사 관리 기능 버튼이라면
				ViewChange(new HaksaMainView()); // 학사 관리기능 메인 뷰로 변경
			} else if (e.getSource().equals(((BAMainView) view).getChangePwBtn())) { // 학사담당 ) 암호변경 버튼이라면
				ViewChange(new ChangePasswordView());
				ModelChange(new LoginModel());


			}
		}

		else if (this.view instanceof HaksaMainView) { // 학사 담당자의 학사 관리 기능 메인 뷰일때의 리스너.
			if (e.getSource().equals(((HaksaMainView) this.view).getStuBtn())) { // 교수 관리 버튼
				ModelChange(new HaksaModel()); // 학사 모델로 변경
				((HaksaModel) model).setUser("professor");
				ViewChange(new HaksaProfView()); // 교수관리 뷰로 변경

				// ((HaksaProfView)view).setAllHaksaList(
				// ((HaksaModel)model).getHaksaAllInfo());
			} else if (e.getSource().equals(((HaksaMainView) this.view).getProfBtn())) { // 학생 관리 버튼
				ModelChange(new HaksaModel()); // 학사 모델로 변경
				((HaksaModel) model).setUser("student");
				ViewChange(new HaksaStuView()); // 교수관리 뷰로 변경

				// ((HaksaStuView)view).setAllHaksaList( ((HaksaModel)model).getHaksaAllInfo());

			}
			else if (e.getSource().equals(((HaksaMainView) this.view).getReturnBtn())) { 
				ViewChange(new BAMainView());
				
			}
		}

		else if (this.view instanceof HaksaProfView) { // 학사 담당자의 교수 학사정보 관리
			if (e.getSource().equals(((HaksaProfView) this.view).getButtonList(0))) { // 조회
				if ((((HaksaProfView) this.view).getProfNum().equals(""))
						|| (((HaksaProfView) this.view).getProfName().equals(""))) { // 교번(학번)과 이름이 비어있을때
					((HaksaProfView) this.view).valueAlarm(); // 뷰에 알람을 터트린다
				} else { // 값이 있을때
					String ProfName = ((HaksaProfView) view).getProfName();
					String ProfNum = ((HaksaProfView) view).getProfNum();
					((HaksaModel) model).searchHaksaInfo(ProfNum, ProfName); // 학사 모델에 들어있는 학사 리스트 값 변경 요청
					((HaksaModel) model).getHaksaInfo(); // 방금 조회해서모델값이 변경되었으니, 모델값에 있는정보를 getter를 이용하여 뷰에 등록
					((HaksaProfView) view).setHaksaList(((HaksaModel) model).getHaksaInfo()); // 모델의 값을 view에 다시 등록한다.

				}
			}

			else if (e.getSource().equals(((HaksaProfView) this.view).getButtonList(1))) { // 학사 정보 삽입 버튼일때
				ViewChange(new HaksaInsertView());// 학사정보삽입뷰로 변경

			} else if (e.getSource().equals(((HaksaProfView) this.view).getButtonList(2))) { // 수정

				if ((((HaksaProfView) this.view).getProfNum().equals(""))
						|| (((HaksaProfView) this.view).getProfName().equals(""))) { // 아무것도 입력 안되었다면
					((HaksaProfView) this.view).valueAlarm();
				} else if (((HaksaProfView) this.view).getTable().getSelectedRowCount() == 0) { // 테이블의 선택된 개수가 0 이라면
					((HaksaProfView) this.view).tableAlarm();
				} else {
					int row = ((HaksaProfView) this.view).getTable().getSelectedRow(); // 선택된 행을 가지고,
					String num = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 0).toString();
					String name = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 1).toString();
					String dept = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 2).toString();
					String jumintemp = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 3).toString();
					String jumin1 = jumintemp.substring(0, jumintemp.lastIndexOf('-'));
					String jumin2 = jumintemp.substring(jumintemp.lastIndexOf('-') + 1);

					((HaksaModel) model).setmodifyData(num, name, dept, jumin1, jumin2); // 학사 모델에 수정할 값 저장

					ViewChange(new HaksaModifyView()); // 학사 수정 뷰로 변경

				}

			} else if (e.getSource().equals(((HaksaProfView) this.view).getButtonList(3))) { // 삭제
				if ((((HaksaProfView) this.view).getProfNum().equals(""))
						|| (((HaksaProfView) this.view).getProfName().equals(""))) {
					((HaksaProfView) this.view).valueAlarm();
				} else if (((HaksaProfView) this.view).getTable().getSelectedRowCount() == 0) { // 테이블의 선택된 개수가 0 이라면
					((HaksaProfView) this.view).tableAlarm();
				} else { // 테이블을 정상 선택하고 삭제했다면.
					int row = ((HaksaProfView) this.view).getTable().getSelectedRow(); // 선택된 행을 가지고,
					String num = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 0).toString();
					String name = ((HaksaProfView) this.view).getTable().getModel().getValueAt(row, 1).toString();
					((HaksaModel) model).deleteHaksaInfo(num, name); // 모델에 삭제요청
					((HaksaProfView) view).deleteTablerow(row);// 삭제 요청한 해당 로우 삭제
					// 해당 교번에 해당하는 학생/교수를 삭제.
				}
			} else if (e.getSource().equals(((HaksaProfView) this.view).getReturnBtn())) {
				ViewChange(new HaksaMainView());
			}

		}

		else if (this.view instanceof HaksaStuView) { // 학사 담당자의학생 학사정보 관리
			if (e.getSource().equals(((HaksaStuView) this.view).getButtonList(0))) { // 조회
				if ((((HaksaStuView) this.view).getProfNum().equals(""))
						|| (((HaksaStuView) this.view).getProfName().equals(""))) { // 교번(학번)과 이름이 비어있을때
					((HaksaStuView) this.view).valueAlarm(); // 뷰에 알람을 터트린다
				} else { // 값이 있을때
					String ProfName = ((HaksaStuView) view).getProfName();
					String ProfNum = ((HaksaStuView) view).getProfNum();
					((HaksaModel) model).searchHaksaInfo(ProfNum, ProfName); // 학사 모델에 들어있는 학사 리스트 값 변경 요청
					((HaksaModel) model).getHaksaInfo(); // 방금 조회해서모델값이 변경되었으니, 모델값에 있는정보를 getter를 이용하여 뷰에 등록
					((HaksaStuView) view).setHaksaList(((HaksaModel) model).getHaksaInfo()); // 모델의 값을 view에 다시 등록한다.

				}
			}

			else if (e.getSource().equals(((HaksaStuView) this.view).getButtonList(1))) { // 학사 정보 삽입 버튼일때
				ViewChange(new HaksaInsertView());// 학사정보삽입뷰로 변경

			} else if (e.getSource().equals(((HaksaStuView) this.view).getButtonList(2))) { // 학사 정보 수정버튼일 때

				if ((((HaksaStuView) this.view).getProfNum().equals(""))
						|| (((HaksaStuView) this.view).getProfName().equals(""))) { // 아무것도 입력 안되었다면
					((HaksaStuView) this.view).valueAlarm();
				} else if (((HaksaStuView) this.view).getTable().getSelectedRowCount() == 0) { // 테이블의 선택된 개수가 0 이라면
					((HaksaStuView) this.view).tableAlarm();
				} else {
					int row = ((HaksaStuView) this.view).getTable().getSelectedRow(); // 선택된 행을 가지고,
					String num = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 0).toString();
					String name = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 1).toString();
					String dept = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 2).toString();
					String jumintemp = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 3).toString();
					String jumin1 = jumintemp.substring(0, jumintemp.lastIndexOf('-'));
					String jumin2 = jumintemp.substring(jumintemp.lastIndexOf('-') + 1);
					((HaksaModel) model).setmodifyData(num, name, dept, jumin1, jumin2); // 학사 모델에 수정할 값 저장
					ViewChange(new HaksaModifyView()); // 학사 수정 뷰로 변경

				}

			} else if (e.getSource().equals(((HaksaStuView) this.view).getButtonList(3))) { // 삭제
				if ((((HaksaStuView) this.view).getProfNum().equals(""))
						|| (((HaksaStuView) this.view).getProfName().equals(""))) {
					((HaksaStuView) this.view).valueAlarm();
				} else if (((HaksaStuView) this.view).getTable().getSelectedRowCount() == 0) { // 테이블의 선택된 개수가 0 이라면
					((HaksaStuView) this.view).tableAlarm();
				} else { // 테이블을 정상 선택하고 삭제했다면.
					int row = ((HaksaStuView) this.view).getTable().getSelectedRow(); // 선택된 행을 가지고,
					String num = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 0).toString();
					String name = ((HaksaStuView) this.view).getTable().getModel().getValueAt(row, 1).toString();
					((HaksaModel) model).deleteHaksaInfo(num, name); // 모델에 삭제요청
					((HaksaStuView) view).deleteTablerow(row);// 삭제 요청한 해당 로우 삭제
					// 해당 교번에 해당하는 학생/교수를 삭제.
				}
			} else if (e.getSource().equals(((HaksaStuView) this.view).getReturnBtn())) {
				ViewChange(new HaksaMainView());
			}

		}

		else if (this.view instanceof HaksaInsertView) { // 학사 추가 뷰일때
			if (e.getSource().equals(((HaksaInsertView) this.view).getRegisterBtn())) {
				String dept = ((HaksaInsertView) this.view).getDeptCombo().getSelectedItem().toString(); // 선택한 dept 선택
				String firstJumin = ((HaksaInsertView) this.view).getFirstJumin();
				String lastJumin = ((HaksaInsertView) this.view).getLastJumin();
				String jumin = firstJumin + "-" + lastJumin;

				if (!((HaksaInsertView) this.view).getNum().equals("")
						&& !((HaksaInsertView) this.view).getName().equals("")
						&& !((HaksaInsertView) this.view).getFirstJumin().equals("")
						&& !((HaksaInsertView) this.view).getLastJumin().equals("")) {

					if (((HaksaModel) model).setHaksaInfo(((HaksaInsertView) this.view).getNum(),
							((HaksaInsertView) this.view).getName(), dept, jumin)) { // 정보추가 성공시=
						((HaksaInsertView) this.view).okAlarm(); // 추가 실패 알람

					} else {
						((HaksaInsertView) this.view).confirmAlarm(); // 추가 실패 알람
					}
				} else {
					((HaksaInsertView) this.view).valueAlarm(); // 값문제 알ㄹ
				}
			}
		}

		else if (this.view instanceof HaksaModifyView) { // 학사 관리 수정페이지일때
			if (e.getSource().equals(((HaksaModifyView) this.view).getRegisterBtn())) {
				String dept = (String) ((HaksaModifyView) this.view).getDeptCombo().getSelectedItem().toString();
				String name = ((HaksaModifyView) this.view).getName().toString();
				String firstJumin = ((HaksaModifyView) this.view).getFirstJumin();
				String lastJumin = ((HaksaModifyView) this.view).getLastJumin();
				String jumin = firstJumin + "-" + lastJumin;

				if (!((HaksaModifyView) this.view).getNum().equals("")
						&& !((HaksaModifyView) this.view).getName().equals("")
						&& !((HaksaModifyView) this.view).getFirstJumin().equals("")
						&& !((HaksaModifyView) this.view).getFirstJumin().equals("")) {

					// 모델에 학사 정보변경을 요청
					int error = ((HaksaModel) model).changeHaksaInfo(((HaksaModifyView) this.view).getNum(), name, dept,
							jumin);
					if (error == 1) {
						((HaksaModifyView) view).OkAlarm();
					} else {
						((HaksaModifyView) view).NoAlarm();
					}

					if (((HaksaModel) model).getUser().equals("student")) {
						ViewChange(new HaksaStuView());
					} else if (((HaksaModel) model).getUser().equals("professor")) {
						ViewChange(new HaksaProfView());
					}
					// 요청 처리후 다시 학사 메인

				} else {
					((HaksaModifyView) this.view).valueAlarm();
				}

			} else if (e.getSource().equals(((HaksaModifyView) this.view).getCancelBtn())) {
				ViewChange(new HaksaProfView());

			}
		}

		else if (this.view instanceof CSMainView) { // 수업 담당자의 메인 뷰일때
			if (e.getSource().equals(((CSMainView) view).getLogOutBtn())) { // 수메인) 메인 뷰- 로그아웃 버튼이라면
				ViewChange(new LoginView());
				ModelChange(new LoginModel());
			} else if (e.getSource().equals(((CSMainView) view).getCourseBtn())) { // 수업담당메인 ) 강의 관리 버튼이라면
				ModelChange(new LectureMainModel());
				ViewChange(new LectureMainView());

			} else if (e.getSource().equals(((CSMainView) view).getPaymentBtn())) { // 수업담당메인) 수강료 청구서 발급 버튼이라면
				ViewChange(new CSmanagerPaymentView());
				ModelChange(new CSmanagerPaymentModel());

			}

			else if (e.getSource().equals(((CSMainView) view).getChangePwBtn())) { // 수업담당메인) 암호변경 버튼이라면
				ViewChange(new ChangePasswordView());
				ModelChange(new LoginModel());
			}
		}

		else if (this.view instanceof LectureMainView) {// 수업관리 메인 프레임에서 버튼이 클릭
			if (e.getSource().equals(((LectureMainView) view).getRegister())) { // 강의 등록 버튼 클릭
				ViewChange(new LectureRegisterView());
				((LectureRegisterView) view).setName(((LectureMainModel) model).getProfessorRow()); // 교수 정보 불러오기
				((LectureRegisterView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());// 테이블

			} else if (e.getSource().equals(((LectureMainView) view).getNew_register())) { // 새로운 강좌 등록 버튼 클릭
				ViewChange(new LectureNewView());
				((LectureNewView) view).setName(((LectureMainModel) model).getProfessorRow()); // 교수 정보 불러오기
				((LectureNewView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());

			} else if (e.getSource().equals(((LectureMainView) view).getUpdate())) { // 강의 정보 변경 버튼 클릭
				ViewChange(new LectureUpdateView());

				((LectureUpdateView) view).setName(((LectureMainModel) model).getProfessorRow());
				((LectureUpdateView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());

			} else if (e.getSource().equals(((LectureMainView) view).getDelete())) { // 강좌 삭제 버튼 클릭
				ViewChange(new LectureDeleteView());
				((LectureDeleteView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());
			} else if (e.getSource().equals(((LectureMainView) view).getReturnBtn())) { // 돌아가기 버튼 클릭
				ViewChange(new CSMainView());
			}
		}

		else if (this.view instanceof LectureRegisterView) {// 수업관리자, 강의 등록
			if (e.getSource().equals(((LectureRegisterView) view).getOk())) { // 강의 등록 버튼 클릭
				int count = 0;
				String cno = ((LectureRegisterView) view).getSelectCNO();
				String pname = ((LectureRegisterView) view).getSelectProf();
				String cmax = ((LectureRegisterView) view).getMaxNum().getText();
				String cmin = ((LectureRegisterView) view).getMinNum().getText();

				if (cmax.equals("")) {
					System.out.println("수강 최대 인원이 입력되지 않았습니다.");
					count++;
				}
				if (cmin.equals("")) {
					System.out.println("수강 최소 인원이 입력되지 않았습니다.");
					count++;
				}
				if (cno.equals("")) {
					System.out.println("강좌 번호가 입력되지 않았습니다.");// 정보가 입력되지 않았을 때 알린다.
					count++;
				}
				if (pname.equals("")) {
					System.out.println("교수가 입력되지 않았습니다.");
					count++;
				}
				if (!cmin.equals("") && !cmax.equals("") && Integer.parseInt(cmin) > Integer.parseInt(cmax)) {
					System.out.println("수강 신청 인원의 입력이 잘못되었습니다.");
					count++;
				}

				if (count == 0) {
					((LectureMainModel) model).register(cno, pname, cmax, cmin);
				}
			}
			else if (e.getSource().equals(((LectureRegisterView) view).getReturnBtn())) { // 돌아가기
				ViewChange(new LectureMainView());
			}
		
		} 

		else if (this.view instanceof LectureNewView) {// 수업관리자 새강좌 등록
			if (e.getSource().equals(((LectureNewView) view).getOk())) { // 새 강좌 등록 버튼 클릭
				int count = 0;
				String cno = ((LectureNewView) view).getCourseNum();
				String cname = ((LectureNewView) view).getCourseName();
				String cdept = ((LectureNewView) view).getDept();
				String cgrade = ((LectureNewView) view).getGrade();
				String cinfo = ((LectureNewView) view).getInfo();
				String pname = ((LectureNewView) view).getSelectProf();

				if (cname.equals("") || cno.equals("") || cdept.equals("") || cgrade.equals("") || cinfo.equals("")
						|| pname.equals("")) {

				} else {
					((LectureMainModel) model).newRegister(cno, cname, cdept, cgrade, cinfo, pname);
					((LectureNewView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());
				}
			} else if (e.getSource().equals(((LectureNewView) view).getReturnBtn())) { // 돌아가기
				ViewChange(new LectureMainView());

			}
		} else if (this.view instanceof LectureUpdateView) {// 수업관리 강좌 수정
			if (e.getSource().equals(((LectureUpdateView) view).getOk())) { // 강좌 수정 버튼 클릭
				int count = 0;
				String cno = ((LectureUpdateView) view).getSelectCNO();
				String cdept = ((LectureUpdateView) view).getDept();
				String pname = ((LectureUpdateView) view).getSelectProf();
				String cinfo = ((LectureUpdateView) view).getLecInfo();
				String cname = ((LectureUpdateView) view).getLecName();
				String cgrade = ((LectureUpdateView) view).getGradeNum();

				if (cno.equals("") || cdept.equals("") || pname.equals("") || cinfo.equals("") || cname.equals("")
						|| cgrade.equals("")) {
					// 빈칸이 있습니다 에러메세지
				} else {
					((LectureMainModel) model).update(cno, cname, cdept, pname, cgrade, cinfo);
					((LectureUpdateView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());
				}
			} else if (e.getSource().equals(((LectureUpdateView) view).getReturnBtn())) { // 돌아가기
				ViewChange(new LectureMainView());

			}
		} else if (this.view instanceof LectureDeleteView) {// 수업 관리자 강좌 삭제
			if (e.getSource().equals(((LectureDeleteView) view).getOk())) { // 강좌 삭제 버튼 클릭
				String cno = ((LectureDeleteView) view).getSelectCNO();
				((LectureMainModel) model).delete(cno);
				((LectureDeleteView) view).setAllCourseRowList(((LectureMainModel) model).getAllCourseRow());

			} else if (e.getSource().equals(((LectureDeleteView) view).getReturnBtn())) { // 돌아가기
				ViewChange(new LectureMainView());

			}
		}

		else if (this.view instanceof CSmanagerPaymentView) { // 수업 담당자의 수강료 청구서 발급 기능일때
			if (e.getSource().equals(((CSmanagerPaymentView) view).getReturnBtn())) {
				ViewChange(new CSMainView());
			} else if (e.getSource().equals(((CSmanagerPaymentView) view).getPaymentButton())) { // 청구서 발급 버튼
			} else if (e.getSource().equals(((CSmanagerPaymentView) view).getRefreshListBtn())) { // 학생 목록 불러오기 버튼
				((CSmanagerPaymentModel) model).getStudentList();

			}
		}

		else if (this.view instanceof ChangePasswordView) { // 암호변경 뷰일때
			if (e.getSource().equals(((ChangePasswordView) view).getChangeBtn())) { // 패스워드 변경 버튼이 클릭되었다면
				String npw = new String(((ChangePasswordView) view).getNewpw().getPassword());
				String conpw = new String(((ChangePasswordView) view).getConfirmpw().getPassword());
				boolean pwCheck = Pattern.matches(pwPattern, npw);

				if (!npw.isEmpty() && !conpw.isEmpty()) { 
					if (pwCheck == true) { // 비밀번호 제약조건 확인.
						if (npw.equals(conpw)) {
							if (((LoginModel) model).changePW(npw)) { 
								((ChangePasswordView) view).okMessage(); // 비밀번호 변경성공
								ViewChange(new LoginView());
							}
						} else {
							((ChangePasswordView) view).ckMessage(); //두 비밀번호가 다를 시 에러메세지
						}
					} else {
						((ChangePasswordView) view).pwMessage(); //암호 조건에 맞지 않을 시 에러메세지
					}
				} else {
					((ChangePasswordView) view).emptyMessage(); //빈 칸이 있을 시 에러메세지
				}

			} else if (e.getSource().equals(((ChangePasswordView) view).getReturnBtn())) { // 돌아가기 버튼일때
				ViewChange(new LoginView());
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.view instanceof ProfRankInsertView) { // 교수 수강 관리 뷰일때 리스너
			if (e.getSource().equals(((ProfRankInsertView) view).getMyCourseList())) {// 교수의 수강관리에서 자신 강좌리스트에서 강좌 클릭시
																						// (학생 명단 띄운다)
				JTable courseTable = ((ProfRankInsertView) view).getMyCourseList(); // 선택된 뷰의 테이블
				TableModel rowmodel = courseTable.getModel(); // 현재마우스로 선택된 테이블의 행 모델을 가져온다~(데이터 가져오기)
				int row = courseTable.getSelectedRow();
				String coursenum = (String) rowmodel.getValueAt(row, 0); // String 형의 강좌번호 반환.

				((ProfRankInsertView) view).setFocusCoStuList(((ProfRankInsertModel) this.model).getStuList(coursenum));
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (view instanceof LectureRegisterView) {
			if (e.getSource().equals(((LectureRegisterView) view).getLecTable())) {
				int row = ((LectureRegisterView) view).getLecTable().getSelectedRow(); // 행 선택
				String str = (String) ((LectureRegisterView) view).getLecTable().getValueAt(row, 0);
				((LectureRegisterView) view).setSelectCNO(str);
			} else if (e.getSource().equals(((LectureRegisterView) view).getProf())) {
				String str = (String) ((LectureRegisterView) view).getProf().getSelectedValue();
				((LectureRegisterView) view).setSelectProf(str);

			}
		} else if (view instanceof LectureUpdateView) {
			if (e.getSource().equals(((LectureUpdateView) view).getLecTable())) {
				int row = ((LectureUpdateView) view).getLecTable().getSelectedRow(); // 행 선택
				String str = (String) ((LectureUpdateView) view).getLecTable().getValueAt(row, 0);
				((LectureUpdateView) view).setSelectCNO(str);
			} else if (e.getSource().equals(((LectureUpdateView) view).getProf())) {
				String str = (String) ((LectureUpdateView) view).getProf().getSelectedValue();
				((LectureUpdateView) view).setSelectProf(str);

			}
		} else if (view instanceof LectureNewView) {
			if (e.getSource().equals(((LectureNewView) view).getProf())) {
				String str = (String) ((LectureNewView) view).getProf().getSelectedValue();
				((LectureNewView) view).setSelectProf(str);
			}
		} else if (view instanceof LectureDeleteView) {
			if (e.getSource().equals(((LectureDeleteView) view).getLecTable())) {
				int row = ((LectureDeleteView) view).getLecTable().getSelectedRow(); // 행 선택
				String str = (String) ((LectureDeleteView) view).getLecTable().getValueAt(row, 0);
				((LectureDeleteView) view).setSelectCNO(str);
			}
		} else if (view instanceof CSmanagerPaymentView) {
			if (e.getSource().equals(((CSmanagerPaymentView) view).getStuTable())) { // 수강료 청구서 발급에ㅐ서 선택된 행
			}
		}
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
