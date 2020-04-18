package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.mapper.BoardMapper;
import kr.co.vo.BoardVo;
import kr.co.vo.Criteria;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



@Service
@AllArgsConstructor
public class BoardServiceimple implements BoardService {

		//spring 4.3 이상에서 자동처리
		private BoardMapper mapper;
	@Override
	public void register(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(boardVo);
		
	}

	/*
	 * @Override public List<BoardVo> getList() throws Exception { // TODO
	 * Auto-generated method stub return mapper.getList(); }
	 */

	@Override
	public BoardVo get(Long bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo boardVo) throws Exception {
		return mapper.update(boardVo)==1;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public boolean remove(Long bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVo> getList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		//log.info("get List with criteria :"+cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	
		
	

	
}
