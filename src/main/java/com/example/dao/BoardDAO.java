package com.example.dao;

import java.util.List;

import com.example.dto.BoardVO;
import com.example.dto.PagingVO;

public interface BoardDAO {
	
	public List<BoardVO> selectMember() throws Exception;
	public BoardVO view(int idx) throws Exception;
	public void delete(int idx) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void write(BoardVO vo) throws Exception;
	public void count(int idx) throws Exception;
	// 게시물 총 갯수
	public int countBoard();
	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO vo);
}
