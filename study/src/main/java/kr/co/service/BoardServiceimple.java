package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVo;
@Service
public class BoardServiceimple implements BoardService {

	@Inject
	private BoardDAO dao;
	

	@Override
	public void write(BoardVo boardVo) throws Exception {
		dao.write(boardVo);
	}


	@Override
	public List<BoardVo> list() throws Exception {
		
			return dao.list();
		
	}


	@Override
	public BoardVo read(int bno) throws Exception {
		
		return dao.read(bno);
	}


	@Override
	public void update(BoardVo boardVo) throws Exception {
			
		dao.update(boardVo);
		
	}


	@Override
	public void delete(int bno) throws Exception {
			
		dao.delete(bno);
		
	}

	
}
