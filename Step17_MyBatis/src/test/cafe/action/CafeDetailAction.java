package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  글 자세히 보기 요청 처리 
 */
public class CafeDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 글번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");		
		
		//CafeDto 객체를 생성해서 
		CafeDto dto=new CafeDto();
		if(keyword != null) {//검색어가 전달된 경우 
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//list.jsp 에서 필요한 내용 담기
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}		
		//글번호도 dto 에 담는다.
		dto.setNum(num);
		
		//2. CafeDao 를 이용해서 글정보를 읽어와서
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		// 글 조회수 올리기
		CafeDao.getInstance().addViewCount(num);
	
		//3. request 에 담고
		request.setAttribute("dto", resultDto);
		//로그인 여부 확인해서  request 에 담기 
		String id=(String)request.getSession().getAttribute("id");
		boolean isLogin=false;
		if(id!=null) {
			isLogin=true;
		}
		request.setAttribute("isLogin", isLogin);
		
		//4. view 페이지로 forward 이동해서 응답 
		return new ActionForward("/views/cafe/detail.jsp");
	}

}








