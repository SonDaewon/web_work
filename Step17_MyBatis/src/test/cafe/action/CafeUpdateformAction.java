package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  글 수정 폼을 출력해주는 액션
 */
public class CafeUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 수정할 글번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		//글번호를 CafeDto 객체에 담아서 
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		//2. 수정할 글정보 얻어오기
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		//3. request 에 담고
		request.setAttribute("dto", resultDto);
		//4. 응답하기 
		return new ActionForward("/views/cafe/updateform.jsp");
	}

}









