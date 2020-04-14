package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVo;
@Repository
public class BoardDAOimple implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	//게시글 작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVo);
		
	}
	//게시글 목록
	@Override
	public List<BoardVo> list() throws Exception {
		 
		return sqlSession.selectList("boardMapper.list");
	}
	//게시글 조회
	@Override
	public BoardVo read(int bno) throws Exception {
		
		 return sqlSession.selectOne("boardMapper.read" ,bno);
	}
	//게시글 수정
	@Override
	public void update(BoardVo boardVo) throws Exception {
		
		sqlSession.update("boardMapper.update", boardVo);
		
	}
	//게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("boardMapper.delete", bno);
	}
	
}
