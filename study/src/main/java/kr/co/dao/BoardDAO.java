package kr.co.dao;



import java.util.List;

import kr.co.vo.BoardVo;

public interface BoardDAO {

		public void write(BoardVo boardVo)throws Exception;
		
		public List<BoardVo> list() throws Exception;
		
		public BoardVo read(int bno)throws Exception;
		
		public void update(BoardVo boardVo)throws Exception;
		
		public void delete(int bno)throws Exception;
}
