package test.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeDto;
import test.mybatis.SqlMapConfig;

public class CafeDao {
	private static CafeDao dao;
	private static SqlSessionFactory factory;
	private CafeDao() {}
	
	//자신의 참조값을 리턴해주는 메소드
	public static CafeDao getInstance() {
		if(dao==null) {
			dao=new CafeDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//새글을 저장하는 메소드
	public boolean insert(CafeDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("cafe.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//글의 갯수를 리턴하는 메소드 
	public int getCount() {
		SqlSession session=null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("cafe.getCount");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}
	
	//글목록을 리턴하는 메소드
	public List<CafeDto> getList(CafeDto dto){
		SqlSession session=null;
		List<CafeDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  페이징 처리를 염두에둔 CafeMapper.xml 을 작성해 보세요.
			 */
			list=session.selectList("cafe.getList", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	//글 하나의 정보를 리턴하는 메소드 
	public CafeDto getData(int num) {
		SqlSession session=null;
		CafeDto dto=null;
		try {
			session=factory.openSession();
			dto=session.selectOne("cafe.getData", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	//글정보를 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("cafe.delete", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//글정보 수정하는 메소드 
	public boolean update(CafeDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafe.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//조회수를 증가 시키는 메소드
	public void addViewCount(int num) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.update("cafe.addViewCount", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}


















