package kr.co.service;

import java.util.List;

import kr.co.vo.BoardVo;
import kr.co.vo.Criteria;

public interface BoardService {

	public void register(BoardVo boardVo)throws Exception;
	
	//public List<BoardVo> getList() throws Exception;
	
	public List<BoardVo> getList(Criteria cri)throws Exception;
	
	public BoardVo get(Long bno)throws Exception;
	
	public boolean modify(BoardVo boardVo)throws Exception;
	
	public boolean remove(Long bno)throws Exception;
	
	public int getTotal(Criteria cri);
}
