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
		//2. CafeDao 를 이용해서 글정보를 읽어와서
		CafeDto dto=CafeDao.getInstance().getData(num);
		// 글 조회수 올리기
		CafeDao.getInstance().addViewCount(num);
	
		//3. request 에 담고
		request.setAttribute("dto", dto);
		//4. view 페이지로 forward 이동해서 응답 
		return new ActionForward("/views/cafe/detail.jsp");
	}

}








