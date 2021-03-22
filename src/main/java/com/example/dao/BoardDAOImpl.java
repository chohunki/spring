package com.example.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.BoardVO;
import com.example.dto.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.example.mapper.boardMapper";  //매퍼의 네임스페이스와 이름이 같아야 한다.
	
	@Override
	public List<BoardVO> selectMember() throws Exception {

		return sqlSession.selectList(Namespace+".selectMember");  //Namespace 뒤에 오는 이름은 매퍼의 select id와 같아야한다.
	}

	@Override
	public BoardVO view(int idx) throws Exception {
	
		return sqlSession.selectOne(Namespace + ".view",idx);
	}

	@Override
	public void delete(int idx) throws Exception {
		sqlSession.delete(Namespace + ".delete",idx);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		sqlSession.update(Namespace + ".modify", vo);
		
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		sqlSession.insert(Namespace + ".write", vo);
	}

	@Override
	public void count(int idx) throws Exception {
		sqlSession.update(Namespace + ".count", idx);
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".countBoard");
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".selectBoard", vo);
	}



}
