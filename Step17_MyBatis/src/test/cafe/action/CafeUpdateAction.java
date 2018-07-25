package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수정할 글정보 얻어오기 
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//CafeDto 에 담기
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		//CafeDao 를 이용해서 수정 반영
		boolean isSuccess=CafeDao.getInstance().update(dto);
		//request 에 결과 담고 
		request.setAttribute("isSuccess", isSuccess);
		//응답
		return new ActionForward("/views/cafe/update.jsp");
	}

}











